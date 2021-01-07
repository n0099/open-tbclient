package com.baidu.swan.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.u.c.b;
/* loaded from: classes9.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.b cEt;
    protected final SwanAppActivity cOo;
    protected f deW;
    protected a.b deX;
    private final com.baidu.swan.apps.ak.f.b deY;
    private FrameLayout deZ;
    private com.baidu.swan.apps.statistic.a dfa;
    private d dfb;
    public final String dfc;
    private FrameLifeState dfd;
    private FrameLifeState dfe;
    private boolean dff;
    private boolean dfg;
    private boolean dfh;

    @NonNull
    protected abstract a.b ayP();

    protected abstract void ays();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aMh());
        this.deX = null;
        this.deY = new com.baidu.swan.apps.ak.f.b();
        this.dfd = FrameLifeState.INACTIVATED;
        this.dfe = null;
        this.dff = false;
        this.dfg = false;
        this.cEt = new com.baidu.swan.apps.runtime.b();
        this.dfh = true;
        this.cOo = swanAppActivity;
        this.dfc = str;
        this.dfb = new d();
        v(this.cEt);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cOo.isDestroyed()) {
                final boolean z3 = (!this.dfd.hasCreated()) | z;
                if (this.dfd.hasCreated() && z3) {
                    z2 = true;
                }
                this.dfh = ayW();
                if (this.dfh && z2 && !aMd().aMI()) {
                    this.cEt.a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void L(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aMh().aJx()) {
                                c.this.cEt.E("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.ayu();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == ajl())) {
                    com.baidu.swan.apps.performance.i.a(ajv(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        ayB();
    }

    public boolean ayt() {
        return this.dfg;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aMd().aMI() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.dfd)) ? frameLifeState : this.dfd.hasCreated() ? this.dfd : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.dff + " locked=" + this.dfg + " thread=" + Thread.currentThread());
            if (!this.dfg) {
                this.dfe = frameLifeState;
                this.dfg = FrameLifeState.INACTIVATED == this.dfe;
            }
            if (!this.dff) {
                this.dff = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.ayu();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void ayu() {
        synchronized (this) {
            this.dff = true;
            while (this.dfe != null && ayV()) {
                FrameLifeState c = c(this.dfe);
                log("syncLifeState: pendingTarget=" + this.dfe + " fixedTarget=" + c);
                this.dfe = null;
                switch (c) {
                    case JUST_CREATED:
                        ayz();
                        ayv();
                        break;
                    case JUST_STARTED:
                        ayy();
                        ayw();
                        break;
                    case JUST_RESUMED:
                        ayx();
                        break;
                    default:
                        ayA();
                        break;
                }
            }
            log("syncLifeState: done=" + this.dfd);
            this.dfg = FrameLifeState.INACTIVATED == this.dfe;
            this.dff = false;
        }
    }

    private synchronized void ayv() {
        if (!this.dfd.hasCreated()) {
            ayC();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            ays();
            this.dfd = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ayw() {
        ayv();
        if (!this.dfd.hasStarted()) {
            ayD();
            this.dfd = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void ayx() {
        ayw();
        if (!this.dfd.hasResumed()) {
            ayE();
            this.dfd = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void ayy() {
        if (this.dfd.hasResumed()) {
            ayF();
            this.dfd = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void ayz() {
        ayy();
        if (this.dfd.hasStarted()) {
            ayG();
            this.dfd = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ayA() {
        ayz();
        if (this.dfd.hasCreated()) {
            ayH();
            this.dfd = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("onUpdateInternalStart").gt(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a ajv = ajv();
            if (!z2) {
                ayU();
            }
            if (!TextUtils.isEmpty(ajv.aCL())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(ajv.aCL());
            }
        }
        com.baidu.swan.apps.v.f.aDH().i(this.cOo);
        rd.f(new UbcFlowEvent("onUpdateStart").gt(true));
        p(z, z2);
        rd.f(new UbcFlowEvent("onUpdateEnd").gt(true));
    }

    private synchronized void ayB() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.auF();
    }

    @DebugTrace
    private synchronized void ayC() {
        log("onCreateInternal");
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("frame_start_create"));
        rd.f(new UbcFlowEvent("onCreateInternalStart").gt(true));
        this.dfb.ayq();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.apH()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        ayR();
        com.baidu.swan.apps.runtime.d aMh = com.baidu.swan.apps.runtime.d.aMh();
        if (!aMh.aJx() || !aMh.aMd().available()) {
            com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(11L).uz("aiapp data is invalid");
            com.baidu.swan.apps.al.e.aQK().j(uz);
            h.b(new com.baidu.swan.apps.statistic.a.d().tH(h.kX(ajl())).i(uz).a(ajv()));
            com.baidu.swan.apps.performance.i.d(uz);
            com.baidu.swan.apps.ao.e.N(this.cOo);
        } else {
            ayK();
            rd.f(new UbcFlowEvent("onCreateStart").gt(true));
            onCreate();
            rd.f(new UbcFlowEvent("onCreateEnd").gt(true));
            com.baidu.swan.apps.ao.d ajk = this.cOo.ajk();
            if (ajk != null) {
                ajk.aQX();
            }
            rd.f(new UbcFlowEvent("onCreateInternalEnd").gt(true));
        }
    }

    private synchronized void ayD() {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("onStartStart").gt(true));
        log("onStartInternal");
        this.dfb.ayr();
        onStart();
        rd.f(new UbcFlowEvent("onStartEnd").gt(true));
    }

    private synchronized void ayE() {
        HybridUbcFlow rd = com.baidu.swan.apps.performance.i.rd("startup");
        rd.f(new UbcFlowEvent("onResumeInternalStart").gt(true));
        log("onResumeInternal");
        this.dfb.anr();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.dfa = h.tA("607");
        ayQ();
        if (aJx()) {
            aMd().L(this.cOo);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aGG().aGI();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cOo != null && com.baidu.swan.apps.runtime.e.aMl() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aMl(), com.baidu.swan.apps.env.c.c.axG().iL(10).axH());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.aj.a.aOJ().tr("na_page_show");
        com.baidu.swan.apps.v.f.aDH().alY();
        rd.f(new UbcFlowEvent("onResumeStart").gt(true));
        onResume();
        rd.f(new UbcFlowEvent("onResumeEnd").gt(true));
    }

    private synchronized void ayF() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.aDH().alZ();
        this.dfb.aoK();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.dfa != null && aJx()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a ajv = ajv();
            aVar.mFrom = h.kX(ajl());
            aVar.mAppId = ajv.getAppId();
            aVar.mSource = ajv.aCw();
            aVar.c(ajv);
            aVar.tL(ajv.aCC().getString("ubc"));
            aVar.cl(h.tC(ajv.aCy()));
            h.a(this.dfa, aVar);
            this.dfa = null;
        }
    }

    private synchronized void ayG() {
        com.baidu.swan.apps.performance.i.aHB();
        log("onStopInternal");
        onStop();
        this.dfb.aqN();
    }

    private synchronized void ayH() {
        log("onDestroyInternal");
        onDestroy();
        this.dfb.anq();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aGG().release();
        com.baidu.swan.apps.core.i.a.auQ().release();
        com.baidu.swan.apps.api.b.c.anZ().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        ayI();
        ayL();
        com.baidu.swan.apps.v.f.release();
    }

    private void ayI() {
        com.baidu.swan.apps.scheme.actions.k.c.dKj = null;
        com.baidu.swan.apps.performance.i.dtv = null;
    }

    public synchronized FrameLifeState ayJ() {
        return this.dfd;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dfb.onKeyDown(i, keyEvent);
    }

    public void ayK() {
        if (this.deX == null) {
            this.deX = ayP();
        }
        aMc().a((a.c) null, this.deX);
    }

    public void ayL() {
        aMc().ayL();
        this.deX = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayM() {
        ayN();
        ayO();
    }

    private void ayN() {
        com.baidu.swan.apps.adaptation.a.b alI = aMj().ajO().alI();
        if (alI != null) {
            alI.bY(this.cOo);
        }
    }

    protected void ayO() {
        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
        com.baidu.swan.apps.a.b bVar = null;
        if (aMl != null) {
            bVar = aMl.aMy();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void ayQ() {
        if (aMd().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.ajv(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cOo != null && com.baidu.swan.apps.runtime.e.aMm() != null) {
                                c.this.m(a2);
                            }
                        }
                    });
                }
            }, "updateTaskDescription", 2);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(Bitmap bitmap) {
        if (aMd().available()) {
            a(this.cOo, ajv().awy(), bitmap, (int) ajv().aCv());
        }
    }

    private static void a(Activity activity, String str, Bitmap bitmap, int i) {
        if (i != 0 && Color.alpha(i) != 255) {
            i = Color.argb(255, Color.red(i), Color.green(i), Color.blue(i));
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.setTaskDescription(new ActivityManager.TaskDescription(str, bitmap, i));
        }
    }

    private void ayR() {
        this.deW = new f(this.cOo);
        ayS();
    }

    protected void ayS() {
    }

    public f ajt() {
        if (this.deW == null) {
            ayR();
        }
        return this.deW;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        ajx().lD(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean ayT() {
        if (this.deW.asX() != 1) {
            return false;
        }
        this.cOo.moveTaskToBack(true);
        this.cOo.hD(2);
        ap.aSb().lQ(1);
        return true;
    }

    public b.a ajv() {
        return aMd().aMp();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aJx()) {
            b.a ajv = ajv();
            fVar.mFrom = h.kX(ajl());
            fVar.mAppId = ajv.getAppId();
            fVar.mSource = ajv.aCw();
            fVar.cl(h.tC(ajv.aCy()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.tL(ajv.aCC().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.deZ = (FrameLayout) this.cOo.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.f(this.cOo, this.deZ);
    }

    public void ajw() {
        com.baidu.swan.apps.res.widget.loadingview.a.I(this.deZ);
    }

    @NonNull
    public com.baidu.swan.apps.ak.f.b ajx() {
        return this.deY;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.dfb.c(bVar);
    }

    public void b(b bVar) {
        this.dfb.d(bVar);
    }

    public boolean oO(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ayU() {
    }

    public void ans() {
        this.dfb.ans();
    }

    public boolean ayV() {
        return com.baidu.swan.apps.v.f.aDH().aDJ();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean ayW() {
        return com.baidu.swan.apps.performance.b.b.aHQ() ? com.baidu.swan.apps.performance.b.b.ayW() : com.baidu.swan.apps.t.a.aAv().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
