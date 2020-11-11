package com.baidu.swan.apps.v;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.CallSuper;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.widget.AbsoluteLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ac;
import com.baidu.swan.apps.ap.ah;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.console.property.SwanAppPropertyWindow;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.res.ui.FullScreenFloatView;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.SwanAppDownloadAction;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public abstract class b implements d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected FullScreenFloatView cJI;
    protected SwanAppPropertyWindow cJK;
    protected boolean cQm;
    protected String cXm;
    protected com.baidu.swan.apps.adaptation.b.a cZk;
    protected com.baidu.swan.games.t.a.a cZl;
    protected com.baidu.swan.apps.runtime.config.a cZm = new com.baidu.swan.apps.runtime.config.a();
    @Deprecated
    protected SwanAppActivity cZn;
    protected e cZo;
    protected boolean cZp;

    /* JADX INFO: Access modifiers changed from: protected */
    public b() {
        com.baidu.swan.apps.core.turbo.d.arI();
        this.cZo = new e();
        this.cZo.a(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void azm() {
        if (azy() == null && DEBUG) {
            throw new IllegalStateException("AiBaseController: This method should be called after setActivityRef");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void ch(Context context) {
        azm();
        this.cZo.cj(context);
    }

    @Override // com.baidu.swan.apps.v.d
    public void ci(Context context) {
        this.cZo.ck(context);
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void doRelease() {
        this.cQm = true;
        if (this.cZo != null) {
            this.cZo.azI();
            this.cZo = null;
        }
        g.azX().azZ();
        com.baidu.swan.apps.process.a.b.b.a.aEX().release();
        aix();
        com.baidu.swan.apps.u.a.b.ayk().clear();
        com.baidu.swan.apps.network.c.b.a.resetCache();
        this.cZn = null;
    }

    private void aix() {
        if (this.cJI != null) {
            ViewParent parent = this.cJI.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.cJI);
            }
        }
        if (this.cZk != null) {
            this.cZk.aix();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void ain() {
        azm();
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        if (!TextUtils.isEmpty(aHw)) {
            this.cZp = true;
            this.cZo.azI();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aHw);
            bundle.putInt("task_id", azy().getTaskId());
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(9, bundle));
            com.baidu.swan.apps.t.a.axe().ain();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void aio() {
        String aHw = com.baidu.swan.apps.runtime.e.aHw();
        if (!TextUtils.isEmpty(aHw)) {
            azn();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", aHw);
            bundle.putInt("task_id", ap.aNk().aNj());
            com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(10, bundle));
            com.baidu.swan.apps.t.a.axe().aio();
            com.baidu.swan.apps.t.a.awK().a(AppRuntime.getAppContext(), null, SwanAppDownloadAction.SwanAppDownloadType.TYPE_STOP_SERVICE, null);
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azn() {
        if (azE()) {
            this.cZo.azF();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void exit() {
        exit(true);
    }

    private void exit(final boolean z) {
        if (this.cZn != null) {
            ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.v.b.1
                @Override // java.lang.Runnable
                public void run() {
                    if (b.this.cZn != null) {
                        int taskId = b.this.cZn.getTaskId();
                        b.this.cZn.finish();
                        if (z) {
                            b.this.cZn.overridePendingTransition(0, a.C0369a.aiapps_slide_out_to_right_zadjustment_top);
                        }
                        com.baidu.swan.apps.ap.b.aLZ().lm(taskId);
                    }
                }
            });
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void azo() {
        this.cZp = false;
    }

    @Override // com.baidu.swan.apps.v.d
    public void azp() {
        this.cZp = true;
    }

    @Override // com.baidu.swan.apps.v.d
    @Nullable
    public com.baidu.swan.apps.runtime.e aoc() {
        return com.baidu.swan.apps.runtime.e.aHu();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanCoreVersion azq() {
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void a(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azm();
    }

    @Override // com.baidu.swan.apps.v.d
    @CallSuper
    public void b(com.baidu.swan.apps.u.c.b bVar, com.baidu.swan.apps.r.b bVar2) {
        azm();
    }

    @Override // com.baidu.swan.apps.v.d
    @DebugTrace
    public com.baidu.swan.apps.adaptation.b.a azr() {
        azm();
        if (this.cZk == null) {
            this.cZk = com.baidu.swan.apps.core.turbo.d.arI().arJ().bv(AppRuntime.getAppContext());
            com.baidu.swan.apps.console.c.ez(true);
        }
        if (this.cZn != null) {
            this.cZk.D((ViewGroup) this.cZn.findViewById(a.f.ai_apps_activity_root));
        }
        return this.cZk;
    }

    @Override // com.baidu.swan.apps.v.d
    public FullScreenFloatView J(Activity activity) {
        azm();
        if (activity == null) {
            return null;
        }
        if (this.cJI == null) {
            this.cJI = com.baidu.swan.apps.res.ui.b.a(activity, (ViewGroup) activity.findViewById(16908290), 2);
            this.cJI.setFloatButtonText(activity.getString(a.h.aiapps_sconsole));
            this.cJI.setFloatImageBackground(a.e.aiapps_float_view_button_shape);
            this.cJI.setVisibility(8);
            this.cJI.setDragImageListener(new FullScreenFloatView.b() { // from class: com.baidu.swan.apps.v.b.2
                com.baidu.swan.apps.adaptation.b.a cZk;

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void onClick() {
                    if (this.cZk == null) {
                        this.cZk = f.azO().azr();
                    }
                    this.cZk.aiw();
                }

                @Override // com.baidu.swan.apps.res.ui.FullScreenFloatView.b
                public void azD() {
                }
            });
        }
        return this.cJI;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppPropertyWindow K(Activity activity) {
        ViewGroup viewGroup;
        azm();
        if (activity == null) {
            return null;
        }
        if (this.cJK == null && (viewGroup = (ViewGroup) activity.findViewById(a.f.ai_apps_activity_root)) != null) {
            this.cJK = new SwanAppPropertyWindow(activity);
            this.cJK.setVisibility(8);
            viewGroup.addView(this.cJK);
        }
        return this.cJK;
    }

    @Override // com.baidu.swan.apps.v.d
    public boolean azs() {
        azm();
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        b.a aVar = null;
        if (aHu != null) {
            aVar = aHu.afO();
        }
        return aVar != null && ((DEBUG && aVar.isDebug()) || com.baidu.swan.apps.f.a.c(aVar) || com.baidu.swan.apps.f.a.b(aVar));
    }

    @Override // com.baidu.swan.apps.v.d
    public void w(Intent intent) {
        com.baidu.swan.apps.core.turbo.d.arI().r(intent);
    }

    @Override // com.baidu.swan.apps.v.d
    public void i(SwanAppActivity swanAppActivity) {
        this.cZn = swanAppActivity;
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppConfigData azt() {
        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
        if (aHq.aFD()) {
            return aHq.aHm().aHD();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c pL(String str) {
        SwanAppConfigData azt = azt();
        if (azt == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aIw();
        }
        return this.cZm.a(azv(), str, azt.dtD);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.runtime.config.c pM(String str) {
        SwanAppConfigData azt = azt();
        if (azt == null) {
            if (DEBUG) {
                Log.e("AiBaseController", "mConfigData is null." + Log.getStackTraceString(new Exception()));
            }
            return com.baidu.swan.apps.runtime.config.c.aIw();
        }
        return this.cZm.b(azv(), str, azt.dtD);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public com.baidu.swan.apps.runtime.config.c a(String str, SwanAppConfigData swanAppConfigData, String str2) {
        return (swanAppConfigData == null || TextUtils.isEmpty(str2)) ? pL(str) : this.cZm.a(str2, str, swanAppConfigData.dtD);
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public final com.baidu.swan.apps.storage.b.c azu() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        return aHv == null ? new com.baidu.swan.apps.storage.b.b() : aHv.azu();
    }

    @Override // com.baidu.swan.apps.v.d
    public String azv() {
        return TextUtils.isEmpty(this.cXm) ? "" : this.cXm;
    }

    @Override // com.baidu.swan.apps.v.d
    public String azw() {
        com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
        if (aHv == null || aHv.afO() == null) {
            return null;
        }
        return com.baidu.swan.apps.u.c.b.a(aHv.afO(), f.azO().azt());
    }

    @Override // com.baidu.swan.apps.v.d
    public String azx() {
        SwanAppConfigData azt = azt();
        return azt == null ? "" : azt.azx();
    }

    public com.baidu.swan.apps.core.d.f afM() {
        if (this.cZn == null) {
            return null;
        }
        return this.cZn.afM();
    }

    @Override // com.baidu.swan.apps.v.d
    public SwanAppActivity azy() {
        return com.baidu.swan.apps.runtime.d.aHq().aHo();
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apB() {
        j jVar;
        com.baidu.swan.apps.core.d.f afM = afM();
        if (afM != null && (jVar = (j) afM.q(j.class)) != null) {
            return jVar.apB();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.view.d apC() {
        j jVar;
        com.baidu.swan.apps.core.d.f afM = afM();
        if (afM != null && (jVar = (j) afM.q(j.class)) != null) {
            return jVar.apC();
        }
        return null;
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.e nH(String str) {
        return com.baidu.swan.apps.core.turbo.d.arI().nH(str);
    }

    @Override // com.baidu.swan.apps.v.d
    public AbsoluteLayout pN(String str) {
        com.baidu.swan.apps.adaptation.b.d aiH;
        com.baidu.swan.apps.adaptation.b.e nH = nH(str);
        if (nH == null || (aiH = nH.aiH()) == null) {
            return null;
        }
        return aiH.getCurrentWebView();
    }

    /* JADX WARN: Type inference failed for: r1v1, types: [T, java.lang.String] */
    @Override // com.baidu.swan.apps.v.d
    public void a(com.baidu.swan.apps.event.a.d dVar, boolean z) {
        com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage start.");
        if (dVar != null) {
            com.baidu.swan.apps.event.a.g gVar = new com.baidu.swan.apps.event.a.g();
            gVar.mData = dVar.mData;
            gVar.cTx = z;
            if (DEBUG) {
                Log.d("AiBaseController", "handleNativeMessage data: " + dVar.mData + " ; needEncode = " + z);
            }
            a(dVar.cMh, gVar);
            com.baidu.swan.apps.performance.h.E("postMessage", "handleNativeMessage end.");
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.arI().b(aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.turbo.d.arI().a(str, aVar);
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.core.d.e apc() {
        com.baidu.swan.apps.core.d.f afM = afM();
        if (afM == null) {
            return null;
        }
        return afM.apc();
    }

    @Override // com.baidu.swan.apps.v.d
    public String aoL() {
        com.baidu.swan.apps.core.d.e apc = apc();
        return apc != null ? apc.aoL() : "";
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.apps.adaptation.b.d azz() {
        com.baidu.swan.apps.adaptation.b.e nH = nH(aoL());
        if (nH == null) {
            return null;
        }
        return nH.aiH();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azA() {
        Pair<Integer, Integer> aoN = aoN();
        int intValue = ((Integer) aoN.first).intValue();
        int intValue2 = ((Integer) aoN.second).intValue();
        if (intValue == 0) {
            intValue = ah.getDisplayWidth(AppRuntime.getAppContext());
        }
        if (intValue2 == 0) {
            intValue2 = ah.cM(AppRuntime.getAppContext());
        }
        return new Pair<>(Integer.valueOf(intValue), Integer.valueOf(intValue2));
    }

    @NonNull
    public Pair<Integer, Integer> aoN() {
        com.baidu.swan.apps.core.d.e apc = apc();
        return apc == null ? new Pair<>(0, 0) : apc.aoN();
    }

    @Override // com.baidu.swan.apps.v.d
    @NonNull
    public Pair<Integer, Integer> azB() {
        Window window;
        ViewGroup viewGroup;
        Context appContext = AppRuntime.getAppContext();
        int displayHeight = ah.getDisplayHeight(appContext);
        int i = 0;
        if (com.baidu.swan.apps.runtime.d.aHq().aHo() != null && (window = com.baidu.swan.apps.runtime.d.aHq().aHo().getWindow()) != null && (viewGroup = (ViewGroup) window.getDecorView().findViewById(16908290)) != null && viewGroup.isLaidOut()) {
            i = viewGroup.getMeasuredHeight();
        }
        if (i >= displayHeight) {
            return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(i));
        }
        return new Pair<>(Integer.valueOf(ah.getDisplayWidth(appContext)), Integer.valueOf(Build.VERSION.SDK_INT >= 28 ? ac.cJ(appContext) + displayHeight : displayHeight));
    }

    @Override // com.baidu.swan.apps.v.e.b
    public void ji(int i) {
        azm();
        com.baidu.swan.apps.ap.b.aLZ().l(this.cZn);
        exit(false);
    }

    @Override // com.baidu.swan.apps.v.d
    public void showLoadingView() {
        SwanAppActivity aHo = com.baidu.swan.apps.runtime.d.aHq().aHo();
        if (aHo != null && !aHo.isFinishing()) {
            aHo.showLoadingView();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public void afP() {
        SwanAppActivity aHo = com.baidu.swan.apps.runtime.d.aHq().aHo();
        if (aHo != null && !aHo.isFinishing()) {
            aHo.afP();
        }
    }

    @Override // com.baidu.swan.apps.v.d
    public com.baidu.swan.games.q.a azC() {
        return null;
    }
}
