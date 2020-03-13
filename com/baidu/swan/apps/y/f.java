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
    private static volatile f bzD;
    private d bzE = new a();

    private f() {
    }

    public static f WS() {
        if (bzD == null) {
            synchronized (f.class) {
                if (bzD == null) {
                    bzD = new f();
                }
            }
        }
        return bzD;
    }

    boolean hasController() {
        return (this.bzE == null || (this.bzE instanceof a)) ? false : true;
    }

    public boolean WT() {
        return hasController() && this.bzE.WD() != null;
    }

    public void cg(Context context) {
        this.bzE.cg(context);
    }

    public void ch(Context context) {
        this.bzE.ch(context);
    }

    public void Iy() {
        this.bzE.Iy();
    }

    public void Iz() {
        this.bzE.Iz();
    }

    public void exit() {
        this.bzE.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bzE.a(i, strArr, aVar);
    }

    public void Wt() {
        this.bzE.Wt();
    }

    public void Wu() {
        this.bzE.Wu();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bzD != null) {
                if (bzD.bzE != null) {
                    bzD.bzE.doRelease();
                }
                bzD = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e OA() {
        return this.bzE.OA();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzE.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzE.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Ww() {
        return this.bzE.Ww();
    }

    public FullScreenFloatView O(Activity activity) {
        return this.bzE.O(activity);
    }

    public SwanAppPropertyWindow P(Activity activity) {
        return this.bzE.P(activity);
    }

    public boolean Wx() {
        return this.bzE.Wx();
    }

    public void J(Intent intent) {
        this.bzE.J(intent);
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
                    this.bzE = new c();
                    break;
                case 1:
                    this.bzE = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (hasController()) {
            this.bzE.i(swanAppActivity);
        }
    }

    public SwanCoreVersion Wv() {
        return this.bzE.Wv();
    }

    public SwanAppConfigData Wy() {
        return this.bzE.Wy();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c iS(String str) {
        return this.bzE.iS(str);
    }

    public com.baidu.swan.apps.storage.b.c Wz() {
        return this.bzE.Wz();
    }

    public String WA() {
        return this.bzE.WA();
    }

    public String WB() {
        return this.bzE.WB();
    }

    public String WC() {
        return this.bzE.WC();
    }

    public com.baidu.swan.apps.core.d.e GC() {
        return this.bzE.GC();
    }

    public SwanAppActivity WD() {
        return this.bzE.WD();
    }

    public com.baidu.swan.games.view.d WU() {
        return this.bzE.OO();
    }

    public com.baidu.swan.games.view.d WV() {
        return this.bzE.OP();
    }

    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        return this.bzE.hv(str);
    }

    public AbsoluteLayout iT(String str) {
        return this.bzE.iT(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bzE.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bzE.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bzE.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Oo() {
        return this.bzE.Oo();
    }

    public String WW() {
        return ai.ahk().getPage();
    }

    public String NZ() {
        return this.bzE.NZ();
    }

    public com.baidu.swan.apps.adaptation.b.d WE() {
        return this.bzE.WE();
    }

    @NonNull
    public Pair<Integer, Integer> WF() {
        return this.bzE.WF();
    }

    @NonNull
    public Pair<Integer, Integer> WG() {
        return this.bzE.WG();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        this.bzE.fn(i);
    }

    public void showLoadingView() {
        this.bzE.showLoadingView();
    }

    public void GF() {
        this.bzE.GF();
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
        return this.bzE.WH();
    }
}
