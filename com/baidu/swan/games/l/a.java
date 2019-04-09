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
    private String bed;
    private SwanCoreVersion bee;
    private com.baidu.swan.games.inspector.b bef = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vP() {
        super.vP();
        if (this.ayn != null && this.ayn.uA() != null) {
            f fVar = new f();
            fVar.mFrom = c.dB(1);
            fVar.mAppId = this.ayn.uA().mAppId;
            fVar.mSource = this.ayn.uA().axK;
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
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atv);
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.l.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(int i, com.baidu.swan.apps.install.a aVar) {
                final a.b bVar3 = (a.b) aVar;
                if (i == 0 && bVar3 != null && bVar2 != null) {
                    if (bVar.ayc) {
                        if (!com.baidu.swan.games.c.a.b.ND().NN()) {
                            com.baidu.swan.apps.console.b.aQ(false);
                            bVar.ayc = false;
                        } else {
                            aa.i(new Runnable() { // from class: com.baidu.swan.games.l.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!a.this.atD) {
                                        a.this.C(a.this.ayn).setVisibility(0);
                                        a.this.DG().L(a.this.apS);
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
                            if (!a.this.atD) {
                                a.this.bef.a(bVar3, a.this.ayn);
                            }
                        }
                    });
                    bVar2.a(0, bVar3);
                    a.this.bed = bVar3.bdG;
                    a.this.b(bVar3.bdI);
                    com.baidu.swan.games.subpackage.a.Pd().c(bVar3.bdI);
                }
            }
        });
        w(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a DG() {
        if (this.ayk == null) {
            this.ayk = com.baidu.swan.apps.core.i.c.Aa().Ab().bp(AppRuntime.getAppContext());
            e.aR(true);
        }
        this.ayk.e((ViewGroup) this.ayn.findViewById(a.f.ai_apps_activity_root));
        return this.ayk;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String DJ() {
        return TextUtils.isEmpty(this.bed) ? "" : this.bed;
    }

    public void w(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bee != null) {
            bVar.atv = this.bee;
        } else {
            this.bee = bVar.atv;
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        super.C(activity);
        this.apS.setAutoAttachEnable(false);
        return this.apS;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.apV == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.apV = new SwanAppPropertyWindow(activity);
            this.apV.setVisibility(8);
            viewGroup.addView(this.apV);
        }
        return this.apV;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion DF() {
        return this.bee;
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
        if (this.ayn == null) {
            return yB();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.ayn.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        if (this.ayn.isLandScape() == Oz()) {
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    private boolean Oz() {
        if (this.ayn == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24 && this.ayn.isInMultiWindowMode()) {
            int rotation = this.ayn.getWindowManager().getDefaultDisplay().getRotation();
            return rotation == 1 || rotation == 3;
        }
        return this.ayn.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.o.a.a aVar) {
        this.ayl = aVar;
        com.baidu.swan.apps.ae.b za = za();
        if (za != null) {
            za.a(aVar);
        }
    }
}
