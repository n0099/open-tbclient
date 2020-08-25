package com.baidu.swan.apps.core.slave;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
/* loaded from: classes8.dex */
public final class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static ExecutorService cmt = Executors.newSingleThreadExecutor();

    /* renamed from: com.baidu.swan.apps.core.slave.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0394a {
        private static int cmu = -1;

        public static boolean ajz() {
            if (cmu == -1) {
                cmu = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_preload_slave_optimization", 0);
            }
            return cmu == 1;
        }
    }
}
