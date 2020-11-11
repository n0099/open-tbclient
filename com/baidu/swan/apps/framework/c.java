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
    protected final SwanAppActivity cEi;
    protected f cUP;
    protected a.b cUQ;
    private final com.baidu.swan.apps.al.f.b cUR;
    private FrameLayout cUS;
    private com.baidu.swan.apps.statistic.a cUT;
    private d cUU;
    public final String cUV;
    private FrameLifeState cUW;
    private FrameLifeState cUX;
    private boolean cUY;
    private boolean cUZ;
    private boolean cVa;
    private final com.baidu.swan.apps.runtime.b cux;

    protected abstract void auA();

    @NonNull
    protected abstract a.b auX();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aHq());
        this.cUQ = null;
        this.cUR = new com.baidu.swan.apps.al.f.b();
        this.cUW = FrameLifeState.INACTIVATED;
        this.cUX = null;
        this.cUY = false;
        this.cUZ = false;
        this.cux = new com.baidu.swan.apps.runtime.b();
        this.cVa = true;
        this.cEi = swanAppActivity;
        this.cUV = str;
        this.cUU = new d();
        v(this.cux);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cEi.isDestroyed()) {
                final boolean z3 = (!this.cUW.hasCreated()) | z;
                if (this.cUW.hasCreated() && z3) {
                    z2 = true;
                }
                this.cVa = ave();
                if (this.cVa && z2 && !aHm().aHR()) {
                    this.cux.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void M(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aHq().aFD()) {
                                c.this.cux.x("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.auC();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == afE())) {
                    com.baidu.swan.apps.performance.i.a(afO(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        auJ();
    }

    public boolean auB() {
        return this.cUZ;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aHm().aHR() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cUW)) ? frameLifeState : this.cUW.hasCreated() ? this.cUW : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cUY + " locked=" + this.cUZ + " thread=" + Thread.currentThread());
            if (!this.cUZ) {
                this.cUX = frameLifeState;
                this.cUZ = FrameLifeState.INACTIVATED == this.cUX;
            }
            if (!this.cUY) {
                this.cUY = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.auC();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void auC() {
        synchronized (this) {
            this.cUY = true;
            while (this.cUX != null && avd()) {
                FrameLifeState c = c(this.cUX);
                log("syncLifeState: pendingTarget=" + this.cUX + " fixedTarget=" + c);
                this.cUX = null;
                switch (c) {
                    case JUST_CREATED:
                        auH();
                        auD();
                        break;
                    case JUST_STARTED:
                        auG();
                        auE();
                        break;
                    case JUST_RESUMED:
                        auF();
                        break;
                    default:
                        auI();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cUW);
            this.cUZ = FrameLifeState.INACTIVATED == this.cUX;
            this.cUY = false;
        }
    }

    private synchronized void auD() {
        if (!this.cUW.hasCreated()) {
            auK();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            auA();
            this.cUW = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void auE() {
        auD();
        if (!this.cUW.hasStarted()) {
            auL();
            this.cUW = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void auF() {
        auE();
        if (!this.cUW.hasResumed()) {
            auM();
            this.cUW = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void auG() {
        if (this.cUW.hasResumed()) {
            auN();
            this.cUW = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void auH() {
        auG();
        if (this.cUW.hasStarted()) {
            auO();
            this.cUW = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void auI() {
        auH();
        if (this.cUW.hasCreated()) {
            auP();
            this.cUW = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("onUpdateInternalStart").fS(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a afO = afO();
            if (!z2) {
                avc();
            }
            if (!TextUtils.isEmpty(afO.ayS())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(afO.ayS());
            }
        }
        com.baidu.swan.apps.v.f.azO().i(this.cEi);
        qJ.f(new UbcFlowEvent("onUpdateStart").fS(true));
        p(z, z2);
        qJ.f(new UbcFlowEvent("onUpdateEnd").fS(true));
    }

    private synchronized void auJ() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.aqN();
    }

    @DebugTrace
    private synchronized void auK() {
        log("onCreateInternal");
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("frame_start_create"));
        qJ.f(new UbcFlowEvent("onCreateInternalStart").fS(true));
        this.cUU.auy();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.alT()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        auZ();
        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
        if (!aHq.aFD() || !aHq.aHm().available()) {
            com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(5L).cw(11L).ua("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aLT().j(ua);
            h.b(new com.baidu.swan.apps.statistic.a.d().ti(h.ky(afE())).i(ua).a(afO()));
            com.baidu.swan.apps.performance.i.d(ua);
            com.baidu.swan.apps.ap.e.N(this.cEi);
        } else {
            auS();
            qJ.f(new UbcFlowEvent("onCreateStart").fS(true));
            onCreate();
            qJ.f(new UbcFlowEvent("onCreateEnd").fS(true));
            com.baidu.swan.apps.ap.d afD = this.cEi.afD();
            if (afD != null) {
                afD.aMg();
            }
            qJ.f(new UbcFlowEvent("onCreateInternalEnd").fS(true));
        }
    }

    private synchronized void auL() {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("onStartStart").fS(true));
        log("onStartInternal");
        this.cUU.auz();
        onStart();
        qJ.f(new UbcFlowEvent("onStartEnd").fS(true));
    }

    private synchronized void auM() {
        HybridUbcFlow qJ = com.baidu.swan.apps.performance.i.qJ("startup");
        qJ.f(new UbcFlowEvent("onResumeInternalStart").fS(true));
        log("onResumeInternal");
        this.cUU.ajG();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.cUT = h.tb("607");
        auY();
        if (aFD()) {
            aHm().L(this.cEi);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aCK().aCM();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cEi != null && com.baidu.swan.apps.runtime.e.aHu() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aHu(), com.baidu.swan.apps.env.c.c.atN().iw(10).atO());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.qJ("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aJS().sS("na_page_show");
        com.baidu.swan.apps.v.f.azO().ain();
        qJ.f(new UbcFlowEvent("onResumeStart").fS(true));
        onResume();
        qJ.f(new UbcFlowEvent("onResumeEnd").fS(true));
    }

    private synchronized void auN() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.azO().aio();
        this.cUU.akY();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.cUT != null && aFD()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a afO = afO();
            aVar.mFrom = h.ky(afE());
            aVar.mAppId = afO.getAppId();
            aVar.mSource = afO.ayD();
            aVar.c(afO);
            aVar.tm(afO.ayJ().getString("ubc"));
            aVar.ch(h.td(afO.ayF()));
            h.a(this.cUT, aVar);
            this.cUT = null;
        }
    }

    private synchronized void auO() {
        com.baidu.swan.apps.performance.i.aDH();
        log("onStopInternal");
        onStop();
        this.cUU.ana();
    }

    private synchronized void auP() {
        log("onDestroyInternal");
        onDestroy();
        this.cUU.ajF();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aCK().release();
        com.baidu.swan.apps.core.i.a.aqY().release();
        com.baidu.swan.apps.api.b.c.ako().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        auQ();
        auT();
        com.baidu.swan.apps.v.f.release();
    }

    private void auQ() {
        com.baidu.swan.apps.scheme.actions.k.c.dwm = null;
        com.baidu.swan.apps.performance.i.dje = null;
    }

    public synchronized FrameLifeState auR() {
        return this.cUW;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cUU.onKeyDown(i, keyEvent);
    }

    public void auS() {
        if (this.cUQ == null) {
            this.cUQ = auX();
        }
        aHl().a((a.c) null, this.cUQ);
    }

    public void auT() {
        aHl().auT();
        this.cUQ = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auU() {
        auV();
        auW();
    }

    private void auV() {
        com.baidu.swan.apps.adaptation.a.b ahX = aHs().agf().ahX();
        if (ahX != null) {
            ahX.bl(this.cEi);
        }
    }

    protected void auW() {
        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
        com.baidu.swan.apps.a.b bVar = null;
        if (aHu != null) {
            bVar = aHu.aHH();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void auY() {
        if (aHm().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.afO(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cEi != null && com.baidu.swan.apps.runtime.e.aHv() != null) {
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
        if (aHm().available()) {
            setTaskDescription(this.cEi, afO().asF(), bitmap, (int) afO().ayC());
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

    private void auZ() {
        this.cUP = new f(this.cEi);
        ava();
    }

    protected void ava() {
    }

    public f afM() {
        if (this.cUP == null) {
            auZ();
        }
        return this.cUP;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        afQ().le(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avb() {
        if (this.cUP.ape() != 1) {
            return false;
        }
        this.cEi.moveTaskToBack(true);
        this.cEi.hp(2);
        ap.aNk().lr(1);
        return true;
    }

    public b.a afO() {
        return aHm().aHy();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aFD()) {
            b.a afO = afO();
            fVar.mFrom = h.ky(afE());
            fVar.mAppId = afO.getAppId();
            fVar.mSource = afO.ayD();
            fVar.ch(h.td(afO.ayF()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.tm(afO.ayJ().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.cUS = (FrameLayout) this.cEi.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cEi, this.cUS);
    }

    public void afP() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cUS);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b afQ() {
        return this.cUR;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cUU.c(bVar);
    }

    public void b(b bVar) {
        this.cUU.d(bVar);
    }

    public boolean ou(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avc() {
    }

    public void ajH() {
        this.cUU.ajH();
    }

    public boolean avd() {
        return com.baidu.swan.apps.v.f.azO().azQ();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean ave() {
        return com.baidu.swan.apps.performance.b.b.aDW() ? com.baidu.swan.apps.performance.b.b.ave() : com.baidu.swan.apps.t.a.awD().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
