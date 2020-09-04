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
/* loaded from: classes8.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cgY;
    protected SwanAppPropertyWindow cha;
    protected boolean cnG;
    protected String cuR;
    protected com.baidu.swan.apps.adaptation.b.a cwP;
    protected com.baidu.swan.games.t.a.a cwQ;
    protected com.baidu.swan.apps.runtime.config.a cwR = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cwS;
    protected e cwT;
    protected boolean cwU;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.ajS();
        this.cwT = new e();
        this.cwT.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void arw() {
        if (arI() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cc(Context context) {
        arw();
        this.cwT.ce(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cd(Context context) {
        this.cwT.cf(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cnG = true;
        if (this.cwT != null) {
            this.cwT.arS();
            this.cwT = null;
        }
        g.ash().asj();
        com.baidu.swan.apps.process.a.b.b.a.axj().release();
        aaI();
        com.baidu.swan.apps.u.a.b.aqu().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.cwS = null;
    }

    private void aaI() {
        if (this.cgY != null) {
            ViewParent parent = this.cgY.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cgY);
            }
        }
        if (this.cwP != null) {
            this.cwP.aaI();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aay() {
        arw();
        String azK = com.baidu.swan.apps.runtime.e.azK();
        if (!TextUtils.isEmpty(azK)) {
            this.cwU = true;
            this.cwT.arS();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", azK);
            bundle.putInt("task_id", arI().getTaskId());
            com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.apo().aay();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aaz() {
        String azK = com.baidu.swan.apps.runtime.e.azK();
        if (!TextUtils.isEmpty(azK)) {
            arx();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", azK);
            bundle.putInt("task_id", ap.aFx().aFw());
            com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.apo().aaz();
            com.baidu.swan.apps.t.a.aoT().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void arx() {
        if (arO()) {
            this.cwT.arP();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cwS != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cwS != null) {
                        int taskId = b.this.cwS.getTaskId();
                        b.this.cwS.finish();
                        if (z) {
                            b.this.cwS.overridePendingTransition(0, a.C0331a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aEm().kj(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ary() {
        this.cwU = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void arz() {
        this.cwU = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e agn() {
        return com.baidu.swan.apps.runtime.e.azI();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion arA() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        arw();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        arw();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a arB() {
        arw();
        if (this.cwP == null) {
            this.cwP = com.baidu.swan.apps.core.turbo.d.ajS().ajT().bq(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.dJ(true);
        }
        if (this.cwS != null) {
            this.cwP.v((ViewGroup) this.cwS.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cwP;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        arw();
        if (activity == null) {
            return null;
        }
        if (this.cgY == null) {
            this.cgY = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cgY.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cgY.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cgY.setVisibility(8);
            this.cgY.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cwP;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cwP == null) {
                        this.cwP = f.arY().arB();
                    }
                    this.cwP.aaH();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void arN() {
                }
            });
        }
        return this.cgY;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        arw();
        if (activity == null) {
            return null;
        }
        if (this.cha == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cha = new SwanAppPropertyWindow(activity);
            this.cha.setVisibility(8);
            viewGroup.addView(this.cha);
        }
        return this.cha;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean arC() {
        arw();
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        b.a aVar = null;
        if (azI != null) {
            aVar = azI.XZ();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.ajS().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cwS = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData arD() {
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        if (azE.axR()) {
            return azE.azA().azR();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c nX(String str) {
        SwanAppConfigData arD = arD();
        if (arD == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aAK();
        }
        return this.cwR.a(arF(), str, arD.cQY);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c nY(String str) {
        SwanAppConfigData arD = arD();
        if (arD == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aAK();
        }
        return this.cwR.b(arF(), str, arD.cQY);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? nX(str) : this.cwR.a(str2, str, swanAppConfigData.cQY);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c arE() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        return azJ == null ? new com.baidu.swan.apps.storage.b.b() : azJ.arE();
    }

    @Override // com.baidu.swan.apps.v.d
    public String arF() {
        return TextUtils.isEmpty(this.cuR) ? "" : this.cuR;
    }

    @Override // com.baidu.swan.apps.v.d
    public String arG() {
        com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
        if (azJ == null || azJ.XZ() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(azJ.XZ(), f.arY().arD());
    }

    @Override // com.baidu.swan.apps.v.d
    public String arH() {
        SwanAppConfigData arD = arD();
        return arD == null ? "" : arD.arH();
    }

    public com.baidu.swan.apps.core.d.f XX() {
        if (this.cwS == null) {
            return null;
        }
        return this.cwS.XX();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity arI() {
        return com.baidu.swan.apps.runtime.d.azE().azC();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d ahL() {
        j jVar;
        com.baidu.swan.apps.core.d.f XX = XX();
        if (XX != null && (jVar = (j) XX.q(j.class)) != null) {
            return jVar.ahL();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d ahM() {
        j jVar;
        com.baidu.swan.apps.core.d.f XX = XX();
        if (XX != null && (jVar = (j) XX.q(j.class)) != null) {
            return jVar.ahM();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e lU(String str) {
        return com.baidu.swan.apps.core.turbo.d.ajS().lU(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout nZ(String str) {
        com.baidu.swan.apps.adaptation.b.d aaS;
        com.baidu.swan.apps.adaptation.b.e lU = lU(str);
        if (lU == null || (aaS = lU.aaS()) == null) {
            return null;
        }
        return aaS.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cqU = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cjz, gVar);
            com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ajS().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ajS().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e ahn() {
        com.baidu.swan.apps.core.d.f XX = XX();
        if (XX == null) {
            return null;
        }
        return XX.ahn();
    }

    @Override // com.baidu.swan.apps.v.d
    public String agW() {
        com.baidu.swan.apps.core.d.e ahn = ahn();
        return ahn != null ? ahn.agW() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d arJ() {
        com.baidu.swan.apps.adaptation.b.e lU = lU(agW());
        if (lU == null) {
            return null;
        }
        return lU.aaS();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> arK() {
        Pair<Integer, Integer> agY = agY();
        int intValue = ((Integer) agY.first).intValue();
        int intValue2 = ((Integer) agY.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.cH(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> agY() {
        com.baidu.swan.apps.core.d.e ahn = ahn();
        return ahn == null ? new Pair<>(0, 0) : ahn.agY();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> arL() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.azE().azC() != null && (window = com.baidu.swan.apps.runtime.d.azE().azC().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.cE(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void ig(int i) {
        arw();
        com.baidu.swan.apps.ap.b.aEm().l(this.cwS);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity azC = com.baidu.swan.apps.runtime.d.azE().azC();
        if (azC != null && !azC.isFinishing()) {
            azC.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void Ya() {
        SwanAppActivity azC = com.baidu.swan.apps.runtime.d.azE().azC();
        if (azC != null && !azC.isFinishing()) {
            azC.Ya();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a arM() {
        return null;
    }
}
