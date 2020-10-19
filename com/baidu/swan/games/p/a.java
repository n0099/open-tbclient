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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.games.c.i;
import com.baidu.swan.games.i.n;
import com.baidu.swan.games.l.a;
import java.io.File;
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cLd;
    private String dIF;
    private com.baidu.swan.games.inspector.b dIG = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a dIH = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void adT() {
        super.adT();
        if (this.cKY != null && this.cKY.abu() != null) {
            b.a abu = this.cKY.abu();
            f fVar = new f();
            fVar.mFrom = h.kd(1);
            fVar.mAppId = abu.getAppId();
            fVar.mSource = abu.auj();
            fVar.mType = "show";
            fVar.sF(abu.aup().getString("ubc"));
            fVar.bY(h.sw(abu.aul()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fd(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void adU() {
        super.adU();
        com.baidu.swan.apps.media.b.fd(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion auW() {
        return com.baidu.swan.games.j.a.aQW().anI();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a auX() {
        if (this.cKV == null) {
            this.cKV = com.baidu.swan.apps.core.turbo.d.ann().ano().bw(AppRuntime.getAppContext());
            i.ed(true);
        }
        this.cKV.A((ViewGroup) this.cKY.findViewById(16908290));
        return this.cKV;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String avb() {
        return TextUtils.isEmpty(this.dIF) ? "" : this.dIF;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView J(Activity activity) {
        super.J(activity);
        this.cvt.setAutoAttachEnable(false);
        return this.cvt;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow K(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cvv == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cvv = new SwanAppPropertyWindow(activity);
            this.cvv.setVisibility(8);
            viewGroup.addView(this.cvv);
        }
        return this.cvv;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.anI());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.cLd);
                a.this.cLd = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cBX) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.auv()) {
                                    if (com.baidu.swan.games.c.d.aPW().aQh()) {
                                        a.this.J(a.this.cKY).setVisibility(0);
                                        a.this.auX().aj(a.this.cvt);
                                        com.baidu.swan.apps.console.a.eb(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.ec(false);
                                        bVar.fa(false);
                                    }
                                }
                                a.this.dIG.a(bVar3, a.this.cKY);
                                a.this.dIF = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dIk);
                                com.baidu.swan.games.y.a.aSU().c(bVar3.dIk);
                            }
                        }
                    }
                };
                ak.k(a.this.cLd);
            }
        });
        com.baidu.swan.games.j.a.aQW().e(bVar);
        com.baidu.swan.games.j.a.aQW().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aQW().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> avg() {
        return avh();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> akt() {
        return avg();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> avh() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cKY == null) {
            return super.avh();
        }
        Window window = this.cKY.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cKY.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cKY.isLandScape() == z) {
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
        this.cKW = aVar;
        com.baidu.swan.apps.runtime.e ajI = ajI();
        if (ajI != null) {
            ajI.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a avi() {
        return this.dIH;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean avk() {
        return this.cLa;
    }
}
