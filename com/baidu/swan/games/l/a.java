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
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.c;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.c.e;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.i.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.w.a {
    private static final boolean DEBUG = c.DEBUG;
    private String bdY;
    private SwanCoreVersion bdZ;
    private com.baidu.swan.games.inspector.b bea = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vQ() {
        super.vQ();
        if (this.ayi != null && this.ayi.uB() != null) {
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.c.dC(1);
            fVar.mAppId = this.ayi.uB().mAppId;
            fVar.mSource = this.ayi.uB().axF;
            fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
            com.baidu.swan.apps.statistic.c.onEvent(fVar);
            com.baidu.swan.apps.statistic.c.f(fVar.mAppId, fVar.mSource, 1);
        }
        com.baidu.swan.apps.media.b.bl(true);
        com.baidu.swan.games.m.a.OC().bo(false);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vR() {
        super.vR();
        com.baidu.swan.apps.media.b.bl(false);
        com.baidu.swan.games.m.a.OC().bo(true);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        e.aR(false);
        com.baidu.swan.c.b.deleteFile(g.getBasePath() + File.separator + "tmp");
        com.baidu.swan.apps.ae.b.terminate();
        com.baidu.swan.apps.statistic.c.Ks();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atp);
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.l.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(int i, com.baidu.swan.apps.install.a aVar) {
                final a.b bVar3 = (a.b) aVar;
                if (i == 0 && bVar3 != null && bVar2 != null) {
                    if (bVar.axX) {
                        if (!com.baidu.swan.games.c.a.b.NF().NP()) {
                            com.baidu.swan.apps.console.b.aQ(false);
                            bVar.axX = false;
                        } else {
                            aa.i(new Runnable() { // from class: com.baidu.swan.games.l.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!a.this.atx) {
                                        a.this.C(a.this.ayi).setVisibility(0);
                                        a.this.DI().L(a.this.apM);
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
                            if (!a.this.atx) {
                                a.this.bea.a(bVar3, a.this.ayi);
                            }
                        }
                    });
                    bVar2.a(0, bVar3);
                    a.this.bdY = bVar3.bdB;
                    a.this.b(bVar3.bdD);
                    com.baidu.swan.games.subpackage.a.Pf().c(bVar3.bdD);
                }
            }
        });
        w(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a DI() {
        if (this.ayf == null) {
            this.ayf = com.baidu.swan.apps.core.i.c.Ab().Ac().bp(AppRuntime.getAppContext());
            e.aR(true);
        }
        this.ayf.e((ViewGroup) this.ayi.findViewById(b.f.ai_apps_activity_root));
        return this.ayf;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String DL() {
        return TextUtils.isEmpty(this.bdY) ? "" : this.bdY;
    }

    public void w(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bdZ != null) {
            bVar.atp = this.bdZ;
        } else {
            this.bdZ = bVar.atp;
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        super.C(activity);
        this.apM.setAutoAttachEnable(false);
        return this.apM;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.apP == null && (viewGroup = (ViewGroup) activity.findViewById(b.f.ai_apps_activity_root)) != null) {
            this.apP = new SwanAppPropertyWindow(activity);
            this.apP.setVisibility(8);
            viewGroup.addView(this.apP);
        }
        return this.apP;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion DH() {
        return this.bdZ;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DQ() {
        return DR();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> yC() {
        return DQ();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DR() {
        if (this.ayi == null) {
            return yC();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.ayi.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        if (this.ayi.isLandScape() == OB()) {
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    private boolean OB() {
        if (this.ayi == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24 && this.ayi.isInMultiWindowMode()) {
            int rotation = this.ayi.getWindowManager().getDefaultDisplay().getRotation();
            return rotation == 1 || rotation == 3;
        }
        return this.ayi.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.o.a.a aVar) {
        this.ayg = aVar;
        com.baidu.swan.apps.ae.b zb = zb();
        if (zb != null) {
            zb.a(aVar);
        }
    }
}
