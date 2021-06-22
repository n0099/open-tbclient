package com.baidu.sofire.utility;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
/* loaded from: classes2.dex */
public final class k {

    /* renamed from: c  reason: collision with root package name */
    public static final k f10423c = new k();

    /* renamed from: a  reason: collision with root package name */
    public HandlerThread f10424a;

    /* renamed from: b  reason: collision with root package name */
    public Handler f10425b;

    public k() {
        HandlerThread handlerThread = new HandlerThread("rp_th", 10);
        this.f10424a = handlerThread;
        handlerThread.start();
        this.f10425b = new Handler(this.f10424a.getLooper());
    }

    public static Looper a() {
        return f10423c.f10425b.getLooper();
    }
}
