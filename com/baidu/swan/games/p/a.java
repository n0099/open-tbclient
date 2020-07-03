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
    private Runnable cne;
    private String deI;
    private com.baidu.swan.games.inspector.b deJ = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a deK = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void TW() {
        super.TW();
        if (this.cmZ != null && this.cmZ.RP() != null) {
            b.a RP = this.cmZ.RP();
            f fVar = new f();
            fVar.mFrom = h.hf(1);
            fVar.mAppId = RP.getAppId();
            fVar.mSource = RP.ahQ();
            fVar.mType = "show";
            fVar.oO(RP.ahW().getString("ubc"));
            fVar.bB(h.oF(RP.ahS()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.ek(true);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void TX() {
        super.TX();
        com.baidu.swan.apps.media.b.ek(false);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.e.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public SwanCoreVersion aiD() {
        return com.baidu.swan.games.j.a.aBj().acM();
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.adaptation.b.a aiE() {
        if (this.cmW == null) {
            this.cmW = com.baidu.swan.apps.core.turbo.d.acr().acs().bi(AppRuntime.getAppContext());
            i.dw(true);
        }
        this.cmW.t((ViewGroup) this.cmZ.findViewById(16908290));
        return this.cmW;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public String aiI() {
        return TextUtils.isEmpty(this.deI) ? "" : this.deI;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public FullScreenFloatView I(Activity activity) {
        super.I(activity);
        this.bZz.setAutoAttachEnable(false);
        return this.bZz;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bZC == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bZC = new SwanAppPropertyWindow(activity);
            this.bZC.setVisibility(8);
            viewGroup.addView(this.bZC);
        }
        return this.bZC;
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.acM());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                aj.o(a.this.cne);
                a.this.cne = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cfB) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.aic()) {
                                    if (com.baidu.swan.games.c.d.aAi().aAt()) {
                                        a.this.I(a.this.cmZ).setVisibility(0);
                                        a.this.aiE().ac(a.this.bZz);
                                        com.baidu.swan.apps.console.a.du(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.dv(false);
                                        bVar.ef(false);
                                    }
                                }
                                a.this.deJ.a(bVar3, a.this.cmZ);
                                a.this.deI = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dem);
                                com.baidu.swan.games.y.a.aDc().c(bVar3.dem);
                            }
                        }
                    }
                };
                aj.n(a.this.cne);
            }
        });
        com.baidu.swan.games.j.a.aBj().e(bVar);
        com.baidu.swan.games.j.a.aBj().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aBj().p(null);
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> aiN() {
        return aiO();
    }

    @Override // com.baidu.swan.apps.w.b
    @NonNull
    public Pair<Integer, Integer> ZJ() {
        return aiN();
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> aiO() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cmZ == null) {
            return super.aiO();
        }
        Window window = this.cmZ.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cmZ.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cmZ.isLandScape() == z) {
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
        this.cmX = aVar;
        com.baidu.swan.apps.runtime.e aai = aai();
        if (aai != null) {
            aai.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.w.b, com.baidu.swan.apps.w.d
    public com.baidu.swan.games.q.a aiP() {
        return this.deK;
    }

    @Override // com.baidu.swan.apps.w.d
    public boolean aiR() {
        return this.cnb;
    }
}
