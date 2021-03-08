package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cYk = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0420a {
        private static int cYl = -1;

        public static boolean arN() {
            if (cYl == -1) {
                cYl = com.baidu.swan.apps.t.a.axc().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cYl == 1;
        }
    }
}
