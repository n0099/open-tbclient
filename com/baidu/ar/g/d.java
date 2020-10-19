package com.baidu.ar.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes14.dex */
public class d {
    private HandlerThread kJ;
    private String mTag;
    private a xh;

    /* loaded from: classes14.dex */
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
        if (this.xh != null) {
            this.xh.a(runnable);
        }
    }

    public void start() {
        this.kJ = new HandlerThread(this.mTag);
        this.kJ.start();
        this.xh = new a(this.kJ.getLooper());
    }

    public void stop() {
        if (this.xh != null) {
            this.xh.release();
            this.xh = null;
        }
        if (this.kJ != null) {
            this.kJ.quit();
            this.kJ = null;
        }
    }
}
