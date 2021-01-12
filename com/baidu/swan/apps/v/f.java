package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.e;
import java.util.concurrent.atomic.AtomicLong;
/* loaded from: classes8.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong deY = new AtomicLong(0);
    private static volatile f deZ;
    private d dfa = new a();

    private f() {
    }

    public static f azN() {
        if (deZ == null) {
            synchronized (f.class) {
                if (deZ == null) {
                    deZ = new f();
                }
            }
        }
        return deZ;
    }

    boolean azO() {
        return (this.dfa == null || (this.dfa instanceof a)) ? false : true;
    }

    public boolean azP() {
        return azO() && this.dfa.azx() != null;
    }

    public void cU(Context context) {
        this.dfa.cU(context);
    }

    public void cV(Context context) {
        this.dfa.cV(context);
    }

    public void aie() {
        this.dfa.aie();
    }

    public void aif() {
        this.dfa.aif();
    }

    public void exit() {
        this.dfa.exit();
    }

    public void azn() {
        this.dfa.azn();
    }

    public void azo() {
        this.dfa.azo();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (deZ != null) {
                if (deZ.dfa != null) {
                    deZ.dfa.doRelease();
                }
                deZ = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e anU() {
        return this.dfa.anU();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.dfa.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.dfa.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azq() {
        return this.dfa.azq();
    }

    public FullScreenFloatView H(Activity activity) {
        return this.dfa.H(activity);
    }

    public SwanAppPropertyWindow I(Activity activity) {
        return this.dfa.I(activity);
    }

    public boolean azr() {
        return this.dfa.azr();
    }

    public void w(Intent intent) {
        this.dfa.w(intent);
    }

    public void ahr() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.awZ().ahr();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aNw();
        p.b(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.cr(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !azO()) {
            hS(swanAppActivity.afr());
        }
        if (azO()) {
            this.dfa.i(swanAppActivity);
        }
    }

    public void hS(int i) {
        if (!azO()) {
            switch (i) {
                case 0:
                    this.dfa = new c();
                    return;
                case 1:
                    this.dfa = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion azp() {
        return this.dfa.azp();
    }

    public SwanAppConfigData azs() {
        return this.dfa.azs();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c oU(String str) {
        return this.dfa.oU(str);
    }

    public com.baidu.swan.apps.runtime.config.c oV(String str) {
        return this.dfa.oV(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.dfa.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c azt() {
        return this.dfa.azt();
    }

    public String azu() {
        return this.dfa.azu();
    }

    public String azv() {
        return this.dfa.azv();
    }

    public String azw() {
        return this.dfa.azw();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f afz() {
        SwanAppActivity aIl;
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null || (aIl = aIs.aIl()) == null) {
            return null;
        }
        return aIl.afz();
    }

    public SwanAppActivity azx() {
        return this.dfa.azx();
    }

    public com.baidu.swan.games.view.d azQ() {
        return this.dfa.apy();
    }

    public com.baidu.swan.games.view.d azR() {
        return this.dfa.apz();
    }

    public com.baidu.swan.apps.adaptation.b.e mQ(String str) {
        return this.dfa.mQ(str);
    }

    public AbsoluteLayout oW(String str) {
        return this.dfa.oW(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.dfa.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.dfa.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.dfa.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e aoZ() {
        return this.dfa.aoZ();
    }

    public String azS() {
        return ak.aNY().getPage();
    }

    public String aoI() {
        return this.dfa.aoI();
    }

    public com.baidu.swan.apps.adaptation.b.d azy() {
        return this.dfa.azy();
    }

    @NonNull
    public Pair<Integer, Integer> azz() {
        return this.dfa.azz();
    }

    @NonNull
    public Pair<Integer, Integer> azA() {
        return this.dfa.azA();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void hR(int i) {
        this.dfa.hR(i);
    }

    public void showLoadingView() {
        this.dfa.showLoadingView();
    }

    public void afC() {
        this.dfa.afC();
    }

    public long azT() {
        return deY.get();
    }

    public void azU() {
        long incrementAndGet = deY.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void azV() {
        long decrementAndGet = deY.decrementAndGet();
        if (decrementAndGet <= 0) {
            deZ.dfa.azm();
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
        protected void azl() {
            super.azl();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean azD() {
            return this.deJ;
        }
    }

    public com.baidu.swan.games.q.a azB() {
        return this.dfa.azB();
    }
}
