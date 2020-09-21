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
/* loaded from: classes3.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cyY;
    private String dwE;
    private com.baidu.swan.games.inspector.b dwF = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a dwG = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void abh() {
        super.abh();
        if (this.cyT != null && this.cyT.YI() != null) {
            b.a YI = this.cyT.YI();
            f fVar = new f();
            fVar.mFrom = h.jG(1);
            fVar.mAppId = YI.getAppId();
            fVar.mSource = YI.arx();
            fVar.mType = "show";
            fVar.rS(YI.arD().getString("ubc"));
            fVar.bR(h.rJ(YI.arz()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.eH(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void abi() {
        super.abi();
        com.baidu.swan.apps.media.b.eH(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion ask() {
        return com.baidu.swan.games.j.a.aOn().akX();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a asl() {
        if (this.cyQ == null) {
            this.cyQ = com.baidu.swan.apps.core.turbo.d.akC().akD().bq(AppRuntime.getAppContext());
            i.dH(true);
        }
        this.cyQ.y((ViewGroup) this.cyT.findViewById(16908290));
        return this.cyQ;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String asq() {
        return TextUtils.isEmpty(this.dwE) ? "" : this.dwE;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView I(Activity activity) {
        super.I(activity);
        this.cja.setAutoAttachEnable(false);
        return this.cja;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cjc == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cjc = new SwanAppPropertyWindow(activity);
            this.cjc.setVisibility(8);
            viewGroup.addView(this.cjc);
        }
        return this.cjc;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.akX());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.cyY);
                a.this.cyY = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cpJ) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.arJ()) {
                                    if (com.baidu.swan.games.c.d.aNn().aNy()) {
                                        a.this.I(a.this.cyT).setVisibility(0);
                                        a.this.asl().ai(a.this.cja);
                                        com.baidu.swan.apps.console.a.dF(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.dG(false);
                                        bVar.eE(false);
                                    }
                                }
                                a.this.dwF.a(bVar3, a.this.cyT);
                                a.this.dwE = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dwj);
                                com.baidu.swan.games.y.a.aQl().c(bVar3.dwj);
                            }
                        }
                    }
                };
                ak.k(a.this.cyY);
            }
        });
        com.baidu.swan.games.j.a.aOn().e(bVar);
        com.baidu.swan.games.j.a.aOn().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aOn().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> asv() {
        return asw();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> ahI() {
        return asv();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> asw() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cyT == null) {
            return super.asw();
        }
        Window window = this.cyT.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cyT.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cyT.isLandScape() == z) {
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
        this.cyR = aVar;
        com.baidu.swan.apps.runtime.e agX = agX();
        if (agX != null) {
            agX.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a asx() {
        return this.dwG;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean asz() {
        return this.cyV;
    }
}
