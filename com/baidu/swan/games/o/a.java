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
    private Runnable bzq;
    private String cpN;
    private com.baidu.swan.games.inspector.b cpO = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.p.a cpP = new com.baidu.swan.games.p.a();

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Iw() {
        super.Iw();
        if (this.bzl != null && this.bzl.GC() != null) {
            b.a GC = this.bzl.GC();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gs(1);
            fVar.mAppId = GC.getAppId();
            fVar.mSource = GC.VH();
            fVar.mType = "show";
            fVar.lR(GC.VN().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lI(GC.VJ()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.cR(true);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Ix() {
        super.Ix();
        com.baidu.swan.apps.media.b.cR(false);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.i.a.release();
        com.baidu.swan.d.c.deleteFile(l.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion Wt() {
        return com.baidu.swan.games.i.a.anW().QO();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.a Wu() {
        if (this.bzi == null) {
            this.bzi = com.baidu.swan.apps.core.k.d.Qu().Qv().bw(AppRuntime.getAppContext());
            i.ch(true);
        }
        this.bzi.m((ViewGroup) this.bzl.findViewById(16908290));
        return this.bzi;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public String Wy() {
        return TextUtils.isEmpty(this.cpN) ? "" : this.cpN;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        super.O(activity);
        this.bnm.setAutoAttachEnable(false);
        return this.bnm;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bno == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bno = new SwanAppPropertyWindow(activity);
            this.bno.setVisibility(8);
            viewGroup.addView(this.bno);
        }
        return this.bno;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.QO());
        }
        com.baidu.swan.games.k.a.c(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.o.a.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, final com.baidu.swan.apps.t.a aVar) {
                ai.k(a.this.bzq);
                a.this.bzq = new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.VT()) {
                                    if (com.baidu.swan.games.b.d.amV().ang()) {
                                        a.this.O(a.this.bzl).setVisibility(0);
                                        a.this.Wu().ad(a.this.bnm);
                                        com.baidu.swan.apps.console.a.cf(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.cg(false);
                                        bVar.cN(false);
                                    }
                                }
                                a.this.cpO.a(bVar3, a.this.bzl);
                                a.this.cpN = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.cpr);
                                com.baidu.swan.games.x.a.apO().c(bVar3.cpr);
                            }
                        }
                    }
                };
                ai.j(a.this.bzq);
            }
        });
        com.baidu.swan.games.i.a.anW().e(bVar);
        com.baidu.swan.games.i.a.anW().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.i.a.anW().E(null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WD() {
        return WE();
    }

    @Override // com.baidu.swan.apps.y.b
    @NonNull
    public Pair<Integer, Integer> NY() {
        return WD();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WE() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.bzl == null) {
            return super.WE();
        }
        Window window = this.bzl.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.bzl.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.bzl.isLandScape() == z) {
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
        this.bzj = aVar;
        com.baidu.swan.apps.runtime.e Oy = Oy();
        if (Oy != null) {
            Oy.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a WF() {
        return this.cpP;
    }
}
