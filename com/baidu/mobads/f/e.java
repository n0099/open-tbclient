package com.baidu.mobads.f;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static d f8241a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f8242b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f8243c = new f();

    /* renamed from: d  reason: collision with root package name */
    public static final b f8244d = new h();

    public static d a(int i, int i2) {
        d dVar = new d(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f8243c);
        dVar.a(f8244d);
        return dVar;
    }

    public static ScheduledThreadPoolExecutor a(int i) {
        return new ScheduledThreadPoolExecutor(i, f8243c);
    }
}
