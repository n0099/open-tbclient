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
    public static final boolean dpi;
    private static volatile boolean dpj;
    private static volatile a dpk;

    static {
        dpi = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.awB().agM();
        dpj = false;
    }

    public static void init() {
        if (!dpj) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + dpi);
            }
            aDS();
            aDT();
            dpj = true;
        }
    }

    private static void aDS() {
        a.b.ant();
        a.C0411a.aqS();
        com.baidu.swan.apps.t.a.awB().agg();
        com.baidu.swan.apps.core.i.a.aqV();
        com.baidu.swan.apps.ao.b.aMX();
        d.aEh();
        d.a.isEnable();
        d.C0419d.agn();
        d.c.h(true);
    }

    private static void aDT() {
        aDU();
    }

    private static a aDU() {
        if (dpk == null) {
            synchronized (a.class) {
                if (dpk == null) {
                    dpk = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return dpk;
    }

    public static boolean aDV() {
        return dpj;
    }

    public static boolean aDW() {
        return dpi && dpj && dpk != null;
    }

    public static boolean aCA() {
        return aDU().dpp;
    }

    public static boolean avc() {
        return aDU().dpq;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aDU().dpr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private final int dpm;
        private final long dpn;
        private final boolean dpo;
        private final boolean dpp;
        private final boolean dpq;
        private final boolean dpr;

        private a() {
            this.dpm = com.baidu.swan.apps.t.a.awB().agN();
            this.dpn = com.baidu.swan.apps.t.a.awB().agz();
            this.dpo = com.baidu.swan.apps.t.a.awB().agv();
            this.dpp = f.aCA();
            this.dpq = com.baidu.swan.apps.framework.c.avc();
            this.dpr = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
