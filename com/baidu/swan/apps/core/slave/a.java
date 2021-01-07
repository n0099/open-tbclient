package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes9.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cZj = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public static class C0434a {
        private static int cZk = -1;

        public static boolean avh() {
            if (cZk == -1) {
                cZk = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cZk == 1;
        }
    }
}
