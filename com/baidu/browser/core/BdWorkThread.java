package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes9.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a HU;
    private Message HV;
    private volatile Status HW;
    private long HX;
    private long mInterval;
    private final Object mLock;
    private Handler mPrivateHandler;
    private long mTimeout;

    /* loaded from: classes9.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WORKING,
        PROCESS,
        WAITING,
        Status
    }

    /* loaded from: classes9.dex */
    public interface a {
        void k(Message message);

        void mh();
    }

    public void i(Message message) {
        if (System.currentTimeMillis() - this.HX > this.mInterval) {
            this.HW = Status.WORKING;
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
                                BdWorkThread.this.j((Message) message.obj);
                                return;
                            case 2:
                                BdWorkThread.this.mg();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            i(this.HV);
            this.HV = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        this.HW = Status.PROCESS;
        this.HX = System.currentTimeMillis();
        try {
            if (this.HU != null) {
                this.HU.k(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.HW == Status.PROCESS) {
            this.HW = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mg() {
        try {
            if (this.HU != null) {
                this.HU.mh();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
