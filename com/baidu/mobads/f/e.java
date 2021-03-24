package com.baidu.mobads.f;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes2.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    public static d f8240a;

    /* renamed from: b  reason: collision with root package name */
    public static LinkedBlockingQueue<Runnable> f8241b;

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadFactory f8242c = new f();

    /* renamed from: d  reason: collision with root package name */
    public static final b f8243d = new h();

    public static d a(int i, int i2) {
        d dVar = new d(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), f8242c);
        dVar.a(f8243d);
        return dVar;
    }

    public static ScheduledThreadPoolExecutor a(int i) {
        return new ScheduledThreadPoolExecutor(i, f8242c);
    }
}
