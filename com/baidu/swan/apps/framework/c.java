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
    private final com.baidu.swan.apps.runtime.b cDD;
    protected final SwanAppActivity cNq;
    protected f ddU;
    protected a.b ddV;
    private final com.baidu.swan.apps.ak.f.b ddW;
    private FrameLayout ddX;
    private com.baidu.swan.apps.statistic.a ddY;
    private d ddZ;
    public final String dea;
    private FrameLifeState deb;
    private FrameLifeState dec;
    private boolean ded;
    private boolean dee;
    private boolean def;

    protected abstract void auZ();

    @NonNull
    protected abstract a.b avw();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void q(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aIJ());
        this.ddV = null;
        this.ddW = new com.baidu.swan.apps.ak.f.b();
        this.deb = FrameLifeState.INACTIVATED;
        this.dec = null;
        this.ded = false;
        this.dee = false;
        this.cDD = new com.baidu.swan.apps.runtime.b();
        this.def = true;
        this.cNq = swanAppActivity;
        this.dea = str;
        this.ddZ = new d();
        v(this.cDD);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cNq.isDestroyed()) {
                final boolean z3 = (!this.deb.hasCreated()) | z;
                if (this.deb.hasCreated() && z3) {
                    z2 = true;
                }
                this.def = avD();
                if (this.def && z2 && !aIF().aJk()) {
                    this.cDD.a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void N(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aIJ().aGb()) {
                                c.this.cDD.E("event_first_action_launched");
                                c.this.r(z3, z2);
                                c.this.avb();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    r(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == getFrameType())) {
                    com.baidu.swan.apps.performance.i.a(agc(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        avi();
    }

    public boolean ava() {
        return this.dee;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aIF().aJk() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.deb)) ? frameLifeState : this.deb.hasCreated() ? this.deb : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.ded + " locked=" + this.dee + " thread=" + Thread.currentThread());
            if (!this.dee) {
                this.dec = frameLifeState;
                this.dee = FrameLifeState.INACTIVATED == this.dec;
            }
            if (!this.ded) {
                this.ded = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.avb();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void avb() {
        synchronized (this) {
            this.ded = true;
            while (this.dec != null && avC()) {
                FrameLifeState c = c(this.dec);
                log("syncLifeState: pendingTarget=" + this.dec + " fixedTarget=" + c);
                this.dec = null;
                switch (c) {
                    case JUST_CREATED:
                        avg();
                        avc();
                        break;
                    case JUST_STARTED:
                        avf();
                        avd();
                        break;
                    case JUST_RESUMED:
                        ave();
                        break;
                    default:
                        avh();
                        break;
                }
            }
            log("syncLifeState: done=" + this.deb);
            this.dee = FrameLifeState.INACTIVATED == this.dec;
            this.ded = false;
        }
    }

    private synchronized void avc() {
        if (!this.deb.hasCreated()) {
            avj();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            auZ();
            this.deb = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void avd() {
        avc();
        if (!this.deb.hasStarted()) {
            avk();
            this.deb = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void ave() {
        avd();
        if (!this.deb.hasResumed()) {
            avl();
            this.deb = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void avf() {
        if (this.deb.hasResumed()) {
            avm();
            this.deb = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void avg() {
        avf();
        if (this.deb.hasStarted()) {
            avn();
            this.deb = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void avh() {
        avg();
        if (this.deb.hasCreated()) {
            avo();
            this.deb = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(boolean z, boolean z2) {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("onUpdateInternalStart").gr(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a agc = agc();
            if (!z2) {
                avB();
            }
            if (!TextUtils.isEmpty(agc.azs())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(agc.azs());
            }
        }
        com.baidu.swan.apps.v.f.aAo().i(this.cNq);
        qr.f(new UbcFlowEvent("onUpdateStart").gr(true));
        q(z, z2);
        qr.f(new UbcFlowEvent("onUpdateEnd").gr(true));
    }

    private synchronized void avi() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.arl();
    }

    @DebugTrace
    private synchronized void avj() {
        log("onCreateInternal");
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("frame_start_create"));
        qr.f(new UbcFlowEvent("onCreateInternalStart").gr(true));
        this.ddZ.auX();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.amn()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        avy();
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        if (!aIJ.aGb() || !aIJ.aIF().available()) {
            com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(11L).tO("aiapp data is invalid");
            com.baidu.swan.apps.al.e.aNm().j(tO);
            h.b(new com.baidu.swan.apps.statistic.a.d().sW(h.jv(getFrameType())).i(tO).a(agc()));
            com.baidu.swan.apps.performance.i.d(tO);
            com.baidu.swan.apps.ao.e.H(this.cNq);
        } else {
            avr();
            qr.f(new UbcFlowEvent("onCreateStart").gr(true));
            onCreate();
            qr.f(new UbcFlowEvent("onCreateEnd").gr(true));
            com.baidu.swan.apps.ao.d afS = this.cNq.afS();
            if (afS != null) {
                afS.aNz();
            }
            qr.f(new UbcFlowEvent("onCreateInternalEnd").gr(true));
        }
    }

    private synchronized void avk() {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("onStartStart").gr(true));
        log("onStartInternal");
        this.ddZ.auY();
        onStart();
        qr.f(new UbcFlowEvent("onStartEnd").gr(true));
    }

    private synchronized void avl() {
        HybridUbcFlow qr = com.baidu.swan.apps.performance.i.qr("startup");
        qr.f(new UbcFlowEvent("onResumeInternalStart").gr(true));
        log("onResumeInternal");
        this.ddZ.ajY();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.ddY = h.sP("607");
        avx();
        if (aGb()) {
            aIF().F(this.cNq);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aDl().aDn();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cNq != null && com.baidu.swan.apps.runtime.e.aIN() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aIN(), com.baidu.swan.apps.env.c.c.aun().hj(10).auo());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.aj.a.aLl().sG("na_page_show");
        com.baidu.swan.apps.v.f.aAo().aiF();
        qr.f(new UbcFlowEvent("onResumeStart").gr(true));
        onResume();
        qr.f(new UbcFlowEvent("onResumeEnd").gr(true));
    }

    private synchronized void avm() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.aAo().aiG();
        this.ddZ.alr();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.ddY != null && aGb()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a agc = agc();
            aVar.mFrom = h.jv(getFrameType());
            aVar.mAppId = agc.getAppId();
            aVar.mSource = agc.azd();
            aVar.c(agc);
            aVar.ta(agc.azj().getString("ubc"));
            aVar.ck(h.sR(agc.azf()));
            h.a(this.ddY, aVar);
            this.ddY = null;
        }
    }

    private synchronized void avn() {
        com.baidu.swan.apps.performance.i.aEf();
        log("onStopInternal");
        onStop();
        this.ddZ.ant();
    }

    private synchronized void avo() {
        log("onDestroyInternal");
        onDestroy();
        this.ddZ.ajX();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aDl().release();
        com.baidu.swan.apps.core.i.a.arw().release();
        com.baidu.swan.apps.api.b.c.akG().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        avp();
        avs();
        com.baidu.swan.apps.v.f.release();
    }

    private void avp() {
        com.baidu.swan.apps.scheme.actions.k.c.dJc = null;
        com.baidu.swan.apps.performance.i.dss = null;
    }

    public synchronized FrameLifeState avq() {
        return this.deb;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.ddZ.onKeyDown(i, keyEvent);
    }

    public void avr() {
        if (this.ddV == null) {
            this.ddV = avw();
        }
        aIE().a((a.c) null, this.ddV);
    }

    public void avs() {
        aIE().avs();
        this.ddV = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avt() {
        avu();
        avv();
    }

    private void avu() {
        com.baidu.swan.apps.adaptation.a.b aip = aIL().agv().aip();
        if (aip != null) {
            aip.bV(this.cNq);
        }
    }

    protected void avv() {
        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
        com.baidu.swan.apps.a.b bVar = null;
        if (aIN != null) {
            bVar = aIN.aJa();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void avx() {
        if (aIF().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.agc(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cNq != null && com.baidu.swan.apps.runtime.e.aIO() != null) {
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
        if (aIF().available()) {
            a(this.cNq, agc().atf(), bitmap, (int) agc().azc());
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

    private void avy() {
        this.ddU = new f(this.cNq);
        avz();
    }

    protected void avz() {
    }

    public f aga() {
        if (this.ddU == null) {
            avy();
        }
        return this.ddU;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        age().kb(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avA() {
        if (this.ddU.apD() != 1) {
            return false;
        }
        this.cNq.moveTaskToBack(true);
        this.cNq.ga(2);
        ap.aOD().ko(1);
        return true;
    }

    public b.a agc() {
        return aIF().aIR();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aGb()) {
            b.a agc = agc();
            fVar.mFrom = h.jv(getFrameType());
            fVar.mAppId = agc.getAppId();
            fVar.mSource = agc.azd();
            fVar.ck(h.sR(agc.azf()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.ta(agc.azj().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.ddX = (FrameLayout) this.cNq.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.f(this.cNq, this.ddX);
    }

    public void agd() {
        com.baidu.swan.apps.res.widget.loadingview.a.G(this.ddX);
    }

    @NonNull
    public com.baidu.swan.apps.ak.f.b age() {
        return this.ddW;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.ddZ.c(bVar);
    }

    public void b(b bVar) {
        this.ddZ.d(bVar);
    }

    public boolean oa(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avB() {
    }

    public void ajZ() {
        this.ddZ.ajZ();
    }

    public boolean avC() {
        return com.baidu.swan.apps.v.f.aAo().aAq();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean avD() {
        return com.baidu.swan.apps.performance.b.b.aEu() ? com.baidu.swan.apps.performance.b.b.avD() : com.baidu.swan.apps.t.a.axc().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
