package com.baidu.mapsdkvi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class VMsg {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7946a = "VMsg";

    /* renamed from: b  reason: collision with root package name */
    public static Handler f7947b;

    /* renamed from: c  reason: collision with root package name */
    public static HandlerThread f7948c;

    /* renamed from: d  reason: collision with root package name */
    public static VMsg f7949d = new VMsg();

    /* loaded from: classes2.dex */
    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            Object obj = message.obj;
            VMsg.OnUserCommand1(message.what, message.arg1, message.arg2, obj == null ? 0L : ((Long) obj).longValue());
        }
    }

    public static native void InitClass(Object obj);

    public static native void OnUserCommand1(int i, int i2, int i3, long j);

    public static void destroy() {
        f7948c.quit();
        f7948c = null;
        f7947b.removeCallbacksAndMessages(null);
        f7947b = null;
    }

    public static VMsg getInstance() {
        return f7949d;
    }

    public static void init() {
        HandlerThread handlerThread = new HandlerThread("VIMsgThread");
        f7948c = handlerThread;
        handlerThread.start();
        f7947b = new a(f7948c.getLooper());
    }

    public static void postMessage(int i, int i2, int i3, long j) {
        Handler handler = f7947b;
        if (handler == null) {
            return;
        }
        Message.obtain(handler, i, i2, i3, j == 0 ? null : Long.valueOf(j)).sendToTarget();
    }
}
