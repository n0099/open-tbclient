package com.baidu.swan.apps.performance.b;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.y.f;
/* loaded from: classes10.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean cVl;
    private static volatile boolean cVm;
    private static volatile a cVn;

    static {
        cVl = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.asi().acD();
        cVm = false;
    }

    public static void init() {
        if (!cVm) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + cVl);
            }
            azy();
            azz();
            cVm = true;
        }
    }

    private static void azy() {
        a.b.ajh();
        a.C0400a.amA();
        com.baidu.swan.apps.t.a.asi().abX();
        com.baidu.swan.apps.core.i.a.amD();
        com.baidu.swan.apps.ap.b.aHG();
        d.azN();
        d.a.isEnable();
        d.C0408d.ace();
        d.c.g(true);
    }

    private static void azz() {
        azA();
    }

    private static a azA() {
        if (cVn == null) {
            synchronized (a.class) {
                if (cVn == null) {
                    cVn = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return cVn;
    }

    public static boolean azB() {
        return cVm;
    }

    public static boolean azC() {
        return cVl && cVm && cVn != null;
    }

    public static boolean aye() {
        return azA().cVr;
    }

    public static boolean aqJ() {
        return azA().cVs;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return azA().cVt;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private final int cVo;
        private final long cVp;
        private final boolean cVq;
        private final boolean cVr;
        private final boolean cVs;
        private final boolean cVt;

        private a() {
            this.cVo = com.baidu.swan.apps.t.a.asi().acE();
            this.cVp = com.baidu.swan.apps.t.a.asi().acq();
            this.cVq = com.baidu.swan.apps.t.a.asi().acm();
            this.cVr = f.aye();
            this.cVs = com.baidu.swan.apps.framework.c.aqJ();
            this.cVt = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
