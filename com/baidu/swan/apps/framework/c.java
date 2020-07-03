package com.baidu.swan.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.b bLO;
    protected final SwanAppActivity bUR;
    protected com.baidu.swan.apps.core.d.e ciX;
    protected a.b ciY;
    private final com.baidu.swan.apps.am.f.b ciZ;
    private com.baidu.swan.apps.ad.c cja;
    private FrameLayout cjb;
    private com.baidu.swan.apps.statistic.a cjc;
    private d cjd;
    public final String cje;
    private FrameLifeState cjf;
    private FrameLifeState cjg;
    private boolean cjh;
    private boolean cji;
    private boolean cjj;

    @NonNull
    protected abstract a.b aeO();

    protected abstract void aeq();

    protected abstract void m(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.apI());
        this.ciY = null;
        this.ciZ = new com.baidu.swan.apps.am.f.b();
        this.cjf = FrameLifeState.INACTIVATED;
        this.cjg = null;
        this.cjh = false;
        this.cji = false;
        this.bLO = new com.baidu.swan.apps.runtime.b();
        this.cjj = true;
        this.bUR = swanAppActivity;
        this.cje = str;
        this.cjd = new d();
        n(this.bLO);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.bUR.isDestroyed()) {
                final boolean z3 = (!this.cjf.hasCreated()) | z;
                if (this.cjf.hasCreated() && z3) {
                    z2 = true;
                }
                this.cjj = com.baidu.swan.apps.u.a.aga().getSwitch("swan_fixed_relaunch_switch", true);
                if (this.cjj && z2 && !apE().aqj()) {
                    this.bLO.a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.aq.e.b
                        /* renamed from: b */
                        public void H(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.apI().aok()) {
                                c.this.bLO.u("event_first_action_launched");
                                c.this.n(z3, z2);
                                c.this.aes();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    n(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == RF())) {
                    g.i(RP());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        aez();
    }

    public boolean aer() {
        return this.cji;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || apE().aqj() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cjf)) ? frameLifeState : this.cjf.hasCreated() ? this.cjf : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cjh + " locked=" + this.cji + " thread=" + Thread.currentThread());
            if (!this.cji) {
                this.cjg = frameLifeState;
                this.cji = FrameLifeState.INACTIVATED == this.cjg;
            }
            if (!this.cjh) {
                this.cjh = true;
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.aes();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aes() {
        synchronized (this) {
            this.cjh = true;
            while (this.cjg != null && aeU()) {
                FrameLifeState c = c(this.cjg);
                log("syncLifeState: pendingTarget=" + this.cjg + " fixedTarget=" + c);
                this.cjg = null;
                switch (c) {
                    case JUST_CREATED:
                        aex();
                        aet();
                        break;
                    case JUST_STARTED:
                        aew();
                        aeu();
                        break;
                    case JUST_RESUMED:
                        aev();
                        break;
                    default:
                        aey();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cjf);
            this.cji = FrameLifeState.INACTIVATED == this.cjg;
            this.cjh = false;
        }
    }

    private synchronized void aet() {
        if (!this.cjf.hasCreated()) {
            aeA();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            aeq();
            this.cjf = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aeu() {
        aet();
        if (!this.cjf.hasStarted()) {
            aeB();
            this.cjf = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aev() {
        aeu();
        if (!this.cjf.hasResumed()) {
            aeC();
            this.cjf = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void aew() {
        if (this.cjf.hasResumed()) {
            aeD();
            this.cjf = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aex() {
        aew();
        if (this.cjf.hasStarted()) {
            aeE();
            this.cjf = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aey() {
        aex();
        if (this.cjf.hasCreated()) {
            aeF();
            this.cjf = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(boolean z, boolean z2) {
        HybridUbcFlow mx = g.mx("startup");
        mx.f(new UbcFlowEvent("onUpdateInternalStart").ez(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a RP = RP();
            if (!z2) {
                aeT();
            }
            if (!TextUtils.isEmpty(RP.aif())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(RP.aif());
            }
        }
        f.ajb().h(this.bUR);
        mx.f(new UbcFlowEvent("onUpdateStart").ez(true));
        m(z, z2);
        mx.f(new UbcFlowEvent("onUpdateEnd").ez(true));
    }

    private synchronized void aez() {
        log("onReleaseInternal");
        onRelease();
        f.release();
    }

    @DebugTrace
    private synchronized void aeA() {
        log("onCreateInternal");
        HybridUbcFlow mx = g.mx("startup");
        mx.f(new UbcFlowEvent("frame_start_create"));
        mx.f(new UbcFlowEvent("onCreateInternalStart").ez(true));
        this.cjd.aen();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.Xs()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        aeQ();
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        if (!apI.aok() || !apI.apE().available()) {
            com.baidu.swan.apps.an.a pB = new com.baidu.swan.apps.an.a().bw(5L).bx(11L).pB("aiapp data is invalid");
            com.baidu.swan.apps.an.e.atW().g(pB);
            h.b(new com.baidu.swan.apps.statistic.a.d().oK(h.hf(RF())).f(pB).a(RP()));
            g.a(pB);
            com.baidu.swan.apps.aq.d.N(this.bUR);
        } else {
            aeI();
            mx.f(new UbcFlowEvent("onCreateStart").ez(true));
            onCreate();
            mx.f(new UbcFlowEvent("onCreateEnd").ez(true));
            com.baidu.swan.apps.aq.c RE = this.bUR.RE();
            if (RE != null) {
                RE.auh();
            }
            mx.f(new UbcFlowEvent("onCreateInternalEnd").ez(true));
        }
    }

    private synchronized void aeB() {
        HybridUbcFlow mx = g.mx("startup");
        mx.f(new UbcFlowEvent("onStartStart").ez(true));
        log("onStartInternal");
        this.cjd.aeo();
        onStart();
        mx.f(new UbcFlowEvent("onStartEnd").ez(true));
    }

    private synchronized void aeC() {
        HybridUbcFlow mx = g.mx("startup");
        mx.f(new UbcFlowEvent("onResumeInternalStart").ez(true));
        log("onResumeInternal");
        this.cjd.Vg();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.cjc = h.oE("607");
        aeP();
        if (aok()) {
            apE().onActivityResume(this.bUR);
        }
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.alJ().alL();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bUR != null && com.baidu.swan.apps.runtime.e.apM() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.apM());
                }
            }
        }, "saveSwanAppHistory");
        g.mx("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.al.a.arZ().ow("na_page_show");
        f.ajb().TW();
        mx.f(new UbcFlowEvent("onResumeStart").ez(true));
        onResume();
        mx.f(new UbcFlowEvent("onResumeEnd").ez(true));
    }

    private synchronized void aeD() {
        log("onPauseInternal");
        onPause();
        f.ajb().TX();
        this.cjd.Wx();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.cjc != null && aok()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a RP = RP();
            aVar.mFrom = h.hf(RF());
            aVar.mAppId = RP.getAppId();
            aVar.mSource = RP.ahQ();
            aVar.c(RP);
            aVar.oO(RP.ahW().getString("ubc"));
            aVar.bB(h.oF(RP.ahS()));
            h.a(this.cjc, aVar);
            this.cjc = null;
        }
    }

    private synchronized void aeE() {
        g.amE();
        log("onStopInternal");
        onStop();
        this.cjd.aep();
    }

    private synchronized void aeF() {
        log("onDestroyInternal");
        onDestroy();
        this.cjd.Vf();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.alJ().release();
        com.baidu.swan.apps.core.i.a.abH().release();
        com.baidu.swan.apps.api.b.c.VM().release();
        com.baidu.swan.apps.performance.d.d.releaseInstance();
        aeG();
        aeJ();
        f.release();
    }

    private void aeG() {
        com.baidu.swan.apps.scheme.actions.k.c.cHF = null;
        g.cwu = null;
    }

    public synchronized FrameLifeState aeH() {
        return this.cjf;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cjd.onKeyDown(i, keyEvent);
    }

    public void aeI() {
        if (this.ciY == null) {
            this.ciY = aeO();
        }
        apD().a((a.c) null, this.ciY);
    }

    public void aeJ() {
        apD().aeJ();
        this.ciY = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeK() {
        b.a RP;
        Bundle ahV;
        if (aok() && (ahV = (RP = RP()).ahV()) != null && ahV.getLong("launch_flag_for_statistic") > 0) {
            long j = RP.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.hf(RF());
            fVar.mAppId = RP.getAppId();
            if (com.baidu.swan.apps.af.a.a.mZ(RP().aif())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = RP.ahQ();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.cLn = String.valueOf(currentTimeMillis - j);
            fVar.v("status", "0");
            fVar.oO(RP.ahW().getString("ubc"));
            fVar.bB(h.oF(RP.ahS()));
            h.onEvent(fVar);
            ahV.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeL() {
        aeM();
        aeN();
    }

    private void aeM() {
        com.baidu.swan.apps.adaptation.a.b TG = apK().Se().TG();
        if (TG != null) {
            TG.ba(this.bUR);
        }
    }

    protected void aeN() {
        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
        com.baidu.swan.apps.a.b bVar = null;
        if (apM != null) {
            bVar = apM.apZ();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void aeP() {
        if (apE().available()) {
            setTaskDescription(this.bUR, RP().acZ(), aj.a((com.baidu.swan.apps.v.b.b) RP(), "SwanActivityFrame", true), (int) RP().ahP());
        }
    }

    private static void setTaskDescription(Activity activity, String str, Bitmap bitmap, int i) {
        if (i != 0 && Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    private void aeQ() {
        this.ciX = new com.baidu.swan.apps.core.d.e(this.bUR);
        aeR();
    }

    protected void aeR() {
    }

    public com.baidu.swan.apps.core.d.e RN() {
        if (this.ciX == null) {
            aeQ();
        }
        return this.ciX;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        RR().hJ(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aeS() {
        if (this.ciX.ZY() != 1) {
            return false;
        }
        this.bUR.moveTaskToBack(true);
        this.bUR.ep(2);
        an.ave().hV(1);
        return true;
    }

    public b.a RP() {
        return apE().apQ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aok()) {
            b.a RP = RP();
            fVar.mFrom = h.hf(RF());
            fVar.mAppId = RP.getAppId();
            fVar.mSource = RP.ahQ();
            fVar.bB(h.oF(RP.ahS()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.oO(RP.ahW().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.cja == null) {
                this.cja = new com.baidu.swan.apps.ad.c();
            }
            this.cja.a(this.bUR, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.cja != null) {
            this.cja.a(this.bUR, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.cjb = (FrameLayout) this.bUR.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bUR, this.cjb);
    }

    public void RQ() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cjb);
    }

    @NonNull
    public com.baidu.swan.apps.am.f.b RR() {
        return this.ciZ;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cjd.c(bVar);
    }

    public void b(b bVar) {
        this.cjd.d(bVar);
    }

    public boolean kv(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aeT() {
    }

    public void Vh() {
        this.cjd.Vh();
    }

    public boolean aeU() {
        return f.ajb().ajd();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
