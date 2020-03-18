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
    protected FullScreenFloatView bnB;
    protected SwanAppPropertyWindow bnD;
    protected String bxL;
    protected boolean bzA;
    protected com.baidu.swan.apps.adaptation.b.a bzv;
    protected com.baidu.swan.games.s.a.a bzw;
    protected com.baidu.swan.apps.runtime.config.a bzx = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bzy;
    protected e bzz;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Qz();
        this.bzz = new e();
        this.bzz.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wv() {
        if (WG() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void cf(Context context) {
        Wv();
        this.bzz.ch(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void cg(Context context) {
        this.bzz.ci(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.bzz != null) {
            this.bzz.WP();
            this.bzz = null;
        }
        g.Xa().Xc();
        com.baidu.swan.apps.process.a.b.b.a.aaM().release();
        IJ();
        this.bzy = null;
    }

    private void IJ() {
        if (this.bnB != null) {
            ViewParent parent = this.bnB.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bnB);
            }
        }
        if (this.bzv != null) {
            this.bzv.IJ();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void IB() {
        Wv();
        String acK = com.baidu.swan.apps.runtime.e.acK();
        if (!TextUtils.isEmpty(acK)) {
            this.bzA = true;
            this.bzz.WP();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, acK);
            com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.UC().IB();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void IC() {
        String acK = com.baidu.swan.apps.runtime.e.acK();
        if (!TextUtils.isEmpty(acK)) {
            if (this.bzA) {
                this.bzz.WM();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, acK);
            com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.UC().IC();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.bzy != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bzy != null) {
                        b.this.bzy.finish();
                        if (z) {
                            b.this.bzy.overridePendingTransition(0, a.C0197a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        Wv();
        SwanAppActivity WG = WG();
        if (WG != null) {
            WG.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Ww() {
        this.bzA = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void Wx() {
        this.bzA = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e OD() {
        return com.baidu.swan.apps.runtime.e.acI();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion Wy() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Wv();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Wv();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Wz() {
        Wv();
        if (this.bzv == null) {
            this.bzv = com.baidu.swan.apps.core.k.d.Qz().QA().bu(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.ci(true);
        }
        if (this.bzy != null) {
            this.bzv.m((ViewGroup) this.bzy.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bzv;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        Wv();
        if (activity == null) {
            return null;
        }
        if (this.bnB == null) {
            this.bnB = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bnB.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bnB.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bnB.setVisibility(8);
            this.bnB.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bzv;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bzv == null) {
                        this.bzv = f.WV().Wz();
                    }
                    this.bzv.II();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void WL() {
                }
            });
        }
        return this.bnB;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        Wv();
        if (activity == null) {
            return null;
        }
        if (this.bnD == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bnD = new SwanAppPropertyWindow(activity);
            this.bnD.setVisibility(8);
            viewGroup.addView(this.bnD);
        }
        return this.bnD;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean WA() {
        Wv();
        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
        b.a aVar = null;
        if (acI != null) {
            aVar = acI.GJ();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void J(Intent intent) {
        com.baidu.swan.apps.core.k.d.Qz().E(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.bzy = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData WB() {
        com.baidu.swan.apps.runtime.d acF = com.baidu.swan.apps.runtime.d.acF();
        if (acF.abm()) {
            return acF.acC().acO();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c iR(String str) {
        SwanAppConfigData WB = WB();
        if (WB == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.adH();
        }
        return this.bzx.a(WD(), str, WB.bPR);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c WC() {
        com.baidu.swan.apps.runtime.e acJ = com.baidu.swan.apps.runtime.e.acJ();
        return acJ == null ? new com.baidu.swan.apps.storage.b.a() : acJ.acR();
    }

    @Override // com.baidu.swan.apps.y.d
    public String WD() {
        return TextUtils.isEmpty(this.bxL) ? "" : this.bxL;
    }

    @Override // com.baidu.swan.apps.y.d
    public String WE() {
        if (this.bzy == null || this.bzy.GJ() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bzy.GJ(), f.WV().WB());
    }

    @Override // com.baidu.swan.apps.y.d
    public String WF() {
        SwanAppConfigData WB = WB();
        return WB == null ? "" : WB.WF();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e GH() {
        if (this.bzy == null) {
            return null;
        }
        return this.bzy.GH();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity WG() {
        return com.baidu.swan.apps.runtime.d.acF().acE();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d OR() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e GH = GH();
        if (GH != null && (iVar = (com.baidu.swan.apps.core.d.i) GH.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.OR();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d OS() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e GH = GH();
        if (GH != null && (iVar = (com.baidu.swan.apps.core.d.i) GH.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.OS();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e hu(String str) {
        return com.baidu.swan.apps.core.k.d.Qz().hu(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout iS(String str) {
        com.baidu.swan.apps.adaptation.b.d IS;
        com.baidu.swan.apps.adaptation.b.e hu = hu(str);
        if (hu == null || (IS = hu.IS()) == null) {
            return null;
        }
        return IS.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.z("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.buL = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.brK, fVar);
            com.baidu.swan.apps.performance.e.z("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Qz().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Qz().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d Or() {
        com.baidu.swan.apps.core.d.e GH = GH();
        if (GH == null) {
            return null;
        }
        return GH.Or();
    }

    @Override // com.baidu.swan.apps.y.d
    public String Oc() {
        com.baidu.swan.apps.core.d.d Or = Or();
        return Or != null ? Or.Oc() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d WH() {
        com.baidu.swan.apps.adaptation.b.e hu = hu(Oc());
        if (hu == null) {
            return null;
        }
        return hu.IS();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WI() {
        Pair<Integer, Integer> Od = Od();
        int intValue = ((Integer) Od.first).intValue();
        int intValue2 = ((Integer) Od.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cH(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Od() {
        com.baidu.swan.apps.core.d.d Or = Or();
        return Or == null ? new Pair<>(0, 0) : Or.Od();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WJ() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        Wv();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity acE = com.baidu.swan.apps.runtime.d.acF().acE();
        if (acE != null && !acE.isFinishing()) {
            acE.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void GK() {
        SwanAppActivity acE = com.baidu.swan.apps.runtime.d.acF().acE();
        if (acE != null && !acE.isFinishing()) {
            acE.GK();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a WK() {
        return null;
    }
}
