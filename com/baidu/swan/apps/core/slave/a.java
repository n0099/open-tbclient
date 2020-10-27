package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes10.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cJl = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0420a {
        private static int cJm = -1;

        public static boolean aoO() {
            if (cJm == -1) {
                cJm = com.baidu.swan.apps.t.a.aud().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cJm == 1;
        }
    }
}
