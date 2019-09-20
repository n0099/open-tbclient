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
    private Runnable aAu;
    private String bjE;
    private SwanCoreVersion bjF;
    private com.baidu.swan.games.inspector.b bjG = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xl() {
        super.xl();
        if (this.aAp != null && this.aAp.vP() != null) {
            com.baidu.swan.apps.v.b.b vP = this.aAp.vP();
            f fVar = new f();
            fVar.mFrom = e.dQ(1);
            fVar.mAppId = this.aAp.vP().getAppId();
            fVar.mSource = this.aAp.vP().FK();
            fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
            fVar.ak(e.hv(vP.FL()));
            e.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.bx(true);
        com.baidu.swan.games.n.a.SC().bz(false);
        com.baidu.swan.apps.u.a.EQ().xl();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void xm() {
        super.xm();
        com.baidu.swan.apps.media.b.bx(false);
        com.baidu.swan.apps.u.a.EQ().xm();
        com.baidu.swan.games.n.a.SC().bz(true);
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
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Cm());
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.m.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, final com.baidu.swan.apps.install.a aVar) {
                ac.j(a.this.aAu);
                a.this.aAu = new Runnable() { // from class: com.baidu.swan.games.m.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.auT) {
                            a.c cVar = (a.c) aVar;
                            if (i == 0 && cVar != null && bVar2 != null) {
                                if (bVar.FV()) {
                                    if (com.baidu.swan.games.c.a.b.Rs().RC()) {
                                        a.this.F(a.this.aAp).setVisibility(0);
                                        a.this.Gp().N(a.this.aqZ);
                                        com.baidu.swan.apps.console.a.aU(true);
                                        c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.aV(false);
                                        bVar.aW(false);
                                    }
                                }
                                a.this.bjG.a(cVar, a.this.aAp);
                                bVar2.a(0, cVar);
                                a.this.bjE = cVar.bjh;
                                a.this.b(cVar.bjj);
                                com.baidu.swan.games.subpackage.a.Tt().c(cVar.bjj);
                            }
                        }
                    }
                };
                ac.i(a.this.aAu);
            }
        });
        y(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a Gp() {
        if (this.aAm == null) {
            this.aAm = com.baidu.swan.apps.core.j.c.BU().BV().aI(AppRuntime.getAppContext());
            com.baidu.swan.games.c.f.aW(true);
        }
        this.aAm.e((ViewGroup) this.aAp.findViewById(16908290));
        return this.aAm;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String Gs() {
        return TextUtils.isEmpty(this.bjE) ? "" : this.bjE;
    }

    public void y(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bjF != null) {
            bVar.a(this.bjF);
        } else {
            this.bjF = bVar.Cm();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView F(Activity activity) {
        super.F(activity);
        this.aqZ.setAutoAttachEnable(false);
        return this.aqZ;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow G(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.arc == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.arc = new SwanAppPropertyWindow(activity);
            this.arc.setVisibility(8);
            viewGroup.addView(this.arc);
        }
        return this.arc;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion Go() {
        return this.bjF;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gx() {
        return Gy();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> Ah() {
        return Gx();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gy() {
        int i;
        int i2;
        View decorView;
        if (this.aAp == null) {
            return super.Gy();
        }
        Window window = this.aAp.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.aAp.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.aAp.isLandScape() == (this.aAp.getResources().getConfiguration().orientation == 2)) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.p.a.a aVar) {
        this.aAn = aVar;
        com.baidu.swan.apps.ae.b AI = AI();
        if (AI != null) {
            AI.a(aVar);
        }
    }
}
