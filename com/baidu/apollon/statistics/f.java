package com.baidu.apollon.statistics;

import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes2.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    public static final long f3870a = 999;

    /* renamed from: b  reason: collision with root package name */
    public static AtomicLong f3871b = new AtomicLong(999);

    public static void a(long j) {
        if (0 == j) {
            j = 999;
        }
        f3871b.set(j);
    }

    public static long a() {
        if (0 == f3871b.incrementAndGet()) {
            f3871b.set(999L);
        }
        return f3871b.get();
    }
}
