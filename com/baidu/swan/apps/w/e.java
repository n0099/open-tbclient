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
    private static volatile e aTB;
    private c aTC = new a();

    private e() {
    }

    public static e LE() {
        if (aTB == null) {
            synchronized (e.class) {
                if (aTB == null) {
                    aTB = new e();
                }
            }
        }
        return aTB;
    }

    public void bj(Context context) {
        this.aTC.bj(context);
    }

    public void bk(Context context) {
        this.aTC.bk(context);
    }

    public void Cg() {
        this.aTC.Cg();
    }

    public void Ch() {
        this.aTC.Ch();
    }

    public void exit() {
        this.aTC.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0152a interfaceC0152a) {
        this.aTC.a(i, strArr, interfaceC0152a);
    }

    public void Lh() {
        this.aTC.Lh();
    }

    public void Li() {
        this.aTC.Li();
    }

    public static void release() {
        if (aTB != null) {
            if (aTB.aTC != null) {
                aTB.aTC.doRelease();
            }
            aTB = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b FE() {
        return this.aTC.FE();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aTC.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aTC.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a Lk() {
        return this.aTC.Lk();
    }

    public FullScreenFloatView E(Activity activity) {
        return this.aTC.E(activity);
    }

    public SwanAppPropertyWindow F(Activity activity) {
        return this.aTC.F(activity);
    }

    public boolean Ll() {
        return this.aTC.Ll();
    }

    public void O(Intent intent) {
        this.aTC.O(intent);
    }

    public void BD() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.JI().BD();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.Ug();
        j.Uh();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.AC() == 1) {
                this.aTC = new com.baidu.swan.games.m.a();
            } else {
                this.aTC = new b();
            }
        }
        if (this.aTC != null) {
            this.aTC.f(swanAppActivity);
        }
    }

    public SwanCoreVersion Lj() {
        return this.aTC.Lj();
    }

    public com.baidu.swan.apps.ae.a.c Lm() {
        return this.aTC.Lm();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d fM(String str) {
        return this.aTC.fM(str);
    }

    public String Ln() {
        return this.aTC.Ln();
    }

    public String Lo() {
        return this.aTC.Lo();
    }

    public String Lp() {
        return this.aTC.Lp();
    }

    public com.baidu.swan.apps.core.d.e AI() {
        return this.aTC.AI();
    }

    public SwanAppActivity Lq() {
        return this.aTC.Lq();
    }

    public com.baidu.swan.games.view.b LF() {
        return this.aTC.FP();
    }

    public com.baidu.swan.games.view.b LG() {
        return this.aTC.FQ();
    }

    public com.baidu.swan.apps.b.c.e eH(String str) {
        return this.aTC.eH(str);
    }

    public AbsoluteLayout fN(String str) {
        return this.aTC.fN(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.aTC.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.aTC.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.aTC.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d Fs() {
        return this.aTC.Fs();
    }

    public String Fc() {
        return this.aTC.Fc();
    }

    public com.baidu.swan.apps.b.c.d Lr() {
        return this.aTC.Lr();
    }

    @NonNull
    public Pair<Integer, Integer> Ls() {
        return this.aTC.Ls();
    }

    @NonNull
    public Pair<Integer, Integer> Lt() {
        return this.aTC.Lt();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void dE(int i) {
        this.aTC.dE(i);
    }

    public void showLoadingView() {
        this.aTC.showLoadingView();
    }

    public void AL() {
        this.aTC.AL();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
