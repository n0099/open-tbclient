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
/* loaded from: classes10.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong cTL = new AtomicLong(0);
    private static volatile f cTM;
    private d cTN = new a();

    private f() {
    }

    public static f axo() {
        if (cTM == null) {
            synchronized (f.class) {
                if (cTM == null) {
                    cTM = new f();
                }
            }
        }
        return cTM;
    }

    boolean axp() {
        return (this.cTN == null || (this.cTN instanceof a)) ? false : true;
    }

    public boolean axq() {
        return axp() && this.cTN.awY() != null;
    }

    public void ch(Context context) {
        this.cTN.ch(context);
    }

    public void ci(Context context) {
        this.cTN.ci(context);
    }

    public void afN() {
        this.cTN.afN();
    }

    public void afO() {
        this.cTN.afO();
    }

    public void exit() {
        this.cTN.exit();
    }

    public void awO() {
        this.cTN.awO();
    }

    public void awP() {
        this.cTN.awP();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cTM != null) {
                if (cTM.cTN != null) {
                    cTM.cTN.doRelease();
                }
                cTM = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e alC() {
        return this.cTN.alC();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cTN.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cTN.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a awR() {
        return this.cTN.awR();
    }

    public FullScreenFloatView J(Activity activity) {
        return this.cTN.J(activity);
    }

    public SwanAppPropertyWindow K(Activity activity) {
        return this.cTN.K(activity);
    }

    public boolean awS() {
        return this.cTN.awS();
    }

    public void w(Intent intent) {
        this.cTN.w(intent);
    }

    public void afc() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.auB().afc();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aJZ();
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.bF(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !axp()) {
            iZ(swanAppActivity.ade());
        }
        if (axp()) {
            this.cTN.i(swanAppActivity);
        }
    }

    public void iZ(int i) {
        if (!axp()) {
            switch (i) {
                case 0:
                    this.cTN = new c();
                    return;
                case 1:
                    this.cTN = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion awQ() {
        return this.cTN.awQ();
    }

    public SwanAppConfigData awT() {
        return this.cTN.awT();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c px(String str) {
        return this.cTN.px(str);
    }

    public com.baidu.swan.apps.runtime.config.c py(String str) {
        return this.cTN.py(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cTN.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c awU() {
        return this.cTN.awU();
    }

    public String awV() {
        return this.cTN.awV();
    }

    public String awW() {
        return this.cTN.awW();
    }

    public String awX() {
        return this.cTN.awX();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f adm() {
        SwanAppActivity aEO;
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null || (aEO = aEV.aEO()) == null) {
            return null;
        }
        return aEO.adm();
    }

    public SwanAppActivity awY() {
        return this.cTN.awY();
    }

    public com.baidu.swan.games.view.d axr() {
        return this.cTN.ana();
    }

    public com.baidu.swan.games.view.d axs() {
        return this.cTN.anb();
    }

    public com.baidu.swan.apps.adaptation.b.e ns(String str) {
        return this.cTN.ns(str);
    }

    public AbsoluteLayout pz(String str) {
        return this.cTN.pz(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cTN.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.cTN.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cTN.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e amC() {
        return this.cTN.amC();
    }

    public String axt() {
        return ak.aKC().getPage();
    }

    public String aml() {
        return this.cTN.aml();
    }

    public com.baidu.swan.apps.adaptation.b.d awZ() {
        return this.cTN.awZ();
    }

    @NonNull
    public Pair<Integer, Integer> axa() {
        return this.cTN.axa();
    }

    @NonNull
    public Pair<Integer, Integer> axb() {
        return this.cTN.axb();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void iY(int i) {
        this.cTN.iY(i);
    }

    public void showLoadingView() {
        this.cTN.showLoadingView();
    }

    public void adp() {
        this.cTN.adp();
    }

    public long axu() {
        return cTL.get();
    }

    public void axv() {
        long incrementAndGet = cTL.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void axw() {
        long decrementAndGet = cTL.decrementAndGet();
        if (decrementAndGet <= 0) {
            cTM.cTN.awN();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void awM() {
            super.awM();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean axe() {
            return this.cTw;
        }
    }

    public com.baidu.swan.games.q.a axc() {
        return this.cTN.axc();
    }
}
