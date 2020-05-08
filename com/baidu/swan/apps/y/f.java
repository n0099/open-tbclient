package com.baidu.swan.apps.y;

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
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.y.e;
/* loaded from: classes11.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f bYa;
    private d bYb = new a();

    private f() {
    }

    public static f aeJ() {
        if (bYa == null) {
            synchronized (f.class) {
                if (bYa == null) {
                    bYa = new f();
                }
            }
        }
        return bYa;
    }

    boolean aeK() {
        return (this.bYb == null || (this.bYb instanceof a)) ? false : true;
    }

    public boolean aeL() {
        return aeK() && this.bYb.aeu() != null;
    }

    public void bH(Context context) {
        this.bYb.bH(context);
    }

    public void bI(Context context) {
        this.bYb.bI(context);
    }

    public void Qm() {
        this.bYb.Qm();
    }

    public void Qn() {
        this.bYb.Qn();
    }

    public void exit() {
        this.bYb.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bYb.a(i, strArr, aVar);
    }

    public void aek() {
        this.bYb.aek();
    }

    public void ael() {
        this.bYb.ael();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bYa != null) {
                if (bYa.bYb != null) {
                    bYa.bYb.doRelease();
                }
                bYa = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e Wq() {
        return this.bYb.Wq();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bYb.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bYb.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aen() {
        return this.bYb.aen();
    }

    public FullScreenFloatView K(Activity activity) {
        return this.bYb.K(activity);
    }

    public SwanAppPropertyWindow L(Activity activity) {
        return this.bYb.L(activity);
    }

    public boolean aeo() {
        return this.bYb.aeo();
    }

    public void v(Intent intent) {
        this.bYb.v(intent);
    }

    public void Pu() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.acn().Pu();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.aoT();
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bf(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aeK()) {
            switch (swanAppActivity.Ol()) {
                case 0:
                    this.bYb = new c();
                    break;
                case 1:
                    this.bYb = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (aeK()) {
            this.bYb.i(swanAppActivity);
        }
    }

    public SwanCoreVersion aem() {
        return this.bYb.aem();
    }

    public SwanAppConfigData aep() {
        return this.bYb.aep();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c ke(String str) {
        return this.bYb.ke(str);
    }

    public com.baidu.swan.apps.storage.b.c aeq() {
        return this.bYb.aeq();
    }

    public String aer() {
        return this.bYb.aer();
    }

    public String aes() {
        return this.bYb.aes();
    }

    public String aet() {
        return this.bYb.aet();
    }

    public com.baidu.swan.apps.core.d.e Ot() {
        return this.bYb.Ot();
    }

    public SwanAppActivity aeu() {
        return this.bYb.aeu();
    }

    public com.baidu.swan.games.view.d aeM() {
        return this.bYb.WF();
    }

    public com.baidu.swan.games.view.d aeN() {
        return this.bYb.WG();
    }

    public com.baidu.swan.apps.adaptation.b.e iI(String str) {
        return this.bYb.iI(str);
    }

    public AbsoluteLayout kf(String str) {
        return this.bYb.kf(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bYb.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bYb.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bYb.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d We() {
        return this.bYb.We();
    }

    public String aeO() {
        return ai.apu().getPage();
    }

    public String VP() {
        return this.bYb.VP();
    }

    public com.baidu.swan.apps.adaptation.b.d aev() {
        return this.bYb.aev();
    }

    @NonNull
    public Pair<Integer, Integer> aew() {
        return this.bYb.aew();
    }

    @NonNull
    public Pair<Integer, Integer> aex() {
        return this.bYb.aex();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fs(int i) {
        this.bYb.fs(i);
    }

    public void showLoadingView() {
        this.bYb.showLoadingView();
    }

    public void Ow() {
        this.bYb.Ow();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void aej() {
            super.aej();
        }
    }

    public com.baidu.swan.games.p.a aey() {
        return this.bYb.aey();
    }
}
