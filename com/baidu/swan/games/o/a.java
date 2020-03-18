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
    private Runnable bzD;
    private String cqa;
    private com.baidu.swan.games.inspector.b cqb = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.p.a cqc = new com.baidu.swan.games.p.a();

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void IB() {
        super.IB();
        if (this.bzy != null && this.bzy.GJ() != null) {
            b.a GJ = this.bzy.GJ();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(1);
            fVar.mAppId = GJ.getAppId();
            fVar.mSource = GJ.VM();
            fVar.mType = "show";
            fVar.lQ(GJ.VS().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lH(GJ.VO()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.cS(true);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void IC() {
        super.IC();
        com.baidu.swan.apps.media.b.cS(false);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.i.a.release();
        com.baidu.swan.d.c.deleteFile(l.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion Wy() {
        return com.baidu.swan.games.i.a.aob().QT();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.a Wz() {
        if (this.bzv == null) {
            this.bzv = com.baidu.swan.apps.core.k.d.Qz().QA().bv(AppRuntime.getAppContext());
            i.ci(true);
        }
        this.bzv.m((ViewGroup) this.bzy.findViewById(16908290));
        return this.bzv;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public String WD() {
        return TextUtils.isEmpty(this.cqa) ? "" : this.cqa;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        super.O(activity);
        this.bnB.setAutoAttachEnable(false);
        return this.bnB;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bnD == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bnD = new SwanAppPropertyWindow(activity);
            this.bnD.setVisibility(8);
            viewGroup.addView(this.bnD);
        }
        return this.bnD;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.QT());
        }
        com.baidu.swan.games.k.a.c(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.o.a.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, final com.baidu.swan.apps.t.a aVar) {
                ai.k(a.this.bzD);
                a.this.bzD = new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.VY()) {
                                    if (com.baidu.swan.games.b.d.ana().anl()) {
                                        a.this.O(a.this.bzy).setVisibility(0);
                                        a.this.Wz().ad(a.this.bnB);
                                        com.baidu.swan.apps.console.a.cg(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.ch(false);
                                        bVar.cO(false);
                                    }
                                }
                                a.this.cqb.a(bVar3, a.this.bzy);
                                a.this.cqa = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.cpF);
                                com.baidu.swan.games.x.a.apT().c(bVar3.cpF);
                            }
                        }
                    }
                };
                ai.j(a.this.bzD);
            }
        });
        com.baidu.swan.games.i.a.aob().e(bVar);
        com.baidu.swan.games.i.a.aob().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.i.a.aob().E(null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WI() {
        return WJ();
    }

    @Override // com.baidu.swan.apps.y.b
    @NonNull
    public Pair<Integer, Integer> Od() {
        return WI();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WJ() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.bzy == null) {
            return super.WJ();
        }
        Window window = this.bzy.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.bzy.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.bzy.isLandScape() == z) {
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
        this.bzw = aVar;
        com.baidu.swan.apps.runtime.e OD = OD();
        if (OD != null) {
            OD.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a WK() {
        return this.cqc;
    }
}
