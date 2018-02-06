package com.baidu.ar.slam;

import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.ar.d.b;
import com.baidu.ar.util.Constants;
import com.baidu.ar.util.o;
import com.baidu.baiduarsdk.ArBridge;
import java.util.HashMap;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class SlamStateMachine {
    private static volatile SlamStateMachine b;
    private static STATE f = STATE.INITIAL_STATE;
    private Handler h;
    private b i;
    private STATE c = STATE.INITIAL_STATE;
    private STATE d = STATE.INITIAL_STATE;
    private STATE e = STATE.INITIAL_STATE;
    private STATE g = STATE.INITIAL_STATE;
    boolean a = false;

    /* loaded from: classes3.dex */
    public enum EVENT {
        QUERY_RES_START,
        QUERY_RES_SUCCESS,
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        UPDATE_RT_MATRIX,
        SLAM_TRACK_SUCCESS,
        SLAM_TRACK_FAILED,
        SLAM_TRACK_QUALITY,
        SLAM_PLANE_LEVEL,
        SLAM_IMU_OPEN,
        SLAM_IMU_CLOSE,
        SLAM_ALIGN_PLANE,
        SLAM_ELEVATION_ANGLE_BIG,
        SLAM_ELEVATION_ANGLE_NORMAL,
        QUERY_RES_FAILED,
        DOWNLOAD_RES_START,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_START,
        LOAD_MODEL_FINISH,
        OPEN_INTERNAL_BROWSER,
        VIDEO_RECORD_START,
        VIDEO_RECORD_STOP_AND_SAVE_FINISH,
        VIDEO_RECORD_STOP_AND_ABANDON,
        VIDEO_PREVIEW_IMAGE_CAPTURE_FINISH
    }

    /* loaded from: classes3.dex */
    public enum STATE {
        INITIAL_STATE,
        RES_QUERYING,
        RES_DOWNLOADING,
        SLAM_START,
        MODEL_SHOWING,
        MODEL_NOT_SHOWING,
        MODEL_LOADING,
        MODEL_LOAD_FINISH,
        TRACKED,
        NOT_TRACKED,
        RESUME,
        PAUSE,
        DESTROY,
        VIDEO_RECORD_FINISH,
        VIDEO_RECORD_ABANDON,
        VIDEO_CAPTURE_IMAGE_FINISH,
        VIDEO_RECORD_COMPLETE
    }

    private SlamStateMachine() {
    }

    public static SlamStateMachine a() {
        if (b == null) {
            synchronized (SlamStateMachine.class) {
                if (b == null) {
                    b = new SlamStateMachine();
                }
            }
        }
        return b;
    }

    private void a(int i) {
        if (this.h != null) {
            this.h.sendEmptyMessage(i);
        }
    }

    private void a(int i, long j) {
        if (this.h != null) {
            this.h.sendEmptyMessageDelayed(i, j);
        }
    }

    private void a(Message message) {
        if (this.h != null) {
            this.h.sendMessage(message);
        }
    }

    public static void a(STATE state) {
        f = state;
    }

    private void b(STATE state) {
        this.c = state;
    }

    private void c(STATE state) {
        this.d = state;
    }

    public static void d() {
        a().h = null;
        b = null;
    }

    public synchronized void a(Bundle bundle) {
        ArBridge.getInstance().updateSLAMMatrix(bundle.getFloatArray(com.baidu.ar.a.a.b.e));
        int renderMode = ArBridge.getInstance().getRenderMode();
        int i = bundle.getInt("average_time");
        com.baidu.ar.util.b.a("bdar:averageTrackingTime = " + i);
        if (i <= 40) {
            if (renderMode != 0) {
                ArBridge.getInstance().setRenderMode(0);
            }
            ArBridge.getInstance().requestRenderer();
        } else if (renderMode != 1) {
            ArBridge.getInstance().setRenderMode(1);
        }
    }

    public void a(Handler handler) {
        this.h = handler;
    }

    public void a(b bVar) {
        this.i = bVar;
    }

    public synchronized void a(EVENT event) {
        a(event, (Bundle) null);
    }

    public synchronized void a(EVENT event, Bundle bundle) {
        if (f != STATE.DESTROY) {
            switch (event) {
                case QUERY_RES_START:
                    if (this.d != STATE.MODEL_LOAD_FINISH) {
                        if (this.c != STATE.INITIAL_STATE && this.c != STATE.RES_QUERYING) {
                            if (this.c != STATE.RES_DOWNLOADING) {
                                a(HttpStatus.SC_INSUFFICIENT_STORAGE);
                                break;
                            } else {
                                a(500);
                                break;
                            }
                        } else {
                            a(508);
                            b(STATE.RES_QUERYING);
                            break;
                        }
                    } else {
                        com.baidu.ar.util.b.a("mCurrentState " + this.c);
                        switch (this.c) {
                            case SLAM_START:
                                a(512);
                                break;
                            case MODEL_NOT_SHOWING:
                                a(HttpStatus.SC_INSUFFICIENT_STORAGE);
                                break;
                            case MODEL_SHOWING:
                                a(506);
                                break;
                        }
                    }
                case QUERY_RES_SUCCESS:
                    com.baidu.ar.util.b.a("QUERY_RES_SUCCESS ");
                    a(500);
                    b(STATE.RES_DOWNLOADING);
                    break;
                case QUERY_RES_FAILED:
                    com.baidu.ar.util.b.a("QUERY_RES_FAILED ");
                    a(523);
                    break;
                case DOWNLOAD_RES_FINISH:
                    com.baidu.ar.util.b.a("DOWNLOAD_RES_FINISH ");
                    b(STATE.SLAM_START);
                    c(STATE.MODEL_LOADING);
                    break;
                case LOAD_MODEL_FINISH:
                    com.baidu.ar.util.b.a("LOAD_MODEL_FINISH ");
                    com.baidu.ar.c.a.b(o.a());
                    a(HttpStatus.SC_NOT_IMPLEMENTED);
                    if (this.e != STATE.TRACKED) {
                        a(512);
                    } else if (this.e == STATE.TRACKED) {
                        ArBridge.getInstance().sendMessage(101, null);
                    }
                    c(STATE.MODEL_LOAD_FINISH);
                    break;
                case UPDATE_RT_MATRIX:
                    b(event, bundle);
                    break;
                case SLAM_PLANE_LEVEL:
                    int i = bundle.getInt(Constants.SLAM_PLANE_LEVEL, Constants.SLAM_PLANE_ERROR);
                    if (i != Constants.SLAM_PLANE_ERROR) {
                        if (i != Constants.SLAM_PLANE_BAD) {
                            if (i != Constants.SLAM_PLANE_GOOD) {
                                if (i == Constants.SLAM_PLANE_PERFECT) {
                                    a(517);
                                    break;
                                }
                            } else {
                                a(516);
                                break;
                            }
                        } else {
                            a(515);
                            break;
                        }
                    } else {
                        a(514);
                        break;
                    }
                    break;
                case SLAM_TRACK_SUCCESS:
                    this.e = STATE.TRACKED;
                    ArBridge.getInstance().sendMessage(101, null);
                    a(HttpStatus.SC_BAD_GATEWAY);
                    break;
                case SLAM_TRACK_FAILED:
                    this.e = STATE.NOT_TRACKED;
                    ArBridge.getInstance().sendMessage(102, null);
                    a(510);
                    break;
                case SLAM_TRACK_QUALITY:
                    ArBridge.getInstance().sendMessage(102, null);
                    Message message = new Message();
                    message.what = 519;
                    message.setData(bundle);
                    a(message);
                    break;
                case SLAM_IMU_OPEN:
                    HashMap<String, Object> hashMap = new HashMap<>();
                    if (this.i.a(0)) {
                        hashMap.put("succeeded", 1);
                    } else {
                        hashMap.put("succeeded", 0);
                    }
                    ArBridge.getInstance().sendMessage(302, hashMap);
                    break;
                case SLAM_IMU_CLOSE:
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap2.put("succeeded", 1);
                    this.i.a();
                    ArBridge.getInstance().sendMessage(304, hashMap2);
                    break;
                case MODEL_APPEAR:
                    if (this.h != null && this.h.hasMessages(HttpStatus.SC_INSUFFICIENT_STORAGE)) {
                        this.h.removeMessages(HttpStatus.SC_INSUFFICIENT_STORAGE);
                    }
                    a(506);
                    b(STATE.MODEL_SHOWING);
                    break;
                case MODEL_DISAPPEAR:
                    a(HttpStatus.SC_INSUFFICIENT_STORAGE, 100L);
                    b(STATE.MODEL_NOT_SHOWING);
                    break;
                case SLAM_ALIGN_PLANE:
                    a(518);
                    break;
                case SLAM_ELEVATION_ANGLE_NORMAL:
                    a(521);
                    break;
                case SLAM_ELEVATION_ANGLE_BIG:
                    a(520);
                    break;
            }
        }
    }

    public synchronized void a(boolean z) {
        this.a = z;
    }

    public synchronized void b(EVENT event, Bundle bundle) {
        if (this.d == STATE.MODEL_LOAD_FINISH) {
            float[] floatArray = bundle.getFloatArray("RTMatrix");
            if (this.e == STATE.TRACKED && floatArray != null) {
                ArBridge.getInstance().updateRTMatrix(floatArray);
                Message message = new Message();
                message.what = 302;
                message.setData(bundle);
                a(message);
            }
        }
    }

    public void b(boolean z) {
        if (z) {
            ArBridge.getInstance().setModelVirtualColor(Color.parseColor("#ffffff88"), false);
        } else {
            ArBridge.getInstance().setModelVirtualColor(Color.parseColor("#ffffffff"), false);
        }
    }

    public float[] b() {
        return this.i.e();
    }

    public void c() {
        f = STATE.INITIAL_STATE;
        this.c = STATE.INITIAL_STATE;
        this.d = STATE.INITIAL_STATE;
        this.e = STATE.INITIAL_STATE;
        this.g = STATE.INITIAL_STATE;
    }

    public synchronized void c(EVENT event, Bundle bundle) {
        if (!this.a && this.d == STATE.MODEL_LOAD_FINISH && bundle.getFloatArray("RMatrix") != null) {
            ArBridge.getInstance().updateSLAMMatrix(this.i.d());
            Message message = new Message();
            message.what = 302;
            message.setData(bundle);
            a(message);
        }
    }

    public synchronized void d(EVENT event, Bundle bundle) {
        if (f != STATE.DESTROY) {
            switch (event) {
                case VIDEO_RECORD_START:
                    this.g = STATE.INITIAL_STATE;
                    break;
                case VIDEO_RECORD_STOP_AND_SAVE_FINISH:
                    if (this.g != STATE.INITIAL_STATE) {
                        if (this.g == STATE.VIDEO_CAPTURE_IMAGE_FINISH) {
                            a(602);
                            this.g = STATE.VIDEO_RECORD_COMPLETE;
                            break;
                        }
                    } else {
                        this.g = STATE.VIDEO_RECORD_FINISH;
                        break;
                    }
                    break;
                case VIDEO_RECORD_STOP_AND_ABANDON:
                    this.g = STATE.VIDEO_RECORD_ABANDON;
                    break;
                case VIDEO_PREVIEW_IMAGE_CAPTURE_FINISH:
                    if (this.g != STATE.INITIAL_STATE) {
                        if (this.g == STATE.VIDEO_RECORD_FINISH) {
                            a(602);
                            this.g = STATE.VIDEO_RECORD_COMPLETE;
                            break;
                        }
                    } else {
                        this.g = STATE.VIDEO_CAPTURE_IMAGE_FINISH;
                        break;
                    }
                    break;
            }
        }
    }
}
