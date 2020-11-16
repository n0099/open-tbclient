package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes7.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cNu = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public static class C0430a {
        private static int cNv = -1;

        public static boolean aqH() {
            if (cNv == -1) {
                cNv = com.baidu.swan.apps.t.a.avV().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cNv == 1;
        }
    }
}
