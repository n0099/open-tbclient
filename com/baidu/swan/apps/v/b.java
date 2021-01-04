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
    protected FullScreenFloatView cTM;
    protected SwanAppPropertyWindow cTO;
    protected String dhs;
    protected com.baidu.swan.apps.adaptation.b.a djt;
    protected com.baidu.swan.games.t.a.a dju;
    protected com.baidu.swan.apps.runtime.config.a djv = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity djw;
    protected e djx;
    protected boolean djy;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.avA();
        this.djx = new e();
        this.djx.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDe() {
        if (aDq() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cV(Context context) {
        aDe();
        this.djx.cX(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cW(Context context) {
        this.djx.cY(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.djx != null) {
            this.djx.aDA();
            this.djx = null;
        }
        g.aDP().aDR();
        com.baidu.swan.apps.process.a.b.b.a.aIQ().release();
        amh();
        com.baidu.swan.apps.u.a.b.aCc().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.djw = null;
    }

    private void amh() {
        if (this.cTM != null) {
            ViewParent parent = this.cTM.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cTM);
            }
        }
        if (this.djt != null) {
            this.djt.amh();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void alX() {
        aDe();
        String aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (!TextUtils.isEmpty(aMm)) {
            this.djy = true;
            this.djx.aDA();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aMm);
            bundle.putInt("task_id", aDq().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.aAV().alX();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void alY() {
        String aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (!TextUtils.isEmpty(aMm)) {
            aDf();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aMm);
            bundle.putInt("task_id", ap.aSa().aRZ());
            com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.aAV().alY();
            com.baidu.swan.apps.t.a.aAB().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aDf() {
        if (aDw()) {
            this.djx.aDx();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.djw != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.djw != null) {
                        int taskId = b.this.djw.getTaskId();
                        b.this.djw.finish();
                        if (z) {
                            b.this.djw.overridePendingTransition(0, a.C0372a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ao.b.aQP().lL(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aDg() {
        this.djy = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void aDh() {
        this.djy = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e arO() {
        return com.baidu.swan.apps.runtime.e.aMk();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion aDi() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aDe();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aDe();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aDj() {
        aDe();
        if (this.djt == null) {
            this.djt = com.baidu.swan.apps.core.turbo.d.avA().avB().ci(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.fa(true);
        }
        if (this.djw != null) {
            this.djt.C((ViewGroup) this.djw.findViewById(a.f.ai_apps_activity_root));
        }
        return this.djt;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        aDe();
        if (activity == null) {
            return null;
        }
        if (this.cTM == null) {
            this.cTM = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cTM.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cTM.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cTM.setVisibility(8);
            this.cTM.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a djt;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.djt == null) {
                        this.djt = f.aDG().aDj();
                    }
                    this.djt.amg();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aDv() {
                }
            });
        }
        return this.cTM;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        aDe();
        if (activity == null) {
            return null;
        }
        if (this.cTO == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cTO = new SwanAppPropertyWindow(activity);
            this.cTO.setVisibility(8);
            viewGroup.addView(this.cTO);
        }
        return this.cTO;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean aDk() {
        aDe();
        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
        b.a aVar = null;
        if (aMk != null) {
            aVar = aMk.aju();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.avA().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.djw = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData aDl() {
        com.baidu.swan.apps.runtime.d aMg = com.baidu.swan.apps.runtime.d.aMg();
        if (aMg.aJw()) {
            return aMg.aMc().aMt();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c qf(String str) {
        SwanAppConfigData aDl = aDl();
        if (aDl == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aNm();
        }
        return this.djv.a(aDn(), str, aDl.dHA);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c qg(String str) {
        SwanAppConfigData aDl = aDl();
        if (aDl == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aNm();
        }
        return this.djv.b(aDn(), str, aDl.dHA);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? qf(str) : this.djv.a(str2, str, swanAppConfigData.dHA);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c aDm() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        return aMl == null ? new com.baidu.swan.apps.storage.b.b() : aMl.aDm();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aDn() {
        return TextUtils.isEmpty(this.dhs) ? "" : this.dhs;
    }

    @Override // com.baidu.swan.apps.v.d
    public String aDo() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        if (aMl == null || aMl.aju() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aMl.aju(), f.aDG().aDl());
    }

    @Override // com.baidu.swan.apps.v.d
    public String aDp() {
        SwanAppConfigData aDl = aDl();
        return aDl == null ? "" : aDl.aDp();
    }

    public com.baidu.swan.apps.core.d.f ajs() {
        if (this.djw == null) {
            return null;
        }
        return this.djw.ajs();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity aDq() {
        return com.baidu.swan.apps.runtime.d.aMg().aMe();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d ats() {
        j jVar;
        com.baidu.swan.apps.core.d.f ajs = ajs();
        if (ajs != null && (jVar = (j) ajs.j(j.class)) != null) {
            return jVar.ats();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d att() {
        j jVar;
        com.baidu.swan.apps.core.d.f ajs = ajs();
        if (ajs != null && (jVar = (j) ajs.j(j.class)) != null) {
            return jVar.att();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e ob(String str) {
        return com.baidu.swan.apps.core.turbo.d.avA().ob(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout qh(String str) {
        com.baidu.swan.apps.adaptation.b.d amr;
        com.baidu.swan.apps.adaptation.b.e ob = ob(str);
        if (ob == null || (amr = ob.amr()) == null) {
            return null;
        }
        return amr.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.ddC = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cWn, gVar);
            com.baidu.swan.apps.performance.h.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.avA().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.avA().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e asU() {
        com.baidu.swan.apps.core.d.f ajs = ajs();
        if (ajs == null) {
            return null;
        }
        return ajs.asU();
    }

    @Override // com.baidu.swan.apps.v.d
    public String asD() {
        com.baidu.swan.apps.core.d.e asU = asU();
        return asU != null ? asU.asD() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d aDr() {
        com.baidu.swan.apps.adaptation.b.e ob = ob(asD());
        if (ob == null) {
            return null;
        }
        return ob.amr();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aDs() {
        Pair<Integer, Integer> asF = asF();
        int intValue = ((Integer) asF.first).intValue();
        int intValue2 = ((Integer) asF.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.dL(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> asF() {
        com.baidu.swan.apps.core.d.e asU = asU();
        return asU == null ? new Pair<>(0, 0) : asU.asF();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aDt() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aMg().aMe() != null && (window = com.baidu.swan.apps.runtime.d.aMg().aMe().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.dI(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void jx(int i) {
        aDe();
        com.baidu.swan.apps.ao.b.aQP().l(this.djw);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aMe = com.baidu.swan.apps.runtime.d.aMg().aMe();
        if (aMe != null && !aMe.isFinishing()) {
            aMe.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ajv() {
        SwanAppActivity aMe = com.baidu.swan.apps.runtime.d.aMg().aMe();
        if (aMe != null && !aMe.isFinishing()) {
            aMe.ajv();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a aDu() {
        return null;
    }
}
