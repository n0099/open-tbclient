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
import com.baidu.sapi2.views.SmsLoginView;
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
    private Runnable azW;
    private String bjg;
    private SwanCoreVersion bjh;
    private com.baidu.swan.games.inspector.b bji = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xh() {
        super.xh();
        if (this.azR != null && this.azR.vL() != null) {
            com.baidu.swan.apps.v.b.b vL = this.azR.vL();
            f fVar = new f();
            fVar.mFrom = e.dP(1);
            fVar.mAppId = this.azR.vL().getAppId();
            fVar.mSource = this.azR.vL().FG();
            fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
            fVar.ak(e.ht(vL.FH()));
            e.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.bx(true);
        com.baidu.swan.games.n.a.Sy().bz(false);
        com.baidu.swan.apps.u.a.EM().xh();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xi() {
        super.xi();
        com.baidu.swan.apps.media.b.bx(false);
        com.baidu.swan.apps.u.a.EM().xi();
        com.baidu.swan.games.n.a.Sy().bz(true);
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
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Ci());
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.m.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, final com.baidu.swan.apps.install.a aVar) {
                ac.j(a.this.azW);
                a.this.azW = new Runnable() { // from class: com.baidu.swan.games.m.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.auv) {
                            a.c cVar = (a.c) aVar;
                            if (i == 0 && cVar != null && bVar2 != null) {
                                if (bVar.FR()) {
                                    if (com.baidu.swan.games.c.a.b.Ro().Ry()) {
                                        a.this.F(a.this.azR).setVisibility(0);
                                        a.this.Gl().N(a.this.aqB);
                                        com.baidu.swan.apps.console.a.aU(true);
                                        c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.aV(false);
                                        bVar.aW(false);
                                    }
                                }
                                a.this.bji.a(cVar, a.this.azR);
                                bVar2.a(0, cVar);
                                a.this.bjg = cVar.biJ;
                                a.this.b(cVar.biL);
                                com.baidu.swan.games.subpackage.a.Tp().c(cVar.biL);
                            }
                        }
                    }
                };
                ac.i(a.this.azW);
            }
        });
        y(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a Gl() {
        if (this.azO == null) {
            this.azO = com.baidu.swan.apps.core.j.c.BQ().BR().aI(AppRuntime.getAppContext());
            com.baidu.swan.games.c.f.aW(true);
        }
        this.azO.e((ViewGroup) this.azR.findViewById(16908290));
        return this.azO;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String Go() {
        return TextUtils.isEmpty(this.bjg) ? "" : this.bjg;
    }

    public void y(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bjh != null) {
            bVar.a(this.bjh);
        } else {
            this.bjh = bVar.Ci();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView F(Activity activity) {
        super.F(activity);
        this.aqB.setAutoAttachEnable(false);
        return this.aqB;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow G(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.aqE == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aqE = new SwanAppPropertyWindow(activity);
            this.aqE.setVisibility(8);
            viewGroup.addView(this.aqE);
        }
        return this.aqE;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Gk() {
        return this.bjh;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gt() {
        return Gu();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> Ad() {
        return Gt();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gu() {
        int i;
        int i2;
        View decorView;
        if (this.azR == null) {
            return super.Gu();
        }
        Window window = this.azR.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.azR.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.azR.isLandScape() == (this.azR.getResources().getConfiguration().orientation == 2)) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.p.a.a aVar) {
        this.azP = aVar;
        com.baidu.swan.apps.ae.b AE = AE();
        if (AE != null) {
            AE.a(aVar);
        }
    }
}
