package com.baidu.swan.apps.performance.b;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.y.f;
/* loaded from: classes3.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean cJi;
    private static volatile boolean cJj;
    private static volatile a cJk;

    static {
        cJi = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.apx().ZR();
        cJj = false;
    }

    public static void init() {
        if (!cJj) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + cJi);
            }
            awN();
            awO();
            cJj = true;
        }
    }

    private static void awN() {
        a.b.agw();
        a.C0383a.ajP();
        com.baidu.swan.apps.t.a.apx().Zl();
        com.baidu.swan.apps.core.i.a.ajS();
        com.baidu.swan.apps.ap.b.aEX();
        d.axc();
        d.a.isEnable();
        d.C0391d.Zs();
        d.c.f(true);
    }

    private static void awO() {
        awP();
    }

    private static a awP() {
        if (cJk == null) {
            synchronized (a.class) {
                if (cJk == null) {
                    cJk = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return cJk;
    }

    public static boolean awQ() {
        return cJj;
    }

    public static boolean awR() {
        return cJi && cJj && cJk != null;
    }

    public static boolean avt() {
        return awP().cJo;
    }

    public static boolean anX() {
        return awP().cJp;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return awP().cJq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public static class a {
        private final int cJl;
        private final long cJm;
        private final boolean cJn;
        private final boolean cJo;
        private final boolean cJp;
        private final boolean cJq;

        private a() {
            this.cJl = com.baidu.swan.apps.t.a.apx().ZS();
            this.cJm = com.baidu.swan.apps.t.a.apx().ZE();
            this.cJn = com.baidu.swan.apps.t.a.apx().ZA();
            this.cJo = f.avt();
            this.cJp = com.baidu.swan.apps.framework.c.anX();
            this.cJq = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
