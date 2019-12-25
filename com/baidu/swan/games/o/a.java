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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.y.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable but;
    private String clx;
    private com.baidu.swan.games.inspector.b cly = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.p.a clz = new com.baidu.swan.games.p.a();

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void FL() {
        super.FL();
        if (this.buo != null && this.buo.DR() != null) {
            b.a DR = this.buo.DR();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.ga(1);
            fVar.mAppId = DR.getAppId();
            fVar.mSource = DR.SW();
            fVar.mType = "show";
            fVar.lz(DR.Tc().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lq(DR.SY()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.cF(true);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void FM() {
        super.FM();
        com.baidu.swan.apps.media.b.cF(false);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.i.a.release();
        com.baidu.swan.d.c.deleteFile(l.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion TI() {
        return com.baidu.swan.games.i.a.alq().Oe();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.a TJ() {
        if (this.bul == null) {
            this.bul = com.baidu.swan.apps.core.k.d.NK().NL().bs(AppRuntime.getAppContext());
            i.bU(true);
        }
        this.bul.i((ViewGroup) this.buo.findViewById(16908290));
        return this.bul;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public String TN() {
        return TextUtils.isEmpty(this.clx) ? "" : this.clx;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public FullScreenFloatView M(Activity activity) {
        super.M(activity);
        this.bim.setAutoAttachEnable(false);
        return this.bim;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow N(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bip == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bip = new SwanAppPropertyWindow(activity);
            this.bip.setVisibility(8);
            viewGroup.addView(this.bip);
        }
        return this.bip;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.Oe());
        }
        com.baidu.swan.games.k.a.c(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.o.a.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, final com.baidu.swan.apps.t.a aVar) {
                ai.k(a.this.but);
                a.this.but = new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.Ti()) {
                                    if (com.baidu.swan.games.b.d.ako().akz()) {
                                        a.this.M(a.this.buo).setVisibility(0);
                                        a.this.TJ().Z(a.this.bim);
                                        com.baidu.swan.apps.console.a.bS(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.bT(false);
                                        bVar.cB(false);
                                    }
                                }
                                a.this.cly.a(bVar3, a.this.buo);
                                a.this.clx = bVar3.ckZ;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.clb);
                                com.baidu.swan.games.x.a.anh().c(bVar3.clb);
                            }
                        }
                    }
                };
                ai.j(a.this.but);
            }
        });
        com.baidu.swan.games.i.a.alq().e(bVar);
        com.baidu.swan.games.i.a.alq().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.i.a.alq().E(null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> TS() {
        return TT();
    }

    @Override // com.baidu.swan.apps.y.b
    @NonNull
    public Pair<Integer, Integer> Lo() {
        return TS();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> TT() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.buo == null) {
            return super.TT();
        }
        Window window = this.buo.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.buo.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.buo.isLandScape() == z) {
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
        this.bum = aVar;
        com.baidu.swan.apps.runtime.e LO = LO();
        if (LO != null) {
            LO.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a TU() {
        return this.clz;
    }
}
