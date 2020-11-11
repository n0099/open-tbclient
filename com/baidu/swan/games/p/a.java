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
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable cZs;
    private String dWU;
    private com.baidu.swan.games.inspector.b dWV = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a dWW = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void ain() {
        super.ain();
        if (this.cZn != null && this.cZn.afO() != null) {
            b.a afO = this.cZn.afO();
            f fVar = new f();
            fVar.mFrom = h.ky(1);
            fVar.mAppId = afO.getAppId();
            fVar.mSource = afO.ayD();
            fVar.mType = "show";
            fVar.tm(afO.ayJ().getString("ubc"));
            fVar.ch(h.td(afO.ayF()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fz(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aio() {
        super.aio();
        com.baidu.swan.apps.media.b.fz(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azq() {
        return com.baidu.swan.games.j.a.aVq().asd();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a azr() {
        if (this.cZk == null) {
            this.cZk = com.baidu.swan.apps.core.turbo.d.arI().arJ().bw(AppRuntime.getAppContext());
            i.ez(true);
        }
        this.cZk.D((ViewGroup) this.cZn.findViewById(16908290));
        return this.cZk;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String azv() {
        return TextUtils.isEmpty(this.dWU) ? "" : this.dWU;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView J(Activity activity) {
        super.J(activity);
        this.cJI.setAutoAttachEnable(false);
        return this.cJI;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow K(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cJK == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cJK = new SwanAppPropertyWindow(activity);
            this.cJK.setVisibility(8);
            viewGroup.addView(this.cJK);
        }
        return this.cJK;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asd());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.cZs);
                a.this.cZs = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cQm) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.ayP()) {
                                    if (com.baidu.swan.games.c.d.aUq().aUB()) {
                                        a.this.J(a.this.cZn).setVisibility(0);
                                        a.this.azr().ap(a.this.cJI);
                                        com.baidu.swan.apps.console.a.ex(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.ey(false);
                                        bVar.fw(false);
                                    }
                                }
                                a.this.dWV.a(bVar3, a.this.cZn);
                                a.this.dWU = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dWz);
                                com.baidu.swan.games.y.a.aXo().c(bVar3.dWz);
                            }
                        }
                    }
                };
                ak.k(a.this.cZs);
            }
        });
        com.baidu.swan.games.j.a.aVq().e(bVar);
        com.baidu.swan.games.j.a.aVq().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aVq().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azA() {
        return azB();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> aoN() {
        return azA();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azB() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cZn == null) {
            return super.azB();
        }
        Window window = this.cZn.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cZn.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cZn.isLandScape() == z) {
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
        this.cZl = aVar;
        com.baidu.swan.apps.runtime.e aoc = aoc();
        if (aoc != null) {
            aoc.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a azC() {
        return this.dWW;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azE() {
        return this.cZp;
    }
}
