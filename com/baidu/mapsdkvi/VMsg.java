package com.baidu.mapsdkvi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class VMsg {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7945a = "VMsg";

    /* renamed from: b  reason: collision with root package name */
    public static Handler f7946b;

    /* renamed from: c  reason: collision with root package name */
    public static HandlerThread f7947c;

    /* renamed from: d  reason: collision with root package name */
    public static VMsg f7948d = new VMsg();

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

    public static native void OnUserCommand1(int i2, int i3, int i4, long j);

    public static void destroy() {
        f7947c.quit();
        f7947c = null;
        f7946b.removeCallbacksAndMessages(null);
        f7946b = null;
    }

    public static VMsg getInstance() {
        return f7948d;
    }

    public static void init() {
        HandlerThread handlerThread = new HandlerThread("VIMsgThread");
        f7947c = handlerThread;
        handlerThread.start();
        f7946b = new a(f7947c.getLooper());
    }

    public static void postMessage(int i2, int i3, int i4, long j) {
        Handler handler = f7946b;
        if (handler == null) {
            return;
        }
        Message.obtain(handler, i2, i3, i4, j == 0 ? null : Long.valueOf(j)).sendToTarget();
    }
}
