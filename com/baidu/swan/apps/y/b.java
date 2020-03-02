package com.baidu.swan.apps.y;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.as.af;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.x.b.b;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes11.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView bnn;
    protected SwanAppPropertyWindow bnp;
    protected String bxz;
    protected com.baidu.swan.apps.adaptation.b.a bzj;
    protected com.baidu.swan.games.s.a.a bzk;
    protected com.baidu.swan.apps.runtime.config.a bzl = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bzm;
    protected e bzn;
    protected boolean bzo;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Qw();
        this.bzn = new e();
        this.bzn.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Ws() {
        if (WD() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void cg(Context context) {
        Ws();
        this.bzn.ci(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void ch(Context context) {
        this.bzn.cj(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.bzn != null) {
            this.bzn.WM();
            this.bzn = null;
        }
        g.WX().WZ();
        com.baidu.swan.apps.process.a.b.b.a.aaJ().release();
        IG();
        this.bzm = null;
    }

    private void IG() {
        if (this.bnn != null) {
            ViewParent parent = this.bnn.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bnn);
            }
        }
        if (this.bzj != null) {
            this.bzj.IG();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Iy() {
        Ws();
        String acH = com.baidu.swan.apps.runtime.e.acH();
        if (!TextUtils.isEmpty(acH)) {
            this.bzo = true;
            this.bzn.WM();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, acH);
            com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.Uz().Iy();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Iz() {
        String acH = com.baidu.swan.apps.runtime.e.acH();
        if (!TextUtils.isEmpty(acH)) {
            if (this.bzo) {
                this.bzn.WJ();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, acH);
            com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.Uz().Iz();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.bzm != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bzm != null) {
                        b.this.bzm.finish();
                        if (z) {
                            b.this.bzm.overridePendingTransition(0, a.C0197a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        Ws();
        SwanAppActivity WD = WD();
        if (WD != null) {
            WD.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Wt() {
        this.bzo = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void Wu() {
        this.bzo = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e OA() {
        return com.baidu.swan.apps.runtime.e.acF();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion Wv() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Ws();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Ws();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Ww() {
        Ws();
        if (this.bzj == null) {
            this.bzj = com.baidu.swan.apps.core.k.d.Qw().Qx().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.ch(true);
        }
        if (this.bzm != null) {
            this.bzj.m((ViewGroup) this.bzm.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bzj;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        Ws();
        if (activity == null) {
            return null;
        }
        if (this.bnn == null) {
            this.bnn = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bnn.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bnn.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bnn.setVisibility(8);
            this.bnn.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bzj;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bzj == null) {
                        this.bzj = f.WS().Ww();
                    }
                    this.bzj.IF();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void WI() {
                }
            });
        }
        return this.bnn;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        Ws();
        if (activity == null) {
            return null;
        }
        if (this.bnp == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bnp = new SwanAppPropertyWindow(activity);
            this.bnp.setVisibility(8);
            viewGroup.addView(this.bnp);
        }
        return this.bnp;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean Wx() {
        Ws();
        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
        b.a aVar = null;
        if (acF != null) {
            aVar = acF.GE();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void J(Intent intent) {
        com.baidu.swan.apps.core.k.d.Qw().E(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.bzm = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData Wy() {
        com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
        if (acC.abj()) {
            return acC.acz().acL();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c iS(String str) {
        SwanAppConfigData Wy = Wy();
        if (Wy == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.adE();
        }
        return this.bzl.a(WA(), str, Wy.bPF);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c Wz() {
        com.baidu.swan.apps.runtime.e acG = com.baidu.swan.apps.runtime.e.acG();
        return acG == null ? new com.baidu.swan.apps.storage.b.a() : acG.acO();
    }

    @Override // com.baidu.swan.apps.y.d
    public String WA() {
        return TextUtils.isEmpty(this.bxz) ? "" : this.bxz;
    }

    @Override // com.baidu.swan.apps.y.d
    public String WB() {
        if (this.bzm == null || this.bzm.GE() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bzm.GE(), f.WS().Wy());
    }

    @Override // com.baidu.swan.apps.y.d
    public String WC() {
        SwanAppConfigData Wy = Wy();
        return Wy == null ? "" : Wy.WC();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e GC() {
        if (this.bzm == null) {
            return null;
        }
        return this.bzm.GC();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity WD() {
        return com.baidu.swan.apps.runtime.d.acC().acB();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d OO() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e GC = GC();
        if (GC != null && (iVar = (com.baidu.swan.apps.core.d.i) GC.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.OO();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d OP() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e GC = GC();
        if (GC != null && (iVar = (com.baidu.swan.apps.core.d.i) GC.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.OP();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        return com.baidu.swan.apps.core.k.d.Qw().hv(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout iT(String str) {
        com.baidu.swan.apps.adaptation.b.d IP;
        com.baidu.swan.apps.adaptation.b.e hv = hv(str);
        if (hv == null || (IP = hv.IP()) == null) {
            return null;
        }
        return IP.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.z("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.buy = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.brx, fVar);
            com.baidu.swan.apps.performance.e.z("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Qw().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Qw().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d Oo() {
        com.baidu.swan.apps.core.d.e GC = GC();
        if (GC == null) {
            return null;
        }
        return GC.Oo();
    }

    @Override // com.baidu.swan.apps.y.d
    public String NZ() {
        com.baidu.swan.apps.core.d.d Oo = Oo();
        return Oo != null ? Oo.NZ() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d WE() {
        com.baidu.swan.apps.adaptation.b.e hv = hv(NZ());
        if (hv == null) {
            return null;
        }
        return hv.IP();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WF() {
        Pair<Integer, Integer> Oa = Oa();
        int intValue = ((Integer) Oa.first).intValue();
        int intValue2 = ((Integer) Oa.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cI(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Oa() {
        com.baidu.swan.apps.core.d.d Oo = Oo();
        return Oo == null ? new Pair<>(0, 0) : Oo.Oa();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WG() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        Ws();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity acB = com.baidu.swan.apps.runtime.d.acC().acB();
        if (acB != null && !acB.isFinishing()) {
            acB.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void GF() {
        SwanAppActivity acB = com.baidu.swan.apps.runtime.d.acC().acB();
        if (acB != null && !acB.isFinishing()) {
            acB.GF();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a WH() {
        return null;
    }
}
