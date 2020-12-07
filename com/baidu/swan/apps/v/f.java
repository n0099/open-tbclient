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
/* loaded from: classes25.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong deT = new AtomicLong(0);
    private static volatile f deU;
    private d deV = new a();

    private f() {
    }

    public static f aCp() {
        if (deU == null) {
            synchronized (f.class) {
                if (deU == null) {
                    deU = new f();
                }
            }
        }
        return deU;
    }

    boolean aCq() {
        return (this.deV == null || (this.deV instanceof a)) ? false : true;
    }

    public boolean aCr() {
        return aCq() && this.deV.aBZ() != null;
    }

    public void cN(Context context) {
        this.deV.cN(context);
    }

    public void cO(Context context) {
        this.deV.cO(context);
    }

    public void akN() {
        this.deV.akN();
    }

    public void akO() {
        this.deV.akO();
    }

    public void exit() {
        this.deV.exit();
    }

    public void aBP() {
        this.deV.aBP();
    }

    public void aBQ() {
        this.deV.aBQ();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (deU != null) {
                if (deU.deV != null) {
                    deU.deV.doRelease();
                }
                deU = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aqC() {
        return this.deV.aqC();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.deV.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.deV.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aBS() {
        return this.deV.aBS();
    }

    public FullScreenFloatView I(Activity activity) {
        return this.deV.I(activity);
    }

    public SwanAppPropertyWindow J(Activity activity) {
        return this.deV.J(activity);
    }

    public boolean aBT() {
        return this.deV.aBT();
    }

    public void w(Intent intent) {
        this.deV.w(intent);
    }

    public void akc() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.azB().akc();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aOY();
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.cl(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aCq()) {
            jD(swanAppActivity.aie());
        }
        if (aCq()) {
            this.deV.i(swanAppActivity);
        }
    }

    public void jD(int i) {
        if (!aCq()) {
            switch (i) {
                case 0:
                    this.deV = new c();
                    return;
                case 1:
                    this.deV = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion aBR() {
        return this.deV.aBR();
    }

    public SwanAppConfigData aBU() {
        return this.deV.aBU();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c qm(String str) {
        return this.deV.qm(str);
    }

    public com.baidu.swan.apps.runtime.config.c qn(String str) {
        return this.deV.qn(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.deV.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c aBV() {
        return this.deV.aBV();
    }

    public String aBW() {
        return this.deV.aBW();
    }

    public String aBX() {
        return this.deV.aBX();
    }

    public String aBY() {
        return this.deV.aBY();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f aim() {
        SwanAppActivity aJO;
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null || (aJO = aJV.aJO()) == null) {
            return null;
        }
        return aJO.aim();
    }

    public SwanAppActivity aBZ() {
        return this.deV.aBZ();
    }

    public com.baidu.swan.games.view.d aCs() {
        return this.deV.asa();
    }

    public com.baidu.swan.games.view.d aCt() {
        return this.deV.asb();
    }

    public com.baidu.swan.apps.adaptation.b.e oj(String str) {
        return this.deV.oj(str);
    }

    public AbsoluteLayout qo(String str) {
        return this.deV.qo(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.deV.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.deV.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.deV.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e arC() {
        return this.deV.arC();
    }

    public String aCu() {
        return ak.aPA().getPage();
    }

    public String arl() {
        return this.deV.arl();
    }

    public com.baidu.swan.apps.adaptation.b.d aCa() {
        return this.deV.aCa();
    }

    @NonNull
    public Pair<Integer, Integer> aCb() {
        return this.deV.aCb();
    }

    @NonNull
    public Pair<Integer, Integer> aCc() {
        return this.deV.aCc();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void jC(int i) {
        this.deV.jC(i);
    }

    public void showLoadingView() {
        this.deV.showLoadingView();
    }

    public void aip() {
        this.deV.aip();
    }

    public long aCv() {
        return deT.get();
    }

    public void aCw() {
        long incrementAndGet = deT.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void aCx() {
        long decrementAndGet = deT.decrementAndGet();
        if (decrementAndGet <= 0) {
            deU.deV.aBO();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void aBN() {
            super.aBN();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean aCf() {
            return this.deE;
        }
    }

    public com.baidu.swan.games.q.a aCd() {
        return this.deV.aCd();
    }
}
