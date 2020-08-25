package com.baidu.ar.capture;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes11.dex */
class a {
    private HandlerThread kJ;
    private HandlerC0079a kK;
    private String mTag;

    /* renamed from: com.baidu.ar.capture.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private static final class HandlerC0079a extends Handler {
        public HandlerC0079a(Looper looper) {
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
        if (this.kK != null) {
            this.kK.a(runnable);
        }
    }

    public void start() {
        this.kJ = new HandlerThread(this.mTag);
        this.kJ.start();
        this.kK = new HandlerC0079a(this.kJ.getLooper());
    }

    public void stop() {
        if (this.kK != null) {
            this.kK.release();
            this.kK = null;
        }
        if (this.kJ != null) {
            this.kJ.quit();
            this.kJ = null;
        }
    }
}
