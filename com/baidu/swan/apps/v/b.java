package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsoluteLayout;
import androidx.annotation.CallSuper;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ac;
import com.baidu.swan.apps.ao.ah;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes8.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cPa;
    protected SwanAppPropertyWindow cPc;
    protected String dcE;
    protected com.baidu.swan.apps.adaptation.b.a deE;
    protected com.baidu.swan.games.t.a.a deF;
    protected com.baidu.swan.apps.runtime.config.a deG = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity deH;
    protected e deI;
    protected boolean deJ;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.arG();
        this.deI = new e();
        this.deI.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azl() {
        if (azx() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cU(Context context) {
        azl();
        this.deI.cW(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cV(Context context) {
        this.deI.cX(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.deI != null) {
            this.deI.azH();
            this.deI = null;
        }
        g.azW().azY();
        com.baidu.swan.apps.process.a.b.b.a.aEX().release();
        aio();
        com.baidu.swan.apps.u.a.b.ayj().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.deH = null;
    }

    private void aio() {
        if (this.cPa != null) {
            ViewParent parent = this.cPa.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cPa);
            }
        }
        if (this.deE != null) {
            this.deE.aio();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aie() {
        azl();
        String aIt = com.baidu.swan.apps.runtime.e.aIt();
        if (!TextUtils.isEmpty(aIt)) {
            this.deJ = true;
            this.deI.azH();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aIt);
            bundle.putInt("task_id", azx().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.axc().aie();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aif() {
        String aIt = com.baidu.swan.apps.runtime.e.aIt();
        if (!TextUtils.isEmpty(aIt)) {
            azm();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aIt);
            bundle.putInt("task_id", ap.aOh().aOg());
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.axc().aif();
            com.baidu.swan.apps.t.a.awI().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azm() {
        if (azD()) {
            this.deI.azE();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.deH != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.deH != null) {
                        int taskId = b.this.deH.getTaskId();
                        b.this.deH.finish();
                        if (z) {
                            b.this.deH.overridePendingTransition(0, a.C0355a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ao.b.aMW().kf(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azn() {
        this.deJ = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void azo() {
        this.deJ = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e anU() {
        return com.baidu.swan.apps.runtime.e.aIr();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion azp() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azl();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azl();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azq() {
        azl();
        if (this.deE == null) {
            this.deE = com.baidu.swan.apps.core.turbo.d.arG().arH().ch(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.eW(true);
        }
        if (this.deH != null) {
            this.deE.C((ViewGroup) this.deH.findViewById(a.f.ai_apps_activity_root));
        }
        return this.deE;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        azl();
        if (activity == null) {
            return null;
        }
        if (this.cPa == null) {
            this.cPa = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cPa.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cPa.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cPa.setVisibility(8);
            this.cPa.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a deE;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.deE == null) {
                        this.deE = f.azN().azq();
                    }
                    this.deE.ain();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void azC() {
                }
            });
        }
        return this.cPa;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        azl();
        if (activity == null) {
            return null;
        }
        if (this.cPc == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cPc = new SwanAppPropertyWindow(activity);
            this.cPc.setVisibility(8);
            viewGroup.addView(this.cPc);
        }
        return this.cPc;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azr() {
        azl();
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        b.a aVar = null;
        if (aIr != null) {
            aVar = aIr.afB();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.arG().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.deH = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData azs() {
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        if (aIn.aFD()) {
            return aIn.aIj().aIA();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c oU(String str) {
        SwanAppConfigData azs = azs();
        if (azs == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aJt();
        }
        return this.deG.a(azu(), str, azs.dCO);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c oV(String str) {
        SwanAppConfigData azs = azs();
        if (azs == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aJt();
        }
        return this.deG.b(azu(), str, azs.dCO);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? oU(str) : this.deG.a(str2, str, swanAppConfigData.dCO);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c azt() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        return aIs == null ? new com.baidu.swan.apps.storage.b.b() : aIs.azt();
    }

    @Override // com.baidu.swan.apps.v.d
    public String azu() {
        return TextUtils.isEmpty(this.dcE) ? "" : this.dcE;
    }

    @Override // com.baidu.swan.apps.v.d
    public String azv() {
        com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
        if (aIs == null || aIs.afB() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aIs.afB(), f.azN().azs());
    }

    @Override // com.baidu.swan.apps.v.d
    public String azw() {
        SwanAppConfigData azs = azs();
        return azs == null ? "" : azs.azw();
    }

    public com.baidu.swan.apps.core.d.f afz() {
        if (this.deH == null) {
            return null;
        }
        return this.deH.afz();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity azx() {
        return com.baidu.swan.apps.runtime.d.aIn().aIl();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apy() {
        j jVar;
        com.baidu.swan.apps.core.d.f afz = afz();
        if (afz != null && (jVar = (j) afz.j(j.class)) != null) {
            return jVar.apy();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apz() {
        j jVar;
        com.baidu.swan.apps.core.d.f afz = afz();
        if (afz != null && (jVar = (j) afz.j(j.class)) != null) {
            return jVar.apz();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e mQ(String str) {
        return com.baidu.swan.apps.core.turbo.d.arG().mQ(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout oW(String str) {
        com.baidu.swan.apps.adaptation.b.d aiy;
        com.baidu.swan.apps.adaptation.b.e mQ = mQ(str);
        if (mQ == null || (aiy = mQ.aiy()) == null) {
            return null;
        }
        return aiy.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cYM = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cRB, gVar);
            com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.arG().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.arG().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e aoZ() {
        com.baidu.swan.apps.core.d.f afz = afz();
        if (afz == null) {
            return null;
        }
        return afz.aoZ();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aoI() {
        com.baidu.swan.apps.core.d.e aoZ = aoZ();
        return aoZ != null ? aoZ.aoI() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d azy() {
        com.baidu.swan.apps.adaptation.b.e mQ = mQ(aoI());
        if (mQ == null) {
            return null;
        }
        return mQ.aiy();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azz() {
        Pair<Integer, Integer> aoK = aoK();
        int intValue = ((Integer) aoK.first).intValue();
        int intValue2 = ((Integer) aoK.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.dK(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> aoK() {
        com.baidu.swan.apps.core.d.e aoZ = aoZ();
        return aoZ == null ? new Pair<>(0, 0) : aoZ.aoK();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azA() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aIn().aIl() != null && (window = com.baidu.swan.apps.runtime.d.aIn().aIl().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.dH(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void hR(int i) {
        azl();
        com.baidu.swan.apps.ao.b.aMW().l(this.deH);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aIl = com.baidu.swan.apps.runtime.d.aIn().aIl();
        if (aIl != null && !aIl.isFinishing()) {
            aIl.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void afC() {
        SwanAppActivity aIl = com.baidu.swan.apps.runtime.d.aIn().aIl();
        if (aIl != null && !aIl.isFinishing()) {
            aIl.afC();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a azB() {
        return null;
    }
}
