package com.baidu.swan.games.m;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import com.baidu.sapi2.views.SmsLoginView;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.statistic.a.f;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.i.a;
import java.io.File;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.apps.w.a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable azp;
    private String bit;
    private SwanCoreVersion biu;
    private com.baidu.swan.games.inspector.b biv = new com.baidu.swan.games.inspector.b();

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void wG() {
        super.wG();
        if (this.azk != null && this.azk.vk() != null) {
            com.baidu.swan.apps.v.b.b vk = this.azk.vk();
            f fVar = new f();
            fVar.mFrom = e.dM(1);
            fVar.mAppId = this.azk.vk().getAppId();
            fVar.mSource = this.azk.vk().EW();
            fVar.mType = SmsLoginView.StatEvent.LOGIN_SHOW;
            fVar.ak(e.hn(vk.EX()));
            e.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.bu(true);
        com.baidu.swan.games.n.a.RF().bw(false);
        com.baidu.swan.apps.u.a.Ed().wG();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void wH() {
        super.wH();
        com.baidu.swan.apps.media.b.bu(false);
        com.baidu.swan.apps.u.a.Ed().wH();
        com.baidu.swan.games.n.a.RF().bw(true);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.c.a.deleteFile(g.getBasePath() + File.separator + "tmp");
        com.baidu.swan.apps.ae.b.terminate();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public void a(final com.baidu.swan.apps.v.b.b bVar, final com.baidu.swan.apps.install.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.BA());
        }
        com.baidu.swan.games.i.a.c(bVar, new com.baidu.swan.apps.install.b() { // from class: com.baidu.swan.games.m.a.1
            @Override // com.baidu.swan.apps.install.b
            public void a(final int i, final com.baidu.swan.apps.install.a aVar) {
                ac.j(a.this.azp);
                a.this.azp = new Runnable() { // from class: com.baidu.swan.games.m.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.atS) {
                            a.c cVar = (a.c) aVar;
                            if (i == 0 && cVar != null && bVar2 != null) {
                                if (bVar.Fh()) {
                                    if (com.baidu.swan.games.c.a.b.Qv().QF()) {
                                        a.this.C(a.this.azk).setVisibility(0);
                                        a.this.FB().L(a.this.apY);
                                        com.baidu.swan.apps.console.a.aR(true);
                                        c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.aS(false);
                                        bVar.aT(false);
                                    }
                                }
                                a.this.biv.a(cVar, a.this.azk);
                                bVar2.a(0, cVar);
                                a.this.bit = cVar.bhU;
                                a.this.b(cVar.bhW);
                                com.baidu.swan.games.subpackage.a.Sw().c(cVar.bhW);
                            }
                        }
                    }
                };
                ac.i(a.this.azp);
            }
        });
        y(bVar);
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.a FB() {
        if (this.azh == null) {
            this.azh = com.baidu.swan.apps.core.j.c.Bi().Bj().aI(AppRuntime.getAppContext());
            com.baidu.swan.games.c.f.aT(true);
        }
        this.azh.e((ViewGroup) this.azk.findViewById(16908290));
        return this.azh;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public String FE() {
        return TextUtils.isEmpty(this.bit) ? "" : this.bit;
    }

    public void y(com.baidu.swan.apps.v.b.b bVar) {
        if (this.biu != null) {
            bVar.a(this.biu);
        } else {
            this.biu = bVar.BA();
        }
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        super.C(activity);
        this.apY.setAutoAttachEnable(false);
        return this.apY;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.aqb == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aqb = new SwanAppPropertyWindow(activity);
            this.aqb.setVisibility(8);
            viewGroup.addView(this.aqb);
        }
        return this.aqb;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    public SwanCoreVersion FA() {
        return this.biu;
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> FJ() {
        return FK();
    }

    @Override // com.baidu.swan.apps.w.a
    @NonNull
    public Pair<Integer, Integer> zw() {
        return FJ();
    }

    @Override // com.baidu.swan.apps.w.a, com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> FK() {
        int i;
        int i2;
        View decorView;
        if (this.azk == null) {
            return super.FK();
        }
        Window window = this.azk.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            this.azk.getWindowManager().getDefaultDisplay().getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (this.azk.isLandScape() == (this.azk.getResources().getConfiguration().orientation == 2)) {
            int i3 = i;
            i = i2;
            i2 = i3;
        }
        return new Pair<>(Integer.valueOf(i), Integer.valueOf(i2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.p.a.a aVar) {
        this.azi = aVar;
        com.baidu.swan.apps.ae.b zX = zX();
        if (zX != null) {
            zX.a(aVar);
        }
    }
}
