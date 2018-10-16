package com.baidu.ar.slam;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import com.baidu.ar.imu.b;
import com.baidu.ar.statistic.StatisticConstants;
import com.baidu.ar.util.ARLog;
import com.baidu.ar.util.MsgConstants;
import com.baidu.baiduarsdk.ArBridge;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class SlamStateMachine {
    private static volatile SlamStateMachine a;
    private static STATE d = STATE.INITIAL_STATE;
    private STATE b = STATE.INITIAL_STATE;
    private STATE c = STATE.INITIAL_STATE;
    private boolean e = false;
    private Handler f;
    private b g;

    /* loaded from: classes3.dex */
    public enum EVENT {
        MODEL_APPEAR,
        MODEL_DISAPPEAR,
        SLAM_IMU_OPEN,
        SLAM_IMU_CLOSE,
        SLAM_GUESTURE_INTERACTION,
        SLAM_START_FROM_LUA,
        DOWNLOAD_RES_START,
        DOWNLOAD_RES_FINISH,
        LOAD_MODEL_START,
        LOAD_MODEL_FINISH
    }

    /* loaded from: classes3.dex */
    public enum STATE {
        INITIAL_STATE,
        SLAM_START,
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

    private SlamStateMachine() {
    }

    public static SlamStateMachine a() {
        if (a == null) {
            synchronized (SlamStateMachine.class) {
                if (a == null) {
                    a = new SlamStateMachine();
                }
            }
        }
        return a;
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

    private void a(Message message) {
        if (this.f != null) {
            this.f.sendMessage(message);
        }
    }

    public static void a(STATE state) {
        d = state;
    }

    private void b(STATE state) {
        this.b = state;
    }

    public static void c() {
        a().f = null;
        a = null;
    }

    private void c(STATE state) {
        this.c = state;
    }

    public synchronized void a(Bundle bundle, float[] fArr) {
        ArBridge.getInstance().updateSLAMMatrix(fArr);
        StatisticConstants.setIsRenderModel(true);
        if (ArBridge.getInstance().getArGLEngineCtl() != null) {
            int e = ArBridge.getInstance().getArGLEngineCtl().e();
            if (bundle.getInt("averageTime") <= 40) {
                if (e != 0) {
                    ArBridge.getInstance().getArGLEngineCtl().a(0);
                }
                ArBridge.getInstance().getArGLEngineCtl().b();
            } else if (e != 1) {
                ArBridge.getInstance().getArGLEngineCtl().a(1);
            }
        }
    }

    public void a(Handler handler) {
        this.f = handler;
    }

    public void a(b bVar) {
        this.g = bVar;
    }

    public synchronized void a(EVENT event) {
        a(event, (Bundle) null);
    }

    public synchronized void a(EVENT event, Bundle bundle) {
        if (d != STATE.DESTROY) {
            switch (event) {
                case DOWNLOAD_RES_FINISH:
                    ARLog.d("DOWNLOAD_RES_FINISH ");
                    if (this.c != STATE.MODEL_LOAD_FINISH) {
                        if (this.b != STATE.SLAM_START) {
                            b(STATE.SLAM_START);
                            c(STATE.MODEL_LOADING);
                            break;
                        } else {
                            a(507);
                            break;
                        }
                    } else {
                        ARLog.d("mCurrentState " + this.b);
                        switch (this.b) {
                            case SLAM_START:
                                a(512);
                                break;
                            case MODEL_NOT_SHOWING:
                                a(507);
                                break;
                            case MODEL_SHOWING:
                                a(506);
                                break;
                        }
                    }
                    break;
                case LOAD_MODEL_FINISH:
                    ARLog.d("LOAD_MODEL_FINISH ");
                    a(501);
                    c(STATE.MODEL_LOAD_FINISH);
                    break;
                case SLAM_IMU_OPEN:
                    HashMap<String, Object> hashMap = new HashMap<>();
                    if (this.g != null) {
                        if (this.g.a(0)) {
                            hashMap.put("succeeded", 1);
                        } else {
                            hashMap.put("succeeded", 0);
                        }
                        ArBridge.getInstance().sendMessage(302, hashMap);
                        break;
                    }
                    break;
                case SLAM_IMU_CLOSE:
                    if (this.g != null) {
                        HashMap<String, Object> hashMap2 = new HashMap<>();
                        hashMap2.put("succeeded", 1);
                        this.g.a();
                        ArBridge.getInstance().sendMessage(304, hashMap2);
                        break;
                    }
                    break;
                case MODEL_APPEAR:
                    if (this.f != null && this.f.hasMessages(507)) {
                        this.f.removeMessages(507);
                    }
                    a(506);
                    b(STATE.MODEL_SHOWING);
                    break;
                case MODEL_DISAPPEAR:
                    a(507, 100L);
                    b(STATE.MODEL_NOT_SHOWING);
                    break;
                case SLAM_GUESTURE_INTERACTION:
                    Message message = new Message();
                    message.what = MsgConstants.SLAM_GESTURE_INTERACTION;
                    message.setData(bundle);
                    a(message);
                    break;
                case SLAM_START_FROM_LUA:
                    a(MsgConstants.SLAM_START_FROM_LUA);
                    break;
            }
        }
    }

    public void a(boolean z) {
        this.e = z;
    }

    public void b() {
        a(STATE.INITIAL_STATE);
        this.b = STATE.INITIAL_STATE;
        this.c = STATE.INITIAL_STATE;
    }
}
