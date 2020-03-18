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
    private static volatile f bzO;
    private d bzP = new a();

    private f() {
    }

    public static f WV() {
        if (bzO == null) {
            synchronized (f.class) {
                if (bzO == null) {
                    bzO = new f();
                }
            }
        }
        return bzO;
    }

    boolean hasController() {
        return (this.bzP == null || (this.bzP instanceof a)) ? false : true;
    }

    public boolean WW() {
        return hasController() && this.bzP.WG() != null;
    }

    public void cf(Context context) {
        this.bzP.cf(context);
    }

    public void cg(Context context) {
        this.bzP.cg(context);
    }

    public void IB() {
        this.bzP.IB();
    }

    public void IC() {
        this.bzP.IC();
    }

    public void exit() {
        this.bzP.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bzP.a(i, strArr, aVar);
    }

    public void Ww() {
        this.bzP.Ww();
    }

    public void Wx() {
        this.bzP.Wx();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bzO != null) {
                if (bzO.bzP != null) {
                    bzO.bzP.doRelease();
                }
                bzO = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e OD() {
        return this.bzP.OD();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzP.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzP.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Wz() {
        return this.bzP.Wz();
    }

    public FullScreenFloatView O(Activity activity) {
        return this.bzP.O(activity);
    }

    public SwanAppPropertyWindow P(Activity activity) {
        return this.bzP.P(activity);
    }

    public boolean WA() {
        return this.bzP.WA();
    }

    public void J(Intent intent) {
        this.bzP.J(intent);
    }

    public void HI() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.Uz().HI();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.agO();
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bD(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !hasController()) {
            switch (swanAppActivity.Gz()) {
                case 0:
                    this.bzP = new c();
                    break;
                case 1:
                    this.bzP = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (hasController()) {
            this.bzP.i(swanAppActivity);
        }
    }

    public SwanCoreVersion Wy() {
        return this.bzP.Wy();
    }

    public SwanAppConfigData WB() {
        return this.bzP.WB();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c iR(String str) {
        return this.bzP.iR(str);
    }

    public com.baidu.swan.apps.storage.b.c WC() {
        return this.bzP.WC();
    }

    public String WD() {
        return this.bzP.WD();
    }

    public String WE() {
        return this.bzP.WE();
    }

    public String WF() {
        return this.bzP.WF();
    }

    public com.baidu.swan.apps.core.d.e GH() {
        return this.bzP.GH();
    }

    public SwanAppActivity WG() {
        return this.bzP.WG();
    }

    public com.baidu.swan.games.view.d WX() {
        return this.bzP.OR();
    }

    public com.baidu.swan.games.view.d WY() {
        return this.bzP.OS();
    }

    public com.baidu.swan.apps.adaptation.b.e hu(String str) {
        return this.bzP.hu(str);
    }

    public AbsoluteLayout iS(String str) {
        return this.bzP.iS(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bzP.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bzP.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bzP.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Or() {
        return this.bzP.Or();
    }

    public String WZ() {
        return ai.ahn().getPage();
    }

    public String Oc() {
        return this.bzP.Oc();
    }

    public com.baidu.swan.apps.adaptation.b.d WH() {
        return this.bzP.WH();
    }

    @NonNull
    public Pair<Integer, Integer> WI() {
        return this.bzP.WI();
    }

    @NonNull
    public Pair<Integer, Integer> WJ() {
        return this.bzP.WJ();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        this.bzP.fn(i);
    }

    public void showLoadingView() {
        this.bzP.showLoadingView();
    }

    public void GK() {
        this.bzP.GK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void Wv() {
            super.Wv();
        }
    }

    public com.baidu.swan.games.p.a WK() {
        return this.bzP.WK();
    }
}
