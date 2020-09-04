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
/* loaded from: classes8.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cwX;
    private String duD;
    private com.baidu.swan.games.inspector.b duE = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a duF = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aay() {
        super.aay();
        if (this.cwS != null && this.cwS.XZ() != null) {
            b.a XZ = this.cwS.XZ();
            f fVar = new f();
            fVar.mFrom = h.jv(1);
            fVar.mAppId = XZ.getAppId();
            fVar.mSource = XZ.aqN();
            fVar.mType = "show";
            fVar.rz(XZ.aqT().getString("ubc"));
            fVar.bO(h.rq(XZ.aqP()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.eJ(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aaz() {
        super.aaz();
        com.baidu.swan.apps.media.b.eJ(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion arA() {
        return com.baidu.swan.games.j.a.aNC().akn();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a arB() {
        if (this.cwP == null) {
            this.cwP = com.baidu.swan.apps.core.turbo.d.ajS().ajT().br(AppRuntime.getAppContext());
            i.dJ(true);
        }
        this.cwP.v((ViewGroup) this.cwS.findViewById(16908290));
        return this.cwP;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String arF() {
        return TextUtils.isEmpty(this.duD) ? "" : this.duD;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        super.H(activity);
        this.cgY.setAutoAttachEnable(false);
        return this.cgY;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cha == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cha = new SwanAppPropertyWindow(activity);
            this.cha.setVisibility(8);
            viewGroup.addView(this.cha);
        }
        return this.cha;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.akn());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.cwX);
                a.this.cwX = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cnG) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.aqZ()) {
                                    if (com.baidu.swan.games.c.d.aMC().aMN()) {
                                        a.this.H(a.this.cwS).setVisibility(0);
                                        a.this.arB().ag(a.this.cgY);
                                        com.baidu.swan.apps.console.a.dH(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.dI(false);
                                        bVar.eG(false);
                                    }
                                }
                                a.this.duE.a(bVar3, a.this.cwS);
                                a.this.duD = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dui);
                                com.baidu.swan.games.y.a.aPA().c(bVar3.dui);
                            }
                        }
                    }
                };
                ak.k(a.this.cwX);
            }
        });
        com.baidu.swan.games.j.a.aNC().e(bVar);
        com.baidu.swan.games.j.a.aNC().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aNC().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> arK() {
        return arL();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> agY() {
        return arK();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> arL() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cwS == null) {
            return super.arL();
        }
        Window window = this.cwS.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cwS.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cwS.isLandScape() == z) {
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
        this.cwQ = aVar;
        com.baidu.swan.apps.runtime.e agn = agn();
        if (agn != null) {
            agn.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a arM() {
        return this.duF;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean arO() {
        return this.cwU;
    }
}
