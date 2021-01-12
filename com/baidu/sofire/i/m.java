package com.baidu.sofire.i;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes14.dex */
public final class m {
    private static final m c = new m();

    /* renamed from: a  reason: collision with root package name */
    private HandlerThread f5267a = new HandlerThread("rp_th", 10);

    /* renamed from: b  reason: collision with root package name */
    private Handler f5268b;

    private m() {
        this.f5267a.start();
        this.f5268b = new Handler(this.f5267a.getLooper());
    }

    public static Looper a() {
        return c.f5268b.getLooper();
    }
}
