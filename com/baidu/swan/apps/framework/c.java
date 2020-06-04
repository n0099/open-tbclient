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
import com.baidu.swan.apps.ad.c;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.runtime.i;
import com.baidu.swan.apps.runtime.m;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.v.b.b;
import com.baidu.swan.apps.w.f;
/* loaded from: classes11.dex */
public abstract class c extends m {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private final com.baidu.swan.apps.runtime.b bHa;
    protected final SwanAppActivity bQd;
    protected com.baidu.swan.apps.core.d.e cej;
    protected a.b cek;
    private final com.baidu.swan.apps.am.f.b cel;
    private com.baidu.swan.apps.ad.c cem;
    private FrameLayout cen;
    private com.baidu.swan.apps.statistic.a ceo;
    private d cep;
    public final String ceq;
    private FrameLifeState cer;
    private FrameLifeState ces;
    private boolean cet;
    private boolean ceu;
    private boolean cev;

    @NonNull
    protected abstract a.b adI();

    protected abstract void adk();

    protected abstract void m(boolean z, boolean z2);

    protected abstract void onCreate();

    protected abstract void onDestroy();

    protected abstract void onPause();

    protected abstract void onRelease();

    protected abstract void onResume();

    protected abstract void onStart();

    protected abstract void onStop();

    public c(SwanAppActivity swanAppActivity, String str) {
        super(com.baidu.swan.apps.runtime.d.aoB());
        this.cek = null;
        this.cel = new com.baidu.swan.apps.am.f.b();
        this.cer = FrameLifeState.INACTIVATED;
        this.ces = null;
        this.cet = false;
        this.ceu = false;
        this.bHa = new com.baidu.swan.apps.runtime.b();
        this.cev = true;
        this.bQd = swanAppActivity;
        this.ceq = str;
        this.cep = new d();
        n(this.bHa);
    }

    public final synchronized void a(FrameLifeState frameLifeState, boolean z) {
        final boolean z2 = false;
        synchronized (this) {
            if (!this.bQd.isDestroyed()) {
                final boolean z3 = (!this.cer.hasCreated()) | z;
                if (this.cer.hasCreated() && z3) {
                    z2 = true;
                }
                this.cev = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_fixed_relaunch_switch", true);
                if (this.cev && z2 && !aox().apc()) {
                    this.bHa.a(new com.baidu.swan.apps.aq.e.b<i.a>() { // from class: com.baidu.swan.apps.framework.c.1
                        /* JADX DEBUG: Method merged with bridge method */
                        @Override // com.baidu.swan.apps.aq.e.b
                        /* renamed from: b */
                        public void H(i.a aVar) {
                            if (com.baidu.swan.apps.runtime.d.aoB().ane()) {
                                c.this.bHa.v("event_first_action_launched");
                                c.this.n(z3, z2);
                                c.this.adm();
                            }
                        }
                    }, "event_first_action_launched");
                } else {
                    n(z3, z2);
                }
                d(frameLifeState);
                if (z3 && (z2 || 1 == Qz())) {
                    g.i(QJ());
                }
            }
        }
    }

    public final synchronized void release() {
        d(FrameLifeState.INACTIVATED);
        adt();
    }

    public boolean adl() {
        return this.ceu;
    }

    private synchronized FrameLifeState c(@NonNull FrameLifeState frameLifeState) {
        return (frameLifeState.inactivated() || aox().apc() || !frameLifeState.hasStarted() || frameLifeState.moreInactiveThan(this.cer)) ? frameLifeState : this.cer.hasCreated() ? this.cer : FrameLifeState.JUST_CREATED;
    }

