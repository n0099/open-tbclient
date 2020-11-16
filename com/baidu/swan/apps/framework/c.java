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
/* loaded from: classes7.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity cCy;
    protected f cTf;
    protected a.b cTg;
    private final com.baidu.swan.apps.al.f.b cTh;
    private FrameLayout cTi;
    private com.baidu.swan.apps.statistic.a cTj;
    private d cTk;
    public final String cTl;
    private FrameLifeState cTm;
    private FrameLifeState cTn;
    private boolean cTo;
    private boolean cTp;
    private boolean cTq;
    private final com.baidu.swan.apps.runtime.b csJ;

    protected abstract void atS();

    @NonNull
    protected abstract a.b aup();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aGI());
        this.cTg = null;
        this.cTh = new com.baidu.swan.apps.al.f.b();
        this.cTm = FrameLifeState.INACTIVATED;
        this.cTn = null;
        this.cTo = false;
        this.cTp = false;
        this.csJ = new com.baidu.swan.apps.runtime.b();
        this.cTq = true;
        this.cCy = swanAppActivity;
        this.cTl = str;
        this.cTk = new d();
        v(this.csJ);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cCy.isDestroyed()) {
                final boolean z3 = (!this.cTm.hasCreated()) | z;
                if (this.cTm.hasCreated() && z3) {
                    z2 = true;
                }
                this.cTq = auw();
                if (this.cTq && z2 && !aGE().aHj()) {
                    this.csJ.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void M(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aGI().aEV()) {
                                c.this.csJ.x("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.atU();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == aeW())) {
                    com.baidu.swan.apps.performance.i.a(afg(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        aub();
    }

    public boolean atT() {
        return this.cTp;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aGE().aHj() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cTm)) ? frameLifeState : this.cTm.hasCreated() ? this.cTm : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cTo + " locked=" + this.cTp + " thread=" + Thread.currentThread());
            if (!this.cTp) {
                this.cTn = frameLifeState;
                this.cTp = FrameLifeState.INACTIVATED == this.cTn;
            }
            if (!this.cTo) {
                this.cTo = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.atU();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void atU() {
        synchronized (this) {
            this.cTo = true;
            while (this.cTn != null && auv()) {
                FrameLifeState c = c(this.cTn);
                log("syncLifeState: pendingTarget=" + this.cTn + " fixedTarget=" + c);
                this.cTn = null;
                switch (c) {
                    case JUST_CREATED:
                        atZ();
                        atV();
                        break;
                    case JUST_STARTED:
                        atY();
                        atW();
                        break;
                    case JUST_RESUMED:
                        atX();
                        break;
                    default:
                        aua();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cTm);
            this.cTp = FrameLifeState.INACTIVATED == this.cTn;
            this.cTo = false;
        }
    }

    private synchronized void atV() {
        if (!this.cTm.hasCreated()) {
            auc();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            atS();
            this.cTm = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void atW() {
        atV();
        if (!this.cTm.hasStarted()) {
            aud();
            this.cTm = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void atX() {
        atW();
        if (!this.cTm.hasResumed()) {
            aue();
            this.cTm = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void atY() {
        if (this.cTm.hasResumed()) {
            auf();
            this.cTm = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void atZ() {
        atY();
        if (this.cTm.hasStarted()) {
            aug();
            this.cTm = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aua() {
        atZ();
        if (this.cTm.hasCreated()) {
            auh();
            this.cTm = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("onUpdateInternalStart").fV(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a afg = afg();
            if (!z2) {
                auu();
            }
            if (!TextUtils.isEmpty(afg.ayk())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(afg.ayk());
            }
        }
        com.baidu.swan.apps.v.f.azg().i(this.cCy);
        qD.f(new UbcFlowEvent("onUpdateStart").fV(true));
        p(z, z2);
        qD.f(new UbcFlowEvent("onUpdateEnd").fV(true));
    }

    private synchronized void aub() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.aqf();
    }

    @DebugTrace
    private synchronized void auc() {
        log("onCreateInternal");
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("frame_start_create"));
        qD.f(new UbcFlowEvent("onCreateInternalStart").fV(true));
        this.cTk.atQ();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.all()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        aur();
        com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
        if (!aGI.aEV() || !aGI.aGE().available()) {
            com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(5L).cw(11L).tV("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aLl().j(tV);
            h.b(new com.baidu.swan.apps.statistic.a.d().td(h.ku(aeW())).i(tV).a(afg()));
            com.baidu.swan.apps.performance.i.d(tV);
            com.baidu.swan.apps.ap.e.M(this.cCy);
        } else {
            auk();
            qD.f(new UbcFlowEvent("onCreateStart").fV(true));
            onCreate();
            qD.f(new UbcFlowEvent("onCreateEnd").fV(true));
            com.baidu.swan.apps.ap.d aeV = this.cCy.aeV();
            if (aeV != null) {
                aeV.aLy();
            }
            qD.f(new UbcFlowEvent("onCreateInternalEnd").fV(true));
        }
    }

    private synchronized void aud() {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("onStartStart").fV(true));
        log("onStartInternal");
        this.cTk.atR();
        onStart();
        qD.f(new UbcFlowEvent("onStartEnd").fV(true));
    }

    private synchronized void aue() {
        HybridUbcFlow qD = com.baidu.swan.apps.performance.i.qD("startup");
        qD.f(new UbcFlowEvent("onResumeInternalStart").fV(true));
        log("onResumeInternal");
        this.cTk.aiY();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.cTj = h.sW("607");
        auq();
        if (aEV()) {
            aGE().K(this.cCy);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aCc().aCe();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cCy != null && com.baidu.swan.apps.runtime.e.aGM() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aGM(), com.baidu.swan.apps.env.c.c.atf().is(10).atg());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aJk().sN("na_page_show");
        com.baidu.swan.apps.v.f.azg().ahF();
        qD.f(new UbcFlowEvent("onResumeStart").fV(true));
        onResume();
        qD.f(new UbcFlowEvent("onResumeEnd").fV(true));
    }

    private synchronized void auf() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.azg().ahG();
        this.cTk.akq();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.cTj != null && aEV()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a afg = afg();
            aVar.mFrom = h.ku(aeW());
            aVar.mAppId = afg.getAppId();
            aVar.mSource = afg.axV();
            aVar.c(afg);
            aVar.th(afg.ayb().getString("ubc"));
            aVar.cb(h.sY(afg.axX()));
            h.a(this.cTj, aVar);
            this.cTj = null;
        }
    }

    private synchronized void aug() {
        com.baidu.swan.apps.performance.i.aCZ();
        log("onStopInternal");
        onStop();
        this.cTk.ams();
    }

    private synchronized void auh() {
        log("onDestroyInternal");
        onDestroy();
        this.cTk.aiX();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aCc().release();
        com.baidu.swan.apps.core.i.a.aqq().release();
        com.baidu.swan.apps.api.b.c.ajG().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        aui();
        aul();
        com.baidu.swan.apps.v.f.release();
    }

    private void aui() {
        com.baidu.swan.apps.scheme.actions.k.c.duF = null;
        com.baidu.swan.apps.performance.i.dhu = null;
    }

    public synchronized FrameLifeState auj() {
        return this.cTm;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cTk.onKeyDown(i, keyEvent);
    }

    public void auk() {
        if (this.cTg == null) {
            this.cTg = aup();
        }
        aGD().a((a.c) null, this.cTg);
    }

    public void aul() {
        aGD().aul();
        this.cTg = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aum() {
        aun();
        auo();
    }

    private void aun() {
        com.baidu.swan.apps.adaptation.a.b ahp = aGK().afx().ahp();
        if (ahp != null) {
            ahp.bl(this.cCy);
        }
    }

    protected void auo() {
        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
        com.baidu.swan.apps.a.b bVar = null;
        if (aGM != null) {
            bVar = aGM.aGZ();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void auq() {
        if (aGE().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.afg(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cCy != null && com.baidu.swan.apps.runtime.e.aGN() != null) {
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
        if (aGE().available()) {
            setTaskDescription(this.cCy, afg().arW(), bitmap, (int) afg().axU());
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

    private void aur() {
        this.cTf = new f(this.cCy);
        aus();
    }

    protected void aus() {
    }

    public f afe() {
        if (this.cTf == null) {
            aur();
        }
        return this.cTf;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        afi().la(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aut() {
        if (this.cTf.aow() != 1) {
            return false;
        }
        this.cCy.moveTaskToBack(true);
        this.cCy.hl(2);
        ap.aMC().ln(1);
        return true;
    }

    public b.a afg() {
        return aGE().aGQ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aEV()) {
            b.a afg = afg();
            fVar.mFrom = h.ku(aeW());
            fVar.mAppId = afg.getAppId();
            fVar.mSource = afg.axV();
            fVar.cb(h.sY(afg.axX()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.th(afg.ayb().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.cTi = (FrameLayout) this.cCy.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cCy, this.cTi);
    }

    public void afh() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cTi);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b afi() {
        return this.cTh;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cTk.c(bVar);
    }

    public void b(b bVar) {
        this.cTk.d(bVar);
    }

    public boolean oo(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auu() {
    }

    public void aiZ() {
        this.cTk.aiZ();
    }

    public boolean auv() {
        return com.baidu.swan.apps.v.f.azg().azi();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean auw() {
        return com.baidu.swan.apps.performance.b.b.aDo() ? com.baidu.swan.apps.performance.b.b.auw() : com.baidu.swan.apps.t.a.avV().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
