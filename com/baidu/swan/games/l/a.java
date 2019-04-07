package com.baidu.swan.games.l;

import android.app.Activity;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.c.e;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.i.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.w.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bec;
    private SwanCoreVersion bed;
    private com.baidu.swan.games.inspector.b bee = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vP() {
        super.vP();
        if (this.aym != null && this.aym.uA() != null) {
            f fVar = new f();
            fVar.mFrom = c.dB(1);
            fVar.mAppId = this.aym.uA().mAppId;
            fVar.mSource = this.aym.uA().axJ;
            fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
            c.onEvent(fVar);
            c.f(fVar.mAppId, fVar.mSource, 1);
        }
        com.baidu.swan.apps.media.b.bl(true);
        com.baidu.swan.games.m.a.OA().bo(false);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vQ() {
        super.vQ();
        com.baidu.swan.apps.media.b.bl(false);
        com.baidu.swan.games.m.a.OA().bo(true);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        e.aR(false);
        com.baidu.swan.c.b.deleteFile(g.getBasePath() + File.separator + "tmp");
        com.baidu.swan.apps.ae.b.terminate();
        c.Kq();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atu);
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.l.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(int i, com.baidu.swan.apps.install.a aVar) {
                final a.b bVar3 = (a.b) aVar;
                if (i == 0 && bVar3 != null && bVar2 != null) {
                    if (bVar.ayb) {
                        if (!com.baidu.swan.games.c.a.b.ND().NN()) {
                            com.baidu.swan.apps.console.b.aQ(false);
                            bVar.ayb = false;
                        } else {
                            aa.i(new Runnable() { // from class: com.baidu.swan.games.l.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!a.this.atC) {
                                        a.this.C(a.this.aym).setVisibility(0);
                                        a.this.DG().L(a.this.apR);
                                        com.baidu.swan.apps.console.a.aP(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    }
                                }
                            });
                        }
                    }
                    aa.i(new Runnable() { // from class: com.baidu.swan.games.l.a.1.2
                        @Override // java.lang.Runnable
                        public void run() {
                            if (!a.this.atC) {
                                a.this.bee.a(bVar3, a.this.aym);
                            }
                        }
                    });
                    bVar2.a(0, bVar3);
                    a.this.bec = bVar3.bdF;
                    a.this.b(bVar3.bdH);
                    com.baidu.swan.games.subpackage.a.Pd().c(bVar3.bdH);
                }
            }
        });
        w(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a DG() {
        if (this.ayj == null) {
            this.ayj = com.baidu.swan.apps.core.i.c.Aa().Ab().bp(AppRuntime.getAppContext());
            e.aR(true);
        }
        this.ayj.e((ViewGroup) this.aym.findViewById(a.f.ai_apps_activity_root));
        return this.ayj;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String DJ() {
        return TextUtils.isEmpty(this.bec) ? "" : this.bec;
    }

    public void w(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bed != null) {
            bVar.atu = this.bed;
        } else {
            this.bed = bVar.atu;
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        super.C(activity);
        this.apR.setAutoAttachEnable(false);
        return this.apR;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.apU == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.apU = new SwanAppPropertyWindow(activity);
            this.apU.setVisibility(8);
            viewGroup.addView(this.apU);
        }
        return this.apU;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion DF() {
        return this.bed;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DO() {
        return DP();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> yB() {
        return DO();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DP() {
        if (this.aym == null) {
            return yB();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.aym.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        if (this.aym.isLandScape() == Oz()) {
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    private boolean Oz() {
        if (this.aym == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24 && this.aym.isInMultiWindowMode()) {
            int rotation = this.aym.getWindowManager().getDefaultDisplay().getRotation();
            return rotation == 1 || rotation == 3;
        }
        return this.aym.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.o.a.a aVar) {
        this.ayk = aVar;
        com.baidu.swan.apps.ae.b za = za();
        if (za != null) {
            za.a(aVar);
        }
    }
}
