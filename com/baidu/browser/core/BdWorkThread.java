package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a UO;
    private Message UQ;
    private volatile Status UR;
    private long US;
    private long mInterval;
    private final Object mLock;
    private Handler mPrivateHandler;
    private long mTimeout;

    /* loaded from: classes2.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WORKING,
        PROCESS,
        WAITING,
        Status
    }

    /* loaded from: classes2.dex */
    public interface a {
        void h(Message message);

        void qk();
    }

    public void f(Message message) {
        if (System.currentTimeMillis() - this.US > this.mInterval) {
            this.UR = Status.WORKING;
            this.mPrivateHandler.removeMessages(1);
            this.mPrivateHandler.removeMessages(2);
            this.mPrivateHandler.obtainMessage(1, message).sendToTarget();
        }
    }

    @Override // android.os.HandlerThread
    protected void onLooperPrepared() {
        synchronized (this.mLock) {
            if (this.mPrivateHandler == null) {
                this.mPrivateHandler = new Handler(getLooper()) { // from class: com.baidu.browser.core.BdWorkThread.1
                    @Override // android.os.Handler
                    public void handleMessage(Message message) {
                        switch (message.what) {
                            case 1:
                                BdWorkThread.this.g((Message) message.obj);
                                return;
                            case 2:
                                BdWorkThread.this.qj();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            f(this.UQ);
            this.UQ = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g(Message message) {
        this.UR = Status.PROCESS;
        this.US = System.currentTimeMillis();
        try {
            if (this.UO != null) {
                this.UO.h(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.UR == Status.PROCESS) {
            this.UR = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qj() {
        try {
            if (this.UO != null) {
                this.UO.qk();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
