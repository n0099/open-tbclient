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
    protected FullScreenFloatView apY;
    protected SwanAppPropertyWindow aqb;
    protected boolean atS;
    protected String axI;
    protected com.baidu.swan.apps.ae.a.c axJ;
    protected com.baidu.swan.apps.b.c.a azh;
    protected com.baidu.swan.games.p.a.a azi;
    protected com.baidu.swan.apps.ae.a.a azj = new com.baidu.swan.apps.ae.a.a();
    protected SwanAppActivity azk;
    protected d azl;
    protected boolean azm;

    /* JADX INFO: Access modifiers changed from: protected */
    public a() {
        com.baidu.swan.apps.core.j.c.Bi();
        this.azl = new d();
        this.azl.a(this);
        f.FY().FZ();
    }

    private void Fx() {
        if (FH() == null && DEBUG) {
            throw new IllegalStateException("This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void bh(Context context) {
        Fx();
        this.azl.bj(context);
    }

    @Override // com.baidu.swan.apps.w.c
    public void bi(Context context) {
        this.azl.bk(context);
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void doRelease() {
        this.atS = true;
        if (this.azl != null) {
            this.azl.FP();
            this.azl = null;
        }
        f.FY().Ga();
        com.baidu.swan.apps.process.b.b.b.a.IB().release();
        wK();
    }

    private void wK() {
        if (this.apY != null) {
            ViewParent parent = this.apY.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.apY);
            }
        }
        if (this.azh != null) {
            this.azh.wK();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void wG() {
        Fx();
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (!TextUtils.isEmpty(LB)) {
            this.azm = true;
            this.azl.FP();
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, LB);
            com.baidu.swan.apps.process.messaging.client.a.IE().e(9, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void wH() {
        String LB = com.baidu.swan.apps.ae.b.LB();
        if (!TextUtils.isEmpty(LB)) {
            if (this.azm) {
                this.azl.FM();
            }
            Bundle bundle = new Bundle();
            bundle.putString(Constants.APP_ID, LB);
            com.baidu.swan.apps.process.messaging.client.a.IE().e(10, bundle);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.azk != null) {
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.w.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (a.this.azk != null) {
                        com.baidu.swan.apps.performance.f.aFY = true;
                        a.this.azk.finish();
                        if (z) {
                            a.this.azk.overridePendingTransition(0, a.C0108a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(int i, @NonNull String[] strArr, a.InterfaceC0109a interfaceC0109a) {
        Fx();
        SwanAppActivity FH = FH();
        if (FH != null) {
            FH.a(i, strArr, interfaceC0109a);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void Fy() {
        this.azm = false;
    }

    @Override // com.baidu.swan.apps.w.c
    public void Fz() {
        this.azm = true;
    }

    @Override // com.baidu.swan.apps.w.c
    @Nullable
    public com.baidu.swan.apps.ae.b zX() {
        return com.baidu.swan.apps.ae.b.Lq();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanCoreVersion FA() {
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void a(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Fx();
    }

    @Override // com.baidu.swan.apps.w.c
    @CallSuper
    public void b(com.baidu.swan.apps.v.b.b bVar, com.baidu.swan.apps.install.b bVar2) {
        Fx();
    }

    @Override // com.baidu.swan.apps.w.c
    @DebugTrace
    public com.baidu.swan.apps.b.c.a FB() {
        Fx();
        if (this.azh == null) {
            this.azh = com.baidu.swan.apps.core.j.c.Bi().Bj().aH(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.aT(true);
        }
        if (this.azk != null) {
            this.azh.e((ViewGroup) this.azk.findViewById(a.f.ai_apps_activity_root));
        }
        return this.azh;
    }

    @Override // com.baidu.swan.apps.w.c
    public FullScreenFloatView C(Activity activity) {
        Fx();
        if (activity == null) {
            return null;
        }
        if (this.apY == null) {
            this.apY = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.apY.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.apY.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.apY.setVisibility(8);
            this.apY.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.w.a.2
                com.baidu.swan.apps.b.c.a azh;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.azh == null) {
                        this.azh = e.FV().FB();
                    }
                    this.azh.wJ();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void FL() {
                }
            });
        }
        return this.apY;
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppPropertyWindow D(Activity activity) {
        ViewGroup viewGroup;
        Fx();
        if (activity == null) {
            return null;
        }
        if (this.aqb == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.aqb = new SwanAppPropertyWindow(activity);
            this.aqb.setVisibility(8);
            viewGroup.addView(this.aqb);
        }
        return this.aqb;
    }

    @Override // com.baidu.swan.apps.w.c
    public boolean FC() {
        Fx();
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        com.baidu.swan.apps.v.b.b bVar = null;
        if (Lq != null) {
            bVar = Lq.vk();
        }
        return bVar != null && ((DEBUG && bVar.isDebug()) || com.baidu.swan.apps.f.a.c(bVar) || com.baidu.swan.apps.f.a.b(bVar));
    }

    @Override // com.baidu.swan.apps.w.c
    public void I(Intent intent) {
        com.baidu.swan.apps.core.j.c.Bi().C(intent);
    }

    @Override // com.baidu.swan.apps.w.c
    public void f(SwanAppActivity swanAppActivity) {
        this.azk = swanAppActivity;
        com.baidu.swan.apps.ae.b zX = zX();
        if (zX == null && swanAppActivity != null) {
            com.baidu.swan.apps.ae.b.n(swanAppActivity.vk());
            zX = zX();
        }
        if (zX != null) {
            zX.I(swanAppActivity);
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.ae.a.c FD() {
        return this.axJ;
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public com.baidu.swan.apps.ae.a.d eZ(String str) {
        if (this.axJ == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.ae.a.d.LV();
        }
        return this.azj.a(FE(), str, this.axJ.aQq);
    }

    @Override // com.baidu.swan.apps.w.c
    public String FE() {
        return TextUtils.isEmpty(this.axI) ? "" : this.axI;
    }

    @Override // com.baidu.swan.apps.w.c
    public String FF() {
        if (this.azk == null || this.azk.vk() == null) {
            return null;
        }
        return com.baidu.swan.apps.v.b.b.a(this.azk.vk(), e.FV().FD());
    }

    @Override // com.baidu.swan.apps.w.c
    public String FG() {
        return this.axJ == null ? "" : this.axJ.FG();
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.e vi() {
        if (this.azk == null) {
            return null;
        }
        return this.azk.vi();
    }

    @Override // com.baidu.swan.apps.w.c
    public SwanAppActivity FH() {
        return this.azk;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b Ai() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e vi = vi();
        if (vi != null && (hVar = (com.baidu.swan.apps.core.d.h) vi.k(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.Ai();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.games.view.b Aj() {
        com.baidu.swan.apps.core.d.h hVar;
        com.baidu.swan.apps.core.d.e vi = vi();
        if (vi != null && (hVar = (com.baidu.swan.apps.core.d.h) vi.k(com.baidu.swan.apps.core.d.h.class)) != null) {
            return hVar.Aj();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.e dU(String str) {
        return com.baidu.swan.apps.core.j.c.Bi().dU(str);
    }

    @Override // com.baidu.swan.apps.w.c
    public AbsoluteLayout fa(String str) {
        com.baidu.swan.apps.b.c.d wS;
        com.baidu.swan.apps.b.c.e dU = dU(str);
        if (dU == null || (wS = dU.wS()) == null) {
            return null;
        }
        return wS.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.e.am("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.m.a.f fVar = new com.baidu.swan.apps.m.a.f();
            fVar.mData = dVar.avH;
            fVar.avM = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.avH + " ; needEncode = " + z);
            }
            a(dVar.atc, fVar);
            com.baidu.swan.apps.performance.e.am("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.Bi().a(aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        com.baidu.swan.apps.core.j.c.Bi().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.core.d.d zL() {
        com.baidu.swan.apps.core.d.e vi = vi();
        if (vi == null) {
            return null;
        }
        return vi.zL();
    }

    @Override // com.baidu.swan.apps.w.c
    public String zv() {
        com.baidu.swan.apps.core.d.d zL = zL();
        return zL != null ? zL.zv() : "";
    }

    @Override // com.baidu.swan.apps.w.c
    public com.baidu.swan.apps.b.c.d FI() {
        com.baidu.swan.apps.b.c.e dU = dU(zv());
        if (dU == null) {
            return null;
        }
        return dU.wS();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> FJ() {
        Pair<Integer, Integer> zw = zw();
        int intValue = ((Integer) zw.first).intValue();
        int intValue2 = ((Integer) zw.second).intValue();
        if (intValue == 0) {
            intValue = z.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = z.bQ(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> zw() {
        com.baidu.swan.apps.core.d.d zL = zL();
        return zL == null ? new Pair<>(0, 0) : zL.zw();
    }

    @Override // com.baidu.swan.apps.w.c
    @NonNull
    public Pair<Integer, Integer> FK() {
        Context appContext = AppRuntime.getAppContext();
        return new Pair<>(Integer.valueOf(z.getDisplayWidth(appContext)), Integer.valueOf(z.getDisplayHeight(appContext)));
    }

    @Override // com.baidu.swan.apps.w.d.b
    public void cH(int i) {
        Fx();
        exit(false);
    }

    @Override // com.baidu.swan.apps.w.c
    public void showLoadingView() {
        Fx();
        if (this.azk != null) {
            this.azk.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.w.c
    public void vl() {
        Fx();
        if (this.azk != null) {
            this.azk.vl();
        }
    }
}
