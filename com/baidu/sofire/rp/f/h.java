package com.baidu.sofire.rp.f;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes.dex */
public final class h {
    private static final h Qy = new h();
    private HandlerThread a = new HandlerThread("rp_th", 10);
    private Handler b;

    private h() {
        this.a.start();
        this.b = new Handler(this.a.getLooper());
    }

    public static Looper ns() {
        return Qy.b.getLooper();
    }
}
