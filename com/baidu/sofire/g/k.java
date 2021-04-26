package com.baidu.sofire.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f11264c = new k();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f11265a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f11266b;

    public k() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f11265a = handlerThread;
        handlerThread.start();
        this.f11266b = new Handler(this.f11265a.getLooper());
    }

    public static Looper a() {
        return f11264c.f11266b.getLooper();
    }
}
