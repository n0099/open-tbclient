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
/* loaded from: classes7.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cXI;
    private String dVm;
    private com.baidu.swan.games.inspector.b dVn = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a dVo = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void ahF() {
        super.ahF();
        if (this.cXD != null && this.cXD.afg() != null) {
            b.a afg = this.cXD.afg();
            f fVar = new f();
            fVar.mFrom = h.ku(1);
            fVar.mAppId = afg.getAppId();
            fVar.mSource = afg.axV();
            fVar.mType = "show";
            fVar.th(afg.ayb().getString("ubc"));
            fVar.cb(h.sY(afg.axX()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fC(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void ahG() {
        super.ahG();
        com.baidu.swan.apps.media.b.fC(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion ayI() {
        return com.baidu.swan.games.j.a.aUI().arv();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a ayJ() {
        if (this.cXA == null) {
            this.cXA = com.baidu.swan.apps.core.turbo.d.ara().arb().bw(AppRuntime.getAppContext());
            i.eC(true);
        }
        this.cXA.z((ViewGroup) this.cXD.findViewById(16908290));
        return this.cXA;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String ayN() {
        return TextUtils.isEmpty(this.dVm) ? "" : this.dVm;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView I(Activity activity) {
        super.I(activity);
        this.cHY.setAutoAttachEnable(false);
        return this.cHY;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cIa == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cIa = new SwanAppPropertyWindow(activity);
            this.cIa.setVisibility(8);
            viewGroup.addView(this.cIa);
        }
        return this.cIa;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.arv());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.cXI);
                a.this.cXI = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cOC) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.ayh()) {
                                    if (com.baidu.swan.games.c.d.aTI().aTT()) {
                                        a.this.I(a.this.cXD).setVisibility(0);
                                        a.this.ayJ().ap(a.this.cHY);
                                        com.baidu.swan.apps.console.a.eA(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.eB(false);
                                        bVar.fz(false);
                                    }
                                }
                                a.this.dVn.a(bVar3, a.this.cXD);
                                a.this.dVm = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dUR);
                                com.baidu.swan.games.y.a.aWG().c(bVar3.dUR);
                            }
                        }
                    }
                };
                ak.k(a.this.cXI);
            }
        });
        com.baidu.swan.games.j.a.aUI().e(bVar);
        com.baidu.swan.games.j.a.aUI().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aUI().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> ayS() {
        return ayT();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> aof() {
        return ayS();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> ayT() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cXD == null) {
            return super.ayT();
        }
        Window window = this.cXD.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cXD.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cXD.isLandScape() == z) {
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
        this.cXB = aVar;
        com.baidu.swan.apps.runtime.e anu = anu();
        if (anu != null) {
            anu.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a ayU() {
        return this.dVo;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean ayW() {
        return this.cXF;
    }
}
