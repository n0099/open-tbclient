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
    private static volatile f bzB;
    private d bzC = new a();

    private f() {
    }

    public static f WQ() {
        if (bzB == null) {
            synchronized (f.class) {
                if (bzB == null) {
                    bzB = new f();
                }
            }
        }
        return bzB;
    }

    boolean hasController() {
        return (this.bzC == null || (this.bzC instanceof a)) ? false : true;
    }

    public boolean WR() {
        return hasController() && this.bzC.WB() != null;
    }

    public void cg(Context context) {
        this.bzC.cg(context);
    }

    public void ch(Context context) {
        this.bzC.ch(context);
    }

    public void Iw() {
        this.bzC.Iw();
    }

    public void Ix() {
        this.bzC.Ix();
    }

    public void exit() {
        this.bzC.exit();
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        this.bzC.a(i, strArr, aVar);
    }

    public void Wr() {
        this.bzC.Wr();
    }

    public void Ws() {
        this.bzC.Ws();
    }

    public static synchronized void release() {
        synchronized (f.class) {
            if (bzB != null) {
                if (bzB.bzC != null) {
                    bzB.bzC.doRelease();
                }
                bzB = null;
            }
        }
    }

    @Nullable
    public com.baidu.swan.apps.runtime.e Oy() {
        return this.bzC.Oy();
    }

    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzC.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        this.bzC.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Wu() {
        return this.bzC.Wu();
    }

    public FullScreenFloatView O(Activity activity) {
        return this.bzC.O(activity);
    }

    public SwanAppPropertyWindow P(Activity activity) {
        return this.bzC.P(activity);
    }

    public boolean Wv() {
        return this.bzC.Wv();
    }

    public void J(Intent intent) {
        this.bzC.J(intent);
    }

    public void HD() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.w.a.Uu().HD();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        m.agJ();
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
            switch (swanAppActivity.Gs()) {
                case 0:
                    this.bzC = new c();
                    break;
                case 1:
                    this.bzC = new com.baidu.swan.games.o.a();
                    break;
            }
        }
        if (hasController()) {
            this.bzC.i(swanAppActivity);
        }
    }

    public SwanCoreVersion Wt() {
        return this.bzC.Wt();
    }

    public SwanAppConfigData Ww() {
        return this.bzC.Ww();
    }

    @NonNull
    public com.baidu.swan.apps.runtime.config.c iS(String str) {
        return this.bzC.iS(str);
    }

    public com.baidu.swan.apps.storage.b.c Wx() {
        return this.bzC.Wx();
    }

    public String Wy() {
        return this.bzC.Wy();
    }

    public String Wz() {
        return this.bzC.Wz();
    }

    public String WA() {
        return this.bzC.WA();
    }

    public com.baidu.swan.apps.core.d.e GA() {
        return this.bzC.GA();
    }

    public SwanAppActivity WB() {
        return this.bzC.WB();
    }

    public com.baidu.swan.games.view.d WS() {
        return this.bzC.OM();
    }

    public com.baidu.swan.games.view.d WT() {
        return this.bzC.ON();
    }

    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        return this.bzC.hv(str);
    }

    public AbsoluteLayout iT(String str) {
        return this.bzC.iT(str);
    }

    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        this.bzC.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        this.bzC.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        this.bzC.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Om() {
        return this.bzC.Om();
    }

    public String WU() {
        return ai.ahi().getPage();
    }

    public String NX() {
        return this.bzC.NX();
    }

    public com.baidu.swan.apps.adaptation.b.d WC() {
        return this.bzC.WC();
    }

    @NonNull
    public Pair<Integer, Integer> WD() {
        return this.bzC.WD();
    }

    @NonNull
    public Pair<Integer, Integer> WE() {
        return this.bzC.WE();
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        this.bzC.fn(i);
    }

    public void showLoadingView() {
        this.bzC.showLoadingView();
    }

    public void GD() {
        this.bzC.GD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends b {
        private a() {
        }

        @Override // com.baidu.swan.apps.y.b
        protected void Wq() {
            super.Wq();
        }
    }

    public com.baidu.swan.games.p.a WF() {
        return this.bzC.WF();
    }
}
