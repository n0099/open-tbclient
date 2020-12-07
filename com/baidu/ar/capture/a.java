package com.baidu.ar.capture;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes10.dex */
class a {
    private HandlerThread kY;
    private HandlerC0083a kZ;
    private String mTag;

    /* renamed from: com.baidu.ar.capture.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private static final class HandlerC0083a extends Handler {
        public HandlerC0083a(Looper looper) {
            super(looper);
        }

        public void a(Runnable runnable) {
            Message obtain = Message.obtain();
            obtain.obj = runnable;
            sendMessage(obtain);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            super.handleMessage(message);
            Runnable runnable = (Runnable) message.obj;
            if (runnable != null) {
                runnable.run();
            }
        }

        public void release() {
            Thread.currentThread().interrupt();
        }
    }

    public a(String str) {
        this.mTag = str;
    }

    public void execute(Runnable runnable) {
        if (this.kZ != null) {
            this.kZ.a(runnable);
        }
    }

    public void start() {
        this.kY = new HandlerThread(this.mTag);
        this.kY.start();
        this.kZ = new HandlerC0083a(this.kY.getLooper());
    }

    public void stop() {
        if (this.kZ != null) {
            this.kZ.release();
            this.kZ = null;
        }
        if (this.kY != null) {
            this.kY.quit();
            this.kY = null;
        }
    }
}
