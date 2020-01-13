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
/* loaded from: classes10.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView bjc;
    protected SwanAppPropertyWindow bje;
    protected String bto;
    protected com.baidu.swan.apps.adaptation.b.a buZ;
    protected com.baidu.swan.games.s.a.a bva;
    protected com.baidu.swan.apps.runtime.config.a bvb = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity bvc;
    protected e bvd;
    protected boolean bve;
    protected boolean mIsReleased;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.k.d.Og();
        this.bvd = new e();
        this.bvd.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void Uc() {
        if (Un() == null && DEBUG) {
            throw new IllegalStateException(getClass().getSimpleName() + ": This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void cc(Context context) {
        Uc();
        this.bvd.ce(context);
    }

    @Override // com.baidu.swan.apps.y.d
    public void cd(Context context) {
        this.bvd.cf(context);
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void doRelease() {
        this.mIsReleased = true;
        if (this.bvd != null) {
            this.bvd.Uw();
            this.bvd = null;
        }
        g.UH().UJ();
        com.baidu.swan.apps.process.a.b.b.a.Yt().release();
        Gp();
        this.bvc = null;
    }

    private void Gp() {
        if (this.bjc != null) {
            ViewParent parent = this.bjc.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.bjc);
            }
        }
        if (this.buZ != null) {
            this.buZ.Gp();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Gh() {
        Uc();
        String aar = com.baidu.swan.apps.runtime.e.aar();
        if (!TextUtils.isEmpty(aar)) {
            this.bve = true;
            this.bvd.Uw();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, aar);
            com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.w.a.Sj().Gh();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void Gi() {
        String aar = com.baidu.swan.apps.runtime.e.aar();
        if (!TextUtils.isEmpty(aar)) {
            if (this.bve) {
                this.bvd.Ut();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, aar);
            com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.w.a.Sj().Gi();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.bvc != null) {
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.y.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.bvc != null) {
                        b.this.bvc.finish();
                        if (z) {
                            b.this.bvc.overridePendingTransition(0, a.C0187a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        Uc();
        SwanAppActivity Un = Un();
        if (Un != null) {
            Un.a(i, strArr, aVar);
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Ud() {
        this.bve = false;
    }

    @Override // com.baidu.swan.apps.y.d
    public void Ue() {
        this.bve = true;
    }

    @Override // com.baidu.swan.apps.y.d
    @Nullable
    public com.baidu.swan.apps.runtime.e Mk() {
        return com.baidu.swan.apps.runtime.e.aap();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanCoreVersion Uf() {
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void a(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Uc();
    }

    @Override // com.baidu.swan.apps.y.d
    @CallSuper
    public void b(com.baidu.swan.apps.x.b.b bVar, com.baidu.swan.apps.t.b bVar2) {
        Uc();
    }

    @Override // com.baidu.swan.apps.y.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a Ug() {
        Uc();
        if (this.buZ == null) {
            this.buZ = com.baidu.swan.apps.core.k.d.Og().Oh().br(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.bZ(true);
        }
        if (this.bvc != null) {
            this.buZ.l((ViewGroup) this.bvc.findViewById(a.f.ai_apps_activity_root));
        }
        return this.buZ;
    }

    @Override // com.baidu.swan.apps.y.d
    public FullScreenFloatView N(Activity activity) {
        Uc();
        if (activity == null) {
            return null;
        }
        if (this.bjc == null) {
            this.bjc = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.bjc.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.bjc.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.bjc.setVisibility(8);
            this.bjc.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.y.b.2
                com.baidu.swan.apps.adaptation.b.a buZ;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.buZ == null) {
                        this.buZ = f.UC().Ug();
                    }
                    this.buZ.Go();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void Us() {
                }
            });
        }
        return this.bjc;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppPropertyWindow O(Activity activity) {
        ViewGroup viewGroup;
        Uc();
        if (activity == null) {
            return null;
        }
        if (this.bje == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.bje = new SwanAppPropertyWindow(activity);
            this.bje.setVisibility(8);
            viewGroup.addView(this.bje);
        }
        return this.bje;
    }

    @Override // com.baidu.swan.apps.y.d
    public boolean Uh() {
        Uc();
        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
        b.a aVar = null;
        if (aap != null) {
            aVar = aap.En();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.e.a.c(aVar) || com.baidu.swan.apps.e.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.y.d
    public void J(Intent intent) {
        com.baidu.swan.apps.core.k.d.Og().E(intent);
    }

    @Override // com.baidu.swan.apps.y.d
    public void i(SwanAppActivity swanAppActivity) {
        this.bvc = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppConfigData Ui() {
        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
        if (aam.YT()) {
            return aam.aaj().aav();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c iD(String str) {
        SwanAppConfigData Ui = Ui();
        if (Ui == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.abo();
        }
        return this.bvb.a(Uk(), str, Ui.bLz);
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c Uj() {
        com.baidu.swan.apps.runtime.e aaq = com.baidu.swan.apps.runtime.e.aaq();
        return aaq == null ? new com.baidu.swan.apps.storage.b.a() : aaq.aay();
    }

    @Override // com.baidu.swan.apps.y.d
    public String Uk() {
        return TextUtils.isEmpty(this.bto) ? "" : this.bto;
    }

    @Override // com.baidu.swan.apps.y.d
    public String Ul() {
        if (this.bvc == null || this.bvc.En() == null) {
            return null;
        }
        return com.baidu.swan.apps.x.b.b.a(this.bvc.En(), f.UC().Ui());
    }

    @Override // com.baidu.swan.apps.y.d
    public String Um() {
        SwanAppConfigData Ui = Ui();
        return Ui == null ? "" : Ui.Um();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.e El() {
        if (this.bvc == null) {
            return null;
        }
        return this.bvc.El();
    }

    @Override // com.baidu.swan.apps.y.d
    public SwanAppActivity Un() {
        return com.baidu.swan.apps.runtime.d.aam().aal();
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d My() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e El = El();
        if (El != null && (iVar = (com.baidu.swan.apps.core.d.i) El.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.My();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.view.d Mz() {
        com.baidu.swan.apps.core.d.i iVar;
        com.baidu.swan.apps.core.d.e El = El();
        if (El != null && (iVar = (com.baidu.swan.apps.core.d.i) El.p(com.baidu.swan.apps.core.d.i.class)) != null) {
            return iVar.Mz();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.e hg(String str) {
        return com.baidu.swan.apps.core.k.d.Og().hg(str);
    }

    @Override // com.baidu.swan.apps.y.d
    public AbsoluteLayout iE(String str) {
        com.baidu.swan.apps.adaptation.b.d Gy;
        com.baidu.swan.apps.adaptation.b.e hg = hg(str);
        if (hg == null || (Gy = hg.Gy()) == null) {
            return null;
        }
        return Gy.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.aK("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.n.a.f fVar = new com.baidu.swan.apps.n.a.f();
            fVar.mData = dVar.mData;
            fVar.bqn = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.bnn, fVar);
            com.baidu.swan.apps.performance.e.aK("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Og().a(aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        com.baidu.swan.apps.core.k.d.Og().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.core.d.d LY() {
        com.baidu.swan.apps.core.d.e El = El();
        if (El == null) {
            return null;
        }
        return El.LY();
    }

    @Override // com.baidu.swan.apps.y.d
    public String LJ() {
        com.baidu.swan.apps.core.d.d LY = LY();
        return LY != null ? LY.LJ() : "";
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.apps.adaptation.b.d Uo() {
        com.baidu.swan.apps.adaptation.b.e hg = hg(LJ());
        if (hg == null) {
            return null;
        }
        return hg.Gy();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> Up() {
        Pair<Integer, Integer> LK = LK();
        int intValue = ((Integer) LK.first).intValue();
        int intValue2 = ((Integer) LK.second).intValue();
        if (intValue == 0) {
            intValue = af.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = af.cE(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> LK() {
        com.baidu.swan.apps.core.d.d LY = LY();
        return LY == null ? new Pair<>(0, 0) : LY.LK();
    }

    @Override // com.baidu.swan.apps.y.d
    @NonNull
    public Pair<Integer, Integer> Uq() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(af.getDisplayWidth(appContext)), Integer.valueOf(af.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.y.e.b
    public void eX(int i) {
        Uc();
        exit(false);
    }

    @Override // com.baidu.swan.apps.y.d
    public void showLoadingView() {
        SwanAppActivity aal = com.baidu.swan.apps.runtime.d.aam().aal();
        if (aal != null && !aal.isFinishing()) {
            aal.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public void Eo() {
        SwanAppActivity aal = com.baidu.swan.apps.runtime.d.aam().aal();
        if (aal != null && !aal.isFinishing()) {
            aal.Eo();
        }
    }

    @Override // com.baidu.swan.apps.y.d
    public com.baidu.swan.games.p.a Ur() {
        return null;
    }
}
