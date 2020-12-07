package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes25.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cUn = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public static class C0442a {
        private static int cUo = -1;

        public static boolean atP() {
            if (cUo == -1) {
                cUo = com.baidu.swan.apps.t.a.azd().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cUo == 1;
        }
    }
}
