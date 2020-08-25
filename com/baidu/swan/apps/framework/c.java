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
/* loaded from: classes8.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.b bRG;
    protected final SwanAppActivity cbr;
    protected f csj;
    protected a.b csk;
    private final com.baidu.swan.apps.al.f.b csl;
    private FrameLayout csm;
    private com.baidu.swan.apps.statistic.a csn;
    private d cso;
    public final String csp;
    private FrameLifeState csq;
    private FrameLifeState csr;
    private boolean css;
    private boolean cst;
    private boolean csu;

    protected abstract void amJ();

    @NonNull
    protected abstract a.b ang();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.azE());
        this.csk = null;
        this.csl = new com.baidu.swan.apps.al.f.b();
        this.csq = FrameLifeState.INACTIVATED;
        this.csr = null;
        this.css = false;
        this.cst = false;
        this.bRG = new com.baidu.swan.apps.runtime.b();
        this.csu = true;
        this.cbr = swanAppActivity;
        this.csp = str;
        this.cso = new d();
        v(this.bRG);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cbr.isDestroyed()) {
                final boolean z3 = (!this.csq.hasCreated()) | z;
                if (this.csq.hasCreated() && z3) {
                    z2 = true;
                }
                this.csu = ann();
                if (this.csu && z2 && !azA().aAf()) {
                    this.bRG.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void I(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.azE().axR()) {
                                c.this.bRG.v("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.amL();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == XP())) {
                    com.baidu.swan.apps.performance.i.a(XZ(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        amS();
    }

    public boolean amK() {
        return this.cst;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || azA().aAf() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.csq)) ? frameLifeState : this.csq.hasCreated() ? this.csq : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.css + " locked=" + this.cst + " thread=" + Thread.currentThread());
            if (!this.cst) {
                this.csr = frameLifeState;
                this.cst = FrameLifeState.INACTIVATED == this.csr;
            }
            if (!this.css) {
                this.css = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.amL();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void amL() {
        synchronized (this) {
            this.css = true;
            while (this.csr != null && anm()) {
                FrameLifeState c = c(this.csr);
                log("syncLifeState: pendingTarget=" + this.csr + " fixedTarget=" + c);
                this.csr = null;
                switch (c) {
                    case JUST_CREATED:
                        amQ();
                        amM();
                        break;
                    case JUST_STARTED:
                        amP();
                        amN();
                        break;
                    case JUST_RESUMED:
                        amO();
                        break;
                    default:
                        amR();
                        break;
                }
            }
            log("syncLifeState: done=" + this.csq);
            this.cst = FrameLifeState.INACTIVATED == this.csr;
            this.css = false;
        }
    }

    private synchronized void amM() {
        if (!this.csq.hasCreated()) {
            amT();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            amJ();
            this.csq = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void amN() {
        amM();
        if (!this.csq.hasStarted()) {
            amU();
            this.csq = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void amO() {
        amN();
        if (!this.csq.hasResumed()) {
            amV();
            this.csq = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void amP() {
        if (this.csq.hasResumed()) {
            amW();
            this.csq = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void amQ() {
        amP();
        if (this.csq.hasStarted()) {
            amX();
            this.csq = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void amR() {
        amQ();
        if (this.csq.hasCreated()) {
            amY();
            this.csq = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("onUpdateInternalStart").fb(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a XZ = XZ();
            if (!z2) {
                anl();
            }
            if (!TextUtils.isEmpty(XZ.arc())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(XZ.arc());
            }
        }
        com.baidu.swan.apps.v.f.arY().i(this.cbr);
        oW.f(new UbcFlowEvent("onUpdateStart").fb(true));
        p(z, z2);
        oW.f(new UbcFlowEvent("onUpdateEnd").fb(true));
    }

    private synchronized void amS() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.aiX();
    }

    @DebugTrace
    private synchronized void amT() {
        log("onCreateInternal");
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("frame_start_create"));
        oW.f(new UbcFlowEvent("onCreateInternalStart").fb(true));
        this.cso.amH();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.aee()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        ani();
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        if (!azE.axR() || !azE.azA().available()) {
            com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(5L).bP(11L).sm("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aEg().j(sm);
            h.b(new com.baidu.swan.apps.statistic.a.d().ru(h.jv(XP())).i(sm).a(XZ()));
            com.baidu.swan.apps.performance.i.d(sm);
            com.baidu.swan.apps.ap.e.K(this.cbr);
        } else {
            anb();
            oW.f(new UbcFlowEvent("onCreateStart").fb(true));
            onCreate();
            oW.f(new UbcFlowEvent("onCreateEnd").fb(true));
            com.baidu.swan.apps.ap.d XO = this.cbr.XO();
            if (XO != null) {
                XO.aEt();
            }
            oW.f(new UbcFlowEvent("onCreateInternalEnd").fb(true));
        }
    }

    private synchronized void amU() {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("onStartStart").fb(true));
        log("onStartInternal");
        this.cso.amI();
        onStart();
        oW.f(new UbcFlowEvent("onStartEnd").fb(true));
    }

    private synchronized void amV() {
        HybridUbcFlow oW = com.baidu.swan.apps.performance.i.oW("startup");
        oW.f(new UbcFlowEvent("onResumeInternalStart").fb(true));
        log("onResumeInternal");
        this.cso.abR();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.csn = h.rn("607");
        anh();
        if (axR()) {
            azA().onActivityResume(this.cbr);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.auW().auY();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cbr != null && com.baidu.swan.apps.runtime.e.azI() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.azI(), com.baidu.swan.apps.env.c.c.alW().hv(10).alX());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.oW("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aCf().re("na_page_show");
        com.baidu.swan.apps.v.f.arY().aay();
        oW.f(new UbcFlowEvent("onResumeStart").fb(true));
        onResume();
        oW.f(new UbcFlowEvent("onResumeEnd").fb(true));
    }

    private synchronized void amW() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.arY().aaz();
        this.cso.adk();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.csn != null && axR()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a XZ = XZ();
            aVar.mFrom = h.jv(XP());
            aVar.mAppId = XZ.getAppId();
            aVar.mSource = XZ.aqN();
            aVar.c(XZ);
            aVar.ry(XZ.aqT().getString("ubc"));
            aVar.bO(h.rp(XZ.aqP()));
            h.a(this.csn, aVar);
            this.csn = null;
        }
    }

    private synchronized void amX() {
        com.baidu.swan.apps.performance.i.avT();
        log("onStopInternal");
        onStop();
        this.cso.afl();
    }

    private synchronized void amY() {
        log("onDestroyInternal");
        onDestroy();
        this.cso.abQ();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.auW().release();
        com.baidu.swan.apps.core.i.a.aji().release();
        com.baidu.swan.apps.api.b.c.acz().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        amZ();
        anc();
        com.baidu.swan.apps.v.f.release();
    }

    private void amZ() {
        com.baidu.swan.apps.scheme.actions.k.c.cTE = null;
        com.baidu.swan.apps.performance.i.cGB = null;
    }

    public synchronized FrameLifeState ana() {
        return this.csq;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cso.onKeyDown(i, keyEvent);
    }

    public void anb() {
        if (this.csk == null) {
            this.csk = ang();
        }
        azz().a((a.c) null, this.csk);
    }

    public void anc() {
        azz().anc();
        this.csk = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void and() {
        ane();
        anf();
    }

    private void ane() {
        com.baidu.swan.apps.adaptation.a.b aai = azG().Yq().aai();
        if (aai != null) {
            aai.bg(this.cbr);
        }
    }

    protected void anf() {
        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
        com.baidu.swan.apps.a.b bVar = null;
        if (azI != null) {
            bVar = azI.azV();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void anh() {
        if (azA().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a = ak.a((com.baidu.swan.apps.u.c.b) c.this.XZ(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cbr != null && com.baidu.swan.apps.runtime.e.azJ() != null) {
                                c.this.l(a);
                            }
                        }
                    });
                }
            }, "updateTaskDescription", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(Bitmap bitmap) {
        if (azA().available()) {
            setTaskDescription(this.cbr, XZ().akO(), bitmap, (int) XZ().aqM());
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

    private void ani() {
        this.csj = new f(this.cbr);
        anj();
    }

    protected void anj() {
    }

    public f XX() {
        if (this.csj == null) {
            ani();
        }
        return this.csj;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        Yb().kb(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ank() {
        if (this.csj.ahp() != 1) {
            return false;
        }
        this.cbr.moveTaskToBack(true);
        this.cbr.gn(2);
        ap.aFx().ko(1);
        return true;
    }

    public b.a XZ() {
        return azA().azM();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && axR()) {
            b.a XZ = XZ();
            fVar.mFrom = h.jv(XP());
            fVar.mAppId = XZ.getAppId();
            fVar.mSource = XZ.aqN();
            fVar.bO(h.rp(XZ.aqP()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.ry(XZ.aqT().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.csm = (FrameLayout) this.cbr.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cbr, this.csm);
    }

    public void Ya() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.csm);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b Yb() {
        return this.csl;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cso.c(bVar);
    }

    public void b(b bVar) {
        this.cso.d(bVar);
    }

    public boolean mF(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anl() {
    }

    public void abS() {
        this.cso.abS();
    }

    public boolean anm() {
        return com.baidu.swan.apps.v.f.arY().asa();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean ann() {
        return com.baidu.swan.apps.performance.b.b.awi() ? com.baidu.swan.apps.performance.b.b.ann() : com.baidu.swan.apps.t.a.aoM().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
