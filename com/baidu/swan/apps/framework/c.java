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
/* loaded from: classes3.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.b bTK;
    protected final SwanAppActivity cdy;
    private FrameLifeState cuA;
    private FrameLifeState cuB;
    private boolean cuC;
    private boolean cuD;
    private boolean cuE;
    protected f cus;
    protected a.b cuu;
    private final com.baidu.swan.apps.al.f.b cuv;
    private FrameLayout cuw;
    private com.baidu.swan.apps.statistic.a cux;
    private d cuy;
    public final String cuz;

    @NonNull
    protected abstract a.b anQ();

    protected abstract void ant();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aAn());
        this.cuu = null;
        this.cuv = new com.baidu.swan.apps.al.f.b();
        this.cuA = FrameLifeState.INACTIVATED;
        this.cuB = null;
        this.cuC = false;
        this.cuD = false;
        this.bTK = new com.baidu.swan.apps.runtime.b();
        this.cuE = true;
        this.cdy = swanAppActivity;
        this.cuz = str;
        this.cuy = new d();
        v(this.bTK);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cdy.isDestroyed()) {
                final boolean z3 = (!this.cuA.hasCreated()) | z;
                if (this.cuA.hasCreated() && z3) {
                    z2 = true;
                }
                this.cuE = anX();
                if (this.cuE && z2 && !aAj().aAO()) {
                    this.bTK.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void J(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aAn().ayA()) {
                                c.this.bTK.v("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.anv();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == Yy())) {
                    com.baidu.swan.apps.performance.i.a(YI(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        anC();
    }

    public boolean anu() {
        return this.cuD;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aAj().aAO() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cuA)) ? frameLifeState : this.cuA.hasCreated() ? this.cuA : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cuC + " locked=" + this.cuD + " thread=" + Thread.currentThread());
            if (!this.cuD) {
                this.cuB = frameLifeState;
                this.cuD = FrameLifeState.INACTIVATED == this.cuB;
            }
            if (!this.cuC) {
                this.cuC = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.anv();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void anv() {
        synchronized (this) {
            this.cuC = true;
            while (this.cuB != null && anW()) {
                FrameLifeState c = c(this.cuB);
                log("syncLifeState: pendingTarget=" + this.cuB + " fixedTarget=" + c);
                this.cuB = null;
                switch (c) {
                    case JUST_CREATED:
                        anA();
                        anw();
                        break;
                    case JUST_STARTED:
                        anz();
                        anx();
                        break;
                    case JUST_RESUMED:
                        any();
                        break;
                    default:
                        anB();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cuA);
            this.cuD = FrameLifeState.INACTIVATED == this.cuB;
            this.cuC = false;
        }
    }

    private synchronized void anw() {
        if (!this.cuA.hasCreated()) {
            anD();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            ant();
            this.cuA = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void anx() {
        anw();
        if (!this.cuA.hasStarted()) {
            anE();
            this.cuA = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void any() {
        anx();
        if (!this.cuA.hasResumed()) {
            anF();
            this.cuA = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void anz() {
        if (this.cuA.hasResumed()) {
            anG();
            this.cuA = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void anA() {
        anz();
        if (this.cuA.hasStarted()) {
            anH();
            this.cuA = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void anB() {
        anA();
        if (this.cuA.hasCreated()) {
            anI();
            this.cuA = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("onUpdateInternalStart").fa(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a YI = YI();
            if (!z2) {
                anV();
            }
            if (!TextUtils.isEmpty(YI.arM())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(YI.arM());
            }
        }
        com.baidu.swan.apps.v.f.asJ().i(this.cdy);
        pq.f(new UbcFlowEvent("onUpdateStart").fa(true));
        p(z, z2);
        pq.f(new UbcFlowEvent("onUpdateEnd").fa(true));
    }

    private synchronized void anC() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.ajH();
    }

    @DebugTrace
    private synchronized void anD() {
        log("onCreateInternal");
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("frame_start_create"));
        pq.f(new UbcFlowEvent("onCreateInternalStart").fa(true));
        this.cuy.anr();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.aeO()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        anS();
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        if (!aAn.ayA() || !aAn.aAj().available()) {
            com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(11L).sH("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aEQ().j(sH);
            h.b(new com.baidu.swan.apps.statistic.a.d().rO(h.jG(Yy())).i(sH).a(YI()));
            com.baidu.swan.apps.performance.i.d(sH);
            com.baidu.swan.apps.ap.e.M(this.cdy);
        } else {
            anL();
            pq.f(new UbcFlowEvent("onCreateStart").fa(true));
            onCreate();
            pq.f(new UbcFlowEvent("onCreateEnd").fa(true));
            com.baidu.swan.apps.ap.d Yx = this.cdy.Yx();
            if (Yx != null) {
                Yx.aFd();
            }
            pq.f(new UbcFlowEvent("onCreateInternalEnd").fa(true));
        }
    }

    private synchronized void anE() {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("onStartStart").fa(true));
        log("onStartInternal");
        this.cuy.ans();
        onStart();
        pq.f(new UbcFlowEvent("onStartEnd").fa(true));
    }

    private synchronized void anF() {
        HybridUbcFlow pq = com.baidu.swan.apps.performance.i.pq("startup");
        pq.f(new UbcFlowEvent("onResumeInternalStart").fa(true));
        log("onResumeInternal");
        this.cuy.acA();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.cux = h.rH("607");
        anR();
        if (ayA()) {
            aAj().K(this.cdy);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.avF().avH();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cdy != null && com.baidu.swan.apps.runtime.e.aAr() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aAr(), com.baidu.swan.apps.env.c.c.amG().hE(10).amH());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aCP().ry("na_page_show");
        com.baidu.swan.apps.v.f.asJ().abh();
        pq.f(new UbcFlowEvent("onResumeStart").fa(true));
        onResume();
        pq.f(new UbcFlowEvent("onResumeEnd").fa(true));
    }

    private synchronized void anG() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.asJ().abi();
        this.cuy.adT();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.cux != null && ayA()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a YI = YI();
            aVar.mFrom = h.jG(Yy());
            aVar.mAppId = YI.getAppId();
            aVar.mSource = YI.arx();
            aVar.c(YI);
            aVar.rS(YI.arD().getString("ubc"));
            aVar.bR(h.rJ(YI.arz()));
            h.a(this.cux, aVar);
            this.cux = null;
        }
    }

    private synchronized void anH() {
        com.baidu.swan.apps.performance.i.awC();
        log("onStopInternal");
        onStop();
        this.cuy.afV();
    }

    private synchronized void anI() {
        log("onDestroyInternal");
        onDestroy();
        this.cuy.acz();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.avF().release();
        com.baidu.swan.apps.core.i.a.ajS().release();
        com.baidu.swan.apps.api.b.c.adi().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        anJ();
        anM();
        com.baidu.swan.apps.v.f.release();
    }

    private void anJ() {
        com.baidu.swan.apps.scheme.actions.k.c.cVI = null;
        com.baidu.swan.apps.performance.i.cIF = null;
    }

    public synchronized FrameLifeState anK() {
        return this.cuA;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cuy.onKeyDown(i, keyEvent);
    }

    public void anL() {
        if (this.cuu == null) {
            this.cuu = anQ();
        }
        aAi().a((a.c) null, this.cuu);
    }

    public void anM() {
        aAi().anM();
        this.cuu = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anN() {
        anO();
        anP();
    }

    private void anO() {
        com.baidu.swan.apps.adaptation.a.b aaR = aAp().YZ().aaR();
        if (aaR != null) {
            aaR.bf(this.cdy);
        }
    }

    protected void anP() {
        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
        com.baidu.swan.apps.a.b bVar = null;
        if (aAr != null) {
            bVar = aAr.aAE();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void anR() {
        if (aAj().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a = ak.a((com.baidu.swan.apps.u.c.b) c.this.YI(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cdy != null && com.baidu.swan.apps.runtime.e.aAs() != null) {
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
        if (aAj().available()) {
            setTaskDescription(this.cdy, YI().aly(), bitmap, (int) YI().arw());
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

    private void anS() {
        this.cus = new f(this.cdy);
        anT();
    }

    protected void anT() {
    }

    public f YG() {
        if (this.cus == null) {
            anS();
        }
        return this.cus;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        YK().km(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean anU() {
        if (this.cus.ahZ() != 1) {
            return false;
        }
        this.cdy.moveTaskToBack(true);
        this.cdy.gx(2);
        ap.aGh().kz(1);
        return true;
    }

    public b.a YI() {
        return aAj().aAv();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && ayA()) {
            b.a YI = YI();
            fVar.mFrom = h.jG(Yy());
            fVar.mAppId = YI.getAppId();
            fVar.mSource = YI.arx();
            fVar.bR(h.rJ(YI.arz()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.rS(YI.arD().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.cuw = (FrameLayout) this.cdy.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cdy, this.cuw);
    }

    public void YJ() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cuw);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b YK() {
        return this.cuv;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cuy.c(bVar);
    }

    public void b(b bVar) {
        this.cuy.d(bVar);
    }

    public boolean mZ(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void anV() {
    }

    public void acB() {
        this.cuy.acB();
    }

    public boolean anW() {
        return com.baidu.swan.apps.v.f.asJ().asL();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean anX() {
        return com.baidu.swan.apps.performance.b.b.awR() ? com.baidu.swan.apps.performance.b.b.anX() : com.baidu.swan.apps.t.a.apx().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
