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
    private Runnable bzs;
    private String cpP;
    private com.baidu.swan.games.inspector.b cpQ = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.p.a cpR = new com.baidu.swan.games.p.a();

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Iy() {
        super.Iy();
        if (this.bzn != null && this.bzn.GE() != null) {
            b.a GE = this.bzn.GE();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(1);
            fVar.mAppId = GE.getAppId();
            fVar.mSource = GE.VJ();
            fVar.mType = "show";
            fVar.lR(GE.VP().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lI(GE.VL()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.cR(true);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Iz() {
        super.Iz();
        com.baidu.swan.apps.media.b.cR(false);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.i.a.release();
        com.baidu.swan.d.c.deleteFile(l.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion Wv() {
        return com.baidu.swan.games.i.a.anY().QQ();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.a Ww() {
        if (this.bzk == null) {
            this.bzk = com.baidu.swan.apps.core.k.d.Qw().Qx().bw(AppRuntime.getAppContext());
            i.ch(true);
        }
        this.bzk.m((ViewGroup) this.bzn.findViewById(16908290));
        return this.bzk;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public String WA() {
        return TextUtils.isEmpty(this.cpP) ? "" : this.cpP;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        super.O(activity);
        this.bno.setAutoAttachEnable(false);
        return this.bno;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bnq == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bnq = new SwanAppPropertyWindow(activity);
            this.bnq.setVisibility(8);
            viewGroup.addView(this.bnq);
        }
        return this.bnq;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.QQ());
        }
        com.baidu.swan.games.k.a.c(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.o.a.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, final com.baidu.swan.apps.t.a aVar) {
                ai.k(a.this.bzs);
                a.this.bzs = new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.VV()) {
                                    if (com.baidu.swan.games.b.d.amX().ani()) {
                                        a.this.O(a.this.bzn).setVisibility(0);
                                        a.this.Ww().ad(a.this.bno);
                                        com.baidu.swan.apps.console.a.cf(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.cg(false);
                                        bVar.cN(false);
                                    }
                                }
                                a.this.cpQ.a(bVar3, a.this.bzn);
                                a.this.cpP = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.cpt);
                                com.baidu.swan.games.x.a.apQ().c(bVar3.cpt);
                            }
                        }
                    }
                };
                ai.j(a.this.bzs);
            }
        });
        com.baidu.swan.games.i.a.anY().e(bVar);
        com.baidu.swan.games.i.a.anY().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.i.a.anY().E(null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WF() {
        return WG();
    }

    @Override // com.baidu.swan.apps.y.b
    @NonNull
    public Pair<Integer, Integer> Oa() {
        return WF();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WG() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.bzn == null) {
            return super.WG();
        }
        Window window = this.bzn.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.bzn.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.bzn.isLandScape() == z) {
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
        this.bzl = aVar;
        com.baidu.swan.apps.runtime.e OA = OA();
        if (OA != null) {
            OA.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a WH() {
        return this.cpR;
    }
}
