package com.baidu.swan.games.p;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.games.c.i;
import com.baidu.swan.games.i.n;
import com.baidu.swan.games.l.a;
import java.io.File;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.w.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cZT;
    private com.baidu.swan.games.inspector.b cZU = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a cZV = new com.baidu.swan.games.q.a();
    private Runnable ciq;

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void SQ() {
        super.SQ();
        if (this.cil != null && this.cil.QJ() != null) {
            b.a QJ = this.cil.QJ();
            f fVar = new f();
            fVar.mFrom = h.gU(1);
            fVar.mAppId = QJ.getAppId();
            fVar.mSource = QJ.agK();
            fVar.mType = "show";
            fVar.oG(QJ.agQ().getString("ubc"));
            fVar.bu(h.ox(QJ.agM()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.ef(true);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void SR() {
        super.SR();
        com.baidu.swan.apps.media.b.ef(false);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.e.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public SwanCoreVersion ahx() {
        return com.baidu.swan.games.j.a.aAd().abG();
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.adaptation.b.a ahy() {
        if (this.cii == null) {
            this.cii = com.baidu.swan.apps.core.turbo.d.abl().abm().bh(AppRuntime.getAppContext());
            i.dr(true);
        }
        this.cii.r((ViewGroup) this.cil.findViewById(16908290));
        return this.cii;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public String ahC() {
        return TextUtils.isEmpty(this.cZT) ? "" : this.cZT;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public FullScreenFloatView I(Activity activity) {
        super.I(activity);
        this.bUL.setAutoAttachEnable(false);
        return this.bUL;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bUO == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bUO = new SwanAppPropertyWindow(activity);
            this.bUO.setVisibility(8);
            viewGroup.addView(this.bUO);
        }
        return this.bUO;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.abG());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                aj.o(a.this.ciq);
                a.this.ciq = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.caM) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.agW()) {
                                    if (com.baidu.swan.games.c.d.azc().azn()) {
                                        a.this.I(a.this.cil).setVisibility(0);
                                        a.this.ahy().ac(a.this.bUL);
                                        com.baidu.swan.apps.console.a.dp(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.dq(false);
                                        bVar.ea(false);
                                    }
                                }
                                a.this.cZU.a(bVar3, a.this.cil);
                                a.this.cZT = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.cZy);
                                com.baidu.swan.games.y.a.aBW().c(bVar3.cZy);
                            }
                        }
                    }
                };
                aj.n(a.this.ciq);
            }
        });
        com.baidu.swan.games.j.a.aAd().e(bVar);
        com.baidu.swan.games.j.a.aAd().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aAd().p(null);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> ahH() {
        return ahI();
    }

    @Override // com.baidu.swan.apps.w.b
    @NonNull
    public Pair<Integer, Integer> YD() {
        return ahH();
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> ahI() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cil == null) {
            return super.ahI();
        }
        Window window = this.cil.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cil.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cil.isLandScape() == z) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        if (DEBUG) {
            Log.d("GamesControllerImpl", "getCurScreenSize width:" + i + ",height:" + i2);
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.t.a.a aVar) {
        this.cij = aVar;
        com.baidu.swan.apps.runtime.e Zc = Zc();
        if (Zc != null) {
            Zc.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public com.baidu.swan.games.q.a ahJ() {
        return this.cZV;
    }

    @Override // com.baidu.swan.apps.w.d
    public boolean ahL() {
        return this.cin;
    }
}
