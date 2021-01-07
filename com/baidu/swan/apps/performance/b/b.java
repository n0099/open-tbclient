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
        dtY = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.aAv().akG();
        dtZ = false;
    }

    public static void init() {
        if (!dtZ) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + dtY);
            }
            aHM();
            aHN();
            dtZ = true;
        }
    }

    private static void aHM() {
        a.b.aro();
        a.C0428a.auN();
        com.baidu.swan.apps.t.a.aAv().aka();
        com.baidu.swan.apps.core.i.a.auQ();
        com.baidu.swan.apps.ao.b.aQR();
        d.aIb();
        d.a.isEnable();
        d.C0436d.akh();
        d.c.h(true);
    }

    private static void aHN() {
        aHO();
    }

    private static a aHO() {
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

    public static boolean aHP() {
        return dtZ;
    }

    public static boolean aHQ() {
        return dtY && dtZ && dua != null;
    }

    public static boolean aGu() {
        return aHO().due;
    }

    public static boolean ayW() {
        return aHO().duf;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aHO().dug;
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
            this.dub = com.baidu.swan.apps.t.a.aAv().akH();
            this.duc = com.baidu.swan.apps.t.a.aAv().akt();
            this.dud = com.baidu.swan.apps.t.a.aAv().akp();
            this.due = f.aGu();
            this.duf = com.baidu.swan.apps.framework.c.ayW();
            this.dug = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
