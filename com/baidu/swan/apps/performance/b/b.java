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
    public static final boolean djH;
    private static volatile boolean djI;
    private static volatile a djJ;

    static {
        djH = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.awD().agX();
        djI = false;
    }

    public static void init() {
        if (!djI) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + djH);
            }
            aDS();
            aDT();
            djI = true;
        }
    }

    private static void aDS() {
        a.b.anB();
        a.C0426a.aqV();
        com.baidu.swan.apps.t.a.awD().agr();
        com.baidu.swan.apps.core.i.a.aqY();
        com.baidu.swan.apps.ap.b.aMa();
        d.aEh();
        d.a.isEnable();
        d.C0434d.agy();
        d.c.g(true);
    }

    private static void aDT() {
        aDU();
    }

    private static a aDU() {
        if (djJ == null) {
            synchronized (a.class) {
                if (djJ == null) {
                    djJ = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return djJ;
    }

    public static boolean aDV() {
        return djI;
    }

    public static boolean aDW() {
        return djH && djI && djJ != null;
    }

    public static boolean aCy() {
        return aDU().djN;
    }

    public static boolean ave() {
        return aDU().djO;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aDU().djP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private final int djK;
        private final long djL;
        private final boolean djM;
        private final boolean djN;
        private final boolean djO;
        private final boolean djP;

        private a() {
            this.djK = com.baidu.swan.apps.t.a.awD().agY();
            this.djL = com.baidu.swan.apps.t.a.awD().agK();
            this.djM = com.baidu.swan.apps.t.a.awD().agG();
            this.djN = f.aCy();
            this.djO = com.baidu.swan.apps.framework.c.ave();
            this.djP = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
