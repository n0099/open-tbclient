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
/* loaded from: classes7.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cHY;
    protected SwanAppPropertyWindow cIa;
    protected boolean cOC;
    protected String cVC;
    protected com.baidu.swan.apps.adaptation.b.a cXA;
    protected com.baidu.swan.games.t.a.a cXB;
    protected com.baidu.swan.apps.runtime.config.a cXC = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cXD;
    protected e cXE;
    protected boolean cXF;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.ara();
        this.cXE = new e();
        this.cXE.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayE() {
        if (ayQ() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ch(Context context) {
        ayE();
        this.cXE.cj(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void ci(Context context) {
        this.cXE.ck(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cOC = true;
        if (this.cXE != null) {
            this.cXE.aza();
            this.cXE = null;
        }
        g.azp().azr();
        com.baidu.swan.apps.process.a.b.b.a.aEp().release();
        ahP();
        com.baidu.swan.apps.u.a.b.axC().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.cXD = null;
    }

    private void ahP() {
        if (this.cHY != null) {
            ViewParent parent = this.cHY.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cHY);
            }
        }
        if (this.cXA != null) {
            this.cXA.ahP();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void ahF() {
        ayE();
        String aGO = com.baidu.swan.apps.runtime.e.aGO();
        if (!TextUtils.isEmpty(aGO)) {
            this.cXF = true;
            this.cXE.aza();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aGO);
            bundle.putInt("task_id", ayQ().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.aww().ahF();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void ahG() {
        String aGO = com.baidu.swan.apps.runtime.e.aGO();
        if (!TextUtils.isEmpty(aGO)) {
            ayF();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aGO);
            bundle.putInt("task_id", ap.aMC().aMB());
            com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.aww().ahG();
            com.baidu.swan.apps.t.a.awc().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ayF() {
        if (ayW()) {
            this.cXE.ayX();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cXD != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cXD != null) {
                        int taskId = b.this.cXD.getTaskId();
                        b.this.cXD.finish();
                        if (z) {
                            b.this.cXD.overridePendingTransition(0, a.C0367a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aLr().li(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ayG() {
        this.cXF = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void ayH() {
        this.cXF = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e anu() {
        return com.baidu.swan.apps.runtime.e.aGM();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion ayI() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        ayE();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        ayE();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a ayJ() {
        ayE();
        if (this.cXA == null) {
            this.cXA = com.baidu.swan.apps.core.turbo.d.ara().arb().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.eC(true);
        }
        if (this.cXD != null) {
            this.cXA.z((ViewGroup) this.cXD.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cXA;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView I(Activity activity) {
        ayE();
        if (activity == null) {
            return null;
        }
        if (this.cHY == null) {
            this.cHY = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cHY.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cHY.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cHY.setVisibility(8);
            this.cHY.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cXA;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cXA == null) {
                        this.cXA = f.azg().ayJ();
                    }
                    this.cXA.ahO();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void ayV() {
                }
            });
        }
        return this.cHY;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        ayE();
        if (activity == null) {
            return null;
        }
        if (this.cIa == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cIa = new SwanAppPropertyWindow(activity);
            this.cIa.setVisibility(8);
            viewGroup.addView(this.cIa);
        }
        return this.cIa;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean ayK() {
        ayE();
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        b.a aVar = null;
        if (aGM != null) {
            aVar = aGM.afg();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.ara().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cXD = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData ayL() {
        com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
        if (aGI.aEV()) {
            return aGI.aGE().aGV();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c pF(String str) {
        SwanAppConfigData ayL = ayL();
        if (ayL == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aHO();
        }
        return this.cXC.a(ayN(), str, ayL.drU);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c pG(String str) {
        SwanAppConfigData ayL = ayL();
        if (ayL == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aHO();
        }
        return this.cXC.b(ayN(), str, ayL.drU);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? pF(str) : this.cXC.a(str2, str, swanAppConfigData.drU);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c ayM() {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        return aGN == null ? new com.baidu.swan.apps.storage.b.b() : aGN.ayM();
    }

    @Override // com.baidu.swan.apps.v.d
    public String ayN() {
        return TextUtils.isEmpty(this.cVC) ? "" : this.cVC;
    }

    @Override // com.baidu.swan.apps.v.d
    public String ayO() {
        com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
        if (aGN == null || aGN.afg() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aGN.afg(), f.azg().ayL());
    }

    @Override // com.baidu.swan.apps.v.d
    public String ayP() {
        SwanAppConfigData ayL = ayL();
        return ayL == null ? "" : ayL.ayP();
    }

    public com.baidu.swan.apps.core.d.f afe() {
        if (this.cXD == null) {
            return null;
        }
        return this.cXD.afe();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity ayQ() {
        return com.baidu.swan.apps.runtime.d.aGI().aGG();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d aoS() {
        j jVar;
        com.baidu.swan.apps.core.d.f afe = afe();
        if (afe != null && (jVar = (j) afe.q(j.class)) != null) {
            return jVar.aoS();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d aoT() {
        j jVar;
        com.baidu.swan.apps.core.d.f afe = afe();
        if (afe != null && (jVar = (j) afe.q(j.class)) != null) {
            return jVar.aoT();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e nB(String str) {
        return com.baidu.swan.apps.core.turbo.d.ara().nB(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout pH(String str) {
        com.baidu.swan.apps.adaptation.b.d ahZ;
        com.baidu.swan.apps.adaptation.b.e nB = nB(str);
        if (nB == null || (ahZ = nB.ahZ()) == null) {
            return null;
        }
        return ahZ.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cRN = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cKx, gVar);
            com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ara().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ara().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e aou() {
        com.baidu.swan.apps.core.d.f afe = afe();
        if (afe == null) {
            return null;
        }
        return afe.aou();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aod() {
        com.baidu.swan.apps.core.d.e aou = aou();
        return aou != null ? aou.aod() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d ayR() {
        com.baidu.swan.apps.adaptation.b.e nB = nB(aod());
        if (nB == null) {
            return null;
        }
        return nB.ahZ();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> ayS() {
        Pair<Integer, Integer> aof = aof();
        int intValue = ((Integer) aof.first).intValue();
        int intValue2 = ((Integer) aof.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.cM(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> aof() {
        com.baidu.swan.apps.core.d.e aou = aou();
        return aou == null ? new Pair<>(0, 0) : aou.aof();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> ayT() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aGI().aGG() != null && (window = com.baidu.swan.apps.runtime.d.aGI().aGG().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.cJ(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void je(int i) {
        ayE();
        com.baidu.swan.apps.ap.b.aLr().l(this.cXD);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aGG = com.baidu.swan.apps.runtime.d.aGI().aGG();
        if (aGG != null && !aGG.isFinishing()) {
            aGG.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void afh() {
        SwanAppActivity aGG = com.baidu.swan.apps.runtime.d.aGI().aGG();
        if (aGG != null && !aGG.isFinishing()) {
            aGG.afh();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a ayU() {
        return null;
    }
}
