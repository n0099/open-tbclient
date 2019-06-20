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
    private static volatile e azA;
    private c azB = new a();

    private e() {
    }

    public static e FV() {
        if (azA == null) {
            synchronized (e.class) {
                if (azA == null) {
                    azA = new e();
                }
            }
        }
        return azA;
    }

    public void bh(Context context) {
        this.azB.bh(context);
    }

    public void bi(Context context) {
        this.azB.bi(context);
    }

    public void wG() {
        this.azB.wG();
    }

    public void wH() {
        this.azB.wH();
    }

    public void exit() {
        this.azB.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0109a interfaceC0109a) {
        this.azB.a(i, strArr, interfaceC0109a);
    }

    public void Fy() {
        this.azB.Fy();
    }

    public void Fz() {
        this.azB.Fz();
    }

    public static void release() {
        if (azA != null) {
            if (azA.azB != null) {
                azA.azB.doRelease();
            }
            azA = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b zX() {
        return this.azB.zX();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.azB.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.azB.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a FB() {
        return this.azB.FB();
    }

    public FullScreenFloatView C(Activity activity) {
        return this.azB.C(activity);
    }

    public SwanAppPropertyWindow D(Activity activity) {
        return this.azB.D(activity);
    }

    public boolean FC() {
        return this.azB.FC();
    }

    public void I(Intent intent) {
        this.azB.I(intent);
    }

    public void wd() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.Ea().wd();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.Oz();
        j.OA();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.vc() == 1) {
                this.azB = new com.baidu.swan.games.m.a();
            } else {
                this.azB = new b();
            }
        }
        if (this.azB != null) {
            this.azB.f(swanAppActivity);
        }
    }

    public SwanCoreVersion FA() {
        return this.azB.FA();
    }

    public com.baidu.swan.apps.ae.a.c FD() {
        return this.azB.FD();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d eY(String str) {
        return this.azB.eY(str);
    }

    public String FE() {
        return this.azB.FE();
    }

    public String FF() {
        return this.azB.FF();
    }

    public String FG() {
        return this.azB.FG();
    }

    public com.baidu.swan.apps.core.d.e vi() {
        return this.azB.vi();
    }

    public SwanAppActivity FH() {
        return this.azB.FH();
    }

    public com.baidu.swan.games.view.b FW() {
        return this.azB.Ai();
    }

    public com.baidu.swan.games.view.b FX() {
        return this.azB.Aj();
    }

    public com.baidu.swan.apps.b.c.e dT(String str) {
        return this.azB.dT(str);
    }

    public AbsoluteLayout eZ(String str) {
        return this.azB.eZ(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.azB.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.azB.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.azB.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d zL() {
        return this.azB.zL();
    }

    public String zv() {
        return this.azB.zv();
    }

    public com.baidu.swan.apps.b.c.d FI() {
        return this.azB.FI();
    }

    @NonNull
    public Pair<Integer, Integer> FJ() {
        return this.azB.FJ();
    }

    @NonNull
    public Pair<Integer, Integer> FK() {
        return this.azB.FK();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cH(int i) {
        this.azB.cH(i);
    }

    public void showLoadingView() {
        this.azB.showLoadingView();
    }

    public void vl() {
        this.azB.vl();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
