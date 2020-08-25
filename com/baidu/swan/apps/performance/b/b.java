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
    public static final boolean cHe;
    private static volatile boolean cHf;
    private static volatile a cHg;

    static {
        cHe = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.aoM().Zi();
        cHf = false;
    }

    public static void init() {
        if (!cHf) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + cHe);
            }
            awe();
            awf();
            cHf = true;
        }
    }

    private static void awe() {
        a.b.afM();
        a.C0388a.ajf();
        com.baidu.swan.apps.t.a.aoM().YC();
        com.baidu.swan.apps.core.i.a.aji();
        com.baidu.swan.apps.ap.b.aEn();
        d.awt();
        d.a.isEnable();
        d.C0396d.YJ();
        d.c.f(true);
    }

    private static void awf() {
        awg();
    }

    private static a awg() {
        if (cHg == null) {
            synchronized (a.class) {
                if (cHg == null) {
                    cHg = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return cHg;
    }

    public static boolean awh() {
        return cHf;
    }

    public static boolean awi() {
        return cHe && cHf && cHg != null;
    }

    public static boolean auK() {
        return awg().cHk;
    }

    public static boolean ann() {
        return awg().cHl;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return awg().cHm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private final int cHh;
        private final long cHi;
        private final boolean cHj;
        private final boolean cHk;
        private final boolean cHl;
        private final boolean cHm;

        private a() {
            this.cHh = com.baidu.swan.apps.t.a.aoM().Zj();
            this.cHi = com.baidu.swan.apps.t.a.aoM().YV();
            this.cHj = com.baidu.swan.apps.t.a.aoM().YR();
            this.cHk = f.auK();
            this.cHl = com.baidu.swan.apps.framework.c.ann();
            this.cHm = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
