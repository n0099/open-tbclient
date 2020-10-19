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
    protected boolean cBX;
    protected String cIX;
    protected com.baidu.swan.apps.adaptation.b.a cKV;
    protected com.baidu.swan.games.t.a.a cKW;
    protected com.baidu.swan.apps.runtime.config.a cKX = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cKY;
    protected e cKZ;
    protected boolean cLa;
    protected FullScreenFloatView cvt;
    protected SwanAppPropertyWindow cvv;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.ann();
        this.cKZ = new e();
        this.cKZ.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auS() {
        if (ave() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ch(Context context) {
        auS();
        this.cKZ.cj(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void ci(Context context) {
        this.cKZ.ck(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cBX = true;
        if (this.cKZ != null) {
            this.cKZ.avo();
            this.cKZ = null;
        }
        g.avD().avF();
        com.baidu.swan.apps.process.a.b.b.a.aAD().release();
        aed();
        com.baidu.swan.apps.u.a.b.atQ().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.cKY = null;
    }

    private void aed() {
        if (this.cvt != null) {
            ViewParent parent = this.cvt.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cvt);
            }
        }
        if (this.cKV != null) {
            this.cKV.aed();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void adT() {
        auS();
        String aDc = com.baidu.swan.apps.runtime.e.aDc();
        if (!TextUtils.isEmpty(aDc)) {
            this.cLa = true;
            this.cKZ.avo();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aDc);
            bundle.putInt("task_id", ave().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.asK().adT();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void adU() {
        String aDc = com.baidu.swan.apps.runtime.e.aDc();
        if (!TextUtils.isEmpty(aDc)) {
            auT();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aDc);
            bundle.putInt("task_id", ap.aIQ().aIP());
            com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.asK().adU();
            com.baidu.swan.apps.t.a.asq().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void auT() {
        if (avk()) {
            this.cKZ.avl();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cKY != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cKY != null) {
                        int taskId = b.this.cKY.getTaskId();
                        b.this.cKY.finish();
                        if (z) {
                            b.this.cKY.overridePendingTransition(0, a.C0343a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aHF().kR(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void auU() {
        this.cLa = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void auV() {
        this.cLa = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e ajI() {
        return com.baidu.swan.apps.runtime.e.aDa();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion auW() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        auS();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        auS();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a auX() {
        auS();
        if (this.cKV == null) {
            this.cKV = com.baidu.swan.apps.core.turbo.d.ann().ano().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.ed(true);
        }
        if (this.cKY != null) {
            this.cKV.A((ViewGroup) this.cKY.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cKV;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView J(Activity activity) {
        auS();
        if (activity == null) {
            return null;
        }
        if (this.cvt == null) {
            this.cvt = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cvt.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cvt.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cvt.setVisibility(8);
            this.cvt.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cKV;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cKV == null) {
                        this.cKV = f.avu().auX();
                    }
                    this.cKV.aec();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void avj() {
                }
            });
        }
        return this.cvt;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow K(Activity activity) {
        ViewGroup viewGroup;
        auS();
        if (activity == null) {
            return null;
        }
        if (this.cvv == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cvv = new SwanAppPropertyWindow(activity);
            this.cvv.setVisibility(8);
            viewGroup.addView(this.cvv);
        }
        return this.cvv;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean auY() {
        auS();
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        b.a aVar = null;
        if (aDa != null) {
            aVar = aDa.abu();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.ann().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cKY = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData auZ() {
        com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
        if (aCW.aBj()) {
            return aCW.aCS().aDj();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c pe(String str) {
        SwanAppConfigData auZ = auZ();
        if (auZ == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aEc();
        }
        return this.cKX.a(avb(), str, auZ.dfg);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c pf(String str) {
        SwanAppConfigData auZ = auZ();
        if (auZ == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aEc();
        }
        return this.cKX.b(avb(), str, auZ.dfg);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? pe(str) : this.cKX.a(str2, str, swanAppConfigData.dfg);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c ava() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        return aDb == null ? new com.baidu.swan.apps.storage.b.b() : aDb.ava();
    }

    @Override // com.baidu.swan.apps.v.d
    public String avb() {
        return TextUtils.isEmpty(this.cIX) ? "" : this.cIX;
    }

    @Override // com.baidu.swan.apps.v.d
    public String avc() {
        com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
        if (aDb == null || aDb.abu() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aDb.abu(), f.avu().auZ());
    }

    @Override // com.baidu.swan.apps.v.d
    public String avd() {
        SwanAppConfigData auZ = auZ();
        return auZ == null ? "" : auZ.avd();
    }

    public com.baidu.swan.apps.core.d.f abs() {
        if (this.cKY == null) {
            return null;
        }
        return this.cKY.abs();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity ave() {
        return com.baidu.swan.apps.runtime.d.aCW().aCU();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d alg() {
        j jVar;
        com.baidu.swan.apps.core.d.f abs = abs();
        if (abs != null && (jVar = (j) abs.q(j.class)) != null) {
            return jVar.alg();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d alh() {
        j jVar;
        com.baidu.swan.apps.core.d.f abs = abs();
        if (abs != null && (jVar = (j) abs.q(j.class)) != null) {
            return jVar.alh();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e mZ(String str) {
        return com.baidu.swan.apps.core.turbo.d.ann().mZ(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout pg(String str) {
        com.baidu.swan.apps.adaptation.b.d aen;
        com.baidu.swan.apps.adaptation.b.e mZ = mZ(str);
        if (mZ == null || (aen = mZ.aen()) == null) {
            return null;
        }
        return aen.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cFi = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cxS, gVar);
            com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ann().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.ann().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e akI() {
        com.baidu.swan.apps.core.d.f abs = abs();
        if (abs == null) {
            return null;
        }
        return abs.akI();
    }

    @Override // com.baidu.swan.apps.v.d
    public String akr() {
        com.baidu.swan.apps.core.d.e akI = akI();
        return akI != null ? akI.akr() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d avf() {
        com.baidu.swan.apps.adaptation.b.e mZ = mZ(akr());
        if (mZ == null) {
            return null;
        }
        return mZ.aen();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> avg() {
        Pair<Integer, Integer> akt = akt();
        int intValue = ((Integer) akt.first).intValue();
        int intValue2 = ((Integer) akt.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.cM(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> akt() {
        com.baidu.swan.apps.core.d.e akI = akI();
        return akI == null ? new Pair<>(0, 0) : akI.akt();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> avh() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aCW().aCU() != null && (window = com.baidu.swan.apps.runtime.d.aCW().aCU().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.cJ(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void iN(int i) {
        auS();
        com.baidu.swan.apps.ap.b.aHF().l(this.cKY);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aCU = com.baidu.swan.apps.runtime.d.aCW().aCU();
        if (aCU != null && !aCU.isFinishing()) {
            aCU.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void abv() {
        SwanAppActivity aCU = com.baidu.swan.apps.runtime.d.aCW().aCU();
        if (aCU != null && !aCU.isFinishing()) {
            aCU.abv();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a avi() {
        return null;
    }
}
