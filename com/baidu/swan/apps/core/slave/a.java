package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes3.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService coA = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0389a {
        private static int coB = -1;

        public static boolean akj() {
            if (coB == -1) {
                coB = com.baidu.swan.apps.t.a.apx().getSwitch("swan_preload_slave_optimization", 0);
            }
            return coB == 1;
        }
    }
}
