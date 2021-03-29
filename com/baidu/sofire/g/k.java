package com.baidu.sofire.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f11771c = new k();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f11772a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f11773b;

    public k() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f11772a = handlerThread;
        handlerThread.start();
        this.f11773b = new Handler(this.f11772a.getLooper());
    }

    public static Looper a() {
        return f11771c.f11773b.getLooper();
    }
}
