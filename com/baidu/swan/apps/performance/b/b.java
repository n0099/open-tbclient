package com.baidu.swan.apps.performance.b;

import android.util.Log;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.core.b.a;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.turbo.d;
import com.baidu.swan.apps.res.ui.pullrefresh.PullToRefreshBase;
import com.baidu.swan.apps.y.f;
/* loaded from: classes7.dex */
public class b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    public static final boolean dhX;
    private static volatile boolean dhY;
    private static volatile a dhZ;

    static {
        dhX = !ProcessUtils.isMainProcess() && com.baidu.swan.apps.t.a.avV().agp();
        dhY = false;
    }

    public static void init() {
        if (!dhY) {
            if (DEBUG) {
                Log.d("SwanAbSwitchCache", "SwanAbSwitchCache-init:" + ProcessUtils.getCurProcessName() + ":" + dhX);
            }
            aDk();
            aDl();
            dhY = true;
        }
    }

    private static void aDk() {
        a.b.amT();
        a.C0424a.aqn();
        com.baidu.swan.apps.t.a.avV().afJ();
        com.baidu.swan.apps.core.i.a.aqq();
        com.baidu.swan.apps.ap.b.aLs();
        d.aDz();
        d.a.isEnable();
        d.C0432d.afQ();
        d.c.g(true);
    }

    private static void aDl() {
        aDm();
    }

    private static a aDm() {
        if (dhZ == null) {
            synchronized (a.class) {
                if (dhZ == null) {
                    dhZ = new a();
                    if (DEBUG) {
                        Log.d("SwanAbSwitchCache", "getAbSwitchHolder:init.");
                    }
                }
            }
        }
        return dhZ;
    }

    public static boolean aDn() {
        return dhY;
    }

    public static boolean aDo() {
        return dhX && dhY && dhZ != null;
    }

    public static boolean aBQ() {
        return aDm().die;
    }

    public static boolean auw() {
        return aDm().dif;
    }

    public static boolean getNgWebViewHeightSwitch() {
        return aDm().dig;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a {
        private final int dia;
        private final long dib;
        private final boolean dic;
        private final boolean die;
        private final boolean dif;
        private final boolean dig;

        private a() {
            this.dia = com.baidu.swan.apps.t.a.avV().agq();
            this.dib = com.baidu.swan.apps.t.a.avV().agc();
            this.dic = com.baidu.swan.apps.t.a.avV().afY();
            this.die = f.aBQ();
            this.dif = com.baidu.swan.apps.framework.c.auw();
            this.dig = PullToRefreshBase.getNgWebViewHeightSwitch();
        }
    }
}
