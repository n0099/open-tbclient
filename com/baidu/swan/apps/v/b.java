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
import com.baidu.swan.apps.ap.ac;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cDP;
    protected SwanAppPropertyWindow cDR;
    protected boolean cKt;
    protected String cRt;
    protected com.baidu.swan.apps.adaptation.b.a cTr;
    protected com.baidu.swan.games.t.a.a cTs;
    protected com.baidu.swan.apps.runtime.config.a cTt = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cTu;
    protected e cTv;
    protected boolean cTw;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.aph();
        this.cTv = new e();
        this.cTv.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void awM() {
        if (awY() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ch(Context context) {
        awM();
        this.cTv.cj(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void ci(Context context) {
        this.cTv.ck(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cKt = true;
        if (this.cTv != null) {
            this.cTv.axi();
            this.cTv = null;
        }
        g.axx().axz();
        com.baidu.swan.apps.process.a.b.b.a.aCx().release();
        afX();
        com.baidu.swan.apps.u.a.b.avK().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.cTu = null;
    }

    private void afX() {
        if (this.cDP != null) {
            ViewParent parent = this.cDP.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cDP);
            }
        }
        if (this.cTr != null) {
            this.cTr.afX();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void afN() {
        awM();
        String aEW = com.baidu.swan.apps.runtime.e.aEW();
        if (!TextUtils.isEmpty(aEW)) {
            this.cTw = true;
            this.cTv.axi();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aEW);
            bundle.putInt("task_id", awY().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.auE().afN();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void afO() {
        String aEW = com.baidu.swan.apps.runtime.e.aEW();
        if (!TextUtils.isEmpty(aEW)) {
            awN();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aEW);
            bundle.putInt("task_id", ap.aKK().aKJ());
            com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.auE().afO();
            com.baidu.swan.apps.t.a.auk().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void awN() {
        if (axe()) {
            this.cTv.axf();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cTu != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cTu != null) {
                        int taskId = b.this.cTu.getTaskId();
                        b.this.cTu.finish();
                        if (z) {
                            b.this.cTu.overridePendingTransition(0, a.C0357a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aJz().lc(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void awO() {
        this.cTw = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void awP() {
        this.cTw = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e alC() {
        return com.baidu.swan.apps.runtime.e.aEU();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion awQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        awM();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        awM();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a awR() {
        awM();
        if (this.cTr == null) {
            this.cTr = com.baidu.swan.apps.core.turbo.d.aph().apj().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.eq(true);
        }
        if (this.cTu != null) {
            this.cTr.B((ViewGroup) this.cTu.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cTr;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView J(Activity activity) {
        awM();
        if (activity == null) {
            return null;
        }
        if (this.cDP == null) {
            this.cDP = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cDP.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cDP.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cDP.setVisibility(8);
            this.cDP.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cTr;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cTr == null) {
                        this.cTr = f.axo().awR();
                    }
                    this.cTr.afW();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void axd() {
                }
            });
        }
        return this.cDP;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow K(Activity activity) {
        ViewGroup viewGroup;
        awM();
        if (activity == null) {
            return null;
        }
        if (this.cDR == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cDR = new SwanAppPropertyWindow(activity);
            this.cDR.setVisibility(8);
            viewGroup.addView(this.cDR);
        }
        return this.cDR;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean awS() {
        awM();
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        b.a aVar = null;
        if (aEU != null) {
            aVar = aEU.ado();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.aph().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cTu = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData awT() {
        com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
        if (aEQ.aDd()) {
            return aEQ.aEM().aFd();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c px(String str) {
        SwanAppConfigData awT = awT();
        if (awT == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aFW();
        }
        return this.cTt.a(awV(), str, awT.dnG);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c py(String str) {
        SwanAppConfigData awT = awT();
        if (awT == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aFW();
        }
        return this.cTt.b(awV(), str, awT.dnG);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? px(str) : this.cTt.a(str2, str, swanAppConfigData.dnG);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c awU() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        return aEV == null ? new com.baidu.swan.apps.storage.b.b() : aEV.awU();
    }

    @Override // com.baidu.swan.apps.v.d
    public String awV() {
        return TextUtils.isEmpty(this.cRt) ? "" : this.cRt;
    }

    @Override // com.baidu.swan.apps.v.d
    public String awW() {
        com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
        if (aEV == null || aEV.ado() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aEV.ado(), f.axo().awT());
    }

    @Override // com.baidu.swan.apps.v.d
    public String awX() {
        SwanAppConfigData awT = awT();
        return awT == null ? "" : awT.awX();
    }

    public com.baidu.swan.apps.core.d.f adm() {
        if (this.cTu == null) {
            return null;
        }
        return this.cTu.adm();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity awY() {
        return com.baidu.swan.apps.runtime.d.aEQ().aEO();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d ana() {
        j jVar;
        com.baidu.swan.apps.core.d.f adm = adm();
        if (adm != null && (jVar = (j) adm.q(j.class)) != null) {
            return jVar.ana();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d anb() {
        j jVar;
        com.baidu.swan.apps.core.d.f adm = adm();
        if (adm != null && (jVar = (j) adm.q(j.class)) != null) {
            return jVar.anb();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e ns(String str) {
        return com.baidu.swan.apps.core.turbo.d.aph().ns(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout pz(String str) {
        com.baidu.swan.apps.adaptation.b.d agh;
        com.baidu.swan.apps.adaptation.b.e ns = ns(str);
        if (ns == null || (agh = ns.agh()) == null) {
            return null;
        }
        return agh.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cNE = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cGo, gVar);
            com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.aph().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.aph().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e amC() {
        com.baidu.swan.apps.core.d.f adm = adm();
        if (adm == null) {
            return null;
        }
        return adm.amC();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aml() {
        com.baidu.swan.apps.core.d.e amC = amC();
        return amC != null ? amC.aml() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d awZ() {
        com.baidu.swan.apps.adaptation.b.e ns = ns(aml());
        if (ns == null) {
            return null;
        }
        return ns.agh();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> axa() {
        Pair<Integer, Integer> amn = amn();
        int intValue = ((Integer) amn.first).intValue();
        int intValue2 = ((Integer) amn.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.cM(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> amn() {
        com.baidu.swan.apps.core.d.e amC = amC();
        return amC == null ? new Pair<>(0, 0) : amC.amn();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> axb() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aEQ().aEO() != null && (window = com.baidu.swan.apps.runtime.d.aEQ().aEO().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.cJ(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void iY(int i) {
        awM();
        com.baidu.swan.apps.ap.b.aJz().l(this.cTu);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aEO = com.baidu.swan.apps.runtime.d.aEQ().aEO();
        if (aEO != null && !aEO.isFinishing()) {
            aEO.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void adp() {
        SwanAppActivity aEO = com.baidu.swan.apps.runtime.d.aEQ().aEO();
        if (aEO != null && !aEO.isFinishing()) {
            aEO.adp();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a axc() {
        return null;
    }
}
