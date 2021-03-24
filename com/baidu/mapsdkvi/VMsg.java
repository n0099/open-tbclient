package com.baidu.mapsdkvi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes2.dex */
public class VMsg {

    /* renamed from: a  reason: collision with root package name */
    public static final String f7910a = "VMsg";

    /* renamed from: b  reason: collision with root package name */
    public static Handler f7911b;

    /* renamed from: c  reason: collision with root package name */
    public static HandlerThread f7912c;

    /* renamed from: d  reason: collision with root package name */
    public static VMsg f7913d = new VMsg();

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
        f7912c.quit();
        f7912c = null;
        f7911b.removeCallbacksAndMessages(null);
        f7911b = null;
    }

    public static VMsg getInstance() {
        return f7913d;
    }

    public static void init() {
        HandlerThread handlerThread = new HandlerThread("VIMsgThread");
        f7912c = handlerThread;
        handlerThread.start();
        f7911b = new a(f7912c.getLooper());
    }

    public static void postMessage(int i, int i2, int i3, long j) {
        Handler handler = f7911b;
        if (handler == null) {
            return;
        }
        Message.obtain(handler, i, i2, i3, j == 0 ? null : Long.valueOf(j)).sendToTarget();
    }
}
