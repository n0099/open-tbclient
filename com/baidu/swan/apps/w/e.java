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
    private static volatile e ayC;
    private c ayD = new a();

    private e() {
    }

    public static e Ea() {
        if (ayC == null) {
            synchronized (e.class) {
                if (ayC == null) {
                    ayC = new e();
                }
            }
        }
        return ayC;
    }

    public void bL(Context context) {
        this.ayD.bL(context);
    }

    public void bM(Context context) {
        this.ayD.bM(context);
    }

    public void vP() {
        this.ayD.vP();
    }

    public void vQ() {
        this.ayD.vQ();
    }

    public void exit() {
        this.ayD.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        this.ayD.a(i, strArr, interfaceC0108a);
    }

    public void DD() {
        this.ayD.DD();
    }

    public void DE() {
        this.ayD.DE();
    }

    public static void release() {
        if (ayC != null) {
            if (ayC.ayD != null) {
                ayC.ayD.doRelease();
            }
            ayC = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b za() {
        return this.ayD.za();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayD.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayD.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a DG() {
        return this.ayD.DG();
    }

    public FullScreenFloatView C(Activity activity) {
        return this.ayD.C(activity);
    }

    public SwanAppPropertyWindow D(Activity activity) {
        return this.ayD.D(activity);
    }

    public boolean DH() {
        return this.ayD.DH();
    }

    public void J(Intent intent) {
        this.ayD.J(intent);
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
                this.ayD = new com.baidu.swan.games.l.a();
            } else {
                this.ayD = new b();
            }
        }
        if (this.ayD != null) {
            this.ayD.f(swanAppActivity);
        }
    }

    public SwanCoreVersion DF() {
        return this.ayD.DF();
    }

    public com.baidu.swan.apps.ae.a.c DI() {
        return this.ayD.DI();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d eO(String str) {
        return this.ayD.eO(str);
    }

    public String DJ() {
        return this.ayD.DJ();
    }

    public String DK() {
        return this.ayD.DK();
    }

    public String DL() {
        return this.ayD.DL();
    }

    public com.baidu.swan.apps.core.c.e uy() {
        return this.ayD.uy();
    }

    public SwanAppActivity DM() {
        return this.ayD.DM();
    }

    public com.baidu.swan.games.view.b Eb() {
        return this.ayD.zj();
    }

    public com.baidu.swan.apps.b.c.e eg(String str) {
        return this.ayD.eg(str);
    }

    public AbsoluteLayout eP(String str) {
        return this.ayD.eP(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.ayD.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.ayD.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.ayD.a(str, aVar);
    }

    public com.baidu.swan.apps.core.c.d yO() {
        return this.ayD.yO();
    }

    public String yA() {
        return this.ayD.yA();
    }

    public com.baidu.swan.apps.b.c.d DN() {
        return this.ayD.DN();
    }

    @NonNull
    public Pair<Integer, Integer> DO() {
        return this.ayD.DO();
    }

    @NonNull
    public Pair<Integer, Integer> DP() {
        return this.ayD.DP();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cE(int i) {
        this.ayD.cE(i);
    }

    public void showLoadingView() {
        this.ayD.showLoadingView();
    }

    public void uB() {
        this.ayD.uB();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
