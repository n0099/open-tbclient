package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong cxf = new AtomicLong(0);
    private static volatile f cxg;
    private d cxh = new a();

    private f() {
    }

    public static f arY() {
        if (cxg == null) {
            synchronized (f.class) {
                if (cxg == null) {
                    cxg = new f();
                }
            }
        }
        return cxg;
    }

    boolean arZ() {
        return (this.cxh == null || (this.cxh instanceof a)) ? false : true;
    }

    public boolean asa() {
        return arZ() && this.cxh.arI() != null;
    }

    public void cc(Context context) {
        this.cxh.cc(context);
    }

    public void cd(Context context) {
        this.cxh.cd(context);
    }

    public void aay() {
        this.cxh.aay();
    }

    public void aaz() {
        this.cxh.aaz();
    }

    public void exit() {
        this.cxh.exit();
    }

    public void ary() {
        this.cxh.ary();
    }

    public void arz() {
        this.cxh.arz();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cxg != null) {
                if (cxg.cxh != null) {
                    cxg.cxh.doRelease();
                }
                cxg = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e agn() {
        return this.cxh.agn();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cxh.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cxh.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a arB() {
        return this.cxh.arB();
    }

    public FullScreenFloatView H(Activity activity) {
        return this.cxh.H(activity);
    }

    public SwanAppPropertyWindow I(Activity activity) {
        return this.cxh.I(activity);
    }

    public boolean arC() {
        return this.cxh.arC();
    }

    public void w(Intent intent) {
        this.cxh.w(intent);
    }

    public void ZN() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.apl().ZN();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aEM();
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.bA(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !arZ()) {
            ih(swanAppActivity.XP());
        }
        if (arZ()) {
            this.cxh.i(swanAppActivity);
        }
    }

    public void ih(int i) {
        if (!arZ()) {
            switch (i) {
                case 0:
                    this.cxh = new c();
                    return;
                case 1:
                    this.cxh = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion arA() {
        return this.cxh.arA();
    }

    public SwanAppConfigData arD() {
        return this.cxh.arD();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c nW(String str) {
        return this.cxh.nW(str);
    }

    public com.baidu.swan.apps.runtime.config.c nX(String str) {
        return this.cxh.nX(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cxh.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c arE() {
        return this.cxh.arE();
    }

    public String arF() {
        return this.cxh.arF();
    }

    public String arG() {
        return this.cxh.arG();
    }

    public String arH() {
        return this.cxh.arH();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f XX() {
        SwanAppActivity azC;
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null || (azC = azJ.azC()) == null) {
            return null;
        }
        return azC.XX();
    }

    public SwanAppActivity arI() {
        return this.cxh.arI();
    }

    public com.baidu.swan.games.view.d asb() {
        return this.cxh.ahL();
    }

    public com.baidu.swan.games.view.d asc() {
        return this.cxh.ahM();
    }

    public com.baidu.swan.apps.adaptation.b.e lT(String str) {
        return this.cxh.lT(str);
    }

    public AbsoluteLayout nY(String str) {
        return this.cxh.nY(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cxh.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.cxh.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cxh.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e ahn() {
        return this.cxh.ahn();
    }

    public String asd() {
        return ak.aFp().getPage();
    }

    public String agW() {
        return this.cxh.agW();
    }

    public com.baidu.swan.apps.adaptation.b.d arJ() {
        return this.cxh.arJ();
    }

    @NonNull
    public Pair<Integer, Integer> arK() {
        return this.cxh.arK();
    }

    @NonNull
    public Pair<Integer, Integer> arL() {
        return this.cxh.arL();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void ig(int i) {
        this.cxh.ig(i);
    }

    public void showLoadingView() {
        this.cxh.showLoadingView();
    }

    public void Ya() {
        this.cxh.Ya();
    }

    public long ase() {
        return cxf.get();
    }

    public void asf() {
        long incrementAndGet = cxf.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void asg() {
        long decrementAndGet = cxf.decrementAndGet();
        if (decrementAndGet <= 0) {
            cxg.cxh.arx();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void arw() {
            super.arw();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean arO() {
            return this.cwQ;
        }
    }

    public com.baidu.swan.games.q.a arM() {
        return this.cxh.arM();
    }
}
