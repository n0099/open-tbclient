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
/* loaded from: classes9.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView bim;
    protected SwanAppPropertyWindow bip;
    protected String bsA;
    protected com.baidu.swan.apps.adaptation.b.a bul;
    protected com.baidu.swan.games.s.a.a bum;
    protected com.baidu.swan.apps.runtime.config.a bun = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity buo;
    protected e bup;
    protected boolean buq;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.NK();
        this.bup = new e();
        this.bup.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void TF() {
        if (TQ() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void cc(Context context) {
        TF();
        this.bup.ce(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void cd(Context context) {
        this.bup.cf(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.bup != null) {
            this.bup.TZ();
            this.bup = null;
        }
        g.Uk().Um();
        com.baidu.swan.apps.process.a.b.b.a.XW().release();
        FT();
        this.buo = null;
    }

    private void FT() {
        if (this.bim != null) {
            ViewParent parent = this.bim.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bim);
            }
        }
        if (this.bul != null) {
            this.bul.FT();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void FL() {
        TF();
        String ZU = com.baidu.swan.apps.runtime.e.ZU();
        if (!TextUtils.isEmpty(ZU)) {
            this.buq = true;
            this.bup.TZ();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, ZU);
            com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.RN().FL();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void FM() {
        String ZU = com.baidu.swan.apps.runtime.e.ZU();
        if (!TextUtils.isEmpty(ZU)) {
            if (this.buq) {
                this.bup.TW();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, ZU);
            com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.RN().FM();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.buo != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.buo != null) {
                        b.this.buo.finish();
                        if (z) {
                            b.this.buo.overridePendingTransition(0, a.C0185a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        TF();
        SwanAppActivity TQ = TQ();
        if (TQ != null) {
            TQ.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void TG() {
        this.buq = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void TH() {
        this.buq = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e LO() {
        return com.baidu.swan.apps.runtime.e.ZS();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion TI() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        TF();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        TF();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a TJ() {
        TF();
        if (this.bul == null) {
            this.bul = com.baidu.swan.apps.core.k.d.NK().NL().br(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.bU(true);
        }
        if (this.buo != null) {
            this.bul.i((ViewGroup) this.buo.findViewById(a.f.ai_apps_activity_root));
        }
        return this.bul;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView M(Activity activity) {
        TF();
        if (activity == null) {
            return null;
        }
        if (this.bim == null) {
            this.bim = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bim.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bim.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bim.setVisibility(8);
            this.bim.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a bul;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.bul == null) {
                        this.bul = f.Uf().TJ();
                    }
                    this.bul.FS();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void TV() {
                }
            });
        }
        return this.bim;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow N(Activity activity) {
        ViewGroup viewGroup;
        TF();
        if (activity == null) {
            return null;
        }
        if (this.bip == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bip = new SwanAppPropertyWindow(activity);
            this.bip.setVisibility(8);
            viewGroup.addView(this.bip);
        }
        return this.bip;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean TK() {
        TF();
        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
        b.a aVar = null;
        if (ZS != null) {
            aVar = ZS.DR();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void J(Intent intent) {
        com.baidu.swan.apps.core.k.d.NK().E(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.buo = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData TL() {
        com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
        if (ZP.Yw()) {
            return ZP.ZM().ZY();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c iA(String str) {
        SwanAppConfigData TL = TL();
        if (TL == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aaR();
        }
        return this.bun.a(TN(), str, TL.bKP);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c TM() {
        com.baidu.swan.apps.runtime.e ZT = com.baidu.swan.apps.runtime.e.ZT();
        return ZT == null ? new com.baidu.swan.apps.storage.b.a() : ZT.aab();
    }

    @Override // com.baidu.swan.apps.y.d
    public String TN() {
        return TextUtils.isEmpty(this.bsA) ? "" : this.bsA;
    }

    @Override // com.baidu.swan.apps.y.d
    public String TO() {
        if (this.buo == null || this.buo.DR() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.buo.DR(), f.Uf().TL());
    }

    @Override // com.baidu.swan.apps.y.d
    public String TP() {
        SwanAppConfigData TL = TL();
        return TL == null ? "" : TL.TP();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e DP() {
        if (this.buo == null) {
            return null;
        }
        return this.buo.DP();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity TQ() {
        return com.baidu.swan.apps.runtime.d.ZP().ZO();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d Mc() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e DP = DP();
        if (DP != null && (iVar = (com.baidu.swan.apps.core.d.i) DP.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.Mc();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d Md() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e DP = DP();
        if (DP != null && (iVar = (com.baidu.swan.apps.core.d.i) DP.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.Md();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e hd(String str) {
        return com.baidu.swan.apps.core.k.d.NK().hd(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout iB(String str) {
        com.baidu.swan.apps.adaptation.b.d Gc;
        com.baidu.swan.apps.adaptation.b.e hd = hd(str);
        if (hd == null || (Gc = hd.Gc()) == null) {
            return null;
        }
        return Gc.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.aJ("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.bpz = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.bmz, fVar);
            com.baidu.swan.apps.performance.e.aJ("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.NK().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.NK().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d LC() {
        com.baidu.swan.apps.core.d.e DP = DP();
        if (DP == null) {
            return null;
        }
        return DP.LC();
    }

    @Override // com.baidu.swan.apps.y.d
    public String Ln() {
        com.baidu.swan.apps.core.d.d LC = LC();
        return LC != null ? LC.Ln() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d TR() {
        com.baidu.swan.apps.adaptation.b.e hd = hd(Ln());
        if (hd == null) {
            return null;
        }
        return hd.Gc();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> TS() {
        Pair<Integer, Integer> Lo = Lo();
        int intValue = ((Integer) Lo.first).intValue();
        int intValue2 = ((Integer) Lo.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cE(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Lo() {
        com.baidu.swan.apps.core.d.d LC = LC();
        return LC == null ? new Pair<>(0, 0) : LC.Lo();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> TT() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void eW(int i) {
        TF();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity ZO = com.baidu.swan.apps.runtime.d.ZP().ZO();
        if (ZO != null && !ZO.isFinishing()) {
            ZO.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void DS() {
        SwanAppActivity ZO = com.baidu.swan.apps.runtime.d.ZP().ZO();
        if (ZO != null && !ZO.isFinishing()) {
            ZO.DS();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a TU() {
        return null;
    }
}
