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
    private static AtomicLong cZE = new AtomicLong(0);
    private static volatile f cZF;
    private d cZG = new a();

    private f() {
    }

    public static f azO() {
        if (cZF == null) {
            synchronized (f.class) {
                if (cZF == null) {
                    cZF = new f();
                }
            }
        }
        return cZF;
    }

    boolean azP() {
        return (this.cZG == null || (this.cZG instanceof a)) ? false : true;
    }

    public boolean azQ() {
        return azP() && this.cZG.azy() != null;
    }

    public void ch(Context context) {
        this.cZG.ch(context);
    }

    public void ci(Context context) {
        this.cZG.ci(context);
    }

    public void ain() {
        this.cZG.ain();
    }

    public void aio() {
        this.cZG.aio();
    }

    public void exit() {
        this.cZG.exit();
    }

    public void azo() {
        this.cZG.azo();
    }

    public void azp() {
        this.cZG.azp();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (cZF != null) {
                if (cZF.cZG != null) {
                    cZF.cZG.doRelease();
                }
                cZF = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e aoc() {
        return this.cZG.aoc();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cZG.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.cZG.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azr() {
        return this.cZG.azr();
    }

    public FullScreenFloatView J(Activity activity) {
        return this.cZG.J(activity);
    }

    public SwanAppPropertyWindow K(Activity activity) {
        return this.cZG.K(activity);
    }

    public boolean azs() {
        return this.cZG.azs();
    }

    public void w(Intent intent) {
        this.cZG.w(intent);
    }

    public void ahC() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.axb().ahC();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aMz();
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
        if (swanAppActivity != null && !azP()) {
            jj(swanAppActivity.afE());
        }
        if (azP()) {
            this.cZG.i(swanAppActivity);
        }
    }

    public void jj(int i) {
        if (!azP()) {
            switch (i) {
                case 0:
                    this.cZG = new c();
                    return;
                case 1:
                    this.cZG = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion azq() {
        return this.cZG.azq();
    }

    public SwanAppConfigData azt() {
        return this.cZG.azt();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c pL(String str) {
        return this.cZG.pL(str);
    }

    public com.baidu.swan.apps.runtime.config.c pM(String str) {
        return this.cZG.pM(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.cZG.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c azu() {
        return this.cZG.azu();
    }

    public String azv() {
        return this.cZG.azv();
    }

    public String azw() {
        return this.cZG.azw();
    }

    public String azx() {
        return this.cZG.azx();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f afM() {
        SwanAppActivity aHo;
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null || (aHo = aHv.aHo()) == null) {
            return null;
        }
        return aHo.afM();
    }

    public SwanAppActivity azy() {
        return this.cZG.azy();
    }

    public com.baidu.swan.games.view.d azR() {
        return this.cZG.apB();
    }

    public com.baidu.swan.games.view.d azS() {
        return this.cZG.apC();
    }

    public com.baidu.swan.apps.adaptation.b.e nH(String str) {
        return this.cZG.nH(str);
    }

    public AbsoluteLayout pN(String str) {
        return this.cZG.pN(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.cZG.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.cZG.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.cZG.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e apc() {
        return this.cZG.apc();
    }

    public String azT() {
        return ak.aNc().getPage();
    }

    public String aoL() {
        return this.cZG.aoL();
    }

    public com.baidu.swan.apps.adaptation.b.d azz() {
        return this.cZG.azz();
    }

    @NonNull
    public Pair<Integer, Integer> azA() {
        return this.cZG.azA();
    }

    @NonNull
    public Pair<Integer, Integer> azB() {
        return this.cZG.azB();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void ji(int i) {
        this.cZG.ji(i);
    }

    public void showLoadingView() {
        this.cZG.showLoadingView();
    }

    public void afP() {
        this.cZG.afP();
    }

    public long azU() {
        return cZE.get();
    }

    public void azV() {
        long incrementAndGet = cZE.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void azW() {
        long decrementAndGet = cZE.decrementAndGet();
        if (decrementAndGet <= 0) {
            cZF.cZG.azn();
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
        protected void azm() {
            super.azm();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean azE() {
            return this.cZp;
        }
    }

    public com.baidu.swan.games.q.a azC() {
        return this.cZG.azC();
    }
}
