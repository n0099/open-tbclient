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
    private final com.baidu.swan.apps.runtime.b bRK;
    protected final SwanAppActivity cbv;
    protected f csn;
    protected a.b cso;
    private final com.baidu.swan.apps.al.f.b csp;
    private FrameLayout csq;
    private com.baidu.swan.apps.statistic.a csr;
    private d css;
    public final String cst;
    private FrameLifeState csu;
    private FrameLifeState csv;
    private boolean csw;
    private boolean csx;
    private boolean csy;

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
        this.cso = null;
        this.csp = new com.baidu.swan.apps.al.f.b();
        this.csu = FrameLifeState.INACTIVATED;
        this.csv = null;
        this.csw = false;
        this.csx = false;
        this.bRK = new com.baidu.swan.apps.runtime.b();
        this.csy = true;
        this.cbv = swanAppActivity;
        this.cst = str;
        this.css = new d();
        v(this.bRK);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cbv.isDestroyed()) {
                final boolean z3 = (!this.csu.hasCreated()) | z;
                if (this.csu.hasCreated() && z3) {
                    z2 = true;
                }
                this.csy = ann();
                if (this.csy && z2 && !azA().aAf()) {
                    this.bRK.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void I(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.azE().axR()) {
                                c.this.bRK.v("event_first_action_launched");
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
        return this.csx;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || azA().aAf() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.csu)) ? frameLifeState : this.csu.hasCreated() ? this.csu : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.csw + " locked=" + this.csx + " thread=" + Thread.currentThread());
            if (!this.csx) {
                this.csv = frameLifeState;
                this.csx = FrameLifeState.INACTIVATED == this.csv;
            }
            if (!this.csw) {
                this.csw = true;
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
            this.csw = true;
            while (this.csv != null && anm()) {
                FrameLifeState c = c(this.csv);
                log("syncLifeState: pendingTarget=" + this.csv + " fixedTarget=" + c);
                this.csv = null;
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
            log("syncLifeState: done=" + this.csu);
            this.csx = FrameLifeState.INACTIVATED == this.csv;
            this.csw = false;
        }
    }

    private synchronized void amM() {
        if (!this.csu.hasCreated()) {
            amT();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            amJ();
            this.csu = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void amN() {
        amM();
        if (!this.csu.hasStarted()) {
            amU();
            this.csu = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void amO() {
        amN();
        if (!this.csu.hasResumed()) {
            amV();
            this.csu = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void amP() {
        if (this.csu.hasResumed()) {
            amW();
            this.csu = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void amQ() {
        amP();
        if (this.csu.hasStarted()) {
            amX();
            this.csu = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void amR() {
        amQ();
        if (this.csu.hasCreated()) {
            amY();
            this.csu = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
        oX.f(new UbcFlowEvent("onUpdateInternalStart").fc(true));
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
        com.baidu.swan.apps.v.f.arY().i(this.cbv);
        oX.f(new UbcFlowEvent("onUpdateStart").fc(true));
        p(z, z2);
        oX.f(new UbcFlowEvent("onUpdateEnd").fc(true));
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
        HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
        oX.f(new UbcFlowEvent("frame_start_create"));
        oX.f(new UbcFlowEvent("onCreateInternalStart").fc(true));
        this.css.amH();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.aee()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        ani();
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        if (!azE.axR() || !azE.azA().available()) {
            com.baidu.swan.apps.am.a sn = new com.baidu.swan.apps.am.a().bO(5L).bP(11L).sn("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aEg().j(sn);
            h.b(new com.baidu.swan.apps.statistic.a.d().rv(h.jv(XP())).i(sn).a(XZ()));
            com.baidu.swan.apps.performance.i.d(sn);
            com.baidu.swan.apps.ap.e.K(this.cbv);
        } else {
            anb();
            oX.f(new UbcFlowEvent("onCreateStart").fc(true));
            onCreate();
            oX.f(new UbcFlowEvent("onCreateEnd").fc(true));
            com.baidu.swan.apps.ap.d XO = this.cbv.XO();
            if (XO != null) {
                XO.aEt();
            }
            oX.f(new UbcFlowEvent("onCreateInternalEnd").fc(true));
        }
    }

    private synchronized void amU() {
        HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
        oX.f(new UbcFlowEvent("onStartStart").fc(true));
        log("onStartInternal");
        this.css.amI();
        onStart();
        oX.f(new UbcFlowEvent("onStartEnd").fc(true));
    }

    private synchronized void amV() {
        HybridUbcFlow oX = com.baidu.swan.apps.performance.i.oX("startup");
        oX.f(new UbcFlowEvent("onResumeInternalStart").fc(true));
        log("onResumeInternal");
        this.css.abR();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.csr = h.ro("607");
        anh();
        if (axR()) {
            azA().onActivityResume(this.cbv);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.auW().auY();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cbv != null && com.baidu.swan.apps.runtime.e.azI() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.azI(), com.baidu.swan.apps.env.c.c.alW().hv(10).alX());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.oX("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aCf().rf("na_page_show");
        com.baidu.swan.apps.v.f.arY().aay();
        oX.f(new UbcFlowEvent("onResumeStart").fc(true));
        onResume();
        oX.f(new UbcFlowEvent("onResumeEnd").fc(true));
    }

    private synchronized void amW() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.arY().aaz();
        this.css.adk();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.csr != null && axR()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a XZ = XZ();
            aVar.mFrom = h.jv(XP());
            aVar.mAppId = XZ.getAppId();
            aVar.mSource = XZ.aqN();
            aVar.c(XZ);
            aVar.rz(XZ.aqT().getString("ubc"));
            aVar.bO(h.rq(XZ.aqP()));
            h.a(this.csr, aVar);
            this.csr = null;
        }
    }

    private synchronized void amX() {
        com.baidu.swan.apps.performance.i.avT();
        log("onStopInternal");
        onStop();
        this.css.afl();
    }

    private synchronized void amY() {
        log("onDestroyInternal");
        onDestroy();
        this.css.abQ();
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
        com.baidu.swan.apps.scheme.actions.k.c.cTI = null;
        com.baidu.swan.apps.performance.i.cGF = null;
    }

    public synchronized FrameLifeState ana() {
        return this.csu;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.css.onKeyDown(i, keyEvent);
    }

    public void anb() {
        if (this.cso == null) {
            this.cso = ang();
        }
        azz().a((a.c) null, this.cso);
    }

    public void anc() {
        azz().anc();
        this.cso = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void and() {
        ane();
        anf();
    }

    private void ane() {
        com.baidu.swan.apps.adaptation.a.b aai = azG().Yq().aai();
        if (aai != null) {
            aai.bg(this.cbv);
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
                            if (c.this.cbv != null && com.baidu.swan.apps.runtime.e.azJ() != null) {
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
            setTaskDescription(this.cbv, XZ().akO(), bitmap, (int) XZ().aqM());
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
        this.csn = new f(this.cbv);
        anj();
    }

    protected void anj() {
    }

    public f XX() {
        if (this.csn == null) {
            ani();
        }
        return this.csn;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        Yb().kb(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ank() {
        if (this.csn.ahp() != 1) {
            return false;
        }
        this.cbv.moveTaskToBack(true);
        this.cbv.gn(2);
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
            fVar.bO(h.rq(XZ.aqP()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.rz(XZ.aqT().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.csq = (FrameLayout) this.cbv.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cbv, this.csq);
    }

    public void Ya() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.csq);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b Yb() {
        return this.csp;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.css.c(bVar);
    }

    public void b(b bVar) {
        this.css.d(bVar);
    }

    public boolean mG(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anl() {
    }

    public void abS() {
        this.css.abS();
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
