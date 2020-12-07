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
/* loaded from: classes25.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity cJt;
    protected f cZZ;
    private final com.baidu.swan.apps.runtime.b czF;
    protected a.b daa;
    private final com.baidu.swan.apps.al.f.b dab;
    private FrameLayout dac;
    private com.baidu.swan.apps.statistic.a dad;
    private d dae;
    public final String daf;
    private FrameLifeState dag;
    private FrameLifeState dah;
    private boolean dai;
    private boolean daj;
    private boolean dak;

    protected abstract void axa();

    @NonNull
    protected abstract a.b axx();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void p(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aJQ());
        this.daa = null;
        this.dab = new com.baidu.swan.apps.al.f.b();
        this.dag = FrameLifeState.INACTIVATED;
        this.dah = null;
        this.dai = false;
        this.daj = false;
        this.czF = new com.baidu.swan.apps.runtime.b();
        this.dak = true;
        this.cJt = swanAppActivity;
        this.daf = str;
        this.dae = new d();
        v(this.czF);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cJt.isDestroyed()) {
                final boolean z3 = (!this.dag.hasCreated()) | z;
                if (this.dag.hasCreated() && z3) {
                    z2 = true;
                }
                this.dak = axE();
                if (this.dak && z2 && !aJM().aKr()) {
                    this.czF.a(new com.baidu.swan.apps.ap.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ap.e.b
                        /* renamed from: b */
                        public void M(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aJQ().aId()) {
                                c.this.czF.x("event_first_action_launched");
                                c.this.q(z3, z2);
                                c.this.axc();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    q(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == aie())) {
                    com.baidu.swan.apps.performance.i.a(aio(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        axj();
    }

    public boolean axb() {
        return this.daj;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aJM().aKr() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.dag)) ? frameLifeState : this.dag.hasCreated() ? this.dag : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.dai + " locked=" + this.daj + " thread=" + Thread.currentThread());
            if (!this.daj) {
                this.dah = frameLifeState;
                this.daj = FrameLifeState.INACTIVATED == this.dah;
            }
            if (!this.dai) {
                this.dai = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.axc();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void axc() {
        synchronized (this) {
            this.dai = true;
            while (this.dah != null && axD()) {
                FrameLifeState c = c(this.dah);
                log("syncLifeState: pendingTarget=" + this.dah + " fixedTarget=" + c);
                this.dah = null;
                switch (c) {
                    case JUST_CREATED:
                        axh();
                        axd();
                        break;
                    case JUST_STARTED:
                        axg();
                        axe();
                        break;
                    case JUST_RESUMED:
                        axf();
                        break;
                    default:
                        axi();
                        break;
                }
            }
            log("syncLifeState: done=" + this.dag);
            this.daj = FrameLifeState.INACTIVATED == this.dah;
            this.dai = false;
        }
    }

    private synchronized void axd() {
        if (!this.dag.hasCreated()) {
            axk();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            axa();
            this.dag = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void axe() {
        axd();
        if (!this.dag.hasStarted()) {
            axl();
            this.dag = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void axf() {
        axe();
        if (!this.dag.hasResumed()) {
            axm();
            this.dag = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void axg() {
        if (this.dag.hasResumed()) {
            axn();
            this.dag = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void axh() {
        axg();
        if (this.dag.hasStarted()) {
            axo();
            this.dag = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void axi() {
        axh();
        if (this.dag.hasCreated()) {
            axp();
            this.dag = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void q(boolean z, boolean z2) {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("onUpdateInternalStart").gk(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a aio = aio();
            if (!z2) {
                axC();
            }
            if (!TextUtils.isEmpty(aio.aBt())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(aio.aBt());
            }
        }
        com.baidu.swan.apps.v.f.aCp().i(this.cJt);
        rk.f(new UbcFlowEvent("onUpdateStart").gk(true));
        p(z, z2);
        rk.f(new UbcFlowEvent("onUpdateEnd").gk(true));
    }

    private synchronized void axj() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.atn();
    }

    @DebugTrace
    private synchronized void axk() {
        log("onCreateInternal");
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("frame_start_create"));
        rk.f(new UbcFlowEvent("onCreateInternalStart").gk(true));
        this.dae.awY();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.aot()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        axz();
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        if (!aJQ.aId() || !aJQ.aJM().available()) {
            com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(11L).uC("aiapp data is invalid");
            com.baidu.swan.apps.am.e.aOs().j(uC);
            h.b(new com.baidu.swan.apps.statistic.a.d().tK(h.kS(aie())).i(uC).a(aio()));
            com.baidu.swan.apps.performance.i.d(uC);
            com.baidu.swan.apps.ap.e.M(this.cJt);
        } else {
            axs();
            rk.f(new UbcFlowEvent("onCreateStart").gk(true));
            onCreate();
            rk.f(new UbcFlowEvent("onCreateEnd").gk(true));
            com.baidu.swan.apps.ap.d aid = this.cJt.aid();
            if (aid != null) {
                aid.aOF();
            }
            rk.f(new UbcFlowEvent("onCreateInternalEnd").gk(true));
        }
    }

    private synchronized void axl() {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("onStartStart").gk(true));
        log("onStartInternal");
        this.dae.awZ();
        onStart();
        rk.f(new UbcFlowEvent("onStartEnd").gk(true));
    }

    private synchronized void axm() {
        HybridUbcFlow rk = com.baidu.swan.apps.performance.i.rk("startup");
        rk.f(new UbcFlowEvent("onResumeInternalStart").gk(true));
        log("onResumeInternal");
        this.dae.amg();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.dad = h.tD("607");
        axy();
        if (aId()) {
            aJM().K(this.cJt);
        }
        p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aFl().aFn();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cJt != null && com.baidu.swan.apps.runtime.e.aJU() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aJU(), com.baidu.swan.apps.env.c.c.awn().iQ(10).awo());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.ak.a.aMs().tu("na_page_show");
        com.baidu.swan.apps.v.f.aCp().akN();
        rk.f(new UbcFlowEvent("onResumeStart").gk(true));
        onResume();
        rk.f(new UbcFlowEvent("onResumeEnd").gk(true));
    }

    private synchronized void axn() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.aCp().akO();
        this.dae.any();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.dad != null && aId()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a aio = aio();
            aVar.mFrom = h.kS(aie());
            aVar.mAppId = aio.getAppId();
            aVar.mSource = aio.aBe();
            aVar.c(aio);
            aVar.tO(aio.aBk().getString("ubc"));
            aVar.cd(h.tF(aio.aBg()));
            h.a(this.dad, aVar);
            this.dad = null;
        }
    }

    private synchronized void axo() {
        com.baidu.swan.apps.performance.i.aGh();
        log("onStopInternal");
        onStop();
        this.dae.apA();
    }

    private synchronized void axp() {
        log("onDestroyInternal");
        onDestroy();
        this.dae.amf();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aFl().release();
        com.baidu.swan.apps.core.i.a.aty().release();
        com.baidu.swan.apps.api.b.c.amO().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        axq();
        axt();
        com.baidu.swan.apps.v.f.release();
    }

    private void axq() {
        com.baidu.swan.apps.scheme.actions.k.c.dBE = null;
        com.baidu.swan.apps.performance.i.dow = null;
    }

    public synchronized FrameLifeState axr() {
        return this.dag;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dae.onKeyDown(i, keyEvent);
    }

    public void axs() {
        if (this.daa == null) {
            this.daa = axx();
        }
        aJL().a((a.c) null, this.daa);
    }

    public void axt() {
        aJL().axt();
        this.daa = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void axu() {
        axv();
        axw();
    }

    private void axv() {
        com.baidu.swan.apps.adaptation.a.b akx = aJS().aiF().akx();
        if (akx != null) {
            akx.bR(this.cJt);
        }
    }

    protected void axw() {
        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
        com.baidu.swan.apps.a.b bVar = null;
        if (aJU != null) {
            bVar = aJU.aKh();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void axy() {
        if (aJM().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.aio(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cJt != null && com.baidu.swan.apps.runtime.e.aJV() != null) {
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
        if (aJM().available()) {
            setTaskDescription(this.cJt, aio().avf(), bitmap, (int) aio().aBd());
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

    private void axz() {
        this.cZZ = new f(this.cJt);
        axA();
    }

    protected void axA() {
    }

    public f aim() {
        if (this.cZZ == null) {
            axz();
        }
        return this.cZZ;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        aiq().ly(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean axB() {
        if (this.cZZ.arE() != 1) {
            return false;
        }
        this.cJt.moveTaskToBack(true);
        this.cJt.hJ(2);
        ap.aPI().lL(1);
        return true;
    }

    public b.a aio() {
        return aJM().aJY();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aId()) {
            b.a aio = aio();
            fVar.mFrom = h.kS(aie());
            fVar.mAppId = aio.getAppId();
            fVar.mSource = aio.aBe();
            fVar.cd(h.tF(aio.aBg()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.tO(aio.aBk().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.dac = (FrameLayout) this.cJt.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.cJt, this.dac);
    }

    public void aip() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.dac);
    }

    @NonNull
    public com.baidu.swan.apps.al.f.b aiq() {
        return this.dab;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.dae.c(bVar);
    }

    public void b(b bVar) {
        this.dae.d(bVar);
    }

    public boolean oV(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void axC() {
    }

    public void amh() {
        this.dae.amh();
    }

    public boolean axD() {
        return com.baidu.swan.apps.v.f.aCp().aCr();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean axE() {
        return com.baidu.swan.apps.performance.b.b.aGw() ? com.baidu.swan.apps.performance.b.b.axE() : com.baidu.swan.apps.t.a.azd().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
