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
/* loaded from: classes9.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cRo;
    protected SwanAppPropertyWindow cRq;
    protected String deR;
    protected com.baidu.swan.apps.adaptation.b.a dgP;
    protected com.baidu.swan.games.t.a.a dgQ;
    protected com.baidu.swan.apps.runtime.config.a dgR = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity dgS;
    protected e dgT;
    protected boolean dgU;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.ase();
        this.dgT = new e();
        this.dgT.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azJ() {
        if (azV() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cT(Context context) {
        azJ();
        this.dgT.cV(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cU(Context context) {
        this.dgT.cW(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.dgT != null) {
            this.dgT.aAf();
            this.dgT = null;
        }
        g.aAu().aAw();
        com.baidu.swan.apps.process.a.b.b.a.aFs().release();
        aiM();
        com.baidu.swan.apps.u.a.b.ayH().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.dgS = null;
    }

    private void aiM() {
        if (this.cRo != null) {
            ViewParent parent = this.cRo.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cRo);
            }
        }
        if (this.dgP != null) {
            this.dgP.aiM();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aiC() {
        azJ();
        String aIM = com.baidu.swan.apps.runtime.e.aIM();
        if (!TextUtils.isEmpty(aIM)) {
            this.dgU = true;
            this.dgT.aAf();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aIM);
            bundle.putInt("task_id", azV().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.axA().aiC();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aiD() {
        String aIM = com.baidu.swan.apps.runtime.e.aIM();
        if (!TextUtils.isEmpty(aIM)) {
            azK();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aIM);
            bundle.putInt("task_id", ap.aOA().aOz());
            com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.axA().aiD();
            com.baidu.swan.apps.t.a.axg().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azK() {
        if (aAb()) {
            this.dgT.aAc();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.dgS != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.dgS != null) {
                        int taskId = b.this.dgS.getTaskId();
                        b.this.dgS.finish();
                        if (z) {
                            b.this.dgS.overridePendingTransition(0, a.C0352a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ao.b.aNp().ki(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azL() {
        this.dgU = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void azM() {
        this.dgU = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aos() {
        return com.baidu.swan.apps.runtime.e.aIK();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion azN() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azJ();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azJ();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azO() {
        azJ();
        if (this.dgP == null) {
            this.dgP = com.baidu.swan.apps.core.turbo.d.ase().asf().cg(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.eY(true);
        }
        if (this.dgS != null) {
            this.dgP.A((ViewGroup) this.dgS.findViewById(a.f.ai_apps_activity_root));
        }
        return this.dgP;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView B(Activity activity) {
        azJ();
        if (activity == null) {
            return null;
        }
        if (this.cRo == null) {
            this.cRo = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cRo.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cRo.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cRo.setVisibility(8);
            this.cRo.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a dgP;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.dgP == null) {
                        this.dgP = f.aAl().azO();
                    }
                    this.dgP.aiL();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aAa() {
                }
            });
        }
        return this.cRo;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow C(Activity activity) {
        ViewGroup viewGroup;
        azJ();
        if (activity == null) {
            return null;
        }
        if (this.cRq == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cRq = new SwanAppPropertyWindow(activity);
            this.cRq.setVisibility(8);
            viewGroup.addView(this.cRq);
        }
        return this.cRq;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azP() {
        azJ();
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        b.a aVar = null;
        if (aIK != null) {
            aVar = aIK.afZ();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.ase().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.dgS = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData azQ() {
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        if (aIG.aFY()) {
            return aIG.aIC().aIT();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c pm(String str) {
        SwanAppConfigData azQ = azQ();
        if (azQ == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aJM();
        }
        return this.dgR.a(azS(), str, azQ.dES);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c pn(String str) {
        SwanAppConfigData azQ = azQ();
        if (azQ == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aJM();
        }
        return this.dgR.b(azS(), str, azQ.dES);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? pm(str) : this.dgR.a(str2, str, swanAppConfigData.dES);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c azR() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        return aIL == null ? new com.baidu.swan.apps.storage.b.b() : aIL.azR();
    }

    @Override // com.baidu.swan.apps.v.d
    public String azS() {
        return TextUtils.isEmpty(this.deR) ? "" : this.deR;
    }

    @Override // com.baidu.swan.apps.v.d
    public String azT() {
        com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
        if (aIL == null || aIL.afZ() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aIL.afZ(), f.aAl().azQ());
    }

    @Override // com.baidu.swan.apps.v.d
    public String azU() {
        SwanAppConfigData azQ = azQ();
        return azQ == null ? "" : azQ.azU();
    }

    public com.baidu.swan.apps.core.d.f afX() {
        if (this.dgS == null) {
            return null;
        }
        return this.dgS.afX();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity azV() {
        return com.baidu.swan.apps.runtime.d.aIG().aIE();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apW() {
        j jVar;
        com.baidu.swan.apps.core.d.f afX = afX();
        if (afX != null && (jVar = (j) afX.j(j.class)) != null) {
            return jVar.apW();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apX() {
        j jVar;
        com.baidu.swan.apps.core.d.f afX = afX();
        if (afX != null && (jVar = (j) afX.j(j.class)) != null) {
            return jVar.apX();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e ni(String str) {
        return com.baidu.swan.apps.core.turbo.d.ase().ni(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout po(String str) {
        com.baidu.swan.apps.adaptation.b.d aiW;
        com.baidu.swan.apps.adaptation.b.e ni = ni(str);
        if (ni == null || (aiW = ni.aiW()) == null) {
            return null;
        }
        return aiW.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.B("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.daY = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cTO, gVar);
            com.baidu.swan.apps.performance.h.B("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ase().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ase().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e apy() {
        com.baidu.swan.apps.core.d.f afX = afX();
        if (afX == null) {
            return null;
        }
        return afX.apy();
    }

    @Override // com.baidu.swan.apps.v.d
    public String apg() {
        com.baidu.swan.apps.core.d.e apy = apy();
        return apy != null ? apy.apg() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d azW() {
        com.baidu.swan.apps.adaptation.b.e ni = ni(apg());
        if (ni == null) {
            return null;
        }
        return ni.aiW();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azX() {
        Pair<Integer, Integer> apj = apj();
        int intValue = ((Integer) apj.first).intValue();
        int intValue2 = ((Integer) apj.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.dJ(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> apj() {
        com.baidu.swan.apps.core.d.e apy = apy();
        return apy == null ? new Pair<>(0, 0) : apy.apj();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azY() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aIG().aIE() != null && (window = com.baidu.swan.apps.runtime.d.aIG().aIE().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.dG(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void hU(int i) {
        azJ();
        com.baidu.swan.apps.ao.b.aNp().l(this.dgS);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aIE = com.baidu.swan.apps.runtime.d.aIG().aIE();
        if (aIE != null && !aIE.isFinishing()) {
            aIE.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aga() {
        SwanAppActivity aIE = com.baidu.swan.apps.runtime.d.aIG().aIE();
        if (aIE != null && !aIE.isFinishing()) {
            aIE.aga();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a azZ() {
        return null;
    }
}
