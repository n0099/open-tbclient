package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes4.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a afA;
    private Message afB;
    private volatile Status afC;
    private long afD;
    private long mInterval;
    private final Object mLock;
    private Handler mPrivateHandler;
    private long mTimeout;

    /* loaded from: classes4.dex */
    public enum Status {
        PENDING,
        RUNNING,
        WORKING,
        PROCESS,
        WAITING,
        Status
    }

    /* loaded from: classes4.dex */
    public interface a {
        void k(Message message);

        void sH();
    }

    public void i(Message message) {
        if (System.currentTimeMillis() - this.afD > this.mInterval) {
            this.afC = Status.WORKING;
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
                                BdWorkThread.this.sG();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            i(this.afB);
            this.afB = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        this.afC = Status.PROCESS;
        this.afD = System.currentTimeMillis();
        try {
            if (this.afA != null) {
                this.afA.k(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.afC == Status.PROCESS) {
            this.afC = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sG() {
        try {
            if (this.afA != null) {
                this.afA.sH();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
