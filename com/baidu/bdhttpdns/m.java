package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
final class m {
    private static volatile m aeX;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f1586b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m ss() {
        if (aeX == null) {
            synchronized (m.class) {
                if (aeX == null) {
                    aeX = new m();
                }
            }
        }
        return aeX;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.f1586b;
    }
}
