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
    public static final boolean dru;
    private static volatile boolean drv;
    private static volatile a drw;

    static {
        dru = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.awZ().ahk();
        drv = false;
    }

    public static void init() {
        if (!drv) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + dru);
            }
            aEn();
            aEo();
            drv = true;
        }
    }

    private static void aEn() {
        a.b.anR();
        a.C0408a.arq();
        com.baidu.swan.apps.t.a.awZ().agE();
        com.baidu.swan.apps.core.i.a.art();
        com.baidu.swan.apps.ao.b.aNq();
        d.aEC();
        d.a.isEnable();
        d.C0416d.agL();
        d.c.h(true);
    }

    private static void aEo() {
        aEp();
    }

    private static a aEp() {
        if (drw == null) {
            synchronized (a.class) {
                if (drw == null) {
                    drw = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return drw;
    }

    public static boolean aEq() {
        return drv;
    }

    public static boolean aEr() {
        return dru && drv && drw != null;
    }

    public static boolean aCW() {
        return aEp().drA;
    }

    public static boolean avA() {
        return aEp().drB;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aEp().drC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a {
        private final boolean drA;
        private final boolean drB;
        private final boolean drC;
        private final int drx;
        private final long dry;
        private final boolean drz;

        private a() {
            this.drx = com.baidu.swan.apps.t.a.awZ().ahl();
            this.dry = com.baidu.swan.apps.t.a.awZ().agX();
            this.drz = com.baidu.swan.apps.t.a.awZ().agT();
            this.drA = f.aCW();
            this.drB = com.baidu.swan.apps.framework.c.avA();
            this.drC = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
