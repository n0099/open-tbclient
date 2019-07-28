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
    private static volatile e aAh;
    private c aAi = new a();

    private e() {
    }

    public static e GF() {
        if (aAh == null) {
            synchronized (e.class) {
                if (aAh == null) {
                    aAh = new e();
                }
            }
        }
        return aAh;
    }

    public void bh(Context context) {
        this.aAi.bh(context);
    }

    public void bi(Context context) {
        this.aAi.bi(context);
    }

    public void xh() {
        this.aAi.xh();
    }

    public void xi() {
        this.aAi.xi();
    }

    public void exit() {
        this.aAi.exit();
    }

    public void a(int i, @NonNull String[] strArr, a.InterfaceC0111a interfaceC0111a) {
        this.aAi.a(i, strArr, interfaceC0111a);
    }

    public void Gi() {
        this.aAi.Gi();
    }

    public void Gj() {
        this.aAi.Gj();
    }

    public static void release() {
        if (aAh != null) {
            if (aAh.aAi != null) {
                aAh.aAi.doRelease();
            }
            aAh = null;
        }
    }

    @Nullable
    public com.baidu.swan.apps.ae.b AE() {
        return this.aAi.AE();
    }

    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aAi.a(bVar, bVar2);
    }

    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        this.aAi.b(bVar, bVar2);
    }

    @DebugTrace
    public com.baidu.swan.apps.b.c.a Gl() {
        return this.aAi.Gl();
    }

    public FullScreenFloatView F(Activity activity) {
        return this.aAi.F(activity);
    }

    public SwanAppPropertyWindow G(Activity activity) {
        return this.aAi.G(activity);
    }

    public boolean Gm() {
        return this.aAi.Gm();
    }

    public void I(Intent intent) {
        this.aAi.I(intent);
    }

    public void wE() {
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries start.");
        }
        com.baidu.swan.apps.u.a.EJ().wE();
        if (DEBUG) {
            Log.e("SwanAppController", "start preload monitor & executor");
        }
        j.Po();
        j.Pp();
        if (DEBUG) {
            Log.d("SwanAppController", "preloadLibraries end.");
        }
    }

    public void f(SwanAppActivity swanAppActivity) {
        if (swanAppActivity != null) {
            if (swanAppActivity.vD() == 1) {
                this.aAi = new com.baidu.swan.games.m.a();
            } else {
                this.aAi = new b();
            }
        }
        if (this.aAi != null) {
            this.aAi.f(swanAppActivity);
        }
    }

    public SwanCoreVersion Gk() {
        return this.aAi.Gk();
    }

    public com.baidu.swan.apps.ae.a.c Gn() {
        return this.aAi.Gn();
    }

    @NonNull
    public com.baidu.swan.apps.ae.a.d fd(String str) {
        return this.aAi.fd(str);
    }

    public String Go() {
        return this.aAi.Go();
    }

    public String Gp() {
        return this.aAi.Gp();
    }

    public String Gq() {
        return this.aAi.Gq();
    }

    public com.baidu.swan.apps.core.d.e vJ() {
        return this.aAi.vJ();
    }

    public SwanAppActivity Gr() {
        return this.aAi.Gr();
    }

    public com.baidu.swan.games.view.b GG() {
        return this.aAi.AP();
    }

    public com.baidu.swan.games.view.b GH() {
        return this.aAi.AQ();
    }

    public com.baidu.swan.apps.b.c.e dY(String str) {
        return this.aAi.dY(str);
    }

    public AbsoluteLayout fe(String str) {
        return this.aAi.fe(str);
    }

    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        this.aAi.a(dVar, z);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        this.aAi.a(aVar);
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        this.aAi.a(str, aVar);
    }

    public com.baidu.swan.apps.core.d.d As() {
        return this.aAi.As();
    }

    public String Ac() {
        return this.aAi.Ac();
    }

    public com.baidu.swan.apps.b.c.d Gs() {
        return this.aAi.Gs();
    }

    @NonNull
    public Pair<Integer, Integer> Gt() {
        return this.aAi.Gt();
    }

    @NonNull
    public Pair<Integer, Integer> Gu() {
        return this.aAi.Gu();
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cI(int i) {
        this.aAi.cI(i);
    }

    public void showLoadingView() {
        this.aAi.showLoadingView();
    }

    public void vM() {
        this.aAi.vM();
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.apps.w.a {
        private a() {
        }
    }
}
