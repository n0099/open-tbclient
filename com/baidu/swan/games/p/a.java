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
    private Runnable cTz;
    private String dRc;
    private com.baidu.swan.games.inspector.b dRd = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a dRe = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void afN() {
        super.afN();
        if (this.cTu != null && this.cTu.ado() != null) {
            b.a ado = this.cTu.ado();
            f fVar = new f();
            fVar.mFrom = h.ko(1);
            fVar.mAppId = ado.getAppId();
            fVar.mSource = ado.awd();
            fVar.mType = "show";
            fVar.sY(ado.awj().getString("ubc"));
            fVar.cb(h.sP(ado.awf()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fq(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void afO() {
        super.afO();
        com.baidu.swan.apps.media.b.fq(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion awQ() {
        return com.baidu.swan.games.j.a.aSQ().apD();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a awR() {
        if (this.cTr == null) {
            this.cTr = com.baidu.swan.apps.core.turbo.d.aph().apj().bw(AppRuntime.getAppContext());
            i.eq(true);
        }
        this.cTr.B((ViewGroup) this.cTu.findViewById(16908290));
        return this.cTr;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String awV() {
        return TextUtils.isEmpty(this.dRc) ? "" : this.dRc;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView J(Activity activity) {
        super.J(activity);
        this.cDP.setAutoAttachEnable(false);
        return this.cDP;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow K(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cDR == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cDR = new SwanAppPropertyWindow(activity);
            this.cDR.setVisibility(8);
            viewGroup.addView(this.cDR);
        }
        return this.cDR;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.apD());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.l(a.this.cTz);
                a.this.cTz = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.cKt) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.awp()) {
                                    if (com.baidu.swan.games.c.d.aRQ().aSb()) {
                                        a.this.J(a.this.cTu).setVisibility(0);
                                        a.this.awR().al(a.this.cDP);
                                        com.baidu.swan.apps.console.a.eo(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.ep(false);
                                        bVar.fn(false);
                                    }
                                }
                                a.this.dRd.a(bVar3, a.this.cTu);
                                a.this.dRc = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.dQH);
                                com.baidu.swan.games.y.a.aUO().c(bVar3.dQH);
                            }
                        }
                    }
                };
                ak.k(a.this.cTz);
            }
        });
        com.baidu.swan.games.j.a.aSQ().e(bVar);
        com.baidu.swan.games.j.a.aSQ().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aSQ().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> axa() {
        return axb();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> amn() {
        return axa();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> axb() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.cTu == null) {
            return super.axb();
        }
        Window window = this.cTu.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.cTu.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.cTu.isLandScape() == z) {
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
        this.cTs = aVar;
        com.baidu.swan.apps.runtime.e alC = alC();
        if (alC != null) {
            alC.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a axc() {
        return this.dRe;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean axe() {
        return this.cTw;
    }
}
