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
/* loaded from: classes10.dex */
public class a extends com.baidu.swan.apps.y.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable bvh;
    private String clK;
    private com.baidu.swan.games.inspector.b clL = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.p.a clM = new com.baidu.swan.games.p.a();

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Gh() {
        super.Gh();
        if (this.bvc != null && this.bvc.En() != null) {
            b.a En = this.bvc.En();
            f fVar = new f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gb(1);
            fVar.mAppId = En.getAppId();
            fVar.mSource = En.Tt();
            fVar.mType = "show";
            fVar.lC(En.Tz().getString("ubc"));
            fVar.ba(com.baidu.swan.apps.statistic.f.lt(En.Tv()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.cK(true);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void Gi() {
        super.Gi();
        com.baidu.swan.apps.media.b.cK(false);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.i.a.release();
        com.baidu.swan.d.c.deleteFile(l.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanCoreVersion Uf() {
        return com.baidu.swan.games.i.a.alJ().OA();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.a Ug() {
        if (this.buZ == null) {
            this.buZ = com.baidu.swan.apps.core.k.d.Og().Oh().bs(AppRuntime.getAppContext());
            i.bZ(true);
        }
        this.buZ.l((ViewGroup) this.bvc.findViewById(16908290));
        return this.buZ;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public String Uk() {
        return TextUtils.isEmpty(this.clK) ? "" : this.clK;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public FullScreenFloatView N(Activity activity) {
        super.N(activity);
        this.bjc.setAutoAttachEnable(false);
        return this.bjc;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow O(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.bje == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bje = new SwanAppPropertyWindow(activity);
            this.bje.setVisibility(8);
            viewGroup.addView(this.bje);
        }
        return this.bje;
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public void a(final com.baidu.swan.apps.x.b.b bVar, final com.baidu.swan.apps.t.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.OA());
        }
        com.baidu.swan.games.k.a.c(bVar, new com.baidu.swan.apps.t.b() { // from class: com.baidu.swan.games.o.a.1
            @Override // com.baidu.swan.apps.t.b
            public void a(final int i, final com.baidu.swan.apps.t.a aVar) {
                ai.k(a.this.bvh);
                a.this.bvh = new Runnable() { // from class: com.baidu.swan.games.o.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.TF()) {
                                    if (com.baidu.swan.games.b.d.akH().akS()) {
                                        a.this.N(a.this.bvc).setVisibility(0);
                                        a.this.Ug().ad(a.this.bjc);
                                        com.baidu.swan.apps.console.a.bX(true);
                                        com.baidu.swan.apps.console.c.d("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.bY(false);
                                        bVar.cG(false);
                                    }
                                }
                                a.this.clL.a(bVar3, a.this.bvc);
                                a.this.clK = bVar3.clm;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.clo);
                                com.baidu.swan.games.x.a.anA().c(bVar3.clo);
                            }
                        }
                    }
                };
                ai.j(a.this.bvh);
            }
        });
        com.baidu.swan.games.i.a.alJ().e(bVar);
        com.baidu.swan.games.i.a.alJ().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.i.a.alJ().E(null);
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> Up() {
        return Uq();
    }

    @Override // com.baidu.swan.apps.y.b
    @NonNull
    public Pair<Integer, Integer> LK() {
        return Up();
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> Uq() {
        int i;
        int i2;
        View decorView;
        boolean z = false;
        if (this.bvc == null) {
            return super.Uq();
        }
        Window window = this.bvc.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.bvc.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.bvc.isLandScape() == z) {
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
        this.bva = aVar;
        com.baidu.swan.apps.runtime.e Mk = Mk();
        if (Mk != null) {
            Mk.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.b, com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a Ur() {
        return this.clM;
    }
}