    public final synchronized void d(@NonNull FrameLifeState frameLifeState) {
        synchronized (this) {
            log(" transLifeState: target=" + frameLifeState + " holdon=" + this.cet + " locked=" + this.ceu + " thread=" + Thread.currentThread());
            if (!this.ceu) {
                this.ces = frameLifeState;
                this.ceu = FrameLifeState.INACTIVATED == this.ces;
            }
            if (!this.cet) {
                this.cet = true;
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.framework.c.2
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.adm();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void adm() {
        synchronized (this) {
            this.cet = true;
            while (this.ces != null && adO()) {
                FrameLifeState c = c(this.ces);
                log("syncLifeState: pendingTarget=" + this.ces + " fixedTarget=" + c);
                this.ces = null;
                switch (c) {
                    case JUST_CREATED:
                        adr();
                        adn();
                        break;
                    case JUST_STARTED:
                        adq();
                        ado();
                        break;
                    case JUST_RESUMED:
                        adp();
                        break;
                    default:
                        ads();
                        break;
                }
            }
            log("syncLifeState: done=" + this.cer);
            this.ceu = FrameLifeState.INACTIVATED == this.ces;
            this.cet = false;
        }
    }

    private synchronized void adn() {
        if (!this.cer.hasCreated()) {
            adu();
            com.baidu.swan.apps.console.c.d("SwanApp", "onPostCreate: " + this);
            adk();
            this.cer = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ado() {
        adn();
        if (!this.cer.hasStarted()) {
            adv();
            this.cer = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void adp() {
        ado();
        if (!this.cer.hasResumed()) {
            adw();
            this.cer = FrameLifeState.JUST_RESUMED;
        }
    }

    private synchronized void adq() {
        if (this.cer.hasResumed()) {
            adx();
            this.cer = FrameLifeState.JUST_STARTED;
        }
    }

    private synchronized void adr() {
        adq();
        if (this.cer.hasStarted()) {
            ady();
            this.cer = FrameLifeState.JUST_CREATED;
        }
    }

    private synchronized void ads() {
        adr();
        if (this.cer.hasCreated()) {
            adz();
            this.cer = FrameLifeState.INACTIVATED;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void n(boolean z, boolean z2) {
        HybridUbcFlow mp = g.mp("startup");
        mp.f(new UbcFlowEvent("onUpdateInternalStart").eu(true));
        log("onUpdateInternal isLaunch=" + z + " isRelaunch=" + z2);
        if (z) {
            b.a QJ = QJ();
            if (!z2) {
                adN();
            }
            if (!TextUtils.isEmpty(QJ.agZ())) {
                com.baidu.swan.apps.console.debugger.a.e.setWebUrl(QJ.agZ());
            }
        }
        f.ahV().h(this.bQd);
        mp.f(new UbcFlowEvent("onUpdateStart").eu(true));
        m(z, z2);
        mp.f(new UbcFlowEvent("onUpdateEnd").eu(true));
    }

    private synchronized void adt() {
        log("onReleaseInternal");
        onRelease();
        f.release();
    }

    @DebugTrace
    private synchronized void adu() {
        log("onCreateInternal");
        HybridUbcFlow mp = g.mp("startup");
        mp.f(new UbcFlowEvent("frame_start_create"));
        mp.f(new UbcFlowEvent("onCreateInternalStart").eu(true));
        this.cep.adh();
        com.baidu.swan.apps.console.c.d("SwanApp", "onCreate: " + this);
        if (com.baidu.swan.apps.console.debugger.a.e.Wm()) {
            com.baidu.swan.apps.core.turbo.d.release(false);
        }
        adK();
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        if (!aoB.ane() || !aoB.aox().available()) {
            com.baidu.swan.apps.an.a pt = new com.baidu.swan.apps.an.a().bw(5L).bx(11L).pt("aiapp data is invalid");
            com.baidu.swan.apps.an.e.asQ().g(pt);
            h.b(new com.baidu.swan.apps.statistic.a.d().oC(h.gU(Qz())).f(pt).a(QJ()));
            g.a(pt);
            com.baidu.swan.apps.aq.d.N(this.bQd);
        } else {
            adC();
            mp.f(new UbcFlowEvent("onCreateStart").eu(true));
            onCreate();
            mp.f(new UbcFlowEvent("onCreateEnd").eu(true));
            com.baidu.swan.apps.aq.c Qy = this.bQd.Qy();
            if (Qy != null) {
                Qy.atb();
            }
            mp.f(new UbcFlowEvent("onCreateInternalEnd").eu(true));
        }
    }

    private synchronized void adv() {
        HybridUbcFlow mp = g.mp("startup");
        mp.f(new UbcFlowEvent("onStartStart").eu(true));
        log("onStartInternal");
        this.cep.adi();
        onStart();
        mp.f(new UbcFlowEvent("onStartEnd").eu(true));
    }

    private synchronized void adw() {
        HybridUbcFlow mp = g.mp("startup");
        mp.f(new UbcFlowEvent("onResumeInternalStart").eu(true));
        log("onResumeInternal");
        this.cep.Ua();
        com.baidu.swan.apps.console.c.d("SwanApp", "onResume: " + this);
        this.ceo = h.ow("607");
        adJ();
        if (ane()) {
            aox().onActivityResume(this.bQd);
        }
        n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.c.3
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.network.c.a.akD().akF();
                if (c.DEBUG) {
                    Log.e("SwanActivityFrame", "try update on computation thread");
                }
                if (c.this.bQd != null && com.baidu.swan.apps.runtime.e.aoF() != null) {
                    com.baidu.swan.apps.database.a.b.b(com.baidu.swan.apps.runtime.e.aoF());
                }
            }
        }, "saveSwanAppHistory");
        g.mp("startup").f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
        com.baidu.swan.apps.al.a.aqT().oo("na_page_show");
        f.ahV().SQ();
        mp.f(new UbcFlowEvent("onResumeStart").eu(true));
        onResume();
        mp.f(new UbcFlowEvent("onResumeEnd").eu(true));
    }

    private synchronized void adx() {
        log("onPauseInternal");
        onPause();
        f.ahV().SR();
        this.cep.Vr();
        com.baidu.swan.apps.console.c.d("SwanApp", "onPause: " + this);
        if (this.ceo != null && ane()) {
            com.baidu.swan.apps.statistic.a.a aVar = new com.baidu.swan.apps.statistic.a.a();
            b.a QJ = QJ();
            aVar.mFrom = h.gU(Qz());
            aVar.mAppId = QJ.getAppId();
            aVar.mSource = QJ.agK();
            aVar.c(QJ);
            aVar.oG(QJ.agQ().getString("ubc"));
            aVar.bu(h.ox(QJ.agM()));
            h.a(this.ceo, aVar);
            this.ceo = null;
        }
    }

    private synchronized void ady() {
        g.aly();
        log("onStopInternal");
        onStop();
        this.cep.adj();
    }

    private synchronized void adz() {
        log("onDestroyInternal");
        onDestroy();
        this.cep.TZ();
        com.baidu.swan.apps.console.c.d("SwanApp", "onDestroy: " + this);
        com.baidu.swan.apps.network.c.a.akD().release();
        com.baidu.swan.apps.core.i.a.aaB().release();
        com.baidu.swan.apps.api.b.c.UG().release();
        com.baidu.swan.apps.performance.d.d.releaseInstance();
        adA();
        adD();
        f.release();
    }

    private void adA() {
        com.baidu.swan.apps.scheme.actions.k.c.cCV = null;
        g.crG = null;
    }

    public synchronized FrameLifeState adB() {
        return this.cer;
    }

    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return this.cep.onKeyDown(i, keyEvent);
    }

    public void adC() {
        if (this.cek == null) {
            this.cek = adI();
        }
        aow().a((a.c) null, this.cek);
    }

    public void adD() {
        aow().adD();
        this.cek = null;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adE() {
        b.a QJ;
        Bundle agP;
        if (ane() && (agP = (QJ = QJ()).agP()) != null && agP.getLong("launch_flag_for_statistic") > 0) {
            long j = QJ.getLong("launch_time", 0L);
            long currentTimeMillis = System.currentTimeMillis();
            com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
            fVar.mFrom = h.gU(Qz());
            fVar.mAppId = QJ.getAppId();
            if (com.baidu.swan.apps.af.a.a.mR(QJ().agZ())) {
                fVar.mSource = "remote-debug";
            } else {
                fVar.mSource = QJ.agK();
            }
            fVar.mType = Config.LAUNCH;
            fVar.mValue = "success";
            fVar.cGD = String.valueOf(currentTimeMillis - j);
            fVar.v("status", "0");
            fVar.oG(QJ.agQ().getString("ubc"));
            fVar.bu(h.ox(QJ.agM()));
            h.onEvent(fVar);
            agP.remove("launch_flag_for_statistic");
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adF() {
        adG();
        adH();
    }

    private void adG() {
        com.baidu.swan.apps.adaptation.a.b SA = aoD().QY().SA();
        if (SA != null) {
            SA.aZ(this.bQd);
        }
    }

    protected void adH() {
        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
        com.baidu.swan.apps.a.b bVar = null;
        if (aoF != null) {
            bVar = aoF.aoS();
        }
        if (bVar != null) {
            bVar.setUid(bVar.getUid(AppRuntime.getAppContext()));
        }
    }

    private void adJ() {
        if (aox().available()) {
            setTaskDescription(this.bQd, QJ().abT(), aj.a((com.baidu.swan.apps.v.b.b) QJ(), "SwanActivityFrame", true), (int) QJ().agJ());
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

    private void adK() {
        this.cej = new com.baidu.swan.apps.core.d.e(this.bQd);
        adL();
    }

    protected void adL() {
    }

    public com.baidu.swan.apps.core.d.e QH() {
        if (this.cej == null) {
            adK();
        }
        return this.cej;
    }

    public void onTrimMemory(int i) {
        com.baidu.swan.apps.console.c.w("SwanActivityFrame", "onTrimMemory level:" + i);
        QL().hy(i);
    }

    public void onBackPressed() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public boolean adM() {
        if (this.cej.YS() != 1) {
            return false;
        }
        this.bQd.moveTaskToBack(true);
        this.bQd.ee(2);
        an.atY().hK(1);
        return true;
    }

    public b.a QJ() {
        return aox().aoJ();
    }

    public final void a(com.baidu.swan.apps.statistic.a.f fVar) {
        if (fVar != null && ane()) {
            b.a QJ = QJ();
            fVar.mFrom = h.gU(Qz());
            fVar.mAppId = QJ.getAppId();
            fVar.mSource = QJ.agK();
            fVar.bu(h.ox(QJ.agM()));
            if (TextUtils.isEmpty(fVar.mType)) {
                fVar.mType = "click";
            }
            fVar.oG(QJ.agQ().getString("ubc"));
            if (TextUtils.equals(fVar.mType, "click")) {
                com.baidu.swan.apps.statistic.d.b(fVar);
            } else {
                h.onEvent(fVar);
            }
        }
    }

    public void a(int i, @NonNull String[] strArr, c.a aVar) {
        if (Build.VERSION.SDK_INT >= 23) {
            if (this.cem == null) {
                this.cem = new com.baidu.swan.apps.ad.c();
            }
            this.cem.a(this.bQd, i, strArr, aVar);
        }
    }

    public boolean onRequestPermissionsResult(int i, @NonNull String[] strArr, @NonNull int[] iArr) {
        if (this.cem != null) {
            this.cem.a(this.bQd, i, strArr, iArr);
            return true;
        }
        return false;
    }

    public void showLoadingView() {
        this.cen = (FrameLayout) this.bQd.findViewById(a.f.ai_apps_activity_root);
        com.baidu.swan.apps.res.widget.loadingview.a.showLoadingView(this.bQd, this.cen);
    }

    public void QK() {
        com.baidu.swan.apps.res.widget.loadingview.a.removeLoadingView(this.cen);
    }

    @NonNull
    public com.baidu.swan.apps.am.f.b QL() {
        return this.cel;
    }

    public boolean isLandScape() {
        return false;
    }

    public void a(b bVar) {
        this.cep.c(bVar);
    }

    public void b(b bVar) {
        this.cep.d(bVar);
    }

    public boolean kn(String str) {
        return TextUtils.equals(str, "sc9Tq1iKawTnj5GhG6i77vzeIt4Crt5u");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public void adN() {
    }

    public void Ub() {
        this.cep.Ub();
    }

    public boolean adO() {
        return f.ahV().ahX();
    }

    private void log(String str) {
        if (DEBUG) {
            Log.i("SwanActivityFrame", str);
        }
    }
}
