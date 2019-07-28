package com.baidu.swan.apps.w;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public abstract class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView aqB;
    protected SwanAppPropertyWindow aqE;
    protected boolean auv;
    protected String ayp;
    protected com.baidu.swan.apps.ae.a.c ayq;
    protected com.baidu.swan.apps.b.c.a azO;
    protected com.baidu.swan.games.p.a.a azP;
    protected com.baidu.swan.apps.ae.a.a azQ = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity azR;
    protected d azS;
    protected boolean azT;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.j.c.BQ();
        this.azS = new d();
        this.azS.a(this);
        f.GI().GJ();
    }

    private void Gh() {
        if (Gr() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bh(Context context) {
        Gh();
        this.azS.bj(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bi(Context context) {
        this.azS.bk(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.auv = true;
        if (this.azS != null) {
            this.azS.Gz();
            this.azS = null;
        }
        f.GI().GK();
        com.baidu.swan.apps.process.b.b.b.a.Jo().release();
        xl();
    }

    private void xl() {
        if (this.aqB != null) {
            ViewParent parent = this.aqB.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.aqB);
            }
        }
        if (this.azO != null) {
            this.azO.xl();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void xh() {
        Gh();
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (!TextUtils.isEmpty(Mo)) {
            this.azT = true;
            this.azS.Gz();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Mo);
            com.baidu.swan.apps.process.messaging.client.a.Jr().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void xi() {
        String Mo = com.baidu.swan.apps.ae.b.Mo();
        if (!TextUtils.isEmpty(Mo)) {
            if (this.azT) {
                this.azS.Gw();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Mo);
            com.baidu.swan.apps.process.messaging.client.a.Jr().e(10, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.azR != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.azR != null) {
                        com.baidu.swan.apps.performance.f.aGG = true;
                        a.this.azR.finish();
                        if (z) {
                            a.this.azR.overridePendingTransition(0, a.C0110a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0111a interfaceC0111a) {
        Gh();
        SwanAppActivity Gr = Gr();
        if (Gr != null) {
            Gr.a(i, strArr, interfaceC0111a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void Gi() {
        this.azT = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void Gj() {
        this.azT = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b AE() {
        return com.baidu.swan.apps.ae.b.Md();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion Gk() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Gh();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Gh();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a Gl() {
        Gh();
        if (this.azO == null) {
            this.azO = com.baidu.swan.apps.core.j.c.BQ().BR().aH(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.aW(true);
        }
        if (this.azR != null) {
            this.azO.e((ViewGroup) this.azR.findViewById(a.f.ai_apps_activity_root));
        }
        return this.azO;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView F(Activity activity) {
        Gh();
        if (activity == null) {
            return null;
        }
        if (this.aqB == null) {
            this.aqB = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.aqB.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.aqB.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.aqB.setVisibility(8);
            this.aqB.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a azO;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.azO == null) {
                        this.azO = e.GF().Gl();
                    }
                    this.azO.xk();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void Gv() {
                }
            });
        }
        return this.aqB;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow G(Activity activity) {
        ViewGroup viewGroup;
        Gh();
        if (activity == null) {
            return null;
        }
        if (this.aqE == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aqE = new SwanAppPropertyWindow(activity);
            this.aqE.setVisibility(8);
            viewGroup.addView(this.aqE);
        }
        return this.aqE;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean Gm() {
        Gh();
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (Md != null) {
            bVar = Md.vL();
        }
        return bVar != null && ((DEBUG && bVar.isDebug()) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void I(Intent intent) {
        com.baidu.swan.apps.core.j.c.BQ().C(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.azR = swanAppActivity;
        com.baidu.swan.apps.ae.b AE = AE();
        if (AE == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.vL());
            AE = AE();
        }
        if (AE != null) {
            AE.L(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c Gn() {
        return this.ayq;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d fd(String str) {
        if (this.ayq == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.MJ();
        }
        return this.azQ.a(Go(), str, this.ayq.aRa);
    }

    @Override // com.baidu.swan.apps.w.c
    public String Go() {
        return TextUtils.isEmpty(this.ayp) ? "" : this.ayp;
    }

    @Override // com.baidu.swan.apps.w.c
    public String Gp() {
        if (this.azR == null || this.azR.vL() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.azR.vL(), e.GF().Gn());
    }

    @Override // com.baidu.swan.apps.w.c
    public String Gq() {
        return this.ayq == null ? "" : this.ayq.Gq();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.e vJ() {
        if (this.azR == null) {
            return null;
        }
        return this.azR.vJ();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity Gr() {
        return this.azR;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b AP() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e vJ = vJ();
        if (vJ != null && (hVar = (com.baidu.swan.apps.core.d.h) vJ.k(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.AP();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b AQ() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e vJ = vJ();
        if (vJ != null && (hVar = (com.baidu.swan.apps.core.d.h) vJ.k(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.AQ();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e dY(String str) {
        return com.baidu.swan.apps.core.j.c.BQ().dY(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout fe(String str) {
        com.baidu.swan.apps.b.c.d xt;
        com.baidu.swan.apps.b.c.e dY = dY(str);
        if (dY == null || (xt = dY.xt()) == null) {
            return null;
        }
        return xt.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.am("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.awm;
            fVar.awr = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.awm + " ; needEncode = " + z);
            }
            a(dVar.atF, fVar);
            com.baidu.swan.apps.performance.e.am("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.BQ().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.BQ().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.d As() {
        com.baidu.swan.apps.core.d.e vJ = vJ();
        if (vJ == null) {
            return null;
        }
        return vJ.As();
    }

    @Override // com.baidu.swan.apps.w.c
    public String Ac() {
        com.baidu.swan.apps.core.d.d As = As();
        return As != null ? As.Ac() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d Gs() {
        com.baidu.swan.apps.b.c.e dY = dY(Ac());
        if (dY == null) {
            return null;
        }
        return dY.xt();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gt() {
        Pair<Integer, Integer> Ad = Ad();
        int intValue = ((Integer) Ad.first).intValue();
        int intValue2 = ((Integer) Ad.second).intValue();
        if (intValue == 0) {
            intValue = z.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = z.bQ(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Ad() {
        com.baidu.swan.apps.core.d.d As = As();
        return As == null ? new Pair<>(0, 0) : As.Ad();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gu() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(z.getDisplayWidth(appContext)), Integer.valueOf(z.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cI(int i) {
        Gh();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        Gh();
        if (this.azR != null) {
            this.azR.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void vM() {
        Gh();
        if (this.azR != null) {
            this.azR.vM();
        }
    }
}
