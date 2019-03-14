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
    private String bdZ;
    private SwanCoreVersion bea;
    private com.baidu.swan.games.inspector.b beb = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void vQ() {
        super.vQ();
        if (this.ayj != null && this.ayj.uB() != null) {
            f fVar = new f();
            fVar.mFrom = c.dC(1);
            fVar.mAppId = this.ayj.uB().mAppId;
            fVar.mSource = this.ayj.uB().axG;
            fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
            c.onEvent(fVar);
            c.f(fVar.mAppId, fVar.mSource, 1);
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
        c.Ks();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.atq);
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.l.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(int i, com.baidu.swan.apps.install.a aVar) {
                final a.b bVar3 = (a.b) aVar;
                if (i == 0 && bVar3 != null && bVar2 != null) {
                    if (bVar.axY) {
                        if (!com.baidu.swan.games.c.a.b.NF().NP()) {
                            com.baidu.swan.apps.console.b.aQ(false);
                            bVar.axY = false;
                        } else {
                            aa.i(new Runnable() { // from class: com.baidu.swan.games.l.a.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (!a.this.aty) {
                                        a.this.C(a.this.ayj).setVisibility(0);
                                        a.this.DI().L(a.this.apN);
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
                            if (!a.this.aty) {
                                a.this.beb.a(bVar3, a.this.ayj);
                            }
                        }
                    });
                    bVar2.a(0, bVar3);
                    a.this.bdZ = bVar3.bdC;
                    a.this.b(bVar3.bdE);
                    com.baidu.swan.games.subpackage.a.Pf().c(bVar3.bdE);
                }
            }
        });
        w(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a DI() {
        if (this.ayg == null) {
            this.ayg = com.baidu.swan.apps.core.i.c.Ab().Ac().bp(AppRuntime.getAppContext());
            e.aR(true);
        }
        this.ayg.e((ViewGroup) this.ayj.findViewById(a.f.ai_apps_activity_root));
        return this.ayg;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String DL() {
        return TextUtils.isEmpty(this.bdZ) ? "" : this.bdZ;
    }

    public void w(com.baidu.swan.apps.v.b.b bVar) {
        if (this.bea != null) {
            bVar.atq = this.bea;
        } else {
            this.bea = bVar.atq;
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        super.C(activity);
        this.apN.setAutoAttachEnable(false);
        return this.apN;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.apQ == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.apQ = new SwanAppPropertyWindow(activity);
            this.apQ.setVisibility(8);
            viewGroup.addView(this.apQ);
        }
        return this.apQ;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion DH() {
        return this.bea;
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
        if (this.ayj == null) {
            return yC();
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        this.ayj.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
        if (this.ayj.isLandScape() == OB()) {
            return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
        }
        return new Pair<>(Integer.valueOf(displayMetrics.heightPixels), Integer.valueOf(displayMetrics.widthPixels));
    }

    private boolean OB() {
        if (this.ayj == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 24 && this.ayj.isInMultiWindowMode()) {
            int rotation = this.ayj.getWindowManager().getDefaultDisplay().getRotation();
            return rotation == 1 || rotation == 3;
        }
        return this.ayj.getResources().getConfiguration().orientation == 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.o.a.a aVar) {
        this.ayh = aVar;
        com.baidu.swan.apps.ae.b zb = zb();
        if (zb != null) {
            zb.a(aVar);
        }
    }
}
