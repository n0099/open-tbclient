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
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.x;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
/* loaded from: classes2.dex */
public abstract class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    protected FullScreenFloatView apM;
    protected SwanAppPropertyWindow apP;
    protected boolean atx;
    protected String awX;
    protected com.baidu.swan.apps.ae.a.c awY;
    protected com.baidu.swan.apps.b.c.a ayf;
    protected com.baidu.swan.games.o.a.a ayg;
    protected com.baidu.swan.apps.ae.a.a ayh = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity ayi;
    protected d ayj;
    protected boolean ayk;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.i.c.Ab();
        this.ayj = new d();
        this.ayj.a(this);
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
        this.ayj.bN(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bM(Context context) {
        this.ayj.bO(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.atx = true;
        if (this.ayj != null) {
            this.ayj.DW();
            this.ayj = null;
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
            this.ayk = true;
            this.ayj.DW();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", Ji);
            com.baidu.swan.apps.process.messaging.client.a.Gq().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void vR() {
        if (!TextUtils.isEmpty(com.baidu.swan.apps.ae.b.Ji()) && this.ayk) {
            this.ayj.DT();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.ayi != null) {
            aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.ayi != null) {
                        com.baidu.swan.apps.performance.f.aEb = true;
                        a.this.ayi.finish();
                        if (z) {
                            a.this.ayi.overridePendingTransition(0, b.a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0078a interfaceC0078a) {
        DE();
        SwanAppActivity DO = DO();
        if (DO != null) {
            DO.a(i, strArr, interfaceC0078a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void DF() {
        this.ayk = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void DG() {
        this.ayk = true;
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
        if (this.ayf == null) {
            this.ayf = com.baidu.swan.apps.core.i.c.Ab().Ac().bo(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.aR(true);
        }
        if (this.ayi != null) {
            this.ayf.e((ViewGroup) this.ayi.findViewById(b.f.ai_apps_activity_root));
        }
        return this.ayf;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        DE();
        if (activity == null) {
            return null;
        }
        if (this.apM == null) {
            this.apM = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.apM.setFloatButtonText(activity.getString(b.h.aiapps_sconsole));
            this.apM.setFloatImageBackground(b.e.aiapps_float_view_button_shape);
            this.apM.setVisibility(8);
            this.apM.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a ayf;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.ayf == null) {
                        this.ayf = e.Ec().DI();
                    }
                    this.ayf.vU();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void DS() {
                }
            });
        }
        return this.apM;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        DE();
        if (activity == null) {
            return null;
        }
        if (this.apP == null && (viewGroup = (ViewGroup) activity.findViewById(b.f.ai_apps_activity_root)) != null) {
            this.apP = new SwanAppPropertyWindow(activity);
            this.apP.setVisibility(8);
            viewGroup.addView(this.apP);
        }
        return this.apP;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean DJ() {
        DE();
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (IX != null) {
            bVar = IX.uB();
        }
        return bVar != null && ((DEBUG && bVar.axR) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void J(Intent intent) {
        com.baidu.swan.apps.core.i.c.Ab().D(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.ayi = swanAppActivity;
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
        return this.awY;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d eN(String str) {
        if (this.awY == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.JC();
        }
        return this.ayh.a(DL(), str, this.awY.aOi);
    }

    @Override // com.baidu.swan.apps.w.c
    public String DL() {
        return TextUtils.isEmpty(this.awX) ? "" : this.awX;
    }

    @Override // com.baidu.swan.apps.w.c
    public String DM() {
        if (this.ayi == null || this.ayi.uB() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.ayi.uB(), e.Ec().DK());
    }

    @Override // com.baidu.swan.apps.w.c
    public String DN() {
        return this.awY == null ? "" : this.awY.DN();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.c.e uz() {
        if (this.ayi == null) {
            return null;
        }
        return this.ayi.uz();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity DO() {
        return this.ayi;
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
            fVar.mData = dVar.avj;
            fVar.avo = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.avj + " ; needEncode = " + z);
            }
            a(dVar.asI, fVar);
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
        if (this.ayi != null) {
            this.ayi.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void uC() {
        DE();
        if (this.ayi != null) {
            this.ayi.uC();
        }
    }
}
