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
/* loaded from: classes8.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity cJC;
    private final com.baidu.swan.apps.runtime.b czH;
    protected f daf;
    protected a.b dag;
    private final com.baidu.swan.apps.ak.f.b dah;
    private FrameLayout dai;
    private com.baidu.swan.apps.statistic.a daj;
    private d dak;
    public final String dal;
    private FrameLifeState dam;
    private FrameLifeState dan;
    private boolean dao;
    private boolean dap;
    private boolean daq;

    @NonNull
    protected abstract a.b auV();

    protected abstract void auy();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aIn());
        this.dag = null;
        this.dah = new com.baidu.swan.apps.ak.f.b();
        this.dam = FrameLifeState.INACTIVATED;
        this.dan = null;
        this.dao = false;
        this.dap = false;
        this.czH = new com.baidu.swan.apps.runtime.b();
        this.daq = true;
        this.cJC = swanAppActivity;
        this.dal = str;
        this.dak = new d();
        v(this.czH);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cJC.isDestroyed()) {
                final boolean z3 = (!this.dam.hasCreated()) | z;
                if (this.dam.hasCreated() && z3) {
                    z2 = true;
                }
                this.daq = avc();
                if (this.daq && z2 && !aIj().aIO()) {
                    this.czH.a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void L(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aIn().aFD()) {
                                c.this.czH.E("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.auA();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == afr())) {
                    com.baidu.swan.apps.performance.i.a(afB(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        auH();
    }

    public boolean auz() {
        return this.dap;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aIj().aIO() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.dam)) ? frameLifeState : this.dam.hasCreated() ? this.dam : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.dao + " locked=" + this.dap + " thread=" + Thread.currentThread());
            if (!this.dap) {
                this.dan = frameLifeState;
                this.dap = FrameLifeState.INACTIVATED == this.dan;
            }
            if (!this.dao) {
                this.dao = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.auA();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void auA() {
        synchronized (this) {
            this.dao = true;
            while (this.dan != null && avb()) {
                FrameLifeState c = c(this.dan);
                log("syncLifeState: pendingTarget=" + this.dan + " fixedTarget=" + c);
                this.dan = null;
                switch (c) {
                    case JUST_CREATED:
                        auF();
                        auB();
                        break;
                    case JUST_STARTED:
                        auE();
                        auC();
                        break;
                    case JUST_RESUMED:
                        auD();
                        break;
                    default:
                        auG();
                        break;
                }
            }
            log("syncLifeState: done=" + this.dam);
            this.dap = FrameLifeState.INACTIVATED == this.dan;
            this.dao = false;
        }
    }

    private synchronized void auB() {
        if (!this.dam.hasCreated()) {
            auI();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            auy();
            this.dam = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void auC() {
        auB();
        if (!this.dam.hasStarted()) {
            auJ();
            this.dam = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void auD() {
        auC();
        if (!this.dam.hasResumed()) {
            auK();
            this.dam = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void auE() {
        if (this.dam.hasResumed()) {
            auL();
            this.dam = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void auF() {
        auE();
        if (this.dam.hasStarted()) {
            auM();
            this.dam = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void auG() {
        auF();
        if (this.dam.hasCreated()) {
            auN();
            this.dam = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("onUpdateInternalStart").gp(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a afB = afB();
            if (!z2) {
                ava();
            }
            if (!TextUtils.isEmpty(afB.ayR())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(afB.ayR());
            }
        }
        com.baidu.swan.apps.v.f.azN().i(this.cJC);
        pS.f(new UbcFlowEvent("onUpdateStart").gp(true));
        p(z, z2);
        pS.f(new UbcFlowEvent("onUpdateEnd").gp(true));
    }

    private synchronized void auH() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.aqK();
    }

    @DebugTrace
    private synchronized void auI() {
        log("onCreateInternal");
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("frame_start_create"));
        pS.f(new UbcFlowEvent("onCreateInternalStart").gp(true));
        this.dak.auw();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.alM()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        auX();
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        if (!aIn.aFD() || !aIn.aIj().available()) {
            com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(11L).to("aiapp data is invalid");
            com.baidu.swan.apps.al.e.aMQ().j(aVar);
            h.b(new com.baidu.swan.apps.statistic.a.d().sw(h.jr(afr())).i(aVar).a(afB()));
            com.baidu.swan.apps.performance.i.d(aVar);
            com.baidu.swan.apps.ao.e.N(this.cJC);
        } else {
            auQ();
            pS.f(new UbcFlowEvent("onCreateStart").gp(true));
            onCreate();
            pS.f(new UbcFlowEvent("onCreateEnd").gp(true));
            com.baidu.swan.apps.ao.d afq = this.cJC.afq();
            if (afq != null) {
                afq.aNd();
            }
            pS.f(new UbcFlowEvent("onCreateInternalEnd").gp(true));
        }
    }

    private synchronized void auJ() {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("onStartStart").gp(true));
        log("onStartInternal");
        this.dak.aux();
        onStart();
        pS.f(new UbcFlowEvent("onStartEnd").gp(true));
    }

    private synchronized void auK() {
        HybridUbcFlow pS = com.baidu.swan.apps.performance.i.pS("startup");
        pS.f(new UbcFlowEvent("onResumeInternalStart").gp(true));
        log("onResumeInternal");
        this.dak.ajx();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.daj = h.so("607");
        auW();
        if (aFD()) {
            aIj().L(this.cJC);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aCM().aCO();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cJC != null && com.baidu.swan.apps.runtime.e.aIr() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aIr(), com.baidu.swan.apps.env.c.c.atM().hf(10).atN());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.aj.a.aKP().sf("na_page_show");
        com.baidu.swan.apps.v.f.azN().aie();
        pS.f(new UbcFlowEvent("onResumeStart").gp(true));
        onResume();
        pS.f(new UbcFlowEvent("onResumeEnd").gp(true));
    }

    private synchronized void auL() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.azN().aif();
        this.dak.akQ();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.daj != null && aFD()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a afB = afB();
            aVar.mFrom = h.jr(afr());
            aVar.mAppId = afB.getAppId();
            aVar.mSource = afB.ayC();
            aVar.c(afB);
            aVar.sA(afB.ayI().getString("ubc"));
            aVar.cl(h.sq(afB.ayE()));
            h.a(this.daj, aVar);
            this.daj = null;
        }
    }

    private synchronized void auM() {
        com.baidu.swan.apps.performance.i.aDH();
        log("onStopInternal");
        onStop();
        this.dak.amS();
    }

    private synchronized void auN() {
        log("onDestroyInternal");
        onDestroy();
        this.dak.ajw();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aCM().release();
        com.baidu.swan.apps.core.i.a.aqV().release();
        com.baidu.swan.apps.api.b.c.akf().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        auO();
        auR();
        com.baidu.swan.apps.v.f.release();
    }

    private void auO() {
        com.baidu.swan.apps.scheme.actions.k.c.dFx = null;
        com.baidu.swan.apps.performance.i.doF = null;
    }

    public synchronized FrameLifeState auP() {
        return this.dam;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dak.onKeyDown(i, keyEvent);
    }

    public void auQ() {
        if (this.dag == null) {
            this.dag = auV();
        }
        aIi().a((a.c) null, this.dag);
    }

    public void auR() {
        aIi().auR();
        this.dag = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void auS() {
        auT();
        auU();
    }

    private void auT() {
        com.baidu.swan.apps.adaptation.a.b ahO = aIp().afU().ahO();
        if (ahO != null) {
            ahO.bX(this.cJC);
        }
    }

    protected void auU() {
        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
        com.baidu.swan.apps.a.b bVar = null;
        if (aIr != null) {
            bVar = aIr.aIE();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void auW() {
        if (aIj().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.afB(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cJC != null && com.baidu.swan.apps.runtime.e.aIs() != null) {
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
        if (aIj().available()) {
            a(this.cJC, afB().asE(), bitmap, (int) afB().ayB());
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

    private void auX() {
        this.daf = new f(this.cJC);
        auY();
    }

    protected void auY() {
    }

    public f afz() {
        if (this.daf == null) {
            auX();
        }
        return this.daf;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        afD().jX(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean auZ() {
        if (this.daf.apb() != 1) {
            return false;
        }
        this.cJC.moveTaskToBack(true);
        this.cJC.fW(2);
        ap.aOh().kk(1);
        return true;
    }

    public b.a afB() {
        return aIj().aIv();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aFD()) {
            b.a afB = afB();
            fVar.mFrom = h.jr(afr());
            fVar.mAppId = afB.getAppId();
            fVar.mSource = afB.ayC();
            fVar.cl(h.sq(afB.ayE()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.sA(afB.ayI().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.dai = (FrameLayout) this.cJC.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.f(this.cJC, this.dai);
    }

    public void afC() {
        com.baidu.swan.apps.res.widget.loadingview.a.I(this.dai);
    }

    @NonNull
    public com.baidu.swan.apps.ak.f.b afD() {
        return this.dah;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.dak.c(bVar);
    }

    public void b(b bVar) {
        this.dak.d(bVar);
    }

    public boolean nB(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void ava() {
    }

    public void ajy() {
        this.dak.ajy();
    }

    public boolean avb() {
        return com.baidu.swan.apps.v.f.azN().azP();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean avc() {
        return com.baidu.swan.apps.performance.b.b.aDW() ? com.baidu.swan.apps.performance.b.b.avc() : com.baidu.swan.apps.t.a.awB().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
