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
    protected FullScreenFloatView cSO;
    protected SwanAppPropertyWindow cSQ;
    protected String dgs;
    protected com.baidu.swan.apps.adaptation.b.a dit;
    protected com.baidu.swan.games.t.a.a diu;
    protected com.baidu.swan.apps.runtime.config.a div = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity diw;
    protected e dix;
    protected boolean diy;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.ash();
        this.dix = new e();
        this.dix.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azM() {
        if (azY() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cS(Context context) {
        azM();
        this.dix.cU(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cT(Context context) {
        this.dix.cV(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.dix != null) {
            this.dix.aAi();
            this.dix = null;
        }
        g.aAx().aAz();
        com.baidu.swan.apps.process.a.b.b.a.aFv().release();
        aiP();
        com.baidu.swan.apps.u.a.b.ayK().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.diw = null;
    }

    private void aiP() {
        if (this.cSO != null) {
            ViewParent parent = this.cSO.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cSO);
            }
        }
        if (this.dit != null) {
            this.dit.aiP();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aiF() {
        azM();
        String aIP = com.baidu.swan.apps.runtime.e.aIP();
        if (!TextUtils.isEmpty(aIP)) {
            this.diy = true;
            this.dix.aAi();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aIP);
            bundle.putInt("task_id", azY().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.axD().aiF();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aiG() {
        String aIP = com.baidu.swan.apps.runtime.e.aIP();
        if (!TextUtils.isEmpty(aIP)) {
            azN();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aIP);
            bundle.putInt("task_id", ap.aOD().aOC());
            com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.axD().aiG();
            com.baidu.swan.apps.t.a.axj().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azN() {
        if (aAe()) {
            this.dix.aAf();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.diw != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.diw != null) {
                        int taskId = b.this.diw.getTaskId();
                        b.this.diw.finish();
                        if (z) {
                            b.this.diw.overridePendingTransition(0, a.C0358a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ao.b.aNs().kj(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azO() {
        this.diy = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void azP() {
        this.diy = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aov() {
        return com.baidu.swan.apps.runtime.e.aIN();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion azQ() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azM();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azM();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azR() {
        azM();
        if (this.dit == null) {
            this.dit = com.baidu.swan.apps.core.turbo.d.ash().asi().cf(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.eY(true);
        }
        if (this.diw != null) {
            this.dit.A((ViewGroup) this.diw.findViewById(a.f.ai_apps_activity_root));
        }
        return this.dit;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView B(Activity activity) {
        azM();
        if (activity == null) {
            return null;
        }
        if (this.cSO == null) {
            this.cSO = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cSO.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cSO.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cSO.setVisibility(8);
            this.cSO.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a dit;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.dit == null) {
                        this.dit = f.aAo().azR();
                    }
                    this.dit.aiO();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aAd() {
                }
            });
        }
        return this.cSO;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow C(Activity activity) {
        ViewGroup viewGroup;
        azM();
        if (activity == null) {
            return null;
        }
        if (this.cSQ == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cSQ = new SwanAppPropertyWindow(activity);
            this.cSQ.setVisibility(8);
            viewGroup.addView(this.cSQ);
        }
        return this.cSQ;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azS() {
        azM();
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        b.a aVar = null;
        if (aIN != null) {
            aVar = aIN.agc();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.ash().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.diw = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData azT() {
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        if (aIJ.aGb()) {
            return aIJ.aIF().aIW();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c pt(String str) {
        SwanAppConfigData azT = azT();
        if (azT == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aJP();
        }
        return this.div.a(azV(), str, azT.dGt);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c pu(String str) {
        SwanAppConfigData azT = azT();
        if (azT == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aJP();
        }
        return this.div.b(azV(), str, azT.dGt);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? pt(str) : this.div.a(str2, str, swanAppConfigData.dGt);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c azU() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        return aIO == null ? new com.baidu.swan.apps.storage.b.b() : aIO.azU();
    }

    @Override // com.baidu.swan.apps.v.d
    public String azV() {
        return TextUtils.isEmpty(this.dgs) ? "" : this.dgs;
    }

    @Override // com.baidu.swan.apps.v.d
    public String azW() {
        com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
        if (aIO == null || aIO.agc() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aIO.agc(), f.aAo().azT());
    }

    @Override // com.baidu.swan.apps.v.d
    public String azX() {
        SwanAppConfigData azT = azT();
        return azT == null ? "" : azT.azX();
    }

    public com.baidu.swan.apps.core.d.f aga() {
        if (this.diw == null) {
            return null;
        }
        return this.diw.aga();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity azY() {
        return com.baidu.swan.apps.runtime.d.aIJ().aIH();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apZ() {
        j jVar;
        com.baidu.swan.apps.core.d.f aga = aga();
        if (aga != null && (jVar = (j) aga.j(j.class)) != null) {
            return jVar.apZ();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d aqa() {
        j jVar;
        com.baidu.swan.apps.core.d.f aga = aga();
        if (aga != null && (jVar = (j) aga.j(j.class)) != null) {
            return jVar.aqa();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e np(String str) {
        return com.baidu.swan.apps.core.turbo.d.ash().np(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout pv(String str) {
        com.baidu.swan.apps.adaptation.b.d aiZ;
        com.baidu.swan.apps.adaptation.b.e np = np(str);
        if (np == null || (aiZ = np.aiZ()) == null) {
            return null;
        }
        return aiZ.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.B("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.dcA = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cVo, gVar);
            com.baidu.swan.apps.performance.h.B("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ash().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ash().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e apB() {
        com.baidu.swan.apps.core.d.f aga = aga();
        if (aga == null) {
            return null;
        }
        return aga.apB();
    }

    @Override // com.baidu.swan.apps.v.d
    public String apk() {
        com.baidu.swan.apps.core.d.e apB = apB();
        return apB != null ? apB.apk() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d azZ() {
        com.baidu.swan.apps.adaptation.b.e np = np(apk());
        if (np == null) {
            return null;
        }
        return np.aiZ();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aAa() {
        Pair<Integer, Integer> apm = apm();
        int intValue = ((Integer) apm.first).intValue();
        int intValue2 = ((Integer) apm.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.dI(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> apm() {
        com.baidu.swan.apps.core.d.e apB = apB();
        return apB == null ? new Pair<>(0, 0) : apB.apm();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aAb() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aIJ().aIH() != null && (window = com.baidu.swan.apps.runtime.d.aIJ().aIH().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.dF(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void hV(int i) {
        azM();
        com.baidu.swan.apps.ao.b.aNs().l(this.diw);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aIH = com.baidu.swan.apps.runtime.d.aIJ().aIH();
        if (aIH != null && !aIH.isFinishing()) {
            aIH.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void agd() {
        SwanAppActivity aIH = com.baidu.swan.apps.runtime.d.aIJ().aIH();
        if (aIH != null && !aIH.isFinishing()) {
            aIH.agd();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a aAc() {
        return null;
    }
}
