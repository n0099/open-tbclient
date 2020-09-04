package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes19.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a aee;
    private Message aef;
    private volatile Status aeg;
    private long aeh;
    private long mInterval;
    private final Object mLock;
    private Handler mPrivateHandler;
    private long mTimeout;

    /* loaded from: classes19.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WORKING,
        PROCESS,
        WAITING,
        Status
    }

    /* loaded from: classes19.dex */
    public interface a {
        void k(Message message);

        void tk();
    }

    public void i(Message message) {
        if (System.currentTimeMillis() - this.aeh > this.mInterval) {
            this.aeg = Status.WORKING;
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
                                BdWorkThread.this.tj();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            i(this.aef);
            this.aef = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        this.aeg = Status.PROCESS;
        this.aeh = System.currentTimeMillis();
        try {
            if (this.aee != null) {
                this.aee.k(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.aeg == Status.PROCESS) {
            this.aeg = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void tj() {
        try {
            if (this.aee != null) {
                this.aee.tk();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
