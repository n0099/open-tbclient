package com.baidu.swan.apps.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.util.Pair;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.d;
/* loaded from: classes2.dex */
public final class e implements d.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile e aAF;
    private c aAG = new a();

    private e() {
    }

    public static e GJ() {
        if (aAF == null) {
            synchronized (e.class) {
                if (aAF == null) {
                    aAF = new e();
                }
            }
        }
        return aAF;
    }

    public void bh(Context context) {
        this.aAG.bh(context);
    }

    public void bi(Context context) {
        this.aAG.bi(context);
    }

    public void xl() {
        this.aAG.xl();
    }

    public void xm() {
        this.aAG.xm();
    }

    public void exit() {
        this.aAG.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0120a interfaceC0120a) {
        this.aAG.a(i, strArr, interfaceC0120a);
    }

    public void Gm() {
        this.aAG.Gm();
    }

    public void Gn() {
        this.aAG.Gn();
    }

    public static void release() {
        if (aAF != null) {
            if (aAF.aAG != null) {
                aAF.aAG.doRelease();
            }
            aAF = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b AI() {
        return this.aAG.AI();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aAG.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aAG.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a Gp() {
        return this.aAG.Gp();
    }

    public FullScreenFloatView F(Activity activity) {
        return this.aAG.F(activity);
    }

    public SwanAppPropertyWindow G(Activity activity) {
        return this.aAG.G(activity);
    }

    public boolean Gq() {
        return this.aAG.Gq();
    }

    public void I(Intent intent) {
        this.aAG.I(intent);
    }

    public void wI() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.EN().wI();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.Ps();
        j.Pt();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.vH() == 1) {
                this.aAG = new com.baidu.swan.games.m.a();
            } else {
                this.aAG = new b();
            }
        }
        if (this.aAG != null) {
            this.aAG.f(swanAppActivity);
        }
    }

    public SwanCoreVersion Go() {
        return this.aAG.Go();
    }

    public com.baidu.swan.apps.ae.a.c Gr() {
        return this.aAG.Gr();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d ff(String str) {
        return this.aAG.ff(str);
    }

    public String Gs() {
        return this.aAG.Gs();
    }

    public String Gt() {
        return this.aAG.Gt();
    }

    public String Gu() {
        return this.aAG.Gu();
    }

    public com.baidu.swan.apps.core.d.e vN() {
        return this.aAG.vN();
    }

    public SwanAppActivity Gv() {
        return this.aAG.Gv();
    }

    public com.baidu.swan.games.view.b GK() {
        return this.aAG.AT();
    }

    public com.baidu.swan.games.view.b GL() {
        return this.aAG.AU();
    }

    public com.baidu.swan.apps.b.c.e ea(String str) {
        return this.aAG.ea(str);
    }

    public AbsoluteLayout fg(String str) {
        return this.aAG.fg(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.aAG.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.aAG.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.aAG.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Aw() {
        return this.aAG.Aw();
    }

    public String Ag() {
        return this.aAG.Ag();
    }

    public com.baidu.swan.apps.b.c.d Gw() {
        return this.aAG.Gw();
    }

    @NonNull
    public Pair<Integer, Integer> Gx() {
        return this.aAG.Gx();
    }

    @NonNull
    public Pair<Integer, Integer> Gy() {
        return this.aAG.Gy();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cJ(int i) {
        this.aAG.cJ(i);
    }

    public void showLoadingView() {
        this.aAG.showLoadingView();
    }

    public void vQ() {
        this.aAG.vQ();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
