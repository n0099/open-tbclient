package com.baidu.sofire.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes15.dex */
public final class m {
    private static final m c = new m();

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f5550a = new HandlerThread("rp_th", 10);

    /* renamed from: b  reason: collision with root package name */
    private Handler f5551b;

    private m() {
        this.f5550a.start();
        this.f5551b = new Handler(this.f5550a.getLooper());
    }

    public static Looper a() {
        return c.f5551b.getLooper();
    }
}
