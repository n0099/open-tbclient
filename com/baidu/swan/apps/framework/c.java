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
    protected f cOW;
    protected a.b cOX;
    private final com.baidu.swan.apps.al.f.b cOY;
    private FrameLayout cOZ;
    private com.baidu.swan.apps.statistic.a cPa;
    private d cPb;
    public final String cPc;
    private FrameLifeState cPd;
    private FrameLifeState cPe;
    private boolean cPf;
    private boolean cPg;
    private boolean cPh;
    private final com.baidu.swan.apps.runtime.b coy;
    protected final SwanAppActivity cyp;

    protected abstract void arZ();

    @NonNull
    protected abstract a.b asx();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aEQ());
        this.cOX = null;
        this.cOY = new com.baidu.swan.apps.al.f.b();
        this.cPd = FrameLifeState.INACTIVATED;
        this.cPe = null;
        this.cPf = false;
        this.cPg = false;
        this.coy = new com.baidu.swan.apps.runtime.b();
        this.cPh = true;
        this.cyp = swanAppActivity;
        this.cPc = str;
        this.cPb = new d();
        v(this.coy);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cyp.isDestroyed()) {
                final boolean z3 = (!this.cPd.hasCreated()) | z;
                if (this.cPd.hasCreated() && z3) {
                    z2 = true;
                }
                this.cPh = asE();
                if (this.cPh && z2 && !aEM().aFr()) {
                    this.coy.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void M(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aEQ().aDd()) {
                                c.this.coy.x("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.asb();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == ade())) {
                    com.baidu.swan.apps.performance.i.a(ado(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        asi();
    }

    public boolean asa() {
        return this.cPg;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aEM().aFr() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cPd)) ? frameLifeState : this.cPd.hasCreated() ? this.cPd : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cPf + " locked=" + this.cPg + " thread=" + Thread.currentThread());
            if (!this.cPg) {
                this.cPe = frameLifeState;
                this.cPg = FrameLifeState.INACTIVATED == this.cPe;
            }
            if (!this.cPf) {
                this.cPf = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.asb();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void asb() {
        synchronized (this) {
            this.cPf = true;
            while (this.cPe != null && asD()) {
                FrameLifeState c = c(this.cPe);
                log("syncLifeState: pendingTarget=" + this.cPe + " fixedTarget=" + c);
                this.cPe = null;
                switch (c) {
                    case JUST_CREATED:
                        asg();
                        asc();
                        break;
                    case JUST_STARTED:
                        asf();
                        asd();
                        break;
                    case JUST_RESUMED:
                        ase();
                        break;
                    default:
                        ash();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cPd);
            this.cPg = FrameLifeState.INACTIVATED == this.cPe;
            this.cPf = false;
        }
    }

    private synchronized void asc() {
        if (!this.cPd.hasCreated()) {
            asj();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            arZ();
            this.cPd = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void asd() {
        asc();
        if (!this.cPd.hasStarted()) {
            ask();
            this.cPd = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void ase() {
        asd();
        if (!this.cPd.hasResumed()) {
            asl();
            this.cPd = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void asf() {
        if (this.cPd.hasResumed()) {
            asn();
            this.cPd = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void asg() {
        asf();
        if (this.cPd.hasStarted()) {
            aso();
            this.cPd = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ash() {
        asg();
        if (this.cPd.hasCreated()) {
            asp();
            this.cPd = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("onUpdateInternalStart").fJ(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a ado = ado();
            if (!z2) {
                asC();
            }
            if (!TextUtils.isEmpty(ado.aws())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(ado.aws());
            }
        }
        com.baidu.swan.apps.v.f.axo().i(this.cyp);
        qv.f(new UbcFlowEvent("onUpdateStart").fJ(true));
        p(z, z2);
        qv.f(new UbcFlowEvent("onUpdateEnd").fJ(true));
    }

    private synchronized void asi() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.aom();
    }

    @DebugTrace
    private synchronized void asj() {
        log("onCreateInternal");
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("frame_start_create"));
        qv.f(new UbcFlowEvent("onCreateInternalStart").fJ(true));
        this.cPb.arX();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.ajt()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        asz();
        com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
        if (!aEQ.aDd() || !aEQ.aEM().available()) {
            com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(11L).tM("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aJt().j(tM);
            h.b(new com.baidu.swan.apps.statistic.a.d().sU(h.ko(ade())).i(tM).a(ado()));
            com.baidu.swan.apps.performance.i.d(tM);
            com.baidu.swan.apps.ap.e.N(this.cyp);
        } else {
            ass();
            qv.f(new UbcFlowEvent("onCreateStart").fJ(true));
            onCreate();
            qv.f(new UbcFlowEvent("onCreateEnd").fJ(true));
            com.baidu.swan.apps.ap.d add = this.cyp.add();
            if (add != null) {
                add.aJG();
            }
            qv.f(new UbcFlowEvent("onCreateInternalEnd").fJ(true));
        }
    }

    private synchronized void ask() {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("onStartStart").fJ(true));
        log("onStartInternal");
        this.cPb.arY();
        onStart();
        qv.f(new UbcFlowEvent("onStartEnd").fJ(true));
    }

    private synchronized void asl() {
        HybridUbcFlow qv = com.baidu.swan.apps.performance.i.qv("startup");
        qv.f(new UbcFlowEvent("onResumeInternalStart").fJ(true));
        log("onResumeInternal");
        this.cPb.ahg();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.cPa = h.sN("607");
        asy();
        if (aDd()) {
            aEM().L(this.cyp);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aAk().aAm();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cyp != null && com.baidu.swan.apps.runtime.e.aEU() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aEU(), com.baidu.swan.apps.env.c.c.arm().im(10).arn());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aHs().sE("na_page_show");
        com.baidu.swan.apps.v.f.axo().afN();
        qv.f(new UbcFlowEvent("onResumeStart").fJ(true));
        onResume();
        qv.f(new UbcFlowEvent("onResumeEnd").fJ(true));
    }

    private synchronized void asn() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.axo().afO();
        this.cPb.aiy();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.cPa != null && aDd()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a ado = ado();
            aVar.mFrom = h.ko(ade());
            aVar.mAppId = ado.getAppId();
            aVar.mSource = ado.awd();
            aVar.c(ado);
            aVar.sY(ado.awj().getString("ubc"));
            aVar.cb(h.sP(ado.awf()));
            h.a(this.cPa, aVar);
            this.cPa = null;
        }
    }

    private synchronized void aso() {
        com.baidu.swan.apps.performance.i.aBh();
        log("onStopInternal");
        onStop();
        this.cPb.akA();
    }

    private synchronized void asp() {
        log("onDestroyInternal");
        onDestroy();
        this.cPb.ahf();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aAk().release();
        com.baidu.swan.apps.core.i.a.aox().release();
        com.baidu.swan.apps.api.b.c.ahO().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        asq();
        ast();
        com.baidu.swan.apps.v.f.release();
    }

    private void asq() {
        com.baidu.swan.apps.scheme.actions.k.c.dqr = null;
        com.baidu.swan.apps.performance.i.ddh = null;
    }

    public synchronized FrameLifeState asr() {
        return this.cPd;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cPb.onKeyDown(i, keyEvent);
    }

    public void ass() {
        if (this.cOX == null) {
            this.cOX = asx();
        }
        aEL().a((a.c) null, this.cOX);
    }

    public void ast() {
        aEL().ast();
        this.cOX = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asu() {
        asv();
        asw();
    }

    private void asv() {
        com.baidu.swan.apps.adaptation.a.b afx = aES().adF().afx();
        if (afx != null) {
            afx.bl(this.cyp);
        }
    }

    protected void asw() {
        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
        com.baidu.swan.apps.a.b bVar = null;
        if (aEU != null) {
            bVar = aEU.aFh();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void asy() {
        if (aEM().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.ado(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cyp != null && com.baidu.swan.apps.runtime.e.aEV() != null) {
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
        if (aEM().available()) {
            setTaskDescription(this.cyp, ado().aqe(), bitmap, (int) ado().awc());
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

    private void asz() {
        this.cOW = new f(this.cyp);
        asA();
    }

    protected void asA() {
    }

    public f adm() {
        if (this.cOW == null) {
            asz();
        }
        return this.cOW;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        adq().kU(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean asB() {
        if (this.cOW.amE() != 1) {
            return false;
        }
        this.cyp.moveTaskToBack(true);
        this.cyp.hf(2);
        ap.aKK().lh(1);
        return true;
    }

    public b.a ado() {
        return aEM().aEY();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aDd()) {
            b.a ado = ado();
            fVar.mFrom = h.ko(ade());
            fVar.mAppId = ado.getAppId();
            fVar.mSource = ado.awd();
            fVar.cb(h.sP(ado.awf()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.sY(ado.awj().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.cOZ = (FrameLayout) this.cyp.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cyp, this.cOZ);
    }

    public void adp() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cOZ);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b adq() {
        return this.cOY;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cPb.c(bVar);
    }

    public void b(b bVar) {
        this.cPb.d(bVar);
    }

    public boolean oe(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void asC() {
    }

    public void ahh() {
        this.cPb.ahh();
    }

    public boolean asD() {
        return com.baidu.swan.apps.v.f.axo().axq();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean asE() {
        return com.baidu.swan.apps.performance.b.b.aBw() ? com.baidu.swan.apps.performance.b.b.asE() : com.baidu.swan.apps.t.a.aud().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
