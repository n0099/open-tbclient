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
    private static volatile e ayy;
    private c ayz = new a();

    private e() {
    }

    public static e Ec() {
        if (ayy == null) {
            synchronized (e.class) {
                if (ayy == null) {
                    ayy = new e();
                }
            }
        }
        return ayy;
    }

    public void bL(Context context) {
        this.ayz.bL(context);
    }

    public void bM(Context context) {
        this.ayz.bM(context);
    }

    public void vQ() {
        this.ayz.vQ();
    }

    public void vR() {
        this.ayz.vR();
    }

    public void exit() {
        this.ayz.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        this.ayz.a(i, strArr, interfaceC0108a);
    }

    public void DF() {
        this.ayz.DF();
    }

    public void DG() {
        this.ayz.DG();
    }

    public static void release() {
        if (ayy != null) {
            if (ayy.ayz != null) {
                ayy.ayz.doRelease();
            }
            ayy = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b zb() {
        return this.ayz.zb();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayz.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayz.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a DI() {
        return this.ayz.DI();
    }

    public FullScreenFloatView C(Activity activity) {
        return this.ayz.C(activity);
    }

    public SwanAppPropertyWindow D(Activity activity) {
        return this.ayz.D(activity);
    }

    public boolean DJ() {
        return this.ayz.DJ();
    }

    public void J(Intent intent) {
        this.ayz.J(intent);
    }

    public void uZ() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.CX().uZ();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.LU();
        j.LV();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.ut() == 1) {
                this.ayz = new com.baidu.swan.games.l.a();
            } else {
                this.ayz = new b();
            }
        }
        if (this.ayz != null) {
            this.ayz.f(swanAppActivity);
        }
    }

    public SwanCoreVersion DH() {
        return this.ayz.DH();
    }

    public com.baidu.swan.apps.ae.a.c DK() {
        return this.ayz.DK();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d eN(String str) {
        return this.ayz.eN(str);
    }

    public String DL() {
        return this.ayz.DL();
    }

    public String DM() {
        return this.ayz.DM();
    }

    public String DN() {
        return this.ayz.DN();
    }

    public com.baidu.swan.apps.core.c.e uz() {
        return this.ayz.uz();
    }

    public SwanAppActivity DO() {
        return this.ayz.DO();
    }

    public com.baidu.swan.games.view.b Ed() {
        return this.ayz.zk();
    }

    public com.baidu.swan.apps.b.c.e ee(String str) {
        return this.ayz.ee(str);
    }

    public AbsoluteLayout eO(String str) {
        return this.ayz.eO(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.ayz.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.ayz.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.ayz.a(str, aVar);
    }

    public com.baidu.swan.apps.core.c.d yP() {
        return this.ayz.yP();
    }

    public String yB() {
        return this.ayz.yB();
    }

    public com.baidu.swan.apps.b.c.d DP() {
        return this.ayz.DP();
    }

    @NonNull
    public Pair<Integer, Integer> DQ() {
        return this.ayz.DQ();
    }

    @NonNull
    public Pair<Integer, Integer> DR() {
        return this.ayz.DR();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cF(int i) {
        this.ayz.cF(i);
    }

    public void showLoadingView() {
        this.ayz.showLoadingView();
    }

    public void uC() {
        this.ayz.uC();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
