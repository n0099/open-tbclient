package com.baidu.ar.capture;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes.dex */
public class a {
    public HandlerThread kY;
    public HandlerC0057a kZ;
    public String mTag;

    /* renamed from: com.baidu.ar.capture.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public static final class HandlerC0057a extends Handler {
        public HandlerC0057a(Looper looper) {
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
        HandlerC0057a handlerC0057a = this.kZ;
        if (handlerC0057a != null) {
            handlerC0057a.a(runnable);
        }
    }

    public void start() {
        HandlerThread handlerThread = new HandlerThread(this.mTag);
        this.kY = handlerThread;
        handlerThread.start();
        this.kZ = new HandlerC0057a(this.kY.getLooper());
    }

    public void stop() {
        HandlerC0057a handlerC0057a = this.kZ;
        if (handlerC0057a != null) {
            handlerC0057a.release();
            this.kZ = null;
        }
        HandlerThread handlerThread = this.kY;
        if (handlerThread != null) {
            handlerThread.quit();
            this.kY = null;
        }
    }
}
