package com.baidu.swan.apps.performance.b;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.y.f;
/* loaded from: classes9.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dtY;
    private static volatile boolean dtZ;
    private static volatile a dua;

    static {
        dtY = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.aAu().akF();
        dtZ = false;
    }

    public static void init() {
        if (!dtZ) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + dtY);
            }
            aHL();
            aHM();
            dtZ = true;
        }
    }

    private static void aHL() {
        a.b.arn();
        a.C0428a.auM();
        com.baidu.swan.apps.t.a.aAu().ajZ();
        com.baidu.swan.apps.core.i.a.auP();
        com.baidu.swan.apps.ao.b.aQQ();
        d.aIa();
        d.a.isEnable();
        d.C0436d.akg();
        d.c.h(true);
    }

    private static void aHM() {
        aHN();
    }

    private static a aHN() {
        if (dua == null) {
            synchronized (a.class) {
                if (dua == null) {
                    dua = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return dua;
    }

    public static boolean aHO() {
        return dtZ;
    }

    public static boolean aHP() {
        return dtY && dtZ && dua != null;
    }

    public static boolean aGt() {
        return aHN().due;
    }

    public static boolean ayV() {
        return aHN().duf;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aHN().dug;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private final int dub;
        private final long duc;
        private final boolean dud;
        private final boolean due;
        private final boolean duf;
        private final boolean dug;

        private a() {
            this.dub = com.baidu.swan.apps.t.a.aAu().akG();
            this.duc = com.baidu.swan.apps.t.a.aAu().aks();
            this.dud = com.baidu.swan.apps.t.a.aAu().ako();
            this.due = f.aGt();
            this.duf = com.baidu.swan.apps.framework.c.ayV();
            this.dug = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
