package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cAP = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0406a {
        private static int cAQ = -1;

        public static boolean amU() {
            if (cAQ == -1) {
                cAQ = com.baidu.swan.apps.t.a.asi().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cAQ == 1;
        }
    }
}
