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
    protected FullScreenFloatView bLI;
    protected SwanAppPropertyWindow bLK;
    protected boolean bQV;
    protected String bVR;
    protected com.baidu.swan.apps.adaptation.b.a bXB;
    protected com.baidu.swan.games.s.a.a bXC;
    protected com.baidu.swan.apps.runtime.config.a bXD = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bXE;
    protected e bXF;
    protected boolean bXG;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Yo();
        this.bXF = new e();
        this.bXF.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aek() {
        if (aev() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void bT(Context context) {
        aek();
        this.bXF.bV(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void bU(Context context) {
        this.bXF.bW(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.bQV = true;
        if (this.bXF != null) {
            this.bXF.aeE();
            this.bXF = null;
        }
        g.aeQ().aeS();
        com.baidu.swan.apps.process.a.b.b.a.aiR().release();
        Qv();
        this.bXE = null;
    }

    private void Qv() {
        if (this.bLI != null) {
            ViewParent parent = this.bLI.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bLI);
            }
        }
        if (this.bXB != null) {
            this.bXB.Qv();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Qn() {
        aek();
        String akP = com.baidu.swan.apps.runtime.e.akP();
        if (!TextUtils.isEmpty(akP)) {
            this.bXG = true;
            this.bXF.aeE();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", akP);
            com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.acr().Qn();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Qo() {
        String akP = com.baidu.swan.apps.runtime.e.akP();
        if (!TextUtils.isEmpty(akP)) {
            if (this.bXG) {
                this.bXF.aeB();
            }
            Bundle bundle = new Bundle();
            bundle.putString("app_id", akP);
            com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.acr().Qo();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.bXE != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bXE != null) {
                        b.this.bXE.finish();
                        if (z) {
                            b.this.bXE.overridePendingTransition(0, a.C0227a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        aek();
        SwanAppActivity aev = aev();
        if (aev != null) {
            aev.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void ael() {
        this.bXG = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void aem() {
        this.bXG = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Wr() {
        return com.baidu.swan.apps.runtime.e.akN();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion aen() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        aek();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        aek();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a aeo() {
        aek();
        if (this.bXB == null) {
            this.bXB = com.baidu.swan.apps.core.k.d.Yo().Yp().bi(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.de(true);
        }
        if (this.bXE != null) {
            this.bXB.n((ViewGroup) this.bXE.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bXB;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView K(Activity activity) {
        aek();
        if (activity == null) {
            return null;
        }
        if (this.bLI == null) {
            this.bLI = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bLI.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bLI.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bLI.setVisibility(8);
            this.bLI.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bXB;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bXB == null) {
                        this.bXB = f.aeK().aeo();
                    }
                    this.bXB.Qu();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void aeA() {
                }
            });
        }
        return this.bLI;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow L(Activity activity) {
        ViewGroup viewGroup;
        aek();
        if (activity == null) {
            return null;
        }
        if (this.bLK == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bLK = new SwanAppPropertyWindow(activity);
            this.bLK.setVisibility(8);
            viewGroup.addView(this.bLK);
        }
        return this.bLK;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean aep() {
        aek();
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        b.a aVar = null;
        if (akN != null) {
            aVar = akN.Ow();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void I(Intent intent) {
        com.baidu.swan.apps.core.k.d.Yo().D(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.bXE = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData aeq() {
        com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
        if (akK.ajr()) {
            return akK.akH().akT();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c ke(String str) {
        SwanAppConfigData aeq = aeq();
        if (aeq == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.alM();
        }
        return this.bXD.a(aes(), str, aeq.coD);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c aer() {
        com.baidu.swan.apps.runtime.e akO = com.baidu.swan.apps.runtime.e.akO();
        return akO == null ? new com.baidu.swan.apps.storage.b.a() : akO.akW();
    }

    @Override // com.baidu.swan.apps.y.d
    public String aes() {
        return TextUtils.isEmpty(this.bVR) ? "" : this.bVR;
    }

    @Override // com.baidu.swan.apps.y.d
    public String aet() {
        if (this.bXE == null || this.bXE.Ow() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bXE.Ow(), f.aeK().aeq());
    }

    @Override // com.baidu.swan.apps.y.d
    public String aeu() {
        SwanAppConfigData aeq = aeq();
        return aeq == null ? "" : aeq.aeu();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e Ou() {
        if (this.bXE == null) {
            return null;
        }
        return this.bXE.Ou();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity aev() {
        return com.baidu.swan.apps.runtime.d.akK().akJ();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d WG() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e Ou = Ou();
        if (Ou != null && (iVar = (com.baidu.swan.apps.core.d.i) Ou.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.WG();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d WH() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e Ou = Ou();
        if (Ou != null && (iVar = (com.baidu.swan.apps.core.d.i) Ou.q(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.WH();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e iI(String str) {
        return com.baidu.swan.apps.core.k.d.Yo().iI(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout kf(String str) {
        com.baidu.swan.apps.adaptation.b.d QE;
        com.baidu.swan.apps.adaptation.b.e iI = iI(str);
        if (iI == null || (QE = iI.QE()) == null) {
            return null;
        }
        return QE.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.D("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.bSR = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.bPR, fVar);
            com.baidu.swan.apps.performance.e.D("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Yo().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Yo().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d Wf() {
        com.baidu.swan.apps.core.d.e Ou = Ou();
        if (Ou == null) {
            return null;
        }
        return Ou.Wf();
    }

    @Override // com.baidu.swan.apps.y.d
    public String VQ() {
        com.baidu.swan.apps.core.d.d Wf = Wf();
        return Wf != null ? Wf.VQ() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d aew() {
        com.baidu.swan.apps.adaptation.b.e iI = iI(VQ());
        if (iI == null) {
            return null;
        }
        return iI.QE();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> aex() {
        Pair<Integer, Integer> VR = VR();
        int intValue = ((Integer) VR.first).intValue();
        int intValue2 = ((Integer) VR.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cv(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> VR() {
        com.baidu.swan.apps.core.d.d Wf = Wf();
        return Wf == null ? new Pair<>(0, 0) : Wf.VR();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> aey() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void fs(int i) {
        aek();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity akJ = com.baidu.swan.apps.runtime.d.akK().akJ();
        if (akJ != null && !akJ.isFinishing()) {
            akJ.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Ox() {
        SwanAppActivity akJ = com.baidu.swan.apps.runtime.d.akK().akJ();
        if (akJ != null && !akJ.isFinishing()) {
            akJ.Ox();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a aez() {
        return null;
    }
}
