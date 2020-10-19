package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.storage.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String aqN = aqN();
        JSONObject parseString = v.parseString(abu().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + aqN);
        }
        String nM = nM(aqN);
        if (z) {
            e.aFQ();
            f.ayc().ft(z2);
            HybridUbcFlow qc = i.qc("startup");
            b.a abu = abu();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + nM);
                }
                g.kc(2);
                if (!TextUtils.isEmpty(nM)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.N("backtohome", "message", nM);
                    } else {
                        e.a(nM, abu);
                        com.baidu.swan.apps.core.f.eg(true);
                        qc.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.oj("2");
                        boolean rT = com.baidu.swan.apps.scheme.actions.forbidden.a.aEk().rT(nM);
                        com.baidu.swan.apps.scheme.actions.k.a.N("backtohome", rT ? "message" : "relaunch", nM);
                        if (com.baidu.swan.apps.scheme.actions.k.a.rZ(nM) && !rT) {
                            com.baidu.swan.apps.scheme.actions.k.a.sa("reLaunch");
                        }
                    }
                } else if (d.aGo()) {
                    com.baidu.swan.apps.scheme.actions.k.a.N("backtohome", "relaunch", com.baidu.swan.apps.v.f.avu().avd());
                } else {
                    f.ayc().ft(false);
                    qc.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.oj("3");
                    e.n(abu);
                    e.d(abu);
                }
                if (aqw().hasResumed()) {
                    qc.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aFy().sk("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aFy().sk("frame_new_intent");
                com.baidu.swan.apps.runtime.e aCS = com.baidu.swan.apps.runtime.d.aCW().aCS();
                aCS.aDm().aEJ();
                aCS.aDn().clear();
                if (com.baidu.swan.apps.core.i.a.cAs) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aDj = aCS.aDj();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.amD().amE();
                    }
                    com.baidu.swan.apps.core.i.a.amD().b(aDj);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aFY();
            } else {
                qc.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            aqM();
            eK(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cpO.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.P(this.cpO);
        if (com.baidu.swan.apps.core.e.acJ()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aFy().clear();
        com.baidu.swan.apps.ak.a.aFy().sk("frame_create");
        f.ayc().ft(true);
        f.ayc().ayf();
        aqO();
        aqK();
        V8Engine.setCrashKeyValue("app_title", abu().aoj());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aqf() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aEu();
                com.baidu.swan.apps.v.f.avu().ch(a.this.cpO);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.azm().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aFy().sk("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aEv();
        f.ayc().ayd();
        com.baidu.swan.apps.t.a.ash().adp();
        com.baidu.swan.apps.v.f.avu().ci(this.cpO);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int abk() {
        return 0;
    }

    private void aqK() {
        e.aFO();
        if (aBj()) {
            aqP();
            b.a abu = abu();
            if (g(abu)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.avu().b(abu, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.avu().a(abu, (com.baidu.swan.apps.r.b) null);
        }
    }

    private boolean g(com.baidu.swan.apps.u.c.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ad.a.a.j(bVar)) {
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
            SwanAppConfigData aDj = com.baidu.swan.apps.runtime.d.aCW().aCS().aDj();
            if (aDj == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0438d.bG(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aDj);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String nM(String str) {
        b.a abu = abu();
        if (TextUtils.isEmpty(str) && abu != null && nL(abu.getAppId())) {
            return com.baidu.swan.apps.v.f.avu().avd();
        }
        return str;
    }

    private boolean aqL() {
        com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
        if (aCW.aBj()) {
            b.a abu = aCW.aCS().abu();
            String auj = abu.auj();
            String auk = abu.auk();
            if (TextUtils.isEmpty(abu.auj()) || TextUtils.equals(auj, auk)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aDs = aCS().aDs();
            if (aDs.containsKey(abu.auj())) {
                return aDs.b(auj, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void aqM() {
        if (aqL()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.ayq().ays();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.aqQ().aqR()) {
                com.baidu.swan.apps.p.a.aqQ().a(this.cpO, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: e */
                    public void O(Boolean bool) {
                        if (a.this.cpO != null && bool.booleanValue()) {
                            a.this.cpO.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cGA != null && this.cGA.akK() == 1) {
                com.baidu.swan.apps.p.b aqS = new com.baidu.swan.apps.p.b().aqS();
                if (aqS.isShow()) {
                    com.baidu.swan.apps.p.c.aqX().a(this.cpO, aqS.getImageUrl(), aqS.aqW(), ajM());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a ajM() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void akj() {
                if (a.this.cpO != null) {
                    a.this.cpO.moveTaskToBack(true);
                    ap.aIQ().kW(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cGA.akK());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c akH = this.cGA.akH();
        if (akH == null || !akH.aeh()) {
            if (aqG()) {
                com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
                if (aDa != null) {
                    aDa.aDr().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aDc());
                com.baidu.swan.apps.v.f.avu().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.avD().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(abs(), this.cpO);
            this.cGA.mt("navigateBack").ak(com.baidu.swan.apps.core.d.f.cwF, com.baidu.swan.apps.core.d.f.cwE).akO().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aqC() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aAK().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.aqz();
                        com.baidu.swan.apps.runtime.d.aCW().aCT();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.asC().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.asC().dP(nightModeSwitcherState);
                        if (a.this.cpO != null) {
                            a.this.cpO.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aDa = com.baidu.swan.apps.runtime.e.aDa();
                        if (aDa != null) {
                            aDa.aDm().clear();
                            com.baidu.swan.apps.network.c.a.ayq().ayv();
                        }
                        a.this.aqz();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aCW().aCT();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.m(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        com.baidu.swan.apps.ap.b.O(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        com.baidu.swan.apps.ap.b.P(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case 127:
                        com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.axw()));
                        return true;
                    case 129:
                        int aHJ = com.baidu.swan.apps.ap.b.aHF().aHJ();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aHJ);
                        if (a.this.cpO == null || !a.this.cpO.isBackground() || aHJ == -1 || a.this.cpO.getTaskId() == aHJ) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aCW().aCT();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String aqN() {
        return com.baidu.swan.apps.u.c.b.a(abu(), com.baidu.swan.apps.v.f.avu().auZ());
    }

    private void eK(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(abu());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dmc = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void aqO() {
        b.a abu = abu();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + abu.anI());
        }
        if (abu.anI() == null || !abu.anI().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            abu.b(com.baidu.swan.apps.swancore.b.kl(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + abu.anI());
            }
        }
    }

    private void aqP() {
        boolean z = false;
        b.a abu = abu();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (abu == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion anI = com.baidu.swan.apps.core.turbo.d.ann().anI();
        long ti = com.baidu.swan.apps.swancore.b.ti(abu.aun());
        if (ti != 0 && anI != null && ti > anI.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion anI2 = abu.anI();
        ExtensionCore anJ = com.baidu.swan.apps.core.turbo.d.ann().anJ();
        ExtensionCore anJ2 = abu.anJ();
        boolean z2 = anI != null && anI2 != null && anI.swanCoreVersion < anI2.swanCoreVersion && com.baidu.swan.apps.u.c.a.iF(abu.auw());
        if (anJ != null && anJ2 != null && anJ.extensionCoreVersionCode < anJ2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.iG(abu.auw())) {
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
    protected void aqF() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aqH() {
        super.aqH();
        if (com.baidu.swan.apps.core.turbo.d.ann().anE() != null) {
            com.baidu.swan.apps.core.turbo.d.ann().anE().attachActivity(this.cpO);
        }
    }
}
