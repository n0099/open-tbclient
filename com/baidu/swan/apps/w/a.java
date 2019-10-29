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
    protected FullScreenFloatView aKp;
    protected SwanAppPropertyWindow aKs;
    protected boolean aOk;
    protected String aSd;
    protected com.baidu.swan.apps.ae.a.c aSe;
    protected com.baidu.swan.apps.b.c.a aTA;
    protected com.baidu.swan.games.p.a.a aTB;
    protected com.baidu.swan.apps.ae.a.a aTC = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity aTD;
    protected d aTE;
    protected boolean aTF;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.j.c.GO();
        this.aTE = new d();
        this.aTE.a(this);
        f.LG().LH();
    }

    private void Lf() {
        if (Lp() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bj(Context context) {
        Lf();
        this.aTE.bl(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bk(Context context) {
        this.aTE.bm(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.aOk = true;
        if (this.aTE != null) {
            this.aTE.Lx();
            this.aTE = null;
        }
        f.LG().LI();
        com.baidu.swan.apps.process.b.b.b.a.Om().release();
        Cj();
    }

    private void Cj() {
        if (this.aKp != null) {
            ViewParent parent = this.aKp.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.aKp);
            }
        }
        if (this.aTA != null) {
            this.aTA.Cj();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void Cf() {
        Lf();
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (!TextUtils.isEmpty(Rk)) {
            this.aTF = true;
            this.aTE.Lx();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Rk);
            com.baidu.swan.apps.process.messaging.client.a.Op().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void Cg() {
        String Rk = com.baidu.swan.apps.ae.b.Rk();
        if (!TextUtils.isEmpty(Rk)) {
            if (this.aTF) {
                this.aTE.Lu();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Rk);
            com.baidu.swan.apps.process.messaging.client.a.Op().e(10, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.aTD != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aTD != null) {
                        com.baidu.swan.apps.performance.f.bat = true;
                        a.this.aTD.finish();
                        if (z) {
                            a.this.aTD.overridePendingTransition(0, a.C0151a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0152a interfaceC0152a) {
        Lf();
        SwanAppActivity Lp = Lp();
        if (Lp != null) {
            Lp.a(i, strArr, interfaceC0152a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void Lg() {
        this.aTF = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void Lh() {
        this.aTF = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b FD() {
        return com.baidu.swan.apps.ae.b.QZ();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion Li() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Lf();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Lf();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a Lj() {
        Lf();
        if (this.aTA == null) {
            this.aTA = com.baidu.swan.apps.core.j.c.GO().GP().aJ(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.bo(true);
        }
        if (this.aTD != null) {
            this.aTA.h((ViewGroup) this.aTD.findViewById(a.f.ai_apps_activity_root));
        }
        return this.aTA;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView E(Activity activity) {
        Lf();
        if (activity == null) {
            return null;
        }
        if (this.aKp == null) {
            this.aKp = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.aKp.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.aKp.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.aKp.setVisibility(8);
            this.aKp.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a aTA;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.aTA == null) {
                        this.aTA = e.LD().Lj();
                    }
                    this.aTA.Ci();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void Lt() {
                }
            });
        }
        return this.aKp;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow F(Activity activity) {
        ViewGroup viewGroup;
        Lf();
        if (activity == null) {
            return null;
        }
        if (this.aKs == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aKs = new SwanAppPropertyWindow(activity);
            this.aKs.setVisibility(8);
            viewGroup.addView(this.aKs);
        }
        return this.aKs;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean Lk() {
        Lf();
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (QZ != null) {
            bVar = QZ.AJ();
        }
        return bVar != null && ((DEBUG && bVar.isDebug()) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void O(Intent intent) {
        com.baidu.swan.apps.core.j.c.GO().I(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.aTD = swanAppActivity;
        com.baidu.swan.apps.ae.b FD = FD();
        if (FD == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.AJ());
            FD = FD();
        }
        if (FD != null) {
            FD.K(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c Ll() {
        return this.aSe;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d fM(String str) {
        if (this.aSe == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.RF();
        }
        return this.aTC.a(Lm(), str, this.aSe.bkC);
    }

    @Override // com.baidu.swan.apps.w.c
    public String Lm() {
        return TextUtils.isEmpty(this.aSd) ? "" : this.aSd;
    }

    @Override // com.baidu.swan.apps.w.c
    public String Ln() {
        if (this.aTD == null || this.aTD.AJ() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.aTD.AJ(), e.LD().Ll());
    }

    @Override // com.baidu.swan.apps.w.c
    public String Lo() {
        return this.aSe == null ? "" : this.aSe.Lo();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.e AH() {
        if (this.aTD == null) {
            return null;
        }
        return this.aTD.AH();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity Lp() {
        return this.aTD;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b FO() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e AH = AH();
        if (AH != null && (hVar = (com.baidu.swan.apps.core.d.h) AH.i(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.FO();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b FP() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e AH = AH();
        if (AH != null && (hVar = (com.baidu.swan.apps.core.d.h) AH.i(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.FP();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e eH(String str) {
        return com.baidu.swan.apps.core.j.c.GO().eH(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout fN(String str) {
        com.baidu.swan.apps.b.c.d Cr;
        com.baidu.swan.apps.b.c.e eH = eH(str);
        if (eH == null || (Cr = eH.Cr()) == null) {
            return null;
        }
        return Cr.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.au("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.aPZ;
            fVar.aQe = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.aPZ + " ; needEncode = " + z);
            }
            a(dVar.aNu, fVar);
            com.baidu.swan.apps.performance.e.au("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.GO().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.GO().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.d Fr() {
        com.baidu.swan.apps.core.d.e AH = AH();
        if (AH == null) {
            return null;
        }
        return AH.Fr();
    }

    @Override // com.baidu.swan.apps.w.c
    public String Fb() {
        com.baidu.swan.apps.core.d.d Fr = Fr();
        return Fr != null ? Fr.Fb() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d Lq() {
        com.baidu.swan.apps.b.c.e eH = eH(Fb());
        if (eH == null) {
            return null;
        }
        return eH.Cr();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Lr() {
        Pair<Integer, Integer> Fc = Fc();
        int intValue = ((Integer) Fc.first).intValue();
        int intValue2 = ((Integer) Fc.second).intValue();
        if (intValue == 0) {
            intValue = z.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = z.bR(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Fc() {
        com.baidu.swan.apps.core.d.d Fr = Fr();
        return Fr == null ? new Pair<>(0, 0) : Fr.Fc();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Ls() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(z.getDisplayWidth(appContext)), Integer.valueOf(z.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void dE(int i) {
        Lf();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        Lf();
        if (this.aTD != null) {
            this.aTD.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void AK() {
        Lf();
        if (this.aTD != null) {
            this.aTD.AK();
        }
    }
}
