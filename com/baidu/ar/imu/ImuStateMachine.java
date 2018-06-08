package com.baidu.ar.imu;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.ar.rotate.OrientationManager;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.test.PerformanceTest;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.baiduarsdk.ArBridge;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ImuStateMachine {
    private static volatile ImuStateMachine a;
    private static STATE d = STATE.INITIAL_STATE;
    private STATE b = STATE.INITIAL_STATE;
    private STATE c = STATE.INITIAL_STATE;
    private Handler e;
    private b f;

    /* loaded from: classes3.dex */
    public enum EVENT {
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        IMU_OPEN,
        IMU_CLOSE,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_FINISH
    }

    /* loaded from: classes3.dex */
    public enum STATE {
        INITIAL_STATE,
        MODEL_SHOWING,
        MODEL_NOT_SHOWING,
        MODEL_LOADING,
        MODEL_LOAD_FINISH,
        RESUME,
        PAUSE,
        DESTROY
    }

    private ImuStateMachine() {
    }

    public static ImuStateMachine a() {
        if (a == null) {
            synchronized (ImuStateMachine.class) {
                if (a == null) {
                    a = new ImuStateMachine();
                }
            }
        }
        return a;
    }

    private void a(int i) {
        if (this.e != null) {
            this.e.sendEmptyMessage(i);
        }
    }

    private void a(int i, Bundle bundle) {
        if (this.e != null) {
            Message obtainMessage = this.e.obtainMessage();
            obtainMessage.what = i;
            obtainMessage.setData(bundle);
            this.e.sendMessage(obtainMessage);
        }
    }

    public static void a(STATE state) {
        d = state;
    }

    private void b(STATE state) {
        this.b = state;
    }

    public static void c() {
        a().e = null;
        a = null;
    }

    private void c(STATE state) {
        this.c = state;
    }

    public synchronized void a(Bundle bundle) {
        float[] floatArray;
        if (this.c == STATE.MODEL_LOAD_FINISH && (floatArray = bundle.getFloatArray("RMatrix")) != null) {
            ArBridge.getInstance().updateRMatrix(floatArray);
            StatisticConstants.setIsRenderModel(true);
        }
    }

    public void a(Handler handler) {
        this.e = handler;
    }

    public synchronized void a(EVENT event) {
        a(event, (Bundle) null);
    }

    public synchronized void a(EVENT event, Bundle bundle) {
        synchronized (this) {
            ARLog.d("event=" + event + ", state=" + this.b + ", BgState=" + this.c + ", AppState=" + d);
            if (d != STATE.DESTROY) {
                switch (event) {
                    case DOWNLOAD_RES_FINISH:
                        if (this.c != STATE.MODEL_LOAD_FINISH) {
                            c(STATE.MODEL_LOADING);
                            break;
                        }
                        break;
                    case LOAD_MODEL_FINISH:
                        if (this.c == STATE.MODEL_LOADING) {
                            com.baidu.ar.msghandler.a.a(OrientationManager.getGlobalOrientation().getDegree());
                            a(MsgConstants.IMU_MSG_ID_MODEL_LOADED);
                            c(STATE.MODEL_LOAD_FINISH);
                            break;
                        }
                        break;
                    case IMU_OPEN:
                        HashMap<String, Object> hashMap = new HashMap<>();
                        try {
                            this.f.a(bundle);
                            if (PerformanceTest.isOpenIMU() ? this.f.a(bundle.getInt("type")) : true) {
                                hashMap.put("succeeded", 1);
                            } else {
                                hashMap.put("succeeded", 0);
                            }
                            ArBridge.getInstance().sendMessage(302, hashMap);
                            a(MsgConstants.IMU_IMU_OPEN, bundle);
                            break;
                        } catch (NullPointerException e) {
                            ARLog.w("bdar:has NullPointerException!!!");
                            break;
                        }
                    case IMU_CLOSE:
                        if (this.f != null) {
                            HashMap<String, Object> hashMap2 = new HashMap<>();
                            hashMap2.put("succeeded", 1);
                            this.f.a();
                            ArBridge.getInstance().sendMessage(304, hashMap2);
                            break;
                        }
                        break;
                    case MODEL_APPEAR:
                        a(MsgConstants.IMU_MODEL_SHOWING);
                        b(STATE.MODEL_SHOWING);
                        break;
                    case MODEL_DISAPPEAR:
                        b(STATE.MODEL_NOT_SHOWING);
                        break;
                }
            }
        }
    }

    public void a(b bVar) {
        this.f = bVar;
    }

    public void b() {
        a(STATE.INITIAL_STATE);
        this.b = STATE.INITIAL_STATE;
        this.c = STATE.INITIAL_STATE;
    }
}
