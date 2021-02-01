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
    private final com.baidu.swan.apps.runtime.b cCd;
    protected final SwanAppActivity cLQ;
    private FrameLifeState dcA;
    private boolean dcB;
    private boolean dcC;
    private boolean dcD;
    protected f dcr;
    protected a.b dcs;
    private final com.baidu.swan.apps.ak.f.b dct;
    private FrameLayout dcv;
    private com.baidu.swan.apps.statistic.a dcw;
    private d dcx;
    public final String dcy;
    private FrameLifeState dcz;

    protected abstract void auW();

    @NonNull
    protected abstract a.b avt();

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    protected abstract void q(boolean z, boolean z2);

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aIG());
        this.dcs = null;
        this.dct = new com.baidu.swan.apps.ak.f.b();
        this.dcz = FrameLifeState.INACTIVATED;
        this.dcA = null;
        this.dcB = false;
        this.dcC = false;
        this.cCd = new com.baidu.swan.apps.runtime.b();
        this.dcD = true;
        this.cLQ = swanAppActivity;
        this.dcy = str;
        this.dcx = new d();
        v(this.cCd);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.cLQ.isDestroyed()) {
                final boolean z3 = (!this.dcz.hasCreated()) | z;
                if (this.dcz.hasCreated() && z3) {
                    z2 = true;
                }
                this.dcD = avA();
                if (this.dcD && z2 && !aIC().aJh()) {
                    this.cCd.a(new com.baidu.swan.apps.ao.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.ao.e.b
                        /* renamed from: b */
                        public void L(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aIG().aFY()) {
                                c.this.cCd.E("event_first_action_launched");
                                c.this.r(z3, z2);
                                c.this.auY();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    r(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == getFrameType())) {
                    com.baidu.swan.apps.performance.i.a(afZ(), z2);
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        avf();
    }

    public boolean auX() {
        return this.dcC;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aIC().aJh() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.dcz)) ? frameLifeState : this.dcz.hasCreated() ? this.dcz : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.dcB + " locked=" + this.dcC + " thread=" + Thread.currentThread());
            if (!this.dcC) {
                this.dcA = frameLifeState;
                this.dcC = FrameLifeState.INACTIVATED == this.dcA;
            }
            if (!this.dcB) {
                this.dcB = true;
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.auY();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void auY() {
        synchronized (this) {
            this.dcB = true;
            while (this.dcA != null && avz()) {
                FrameLifeState c = c(this.dcA);
                log("syncLifeState: pendingTarget=" + this.dcA + " fixedTarget=" + c);
                this.dcA = null;
                switch (c) {
                    case JUST_CREATED:
                        avd();
                        auZ();
                        break;
                    case JUST_STARTED:
                        avc();
                        ava();
                        break;
                    case JUST_RESUMED:
                        avb();
                        break;
                    default:
                        ave();
                        break;
                }
            }
            log("syncLifeState: done=" + this.dcz);
            this.dcC = FrameLifeState.INACTIVATED == this.dcA;
            this.dcB = false;
        }
    }

    private synchronized void auZ() {
        if (!this.dcz.hasCreated()) {
            avg();
            com.baidu.swan.apps.console.c.i("SwanApp", "onPostCreate: " + this);
            auW();
            this.dcz = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ava() {
        auZ();
        if (!this.dcz.hasStarted()) {
            avh();
            this.dcz = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void avb() {
        ava();
        if (!this.dcz.hasResumed()) {
            avi();
            this.dcz = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void avc() {
        if (this.dcz.hasResumed()) {
            avj();
            this.dcz = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void avd() {
        avc();
        if (this.dcz.hasStarted()) {
            avk();
            this.dcz = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ave() {
        avd();
        if (this.dcz.hasCreated()) {
            avl();
            this.dcz = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void r(boolean z, boolean z2) {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("onUpdateInternalStart").gr(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a afZ = afZ();
            if (!z2) {
                avy();
            }
            if (!TextUtils.isEmpty(afZ.azp())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(afZ.azp());
            }
        }
        com.baidu.swan.apps.v.f.aAl().i(this.cLQ);
        qk.f(new UbcFlowEvent("onUpdateStart").gr(true));
        q(z, z2);
        qk.f(new UbcFlowEvent("onUpdateEnd").gr(true));
    }

    private synchronized void avf() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.v.f.release();
        com.baidu.swan.apps.core.pms.f.a.ari();
    }

    @DebugTrace
    private synchronized void avg() {
        log("onCreateInternal");
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("frame_start_create"));
        qk.f(new UbcFlowEvent("onCreateInternalStart").gr(true));
        this.dcx.auU();
        com.baidu.swan.apps.console.c.i("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.amk()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        avv();
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        if (!aIG.aFY() || !aIG.aIC().available()) {
            com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(5L).dc(11L).tH("aiapp data is invalid");
            com.baidu.swan.apps.al.e.aNj().j(tH);
            h.b(new com.baidu.swan.apps.statistic.a.d().sP(h.ju(getFrameType())).i(tH).a(afZ()));
            com.baidu.swan.apps.performance.i.d(tH);
            com.baidu.swan.apps.ao.e.H(this.cLQ);
        } else {
            avo();
            qk.f(new UbcFlowEvent("onCreateStart").gr(true));
            onCreate();
            qk.f(new UbcFlowEvent("onCreateEnd").gr(true));
            com.baidu.swan.apps.ao.d afP = this.cLQ.afP();
            if (afP != null) {
                afP.aNw();
            }
            qk.f(new UbcFlowEvent("onCreateInternalEnd").gr(true));
        }
    }

    private synchronized void avh() {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("onStartStart").gr(true));
        log("onStartInternal");
        this.dcx.auV();
        onStart();
        qk.f(new UbcFlowEvent("onStartEnd").gr(true));
    }

    private synchronized void avi() {
        HybridUbcFlow qk = com.baidu.swan.apps.performance.i.qk("startup");
        qk.f(new UbcFlowEvent("onResumeInternalStart").gr(true));
        log("onResumeInternal");
        this.dcx.ajV();
        com.baidu.swan.apps.console.c.i("SwanApp", "onResume: " + this);
        this.dcw = h.sI("607");
        avu();
        if (aFY()) {
            aIC().F(this.cLQ);
        }
        p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.aDi().aDk();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.cLQ != null && com.baidu.swan.apps.runtime.e.aIK() != null) {
                    com.baidu.swan.apps.database.a.b.a(com.baidu.swan.apps.runtime.e.aIK(), com.baidu.swan.apps.env.c.c.auk().hi(10).aul());
                }
            }
        }, "saveSwanAppHistory");
        com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.aj.a.aLi().sz("na_page_show");
        com.baidu.swan.apps.v.f.aAl().aiC();
        qk.f(new UbcFlowEvent("onResumeStart").gr(true));
        onResume();
        qk.f(new UbcFlowEvent("onResumeEnd").gr(true));
    }

    private synchronized void avj() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.v.f.aAl().aiD();
        this.dcx.alo();
        com.baidu.swan.apps.console.c.i("SwanApp", "onPause: " + this);
        if (this.dcw != null && aFY()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a afZ = afZ();
            aVar.mFrom = h.ju(getFrameType());
            aVar.mAppId = afZ.getAppId();
            aVar.mSource = afZ.aza();
            aVar.c(afZ);
            aVar.sT(afZ.azg().getString("ubc"));
            aVar.ci(h.sK(afZ.azc()));
            h.a(this.dcw, aVar);
            this.dcw = null;
        }
    }

    private synchronized void avk() {
        com.baidu.swan.apps.performance.i.aEc();
        log("onStopInternal");
        onStop();
        this.dcx.anq();
    }

    private synchronized void avl() {
        log("onDestroyInternal");
        onDestroy();
        this.dcx.ajU();
        com.baidu.swan.apps.console.c.i("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.aDi().release();
        com.baidu.swan.apps.core.i.a.art().release();
        com.baidu.swan.apps.api.b.c.akD().release();
        com.baidu.swan.apps.performance.e.d.releaseInstance();
        avm();
        avp();
        com.baidu.swan.apps.v.f.release();
    }

    private void avm() {
        com.baidu.swan.apps.scheme.actions.k.c.dHB = null;
        com.baidu.swan.apps.performance.i.dqQ = null;
    }

    public synchronized FrameLifeState avn() {
        return this.dcz;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.dcx.onKeyDown(i, keyEvent);
    }

    public void avo() {
        if (this.dcs == null) {
            this.dcs = avt();
        }
        aIB().a((a.c) null, this.dcs);
    }

    public void avp() {
        aIB().avp();
        this.dcs = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avq() {
        avr();
        avs();
    }

    private void avr() {
        com.baidu.swan.apps.adaptation.a.b aim = aII().ags().aim();
        if (aim != null) {
            aim.bW(this.cLQ);
        }
    }

    protected void avs() {
        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
        com.baidu.swan.apps.a.b bVar = null;
        if (aIK != null) {
            bVar = aIK.aIX();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void avu() {
        if (aIC().available()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4
                @Override // java.lang.Runnable
                public void run() {
                    final Bitmap a2 = ak.a((com.baidu.swan.apps.u.c.b) c.this.afZ(), "SwanActivityFrame", true);
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.this.cLQ != null && com.baidu.swan.apps.runtime.e.aIL() != null) {
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
        if (aIC().available()) {
            a(this.cLQ, afZ().atc(), bitmap, (int) afZ().ayZ());
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

    private void avv() {
        this.dcr = new f(this.cLQ);
        avw();
    }

    protected void avw() {
    }

    public f afX() {
        if (this.dcr == null) {
            avv();
        }
        return this.dcr;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        agb().ka(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean avx() {
        if (this.dcr.apA() != 1) {
            return false;
        }
        this.cLQ.moveTaskToBack(true);
        this.cLQ.fZ(2);
        ap.aOA().kn(1);
        return true;
    }

    public b.a afZ() {
        return aIC().aIO();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && aFY()) {
            b.a afZ = afZ();
            fVar.mFrom = h.ju(getFrameType());
            fVar.mAppId = afZ.getAppId();
            fVar.mSource = afZ.aza();
            fVar.ci(h.sK(afZ.azc()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.sT(afZ.azg().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void showLoadingView() {
        this.dcv = (FrameLayout) this.cLQ.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.f(this.cLQ, this.dcv);
    }

    public void aga() {
        com.baidu.swan.apps.res.widget.loadingview.a.G(this.dcv);
    }

    @NonNull
    public com.baidu.swan.apps.ak.f.b agb() {
        return this.dct;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.dcx.c(bVar);
    }

    public void b(b bVar) {
        this.dcx.d(bVar);
    }

    public boolean nT(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void avy() {
    }

    public void ajW() {
        this.dcx.ajW();
    }

    public boolean avz() {
        return com.baidu.swan.apps.v.f.aAl().aAn();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }

    public static boolean avA() {
        return com.baidu.swan.apps.performance.b.b.aEr() ? com.baidu.swan.apps.performance.b.b.avA() : com.baidu.swan.apps.t.a.awZ().getSwitch("swan_fixed_relaunch_switch", true);
    }
}
