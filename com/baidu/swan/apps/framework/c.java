package com.baidu.swan.apps.framework;

import android.app.Activity;
import android.app.ActivityManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import com.baidu.mobstat.Config;
import com.baidu.searchbox.aop.annotation.DebugTrace;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.af.c;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.l;
import com.baidu.swan.apps.x.b.b;
import com.baidu.swan.ubc.Flow;
/* loaded from: classes11.dex */
public abstract class c extends l {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    protected final SwanAppActivity bHg;
    protected com.baidu.swan.apps.core.d.e bTQ;
    protected a.b bTR;
    private final com.baidu.swan.apps.ao.f.b bTS;
    private com.baidu.swan.apps.af.c bTT;
    private FrameLayout bTU;
    private Flow bTV;
    private d bTW;
    public final String bTX;
    private FrameLifeState bTY;
    private FrameLifeState bTZ;
    private boolean bUa;
    private boolean bUb;

    @NonNull
    protected abstract a.b aaI();

    protected abstract void aal();

    protected abstract void l(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.akK());
        this.bTR = null;
        this.bTS = new com.baidu.swan.apps.ao.f.b();
        this.bTY = FrameLifeState.INACTIVATED;
        this.bTZ = null;
        this.bUa = false;
        this.bUb = false;
        this.bHg = swanAppActivity;
        this.bTX = str;
        this.bTW = new d();
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        boolean z2 = false;
        synchronized (this) {
            if (!this.bHg.isDestroyed()) {
                boolean z3 = (!this.bTY.hasCreated()) | z;
                if (this.bTY.hasCreated() && z3) {
                    z2 = true;
                }
                m(z3, z2);
                d(frameLifeState);
                if (z3 && (z2 || 1 == Om())) {
                    f.h(Ow());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        aau();
    }

    public boolean aam() {
        return this.bUb;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || akH().ali() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.bTY)) ? frameLifeState : this.bTY.hasCreated() ? this.bTY : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.bUa + " locked=" + this.bUb + " thread=" + Thread.currentThread());
            if (!this.bUb) {
                this.bTZ = frameLifeState;
                this.bUb = FrameLifeState.INACTIVATED == this.bTZ;
            }
            if (!this.bUa) {
                this.bUa = true;
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.aan();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void aan() {
        synchronized (this) {
            this.bUa = true;
            while (this.bTZ != null && aaO()) {
                FrameLifeState c = c(this.bTZ);
                log("syncLifeState: pendingTarget=" + this.bTZ + " fixedTarget=" + c);
                this.bTZ = null;
                switch (c) {
                    case JUST_CREATED:
                        aas();
                        aao();
                        break;
                    case JUST_STARTED:
                        aar();
                        aap();
                        break;
                    case JUST_RESUMED:
                        aaq();
                        break;
                    default:
                        aat();
                        break;
                }
            }
            log("syncLifeState: done=" + this.bTY);
            this.bUb = FrameLifeState.INACTIVATED == this.bTZ;
            this.bUa = false;
        }
    }

    private synchronized void aao() {
        if (!this.bTY.hasCreated()) {
            aav();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            aal();
            this.bTY = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aap() {
        aao();
        if (!this.bTY.hasStarted()) {
            aaw();
            this.bTY = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aaq() {
        aap();
        if (!this.bTY.hasResumed()) {
            aax();
            this.bTY = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void aar() {
        if (this.bTY.hasResumed()) {
            aay();
            this.bTY = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void aas() {
        aar();
        if (this.bTY.hasStarted()) {
            aaz();
            this.bTY = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void aat() {
        aas();
        if (this.bTY.hasCreated()) {
            aaA();
            this.bTY = FrameLifeState.INACTIVATED;
        }
    }

    private synchronized void m(boolean z, boolean z2) {
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("onUpdateInternalStart").ed(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a Ow = Ow();
            if (!z2) {
                aaN();
            }
            if (!TextUtils.isEmpty(Ow.adQ())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(Ow.adQ());
            }
        }
        com.baidu.swan.apps.y.f aeK = com.baidu.swan.apps.y.f.aeK();
        if (!aaO()) {
            aeK.i(this.bHg);
        }
        lb.f(new UbcFlowEvent("onUpdateStart").ed(true));
        l(z, z2);
        lb.f(new UbcFlowEvent("onUpdateEnd").ed(true));
    }

    private synchronized void aau() {
        log("onReleaseInternal");
        onRelease();
        com.baidu.swan.apps.y.f.release();
    }

    @DebugTrace
    private synchronized void aav() {
        log("onCreateInternal");
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("frame_start_create"));
        lb.f(new UbcFlowEvent("onCreateInternalStart").ed(true));
        this.bTW.aai();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.TG()) {
            com.baidu.swan.apps.core.k.d.release();
        }
        aaK();
        com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
        if (!akK.ajr() || !akK.akH().available()) {
            com.baidu.swan.apps.ap.a nL = new com.baidu.swan.apps.ap.a().bn(5L).bo(11L).nL("aiapp data is invalid");
            com.baidu.swan.apps.ap.e.aow().f(nL);
            com.baidu.swan.apps.statistic.f.b(new com.baidu.swan.apps.statistic.a.d().mZ(com.baidu.swan.apps.statistic.f.gz(Om())).e(nL).a(Ow()));
            com.baidu.swan.apps.as.c.P(this.bHg);
        } else {
            com.baidu.swan.apps.runtime.e akH = akK.akH();
            akH.akX().ami();
            akH.akY().clear();
            aaC();
            lb.f(new UbcFlowEvent("onCreateStart").ed(true));
            onCreate();
            lb.f(new UbcFlowEvent("onCreateEnd").ed(true));
            com.baidu.swan.apps.as.b Ol = this.bHg.Ol();
            if (Ol != null) {
                Ol.aoC();
            }
            lb.f(new UbcFlowEvent("onCreateInternalEnd").ed(true));
        }
    }

    private synchronized void aaw() {
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("onStartStart").ed(true));
        log("onStartInternal");
        this.bTW.aaj();
        onStart();
        lb.f(new UbcFlowEvent("onStartEnd").ed(true));
    }

    private synchronized void aax() {
        HybridUbcFlow lb = f.lb("startup");
        lb.f(new UbcFlowEvent("onResumeInternalStart").ed(true));
        log("onResumeInternal");
        this.bTW.RA();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.bTV = com.baidu.swan.apps.statistic.f.mT("607");
        aaJ();
        if (ajr()) {
            akH().onActivityResume(this.bHg);
        }
        m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.ahk().ahm();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bHg != null && com.baidu.swan.apps.runtime.e.akN() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.akN());
                }
            }
        }, "saveSwanAppHistory");
        f.lb("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.an.a.amP().mO("na_page_show");
        com.baidu.swan.apps.y.f.aeK().Qn();
        lb.f(new UbcFlowEvent("onResumeStart").ed(true));
        onResume();
        lb.f(new UbcFlowEvent("onResumeEnd").ed(true));
    }

    private synchronized void aay() {
        log("onPauseInternal");
        onPause();
        com.baidu.swan.apps.y.f.aeK().Qo();
        this.bTW.SH();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.bTV != null && ajr()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a Ow = Ow();
            aVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Om());
            aVar.mAppId = Ow.getAppId();
            aVar.mSource = Ow.adB();
            aVar.c(Ow);
            aVar.nd(Ow.adH().getString("ubc"));
            aVar.bl(com.baidu.swan.apps.statistic.f.mU(Ow.adD()));
            com.baidu.swan.apps.statistic.f.a(this.bTV, aVar);
            this.bTV = null;
        }
    }

    private synchronized void aaz() {
        log("onStopInternal");
        onStop();
        this.bTW.aak();
    }

    private synchronized void aaA() {
        log("onDestroyInternal");
        onDestroy();
        this.bTW.Rz();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.ahk().release();
        com.baidu.swan.apps.performance.b.d.releaseInstance();
        aaD();
        com.baidu.swan.apps.y.f.release();
    }

    public synchronized FrameLifeState aaB() {
        return this.bTY;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.bTW.onKeyDown(i, keyEvent);
    }

    public void aaC() {
        if (this.bTR == null) {
            this.bTR = aaI();
        }
        akG().a((a.c) null, this.bTR);
    }

    public void aaD() {
        akG().aaD();
        this.bTR = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaE() {
        b.a Ow;
        Bundle adG;
        if (ajr() && (adG = (Ow = Ow()).adG()) != null && adG.getLong("launch_flag_for_statistic") > 0) {
            long j = Ow.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Om());
            fVar.mAppId = Ow.getAppId();
            if (com.baidu.swan.apps.ah.a.a.lA(Ow().adQ())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = Ow.adB();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.cux = String.valueOf(currentTimeMillis - j);
            fVar.s("status", "0");
            fVar.nd(Ow.adH().getString("ubc"));
            fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ow.adD()));
            com.baidu.swan.apps.statistic.f.onEvent(fVar);
            adG.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaF() {
        aaG();
        aaH();
    }

    private void aaG() {
        com.baidu.swan.apps.adaptation.a.b PI = akM().ON().PI();
        if (PI != null) {
            PI.bb(this.bHg);
        }
    }

    protected void aaH() {
        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
        com.baidu.swan.apps.a.b bVar = null;
        if (akN != null) {
            bVar = akN.akY();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void aaJ() {
        if (akH().available()) {
            setTaskDescription(this.bHg, Ow().YT(), ai.a((com.baidu.swan.apps.x.b.b) Ow(), "SwanActivityFrame", true), (int) Ow().adA());
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

    private void aaK() {
        this.bTQ = new com.baidu.swan.apps.core.d.e(this.bHg);
        aaL();
    }

    protected void aaL() {
    }

    public com.baidu.swan.apps.core.d.e Ou() {
        return this.bTQ;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        Oy().hc(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean aaM() {
        if (this.bTQ.Wh() != 1) {
            return false;
        }
        this.bHg.moveTaskToBack(true);
        this.bHg.dW(2);
        return true;
    }

    public b.a Ow() {
        return akH().akQ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && ajr()) {
            b.a Ow = Ow();
            fVar.mFrom = com.baidu.swan.apps.statistic.f.gz(Om());
            fVar.mAppId = Ow.getAppId();
            fVar.mSource = Ow.adB();
            fVar.bl(com.baidu.swan.apps.statistic.f.mU(Ow.adD()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.nd(Ow.adH().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.b.b(fVar);
            } else {
                com.baidu.swan.apps.statistic.f.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.bTT == null) {
                this.bTT = new com.baidu.swan.apps.af.c();
            }
            this.bTT.a(this.bHg, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.bTT != null) {
            this.bTT.a(this.bHg, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.bTU = (FrameLayout) this.bHg.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bHg, this.bTU);
    }

    public void Ox() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.bTU);
    }

    @NonNull
    public com.baidu.swan.apps.ao.f.b Oy() {
        return this.bTS;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.bTW.c(bVar);
    }

    public void b(b bVar) {
        this.bTW.d(bVar);
    }

    public boolean jf(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void aaN() {
    }

    public void RB() {
        this.bTW.RB();
    }

    public boolean aaO() {
        return com.baidu.swan.apps.y.f.aeK().aeM();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
