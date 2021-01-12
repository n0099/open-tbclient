package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cUx = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0417a {
        private static int cUy = -1;

        public static boolean arm() {
            if (cUy == -1) {
                cUy = com.baidu.swan.apps.t.a.awB().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cUy == 1;
        }
    }
}
