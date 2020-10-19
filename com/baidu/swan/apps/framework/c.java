package com.baidu.swan.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes10.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected f cGA;
    protected a.b cGB;
    private final com.baidu.swan.apps.al.f.b cGC;
    private FrameLayout cGD;
    private com.baidu.swan.apps.statistic.a cGE;
    private d cGF;
    public final String cGG;
    private FrameLifeState cGH;
    private FrameLifeState cGI;
    private boolean cGJ;
    private boolean cGK;
    private boolean cGL;
    private final com.baidu.swan.apps.runtime.b cfY;
    protected final SwanAppActivity cpO;

    @NonNull
    protected abstract a.b aqC();

    protected abstract void aqf();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aCW());
        this.cGB = null;
        this.cGC = new com.baidu.swan.apps.al.f.b();
        this.cGH = FrameLifeState.INACTIVATED;
        this.cGI = null;
        this.cGJ = false;
        this.cGK = false;
        this.cfY = new com.baidu.swan.apps.runtime.b();
        this.cGL = true;
        this.cpO = swanAppActivity;
        this.cGG = str;
        this.cGF = new d();
        v(this.cfY);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cpO.isDestroyed()) {
                final boolean z3 = (!this.cGH.hasCreated()) | z;
                if (this.cGH.hasCreated() && z3) {
                    z2 = true;
                }
                this.cGL = aqJ();
                if (this.cGL && z2 && !aCS().aDx()) {
                    this.cfY.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void M(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aCW().aBj()) {
                                c.this.cfY.w("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.aqh();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == abk())) {
                    com.baidu.swan.apps.performance.i.a(abu(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        aqo();
    }

    public boolean aqg() {
        return this.cGK;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aCS().aDx() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cGH)) ? frameLifeState : this.cGH.hasCreated() ? this.cGH : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cGJ + " locked=" + this.cGK + " thread=" + Thread.currentThread());
            if (!this.cGK) {
                this.cGI = frameLifeState;
                this.cGK = FrameLifeState.INACTIVATED == this.cGI;
            }
            if (!this.cGJ) {
                this.cGJ = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.aqh();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aqh() {
        synchronized (this) {
            this.cGJ = true;
            while (this.cGI != null && aqI()) {
                FrameLifeState c = c(this.cGI);
                log("syncLifeState: pendingTarget=" + this.cGI + " fixedTarget=" + c);
                this.cGI = null;
                switch (c) {
                    case JUST_CREATED:
                        aqm();
                        aqi();
                        break;
                    case JUST_STARTED:
                        aql();
                        aqj();
                        break;
                    case JUST_RESUMED:
                        aqk();
                        break;
                    default:
                        aqn();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cGH);
            this.cGK = FrameLifeState.INACTIVATED == this.cGI;
            this.cGJ = false;
        }
    }

    private synchronized void aqi() {
        if (!this.cGH.hasCreated()) {
            aqp();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            aqf();
            this.cGH = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aqj() {
        aqi();
        if (!this.cGH.hasStarted()) {
            aqq();
            this.cGH = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aqk() {
        aqj();
        if (!this.cGH.hasResumed()) {
            aqr();
            this.cGH = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void aql() {
        if (this.cGH.hasResumed()) {
            aqs();
            this.cGH = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aqm() {
        aql();
        if (this.cGH.hasStarted()) {
            aqt();
            this.cGH = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aqn() {
        aqm();
        if (this.cGH.hasCreated()) {
            aqu();
            this.cGH = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("onUpdateInternalStart").fw(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a abu = abu();
            if (!z2) {
                aqH();
            }
            if (!TextUtils.isEmpty(abu.auy())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(abu.auy());
            }
        }
        com.baidu.swan.apps.v.f.avu().i(this.cpO);
        qc.f(new UbcFlowEvent("onUpdateStart").fw(true));
        p(z, z2);
        qc.f(new UbcFlowEvent("onUpdateEnd").fw(true));
    }

    private synchronized void aqo() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.ams();
    }

    @DebugTrace
    private synchronized void aqp() {
        log("onCreateInternal");
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("frame_start_create"));
        qc.f(new UbcFlowEvent("onCreateInternalStart").fw(true));
        this.cGF.aqd();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.ahz()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        aqE();
        com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
        if (!aCW.aBj() || !aCW.aCS().available()) {
            com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(11L).tt("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aHz().j(tt);
            h.b(new com.baidu.swan.apps.statistic.a.d().sB(h.kd(abk())).i(tt).a(abu()));
            com.baidu.swan.apps.performance.i.d(tt);
            com.baidu.swan.apps.ap.e.N(this.cpO);
        } else {
            aqx();
            qc.f(new UbcFlowEvent("onCreateStart").fw(true));
            onCreate();
            qc.f(new UbcFlowEvent("onCreateEnd").fw(true));
            com.baidu.swan.apps.ap.d abj = this.cpO.abj();
            if (abj != null) {
                abj.aHM();
            }
            qc.f(new UbcFlowEvent("onCreateInternalEnd").fw(true));
        }
    }

    private synchronized void aqq() {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("onStartStart").fw(true));
        log("onStartInternal");
        this.cGF.aqe();
        onStart();
        qc.f(new UbcFlowEvent("onStartEnd").fw(true));
    }

    private synchronized void aqr() {
        HybridUbcFlow qc = com.baidu.swan.apps.performance.i.qc("startup");
        qc.f(new UbcFlowEvent("onResumeInternalStart").fw(true));
        log("onResumeInternal");
        this.cGF.afm();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.cGE = h.su("607");
        aqD();
        if (aBj()) {
            aCS().L(this.cpO);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.ayq().ays();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cpO != null && com.baidu.swan.apps.runtime.e.aDa() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aDa(), com.baidu.swan.apps.env.c.c.aps().ib(10).apt());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aFy().sk("na_page_show");
        com.baidu.swan.apps.v.f.avu().adT();
        qc.f(new UbcFlowEvent("onResumeStart").fw(true));
        onResume();
        qc.f(new UbcFlowEvent("onResumeEnd").fw(true));
    }

    private synchronized void aqs() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.avu().adU();
        this.cGF.agE();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.cGE != null && aBj()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a abu = abu();
            aVar.mFrom = h.kd(abk());
            aVar.mAppId = abu.getAppId();
            aVar.mSource = abu.auj();
            aVar.c(abu);
            aVar.sF(abu.aup().getString("ubc"));
            aVar.bY(h.sw(abu.aul()));
            h.a(this.cGE, aVar);
            this.cGE = null;
        }
    }

    private synchronized void aqt() {
        com.baidu.swan.apps.performance.i.azn();
        log("onStopInternal");
        onStop();
        this.cGF.aiG();
    }

    private synchronized void aqu() {
        log("onDestroyInternal");
        onDestroy();
        this.cGF.afl();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.ayq().release();
        com.baidu.swan.apps.core.i.a.amD().release();
        com.baidu.swan.apps.api.b.c.afU().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        aqv();
        aqy();
        com.baidu.swan.apps.v.f.release();
    }

    private void aqv() {
        com.baidu.swan.apps.scheme.actions.k.c.dhP = null;
        com.baidu.swan.apps.performance.i.cUI = null;
    }

    public synchronized FrameLifeState aqw() {
        return this.cGH;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cGF.onKeyDown(i, keyEvent);
    }

    public void aqx() {
        if (this.cGB == null) {
            this.cGB = aqC();
        }
        aCR().a((a.c) null, this.cGB);
    }

    public void aqy() {
        aCR().aqy();
        this.cGB = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqz() {
        aqA();
        aqB();
    }

    private void aqA() {
        com.baidu.swan.apps.adaptation.a.b adD = aCY().abL().adD();
        if (adD != null) {
            adD.bl(this.cpO);
        }
    }

    protected void aqB() {
        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
        com.baidu.swan.apps.a.b bVar = null;
        if (aDa != null) {
            bVar = aDa.aDn();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void aqD() {
        if (aCS().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.abu(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cpO != null && com.baidu.swan.apps.runtime.e.aDb() != null) {
                                c.this.l(a2);
                            }
                        }
                    });
                }
            }, "updateTaskDescription", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (aCS().available()) {
            setTaskDescription(this.cpO, abu().aoj(), bitmap, (int) abu().aui());
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

    private void aqE() {
        this.cGA = new f(this.cpO);
        aqF();
    }

    protected void aqF() {
    }

    public f abs() {
        if (this.cGA == null) {
            aqE();
        }
        return this.cGA;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        abw().kJ(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aqG() {
        if (this.cGA.akK() != 1) {
            return false;
        }
        this.cpO.moveTaskToBack(true);
        this.cpO.gU(2);
        ap.aIQ().kW(1);
        return true;
    }

    public b.a abu() {
        return aCS().aDe();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aBj()) {
            b.a abu = abu();
            fVar.mFrom = h.kd(abk());
            fVar.mAppId = abu.getAppId();
            fVar.mSource = abu.auj();
            fVar.bY(h.sw(abu.aul()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.sF(abu.aup().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.cGD = (FrameLayout) this.cpO.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cpO, this.cGD);
    }

    public void abv() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cGD);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b abw() {
        return this.cGC;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cGF.c(bVar);
    }

    public void b(b bVar) {
        this.cGF.d(bVar);
    }

    public boolean nL(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aqH() {
    }

    public void afn() {
        this.cGF.afn();
    }

    public boolean aqI() {
        return com.baidu.swan.apps.v.f.avu().avw();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean aqJ() {
        return com.baidu.swan.apps.performance.b.b.azC() ? com.baidu.swan.apps.performance.b.b.aqJ() : com.baidu.swan.apps.t.a.asi().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
