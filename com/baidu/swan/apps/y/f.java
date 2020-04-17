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
    private static volatile f bXU;
    private d bXV = new a();

    private f() {
    }

    public static f aeK() {
        if (bXU == null) {
            synchronized (f.class) {
                if (bXU == null) {
                    bXU = new f();
                }
            }
        }
        return bXU;
    }

    boolean aeL() {
        return (this.bXV == null || (this.bXV instanceof a)) ? false : true;
    }

    public boolean aeM() {
        return aeL() && this.bXV.aev() != null;
    }

    public void bT(Context context) {
        this.bXV.bT(context);
    }

    public void bU(Context context) {
        this.bXV.bU(context);
    }

    public void Qn() {
        this.bXV.Qn();
    }

    public void Qo() {
        this.bXV.Qo();
    }

    public void exit() {
        this.bXV.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bXV.a(i, strArr, aVar);
    }

    public void ael() {
        this.bXV.ael();
    }

    public void aem() {
        this.bXV.aem();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bXU != null) {
                if (bXU.bXV != null) {
                    bXU.bXV.doRelease();
                }
                bXU = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e Wr() {
        return this.bXV.Wr();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bXV.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bXV.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aeo() {
        return this.bXV.aeo();
    }

    public FullScreenFloatView K(Activity activity) {
        return this.bXV.K(activity);
    }

    public SwanAppPropertyWindow L(Activity activity) {
        return this.bXV.L(activity);
    }

    public boolean aep() {
        return this.bXV.aep();
    }

    public void I(Intent intent) {
        this.bXV.I(intent);
    }

    public void Pv() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.aco().Pv();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.aoU();
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.br(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !aeL()) {
            switch (swanAppActivity.Om()) {
                case 0:
                    this.bXV = new c();
                    break;
                case 1:
                    this.bXV = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (aeL()) {
            this.bXV.i(swanAppActivity);
        }
    }

    public SwanCoreVersion aen() {
        return this.bXV.aen();
    }

    public SwanAppConfigData aeq() {
        return this.bXV.aeq();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c ke(String str) {
        return this.bXV.ke(str);
    }

    public com.baidu.swan.apps.storage.b.c aer() {
        return this.bXV.aer();
    }

    public String aes() {
        return this.bXV.aes();
    }

    public String aet() {
        return this.bXV.aet();
    }

    public String aeu() {
        return this.bXV.aeu();
    }

    public com.baidu.swan.apps.core.d.e Ou() {
        return this.bXV.Ou();
    }

    public SwanAppActivity aev() {
        return this.bXV.aev();
    }

    public com.baidu.swan.games.view.d aeN() {
        return this.bXV.WG();
    }

    public com.baidu.swan.games.view.d aeO() {
        return this.bXV.WH();
    }

    public com.baidu.swan.apps.adaptation.b.e iI(String str) {
        return this.bXV.iI(str);
    }

    public AbsoluteLayout kf(String str) {
        return this.bXV.kf(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bXV.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bXV.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bXV.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Wf() {
        return this.bXV.Wf();
    }

    public String aeP() {
        return ai.apv().getPage();
    }

    public String VQ() {
        return this.bXV.VQ();
    }

    public com.baidu.swan.apps.adaptation.b.d aew() {
        return this.bXV.aew();
    }

    @NonNull
    public Pair<Integer, Integer> aex() {
        return this.bXV.aex();
    }

    @NonNull
    public Pair<Integer, Integer> aey() {
        return this.bXV.aey();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fs(int i) {
        this.bXV.fs(i);
    }

    public void showLoadingView() {
        this.bXV.showLoadingView();
    }

    public void Ox() {
        this.bXV.Ox();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void aek() {
            super.aek();
        }
    }

    public com.baidu.swan.games.p.a aez() {
        return this.bXV.aez();
    }
}
