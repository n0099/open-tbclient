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
/* loaded from: classes9.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static AtomicLong djN = new AtomicLong(0);
    private static volatile f djO;
    private d djP = new a();

    private f() {
    }

    public static f aDH() {
        if (djO == null) {
            synchronized (f.class) {
                if (djO == null) {
                    djO = new f();
                }
            }
        }
        return djO;
    }

    boolean aDI() {
        return (this.djP == null || (this.djP instanceof a)) ? false : true;
    }

    public boolean aDJ() {
        return aDI() && this.djP.aDr() != null;
    }

    public void cV(Context context) {
        this.djP.cV(context);
    }

    public void cW(Context context) {
        this.djP.cW(context);
    }

    public void alY() {
        this.djP.alY();
    }

    public void alZ() {
        this.djP.alZ();
    }

    public void exit() {
        this.djP.exit();
    }

    public void aDh() {
        this.djP.aDh();
    }

    public void aDi() {
        this.djP.aDi();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (djO != null) {
                if (djO.djP != null) {
                    djO.djP.doRelease();
                }
                djO = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e arP() {
        return this.djP.arP();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.djP.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.djP.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aDk() {
        return this.djP.aDk();
    }

    public FullScreenFloatView H(Activity activity) {
        return this.djP.H(activity);
    }

    public SwanAppPropertyWindow I(Activity activity) {
        return this.djP.I(activity);
    }

    public boolean aDl() {
        return this.djP.aDl();
    }

    public void w(Intent intent) {
        this.djP.w(intent);
    }

    public void all() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.aAT().all();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aRq();
        p.b(new Runnable() { // from class: com.baidu.swan.apps.v.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.e.cs(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aDI()) {
            jy(swanAppActivity.ajl());
        }
        if (aDI()) {
            this.djP.i(swanAppActivity);
        }
    }

    public void jy(int i) {
        if (!aDI()) {
            switch (i) {
                case 0:
                    this.djP = new c();
                    return;
                case 1:
                    this.djP = new com.baidu.swan.games.p.a();
                    return;
                default:
                    return;
            }
        }
    }

    public SwanCoreVersion aDj() {
        return this.djP.aDj();
    }

    public SwanAppConfigData aDm() {
        return this.djP.aDm();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c qf(String str) {
        return this.djP.qf(str);
    }

    public com.baidu.swan.apps.runtime.config.c qg(String str) {
        return this.djP.qg(str);
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return this.djP.a(str, swanAppConfigData, str2);
    }

    public com.baidu.swan.apps.storage.b.c aDn() {
        return this.djP.aDn();
    }

    public String aDo() {
        return this.djP.aDo();
    }

    public String aDp() {
        return this.djP.aDp();
    }

    public String aDq() {
        return this.djP.aDq();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f ajt() {
        SwanAppActivity aMf;
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm == null || (aMf = aMm.aMf()) == null) {
            return null;
        }
        return aMf.ajt();
    }

    public SwanAppActivity aDr() {
        return this.djP.aDr();
    }

    public com.baidu.swan.games.view.d aDK() {
        return this.djP.att();
    }

    public com.baidu.swan.games.view.d aDL() {
        return this.djP.atu();
    }

    public com.baidu.swan.apps.adaptation.b.e ob(String str) {
        return this.djP.ob(str);
    }

    public AbsoluteLayout qh(String str) {
        return this.djP.qh(str);
    }

    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        this.djP.a(dVar, z);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        this.djP.b(aVar);
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        this.djP.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.e asV() {
        return this.djP.asV();
    }

    public String aDM() {
        return ak.aRS().getPage();
    }

    public String asE() {
        return this.djP.asE();
    }

    public com.baidu.swan.apps.adaptation.b.d aDs() {
        return this.djP.aDs();
    }

    @NonNull
    public Pair<Integer, Integer> aDt() {
        return this.djP.aDt();
    }

    @NonNull
    public Pair<Integer, Integer> aDu() {
        return this.djP.aDu();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void jx(int i) {
        this.djP.jx(i);
    }

    public void showLoadingView() {
        this.djP.showLoadingView();
    }

    public void ajw() {
        this.djP.ajw();
    }

    public long aDN() {
        return djN.get();
    }

    public void aDO() {
        long incrementAndGet = djN.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void aDP() {
        long decrementAndGet = djN.decrementAndGet();
        if (decrementAndGet <= 0) {
            djO.djP.aDg();
        }
        if (DEBUG) {
            Log.i("SwanAppController", "decrementBgThreadAliveCount: " + decrementAndGet);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.v.b
        protected void aDf() {
            super.aDf();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean aDx() {
            return this.djy;
        }
    }

    public com.baidu.swan.games.q.a aDv() {
        return this.djP.aDv();
    }
}
