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
/* loaded from: classes7.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong cXU = new AtomicLong(0);
    private static volatile f cXV;
    private d cXW = new a();

    private f() {
    }

    public static f azg() {
        if (cXV == null) {
            synchronized (f.class) {
                if (cXV == null) {
                    cXV = new f();
                }
            }
        }
        return cXV;
    }

    boolean azh() {
        return (this.cXW == null || (this.cXW instanceof a)) ? false : true;
    }

    public boolean azi() {
        return azh() && this.cXW.ayQ() != null;
    }

    public void ch(Context context) {
        this.cXW.ch(context);
    }

    public void ci(Context context) {
        this.cXW.ci(context);
    }

    public void ahF() {
        this.cXW.ahF();
    }

    public void ahG() {
        this.cXW.ahG();
    }

    public void exit() {
        this.cXW.exit();
    }

    public void ayG() {
        this.cXW.ayG();
    }

    public void ayH() {
        this.cXW.ayH();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cXV != null) {
                if (cXV.cXW != null) {
                    cXV.cXW.doRelease();
                }
                cXV = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e anu() {
        return this.cXW.anu();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cXW.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cXW.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a ayJ() {
        return this.cXW.ayJ();
    }

    public FullScreenFloatView I(Activity activity) {
        return this.cXW.I(activity);
    }

    public SwanAppPropertyWindow J(Activity activity) {
        return this.cXW.J(activity);
    }

    public boolean ayK() {
        return this.cXW.ayK();
    }

    public void w(Intent intent) {
        this.cXW.w(intent);
    }

    public void agU() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.awt().agU();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aLR();
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
        if (swanAppActivity != null && !azh()) {
            jf(swanAppActivity.aeW());
        }
        if (azh()) {
            this.cXW.i(swanAppActivity);
        }
    }

    public void jf(int i) {
        if (!azh()) {
            switch (i) {
                case 0:
                    this.cXW = new c();
                    return;
                case 1:
                    this.cXW = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion ayI() {
        return this.cXW.ayI();
    }

    public SwanAppConfigData ayL() {
        return this.cXW.ayL();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c pF(String str) {
        return this.cXW.pF(str);
    }

    public com.baidu.swan.apps.runtime.config.c pG(String str) {
        return this.cXW.pG(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cXW.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c ayM() {
        return this.cXW.ayM();
    }

    public String ayN() {
        return this.cXW.ayN();
    }

    public String ayO() {
        return this.cXW.ayO();
    }

    public String ayP() {
        return this.cXW.ayP();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f afe() {
        SwanAppActivity aGG;
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null || (aGG = aGN.aGG()) == null) {
            return null;
        }
        return aGG.afe();
    }

    public SwanAppActivity ayQ() {
        return this.cXW.ayQ();
    }

    public com.baidu.swan.games.view.d azj() {
        return this.cXW.aoS();
    }

    public com.baidu.swan.games.view.d azk() {
        return this.cXW.aoT();
    }

    public com.baidu.swan.apps.adaptation.b.e nB(String str) {
        return this.cXW.nB(str);
    }

    public AbsoluteLayout pH(String str) {
        return this.cXW.pH(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cXW.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.cXW.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cXW.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e aou() {
        return this.cXW.aou();
    }

    public String azl() {
        return ak.aMu().getPage();
    }

    public String aod() {
        return this.cXW.aod();
    }

    public com.baidu.swan.apps.adaptation.b.d ayR() {
        return this.cXW.ayR();
    }

    @NonNull
    public Pair<Integer, Integer> ayS() {
        return this.cXW.ayS();
    }

    @NonNull
    public Pair<Integer, Integer> ayT() {
        return this.cXW.ayT();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void je(int i) {
        this.cXW.je(i);
    }

    public void showLoadingView() {
        this.cXW.showLoadingView();
    }

    public void afh() {
        this.cXW.afh();
    }

    public long azm() {
        return cXU.get();
    }

    public void azn() {
        long incrementAndGet = cXU.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void azo() {
        long decrementAndGet = cXU.decrementAndGet();
        if (decrementAndGet <= 0) {
            cXV.cXW.ayF();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void ayE() {
            super.ayE();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean ayW() {
            return this.cXF;
        }
    }

    public com.baidu.swan.games.q.a ayU() {
        return this.cXW.ayU();
    }
}
