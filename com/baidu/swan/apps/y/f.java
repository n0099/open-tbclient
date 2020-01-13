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
/* loaded from: classes10.dex */
public final class f implements e.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile f bvs;
    private d bvt = new a();

    private f() {
    }

    public static f UC() {
        if (bvs == null) {
            synchronized (f.class) {
                if (bvs == null) {
                    bvs = new f();
                }
            }
        }
        return bvs;
    }

    boolean hasController() {
        return (this.bvt == null || (this.bvt instanceof a)) ? false : true;
    }

    public boolean UD() {
        return hasController() && this.bvt.Un() != null;
    }

    public void cc(Context context) {
        this.bvt.cc(context);
    }

    public void cd(Context context) {
        this.bvt.cd(context);
    }

    public void Gh() {
        this.bvt.Gh();
    }

    public void Gi() {
        this.bvt.Gi();
    }

    public void exit() {
        this.bvt.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bvt.a(i, strArr, aVar);
    }

    public void Ud() {
        this.bvt.Ud();
    }

    public void Ue() {
        this.bvt.Ue();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bvs != null) {
                if (bvs.bvt != null) {
                    bvs.bvt.doRelease();
                }
                bvs = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e Mk() {
        return this.bvt.Mk();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bvt.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bvt.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Ug() {
        return this.bvt.Ug();
    }

    public FullScreenFloatView N(Activity activity) {
        return this.bvt.N(activity);
    }

    public SwanAppPropertyWindow O(Activity activity) {
        return this.bvt.O(activity);
    }

    public boolean Uh() {
        return this.bvt.Uh();
    }

    public void J(Intent intent) {
        this.bvt.J(intent);
    }

    public void Fo() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.Sg().Fo();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.aev();
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
            switch (swanAppActivity.Ed()) {
                case 0:
                    this.bvt = new c();
                    break;
                case 1:
                    this.bvt = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (hasController()) {
            this.bvt.i(swanAppActivity);
        }
    }

    public SwanCoreVersion Uf() {
        return this.bvt.Uf();
    }

    public SwanAppConfigData Ui() {
        return this.bvt.Ui();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c iD(String str) {
        return this.bvt.iD(str);
    }

    public com.baidu.swan.apps.storage.b.c Uj() {
        return this.bvt.Uj();
    }

    public String Uk() {
        return this.bvt.Uk();
    }

    public String Ul() {
        return this.bvt.Ul();
    }

    public String Um() {
        return this.bvt.Um();
    }

    public com.baidu.swan.apps.core.d.e El() {
        return this.bvt.El();
    }

    public SwanAppActivity Un() {
        return this.bvt.Un();
    }

    public com.baidu.swan.games.view.d UE() {
        return this.bvt.My();
    }

    public com.baidu.swan.games.view.d UF() {
        return this.bvt.Mz();
    }

    public com.baidu.swan.apps.adaptation.b.e hg(String str) {
        return this.bvt.hg(str);
    }

    public AbsoluteLayout iE(String str) {
        return this.bvt.iE(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bvt.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bvt.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bvt.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d LY() {
        return this.bvt.LY();
    }

    public String UG() {
        return ai.aeU().getPage();
    }

    public String LJ() {
        return this.bvt.LJ();
    }

    public com.baidu.swan.apps.adaptation.b.d Uo() {
        return this.bvt.Uo();
    }

    @NonNull
    public Pair<Integer, Integer> Up() {
        return this.bvt.Up();
    }

    @NonNull
    public Pair<Integer, Integer> Uq() {
        return this.bvt.Uq();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void eX(int i) {
        this.bvt.eX(i);
    }

    public void showLoadingView() {
        this.bvt.showLoadingView();
    }

    public void Eo() {
        this.bvt.Eo();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void Uc() {
            super.Uc();
        }
    }

    public com.baidu.swan.games.p.a Ur() {
        return this.bvt.Ur();
    }
}
