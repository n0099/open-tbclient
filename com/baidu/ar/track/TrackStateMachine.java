package com.baidu.ar.track;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import com.baidu.ar.base.MsgField;
import com.baidu.ar.base.d;
import com.baidu.ar.imu.b;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.baiduarsdk.ArBridge;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class TrackStateMachine {
    private static volatile TrackStateMachine a;
    private static STATE e = STATE.INITIAL_STATE;
    private Handler f;
    private b g;
    private long i;
    private long j;
    private STATE b = STATE.INITIAL_STATE;
    private STATE c = STATE.INITIAL_STATE;
    private STATE d = STATE.INITIAL_STATE;
    private int h = 0;

    /* loaded from: classes3.dex */
    public enum EVENT {
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        TRACK_SUCCESS,
        TRACK_FAILED,
        TRACK_IMU_OPEN,
        TRACK_IMU_CLOSE,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_START,
        LOAD_MODEL_FINISH,
        OPEN_TRACK_ALGO,
        CLOSE_TRACK_ALGO
    }

    /* loaded from: classes3.dex */
    public enum STATE {
        INITIAL_STATE,
        TRACK_START,
        MODEL_SHOWING,
        MODEL_NOT_SHOWING,
        MODEL_LOADING,
        MODEL_LOAD_FINISH,
        TRACKED,
        NOT_TRACKED,
        RESUME,
        PAUSE,
        DESTROY
    }

    private TrackStateMachine() {
    }

    private void a(int i) {
        if (this.f != null) {
            this.f.sendEmptyMessage(i);
        }
    }

    private void a(int i, long j) {
        if (this.f != null) {
            this.f.sendEmptyMessageDelayed(i, j);
        }
    }

    private void a(int i, Bundle bundle) {
        if (this.f != null) {
            Message obtainMessage = this.f.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.setData(bundle);
            this.f.sendMessage(obtainMessage);
        }
    }

    private void a(Message message) {
        if (this.f != null) {
            this.f.sendMessage(message);
        }
    }

    private void a(STATE state) {
        this.b = state;
    }

    private void b(STATE state) {
        this.c = state;
    }

    public static void destroy() {
        getInstance().f = null;
        a = null;
    }

    public static TrackStateMachine getInstance() {
        if (a == null) {
            synchronized (TrackStateMachine.class) {
                if (a == null) {
                    a = new TrackStateMachine();
                }
            }
        }
        return a;
    }

    public static void setAppState(STATE state) {
        e = state;
    }

    public STATE getTrackState() {
        return this.d;
    }

    public void init() {
        setAppState(STATE.INITIAL_STATE);
        this.b = STATE.INITIAL_STATE;
        this.c = STATE.INITIAL_STATE;
        this.d = STATE.INITIAL_STATE;
    }

    public synchronized void processEvent(EVENT event) {
        processEvent(event, null);
    }

    public synchronized void processEvent(EVENT event, Bundle bundle) {
        ARLog.d("event=" + event + ", state=" + this.b + ", BgState=" + this.c + ", AppState=" + e + ", TrackState=" + this.d);
        if (e != STATE.DESTROY) {
            switch (event) {
                case DOWNLOAD_RES_FINISH:
                case LOAD_MODEL_START:
                    if (this.c != STATE.MODEL_LOAD_FINISH) {
                        if (this.b != STATE.TRACK_START) {
                            this.i = System.currentTimeMillis();
                            ARLog.d("[TrackStateMachine]loadModelStart=" + this.i);
                            a(STATE.TRACK_START);
                            b(STATE.MODEL_LOADING);
                            break;
                        } else if (this.c == STATE.MODEL_LOAD_FINISH) {
                            a(307);
                            break;
                        }
                    } else {
                        switch (this.b) {
                            case TRACK_START:
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("show_immediately", this.h);
                                if (this.f != null) {
                                    Message obtainMessage = this.f.obtainMessage();
                                    obtainMessage.what = MsgConstants.TRACK_MODEL_CAN_DISAPPEARING;
                                    obtainMessage.setData(bundle2);
                                    a(obtainMessage);
                                    break;
                                }
                                break;
                            case MODEL_NOT_SHOWING:
                                a(307);
                                break;
                            case MODEL_SHOWING:
                                a(MsgConstants.TRACK_MODEL_SHOWING);
                                break;
                        }
                        a(MsgConstants.TRACK_SHOW_CAPTURE);
                        break;
                    }
                    break;
                case LOAD_MODEL_FINISH:
                    this.j = System.currentTimeMillis();
                    ARLog.d("[TrackStateMachine]loadModelEnd=" + this.j + ",cost:" + (this.j - this.i));
                    if (this.c == STATE.MODEL_LOADING) {
                        com.baidu.ar.msghandler.a.a(OrientationManager.getGlobalOrientation().getDegree());
                        a(301);
                        Message obtain = Message.obtain();
                        obtain.what = MsgConstants.TRACK_MODEL_CAN_DISAPPEARING;
                        obtain.setData(bundle);
                        if (this.d == STATE.INITIAL_STATE) {
                            a(obtain);
                        } else if (this.d == STATE.NOT_TRACKED) {
                            a(obtain);
                            ArBridge.getInstance().sendMessage(102, null);
                        } else if (this.d == STATE.TRACKED) {
                            ArBridge.getInstance().sendMessage(101, null);
                        }
                        if (bundle != null) {
                            this.h = bundle.getInt("show_immediately");
                        }
                        b(STATE.MODEL_LOAD_FINISH);
                        break;
                    }
                    break;
                case TRACK_SUCCESS:
                    this.d = STATE.TRACKED;
                    if (this.c == STATE.MODEL_LOAD_FINISH) {
                        ArBridge.getInstance().sendMessage(101, null);
                        break;
                    }
                    break;
                case TRACK_FAILED:
                    this.d = STATE.NOT_TRACKED;
                    if (this.c == STATE.MODEL_LOAD_FINISH) {
                        ArBridge.getInstance().sendMessage(102, null);
                        a(MsgConstants.TRACK_MSG_ID_TRACK_LOST);
                        d.a((int) MsgField.IMSG_TRACK_LOST, MsgField.SMSG_TRACK_LOST);
                        break;
                    }
                    break;
                case TRACK_IMU_OPEN:
                    HashMap<String, Object> hashMap = new HashMap<>();
                    try {
                        this.g.a(bundle);
                        if (this.g.a(bundle.getInt("type"))) {
                            hashMap.put("succeeded", 1);
                        } else {
                            hashMap.put("succeeded", 0);
                        }
                        ArBridge.getInstance().sendMessage(302, hashMap);
                        a(MsgConstants.TRACK_IMU_OPEN, bundle);
                        break;
                    } catch (NullPointerException e2) {
                        ARLog.w("bdar:has NullPointerException!!!");
                        break;
                    }
                case TRACK_IMU_CLOSE:
                    if (this.g != null) {
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        hashMap2.put("succeeded", 1);
                        this.g.a();
                        ArBridge.getInstance().sendMessage(304, hashMap2);
                        break;
                    }
                    break;
                case MODEL_APPEAR:
                    Log.e("bdar", "model appear");
                    d.a((int) MsgField.IMSG_TRACK_MODEL_APPEAR, " track model disapper!");
                    if (this.f != null && this.f.hasMessages(307)) {
                        this.f.removeMessages(307);
                    }
                    a(MsgConstants.TRACK_MODEL_SHOWING);
                    a(STATE.MODEL_SHOWING);
                    break;
                case MODEL_DISAPPEAR:
                    Log.e("bdar", "model disapear");
                    a(307, 100L);
                    a(STATE.MODEL_NOT_SHOWING);
                    break;
                case OPEN_TRACK_ALGO:
                    a(MsgConstants.TRACK_OPEN_TRACK_ALGO);
                    break;
                case CLOSE_TRACK_ALGO:
                    a(MsgConstants.TRACK_CLOSE_TRACK_ALGO);
                    break;
            }
        }
    }

    public synchronized void processRMatrix(Bundle bundle) {
        float[] floatArray;
        if (this.c == STATE.MODEL_LOAD_FINISH && (floatArray = bundle.getFloatArray("RMatrix")) != null) {
            ArBridge.getInstance().updateRMatrix(floatArray);
        }
    }

    public synchronized void processRtMatrix(Bundle bundle) {
        if (e != STATE.PAUSE && e != STATE.DESTROY && this.c == STATE.MODEL_LOAD_FINISH) {
            ARLog.d("bdar: processRtMatrix isTracked = " + bundle.getBoolean("isTracked"));
            if (bundle != null) {
                float[] floatArray = bundle.getFloatArray("RTMatrix");
                if (this.d == STATE.TRACKED && floatArray != null) {
                    ArBridge.getInstance().updateRTMatrix(floatArray);
                    Message message = new Message();
                    message.what = 302;
                    message.setData(bundle);
                    a(message);
                    if (ArBridge.getInstance().getArGLEngineCtl() != null) {
                        int e2 = ArBridge.getInstance().getArGLEngineCtl().e();
                        if (bundle.getInt("averageTime") <= 40) {
                            if (e2 != 0) {
                                ArBridge.getInstance().getArGLEngineCtl().a(0);
                            }
                            ArBridge.getInstance().getArGLEngineCtl().b();
                        } else if (e2 != 1) {
                            ArBridge.getInstance().getArGLEngineCtl().a(1);
                        }
                    }
                } else if (ArBridge.getInstance().getArGLEngineCtl() != null && ArBridge.getInstance().getArGLEngineCtl().e() != 1) {
                    ArBridge.getInstance().getArGLEngineCtl().a(1);
                }
            }
        }
    }

    public void setIMUController(b bVar) {
        this.g = bVar;
    }

    public void setMainThreadHandler(Handler handler) {
        this.f = handler;
    }
}
