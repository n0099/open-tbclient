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
    protected FullScreenFloatView aJX;
    protected SwanAppPropertyWindow aKa;
    protected boolean aNS;
    protected String aRL;
    protected com.baidu.swan.apps.ae.a.c aRM;
    protected com.baidu.swan.apps.b.c.a aTi;
    protected com.baidu.swan.games.p.a.a aTj;
    protected com.baidu.swan.apps.ae.a.a aTk = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity aTl;
    protected d aTm;
    protected boolean aTn;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.j.c.GP();
        this.aTm = new d();
        this.aTm.a(this);
        f.LH().LI();
    }

    private void Lg() {
        if (Lq() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bj(Context context) {
        Lg();
        this.aTm.bl(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bk(Context context) {
        this.aTm.bm(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.aNS = true;
        if (this.aTm != null) {
            this.aTm.Ly();
            this.aTm = null;
        }
        f.LH().LJ();
        com.baidu.swan.apps.process.b.b.b.a.On().release();
        Ck();
    }

    private void Ck() {
        if (this.aJX != null) {
            ViewParent parent = this.aJX.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.aJX);
            }
        }
        if (this.aTi != null) {
            this.aTi.Ck();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void Cg() {
        Lg();
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (!TextUtils.isEmpty(Rm)) {
            this.aTn = true;
            this.aTm.Ly();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Rm);
            com.baidu.swan.apps.process.messaging.client.a.Oq().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void Ch() {
        String Rm = com.baidu.swan.apps.ae.b.Rm();
        if (!TextUtils.isEmpty(Rm)) {
            if (this.aTn) {
                this.aTm.Lv();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Rm);
            com.baidu.swan.apps.process.messaging.client.a.Oq().e(10, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.aTl != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aTl != null) {
                        com.baidu.swan.apps.performance.f.bab = true;
                        a.this.aTl.finish();
                        if (z) {
                            a.this.aTl.overridePendingTransition(0, a.C0151a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0152a interfaceC0152a) {
        Lg();
        SwanAppActivity Lq = Lq();
        if (Lq != null) {
            Lq.a(i, strArr, interfaceC0152a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void Lh() {
        this.aTn = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void Li() {
        this.aTn = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b FE() {
        return com.baidu.swan.apps.ae.b.Ra();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion Lj() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Lg();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Lg();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a Lk() {
        Lg();
        if (this.aTi == null) {
            this.aTi = com.baidu.swan.apps.core.j.c.GP().GQ().aJ(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.bo(true);
        }
        if (this.aTl != null) {
            this.aTi.h((ViewGroup) this.aTl.findViewById(a.f.ai_apps_activity_root));
        }
        return this.aTi;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView E(Activity activity) {
        Lg();
        if (activity == null) {
            return null;
        }
        if (this.aJX == null) {
            this.aJX = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.aJX.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.aJX.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.aJX.setVisibility(8);
            this.aJX.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a aTi;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.aTi == null) {
                        this.aTi = e.LE().Lk();
                    }
                    this.aTi.Cj();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void Lu() {
                }
            });
        }
        return this.aJX;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow F(Activity activity) {
        ViewGroup viewGroup;
        Lg();
        if (activity == null) {
            return null;
        }
        if (this.aKa == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aKa = new SwanAppPropertyWindow(activity);
            this.aKa.setVisibility(8);
            viewGroup.addView(this.aKa);
        }
        return this.aKa;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean Ll() {
        Lg();
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (Ra != null) {
            bVar = Ra.AK();
        }
        return bVar != null && ((DEBUG && bVar.isDebug()) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void O(Intent intent) {
        com.baidu.swan.apps.core.j.c.GP().I(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.aTl = swanAppActivity;
        com.baidu.swan.apps.ae.b FE = FE();
        if (FE == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.AK());
            FE = FE();
        }
        if (FE != null) {
            FE.K(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c Lm() {
        return this.aRM;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d fM(String str) {
        if (this.aRM == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.RH();
        }
        return this.aTk.a(Ln(), str, this.aRM.bkk);
    }

    @Override // com.baidu.swan.apps.w.c
    public String Ln() {
        return TextUtils.isEmpty(this.aRL) ? "" : this.aRL;
    }

    @Override // com.baidu.swan.apps.w.c
    public String Lo() {
        if (this.aTl == null || this.aTl.AK() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.aTl.AK(), e.LE().Lm());
    }

    @Override // com.baidu.swan.apps.w.c
    public String Lp() {
        return this.aRM == null ? "" : this.aRM.Lp();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.e AI() {
        if (this.aTl == null) {
            return null;
        }
        return this.aTl.AI();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity Lq() {
        return this.aTl;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b FP() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e AI = AI();
        if (AI != null && (hVar = (com.baidu.swan.apps.core.d.h) AI.i(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.FP();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b FQ() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e AI = AI();
        if (AI != null && (hVar = (com.baidu.swan.apps.core.d.h) AI.i(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.FQ();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e eH(String str) {
        return com.baidu.swan.apps.core.j.c.GP().eH(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout fN(String str) {
        com.baidu.swan.apps.b.c.d Cs;
        com.baidu.swan.apps.b.c.e eH = eH(str);
        if (eH == null || (Cs = eH.Cs()) == null) {
            return null;
        }
        return Cs.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.au("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.aPH;
            fVar.aPM = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.aPH + " ; needEncode = " + z);
            }
            a(dVar.aNc, fVar);
            com.baidu.swan.apps.performance.e.au("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.GP().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.GP().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.d Fs() {
        com.baidu.swan.apps.core.d.e AI = AI();
        if (AI == null) {
            return null;
        }
        return AI.Fs();
    }

    @Override // com.baidu.swan.apps.w.c
    public String Fc() {
        com.baidu.swan.apps.core.d.d Fs = Fs();
        return Fs != null ? Fs.Fc() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d Lr() {
        com.baidu.swan.apps.b.c.e eH = eH(Fc());
        if (eH == null) {
            return null;
        }
        return eH.Cs();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Ls() {
        Pair<Integer, Integer> Fd = Fd();
        int intValue = ((Integer) Fd.first).intValue();
        int intValue2 = ((Integer) Fd.second).intValue();
        if (intValue == 0) {
            intValue = z.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = z.bR(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Fd() {
        com.baidu.swan.apps.core.d.d Fs = Fs();
        return Fs == null ? new Pair<>(0, 0) : Fs.Fd();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Lt() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(z.getDisplayWidth(appContext)), Integer.valueOf(z.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void dE(int i) {
        Lg();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        Lg();
        if (this.aTl != null) {
            this.aTl.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void AL() {
        Lg();
        if (this.aTl != null) {
            this.aTl.AL();
        }
    }
}
