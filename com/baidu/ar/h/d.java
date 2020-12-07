package com.baidu.ar.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes10.dex */
public class d {
    private HandlerThread kY;
    private String mTag;
    private a xW;

    /* loaded from: classes10.dex */
    private static final class a extends Handler {
        public a(Looper looper) {
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

    public d(String str) {
        this.mTag = str;
    }

    public void execute(Runnable runnable) {
        if (this.xW != null) {
            this.xW.a(runnable);
        }
    }

    public void start() {
        this.kY = new HandlerThread(this.mTag);
        this.kY.start();
        this.xW = new a(this.kY.getLooper());
    }

    public void stop() {
        if (this.xW != null) {
            this.xW.release();
            this.xW = null;
        }
        if (this.kY != null) {
            this.kY.quit();
            this.kY = null;
        }
    }
}
