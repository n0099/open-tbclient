package com.baidu.ar.h;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class d {
    public HandlerThread kY;
    public String mTag;
    public a xW;

    /* loaded from: classes.dex */
    public static final class a extends Handler {
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
        a aVar = this.xW;
        if (aVar != null) {
            aVar.a(runnable);
        }
    }

    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.mTag);
        this.kY = handlerThread;
        handlerThread.start();
        this.xW = new a(this.kY.getLooper());
    }

    public void stop() {
        a aVar = this.xW;
        if (aVar != null) {
            aVar.release();
            this.xW = null;
        }
        HandlerThread handlerThread = this.kY;
        if (handlerThread != null) {
            handlerThread.quit();
            this.kY = null;
        }
    }
}
