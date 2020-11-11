package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cPe = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0432a {
        private static int cPf = -1;

        public static boolean arp() {
            if (cPf == -1) {
                cPf = com.baidu.swan.apps.t.a.awD().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cPf == 1;
        }
    }
}
