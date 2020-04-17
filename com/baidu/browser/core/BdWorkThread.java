package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes11.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a abC;
    private Message abD;
    private volatile Status abE;
    private long abF;
    private long mInterval;
    private final Object mLock;
    private Handler mPrivateHandler;
    private long mTimeout;

    /* loaded from: classes11.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WORKING,
        PROCESS,
        WAITING,
        Status
    }

    /* loaded from: classes11.dex */
    public interface a {
        void k(Message message);

        void qY();
    }

    public void i(Message message) {
        if (System.currentTimeMillis() - this.abF > this.mInterval) {
            this.abE = Status.WORKING;
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
                                BdWorkThread.this.qX();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            i(this.abD);
            this.abD = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        this.abE = Status.PROCESS;
        this.abF = System.currentTimeMillis();
        try {
            if (this.abC != null) {
                this.abC.k(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.abE == Status.PROCESS) {
            this.abE = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qX() {
        try {
            if (this.abC != null) {
                this.abC.qY();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
