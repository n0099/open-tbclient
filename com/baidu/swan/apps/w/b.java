package com.baidu.swan.apps.w;

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
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aa;
import com.baidu.swan.apps.aq.ag;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
/* loaded from: classes11.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView bUL;
    protected SwanAppPropertyWindow bUO;
    protected boolean caM;
    protected String cgs;
    protected com.baidu.swan.apps.adaptation.b.a cii;
    protected com.baidu.swan.games.t.a.a cij;
    protected com.baidu.swan.apps.runtime.config.a cik = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cil;
    protected e cim;
    protected boolean cin;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.abl();
        this.cim = new e();
        this.cim.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aht() {
        if (ahF() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void bS(Context context) {
        aht();
        this.cim.bU(context);
    }

    @Override // com.baidu.swan.apps.w.d
    public void bT(Context context) {
        this.cim.bV(context);
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void doRelease() {
        this.caM = true;
        if (this.cim != null) {
            this.cim.ahP();
            this.cim = null;
        }
        g.aie().aig();
        com.baidu.swan.apps.process.a.b.b.a.amx().release();
        SY();
        this.cil = null;
    }

    private void SY() {
        if (this.bUL != null) {
            ViewParent parent = this.bUL.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bUL);
            }
        }
        if (this.cii != null) {
            this.cii.SY();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void SQ() {
        aht();
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        if (!TextUtils.isEmpty(aoH)) {
            this.cin = true;
            this.cim.ahP();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aoH);
            bundle.putInt("task_id", ahF().getTaskId());
            com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.u.a.aft().SQ();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void SR() {
        String aoH = com.baidu.swan.apps.runtime.e.aoH();
        if (!TextUtils.isEmpty(aoH)) {
            ahu();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aoH);
            com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.u.a.aft().SR();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void ahu() {
        if (ahL()) {
            this.cim.ahM();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cil != null) {
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cil != null) {
                        int taskId = b.this.cil.getTaskId();
                        b.this.cil.finish();
                        if (z) {
                            b.this.cil.overridePendingTransition(0, a.C0281a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.aq.a.asW().hH(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        aht();
        SwanAppActivity ahF = ahF();
        if (ahF != null) {
            ahF.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void ahv() {
        this.cin = false;
    }

    @Override // com.baidu.swan.apps.w.d
    public void ahw() {
        this.cin = true;
    }

    @Override // com.baidu.swan.apps.w.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Zc() {
        return com.baidu.swan.apps.runtime.e.aoF();
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanCoreVersion ahx() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aht();
    }

    @Override // com.baidu.swan.apps.w.d
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.r.b bVar2) {
        aht();
    }

    @Override // com.baidu.swan.apps.w.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a ahy() {
        aht();
        if (this.cii == null) {
            this.cii = com.baidu.swan.apps.core.turbo.d.abl().abm().bg(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.dr(true);
        }
        if (this.cil != null) {
            this.cii.r((ViewGroup) this.cil.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cii;
    }

    @Override // com.baidu.swan.apps.w.d
    public FullScreenFloatView I(Activity activity) {
        aht();
        if (activity == null) {
            return null;
        }
        if (this.bUL == null) {
            this.bUL = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bUL.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bUL.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bUL.setVisibility(8);
            this.bUL.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.b.2
                com.baidu.swan.apps.adaptation.b.a cii;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cii == null) {
                        this.cii = f.ahV().ahy();
                    }
                    this.cii.SX();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void ahK() {
                }
            });
        }
        return this.bUL;
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanAppPropertyWindow J(Activity activity) {
        ViewGroup viewGroup;
        aht();
        if (activity == null) {
            return null;
        }
        if (this.bUO == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bUO = new SwanAppPropertyWindow(activity);
            this.bUO.setVisibility(8);
            viewGroup.addView(this.bUO);
        }
        return this.bUO;
    }

    @Override // com.baidu.swan.apps.w.d
    public boolean ahz() {
        aht();
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        b.a aVar = null;
        if (aoF != null) {
            aVar = aoF.QJ();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.w.d
    public void u(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.abl().p(intent);
    }

    @Override // com.baidu.swan.apps.w.d
    public void h(SwanAppActivity swanAppActivity) {
        this.cil = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanAppConfigData ahA() {
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        if (aoB.ane()) {
            return aoB.aox().aoO();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c lq(String str) {
        SwanAppConfigData ahA = ahA();
        if (ahA == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.apJ();
        }
        return this.cik.a(ahC(), str, ahA.cAv);
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.runtime.config.c lr(String str) {
        SwanAppConfigData ahA = ahA();
        if (ahA == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.apJ();
        }
        return this.cik.b(ahC(), str, ahA.cAv);
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c ahB() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        return aoG == null ? new com.baidu.swan.apps.storage.b.b() : aoG.ahB();
    }

    @Override // com.baidu.swan.apps.w.d
    public String ahC() {
        return TextUtils.isEmpty(this.cgs) ? "" : this.cgs;
    }

    @Override // com.baidu.swan.apps.w.d
    public String ahD() {
        com.baidu.swan.apps.runtime.e aoG = com.baidu.swan.apps.runtime.e.aoG();
        if (aoG == null || aoG.QJ() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(aoG.QJ(), f.ahV().ahA());
    }

    @Override // com.baidu.swan.apps.w.d
    public String ahE() {
        SwanAppConfigData ahA = ahA();
        return ahA == null ? "" : ahA.ahE();
    }

    public com.baidu.swan.apps.core.d.e QH() {
        if (this.cil == null) {
            return null;
        }
        return this.cil.QH();
    }

    @Override // com.baidu.swan.apps.w.d
    public SwanAppActivity ahF() {
        return com.baidu.swan.apps.runtime.d.aoB().aoz();
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.games.view.d Zr() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e QH = QH();
        if (QH != null && (iVar = (com.baidu.swan.apps.core.d.i) QH.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.Zr();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.games.view.d Zs() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e QH = QH();
        if (QH != null && (iVar = (com.baidu.swan.apps.core.d.i) QH.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.Zs();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.adaptation.b.e jO(String str) {
        return com.baidu.swan.apps.core.turbo.d.abl().jO(str);
    }

    @Override // com.baidu.swan.apps.w.d
    public AbsoluteLayout ls(String str) {
        com.baidu.swan.apps.adaptation.b.d Th;
        com.baidu.swan.apps.adaptation.b.e jO = jO(str);
        if (jO == null || (Th = jO.Th()) == null) {
            return null;
        }
        return Th.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.f.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.ccQ = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.bZI, gVar);
            com.baidu.swan.apps.performance.f.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void a(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.abl().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.abl().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.core.d.d YQ() {
        com.baidu.swan.apps.core.d.e QH = QH();
        if (QH == null) {
            return null;
        }
        return QH.YQ();
    }

    @Override // com.baidu.swan.apps.w.d
    public String YB() {
        com.baidu.swan.apps.core.d.d YQ = YQ();
        return YQ != null ? YQ.YB() : "";
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.apps.adaptation.b.d ahG() {
        com.baidu.swan.apps.adaptation.b.e jO = jO(YB());
        if (jO == null) {
            return null;
        }
        return jO.Th();
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> ahH() {
        Pair<Integer, Integer> YD = YD();
        int intValue = ((Integer) YD.first).intValue();
        int intValue2 = ((Integer) YD.second).intValue();
        if (intValue == 0) {
            intValue = ag.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ag.cv(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> YD() {
        com.baidu.swan.apps.core.d.d YQ = YQ();
        return YQ == null ? new Pair<>(0, 0) : YQ.YD();
    }

    @Override // com.baidu.swan.apps.w.d
    @NonNull
    public Pair<Integer, Integer> ahI() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ag.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aoB().aoz() != null && (window = com.baidu.swan.apps.runtime.d.aoB().aoz().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ag.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ag.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? aa.cu(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.w.e.b
    public void fH(int i) {
        aht();
        com.baidu.swan.apps.aq.a.asW().k(this.cil);
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.d
    public void showLoadingView() {
        SwanAppActivity aoz = com.baidu.swan.apps.runtime.d.aoB().aoz();
        if (aoz != null && !aoz.isFinishing()) {
            aoz.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public void QK() {
        SwanAppActivity aoz = com.baidu.swan.apps.runtime.d.aoB().aoz();
        if (aoz != null && !aoz.isFinishing()) {
            aoz.QK();
        }
    }

    @Override // com.baidu.swan.apps.w.d
    public com.baidu.swan.games.q.a ahJ() {
        return null;
    }
}
