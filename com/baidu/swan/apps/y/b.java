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
    protected FullScreenFloatView bno;
    protected SwanAppPropertyWindow bnq;
    protected String bxA;
    protected com.baidu.swan.apps.adaptation.b.a bzk;
    protected com.baidu.swan.games.s.a.a bzl;
    protected com.baidu.swan.apps.runtime.config.a bzm = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bzn;
    protected e bzo;
    protected boolean bzp;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Qw();
        this.bzo = new e();
        this.bzo.a(this);
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
        this.bzo.ci(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void ch(Context context) {
        this.bzo.cj(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.bzo != null) {
            this.bzo.WM();
            this.bzo = null;
        }
        g.WX().WZ();
        com.baidu.swan.apps.process.a.b.b.a.aaJ().release();
        IG();
        this.bzn = null;
    }

    private void IG() {
        if (this.bno != null) {
            ViewParent parent = this.bno.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bno);
            }
        }
        if (this.bzk != null) {
            this.bzk.IG();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Iy() {
        Ws();
        String acH = com.baidu.swan.apps.runtime.e.acH();
        if (!TextUtils.isEmpty(acH)) {
            this.bzp = true;
            this.bzo.WM();
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
            if (this.bzp) {
                this.bzo.WJ();
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
        if (this.bzn != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bzn != null) {
                        b.this.bzn.finish();
                        if (z) {
                            b.this.bzn.overridePendingTransition(0, a.C0197a.aiapps_slide_out_to_right_zadjustment_top);
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
        this.bzp = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void Wu() {
        this.bzp = true;
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
        if (this.bzk == null) {
            this.bzk = com.baidu.swan.apps.core.k.d.Qw().Qx().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.ch(true);
        }
        if (this.bzn != null) {
            this.bzk.m((ViewGroup) this.bzn.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bzk;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        Ws();
        if (activity == null) {
            return null;
        }
        if (this.bno == null) {
            this.bno = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bno.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bno.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bno.setVisibility(8);
            this.bno.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bzk;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bzk == null) {
                        this.bzk = f.WS().Ww();
                    }
                    this.bzk.IF();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void WI() {
                }
            });
        }
        return this.bno;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        Ws();
        if (activity == null) {
            return null;
        }
        if (this.bnq == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bnq = new SwanAppPropertyWindow(activity);
            this.bnq.setVisibility(8);
            viewGroup.addView(this.bnq);
        }
        return this.bnq;
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
        this.bzn = swanAppActivity;
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
        return this.bzm.a(WA(), str, Wy.bPG);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c Wz() {
        com.baidu.swan.apps.runtime.e acG = com.baidu.swan.apps.runtime.e.acG();
        return acG == null ? new com.baidu.swan.apps.storage.b.a() : acG.acO();
    }

    @Override // com.baidu.swan.apps.y.d
    public String WA() {
        return TextUtils.isEmpty(this.bxA) ? "" : this.bxA;
    }

    @Override // com.baidu.swan.apps.y.d
    public String WB() {
        if (this.bzn == null || this.bzn.GE() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bzn.GE(), f.WS().Wy());
    }

    @Override // com.baidu.swan.apps.y.d
    public String WC() {
        SwanAppConfigData Wy = Wy();
        return Wy == null ? "" : Wy.WC();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e GC() {
        if (this.bzn == null) {
            return null;
        }
        return this.bzn.GC();
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
            fVar.buz = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.bry, fVar);
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
