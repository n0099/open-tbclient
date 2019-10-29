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
    private static volatile e aTT;
    private c aTU = new a();

    private e() {
    }

    public static e LD() {
        if (aTT == null) {
            synchronized (e.class) {
                if (aTT == null) {
                    aTT = new e();
                }
            }
        }
        return aTT;
    }

    public void bj(Context context) {
        this.aTU.bj(context);
    }

    public void bk(Context context) {
        this.aTU.bk(context);
    }

    public void Cf() {
        this.aTU.Cf();
    }

    public void Cg() {
        this.aTU.Cg();
    }

    public void exit() {
        this.aTU.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0152a interfaceC0152a) {
        this.aTU.a(i, strArr, interfaceC0152a);
    }

    public void Lg() {
        this.aTU.Lg();
    }

    public void Lh() {
        this.aTU.Lh();
    }

    public static void release() {
        if (aTT != null) {
            if (aTT.aTU != null) {
                aTT.aTU.doRelease();
            }
            aTT = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b FD() {
        return this.aTU.FD();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aTU.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aTU.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a Lj() {
        return this.aTU.Lj();
    }

    public FullScreenFloatView E(Activity activity) {
        return this.aTU.E(activity);
    }

    public SwanAppPropertyWindow F(Activity activity) {
        return this.aTU.F(activity);
    }

    public boolean Lk() {
        return this.aTU.Lk();
    }

    public void O(Intent intent) {
        this.aTU.O(intent);
    }

    public void BC() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.JH().BC();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.Ui();
        j.Uj();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.AB() == 1) {
                this.aTU = new com.baidu.swan.games.m.a();
            } else {
                this.aTU = new b();
            }
        }
        if (this.aTU != null) {
            this.aTU.f(swanAppActivity);
        }
    }

    public SwanCoreVersion Li() {
        return this.aTU.Li();
    }

    public com.baidu.swan.apps.ae.a.c Ll() {
        return this.aTU.Ll();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d fM(String str) {
        return this.aTU.fM(str);
    }

    public String Lm() {
        return this.aTU.Lm();
    }

    public String Ln() {
        return this.aTU.Ln();
    }

    public String Lo() {
        return this.aTU.Lo();
    }

    public com.baidu.swan.apps.core.d.e AH() {
        return this.aTU.AH();
    }

    public SwanAppActivity Lp() {
        return this.aTU.Lp();
    }

    public com.baidu.swan.games.view.b LE() {
        return this.aTU.FO();
    }

    public com.baidu.swan.games.view.b LF() {
        return this.aTU.FP();
    }

    public com.baidu.swan.apps.b.c.e eH(String str) {
        return this.aTU.eH(str);
    }

    public AbsoluteLayout fN(String str) {
        return this.aTU.fN(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.aTU.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.aTU.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.aTU.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Fr() {
        return this.aTU.Fr();
    }

    public String Fb() {
        return this.aTU.Fb();
    }

    public com.baidu.swan.apps.b.c.d Lq() {
        return this.aTU.Lq();
    }

    @NonNull
    public Pair<Integer, Integer> Lr() {
        return this.aTU.Lr();
    }

    @NonNull
    public Pair<Integer, Integer> Ls() {
        return this.aTU.Ls();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void dE(int i) {
        this.aTU.dE(i);
    }

    public void showLoadingView() {
        this.aTU.showLoadingView();
    }

    public void AK() {
        this.aTU.AK();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
