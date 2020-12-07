package com.baidu.sofire.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes8.dex */
public final class m {
    private static final m c = new m();

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f3641a = new HandlerThread("rp_th", 10);
    private Handler b;

    private m() {
        this.f3641a.start();
        this.b = new Handler(this.f3641a.getLooper());
    }

    public static Looper a() {
        return c.b.getLooper();
    }
}
