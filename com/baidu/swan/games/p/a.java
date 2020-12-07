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
/* loaded from: classes25.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable deH;
    private String eck;
    private com.baidu.swan.games.inspector.b ecl = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a ecm = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void akN() {
        super.akN();
        if (this.deC != null && this.deC.aio() != null) {
            b.a aio = this.deC.aio();
            f fVar = new f();
            fVar.mFrom = h.kS(1);
            fVar.mAppId = aio.getAppId();
            fVar.mSource = aio.aBe();
            fVar.mType = "show";
            fVar.tO(aio.aBk().getString("ubc"));
            fVar.cd(h.tF(aio.aBg()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fR(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void akO() {
        super.akO();
        com.baidu.swan.apps.media.b.fR(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion aBR() {
        return com.baidu.swan.games.j.a.aXN().auD();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a aBS() {
        if (this.dez == null) {
            this.dez = com.baidu.swan.apps.core.turbo.d.aui().auj().cc(AppRuntime.getAppContext());
            i.eR(true);
        }
        this.dez.z((ViewGroup) this.deC.findViewById(16908290));
        return this.dez;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String aBW() {
        return TextUtils.isEmpty(this.eck) ? "" : this.eck;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView I(Activity activity) {
        super.I(activity);
        this.cOR.setAutoAttachEnable(false);
        return this.cOR;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cOT == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cOT = new SwanAppPropertyWindow(activity);
            this.cOT.setVisibility(8);
            viewGroup.addView(this.cOT);
        }
        return this.cOT;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.auD());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.deH);
                a.this.deH = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cVv) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.aBq()) {
                                    if (com.baidu.swan.games.c.d.aWN().aWY()) {
                                        a.this.I(a.this.deC).setVisibility(0);
                                        a.this.aBS().ar(a.this.cOR);
                                        com.baidu.swan.apps.console.a.eP(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.eQ(false);
                                        bVar.fO(false);
                                    }
                                }
                                a.this.ecl.a(bVar3, a.this.deC);
                                a.this.eck = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.ebP);
                                com.baidu.swan.games.y.a.aZL().c(bVar3.ebP);
                            }
                        }
                    }
                };
                ak.k(a.this.deH);
            }
        });
        com.baidu.swan.games.j.a.aXN().e(bVar);
        com.baidu.swan.games.j.a.aXN().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aXN().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aCb() {
        return aCc();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> arn() {
        return aCb();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aCc() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.deC == null) {
            return super.aCc();
        }
        Window window = this.deC.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.deC.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.deC.isLandScape() == z) {
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
        this.deA = aVar;
        com.baidu.swan.apps.runtime.e aqC = aqC();
        if (aqC != null) {
            aqC.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a aCd() {
        return this.ecm;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aCf() {
        return this.deE;
    }
}
