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
    public static final boolean ddL;
    private static volatile boolean ddM;
    private static volatile a ddN;

    static {
        ddL = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.aud().aex();
        ddM = false;
    }

    public static void init() {
        if (!ddM) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + ddL);
            }
            aBs();
            aBt();
            ddM = true;
        }
    }

    private static void aBs() {
        a.b.alb();
        a.C0414a.aou();
        com.baidu.swan.apps.t.a.aud().adR();
        com.baidu.swan.apps.core.i.a.aox();
        com.baidu.swan.apps.ap.b.aJA();
        d.aBH();
        d.a.isEnable();
        d.C0422d.adY();
        d.c.g(true);
    }

    private static void aBt() {
        aBu();
    }

    private static a aBu() {
        if (ddN == null) {
            synchronized (a.class) {
                if (ddN == null) {
                    ddN = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return ddN;
    }

    public static boolean aBv() {
        return ddM;
    }

    public static boolean aBw() {
        return ddL && ddM && ddN != null;
    }

    public static boolean azY() {
        return aBu().ddR;
    }

    public static boolean asE() {
        return aBu().ddS;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aBu().ddT;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public static class a {
        private final int ddO;
        private final long ddP;
        private final boolean ddQ;
        private final boolean ddR;
        private final boolean ddS;
        private final boolean ddT;

        private a() {
            this.ddO = com.baidu.swan.apps.t.a.aud().aey();
            this.ddP = com.baidu.swan.apps.t.a.aud().aek();
            this.ddQ = com.baidu.swan.apps.t.a.aud().aeg();
            this.ddR = f.azY();
            this.ddS = com.baidu.swan.apps.framework.c.asE();
            this.ddT = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
