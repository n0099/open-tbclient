package com.baidu.ar.capture;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes3.dex */
class a {
    private HandlerThread ka;
    private HandlerC0080a kb;
    private String mTag;

    /* renamed from: com.baidu.ar.capture.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    private static final class HandlerC0080a extends Handler {
        public HandlerC0080a(Looper looper) {
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
        if (this.kb != null) {
            this.kb.c(runnable);
        }
    }

    public void start() {
        this.ka = new HandlerThread(this.mTag);
        this.ka.start();
        this.kb = new HandlerC0080a(this.ka.getLooper());
    }

    public void stop() {
        if (this.kb != null) {
            this.kb.release();
            this.kb = null;
        }
        if (this.ka != null) {
            this.ka.quit();
            this.ka = null;
        }
    }
}
