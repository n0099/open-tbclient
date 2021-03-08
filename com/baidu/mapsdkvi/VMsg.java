package com.baidu.mapsdkvi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes4.dex */
public class VMsg {
    private static Handler b;
    private static HandlerThread c;

    /* renamed from: a  reason: collision with root package name */
    private static final String f2297a = VMsg.class.getSimpleName();
    private static VMsg d = new VMsg();

    /* loaded from: classes4.dex */
    static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            VMsg.OnUserCommand1(message.what, message.arg1, message.arg2, message.obj == null ? 0L : ((Long) message.obj).longValue());
        }
    }

    public static native void InitClass(Object obj);

    /* JADX INFO: Access modifiers changed from: private */
    public static native void OnUserCommand1(int i, int i2, int i3, long j);

    public static void destroy() {
        c.quit();
        c = null;
        b.removeCallbacksAndMessages(null);
        b = null;
    }

    public static VMsg getInstance() {
        return d;
    }

    public static void init() {
        c = new HandlerThread("VIMsgThread");
        c.start();
        b = new a(c.getLooper());
    }

    private static void postMessage(int i, int i2, int i3, long j) {
        if (b == null) {
            return;
        }
        Message.obtain(b, i, i2, i3, j == 0 ? null : Long.valueOf(j)).sendToTarget();
    }
}
