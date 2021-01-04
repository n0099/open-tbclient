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

    public static f aDG() {
        if (djO == null) {
            synchronized (f.class) {
                if (djO == null) {
                    djO = new f();
                }
            }
        }
        return djO;
    }

    boolean aDH() {
        return (this.djP == null || (this.djP instanceof a)) ? false : true;
    }

    public boolean aDI() {
        return aDH() && this.djP.aDq() != null;
    }

    public void cV(Context context) {
        this.djP.cV(context);
    }

    public void cW(Context context) {
        this.djP.cW(context);
    }

    public void alX() {
        this.djP.alX();
    }

    public void alY() {
        this.djP.alY();
    }

    public void exit() {
        this.djP.exit();
    }

    public void aDg() {
        this.djP.aDg();
    }

    public void aDh() {
        this.djP.aDh();
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
    public com.baidu.swan.apps.runtime.e arO() {
        return this.djP.arO();
    }

    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.djP.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        this.djP.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aDj() {
        return this.djP.aDj();
    }

    public FullScreenFloatView H(Activity activity) {
        return this.djP.H(activity);
    }

    public SwanAppPropertyWindow I(Activity activity) {
        return this.djP.I(activity);
    }

    public boolean aDk() {
        return this.djP.aDk();
    }

    public void w(Intent intent) {
        this.djP.w(intent);
    }

    public void alk() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.t.a.aAS().alk();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        p.aRp();
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
        if (swanAppActivity != null && !aDH()) {
            jy(swanAppActivity.ajk());
        }
        if (aDH()) {
            this.djP.i(swanAppActivity);
        }
    }

    public void jy(int i) {
        if (!aDH()) {
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

    public SwanCoreVersion aDi() {
        return this.djP.aDi();
    }

    public SwanAppConfigData aDl() {
        return this.djP.aDl();
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

    public com.baidu.swan.apps.storage.b.c aDm() {
        return this.djP.aDm();
    }

    public String aDn() {
        return this.djP.aDn();
    }

    public String aDo() {
        return this.djP.aDo();
    }

    public String aDp() {
        return this.djP.aDp();
    }

    @Nullable
    public com.baidu.swan.apps.core.d.f ajs() {
        SwanAppActivity aMe;
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null || (aMe = aMl.aMe()) == null) {
            return null;
        }
        return aMe.ajs();
    }

    public SwanAppActivity aDq() {
        return this.djP.aDq();
    }

    public com.baidu.swan.games.view.d aDJ() {
        return this.djP.ats();
    }

    public com.baidu.swan.games.view.d aDK() {
        return this.djP.att();
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

    public com.baidu.swan.apps.core.d.e asU() {
        return this.djP.asU();
    }

    public String aDL() {
        return ak.aRR().getPage();
    }

    public String asD() {
        return this.djP.asD();
    }

    public com.baidu.swan.apps.adaptation.b.d aDr() {
        return this.djP.aDr();
    }

    @NonNull
    public Pair<Integer, Integer> aDs() {
        return this.djP.aDs();
    }

    @NonNull
    public Pair<Integer, Integer> aDt() {
        return this.djP.aDt();
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void jx(int i) {
        this.djP.jx(i);
    }

    public void showLoadingView() {
        this.djP.showLoadingView();
    }

    public void ajv() {
        this.djP.ajv();
    }

    public long aDM() {
        return djN.get();
    }

    public void aDN() {
        long incrementAndGet = djN.incrementAndGet();
        if (DEBUG) {
            Log.i("SwanAppController", "incrementBgThreadAliveCount: " + incrementAndGet);
        }
    }

    public void aDO() {
        long decrementAndGet = djN.decrementAndGet();
        if (decrementAndGet <= 0) {
            djO.djP.aDf();
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
        protected void aDe() {
            super.aDe();
        }

        @Override // com.baidu.swan.apps.v.d
        public boolean aDw() {
            return this.djy;
        }
    }

    public com.baidu.swan.games.q.a aDu() {
        return this.djP.aDu();
    }
}
