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
    public static final boolean cHi;
    private static volatile boolean cHj;
    private static volatile a cHk;

    static {
        cHi = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.aoM().Zi();
        cHj = false;
    }

    public static void init() {
        if (!cHj) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + cHi);
            }
            awe();
            awf();
            cHj = true;
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
        if (cHk == null) {
            synchronized (a.class) {
                if (cHk == null) {
                    cHk = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return cHk;
    }

    public static boolean awh() {
        return cHj;
    }

    public static boolean awi() {
        return cHi && cHj && cHk != null;
    }

    public static boolean auK() {
        return awg().cHo;
    }

    public static boolean ann() {
        return awg().cHp;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return awg().cHq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public static class a {
        private final int cHl;
        private final long cHm;
        private final boolean cHn;
        private final boolean cHo;
        private final boolean cHp;
        private final boolean cHq;

        private a() {
            this.cHl = com.baidu.swan.apps.t.a.aoM().Zj();
            this.cHm = com.baidu.swan.apps.t.a.aoM().YV();
            this.cHn = com.baidu.swan.apps.t.a.aoM().YR();
            this.cHo = f.auK();
            this.cHp = com.baidu.swan.apps.framework.c.ann();
            this.cHq = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
