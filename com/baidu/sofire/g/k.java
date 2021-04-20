package com.baidu.sofire.g;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f11432c = new k();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f11433a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f11434b;

    public k() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f11433a = handlerThread;
        handlerThread.start();
        this.f11434b = new Handler(this.f11433a.getLooper());
    }

    public static Looper a() {
        return f11432c.f11434b.getLooper();
    }
}
