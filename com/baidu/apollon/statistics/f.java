package com.baidu.apollon.statistics;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final long f3982a = 999;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicLong f3983b = new AtomicLong(999);

    public static void a(long j) {
        if (0 == j) {
            j = 999;
        }
        f3983b.set(j);
    }

    public static long a() {
        if (0 == f3983b.incrementAndGet()) {
            f3983b.set(999L);
        }
        return f3983b.get();
    }
}
