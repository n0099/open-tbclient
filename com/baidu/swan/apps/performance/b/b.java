package com.baidu.swan.apps.performance.b;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.y.f;
/* loaded from: classes8.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dsW;
    private static volatile boolean dsX;
    private static volatile a dsY;

    static {
        dsW = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.axc().ahn();
        dsX = false;
    }

    public static void init() {
        if (!dsX) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + dsW);
            }
            aEq();
            aEr();
            dsX = true;
        }
    }

    private static void aEq() {
        a.b.anU();
        a.C0414a.art();
        com.baidu.swan.apps.t.a.axc().agH();
        com.baidu.swan.apps.core.i.a.arw();
        com.baidu.swan.apps.ao.b.aNt();
        d.aEF();
        d.a.isEnable();
        d.C0422d.agO();
        d.c.h(true);
    }

    private static void aEr() {
        aEs();
    }

    private static a aEs() {
        if (dsY == null) {
            synchronized (a.class) {
                if (dsY == null) {
                    dsY = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return dsY;
    }

    public static boolean aEt() {
        return dsX;
    }

    public static boolean aEu() {
        return dsW && dsX && dsY != null;
    }

    public static boolean aCZ() {
        return aEs().dtc;
    }

    public static boolean avD() {
        return aEs().dtd;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aEs().dte;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private final int dsZ;
        private final long dta;
        private final boolean dtb;
        private final boolean dtc;
        private final boolean dtd;
        private final boolean dte;

        private a() {
            this.dsZ = com.baidu.swan.apps.t.a.axc().aho();
            this.dta = com.baidu.swan.apps.t.a.axc().aha();
            this.dtb = com.baidu.swan.apps.t.a.axc().agW();
            this.dtc = f.aCZ();
            this.dtd = com.baidu.swan.apps.framework.c.avD();
            this.dte = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
