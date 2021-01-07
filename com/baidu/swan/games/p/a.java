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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable djB;
    private String elh;
    private com.baidu.swan.games.inspector.b eli = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a elj = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void alY() {
        super.alY();
        if (this.djw != null && this.djw.ajv() != null) {
            b.a ajv = this.djw.ajv();
            f fVar = new f();
            fVar.mFrom = h.kX(1);
            fVar.mAppId = ajv.getAppId();
            fVar.mSource = ajv.aCw();
            fVar.mType = "show";
            fVar.tL(ajv.aCC().getString("ubc"));
            fVar.cl(h.tC(ajv.aCy()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.ga(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void alZ() {
        super.alZ();
        com.baidu.swan.apps.media.b.ga(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion aDj() {
        return com.baidu.swan.games.j.a.bai().avW();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a aDk() {
        if (this.djt == null) {
            this.djt = com.baidu.swan.apps.core.turbo.d.avB().avC().cj(AppRuntime.getAppContext());
            i.fa(true);
        }
        this.djt.C((ViewGroup) this.djw.findViewById(16908290));
        return this.djt;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String aDo() {
        return TextUtils.isEmpty(this.elh) ? "" : this.elh;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        super.H(activity);
        this.cTM.setAutoAttachEnable(false);
        return this.cTM;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cTO == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cTO = new SwanAppPropertyWindow(activity);
            this.cTO.setVisibility(8);
            viewGroup.addView(this.cTO);
        }
        return this.cTO;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.avW());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.k(a.this.djB);
                a.this.djB = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.aCI()) {
                                    if (com.baidu.swan.games.c.d.aZi().aZt()) {
                                        a.this.H(a.this.djw).setVisibility(0);
                                        a.this.aDk().as(a.this.cTM);
                                        com.baidu.swan.apps.console.a.eY(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.eZ(false);
                                        bVar.fX(false);
                                    }
                                }
                                a.this.eli.a(bVar3, a.this.djw);
                                a.this.elh = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.ekM);
                                com.baidu.swan.games.y.a.bcg().c(bVar3.ekM);
                            }
                        }
                    }
                };
                ak.j(a.this.djB);
            }
        });
        com.baidu.swan.games.j.a.bai().e(bVar);
        com.baidu.swan.games.j.a.bai().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.bai().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aDt() {
        return aDu();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> asG() {
        return aDt();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aDu() {
        int i;
        int i2;
        int i3;
        int i4;
        View decorView;
        boolean z = false;
        if (this.djw == null) {
            return super.aDu();
        }
        Window window = this.djw.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.djw.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.djw.isLandScape() != z) {
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
        this.dju = aVar;
        com.baidu.swan.apps.runtime.e arP = arP();
        if (arP != null) {
            arP.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a aDv() {
        return this.elj;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aDx() {
        return this.djy;
    }
}
