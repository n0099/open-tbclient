package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aa.f;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.pms.h;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.o.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.storage.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c implements e.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        String adS = adS();
        JSONObject parseString = t.parseString(QJ().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + adS);
        }
        String ko = ko(adS);
        if (z) {
            com.baidu.swan.apps.statistic.e.ark();
            f.akp().et(z2);
            HybridUbcFlow mp = g.mp("startup");
            b.a QJ = QJ();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + ko);
                }
                com.baidu.swan.apps.statistic.g.gR(2);
                if (!TextUtils.isEmpty(ko)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.I("backtohome", "message", ko);
                    } else {
                        com.baidu.swan.apps.statistic.e.a(ko, QJ);
                        mp.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.I("backtohome", "relaunch", ko);
                        if (com.baidu.swan.apps.scheme.actions.k.a.od(ko)) {
                            com.baidu.swan.apps.scheme.actions.k.a.oe("reLaunch");
                        }
                    }
                } else if (d.arE()) {
                    com.baidu.swan.apps.scheme.actions.k.a.I("backtohome", "relaunch", com.baidu.swan.apps.w.f.ahV().ahE());
                } else {
                    f.akp().et(false);
                    mp.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.statistic.e.p(QJ);
                    com.baidu.swan.apps.statistic.e.c(QJ);
                }
                if (adB().hasResumed()) {
                    mp.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.al.a.aqT().oo("na_page_show");
                }
                com.baidu.swan.apps.al.a.aqT().oo("frame_new_intent");
                com.baidu.swan.apps.runtime.e aox = com.baidu.swan.apps.runtime.d.aoB().aox();
                aox.aoR().aqk();
                aox.aoS().clear();
            } else {
                mp.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            adR();
            adE();
            dQ(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bQd.setRequestedOrientation(1);
        com.baidu.swan.apps.aq.d.P(this.bQd);
        if (com.baidu.swan.apps.core.a.RN()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.al.a.aqT().clear();
        com.baidu.swan.apps.al.a.aqT().oo("frame_create");
        f.akp().et(true);
        f.akp().akr();
        adT();
        adP();
        V8Engine.setCrashKeyValue("app_title", QJ().abT());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void adk() {
        com.baidu.swan.apps.ai.b.apX();
        com.baidu.swan.apps.w.f.ahV().bS(this.bQd);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        g.alx().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.al.a.aqT().oo("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ai.b.apY();
        f.akp().akq();
        com.baidu.swan.apps.u.a.aeT().Sp();
        com.baidu.swan.apps.w.f.ahV().bT(this.bQd);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int Qz() {
        return 0;
    }

    private void adP() {
        com.baidu.swan.apps.statistic.e.ari();
        if (ane()) {
            adU();
            b.a QJ = QJ();
            if (g(QJ)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.f.ahV().b(QJ, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.f.ahV().a(QJ, (com.baidu.swan.apps.r.b) null);
        }
    }

    private boolean g(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.af.a.a.m(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.getAppFrameType() != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            SwanAppConfigData aoO = com.baidu.swan.apps.runtime.d.aoB().aox().aoO();
            if (aoO == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.bk(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aoO);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String ko(String str) {
        b.a QJ = QJ();
        if (TextUtils.isEmpty(str) && QJ != null && kn(QJ.getAppId())) {
            return com.baidu.swan.apps.w.f.ahV().ahE();
        }
        return str;
    }

    private boolean adQ() {
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        if (aoB.ane()) {
            b.a QJ = aoB.aox().QJ();
            String agK = QJ.agK();
            String agL = QJ.agL();
            if (TextUtils.isEmpty(QJ.agK()) || TextUtils.equals(agK, agL)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aoX = aox().aoX();
            if (aoX.containsKey(QJ.agK())) {
                return aoX.b(agK, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void adR() {
        if (adQ()) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.akD().akF();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.o.a.adV().adW()) {
                com.baidu.swan.apps.o.a.adV().a(this.bQd, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: d */
                    public void K(Boolean bool) {
                        if (a.this.bQd != null && bool.booleanValue()) {
                            a.this.bQd.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cej != null && this.cej.YS() == 1) {
                com.baidu.swan.apps.o.b adX = new com.baidu.swan.apps.o.b().adX();
                if (adX.isShow()) {
                    com.baidu.swan.apps.o.c.aec().a(this.bQd, adX.getImageUrl(), adX.aeb(), XX());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a XX() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.o.c.a
            public void Yv() {
                if (a.this.bQd != null) {
                    a.this.bQd.moveTaskToBack(true);
                    an.atY().hI(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.cej.YS());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b YP = this.cej.YP();
        if (YP == null || !YP.Tc()) {
            if (adM()) {
                com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                if (aoF != null) {
                    aoF.aoW().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aoH());
                com.baidu.swan.apps.w.f.ahV().a(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.aq.e.b(QH(), this.bQd);
            this.cej.jp("navigateBack").ae(com.baidu.swan.apps.core.d.e.bVP, com.baidu.swan.apps.core.d.e.bVO).YX().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b adI() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.amG().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.adF();
                        com.baidu.swan.apps.runtime.d.aoB().aoy();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.afm().getNightModeSwitcherState();
                        com.baidu.swan.apps.u.a.afm().de(nightModeSwitcherState);
                        if (a.this.bQd != null) {
                            a.this.bQd.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                        if (aoF != null) {
                            aoF.aoR().clear();
                            com.baidu.swan.apps.network.c.a.akD().akJ();
                        }
                        a.this.adF();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aoB().aoy();
                        return true;
                    case 107:
                        h.l(message);
                        return true;
                    case 123:
                        com.baidu.swan.apps.aq.a.N(message);
                        return true;
                    case 124:
                        com.baidu.swan.apps.aq.a.O(message);
                        return true;
                    case 301:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String adS() {
        return com.baidu.swan.apps.v.b.b.a(QJ(), com.baidu.swan.apps.w.f.ahV().ahA());
    }

    private void dQ(boolean z) {
        com.baidu.swan.apps.statistic.search.b.q(QJ());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cGJ = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void adT() {
        b.a QJ = QJ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + QJ.abG());
        }
        if (QJ.abG() == null || !QJ.abG().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            QJ.b(com.baidu.swan.apps.swancore.b.ha(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + QJ.abG());
            }
        }
    }

    private void adU() {
        boolean z = false;
        b.a QJ = QJ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (QJ == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion abG = com.baidu.swan.apps.core.turbo.d.abl().abG();
        long pi = com.baidu.swan.apps.swancore.b.pi(QJ.agO());
        if (pi != 0 && abG != null && pi > abG.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion abG2 = QJ.abG();
        ExtensionCore abH = com.baidu.swan.apps.core.turbo.d.abl().abH();
        ExtensionCore abH2 = QJ.abH();
        boolean z2 = abG != null && abG2 != null && abG.swanCoreVersion < abG2.swanCoreVersion && com.baidu.swan.apps.v.b.a.fx(QJ.agX());
        if (abH != null && abH2 != null && abH.extensionCoreVersionCode < abH2.extensionCoreVersionCode && com.baidu.swan.apps.v.b.a.fy(QJ.agX())) {
            z = true;
        }
        if (z2 || z) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            com.baidu.swan.apps.core.turbo.d.release(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void adL() {
        this.cej.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void YV() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void adN() {
        super.adN();
        if (com.baidu.swan.apps.core.turbo.d.abl().abB() != null) {
            com.baidu.swan.apps.core.turbo.d.abl().abB().attachActivity(this.bQd);
        }
    }
}
