package com.baidu.sofire.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f10331c = new k();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f10332a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f10333b;

    public k() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f10332a = handlerThread;
        handlerThread.start();
        this.f10333b = new Handler(this.f10332a.getLooper());
    }

    public static Looper a() {
        return f10331c.f10333b.getLooper();
    }
}
