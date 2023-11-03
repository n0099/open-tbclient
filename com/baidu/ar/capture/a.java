package com.baidu.ar.capture;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    public HandlerThread kY;
    public HandlerC0058a kZ;
    public String mTag;

    /* renamed from: com.baidu.ar.capture.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class HandlerC0058a extends Handler {
        public HandlerC0058a(Looper looper) {
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
        HandlerC0058a handlerC0058a = this.kZ;
        if (handlerC0058a != null) {
            handlerC0058a.a(runnable);
        }
    }

    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.mTag);
        this.kY = handlerThread;
        handlerThread.start();
        this.kZ = new HandlerC0058a(this.kY.getLooper());
    }

    public void stop() {
        HandlerC0058a handlerC0058a = this.kZ;
        if (handlerC0058a != null) {
            handlerC0058a.release();
            this.kZ = null;
        }
        HandlerThread handlerThread = this.kY;
        if (handlerThread != null) {
            handlerThread.quit();
            this.kY = null;
        }
    }
}
