package com.baidu.sofire.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes3.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f11770c = new k();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f11771a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f11772b;

    public k() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f11771a = handlerThread;
        handlerThread.start();
        this.f11772b = new Handler(this.f11771a.getLooper());
    }

    public static Looper a() {
        return f11770c.f11772b.getLooper();
    }
}
