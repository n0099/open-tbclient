package com.baidu.bdhttpdns;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
/* loaded from: classes6.dex */
final class m {
    private static volatile m afV;

    /* renamed from: b  reason: collision with root package name */
    private final Executor f1638b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private m() {
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public static m sG() {
        if (afV == null) {
            synchronized (m.class) {
                if (afV == null) {
                    afV = new m();
                }
            }
        }
        return afV;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Executor b() {
        return this.f1638b;
    }
}
