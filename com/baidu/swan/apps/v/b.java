package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.ab;
import com.baidu.swan.apps.aq.ai;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes7.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView caW;
    protected SwanAppPropertyWindow caY;
    protected boolean chl;
    protected String cnk;
    protected com.baidu.swan.apps.adaptation.b.a cpd;
    protected com.baidu.swan.games.t.a.a cpe;
    protected com.baidu.swan.apps.runtime.config.a cpf = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cpg;
    protected e cph;
    protected boolean cpi;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.adw();
        this.cph = new e();
        this.cph.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ajP() {
        if (akb() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void bW(Context context) {
        ajP();
        this.cph.bY(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void bX(Context context) {
        this.cph.bZ(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.chl = true;
        if (this.cph != null) {
            this.cph.akl();
            this.cph = null;
        }
        g.akA().akC();
        com.baidu.swan.apps.process.a.b.b.a.apn().release();
        UF();
        com.baidu.swan.apps.u.a.b.aiO().clear();
        this.cpg = null;
    }

    private void UF() {
        if (this.caW != null) {
            ViewParent parent = this.caW.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.caW);
            }
        }
        if (this.cpd != null) {
            this.cpd.UF();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void Uw() {
        ajP();
        String arx = com.baidu.swan.apps.runtime.e.arx();
        if (!TextUtils.isEmpty(arx)) {
            this.cpi = true;
            this.cph.akl();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", arx);
            bundle.putInt("task_id", akb().getTaskId());
            com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.ahM().Uw();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void Ux() {
        String arx = com.baidu.swan.apps.runtime.e.arx();
        if (!TextUtils.isEmpty(arx)) {
            ajQ();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", arx);
            bundle.putInt("task_id", aq.axo().axn());
            com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.ahM().Ux();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ajQ() {
        if (akh()) {
            this.cph.aki();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cpg != null) {
            al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cpg != null) {
                        int taskId = b.this.cpg.getTaskId();
                        b.this.cpg.finish();
                        if (z) {
                            b.this.cpg.overridePendingTransition(0, a.C0290a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.aq.b.awd().ib(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ajR() {
        this.cpi = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void ajS() {
        this.cpi = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aad() {
        return com.baidu.swan.apps.runtime.e.arv();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion ajT() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        ajP();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        ajP();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a ajU() {
        ajP();
        if (this.cpd == null) {
            this.cpd = com.baidu.swan.apps.core.turbo.d.adw().adx().bj(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.dz(true);
        }
        if (this.cpg != null) {
            this.cpd.u((ViewGroup) this.cpg.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cpd;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        ajP();
        if (activity == null) {
            return null;
        }
        if (this.caW == null) {
            this.caW = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.caW.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.caW.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.caW.setVisibility(8);
            this.caW.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cpd;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cpd == null) {
                        this.cpd = f.akr().ajU();
                    }
                    this.cpd.UE();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void akg() {
                }
            });
        }
        return this.caW;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        ajP();
        if (activity == null) {
            return null;
        }
        if (this.caY == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.caY = new SwanAppPropertyWindow(activity);
            this.caY.setVisibility(8);
            viewGroup.addView(this.caY);
        }
        return this.caY;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean ajV() {
        ajP();
        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
        b.a aVar = null;
        if (arv != null) {
            aVar = arv.Se();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void u(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.adw().p(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cpg = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData ajW() {
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        if (arr.apU()) {
            return arr.arn().arE();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c lZ(String str) {
        SwanAppConfigData ajW = ajW();
        if (ajW == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.asy();
        }
        return this.cpf.a(ajY(), str, ajW.cHV);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c ma(String str) {
        SwanAppConfigData ajW = ajW();
        if (ajW == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.asy();
        }
        return this.cpf.b(ajY(), str, ajW.cHV);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? lZ(str) : this.cpf.a(str2, str, swanAppConfigData.cHV);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c ajX() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        return arw == null ? new com.baidu.swan.apps.storage.b.b() : arw.ajX();
    }

    @Override // com.baidu.swan.apps.v.d
    public String ajY() {
        return TextUtils.isEmpty(this.cnk) ? "" : this.cnk;
    }

    @Override // com.baidu.swan.apps.v.d
    public String ajZ() {
        com.baidu.swan.apps.runtime.e arw = com.baidu.swan.apps.runtime.e.arw();
        if (arw == null || arw.Se() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(arw.Se(), f.akr().ajW());
    }

    @Override // com.baidu.swan.apps.v.d
    public String aka() {
        SwanAppConfigData ajW = ajW();
        return ajW == null ? "" : ajW.aka();
    }

    public com.baidu.swan.apps.core.d.f Sc() {
        if (this.cpg == null) {
            return null;
        }
        return this.cpg.Sc();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity akb() {
        return com.baidu.swan.apps.runtime.d.arr().arp();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d abz() {
        j jVar;
        com.baidu.swan.apps.core.d.f Sc = Sc();
        if (Sc != null && (jVar = (j) Sc.q(j.class)) != null) {
            return jVar.abz();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d abA() {
        j jVar;
        com.baidu.swan.apps.core.d.f Sc = Sc();
        if (Sc != null && (jVar = (j) Sc.q(j.class)) != null) {
            return jVar.abA();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e kq(String str) {
        return com.baidu.swan.apps.core.turbo.d.adw().kq(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout mb(String str) {
        com.baidu.swan.apps.adaptation.b.d UP;
        com.baidu.swan.apps.adaptation.b.e kq = kq(str);
        if (kq == null || (UP = kq.UP()) == null) {
            return null;
        }
        return UP.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.C("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cjD = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cgh, gVar);
            com.baidu.swan.apps.performance.h.C("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.adw().a(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.adw().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e aba() {
        com.baidu.swan.apps.core.d.f Sc = Sc();
        if (Sc == null) {
            return null;
        }
        return Sc.aba();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aaL() {
        com.baidu.swan.apps.core.d.e aba = aba();
        return aba != null ? aba.aaL() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d akc() {
        com.baidu.swan.apps.adaptation.b.e kq = kq(aaL());
        if (kq == null) {
            return null;
        }
        return kq.UP();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> akd() {
        Pair<Integer, Integer> aaN = aaN();
        int intValue = ((Integer) aaN.first).intValue();
        int intValue2 = ((Integer) aaN.second).intValue();
        if (intValue == 0) {
            intValue = ai.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ai.cA(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> aaN() {
        com.baidu.swan.apps.core.d.e aba = aba();
        return aba == null ? new Pair<>(0, 0) : aba.aaN();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> ake() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ai.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.arr().arp() != null && (window = com.baidu.swan.apps.runtime.d.arr().arp().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ai.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ai.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ab.cx(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void gc(int i) {
        ajP();
        com.baidu.swan.apps.aq.b.awd().l(this.cpg);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity arp = com.baidu.swan.apps.runtime.d.arr().arp();
        if (arp != null && !arp.isFinishing()) {
            arp.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void Sf() {
        SwanAppActivity arp = com.baidu.swan.apps.runtime.d.arr().arp();
        if (arp != null && !arp.isFinishing()) {
            arp.Sf();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a akf() {
        return null;
    }
}
