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
    private static AtomicLong cLp = new AtomicLong(0);
    private static volatile f cLq;
    private d cLr = new a();

    private f() {
    }

    public static f avu() {
        if (cLq == null) {
            synchronized (f.class) {
                if (cLq == null) {
                    cLq = new f();
                }
            }
        }
        return cLq;
    }

    boolean avv() {
        return (this.cLr == null || (this.cLr instanceof a)) ? false : true;
    }

    public boolean avw() {
        return avv() && this.cLr.ave() != null;
    }

    public void ch(Context context) {
        this.cLr.ch(context);
    }

    public void ci(Context context) {
        this.cLr.ci(context);
    }

    public void adT() {
        this.cLr.adT();
    }

    public void adU() {
        this.cLr.adU();
    }

    public void exit() {
        this.cLr.exit();
    }

    public void auU() {
        this.cLr.auU();
    }

    public void auV() {
        this.cLr.auV();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cLq != null) {
                if (cLq.cLr != null) {
                    cLq.cLr.doRelease();
                }
                cLq = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e ajI() {
        return this.cLr.ajI();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cLr.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cLr.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a auX() {
        return this.cLr.auX();
    }

    public FullScreenFloatView J(Activity activity) {
        return this.cLr.J(activity);
    }

    public SwanAppPropertyWindow K(Activity activity) {
        return this.cLr.K(activity);
    }

    public boolean auY() {
        return this.cLr.auY();
    }

    public void w(Intent intent) {
        this.cLr.w(intent);
    }

    public void adi() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.asH().adi();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aIf();
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
        if (swanAppActivity != null && !avv()) {
            iO(swanAppActivity.abk());
        }
        if (avv()) {
            this.cLr.i(swanAppActivity);
        }
    }

    public void iO(int i) {
        if (!avv()) {
            switch (i) {
                case 0:
                    this.cLr = new c();
                    return;
                case 1:
                    this.cLr = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion auW() {
        return this.cLr.auW();
    }

    public SwanAppConfigData auZ() {
        return this.cLr.auZ();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c pe(String str) {
        return this.cLr.pe(str);
    }

    public com.baidu.swan.apps.runtime.config.c pf(String str) {
        return this.cLr.pf(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cLr.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c ava() {
        return this.cLr.ava();
    }

    public String avb() {
        return this.cLr.avb();
    }

    public String avc() {
        return this.cLr.avc();
    }

    public String avd() {
        return this.cLr.avd();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f abs() {
        SwanAppActivity aCU;
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null || (aCU = aDb.aCU()) == null) {
            return null;
        }
        return aCU.abs();
    }

    public SwanAppActivity ave() {
        return this.cLr.ave();
    }

    public com.baidu.swan.games.view.d avx() {
        return this.cLr.alg();
    }

    public com.baidu.swan.games.view.d avy() {
        return this.cLr.alh();
    }

    public com.baidu.swan.apps.adaptation.b.e mZ(String str) {
        return this.cLr.mZ(str);
    }

    public AbsoluteLayout pg(String str) {
        return this.cLr.pg(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cLr.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.cLr.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cLr.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e akI() {
        return this.cLr.akI();
    }

    public String avz() {
        return ak.aII().getPage();
    }

    public String akr() {
        return this.cLr.akr();
    }

    public com.baidu.swan.apps.adaptation.b.d avf() {
        return this.cLr.avf();
    }

    @NonNull
    public Pair<Integer, Integer> avg() {
        return this.cLr.avg();
    }

    @NonNull
    public Pair<Integer, Integer> avh() {
        return this.cLr.avh();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void iN(int i) {
        this.cLr.iN(i);
    }

    public void showLoadingView() {
        this.cLr.showLoadingView();
    }

    public void abv() {
        this.cLr.abv();
    }

    public long avA() {
        return cLp.get();
    }

    public void avB() {
        long incrementAndGet = cLp.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void avC() {
        long decrementAndGet = cLp.decrementAndGet();
        if (decrementAndGet <= 0) {
            cLq.cLr.auT();
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
        protected void auS() {
            super.auS();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean avk() {
            return this.cLa;
        }
    }

    public com.baidu.swan.games.q.a avi() {
        return this.cLr.avi();
    }
}
