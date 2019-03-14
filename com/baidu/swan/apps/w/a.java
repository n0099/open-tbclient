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
    protected FullScreenFloatView apN;
    protected SwanAppPropertyWindow apQ;
    protected boolean aty;
    protected String awY;
    protected com.baidu.swan.apps.ae.a.c awZ;
    protected com.baidu.swan.apps.b.c.a ayg;
    protected com.baidu.swan.games.o.a.a ayh;
    protected com.baidu.swan.apps.ae.a.a ayi = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity ayj;
    protected d ayk;
    protected boolean ayl;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.i.c.Ab();
        this.ayk = new d();
        this.ayk.a(this);
        f.Ee().Ef();
    }

    private void DE() {
        if (DO() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bL(Context context) {
        DE();
        this.ayk.bN(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bM(Context context) {
        this.ayk.bO(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.aty = true;
        if (this.ayk != null) {
            this.ayk.DW();
            this.ayk = null;
        }
        f.Ee().Eg();
        com.baidu.swan.apps.process.b.b.b.a.Gn().release();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void vQ() {
        DE();
        String Ji = com.baidu.swan.apps.ae.b.Ji();
        if (!TextUtils.isEmpty(Ji)) {
            this.ayl = true;
            this.ayk.DW();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", Ji);
            com.baidu.swan.apps.process.messaging.client.a.Gq().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void vR() {
        if (!TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Ji()) && this.ayl) {
            this.ayk.DT();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.ayj != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ayj != null) {
                        com.baidu.swan.apps.performance.f.aEc = true;
                        a.this.ayj.finish();
                        if (z) {
                            a.this.ayj.overridePendingTransition(0, a.C0107a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0108a interfaceC0108a) {
        DE();
        SwanAppActivity DO = DO();
        if (DO != null) {
            DO.a(i, strArr, interfaceC0108a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void DF() {
        this.ayl = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void DG() {
        this.ayl = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b zb() {
        return com.baidu.swan.apps.ae.b.IX();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion DH() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        DE();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        DE();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a DI() {
        DE();
        if (this.ayg == null) {
            this.ayg = com.baidu.swan.apps.core.i.c.Ab().Ac().bo(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.aR(true);
        }
        if (this.ayj != null) {
            this.ayg.e((ViewGroup) this.ayj.findViewById(a.f.ai_apps_activity_root));
        }
        return this.ayg;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        DE();
        if (activity == null) {
            return null;
        }
        if (this.apN == null) {
            this.apN = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.apN.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.apN.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.apN.setVisibility(8);
            this.apN.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a ayg;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.ayg == null) {
                        this.ayg = e.Ec().DI();
                    }
                    this.ayg.vU();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void DS() {
                }
            });
        }
        return this.apN;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        DE();
        if (activity == null) {
            return null;
        }
        if (this.apQ == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.apQ = new SwanAppPropertyWindow(activity);
            this.apQ.setVisibility(8);
            viewGroup.addView(this.apQ);
        }
        return this.apQ;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean DJ() {
        DE();
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (IX != null) {
            bVar = IX.uB();
        }
        return bVar != null && ((DEBUG && bVar.axS) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void J(Intent intent) {
        com.baidu.swan.apps.core.i.c.Ab().D(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.ayj = swanAppActivity;
        com.baidu.swan.apps.ae.b zb = zb();
        if (zb == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.uB());
            zb = zb();
        }
        if (zb != null) {
            zb.H(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c DK() {
        return this.awZ;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d eN(String str) {
        if (this.awZ == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.JC();
        }
        return this.ayi.a(DL(), str, this.awZ.aOj);
    }

    @Override // com.baidu.swan.apps.w.c
    public String DL() {
        return TextUtils.isEmpty(this.awY) ? "" : this.awY;
    }

    @Override // com.baidu.swan.apps.w.c
    public String DM() {
        if (this.ayj == null || this.ayj.uB() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.ayj.uB(), e.Ec().DK());
    }

    @Override // com.baidu.swan.apps.w.c
    public String DN() {
        return this.awZ == null ? "" : this.awZ.DN();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.c.e uz() {
        if (this.ayj == null) {
            return null;
        }
        return this.ayj.uz();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity DO() {
        return this.ayj;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b zk() {
        com.baidu.swan.apps.core.c.h hVar;
        com.baidu.swan.apps.core.c.e uz = uz();
        if (uz != null && (hVar = (com.baidu.swan.apps.core.c.h) uz.l(com.baidu.swan.apps.core.c.h.class)) != null) {
            return hVar.zk();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e ee(String str) {
        return com.baidu.swan.apps.core.i.c.Ab().ee(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout eO(String str) {
        com.baidu.swan.apps.b.c.d wc;
        com.baidu.swan.apps.b.c.e ee = ee(str);
        if (ee == null || (wc = ee.wc()) == null) {
            return null;
        }
        return wc.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.as("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.avk;
            fVar.avp = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.avk + " ; needEncode = " + z);
            }
            a(dVar.asJ, fVar);
            com.baidu.swan.apps.performance.e.as("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.i.c.Ab().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.i.c.Ab().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.c.d yP() {
        com.baidu.swan.apps.core.c.e uz = uz();
        if (uz == null) {
            return null;
        }
        return uz.yP();
    }

    @Override // com.baidu.swan.apps.w.c
    public String yB() {
        com.baidu.swan.apps.core.c.d yP = yP();
        return yP != null ? yP.yB() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d DP() {
        com.baidu.swan.apps.b.c.e ee = ee(yB());
        if (ee == null) {
            return null;
        }
        return ee.wc();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DQ() {
        Pair<Integer, Integer> yC = yC();
        int intValue = ((Integer) yC.first).intValue();
        int intValue2 = ((Integer) yC.second).intValue();
        if (intValue == 0) {
            intValue = x.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = x.co(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> yC() {
        com.baidu.swan.apps.core.c.d yP = yP();
        return yP == null ? new Pair<>(0, 0) : yP.yC();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> DR() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(x.getDisplayWidth(appContext)), Integer.valueOf(x.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cF(int i) {
        DE();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        DE();
        if (this.ayj != null) {
            this.ayj.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void uC() {
        DE();
        if (this.ayj != null) {
            this.ayj.uC();
        }
    }
}
