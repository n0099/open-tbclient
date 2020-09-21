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
/* loaded from: classes3.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cja;
    protected SwanAppPropertyWindow cjc;
    protected boolean cpJ;
    protected String cwS;
    protected com.baidu.swan.apps.adaptation.b.a cyQ;
    protected com.baidu.swan.games.t.a.a cyR;
    protected com.baidu.swan.apps.runtime.config.a cyS = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cyT;
    protected e cyU;
    protected boolean cyV;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.akC();
        this.cyU = new e();
        this.cyU.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asg() {
        if (ast() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void cb(Context context) {
        asg();
        this.cyU.cd(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void cc(Context context) {
        this.cyU.ce(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cpJ = true;
        if (this.cyU != null) {
            this.cyU.asD();
            this.cyU = null;
        }
        g.asS().asU();
        com.baidu.swan.apps.process.a.b.b.a.axS().release();
        abr();
        com.baidu.swan.apps.u.a.b.are().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.cyT = null;
    }

    private void abr() {
        if (this.cja != null) {
            ViewParent parent = this.cja.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cja);
            }
        }
        if (this.cyQ != null) {
            this.cyQ.abr();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void abh() {
        asg();
        String aAt = com.baidu.swan.apps.runtime.e.aAt();
        if (!TextUtils.isEmpty(aAt)) {
            this.cyV = true;
            this.cyU.asD();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aAt);
            bundle.putInt("task_id", ast().getTaskId());
            com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.apY().abh();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void abi() {
        String aAt = com.baidu.swan.apps.runtime.e.aAt();
        if (!TextUtils.isEmpty(aAt)) {
            ash();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aAt);
            bundle.putInt("task_id", ap.aGh().aGg());
            com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.apY().abi();
            com.baidu.swan.apps.t.a.apE().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ash() {
        if (asz()) {
            this.cyU.asA();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cyT != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cyT != null) {
                        int taskId = b.this.cyT.getTaskId();
                        b.this.cyT.finish();
                        if (z) {
                            b.this.cyT.overridePendingTransition(0, a.C0326a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aEW().ku(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void asi() {
        this.cyV = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void asj() {
        this.cyV = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e agX() {
        return com.baidu.swan.apps.runtime.e.aAr();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion ask() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        asg();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        asg();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a asl() {
        asg();
        if (this.cyQ == null) {
            this.cyQ = com.baidu.swan.apps.core.turbo.d.akC().akD().bp(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.dH(true);
        }
        if (this.cyT != null) {
            this.cyQ.y((ViewGroup) this.cyT.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cyQ;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView I(Activity activity) {
        asg();
        if (activity == null) {
            return null;
        }
        if (this.cja == null) {
            this.cja = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cja.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cja.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cja.setVisibility(8);
            this.cja.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cyQ;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cyQ == null) {
                        this.cyQ = f.asJ().asl();
                    }
                    this.cyQ.abq();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void asy() {
                }
            });
        }
        return this.cja;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        asg();
        if (activity == null) {
            return null;
        }
        if (this.cjc == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cjc = new SwanAppPropertyWindow(activity);
            this.cjc.setVisibility(8);
            viewGroup.addView(this.cjc);
        }
        return this.cjc;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean asn() {
        asg();
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        b.a aVar = null;
        if (aAr != null) {
            aVar = aAr.YI();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.akC().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cyT = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData aso() {
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        if (aAn.ayA()) {
            return aAn.aAj().aAA();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c os(String str) {
        SwanAppConfigData aso = aso();
        if (aso == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aBt();
        }
        return this.cyS.a(asq(), str, aso.cSY);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c ot(String str) {
        SwanAppConfigData aso = aso();
        if (aso == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aBt();
        }
        return this.cyS.b(asq(), str, aso.cSY);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? os(str) : this.cyS.a(str2, str, swanAppConfigData.cSY);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c asp() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        return aAs == null ? new com.baidu.swan.apps.storage.b.b() : aAs.asp();
    }

    @Override // com.baidu.swan.apps.v.d
    public String asq() {
        return TextUtils.isEmpty(this.cwS) ? "" : this.cwS;
    }

    @Override // com.baidu.swan.apps.v.d
    public String asr() {
        com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
        if (aAs == null || aAs.YI() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aAs.YI(), f.asJ().aso());
    }

    @Override // com.baidu.swan.apps.v.d
    public String ass() {
        SwanAppConfigData aso = aso();
        return aso == null ? "" : aso.ass();
    }

    public com.baidu.swan.apps.core.d.f YG() {
        if (this.cyT == null) {
            return null;
        }
        return this.cyT.YG();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity ast() {
        return com.baidu.swan.apps.runtime.d.aAn().aAl();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d aiv() {
        j jVar;
        com.baidu.swan.apps.core.d.f YG = YG();
        if (YG != null && (jVar = (j) YG.q(j.class)) != null) {
            return jVar.aiv();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d aiw() {
        j jVar;
        com.baidu.swan.apps.core.d.f YG = YG();
        if (YG != null && (jVar = (j) YG.q(j.class)) != null) {
            return jVar.aiw();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e mn(String str) {
        return com.baidu.swan.apps.core.turbo.d.akC().mn(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout ou(String str) {
        com.baidu.swan.apps.adaptation.b.d abB;
        com.baidu.swan.apps.adaptation.b.e mn = mn(str);
        if (mn == null || (abB = mn.abB()) == null) {
            return null;
        }
        return abB.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.csX = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.clA, gVar);
            com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.akC().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.akC().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e ahX() {
        com.baidu.swan.apps.core.d.f YG = YG();
        if (YG == null) {
            return null;
        }
        return YG.ahX();
    }

    @Override // com.baidu.swan.apps.v.d
    public String ahG() {
        com.baidu.swan.apps.core.d.e ahX = ahX();
        return ahX != null ? ahX.ahG() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d asu() {
        com.baidu.swan.apps.adaptation.b.e mn = mn(ahG());
        if (mn == null) {
            return null;
        }
        return mn.abB();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> asv() {
        Pair<Integer, Integer> ahI = ahI();
        int intValue = ((Integer) ahI.first).intValue();
        int intValue2 = ((Integer) ahI.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.cG(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> ahI() {
        com.baidu.swan.apps.core.d.e ahX = ahX();
        return ahX == null ? new Pair<>(0, 0) : ahX.ahI();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> asw() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aAn().aAl() != null && (window = com.baidu.swan.apps.runtime.d.aAn().aAl().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.cD(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void iq(int i) {
        asg();
        com.baidu.swan.apps.ap.b.aEW().l(this.cyT);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aAl = com.baidu.swan.apps.runtime.d.aAn().aAl();
        if (aAl != null && !aAl.isFinishing()) {
            aAl.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void YJ() {
        SwanAppActivity aAl = com.baidu.swan.apps.runtime.d.aAn().aAl();
        if (aAl != null && !aAl.isFinishing()) {
            aAl.YJ();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a asx() {
        return null;
    }
}
