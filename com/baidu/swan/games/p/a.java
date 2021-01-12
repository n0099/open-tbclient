package com.baidu.swan.games.p;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable deM;
    private String egv;
    private com.baidu.swan.games.inspector.b egw = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a egx = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aie() {
        super.aie();
        if (this.deH != null && this.deH.afB() != null) {
            b.a afB = this.deH.afB();
            f fVar = new f();
            fVar.mFrom = h.jr(1);
            fVar.mAppId = afB.getAppId();
            fVar.mSource = afB.ayC();
            fVar.mType = "show";
            fVar.sA(afB.ayI().getString("ubc"));
            fVar.cl(h.sq(afB.ayE()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fW(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aif() {
        super.aif();
        com.baidu.swan.apps.media.b.fW(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azp() {
        return com.baidu.swan.games.j.a.aWo().asb();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a azq() {
        if (this.deE == null) {
            this.deE = com.baidu.swan.apps.core.turbo.d.arG().arH().ci(AppRuntime.getAppContext());
            i.eW(true);
        }
        this.deE.C((ViewGroup) this.deH.findViewById(16908290));
        return this.deE;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String azu() {
        return TextUtils.isEmpty(this.egv) ? "" : this.egv;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        super.H(activity);
        this.cPa.setAutoAttachEnable(false);
        return this.cPa;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cPc == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cPc = new SwanAppPropertyWindow(activity);
            this.cPc.setVisibility(8);
            viewGroup.addView(this.cPc);
        }
        return this.cPc;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asb());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.k(a.this.deM);
                a.this.deM = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.ayO()) {
                                    if (com.baidu.swan.games.c.d.aVo().aVz()) {
                                        a.this.H(a.this.deH).setVisibility(0);
                                        a.this.azq().as(a.this.cPa);
                                        com.baidu.swan.apps.console.a.eU(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.eV(false);
                                        bVar.fT(false);
                                    }
                                }
                                a.this.egw.a(bVar3, a.this.deH);
                                a.this.egv = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.efZ);
                                com.baidu.swan.games.y.a.aYm().c(bVar3.efZ);
                            }
                        }
                    }
                };
                ak.j(a.this.deM);
            }
        });
        com.baidu.swan.games.j.a.aWo().e(bVar);
        com.baidu.swan.games.j.a.aWo().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aWo().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azz() {
        return azA();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> aoK() {
        return azz();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azA() {
        int i;
        int i2;
        int i3;
        int i4;
        View decorView;
        boolean z = false;
        if (this.deH == null) {
            return super.azA();
        }
        Window window = this.deH.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.deH.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.deH.isLandScape() != z) {
            i3 = i2;
            i4 = i;
        } else {
            i3 = i;
            i4 = i2;
        }
        if (DEBUG) {
            Log.d("GamesControllerImpl", "getCurScreenSize width:" + i4 + ",height:" + i3);
        }
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.t.a.a aVar) {
        this.deF = aVar;
        com.baidu.swan.apps.runtime.e anU = anU();
        if (anU != null) {
            anU.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a azB() {
        return this.egx;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azD() {
        return this.deJ;
    }
}
