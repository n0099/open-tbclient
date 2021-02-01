package com.baidu.swan.games.p;

import android.app.Activity;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Pair;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.annotation.NonNull;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
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
/* loaded from: classes9.dex */
public class a extends com.baidu.swan.apps.v.b {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private Runnable dgX;
    private String eiC;
    private com.baidu.swan.games.inspector.b eiD = new com.baidu.swan.games.inspector.b();
    private com.baidu.swan.games.q.a eiE = new com.baidu.swan.games.q.a();

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aiC() {
        super.aiC();
        if (this.dgS != null && this.dgS.afZ() != null) {
            b.a afZ = this.dgS.afZ();
            f fVar = new f();
            fVar.mFrom = h.ju(1);
            fVar.mAppId = afZ.getAppId();
            fVar.mSource = afZ.aza();
            fVar.mType = "show";
            fVar.sT(afZ.azg().getString("ubc"));
            fVar.ci(h.sK(afZ.azc()));
            h.onEvent(fVar);
        }
        com.baidu.swan.apps.media.b.fY(true);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void aiD() {
        super.aiD();
        com.baidu.swan.apps.media.b.fY(false);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void doRelease() {
        super.doRelease();
        com.baidu.swan.games.j.a.release();
        com.baidu.swan.c.d.deleteFile(n.getBasePath() + File.separator + "tmp");
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanCoreVersion azN() {
        return com.baidu.swan.games.j.a.aWA().asA();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.a azO() {
        if (this.dgP == null) {
            this.dgP = com.baidu.swan.apps.core.turbo.d.ase().asf().ch(AppRuntime.getAppContext());
            i.eY(true);
        }
        this.dgP.A((ViewGroup) this.dgS.findViewById(16908290));
        return this.dgP;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public String azS() {
        return TextUtils.isEmpty(this.eiC) ? "" : this.eiC;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public FullScreenFloatView B(Activity activity) {
        super.B(activity);
        this.cRo.setAutoAttachEnable(false);
        return this.cRo;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow C(Activity activity) {
        ViewGroup viewGroup;
        if (activity == null) {
            return null;
        }
        if (this.cRq == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cRq = new SwanAppPropertyWindow(activity);
            this.cRq.setVisibility(8);
            viewGroup.addView(this.cRq);
        }
        return this.cRq;
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public void a(final com.baidu.swan.apps.u.c.b bVar, final com.baidu.swan.apps.r.b bVar2) {
        super.a(bVar, bVar2);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "asyncLoadSwanApp swanCoreVersion: " + bVar.asA());
        }
        com.baidu.swan.games.l.a.c(bVar, new com.baidu.swan.apps.r.b() { // from class: com.baidu.swan.games.p.a.1
            @Override // com.baidu.swan.apps.r.b
            public void a(final int i, final com.baidu.swan.apps.r.a aVar) {
                ak.j(a.this.dgX);
                a.this.dgX = new Runnable() { // from class: com.baidu.swan.games.p.a.1.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!a.this.mIsReleased) {
                            a.b bVar3 = (a.b) aVar;
                            if (i == 0 && bVar3 != null && bVar2 != null) {
                                if (bVar.azm()) {
                                    if (com.baidu.swan.games.c.d.aVA().aVL()) {
                                        a.this.B(a.this.dgS).setVisibility(0);
                                        a.this.azO().ao(a.this.cRo);
                                        com.baidu.swan.apps.console.a.eW(true);
                                        com.baidu.swan.apps.console.c.i("GamesControllerImpl", "init sConsole for devHook");
                                    } else {
                                        com.baidu.swan.apps.console.b.eX(false);
                                        bVar.fV(false);
                                    }
                                }
                                a.this.eiD.a(bVar3, a.this.dgS);
                                a.this.eiC = bVar3.appBundlePath;
                                bVar2.a(0, bVar3);
                                a.this.b(bVar3.eih);
                                com.baidu.swan.games.y.a.aYy().c(bVar3.eih);
                            }
                        }
                    }
                };
                ak.i(a.this.dgX);
            }
        });
        com.baidu.swan.games.j.a.aWA().e(bVar);
        com.baidu.swan.games.j.a.aWA().f(bVar);
        if (DEBUG) {
            Log.d("GamesControllerImpl", "SwanGameCoreRuntime preloadCoreRuntime by asyncLoadSwanApp");
        }
        com.baidu.swan.games.j.a.aWA().r(null);
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azX() {
        return azY();
    }

    @Override // com.baidu.swan.apps.v.b
    @NonNull
    public Pair<Integer, Integer> apj() {
        return azX();
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azY() {
        int i;
        int i2;
        int i3;
        int i4;
        View decorView;
        boolean z = false;
        if (this.dgS == null) {
            return super.azY();
        }
        Window window = this.dgS.getWindow();
        if (window == null || (decorView = window.getDecorView()) == null) {
            i = 0;
            i2 = 0;
        } else {
            i2 = decorView.getWidth();
            i = decorView.getHeight();
        }
        Display defaultDisplay = this.dgS.getWindowManager().getDefaultDisplay();
        if (i2 == 0 || i == 0) {
            DisplayMetrics displayMetrics = new DisplayMetrics();
            defaultDisplay.getRealMetrics(displayMetrics);
            i2 = displayMetrics.widthPixels;
            i = displayMetrics.heightPixels;
        }
        if (defaultDisplay.getRotation() == 1 || defaultDisplay.getRotation() == 3) {
            z = true;
        }
        if (this.dgS.isLandScape() != z) {
            i3 = i2;
            i4 = i;
        } else {
            i3 = i;
            i4 = i2;
        }
        if (DEBUG) {
            Log.d("GamesControllerImpl", "getCurScreenSize width:" + i4 + ",height:" + i3);
        }
        return new Pair<>(Integer.valueOf(i4), Integer.valueOf(i3));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.swan.games.t.a.a aVar) {
        this.dgQ = aVar;
        com.baidu.swan.apps.runtime.e aos = aos();
        if (aos != null) {
            aos.a(aVar);
        }
    }

    @Override // com.baidu.swan.apps.v.b, com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a azZ() {
        return this.eiE;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aAb() {
        return this.dgU;
    }
}
