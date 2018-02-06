package com.baidu.ar.track;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.ar.d.b;
import com.baidu.ar.util.o;
import com.baidu.baiduarsdk.ArBridge;
import java.util.HashMap;
import org.apache.http.HttpStatus;
/* loaded from: classes3.dex */
public class TrackStateMachine {
    private static volatile TrackStateMachine a;
    private static STATE e = STATE.INITIAL_STATE;
    private Handler g;
    private b h;
    private STATE b = STATE.INITIAL_STATE;
    private STATE c = STATE.INITIAL_STATE;
    private STATE d = STATE.INITIAL_STATE;
    private STATE f = STATE.INITIAL_STATE;
    private int i = 0;

    /* loaded from: classes3.dex */
    public enum EVENT {
        QUERY_RES_START,
        QUERY_RES_SUCCESS,
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        UPDATE_RT_MATRIX,
        TRACK_SUCCESS,
        TRACK_FAILED,
        TRACK_IMU_OPEN,
        TRACK_IMU_CLOSE,
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
        TRACK_START,
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

    private TrackStateMachine() {
    }

    public static TrackStateMachine a() {
        if (a == null) {
            synchronized (TrackStateMachine.class) {
                if (a == null) {
                    a = new TrackStateMachine();
                }
            }
        }
        return a;
    }

    private void a(int i) {
        if (this.g != null) {
            this.g.sendEmptyMessage(i);
        }
    }

    private void a(int i, long j) {
        if (this.g != null) {
            this.g.sendEmptyMessageDelayed(i, j);
        }
    }

    private void a(int i, Bundle bundle) {
        if (this.g != null) {
            Message obtainMessage = this.g.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.setData(bundle);
            this.g.sendMessage(obtainMessage);
        }
    }

    private void a(Message message) {
        if (this.g != null) {
            this.g.sendMessage(message);
        }
    }

    public static void a(STATE state) {
        e = state;
    }

    private void b(STATE state) {
        this.b = state;
    }

    private void c(STATE state) {
        this.c = state;
    }

    public static void d() {
        a().g = null;
        a = null;
    }

    public void a(Handler handler) {
        this.g = handler;
    }

    public void a(b bVar) {
        this.h = bVar;
    }

    public synchronized void a(EVENT event) {
        a(event, (Bundle) null);
    }

