package com.baidu.swan.apps.w;

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
import com.baidu.swan.apps.ab.a;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.an.z;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.xiaomi.mipush.sdk.Constants;
/* loaded from: classes2.dex */
public abstract class a implements c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected com.baidu.swan.apps.b.c.a aAm;
    protected com.baidu.swan.games.p.a.a aAn;
    protected com.baidu.swan.apps.ae.a.a aAo = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity aAp;
    protected d aAq;
    protected boolean aAr;
    protected FullScreenFloatView aqZ;
    protected SwanAppPropertyWindow arc;
    protected boolean auT;
    protected String ayN;
    protected com.baidu.swan.apps.ae.a.c ayO;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.j.c.BU();
        this.aAq = new d();
        this.aAq.a(this);
        f.GM().GN();
    }

    private void Gl() {
        if (Gv() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bh(Context context) {
        Gl();
        this.aAq.bj(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bi(Context context) {
        this.aAq.bk(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.auT = true;
        if (this.aAq != null) {
            this.aAq.GD();
            this.aAq = null;
        }
        f.GM().GO();
        com.baidu.swan.apps.process.b.b.b.a.Js().release();
        xp();
    }

    private void xp() {
        if (this.aqZ != null) {
            ViewParent parent = this.aqZ.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.aqZ);
            }
        }
        if (this.aAm != null) {
            this.aAm.xp();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void xl() {
        Gl();
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (!TextUtils.isEmpty(Ms)) {
            this.aAr = true;
            this.aAq.GD();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Ms);
            com.baidu.swan.apps.process.messaging.client.a.Jv().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void xm() {
        String Ms = com.baidu.swan.apps.ae.b.Ms();
        if (!TextUtils.isEmpty(Ms)) {
            if (this.aAr) {
                this.aAq.GA();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, Ms);
            com.baidu.swan.apps.process.messaging.client.a.Jv().e(10, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.aAp != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.aAp != null) {
                        com.baidu.swan.apps.performance.f.aHe = true;
                        a.this.aAp.finish();
                        if (z) {
                            a.this.aAp.overridePendingTransition(0, a.C0119a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0120a interfaceC0120a) {
        Gl();
        SwanAppActivity Gv = Gv();
        if (Gv != null) {
            Gv.a(i, strArr, interfaceC0120a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void Gm() {
        this.aAr = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void Gn() {
        this.aAr = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b AI() {
        return com.baidu.swan.apps.ae.b.Mh();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion Go() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Gl();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Gl();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a Gp() {
        Gl();
        if (this.aAm == null) {
            this.aAm = com.baidu.swan.apps.core.j.c.BU().BV().aH(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.aW(true);
        }
        if (this.aAp != null) {
            this.aAm.e((ViewGroup) this.aAp.findViewById(a.f.ai_apps_activity_root));
        }
        return this.aAm;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView F(Activity activity) {
        Gl();
        if (activity == null) {
            return null;
        }
        if (this.aqZ == null) {
            this.aqZ = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.aqZ.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.aqZ.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.aqZ.setVisibility(8);
            this.aqZ.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a aAm;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.aAm == null) {
                        this.aAm = e.GJ().Gp();
                    }
                    this.aAm.xo();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void Gz() {
                }
            });
        }
        return this.aqZ;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow G(Activity activity) {
        ViewGroup viewGroup;
        Gl();
        if (activity == null) {
            return null;
        }
        if (this.arc == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.arc = new SwanAppPropertyWindow(activity);
            this.arc.setVisibility(8);
            viewGroup.addView(this.arc);
        }
        return this.arc;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean Gq() {
        Gl();
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (Mh != null) {
            bVar = Mh.vP();
        }
        return bVar != null && ((DEBUG && bVar.isDebug()) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void I(Intent intent) {
        com.baidu.swan.apps.core.j.c.BU().C(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.aAp = swanAppActivity;
        com.baidu.swan.apps.ae.b AI = AI();
        if (AI == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.vP());
            AI = AI();
        }
        if (AI != null) {
            AI.L(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c Gr() {
        return this.ayO;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d ff(String str) {
        if (this.ayO == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.MN();
        }
        return this.aAo.a(Gs(), str, this.ayO.aRy);
    }

    @Override // com.baidu.swan.apps.w.c
    public String Gs() {
        return TextUtils.isEmpty(this.ayN) ? "" : this.ayN;
    }

    @Override // com.baidu.swan.apps.w.c
    public String Gt() {
        if (this.aAp == null || this.aAp.vP() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.aAp.vP(), e.GJ().Gr());
    }

    @Override // com.baidu.swan.apps.w.c
    public String Gu() {
        return this.ayO == null ? "" : this.ayO.Gu();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.e vN() {
        if (this.aAp == null) {
            return null;
        }
        return this.aAp.vN();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity Gv() {
        return this.aAp;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b AT() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e vN = vN();
        if (vN != null && (hVar = (com.baidu.swan.apps.core.d.h) vN.k(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.AT();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b AU() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e vN = vN();
        if (vN != null && (hVar = (com.baidu.swan.apps.core.d.h) vN.k(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.AU();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e ea(String str) {
        return com.baidu.swan.apps.core.j.c.BU().ea(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout fg(String str) {
        com.baidu.swan.apps.b.c.d xx;
        com.baidu.swan.apps.b.c.e ea = ea(str);
        if (ea == null || (xx = ea.xx()) == null) {
            return null;
        }
        return xx.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.am("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.awK;
            fVar.awP = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.awK + " ; needEncode = " + z);
            }
            a(dVar.aud, fVar);
            com.baidu.swan.apps.performance.e.am("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.BU().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.BU().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.d Aw() {
        com.baidu.swan.apps.core.d.e vN = vN();
        if (vN == null) {
            return null;
        }
        return vN.Aw();
    }

    @Override // com.baidu.swan.apps.w.c
    public String Ag() {
        com.baidu.swan.apps.core.d.d Aw = Aw();
        return Aw != null ? Aw.Ag() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d Gw() {
        com.baidu.swan.apps.b.c.e ea = ea(Ag());
        if (ea == null) {
            return null;
        }
        return ea.xx();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gx() {
        Pair<Integer, Integer> Ah = Ah();
        int intValue = ((Integer) Ah.first).intValue();
        int intValue2 = ((Integer) Ah.second).intValue();
        if (intValue == 0) {
            intValue = z.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = z.bQ(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> Ah() {
        com.baidu.swan.apps.core.d.d Aw = Aw();
        return Aw == null ? new Pair<>(0, 0) : Aw.Ah();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> Gy() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(z.getDisplayWidth(appContext)), Integer.valueOf(z.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cJ(int i) {
        Gl();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        Gl();
        if (this.aAp != null) {
            this.aAp.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void vQ() {
        Gl();
        if (this.aAp != null) {
            this.aAp.vQ();
        }
    }
}
