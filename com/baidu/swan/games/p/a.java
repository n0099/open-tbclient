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
import com.baidu.swan.apps.aq.al;
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
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cpl;
    private String dkr;
    private com.baidu.swan.games.inspector.b dks = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a dkt = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void Uw() {
        super.Uw();
        if (this.cpg != null && this.cpg.Se() != null) {
            b.a Se = this.cpg.Se();
            f fVar = new f();
            fVar.mFrom = h.ho(1);
            fVar.mAppId = Se.getAppId();
            fVar.mSource = Se.ajg();
            fVar.mType = "show";
            fVar.py(Se.ajm().getString("ubc"));
            fVar.bG(h.pp(Se.aji()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.es(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void Ux() {
        super.Ux();
        com.baidu.swan.apps.media.b.es(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.d.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion ajT() {
        return com.baidu.swan.games.j.a.aEO().adQ();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a ajU() {
        if (this.cpd == null) {
            this.cpd = com.baidu.swan.apps.core.turbo.d.adw().adx().bk(AppRuntime.getAppContext());
            i.dz(true);
        }
        this.cpd.u((ViewGroup) this.cpg.findViewById(16908290));
        return this.cpd;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String ajY() {
        return TextUtils.isEmpty(this.dkr) ? "" : this.dkr;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        super.H(activity);
        this.caW.setAutoAttachEnable(false);
        return this.caW;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.caY == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.caY = new SwanAppPropertyWindow(activity);
            this.caY.setVisibility(8);
            viewGroup.addView(this.caY);
        }
        return this.caY;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.adQ());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                al.o(a.this.cpl);
                a.this.cpl = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.chl) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.ajs()) {
                                    if (com.baidu.swan.games.c.d.aDN().aDY()) {
                                        a.this.H(a.this.cpg).setVisibility(0);
                                        a.this.ajU().af(a.this.caW);
                                        com.baidu.swan.apps.console.a.dx(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.dy(false);
                                        bVar.en(false);
                                    }
                                }
                                a.this.dks.a(bVar3, a.this.cpg);
                                a.this.dkr = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.djW);
                                com.baidu.swan.games.y.a.aGJ().c(bVar3.djW);
                            }
                        }
                    }
                };
                al.n(a.this.cpl);
            }
        });
        com.baidu.swan.games.j.a.aEO().e(bVar);
        com.baidu.swan.games.j.a.aEO().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aEO().p(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> akd() {
        return ake();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> aaN() {
        return akd();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> ake() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cpg == null) {
            return super.ake();
        }
        Window window = this.cpg.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cpg.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cpg.isLandScape() == z) {
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
        this.cpe = aVar;
        com.baidu.swan.apps.runtime.e aad = aad();
        if (aad != null) {
            aad.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a akf() {
        return this.dkt;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean akh() {
        return this.cpi;
    }
}
