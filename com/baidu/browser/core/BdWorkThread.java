package com.baidu.browser.core;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
/* loaded from: classes11.dex */
public class BdWorkThread extends HandlerThread {
    private static final String LOG_TAG = BdWorkThread.class.getSimpleName();
    private a afO;
    private Message afP;
    private volatile Status afQ;
    private long afR;
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

        void tt();
    }

    public void i(Message message) {
        if (System.currentTimeMillis() - this.afR > this.mInterval) {
            this.afQ = Status.WORKING;
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
                                BdWorkThread.this.ts();
                                return;
                            default:
                                return;
                        }
                    }
                };
            }
            i(this.afP);
            this.afP = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(Message message) {
        this.afQ = Status.PROCESS;
        this.afR = System.currentTimeMillis();
        try {
            if (this.afO != null) {
                this.afO.k(message);
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
        if (this.afQ == Status.PROCESS) {
            this.afQ = Status.RUNNING;
            return;
        }
        synchronized (this.mLock) {
            if (this.mTimeout >= 0) {
                this.mPrivateHandler.sendMessageDelayed(this.mPrivateHandler.obtainMessage(2), this.mTimeout);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ts() {
        try {
            if (this.afO != null) {
                this.afO.tt();
            }
        } catch (Error e) {
        } catch (Exception e2) {
        }
    }
}
