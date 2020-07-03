package com.baidu.swan.apps.w;

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
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected SwanAppPropertyWindow bZC;
    protected FullScreenFloatView bZz;
    protected boolean cfB;
    protected String clg;
    protected com.baidu.swan.apps.adaptation.b.a cmW;
    protected com.baidu.swan.games.t.a.a cmX;
    protected com.baidu.swan.apps.runtime.config.a cmY = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cmZ;
    protected e cna;
    protected boolean cnb;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.acr();
        this.cna = new e();
        this.cna.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aiz() {
        if (aiL() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void bT(Context context) {
        aiz();
        this.cna.bV(context);
    }

    @Override // com.baidu.swan.apps.w.d
    public void bU(Context context) {
        this.cna.bW(context);
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void doRelease() {
        this.cfB = true;
        if (this.cna != null) {
            this.cna.aiV();
            this.cna = null;
        }
        g.ajk().ajm();
        com.baidu.swan.apps.process.a.b.b.a.anD().release();
        Ue();
        this.cmZ = null;
    }

    private void Ue() {
        if (this.bZz != null) {
            ViewParent parent = this.bZz.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bZz);
            }
        }
        if (this.cmW != null) {
            this.cmW.Ue();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void TW() {
        aiz();
        String apO = com.baidu.swan.apps.runtime.e.apO();
        if (!TextUtils.isEmpty(apO)) {
            this.cnb = true;
            this.cna.aiV();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", apO);
            bundle.putInt("task_id", aiL().getTaskId());
            com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.u.a.agz().TW();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void TX() {
        String apO = com.baidu.swan.apps.runtime.e.apO();
        if (!TextUtils.isEmpty(apO)) {
            aiA();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", apO);
            com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.u.a.agz().TX();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void aiA() {
        if (aiR()) {
            this.cna.aiS();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cmZ != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cmZ != null) {
                        int taskId = b.this.cmZ.getTaskId();
                        b.this.cmZ.finish();
                        if (z) {
                            b.this.cmZ.overridePendingTransition(0, a.C0287a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.aq.a.auc().hS(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        aiz();
        SwanAppActivity aiL = aiL();
        if (aiL != null) {
            aiL.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void aiB() {
        this.cnb = false;
    }

    @Override // com.baidu.swan.apps.w.d
    public void aiC() {
        this.cnb = true;
    }

    @Override // com.baidu.swan.apps.w.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aai() {
        return com.baidu.swan.apps.runtime.e.apM();
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanCoreVersion aiD() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aiz();
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aiz();
    }

    @Override // com.baidu.swan.apps.w.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aiE() {
        aiz();
        if (this.cmW == null) {
            this.cmW = com.baidu.swan.apps.core.turbo.d.acr().acs().bh(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.dw(true);
        }
        if (this.cmZ != null) {
            this.cmW.t((ViewGroup) this.cmZ.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cmW;
    }

    @Override // com.baidu.swan.apps.w.d
    public FullScreenFloatView I(Activity activity) {
        aiz();
        if (activity == null) {
            return null;
        }
        if (this.bZz == null) {
            this.bZz = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bZz.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bZz.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bZz.setVisibility(8);
            this.bZz.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.b.2
                com.baidu.swan.apps.adaptation.b.a cmW;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cmW == null) {
                        this.cmW = f.ajb().aiE();
                    }
                    this.cmW.Ud();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aiQ() {
                }
            });
        }
        return this.bZz;
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        aiz();
        if (activity == null) {
            return null;
        }
        if (this.bZC == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bZC = new SwanAppPropertyWindow(activity);
            this.bZC.setVisibility(8);
            viewGroup.addView(this.bZC);
        }
        return this.bZC;
    }

    @Override // com.baidu.swan.apps.w.d
    public boolean aiF() {
        aiz();
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        b.a aVar = null;
        if (apM != null) {
            aVar = apM.RP();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.w.d
    public void u(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.acr().p(intent);
    }

    @Override // com.baidu.swan.apps.w.d
    public void h(SwanAppActivity swanAppActivity) {
        this.cmZ = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanAppConfigData aiG() {
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        if (apI.aok()) {
            return apI.apE().apV();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c ly(String str) {
        SwanAppConfigData aiG = aiG();
        if (aiG == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aqP();
        }
        return this.cmY.a(aiI(), str, aiG.cFf);
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.runtime.config.c lz(String str) {
        SwanAppConfigData aiG = aiG();
        if (aiG == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aqP();
        }
        return this.cmY.b(aiI(), str, aiG.cFf);
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c aiH() {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        return apN == null ? new com.baidu.swan.apps.storage.b.b() : apN.aiH();
    }

    @Override // com.baidu.swan.apps.w.d
    public String aiI() {
        return TextUtils.isEmpty(this.clg) ? "" : this.clg;
    }

    @Override // com.baidu.swan.apps.w.d
    public String aiJ() {
        com.baidu.swan.apps.runtime.e apN = com.baidu.swan.apps.runtime.e.apN();
        if (apN == null || apN.RP() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(apN.RP(), f.ajb().aiG());
    }

    @Override // com.baidu.swan.apps.w.d
    public String aiK() {
        SwanAppConfigData aiG = aiG();
        return aiG == null ? "" : aiG.aiK();
    }

    public com.baidu.swan.apps.core.d.e RN() {
        if (this.cmZ == null) {
            return null;
        }
        return this.cmZ.RN();
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanAppActivity aiL() {
        return com.baidu.swan.apps.runtime.d.apI().apG();
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.games.view.d aax() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e RN = RN();
        if (RN != null && (iVar = (com.baidu.swan.apps.core.d.i) RN.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.aax();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.games.view.d aay() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e RN = RN();
        if (RN != null && (iVar = (com.baidu.swan.apps.core.d.i) RN.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.aay();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.adaptation.b.e jW(String str) {
        return com.baidu.swan.apps.core.turbo.d.acr().jW(str);
    }

    @Override // com.baidu.swan.apps.w.d
    public AbsoluteLayout lA(String str) {
        com.baidu.swan.apps.adaptation.b.d Un;
        com.baidu.swan.apps.adaptation.b.e jW = jW(str);
        if (jW == null || (Un = jW.Un()) == null) {
            return null;
        }
        return Un.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.f.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.chE = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cey, gVar);
            com.baidu.swan.apps.performance.f.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void a(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.acr().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.acr().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.core.d.d ZW() {
        com.baidu.swan.apps.core.d.e RN = RN();
        if (RN == null) {
            return null;
        }
        return RN.ZW();
    }

    @Override // com.baidu.swan.apps.w.d
    public String ZH() {
        com.baidu.swan.apps.core.d.d ZW = ZW();
        return ZW != null ? ZW.ZH() : "";
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.adaptation.b.d aiM() {
        com.baidu.swan.apps.adaptation.b.e jW = jW(ZH());
        if (jW == null) {
            return null;
        }
        return jW.Un();
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> aiN() {
        Pair<Integer, Integer> ZJ = ZJ();
        int intValue = ((Integer) ZJ.first).intValue();
        int intValue2 = ((Integer) ZJ.second).intValue();
        if (intValue == 0) {
            intValue = ag.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ag.cw(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> ZJ() {
        com.baidu.swan.apps.core.d.d ZW = ZW();
        return ZW == null ? new Pair<>(0, 0) : ZW.ZJ();
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> aiO() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ag.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.apI().apG() != null && (window = com.baidu.swan.apps.runtime.d.apI().apG().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ag.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ag.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? aa.cv(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.w.e.b
    public void fS(int i) {
        aiz();
        com.baidu.swan.apps.aq.a.auc().k(this.cmZ);
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.d
    public void showLoadingView() {
        SwanAppActivity apG = com.baidu.swan.apps.runtime.d.apI().apG();
        if (apG != null && !apG.isFinishing()) {
            apG.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void RQ() {
        SwanAppActivity apG = com.baidu.swan.apps.runtime.d.apI().apG();
        if (apG != null && !apG.isFinishing()) {
            apG.RQ();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.games.q.a aiP() {
        return null;
    }
}
