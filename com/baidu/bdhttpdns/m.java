package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
final class m {
    private static volatile m afe;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f1588b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m sv() {
        if (afe == null) {
            synchronized (m.class) {
                if (afe == null) {
                    afe = new m();
                }
            }
        }
        return afe;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.f1588b;
    }
}
