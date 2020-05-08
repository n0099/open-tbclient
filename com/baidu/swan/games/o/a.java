package com.baidu.swan.games.o;

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
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.games.b.i;
import com.baidu.swan.games.h.l;
import com.baidu.swan.games.k.a;
import java.io.File;
/* loaded from: classes11.dex */
public class a extends com.baidu.swan.apps.y.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable bXP;
    private String cPb;
    private com.baidu.swan.games.inspector.b cPc = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.p.a cPd = new com.baidu.swan.games.p.a();

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Qm() {
        super.Qm();
        if (this.bXK != null && this.bXK.Ov() != null) {
            b.a Ov = this.bXK.Ov();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(1);
            fVar.mAppId = Ov.getAppId();
            fVar.mSource = Ov.adA();
            fVar.mType = "show";
            fVar.nd(Ov.adG().getString("ubc"));
            fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ov.adC()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.dO(true);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Qn() {
        super.Qn();
        com.baidu.swan.apps.media.b.dO(false);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.i.a.release();
        com.baidu.swan.d.c.deleteFile(l.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion aem() {
        return com.baidu.swan.games.i.a.awo().YH();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.a aen() {
        if (this.bXH == null) {
            this.bXH = com.baidu.swan.apps.core.k.d.Yn().Yo().aX(AppRuntime.getAppContext());
            i.de(true);
        }
        this.bXH.n((ViewGroup) this.bXK.findViewById(16908290));
        return this.bXH;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public String aer() {
        return TextUtils.isEmpty(this.cPb) ? "" : this.cPb;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public FullScreenFloatView K(Activity activity) {
        super.K(activity);
        this.bLN.setAutoAttachEnable(false);
        return this.bLN;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bLP == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bLP = new SwanAppPropertyWindow(activity);
            this.bLP.setVisibility(8);
            viewGroup.addView(this.bLP);
        }
        return this.bLP;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.YH());
        }
        com.baidu.swan.games.k.a.c(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.o.a.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, final com.baidu.swan.apps.t.a aVar) {
                ai.n(a.this.bXP);
                a.this.bXP = new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.bRa) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.adM()) {
                                    if (com.baidu.swan.games.b.d.avn().avy()) {
                                        a.this.K(a.this.bXK).setVisibility(0);
                                        a.this.aen().ad(a.this.bLN);
                                        com.baidu.swan.apps.console.a.dc(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.dd(false);
                                        bVar.dK(false);
                                    }
                                }
                                a.this.cPc.a(bVar3, a.this.bXK);
                                a.this.cPb = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.cOG);
                                com.baidu.swan.games.x.a.ayf().c(bVar3.cOG);
                            }
                        }
                    }
                };
                ai.m(a.this.bXP);
            }
        });
        com.baidu.swan.games.i.a.awo().e(bVar);
        com.baidu.swan.games.i.a.awo().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.i.a.awo().q(null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> aew() {
        return aex();
    }

    @Override // com.baidu.swan.apps.y.b
    @NonNull
    public Pair<Integer, Integer> VQ() {
        return aew();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> aex() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.bXK == null) {
            return super.aex();
        }
        Window window = this.bXK.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.bXK.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.bXK.isLandScape() == z) {
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
    public void b(com.baidu.swan.games.s.a.a aVar) {
        this.bXI = aVar;
        com.baidu.swan.apps.runtime.e Wq = Wq();
        if (Wq != null) {
            Wq.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a aey() {
        return this.cPd;
    }
}