    public synchronized void a(EVENT event, Bundle bundle) {
        com.baidu.ar.util.b.a("event=" + event + ", state=" + this.b + ", BgState=" + this.c + ", AppState=" + e + ", TrackState=" + this.d);
        if (e != STATE.DESTROY) {
            switch (event) {
                case QUERY_RES_START:
                    if (this.c != STATE.MODEL_LOAD_FINISH) {
                        if (this.b != STATE.INITIAL_STATE && this.b != STATE.RES_QUERYING) {
                            if (this.b != STATE.RES_DOWNLOADING) {
                                a(HttpStatus.SC_TEMPORARY_REDIRECT);
                                break;
                            } else {
                                a(300);
                                break;
                            }
                        } else {
                            a(308);
                            b(STATE.RES_QUERYING);
                            break;
                        }
                    } else {
                        switch (this.b) {
                            case TRACK_START:
                                Bundle bundle2 = new Bundle();
                                bundle2.putInt("show_immediately", this.i);
                                if (this.g != null) {
                                    Message obtainMessage = this.g.obtainMessage();
                                    obtainMessage.what = 312;
                                    obtainMessage.setData(bundle2);
                                    a(obtainMessage);
                                    break;
                                }
                                break;
                            case MODEL_NOT_SHOWING:
                                a(HttpStatus.SC_TEMPORARY_REDIRECT);
                                break;
                            case MODEL_SHOWING:
                                a(306);
                                break;
                        }
                        a(314);
                        break;
                    }
                    break;
                case QUERY_RES_SUCCESS:
                    a(300);
                    b(STATE.RES_DOWNLOADING);
                    break;
                case DOWNLOAD_RES_FINISH:
                    b(STATE.TRACK_START);
                    c(STATE.MODEL_LOADING);
                    break;
                case LOAD_MODEL_FINISH:
                    com.baidu.ar.util.b.a("bdar: LOAD_MODEL_FINISH");
                    com.baidu.ar.c.a.b(o.a());
                    a(301);
                    Message obtain = Message.obtain();
                    obtain.what = 312;
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
                        this.i = bundle.getInt("show_immediately");
                    }
                    c(STATE.MODEL_LOAD_FINISH);
                    break;
                case UPDATE_RT_MATRIX:
                    b(event, bundle);
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
                    }
                    a(310);
                    break;
                case TRACK_IMU_OPEN:
                    HashMap<String, Object> hashMap = new HashMap<>();
                    if (this.h.a(bundle.getInt("type"))) {
                        hashMap.put("succeeded", 1);
                    } else {
                        hashMap.put("succeeded", 0);
                    }
                    ArBridge.getInstance().sendMessage(302, hashMap);
                    a(313, bundle);
                    break;
                case TRACK_IMU_CLOSE:
                    HashMap<String, Object> hashMap2 = new HashMap<>();
                    hashMap2.put("succeeded", 1);
                    this.h.a();
                    ArBridge.getInstance().sendMessage(304, hashMap2);
                    break;
                case MODEL_APPEAR:
                    if (this.g != null && this.g.hasMessages(HttpStatus.SC_TEMPORARY_REDIRECT)) {
                        this.g.removeMessages(HttpStatus.SC_TEMPORARY_REDIRECT);
                    }
                    a(306);
                    b(STATE.MODEL_SHOWING);
                    break;
                case MODEL_DISAPPEAR:
                    a(HttpStatus.SC_TEMPORARY_REDIRECT, 100L);
                    b(STATE.MODEL_NOT_SHOWING);
                    break;
                case OPEN_INTERNAL_BROWSER:
                    Message message = new Message();
                    message.what = 311;
                    message.setData(bundle);
                    a(message);
                    break;
            }
        }
    }

    public void b() {
        e = STATE.INITIAL_STATE;
        this.b = STATE.INITIAL_STATE;
        this.c = STATE.INITIAL_STATE;
        this.d = STATE.INITIAL_STATE;
        this.f = STATE.INITIAL_STATE;
    }

    public synchronized void b(EVENT event, Bundle bundle) {
        if (e != STATE.PAUSE && e != STATE.DESTROY && this.c == STATE.MODEL_LOAD_FINISH) {
            com.baidu.ar.util.b.a("bdar: processRtMatrix isTracked = " + bundle.getBoolean("isTracked"));
            float[] floatArray = bundle.getFloatArray("RTMatrix");
            int renderMode = ArBridge.getInstance().getRenderMode();
            if (this.d == STATE.TRACKED && floatArray != null) {
                ArBridge.getInstance().updateRTMatrix(floatArray);
                Message message = new Message();
                message.what = 302;
                message.setData(bundle);
                a(message);
                if (bundle.getInt("averageTime") <= 40) {
                    if (renderMode != 0) {
                        ArBridge.getInstance().setRenderMode(0);
                    }
                    ArBridge.getInstance().requestRenderer();
                } else if (renderMode != 1) {
                    ArBridge.getInstance().setRenderMode(1);
                }
            } else if (renderMode != 1) {
                ArBridge.getInstance().setRenderMode(1);
            }
        }
    }

    public STATE c() {
        return this.d;
    }

    public synchronized void c(EVENT event, Bundle bundle) {
        float[] floatArray;
        if (this.c == STATE.MODEL_LOAD_FINISH && (floatArray = bundle.getFloatArray("RMatrix")) != null) {
            ArBridge.getInstance().updateRMatrix(floatArray);
        }
    }

    public synchronized void d(EVENT event, Bundle bundle) {
        if (e != STATE.DESTROY) {
            switch (event) {
                case VIDEO_RECORD_START:
                    this.f = STATE.INITIAL_STATE;
                    break;
                case VIDEO_RECORD_STOP_AND_SAVE_FINISH:
                    if (this.f != STATE.INITIAL_STATE) {
                        if (this.f == STATE.VIDEO_CAPTURE_IMAGE_FINISH) {
                            a(602);
                            this.f = STATE.VIDEO_RECORD_COMPLETE;
                            break;
                        }
                    } else {
                        this.f = STATE.VIDEO_RECORD_FINISH;
                        break;
                    }
                    break;
                case VIDEO_RECORD_STOP_AND_ABANDON:
                    this.f = STATE.VIDEO_RECORD_ABANDON;
                    break;
                case VIDEO_PREVIEW_IMAGE_CAPTURE_FINISH:
                    if (this.f != STATE.INITIAL_STATE) {
                        if (this.f == STATE.VIDEO_RECORD_FINISH) {
                            a(602);
                            this.f = STATE.VIDEO_RECORD_COMPLETE;
                            break;
                        }
                    } else {
                        this.f = STATE.VIDEO_CAPTURE_IMAGE_FINISH;
                        break;
                    }
                    break;
            }
        }
    }
}
