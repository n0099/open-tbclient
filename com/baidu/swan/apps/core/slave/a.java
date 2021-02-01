package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cWK = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0414a {
        private static int cWL = -1;

        public static boolean arK() {
            if (cWL == -1) {
                cWL = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cWL == 1;
        }
    }
}
