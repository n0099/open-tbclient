package com.baidu.ar.capture;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
class a {
    private HandlerThread jI;
    private HandlerC0079a jJ;
    private String mTag;

    /* renamed from: com.baidu.ar.capture.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class HandlerC0079a extends Handler {
        public HandlerC0079a(Looper looper) {
            super(looper);
        }

        public void c(Runnable runnable) {
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
        if (this.jJ != null) {
            this.jJ.c(runnable);
        }
    }

    public void start() {
        this.jI = new HandlerThread(this.mTag);
        this.jI.start();
        this.jJ = new HandlerC0079a(this.jI.getLooper());
    }

    public void stop() {
        if (this.jJ != null) {
            this.jJ.release();
            this.jJ = null;
        }
        if (this.jI != null) {
            this.jI.quit();
            this.jI = null;
        }
    }
}
