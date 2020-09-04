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
    private static AtomicLong cxj = new AtomicLong(0);
    private static volatile f cxk;
    private d cxl = new a();

    private f() {
    }

    public static f arY() {
        if (cxk == null) {
            synchronized (f.class) {
                if (cxk == null) {
                    cxk = new f();
                }
            }
        }
        return cxk;
    }

    boolean arZ() {
        return (this.cxl == null || (this.cxl instanceof a)) ? false : true;
    }

    public boolean asa() {
        return arZ() && this.cxl.arI() != null;
    }

    public void cc(Context context) {
        this.cxl.cc(context);
    }

    public void cd(Context context) {
        this.cxl.cd(context);
    }

    public void aay() {
        this.cxl.aay();
    }

    public void aaz() {
        this.cxl.aaz();
    }

    public void exit() {
        this.cxl.exit();
    }

    public void ary() {
        this.cxl.ary();
    }

    public void arz() {
        this.cxl.arz();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cxk != null) {
                if (cxk.cxl != null) {
                    cxk.cxl.doRelease();
                }
                cxk = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e agn() {
        return this.cxl.agn();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cxl.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cxl.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a arB() {
        return this.cxl.arB();
    }

    public FullScreenFloatView H(Activity activity) {
        return this.cxl.H(activity);
    }

    public SwanAppPropertyWindow I(Activity activity) {
        return this.cxl.I(activity);
    }

    public boolean arC() {
        return this.cxl.arC();
    }

    public void w(Intent intent) {
        this.cxl.w(intent);
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
            this.cxl.i(swanAppActivity);
        }
    }

    public void ih(int i) {
        if (!arZ()) {
            switch (i) {
                case 0:
                    this.cxl = new c();
                    return;
                case 1:
                    this.cxl = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion arA() {
        return this.cxl.arA();
    }

    public SwanAppConfigData arD() {
        return this.cxl.arD();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c nX(String str) {
        return this.cxl.nX(str);
    }

    public com.baidu.swan.apps.runtime.config.c nY(String str) {
        return this.cxl.nY(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cxl.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c arE() {
        return this.cxl.arE();
    }

    public String arF() {
        return this.cxl.arF();
    }

    public String arG() {
        return this.cxl.arG();
    }

    public String arH() {
        return this.cxl.arH();
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
        return this.cxl.arI();
    }

    public com.baidu.swan.games.view.d asb() {
        return this.cxl.ahL();
    }

    public com.baidu.swan.games.view.d asc() {
        return this.cxl.ahM();
    }

    public com.baidu.swan.apps.adaptation.b.e lU(String str) {
        return this.cxl.lU(str);
    }

    public AbsoluteLayout nZ(String str) {
        return this.cxl.nZ(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cxl.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.cxl.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cxl.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e ahn() {
        return this.cxl.ahn();
    }

    public String asd() {
        return ak.aFp().getPage();
    }

    public String agW() {
        return this.cxl.agW();
    }

    public com.baidu.swan.apps.adaptation.b.d arJ() {
        return this.cxl.arJ();
    }

    @NonNull
    public Pair<Integer, Integer> arK() {
        return this.cxl.arK();
    }

    @NonNull
    public Pair<Integer, Integer> arL() {
        return this.cxl.arL();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void ig(int i) {
        this.cxl.ig(i);
    }

    public void showLoadingView() {
        this.cxl.showLoadingView();
    }

    public void Ya() {
        this.cxl.Ya();
    }

    public long ase() {
        return cxj.get();
    }

    public void asf() {
        long incrementAndGet = cxj.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void asg() {
        long decrementAndGet = cxj.decrementAndGet();
        if (decrementAndGet <= 0) {
            cxk.cxl.arx();
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
            return this.cwU;
        }
    }

    public com.baidu.swan.games.q.a arM() {
        return this.cxl.arM();
    }
}
