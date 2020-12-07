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
/* loaded from: classes25.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cOR;
    protected SwanAppPropertyWindow cOT;
    protected boolean cVv;
    protected String dcz;
    protected com.baidu.swan.games.t.a.a deA;
    protected com.baidu.swan.apps.runtime.config.a deB = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity deC;
    protected e deD;
    protected boolean deE;
    protected com.baidu.swan.apps.adaptation.b.a dez;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.aui();
        this.deD = new e();
        this.deD.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aBN() {
        if (aBZ() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cN(Context context) {
        aBN();
        this.deD.cP(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cO(Context context) {
        this.deD.cQ(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cVv = true;
        if (this.deD != null) {
            this.deD.aCj();
            this.deD = null;
        }
        g.aCy().aCA();
        com.baidu.swan.apps.process.a.b.b.a.aHx().release();
        akX();
        com.baidu.swan.apps.u.a.b.aAL().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.deC = null;
    }

    private void akX() {
        if (this.cOR != null) {
            ViewParent parent = this.cOR.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cOR);
            }
        }
        if (this.dez != null) {
            this.dez.akX();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void akN() {
        aBN();
        String aJW = com.baidu.swan.apps.runtime.e.aJW();
        if (!TextUtils.isEmpty(aJW)) {
            this.deE = true;
            this.deD.aCj();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aJW);
            bundle.putInt("task_id", aBZ().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.azE().akN();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void akO() {
        String aJW = com.baidu.swan.apps.runtime.e.aJW();
        if (!TextUtils.isEmpty(aJW)) {
            aBO();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aJW);
            bundle.putInt("task_id", ap.aPI().aPH());
            com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.azE().akO();
            com.baidu.swan.apps.t.a.azk().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aBO() {
        if (aCf()) {
            this.deD.aCg();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.deC != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.deC != null) {
                        int taskId = b.this.deC.getTaskId();
                        b.this.deC.finish();
                        if (z) {
                            b.this.deC.overridePendingTransition(0, a.C0379a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aOy().lG(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aBP() {
        this.deE = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void aBQ() {
        this.deE = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aqC() {
        return com.baidu.swan.apps.runtime.e.aJU();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion aBR() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aBN();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aBN();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aBS() {
        aBN();
        if (this.dez == null) {
            this.dez = com.baidu.swan.apps.core.turbo.d.aui().auj().cb(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.eR(true);
        }
        if (this.deC != null) {
            this.dez.z((ViewGroup) this.deC.findViewById(a.f.ai_apps_activity_root));
        }
        return this.dez;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView I(Activity activity) {
        aBN();
        if (activity == null) {
            return null;
        }
        if (this.cOR == null) {
            this.cOR = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cOR.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cOR.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cOR.setVisibility(8);
            this.cOR.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a dez;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.dez == null) {
                        this.dez = f.aCp().aBS();
                    }
                    this.dez.akW();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aCe() {
                }
            });
        }
        return this.cOR;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        aBN();
        if (activity == null) {
            return null;
        }
        if (this.cOT == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cOT = new SwanAppPropertyWindow(activity);
            this.cOT.setVisibility(8);
            viewGroup.addView(this.cOT);
        }
        return this.cOT;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aBT() {
        aBN();
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        b.a aVar = null;
        if (aJU != null) {
            aVar = aJU.aio();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.aui().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.deC = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData aBU() {
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        if (aJQ.aId()) {
            return aJQ.aJM().aKd();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c qm(String str) {
        SwanAppConfigData aBU = aBU();
        if (aBU == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aKW();
        }
        return this.deB.a(aBW(), str, aBU.dyV);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c qn(String str) {
        SwanAppConfigData aBU = aBU();
        if (aBU == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aKW();
        }
        return this.deB.b(aBW(), str, aBU.dyV);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? qm(str) : this.deB.a(str2, str, swanAppConfigData.dyV);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c aBV() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        return aJV == null ? new com.baidu.swan.apps.storage.b.b() : aJV.aBV();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aBW() {
        return TextUtils.isEmpty(this.dcz) ? "" : this.dcz;
    }

    @Override // com.baidu.swan.apps.v.d
    public String aBX() {
        com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
        if (aJV == null || aJV.aio() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aJV.aio(), f.aCp().aBU());
    }

    @Override // com.baidu.swan.apps.v.d
    public String aBY() {
        SwanAppConfigData aBU = aBU();
        return aBU == null ? "" : aBU.aBY();
    }

    public com.baidu.swan.apps.core.d.f aim() {
        if (this.deC == null) {
            return null;
        }
        return this.deC.aim();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity aBZ() {
        return com.baidu.swan.apps.runtime.d.aJQ().aJO();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d asa() {
        j jVar;
        com.baidu.swan.apps.core.d.f aim = aim();
        if (aim != null && (jVar = (j) aim.q(j.class)) != null) {
            return jVar.asa();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d asb() {
        j jVar;
        com.baidu.swan.apps.core.d.f aim = aim();
        if (aim != null && (jVar = (j) aim.q(j.class)) != null) {
            return jVar.asb();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e oj(String str) {
        return com.baidu.swan.apps.core.turbo.d.aui().oj(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout qo(String str) {
        com.baidu.swan.apps.adaptation.b.d alh;
        com.baidu.swan.apps.adaptation.b.e oj = oj(str);
        if (oj == null || (alh = oj.alh()) == null) {
            return null;
        }
        return alh.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cYG = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cRq, gVar);
            com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.aui().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.aui().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e arC() {
        com.baidu.swan.apps.core.d.f aim = aim();
        if (aim == null) {
            return null;
        }
        return aim.arC();
    }

    @Override // com.baidu.swan.apps.v.d
    public String arl() {
        com.baidu.swan.apps.core.d.e arC = arC();
        return arC != null ? arC.arl() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d aCa() {
        com.baidu.swan.apps.adaptation.b.e oj = oj(arl());
        if (oj == null) {
            return null;
        }
        return oj.alh();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aCb() {
        Pair<Integer, Integer> arn = arn();
        int intValue = ((Integer) arn.first).intValue();
        int intValue2 = ((Integer) arn.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.ds(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> arn() {
        com.baidu.swan.apps.core.d.e arC = arC();
        return arC == null ? new Pair<>(0, 0) : arC.arn();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aCc() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aJQ().aJO() != null && (window = com.baidu.swan.apps.runtime.d.aJQ().aJO().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.dp(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void jC(int i) {
        aBN();
        com.baidu.swan.apps.ap.b.aOy().l(this.deC);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aJO = com.baidu.swan.apps.runtime.d.aJQ().aJO();
        if (aJO != null && !aJO.isFinishing()) {
            aJO.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aip() {
        SwanAppActivity aJO = com.baidu.swan.apps.runtime.d.aJQ().aJO();
        if (aJO != null && !aJO.isFinishing()) {
            aJO.aip();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a aCd() {
        return null;
    }
}
