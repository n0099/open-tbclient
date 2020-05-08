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
/* loaded from: classes11.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView bLN;
    protected SwanAppPropertyWindow bLP;
    protected boolean bRa;
    protected String bVX;
    protected com.baidu.swan.apps.adaptation.b.a bXH;
    protected com.baidu.swan.games.s.a.a bXI;
    protected com.baidu.swan.apps.runtime.config.a bXJ = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bXK;
    protected e bXL;
    protected boolean bXM;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Yn();
        this.bXL = new e();
        this.bXL.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aej() {
        if (aeu() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void bH(Context context) {
        aej();
        this.bXL.bJ(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void bI(Context context) {
        this.bXL.bK(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.bRa = true;
        if (this.bXL != null) {
            this.bXL.aeD();
            this.bXL = null;
        }
        g.aeP().aeR();
        com.baidu.swan.apps.process.a.b.b.a.aiQ().release();
        Qu();
        this.bXK = null;
    }

    private void Qu() {
        if (this.bLN != null) {
            ViewParent parent = this.bLN.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bLN);
            }
        }
        if (this.bXH != null) {
            this.bXH.Qu();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Qm() {
        aej();
        String akO = com.baidu.swan.apps.runtime.e.akO();
        if (!TextUtils.isEmpty(akO)) {
            this.bXM = true;
            this.bXL.aeD();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", akO);
            com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.acq().Qm();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Qn() {
        String akO = com.baidu.swan.apps.runtime.e.akO();
        if (!TextUtils.isEmpty(akO)) {
            if (this.bXM) {
                this.bXL.aeA();
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", akO);
            com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.acq().Qn();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.bXK != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bXK != null) {
                        b.this.bXK.finish();
                        if (z) {
                            b.this.bXK.overridePendingTransition(0, a.C0248a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        aej();
        SwanAppActivity aeu = aeu();
        if (aeu != null) {
            aeu.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void aek() {
        this.bXM = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void ael() {
        this.bXM = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Wq() {
        return com.baidu.swan.apps.runtime.e.akM();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion aem() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        aej();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        aej();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aen() {
        aej();
        if (this.bXH == null) {
            this.bXH = com.baidu.swan.apps.core.k.d.Yn().Yo().aW(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.de(true);
        }
        if (this.bXK != null) {
            this.bXH.n((ViewGroup) this.bXK.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bXH;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView K(Activity activity) {
        aej();
        if (activity == null) {
            return null;
        }
        if (this.bLN == null) {
            this.bLN = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bLN.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bLN.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bLN.setVisibility(8);
            this.bLN.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bXH;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bXH == null) {
                        this.bXH = f.aeJ().aen();
                    }
                    this.bXH.Qt();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aez() {
                }
            });
        }
        return this.bLN;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        aej();
        if (activity == null) {
            return null;
        }
        if (this.bLP == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bLP = new SwanAppPropertyWindow(activity);
            this.bLP.setVisibility(8);
            viewGroup.addView(this.bLP);
        }
        return this.bLP;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean aeo() {
        aej();
        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
        b.a aVar = null;
        if (akM != null) {
            aVar = akM.Ov();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void v(Intent intent) {
        com.baidu.swan.apps.core.k.d.Yn().q(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.bXK = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData aep() {
        com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
        if (akJ.ajq()) {
            return akJ.akG().akS();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c ke(String str) {
        SwanAppConfigData aep = aep();
        if (aep == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.alL();
        }
        return this.bXJ.a(aer(), str, aep.coJ);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c aeq() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        return akN == null ? new com.baidu.swan.apps.storage.b.a() : akN.akV();
    }

    @Override // com.baidu.swan.apps.y.d
    public String aer() {
        return TextUtils.isEmpty(this.bVX) ? "" : this.bVX;
    }

    @Override // com.baidu.swan.apps.y.d
    public String aes() {
        if (this.bXK == null || this.bXK.Ov() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bXK.Ov(), f.aeJ().aep());
    }

    @Override // com.baidu.swan.apps.y.d
    public String aet() {
        SwanAppConfigData aep = aep();
        return aep == null ? "" : aep.aet();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e Ot() {
        if (this.bXK == null) {
            return null;
        }
        return this.bXK.Ot();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity aeu() {
        return com.baidu.swan.apps.runtime.d.akJ().akI();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d WF() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e Ot = Ot();
        if (Ot != null && (iVar = (com.baidu.swan.apps.core.d.i) Ot.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.WF();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d WG() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e Ot = Ot();
        if (Ot != null && (iVar = (com.baidu.swan.apps.core.d.i) Ot.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.WG();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e iI(String str) {
        return com.baidu.swan.apps.core.k.d.Yn().iI(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout kf(String str) {
        com.baidu.swan.apps.adaptation.b.d QD;
        com.baidu.swan.apps.adaptation.b.e iI = iI(str);
        if (iI == null || (QD = iI.QD()) == null) {
            return null;
        }
        return QD.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.bSX = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.bPW, fVar);
            com.baidu.swan.apps.performance.e.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Yn().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Yn().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d We() {
        com.baidu.swan.apps.core.d.e Ot = Ot();
        if (Ot == null) {
            return null;
        }
        return Ot.We();
    }

    @Override // com.baidu.swan.apps.y.d
    public String VP() {
        com.baidu.swan.apps.core.d.d We = We();
        return We != null ? We.VP() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d aev() {
        com.baidu.swan.apps.adaptation.b.e iI = iI(VP());
        if (iI == null) {
            return null;
        }
        return iI.QD();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> aew() {
        Pair<Integer, Integer> VQ = VQ();
        int intValue = ((Integer) VQ.first).intValue();
        int intValue2 = ((Integer) VQ.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cj(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> VQ() {
        com.baidu.swan.apps.core.d.d We = We();
        return We == null ? new Pair<>(0, 0) : We.VQ();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> aex() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fs(int i) {
        aej();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity akI = com.baidu.swan.apps.runtime.d.akJ().akI();
        if (akI != null && !akI.isFinishing()) {
            akI.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Ow() {
        SwanAppActivity akI = com.baidu.swan.apps.runtime.d.akJ().akI();
        if (akI != null && !akI.isFinishing()) {
            akI.Ow();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a aey() {
        return null;
    }
}
