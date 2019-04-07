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
    private static volatile e ayB;
    private c ayC = new a();

    private e() {
    }

    public static e Ea() {
        if (ayB == null) {
            synchronized (e.class) {
                if (ayB == null) {
                    ayB = new e();
                }
            }
        }
        return ayB;
    }

    public void bL(Context context) {
        this.ayC.bL(context);
    }

    public void bM(Context context) {
        this.ayC.bM(context);
    }

    public void vP() {
        this.ayC.vP();
    }

    public void vQ() {
        this.ayC.vQ();
    }

    public void exit() {
        this.ayC.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        this.ayC.a(i, strArr, interfaceC0108a);
    }

    public void DD() {
        this.ayC.DD();
    }

    public void DE() {
        this.ayC.DE();
    }

    public static void release() {
        if (ayB != null) {
            if (ayB.ayC != null) {
                ayB.ayC.doRelease();
            }
            ayB = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b za() {
        return this.ayC.za();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayC.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayC.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a DG() {
        return this.ayC.DG();
    }

    public FullScreenFloatView C(Activity activity) {
        return this.ayC.C(activity);
    }

    public SwanAppPropertyWindow D(Activity activity) {
        return this.ayC.D(activity);
    }

    public boolean DH() {
        return this.ayC.DH();
    }

    public void J(Intent intent) {
        this.ayC.J(intent);
    }

    public void uY() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.CV().uY();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.LS();
        j.LT();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.us() == 1) {
                this.ayC = new com.baidu.swan.games.l.a();
            } else {
                this.ayC = new b();
            }
        }
        if (this.ayC != null) {
            this.ayC.f(swanAppActivity);
        }
    }

    public SwanCoreVersion DF() {
        return this.ayC.DF();
    }

    public com.baidu.swan.apps.ae.a.c DI() {
        return this.ayC.DI();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d eO(String str) {
        return this.ayC.eO(str);
    }

    public String DJ() {
        return this.ayC.DJ();
    }

    public String DK() {
        return this.ayC.DK();
    }

    public String DL() {
        return this.ayC.DL();
    }

    public com.baidu.swan.apps.core.c.e uy() {
        return this.ayC.uy();
    }

    public SwanAppActivity DM() {
        return this.ayC.DM();
    }

    public com.baidu.swan.games.view.b Eb() {
        return this.ayC.zj();
    }

    public com.baidu.swan.apps.b.c.e eg(String str) {
        return this.ayC.eg(str);
    }

    public AbsoluteLayout eP(String str) {
        return this.ayC.eP(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.ayC.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.ayC.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.ayC.a(str, aVar);
    }

    public com.baidu.swan.apps.core.c.d yO() {
        return this.ayC.yO();
    }

    public String yA() {
        return this.ayC.yA();
    }

    public com.baidu.swan.apps.b.c.d DN() {
        return this.ayC.DN();
    }

    @NonNull
    public Pair<Integer, Integer> DO() {
        return this.ayC.DO();
    }

    @NonNull
    public Pair<Integer, Integer> DP() {
        return this.ayC.DP();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cE(int i) {
        this.ayC.cE(i);
    }

    public void showLoadingView() {
        this.ayC.showLoadingView();
    }

    public void uB() {
        this.ayC.uB();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
