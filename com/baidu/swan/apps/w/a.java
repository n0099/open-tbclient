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
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public abstract class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView apR;
    protected SwanAppPropertyWindow apU;
    protected boolean atC;
    protected String axb;
    protected com.baidu.swan.apps.ae.a.c axc;
    protected com.baidu.swan.apps.b.c.a ayj;
    protected com.baidu.swan.games.o.a.a ayk;
    protected com.baidu.swan.apps.ae.a.a ayl = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity aym;
    protected d ayn;
    protected boolean ayo;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.i.c.Aa();
        this.ayn = new d();
        this.ayn.a(this);
        f.Ec().Ed();
    }

    private void DC() {
        if (DM() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bL(Context context) {
        DC();
        this.ayn.bN(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bM(Context context) {
        this.ayn.bO(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.atC = true;
        if (this.ayn != null) {
            this.ayn.DU();
            this.ayn = null;
        }
        f.Ec().Ee();
        com.baidu.swan.apps.process.b.b.b.a.Gl().release();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void vP() {
        DC();
        String Jg = com.baidu.swan.apps.ae.b.Jg();
        if (!TextUtils.isEmpty(Jg)) {
            this.ayo = true;
            this.ayn.DU();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", Jg);
            com.baidu.swan.apps.process.messaging.client.a.Go().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void vQ() {
        if (!TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Jg()) && this.ayo) {
            this.ayn.DR();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.aym != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aym != null) {
                        com.baidu.swan.apps.performance.f.aEf = true;
                        a.this.aym.finish();
                        if (z) {
                            a.this.aym.overridePendingTransition(0, a.C0107a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        DC();
        SwanAppActivity DM = DM();
        if (DM != null) {
            DM.a(i, strArr, interfaceC0108a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void DD() {
        this.ayo = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void DE() {
        this.ayo = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b za() {
        return com.baidu.swan.apps.ae.b.IV();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion DF() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        DC();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        DC();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a DG() {
        DC();
        if (this.ayj == null) {
            this.ayj = com.baidu.swan.apps.core.i.c.Aa().Ab().bo(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.aR(true);
        }
        if (this.aym != null) {
            this.ayj.e((ViewGroup) this.aym.findViewById(a.f.ai_apps_activity_root));
        }
        return this.ayj;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        DC();
        if (activity == null) {
            return null;
        }
        if (this.apR == null) {
            this.apR = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.apR.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.apR.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.apR.setVisibility(8);
            this.apR.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a ayj;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.ayj == null) {
                        this.ayj = e.Ea().DG();
                    }
                    this.ayj.vT();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void DQ() {
                }
            });
        }
        return this.apR;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        DC();
        if (activity == null) {
            return null;
        }
        if (this.apU == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.apU = new SwanAppPropertyWindow(activity);
            this.apU.setVisibility(8);
            viewGroup.addView(this.apU);
        }
        return this.apU;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean DH() {
        DC();
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (IV != null) {
            bVar = IV.uA();
        }
        return bVar != null && ((DEBUG && bVar.axV) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void J(Intent intent) {
        com.baidu.swan.apps.core.i.c.Aa().D(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.aym = swanAppActivity;
        com.baidu.swan.apps.ae.b za = za();
        if (za == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.uA());
            za = za();
        }
        if (za != null) {
            za.H(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c DI() {
        return this.axc;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d eO(String str) {
        if (this.axc == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.JA();
        }
        return this.ayl.a(DJ(), str, this.axc.aOm);
    }

    @Override // com.baidu.swan.apps.w.c
    public String DJ() {
        return TextUtils.isEmpty(this.axb) ? "" : this.axb;
    }

    @Override // com.baidu.swan.apps.w.c
    public String DK() {
        if (this.aym == null || this.aym.uA() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.aym.uA(), e.Ea().DI());
    }

    @Override // com.baidu.swan.apps.w.c
    public String DL() {
        return this.axc == null ? "" : this.axc.DL();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.c.e uy() {
        if (this.aym == null) {
            return null;
        }
        return this.aym.uy();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity DM() {
        return this.aym;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b zj() {
        com.baidu.swan.apps.core.c.h hVar;
        com.baidu.swan.apps.core.c.e uy = uy();
        if (uy != null && (hVar = (com.baidu.swan.apps.core.c.h) uy.l(com.baidu.swan.apps.core.c.h.class)) != null) {
            return hVar.zj();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e eg(String str) {
        return com.baidu.swan.apps.core.i.c.Aa().eg(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout eP(String str) {
        com.baidu.swan.apps.b.c.d wb;
        com.baidu.swan.apps.b.c.e eg = eg(str);
        if (eg == null || (wb = eg.wb()) == null) {
            return null;
        }
        return wb.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.as("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.avn;
            fVar.avs = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.avn + " ; needEncode = " + z);
            }
            a(dVar.asN, fVar);
            com.baidu.swan.apps.performance.e.as("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.i.c.Aa().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.i.c.Aa().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.c.d yO() {
        com.baidu.swan.apps.core.c.e uy = uy();
        if (uy == null) {
            return null;
        }
        return uy.yO();
    }

    @Override // com.baidu.swan.apps.w.c
    public String yA() {
        com.baidu.swan.apps.core.c.d yO = yO();
        return yO != null ? yO.yA() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d DN() {
        com.baidu.swan.apps.b.c.e eg = eg(yA());
        if (eg == null) {
            return null;
        }
        return eg.wb();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DO() {
        Pair<Integer, Integer> yB = yB();
        int intValue = ((Integer) yB.first).intValue();
        int intValue2 = ((Integer) yB.second).intValue();
        if (intValue == 0) {
            intValue = x.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = x.co(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> yB() {
        com.baidu.swan.apps.core.c.d yO = yO();
        return yO == null ? new Pair<>(0, 0) : yO.yB();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DP() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(x.getDisplayWidth(appContext)), Integer.valueOf(x.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cE(int i) {
        DC();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        DC();
        if (this.aym != null) {
            this.aym.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void uB() {
        DC();
        if (this.aym != null) {
            this.aym.uB();
        }
    }
}
