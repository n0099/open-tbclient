package com.baidu.swan.games.m;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.i.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.w.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable aTq;
    private String bBB;
    private SwanCoreVersion bBC;
    private com.baidu.swan.games.inspector.b bBD = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Cg() {
        super.Cg();
        if (this.aTl != null && this.aTl.AK() != null) {
            com.baidu.swan.apps.v.b.b AK = this.aTl.AK();
            f fVar = new f();
            fVar.mFrom = e.eL(1);
            fVar.mAppId = this.aTl.AK().getAppId();
            fVar.mSource = this.aTl.AK().KF();
            fVar.mType = "show";
            fVar.aJ(e.hY(AK.KG()));
            e.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.bP(true);
        com.baidu.swan.games.n.a.Xr().bR(false);
        com.baidu.swan.apps.u.a.JL().Cg();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Ch() {
        super.Ch();
        com.baidu.swan.apps.media.b.bP(false);
        com.baidu.swan.apps.u.a.JL().Ch();
        com.baidu.swan.games.n.a.Xr().bR(true);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.c.a.deleteFile(g.getBasePath() + File.separator + "tmp");
        com.baidu.swan.apps.ae.b.terminate();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Hh());
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.m.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, final com.baidu.swan.apps.install.a aVar) {
                ac.h(a.this.aTq);
                a.this.aTq = new Runnable() { // from class: com.baidu.swan.games.m.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aNS) {
                            a.c cVar = (a.c) aVar;
                            if (i == 0 && cVar != null && bVar2 != null) {
                                if (bVar.KQ()) {
                                    if (com.baidu.swan.games.c.a.b.Wh().Wr()) {
                                        a.this.E(a.this.aTl).setVisibility(0);
                                        a.this.Lk().T(a.this.aJX);
                                        com.baidu.swan.apps.console.a.bm(true);
                                        c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.bn(false);
                                        bVar.bo(false);
                                    }
                                }
                                a.this.bBD.a(cVar, a.this.aTl);
                                bVar2.a(0, cVar);
                                a.this.bBB = cVar.bBe;
                                a.this.b(cVar.bBg);
                                com.baidu.swan.games.subpackage.a.Yi().c(cVar.bBg);
                            }
                        }
                    }
                };
                ac.g(a.this.aTq);
            }
        });
        y(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a Lk() {
        if (this.aTi == null) {
            this.aTi = com.baidu.swan.apps.core.j.c.GP().GQ().aK(AppRuntime.getAppContext());
            com.baidu.swan.games.c.f.bo(true);
        }
        this.aTi.h((ViewGroup) this.aTl.findViewById(16908290));
        return this.aTi;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String Ln() {
        return TextUtils.isEmpty(this.bBB) ? "" : this.bBB;
    }

    public void y(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bBC != null) {
            bVar.a(this.bBC);
        } else {
            this.bBC = bVar.Hh();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView E(Activity activity) {
        super.E(activity);
        this.aJX.setAutoAttachEnable(false);
        return this.aJX;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow F(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.aKa == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aKa = new SwanAppPropertyWindow(activity);
            this.aKa.setVisibility(8);
            viewGroup.addView(this.aKa);
        }
        return this.aKa;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Lj() {
        return this.bBC;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Ls() {
        return Lt();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> Fd() {
        return Ls();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Lt() {
        int i;
        int i2;
        View decorView;
        if (this.aTl == null) {
            return super.Lt();
        }
        Window window = this.aTl.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.aTl.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.aTl.isLandScape() == (this.aTl.getResources().getConfiguration().orientation == 2)) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.p.a.a aVar) {
        this.aTj = aVar;
        com.baidu.swan.apps.ae.b FE = FE();
        if (FE != null) {
            FE.a(aVar);
        }
    }
}
