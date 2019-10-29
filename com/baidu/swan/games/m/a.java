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
    private Runnable aTI;
    private String bCs;
    private SwanCoreVersion bCt;
    private com.baidu.swan.games.inspector.b bCu = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Cf() {
        super.Cf();
        if (this.aTD != null && this.aTD.AJ() != null) {
            com.baidu.swan.apps.v.b.b AJ = this.aTD.AJ();
            f fVar = new f();
            fVar.mFrom = e.eL(1);
            fVar.mAppId = this.aTD.AJ().getAppId();
            fVar.mSource = this.aTD.AJ().KE();
            fVar.mType = "show";
            fVar.aI(e.hY(AJ.KF()));
            e.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.bP(true);
        com.baidu.swan.games.n.a.Xt().bR(false);
        com.baidu.swan.apps.u.a.JK().Cf();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void Cg() {
        super.Cg();
        com.baidu.swan.apps.media.b.bP(false);
        com.baidu.swan.apps.u.a.JK().Cg();
        com.baidu.swan.games.n.a.Xt().bR(true);
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
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Hg());
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.m.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, final com.baidu.swan.apps.install.a aVar) {
                ac.h(a.this.aTI);
                a.this.aTI = new Runnable() { // from class: com.baidu.swan.games.m.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.aOk) {
                            a.c cVar = (a.c) aVar;
                            if (i == 0 && cVar != null && bVar2 != null) {
                                if (bVar.KP()) {
                                    if (com.baidu.swan.games.c.a.b.Wj().Wt()) {
                                        a.this.E(a.this.aTD).setVisibility(0);
                                        a.this.Lj().T(a.this.aKp);
                                        com.baidu.swan.apps.console.a.bm(true);
                                        c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.bn(false);
                                        bVar.bo(false);
                                    }
                                }
                                a.this.bCu.a(cVar, a.this.aTD);
                                bVar2.a(0, cVar);
                                a.this.bCs = cVar.bBV;
                                a.this.b(cVar.bBX);
                                com.baidu.swan.games.subpackage.a.Yk().c(cVar.bBX);
                            }
                        }
                    }
                };
                ac.g(a.this.aTI);
            }
        });
        y(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a Lj() {
        if (this.aTA == null) {
            this.aTA = com.baidu.swan.apps.core.j.c.GO().GP().aK(AppRuntime.getAppContext());
            com.baidu.swan.games.c.f.bo(true);
        }
        this.aTA.h((ViewGroup) this.aTD.findViewById(16908290));
        return this.aTA;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String Lm() {
        return TextUtils.isEmpty(this.bCs) ? "" : this.bCs;
    }

    public void y(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bCt != null) {
            bVar.a(this.bCt);
        } else {
            this.bCt = bVar.Hg();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView E(Activity activity) {
        super.E(activity);
        this.aKp.setAutoAttachEnable(false);
        return this.aKp;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow F(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.aKs == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aKs = new SwanAppPropertyWindow(activity);
            this.aKs.setVisibility(8);
            viewGroup.addView(this.aKs);
        }
        return this.aKs;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Li() {
        return this.bCt;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Lr() {
        return Ls();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> Fc() {
        return Lr();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Ls() {
        int i;
        int i2;
        View decorView;
        if (this.aTD == null) {
            return super.Ls();
        }
        Window window = this.aTD.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.aTD.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.aTD.isLandScape() == (this.aTD.getResources().getConfiguration().orientation == 2)) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.p.a.a aVar) {
        this.aTB = aVar;
        com.baidu.swan.apps.ae.b FD = FD();
        if (FD != null) {
            FD.a(aVar);
        }
    }
}
