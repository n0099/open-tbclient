package com.baidu.swan.apps.performance.b;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.y.f;
/* loaded from: classes25.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean doZ;
    private static volatile boolean dpa;
    private static volatile a dpb;

    static {
        doZ = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.azd().ajx();
        dpa = false;
    }

    public static void init() {
        if (!dpa) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + doZ);
            }
            aGs();
            aGt();
            dpa = true;
        }
    }

    private static void aGs() {
        a.b.aqb();
        a.C0436a.atv();
        com.baidu.swan.apps.t.a.azd().aiR();
        com.baidu.swan.apps.core.i.a.aty();
        com.baidu.swan.apps.ap.b.aOz();
        d.aGH();
        d.a.isEnable();
        d.C0444d.aiY();
        d.c.g(true);
    }

    private static void aGt() {
        aGu();
    }

    private static a aGu() {
        if (dpb == null) {
            synchronized (a.class) {
                if (dpb == null) {
                    dpb = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return dpb;
    }

    public static boolean aGv() {
        return dpa;
    }

    public static boolean aGw() {
        return doZ && dpa && dpb != null;
    }

    public static boolean aEZ() {
        return aGu().dpf;
    }

    public static boolean axE() {
        return aGu().dpg;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aGu().dph;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public static class a {
        private final int dpc;
        private final long dpd;
        private final boolean dpe;
        private final boolean dpf;
        private final boolean dpg;
        private final boolean dph;

        private a() {
            this.dpc = com.baidu.swan.apps.t.a.azd().ajy();
            this.dpd = com.baidu.swan.apps.t.a.azd().ajk();
            this.dpe = com.baidu.swan.apps.t.a.azd().ajg();
            this.dpf = f.aEZ();
            this.dpg = com.baidu.swan.apps.framework.c.axE();
            this.dph = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
