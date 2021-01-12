package com.baidu.mapsdkvi;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
/* loaded from: classes6.dex */
public class VMsg {

    /* renamed from: b  reason: collision with root package name */
    private static Handler f3183b;
    private static HandlerThread c;

    /* renamed from: a  reason: collision with root package name */
    private static final String f3182a = VMsg.class.getSimpleName();
    private static VMsg d = new VMsg();

    /* loaded from: classes6.dex */
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
        f3183b.removeCallbacksAndMessages(null);
        f3183b = null;
    }

    public static VMsg getInstance() {
        return d;
    }

    public static void init() {
        c = new HandlerThread("VIMsgThread");
        c.start();
        f3183b = new a(c.getLooper());
    }

    private static void postMessage(int i, int i2, int i3, long j) {
        if (f3183b == null) {
            return;
        }
        Message.obtain(f3183b, i, i2, i3, j == 0 ? null : Long.valueOf(j)).sendToTarget();
    }
}
