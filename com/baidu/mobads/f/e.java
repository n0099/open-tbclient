package com.baidu.mobads.f;

import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
/* loaded from: classes4.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    private static d f2381a;
    private static LinkedBlockingQueue<Runnable> b;
    private static final ThreadFactory c = new f();
    private static final b d = new h();

    public static d a(int i, int i2) {
        d dVar = new d(i, i2, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), c);
        dVar.a(d);
        return dVar;
    }

    public static ScheduledThreadPoolExecutor a(int i) {
        return new ScheduledThreadPoolExecutor(i, c);
    }
}
