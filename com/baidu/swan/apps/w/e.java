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
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private static volatile e ayx;
    private c ayy = new a();

    private e() {
    }

    public static e Ec() {
        if (ayx == null) {
            synchronized (e.class) {
                if (ayx == null) {
                    ayx = new e();
                }
            }
        }
        return ayx;
    }

    public void bL(Context context) {
        this.ayy.bL(context);
    }

    public void bM(Context context) {
        this.ayy.bM(context);
    }

    public void vQ() {
        this.ayy.vQ();
    }

    public void vR() {
        this.ayy.vR();
    }

    public void exit() {
        this.ayy.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0078a interfaceC0078a) {
        this.ayy.a(i, strArr, interfaceC0078a);
    }

    public void DF() {
        this.ayy.DF();
    }

    public void DG() {
        this.ayy.DG();
    }

    public static void release() {
        if (ayx != null) {
            if (ayx.ayy != null) {
                ayx.ayy.doRelease();
            }
            ayx = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b zb() {
        return this.ayy.zb();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayy.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.ayy.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a DI() {
        return this.ayy.DI();
    }

    public FullScreenFloatView C(Activity activity) {
        return this.ayy.C(activity);
    }

    public SwanAppPropertyWindow D(Activity activity) {
        return this.ayy.D(activity);
    }

    public boolean DJ() {
        return this.ayy.DJ();
    }

    public void J(Intent intent) {
        this.ayy.J(intent);
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
                this.ayy = new com.baidu.swan.games.l.a();
            } else {
                this.ayy = new b();
            }
        }
        if (this.ayy != null) {
            this.ayy.f(swanAppActivity);
        }
    }

    public SwanCoreVersion DH() {
        return this.ayy.DH();
    }

    public com.baidu.swan.apps.ae.a.c DK() {
        return this.ayy.DK();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d eN(String str) {
        return this.ayy.eN(str);
    }

    public String DL() {
        return this.ayy.DL();
    }

    public String DM() {
        return this.ayy.DM();
    }

    public String DN() {
        return this.ayy.DN();
    }

    public com.baidu.swan.apps.core.c.e uz() {
        return this.ayy.uz();
    }

    public SwanAppActivity DO() {
        return this.ayy.DO();
    }

    public com.baidu.swan.games.view.b Ed() {
        return this.ayy.zk();
    }

    public com.baidu.swan.apps.b.c.e ee(String str) {
        return this.ayy.ee(str);
    }

    public AbsoluteLayout eO(String str) {
        return this.ayy.eO(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.ayy.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.ayy.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.ayy.a(str, aVar);
    }

    public com.baidu.swan.apps.core.c.d yP() {
        return this.ayy.yP();
    }

    public String yB() {
        return this.ayy.yB();
    }

    public com.baidu.swan.apps.b.c.d DP() {
        return this.ayy.DP();
    }

    @NonNull
    public Pair<Integer, Integer> DQ() {
        return this.ayy.DQ();
    }

    @NonNull
    public Pair<Integer, Integer> DR() {
        return this.ayy.DR();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cF(int i) {
        this.ayy.cF(i);
    }

    public void showLoadingView() {
        this.ayy.showLoadingView();
    }

    public void uC() {
        this.ayy.uC();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
