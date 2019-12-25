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
/* loaded from: classes9.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f buE;
    private d buF = new a();

    private f() {
    }

    public static f Uf() {
        if (buE == null) {
            synchronized (f.class) {
                if (buE == null) {
                    buE = new f();
                }
            }
        }
        return buE;
    }

    boolean hasController() {
        return (this.buF == null || (this.buF instanceof a)) ? false : true;
    }

    public boolean Ug() {
        return hasController() && this.buF.TQ() != null;
    }

    public void cc(Context context) {
        this.buF.cc(context);
    }

    public void cd(Context context) {
        this.buF.cd(context);
    }

    public void FL() {
        this.buF.FL();
    }

    public void FM() {
        this.buF.FM();
    }

    public void exit() {
        this.buF.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.buF.a(i, strArr, aVar);
    }

    public void TG() {
        this.buF.TG();
    }

    public void TH() {
        this.buF.TH();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (buE != null) {
                if (buE.buF != null) {
                    buE.buF.doRelease();
                }
                buE = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e LO() {
        return this.buF.LO();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.buF.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.buF.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a TJ() {
        return this.buF.TJ();
    }

    public FullScreenFloatView M(Activity activity) {
        return this.buF.M(activity);
    }

    public SwanAppPropertyWindow N(Activity activity) {
        return this.buF.N(activity);
    }

    public boolean TK() {
        return this.buF.TK();
    }

    public void J(Intent intent) {
        this.buF.J(intent);
    }

    public void ES() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.RK().ES();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.aec();
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bA(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !hasController()) {
            switch (swanAppActivity.DH()) {
                case 0:
                    this.buF = new c();
                    break;
                case 1:
                    this.buF = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (hasController()) {
            this.buF.i(swanAppActivity);
        }
    }

    public SwanCoreVersion TI() {
        return this.buF.TI();
    }

    public SwanAppConfigData TL() {
        return this.buF.TL();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c iA(String str) {
        return this.buF.iA(str);
    }

    public com.baidu.swan.apps.storage.b.c TM() {
        return this.buF.TM();
    }

    public String TN() {
        return this.buF.TN();
    }

    public String TO() {
        return this.buF.TO();
    }

    public String TP() {
        return this.buF.TP();
    }

    public com.baidu.swan.apps.core.d.e DP() {
        return this.buF.DP();
    }

    public SwanAppActivity TQ() {
        return this.buF.TQ();
    }

    public com.baidu.swan.games.view.d Uh() {
        return this.buF.Mc();
    }

    public com.baidu.swan.games.view.d Ui() {
        return this.buF.Md();
    }

    public com.baidu.swan.apps.adaptation.b.e hd(String str) {
        return this.buF.hd(str);
    }

    public AbsoluteLayout iB(String str) {
        return this.buF.iB(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.buF.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.buF.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.buF.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d LC() {
        return this.buF.LC();
    }

    public String Uj() {
        return ai.aeB().getPage();
    }

    public String Ln() {
        return this.buF.Ln();
    }

    public com.baidu.swan.apps.adaptation.b.d TR() {
        return this.buF.TR();
    }

    @NonNull
    public Pair<Integer, Integer> TS() {
        return this.buF.TS();
    }

    @NonNull
    public Pair<Integer, Integer> TT() {
        return this.buF.TT();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void eW(int i) {
        this.buF.eW(i);
    }

    public void showLoadingView() {
        this.buF.showLoadingView();
    }

    public void DS() {
        this.buF.DS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void TF() {
            super.TF();
        }
    }

    public com.baidu.swan.games.p.a TU() {
        return this.buF.TU();
    }
}
