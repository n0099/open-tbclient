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
        com.baidu.swan.apps.core.turbo.d.avB();
        this.djx = new e();
        this.djx.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aDf() {
        if (aDr() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cV(Context context) {
        aDf();
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
            this.djx.aDB();
            this.djx = null;
        }
        g.aDQ().aDS();
        com.baidu.swan.apps.process.a.b.b.a.aIR().release();
        ami();
        com.baidu.swan.apps.u.a.b.aCd().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.djw = null;
    }

    private void ami() {
        if (this.cTM != null) {
            ViewParent parent = this.cTM.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cTM);
            }
        }
        if (this.djt != null) {
            this.djt.ami();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void alY() {
        aDf();
        String aMn = com.baidu.swan.apps.runtime.e.aMn();
        if (!TextUtils.isEmpty(aMn)) {
            this.djy = true;
            this.djx.aDB();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aMn);
            bundle.putInt("task_id", aDr().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.aAW().alY();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void alZ() {
        String aMn = com.baidu.swan.apps.runtime.e.aMn();
        if (!TextUtils.isEmpty(aMn)) {
            aDg();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aMn);
            bundle.putInt("task_id", ap.aSb().aSa());
            com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.aAW().alZ();
            com.baidu.swan.apps.t.a.aAC().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aDg() {
        if (aDx()) {
            this.djx.aDy();
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
                        com.baidu.swan.apps.ao.b.aQQ().lL(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void aDh() {
        this.djy = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void aDi() {
        this.djy = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e arP() {
        return com.baidu.swan.apps.runtime.e.aMl();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion aDj() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aDf();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aDf();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aDk() {
        aDf();
        if (this.djt == null) {
            this.djt = com.baidu.swan.apps.core.turbo.d.avB().avC().ci(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.fa(true);
        }
        if (this.djw != null) {
            this.djt.C((ViewGroup) this.djw.findViewById(a.f.ai_apps_activity_root));
        }
        return this.djt;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView H(Activity activity) {
        aDf();
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
                        this.djt = f.aDH().aDk();
                    }
                    this.djt.amh();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aDw() {
                }
            });
        }
        return this.cTM;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow I(Activity activity) {
        ViewGroup viewGroup;
        aDf();
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
    public boolean aDl() {
        aDf();
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        b.a aVar = null;
        if (aMl != null) {
            aVar = aMl.ajv();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.avB().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.djw = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData aDm() {
        com.baidu.swan.apps.runtime.d aMh = com.baidu.swan.apps.runtime.d.aMh();
        if (aMh.aJx()) {
            return aMh.aMd().aMu();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c qf(String str) {
        SwanAppConfigData aDm = aDm();
        if (aDm == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aNn();
        }
        return this.djv.a(aDo(), str, aDm.dHA);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c qg(String str) {
        SwanAppConfigData aDm = aDm();
        if (aDm == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aNn();
        }
        return this.djv.b(aDo(), str, aDm.dHA);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? qf(str) : this.djv.a(str2, str, swanAppConfigData.dHA);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c aDn() {
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        return aMm == null ? new com.baidu.swan.apps.storage.b.b() : aMm.aDn();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aDo() {
        return TextUtils.isEmpty(this.dhs) ? "" : this.dhs;
    }

    @Override // com.baidu.swan.apps.v.d
    public String aDp() {
        com.baidu.swan.apps.runtime.e aMm = com.baidu.swan.apps.runtime.e.aMm();
        if (aMm == null || aMm.ajv() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aMm.ajv(), f.aDH().aDm());
    }

    @Override // com.baidu.swan.apps.v.d
    public String aDq() {
        SwanAppConfigData aDm = aDm();
        return aDm == null ? "" : aDm.aDq();
    }

    public com.baidu.swan.apps.core.d.f ajt() {
        if (this.djw == null) {
            return null;
        }
        return this.djw.ajt();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity aDr() {
        return com.baidu.swan.apps.runtime.d.aMh().aMf();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d att() {
        j jVar;
        com.baidu.swan.apps.core.d.f ajt = ajt();
        if (ajt != null && (jVar = (j) ajt.j(j.class)) != null) {
            return jVar.att();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d atu() {
        j jVar;
        com.baidu.swan.apps.core.d.f ajt = ajt();
        if (ajt != null && (jVar = (j) ajt.j(j.class)) != null) {
            return jVar.atu();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e ob(String str) {
        return com.baidu.swan.apps.core.turbo.d.avB().ob(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout qh(String str) {
        com.baidu.swan.apps.adaptation.b.d ams;
        com.baidu.swan.apps.adaptation.b.e ob = ob(str);
        if (ob == null || (ams = ob.ams()) == null) {
            return null;
        }
        return ams.getCurrentWebView();
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
        com.baidu.swan.apps.core.turbo.d.avB().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.avB().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e asV() {
        com.baidu.swan.apps.core.d.f ajt = ajt();
        if (ajt == null) {
            return null;
        }
        return ajt.asV();
    }

    @Override // com.baidu.swan.apps.v.d
    public String asE() {
        com.baidu.swan.apps.core.d.e asV = asV();
        return asV != null ? asV.asE() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d aDs() {
        com.baidu.swan.apps.adaptation.b.e ob = ob(asE());
        if (ob == null) {
            return null;
        }
        return ob.ams();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aDt() {
        Pair<Integer, Integer> asG = asG();
        int intValue = ((Integer) asG.first).intValue();
        int intValue2 = ((Integer) asG.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.dL(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> asG() {
        com.baidu.swan.apps.core.d.e asV = asV();
        return asV == null ? new Pair<>(0, 0) : asV.asG();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> aDu() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aMh().aMf() != null && (window = com.baidu.swan.apps.runtime.d.aMh().aMf().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.dI(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void jx(int i) {
        aDf();
        com.baidu.swan.apps.ao.b.aQQ().l(this.djw);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aMf = com.baidu.swan.apps.runtime.d.aMh().aMf();
        if (aMf != null && !aMf.isFinishing()) {
            aMf.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ajw() {
        SwanAppActivity aMf = com.baidu.swan.apps.runtime.d.aMh().aMf();
        if (aMf != null && !aMf.isFinishing()) {
            aMf.ajw();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a aDv() {
        return null;
    }
}
