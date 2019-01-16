package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes2.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a Va;
    private Message Vb;
    private volatile Status Vc;
    private long Vd;
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
        void j(Message message);

        void ql();
    }

    public void h(Message message) {
        if (System.currentTimeMillis() - this.Vd > this.mInterval) {
            this.Vc = Status.WORKING;
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
                                BdWorkThread.this.i((Message) message.obj);
                                return;
                            case 2:
                                BdWorkThread.this.qk();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            h(this.Vb);
            this.Vb = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i(Message message) {
        this.Vc = Status.PROCESS;
        this.Vd = System.currentTimeMillis();
        try {
            if (this.Va != null) {
                this.Va.j(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.Vc == Status.PROCESS) {
            this.Vc = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qk() {
        try {
            if (this.Va != null) {
                this.Va.ql();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
