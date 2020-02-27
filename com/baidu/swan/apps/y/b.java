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
    protected FullScreenFloatView bnm;
    protected SwanAppPropertyWindow bno;
    protected String bxy;
    protected com.baidu.swan.apps.adaptation.b.a bzi;
    protected com.baidu.swan.games.s.a.a bzj;
    protected com.baidu.swan.apps.runtime.config.a bzk = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bzl;
    protected e bzm;
    protected boolean bzn;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Qu();
        this.bzm = new e();
        this.bzm.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Wq() {
        if (WB() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void cg(Context context) {
        Wq();
        this.bzm.ci(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void ch(Context context) {
        this.bzm.cj(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.bzm != null) {
            this.bzm.WK();
            this.bzm = null;
        }
        g.WV().WX();
        com.baidu.swan.apps.process.a.b.b.a.aaH().release();
        IE();
        this.bzl = null;
    }

    private void IE() {
        if (this.bnm != null) {
            ViewParent parent = this.bnm.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bnm);
            }
        }
        if (this.bzi != null) {
            this.bzi.IE();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Iw() {
        Wq();
        String acF = com.baidu.swan.apps.runtime.e.acF();
        if (!TextUtils.isEmpty(acF)) {
            this.bzn = true;
            this.bzm.WK();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, acF);
            com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.Ux().Iw();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Ix() {
        String acF = com.baidu.swan.apps.runtime.e.acF();
        if (!TextUtils.isEmpty(acF)) {
            if (this.bzn) {
                this.bzm.WH();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, acF);
            com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.Ux().Ix();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.bzl != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bzl != null) {
                        b.this.bzl.finish();
                        if (z) {
                            b.this.bzl.overridePendingTransition(0, a.C0197a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        Wq();
        SwanAppActivity WB = WB();
        if (WB != null) {
            WB.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Wr() {
        this.bzn = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void Ws() {
        this.bzn = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Oy() {
        return com.baidu.swan.apps.runtime.e.acD();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion Wt() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Wq();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Wq();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Wu() {
        Wq();
        if (this.bzi == null) {
            this.bzi = com.baidu.swan.apps.core.k.d.Qu().Qv().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.ch(true);
        }
        if (this.bzl != null) {
            this.bzi.m((ViewGroup) this.bzl.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bzi;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView O(Activity activity) {
        Wq();
        if (activity == null) {
            return null;
        }
        if (this.bnm == null) {
            this.bnm = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bnm.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bnm.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bnm.setVisibility(8);
            this.bnm.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bzi;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bzi == null) {
                        this.bzi = f.WQ().Wu();
                    }
                    this.bzi.ID();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void WG() {
                }
            });
        }
        return this.bnm;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow P(Activity activity) {
        ViewGroup viewGroup;
        Wq();
        if (activity == null) {
            return null;
        }
        if (this.bno == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bno = new SwanAppPropertyWindow(activity);
            this.bno.setVisibility(8);
            viewGroup.addView(this.bno);
        }
        return this.bno;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean Wv() {
        Wq();
        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
        b.a aVar = null;
        if (acD != null) {
            aVar = acD.GC();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void J(Intent intent) {
        com.baidu.swan.apps.core.k.d.Qu().E(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.bzl = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData Ww() {
        com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
        if (acA.abh()) {
            return acA.acx().acJ();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c iS(String str) {
        SwanAppConfigData Ww = Ww();
        if (Ww == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.adC();
        }
        return this.bzk.a(Wy(), str, Ww.bPE);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c Wx() {
        com.baidu.swan.apps.runtime.e acE = com.baidu.swan.apps.runtime.e.acE();
        return acE == null ? new com.baidu.swan.apps.storage.b.a() : acE.acM();
    }

    @Override // com.baidu.swan.apps.y.d
    public String Wy() {
        return TextUtils.isEmpty(this.bxy) ? "" : this.bxy;
    }

    @Override // com.baidu.swan.apps.y.d
    public String Wz() {
        if (this.bzl == null || this.bzl.GC() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bzl.GC(), f.WQ().Ww());
    }

    @Override // com.baidu.swan.apps.y.d
    public String WA() {
        SwanAppConfigData Ww = Ww();
        return Ww == null ? "" : Ww.WA();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e GA() {
        if (this.bzl == null) {
            return null;
        }
        return this.bzl.GA();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity WB() {
        return com.baidu.swan.apps.runtime.d.acA().acz();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d OM() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e GA = GA();
        if (GA != null && (iVar = (com.baidu.swan.apps.core.d.i) GA.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.OM();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d ON() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e GA = GA();
        if (GA != null && (iVar = (com.baidu.swan.apps.core.d.i) GA.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.ON();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        return com.baidu.swan.apps.core.k.d.Qu().hv(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout iT(String str) {
        com.baidu.swan.apps.adaptation.b.d IN;
        com.baidu.swan.apps.adaptation.b.e hv = hv(str);
        if (hv == null || (IN = hv.IN()) == null) {
            return null;
        }
        return IN.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.z("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.bux = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.brw, fVar);
            com.baidu.swan.apps.performance.e.z("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Qu().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Qu().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d Om() {
        com.baidu.swan.apps.core.d.e GA = GA();
        if (GA == null) {
            return null;
        }
        return GA.Om();
    }

    @Override // com.baidu.swan.apps.y.d
    public String NX() {
        com.baidu.swan.apps.core.d.d Om = Om();
        return Om != null ? Om.NX() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d WC() {
        com.baidu.swan.apps.adaptation.b.e hv = hv(NX());
        if (hv == null) {
            return null;
        }
        return hv.IN();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WD() {
        Pair<Integer, Integer> NY = NY();
        int intValue = ((Integer) NY.first).intValue();
        int intValue2 = ((Integer) NY.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cI(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> NY() {
        com.baidu.swan.apps.core.d.d Om = Om();
        return Om == null ? new Pair<>(0, 0) : Om.NY();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> WE() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fn(int i) {
        Wq();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity acz = com.baidu.swan.apps.runtime.d.acA().acz();
        if (acz != null && !acz.isFinishing()) {
            acz.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void GD() {
        SwanAppActivity acz = com.baidu.swan.apps.runtime.d.acA().acz();
        if (acz != null && !acz.isFinishing()) {
            acz.GD();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a WF() {
        return null;
    }
}
