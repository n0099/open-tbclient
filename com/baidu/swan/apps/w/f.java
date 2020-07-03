package com.baidu.swan.apps.w;

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
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes11.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong cnp = new AtomicLong(0);
    private static volatile f cnq;
    private d cnr = new a();

    private f() {
    }

    public static f ajb() {
        if (cnq == null) {
            synchronized (f.class) {
                if (cnq == null) {
                    cnq = new f();
                }
            }
        }
        return cnq;
    }

    boolean ajc() {
        return (this.cnr == null || (this.cnr instanceof a)) ? false : true;
    }

    public boolean ajd() {
        return ajc() && this.cnr.aiL() != null;
    }

    public void bT(Context context) {
        this.cnr.bT(context);
    }

    public void bU(Context context) {
        this.cnr.bU(context);
    }

    public void TW() {
        this.cnr.TW();
    }

    public void TX() {
        this.cnr.TX();
    }

    public void exit() {
        this.cnr.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.cnr.a(i, strArr, aVar);
    }

    public void aiB() {
        this.cnr.aiB();
    }

    public void aiC() {
        this.cnr.aiC();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cnq != null) {
                if (cnq.cnr != null) {
                    cnq.cnr.doRelease();
                }
                cnq = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aai() {
        return this.cnr.aai();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cnr.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cnr.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aiE() {
        return this.cnr.aiE();
    }

    public FullScreenFloatView I(Activity activity) {
        return this.cnr.I(activity);
    }

    public SwanAppPropertyWindow J(Activity activity) {
        return this.cnr.J(activity);
    }

    public boolean aiF() {
        return this.cnr.aiF();
    }

    public void u(Intent intent) {
        this.cnr.u(intent);
    }

    public void Tn() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.agw().Tn();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        n.auA();
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.w.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bq(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void h(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !ajc()) {
            fT(swanAppActivity.RF());
        }
        if (ajc()) {
            this.cnr.h(swanAppActivity);
        }
    }

    public void fT(int i) {
        if (!ajc()) {
            switch (i) {
                case 0:
                    this.cnr = new c();
                    return;
                case 1:
                    this.cnr = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion aiD() {
        return this.cnr.aiD();
    }

    public SwanAppConfigData aiG() {
        return this.cnr.aiG();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c ly(String str) {
        return this.cnr.ly(str);
    }

    public com.baidu.swan.apps.runtime.config.c lz(String str) {
        return this.cnr.lz(str);
    }

    public com.baidu.swan.apps.storage.b.c aiH() {
        return this.cnr.aiH();
    }

    public String aiI() {
        return this.cnr.aiI();
    }

    public String aiJ() {
        return this.cnr.aiJ();
    }

    public String aiK() {
        return this.cnr.aiK();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.e RN() {
        SwanAppActivity apG;
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null || (apG = apN.apG()) == null) {
            return null;
        }
        return apG.RN();
    }

    public SwanAppActivity aiL() {
        return this.cnr.aiL();
    }

    public com.baidu.swan.games.view.d aje() {
        return this.cnr.aax();
    }

    public com.baidu.swan.games.view.d ajf() {
        return this.cnr.aay();
    }

    public com.baidu.swan.apps.adaptation.b.e jW(String str) {
        return this.cnr.jW(str);
    }

    public AbsoluteLayout lA(String str) {
        return this.cnr.lA(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cnr.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        this.cnr.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cnr.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d ZW() {
        return this.cnr.ZW();
    }

    public String ajg() {
        return aj.ava().getPage();
    }

    public String ZH() {
        return this.cnr.ZH();
    }

    public com.baidu.swan.apps.adaptation.b.d aiM() {
        return this.cnr.aiM();
    }

    @NonNull
    public Pair<Integer, Integer> aiN() {
        return this.cnr.aiN();
    }

    @NonNull
    public Pair<Integer, Integer> aiO() {
        return this.cnr.aiO();
    }

    @Override // com.baidu.swan.apps.w.e.b
    public void fS(int i) {
        this.cnr.fS(i);
    }

    public void showLoadingView() {
        this.cnr.showLoadingView();
    }

    public void RQ() {
        this.cnr.RQ();
    }

    public long ajh() {
        return cnp.get();
    }

    public void aji() {
        long incrementAndGet = cnp.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void ajj() {
        long decrementAndGet = cnp.decrementAndGet();
        if (decrementAndGet <= 0) {
            cnq.cnr.aiA();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.w.b
        protected void aiz() {
            super.aiz();
        }

        @Override // com.baidu.swan.apps.w.d
        public boolean aiR() {
            return this.cnb;
        }
    }

    public com.baidu.swan.games.q.a aiP() {
        return this.cnr.aiP();
    }
}
