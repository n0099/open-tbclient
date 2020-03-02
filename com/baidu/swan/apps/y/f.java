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
    private static volatile f bzC;
    private d bzD = new a();

    private f() {
    }

    public static f WS() {
        if (bzC == null) {
            synchronized (f.class) {
                if (bzC == null) {
                    bzC = new f();
                }
            }
        }
        return bzC;
    }

    boolean hasController() {
        return (this.bzD == null || (this.bzD instanceof a)) ? false : true;
    }

    public boolean WT() {
        return hasController() && this.bzD.WD() != null;
    }

    public void cg(Context context) {
        this.bzD.cg(context);
    }

    public void ch(Context context) {
        this.bzD.ch(context);
    }

    public void Iy() {
        this.bzD.Iy();
    }

    public void Iz() {
        this.bzD.Iz();
    }

    public void exit() {
        this.bzD.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bzD.a(i, strArr, aVar);
    }

    public void Wt() {
        this.bzD.Wt();
    }

    public void Wu() {
        this.bzD.Wu();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bzC != null) {
                if (bzC.bzD != null) {
                    bzC.bzD.doRelease();
                }
                bzC = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e OA() {
        return this.bzD.OA();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzD.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzD.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Ww() {
        return this.bzD.Ww();
    }

    public FullScreenFloatView O(Activity activity) {
        return this.bzD.O(activity);
    }

    public SwanAppPropertyWindow P(Activity activity) {
        return this.bzD.P(activity);
    }

    public boolean Wx() {
        return this.bzD.Wx();
    }

    public void J(Intent intent) {
        this.bzD.J(intent);
    }

    public void HF() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.Uw().HF();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.agL();
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.y.f.1
            @Override // java.lang.Runnable
            public void run() {
            }
        }, "computation");
        com.baidu.swan.apps.api.module.l.d.bE(AppRuntime.getAppContext());
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void i(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null && !hasController()) {
            switch (swanAppActivity.Gu()) {
                case 0:
                    this.bzD = new c();
                    break;
                case 1:
                    this.bzD = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (hasController()) {
            this.bzD.i(swanAppActivity);
        }
    }

    public SwanCoreVersion Wv() {
        return this.bzD.Wv();
    }

    public SwanAppConfigData Wy() {
        return this.bzD.Wy();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c iS(String str) {
        return this.bzD.iS(str);
    }

    public com.baidu.swan.apps.storage.b.c Wz() {
        return this.bzD.Wz();
    }

    public String WA() {
        return this.bzD.WA();
    }

    public String WB() {
        return this.bzD.WB();
    }

    public String WC() {
        return this.bzD.WC();
    }

    public com.baidu.swan.apps.core.d.e GC() {
        return this.bzD.GC();
    }

    public SwanAppActivity WD() {
        return this.bzD.WD();
    }

    public com.baidu.swan.games.view.d WU() {
        return this.bzD.OO();
    }

    public com.baidu.swan.games.view.d WV() {
        return this.bzD.OP();
    }

    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        return this.bzD.hv(str);
    }

    public AbsoluteLayout iT(String str) {
        return this.bzD.iT(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bzD.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bzD.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bzD.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Oo() {
        return this.bzD.Oo();
    }

    public String WW() {
        return ai.ahk().getPage();
    }

    public String NZ() {
        return this.bzD.NZ();
    }

    public com.baidu.swan.apps.adaptation.b.d WE() {
        return this.bzD.WE();
    }

    @NonNull
    public Pair<Integer, Integer> WF() {
        return this.bzD.WF();
    }

    @NonNull
    public Pair<Integer, Integer> WG() {
        return this.bzD.WG();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        this.bzD.fn(i);
    }

    public void showLoadingView() {
        this.bzD.showLoadingView();
    }

    public void GF() {
        this.bzD.GF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void Ws() {
            super.Ws();
        }
    }

    public com.baidu.swan.games.p.a WH() {
        return this.bzD.WH();
    }
}
