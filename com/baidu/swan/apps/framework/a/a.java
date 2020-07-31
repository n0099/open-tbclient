package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aq.aq;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.aq.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d;
import com.baidu.swan.apps.core.d.f;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.o.c;
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
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends c implements f.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "SwanAppActivity onNewIntent");
        String agj = agj();
        JSONObject parseString = v.parseString(Se().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + agj);
        }
        String kS = kS(agj);
        if (z) {
            e.auo();
            com.baidu.swan.apps.z.f.amM().eH(z2);
            HybridUbcFlow mX = i.mX("startup");
            b.a Se = Se();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + kS);
                }
                g.hn(2);
                if (!TextUtils.isEmpty(kS)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "message", kS);
                    } else {
                        e.a(kS, Se);
                        d.YV();
                        mX.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        boolean oQ = com.baidu.swan.apps.scheme.actions.forbidden.a.asG().oQ(kS);
                        com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", oQ ? "message" : "relaunch", kS);
                        if (com.baidu.swan.apps.scheme.actions.k.a.oW(kS) && !oQ) {
                            com.baidu.swan.apps.scheme.actions.k.a.oX("reLaunch");
                        }
                    }
                } else if (com.baidu.swan.apps.storage.d.auM()) {
                    com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "relaunch", com.baidu.swan.apps.v.f.akr().aka());
                } else {
                    com.baidu.swan.apps.z.f.amM().eH(false);
                    mX.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    e.n(Se);
                    e.c(Se);
                }
                if (afT().hasResumed()) {
                    mX.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.al.a.atW().pf("na_page_show");
                }
                com.baidu.swan.apps.al.a.atW().pf("frame_new_intent");
                com.baidu.swan.apps.runtime.e arn = com.baidu.swan.apps.runtime.d.arr().arn();
                arn.arH().ati();
                arn.arI().clear();
                if (com.baidu.swan.apps.core.i.a.cfE) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData arE = arn.arE();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.acJ().acK();
                    }
                    com.baidu.swan.apps.core.i.a.acJ().b(arE);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.auw();
            } else {
                mX.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            agi();
            eb(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bVJ.setRequestedOrientation(1);
        com.baidu.swan.apps.aq.e.O(this.bVJ);
        if (com.baidu.swan.apps.core.c.To()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.al.a.atW().clear();
        com.baidu.swan.apps.al.a.atW().pf("frame_create");
        com.baidu.swan.apps.z.f.amM().eH(true);
        com.baidu.swan.apps.z.f.amM().amO();
        agk();
        agg();
        V8Engine.setCrashKeyValue("app_title", Se().aee());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void afC() {
        if (com.baidu.swan.apps.performance.b.b.aoo()) {
            ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.ai.b.asU();
                    com.baidu.swan.apps.v.f.akr().bW(a.this.bVJ);
                }
            }, "registerScreenshotEvent", 2);
            return;
        }
        com.baidu.swan.apps.ai.b.asU();
        com.baidu.swan.apps.v.f.akr().bW(this.bVJ);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.anX().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.al.a.atW().pf("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ai.b.asV();
        com.baidu.swan.apps.z.f.amM().amN();
        com.baidu.swan.apps.t.a.ahl().TS();
        com.baidu.swan.apps.v.f.akr().bX(this.bVJ);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int RU() {
        return 0;
    }

    private void agg() {
        e.aum();
        if (apU()) {
            agl();
            b.a Se = Se();
            if (g(Se)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.akr().b(Se, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.akr().a(Se, (com.baidu.swan.apps.r.b) null);
        }
    }

    private boolean g(com.baidu.swan.apps.u.c.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ae.a.a.j(bVar)) {
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
            SwanAppConfigData arE = com.baidu.swan.apps.runtime.d.arr().arn().arE();
            if (arE == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0380d.bq(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, arE);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String kS(String str) {
        b.a Se = Se();
        if (TextUtils.isEmpty(str) && Se != null && kR(Se.getAppId())) {
            return com.baidu.swan.apps.v.f.akr().aka();
        }
        return str;
    }

    private boolean agh() {
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        if (arr.apU()) {
            b.a Se = arr.arn().Se();
            String ajg = Se.ajg();
            String ajh = Se.ajh();
            if (TextUtils.isEmpty(Se.ajg()) || TextUtils.equals(ajg, ajh)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g arN = arn().arN();
            if (arN.containsKey(Se.ajg())) {
                return arN.b(ajg, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void agi() {
        if (agh()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.amZ().anb();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.o.a.agm().agn()) {
                com.baidu.swan.apps.o.a.agm().a(this.bVJ, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: d */
                    public void J(Boolean bool) {
                        if (a.this.bVJ != null && bool.booleanValue()) {
                            a.this.bVJ.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.ckW != null && this.ckW.abc() == 1) {
                com.baidu.swan.apps.o.b ago = new com.baidu.swan.apps.o.b().ago();
                if (ago.isShow()) {
                    com.baidu.swan.apps.o.c.agt().a(this.bVJ, ago.getImageUrl(), ago.ags(), aah());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a aah() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.o.c.a
            public void aaE() {
                if (a.this.bVJ != null) {
                    a.this.bVJ.moveTaskToBack(true);
                    aq.axo().ig(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.ckW.abc());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c aaZ = this.ckW.aaZ();
        if (aaZ == null || !aaZ.UJ()) {
            if (agd()) {
                com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                if (arv != null) {
                    arv.arM().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.arx());
                com.baidu.swan.apps.v.f.akr().a(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.akA().eq(false);
                return;
            }
            com.baidu.swan.apps.aq.f.b(Sc(), this.bVJ);
            this.ckW.jO("navigateBack").ag(f.cck, f.ccj).abh().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b afZ() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.apw().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.afW();
                        com.baidu.swan.apps.runtime.d.arr().aro();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.ahF().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.ahF().dm(nightModeSwitcherState);
                        if (a.this.bVJ != null) {
                            a.this.bVJ.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e arv = com.baidu.swan.apps.runtime.e.arv();
                        if (arv != null) {
                            arv.arH().clear();
                            com.baidu.swan.apps.network.c.a.amZ().anf();
                        }
                        a.this.afW();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.arr().aro();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.l(message);
                        return true;
                    case 123:
                        com.baidu.swan.apps.aq.b.N(message);
                        return true;
                    case 124:
                        com.baidu.swan.apps.aq.b.O(message);
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

    private String agj() {
        return com.baidu.swan.apps.u.c.b.a(Se(), com.baidu.swan.apps.v.f.akr().ajW());
    }

    private void eb(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(Se());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cOO = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void agk() {
        b.a Se = Se();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Se.adQ());
        }
        if (Se.adQ() == null || !Se.adQ().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            Se.b(com.baidu.swan.apps.swancore.b.hw(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Se.adQ());
            }
        }
    }

    private void agl() {
        boolean z = false;
        b.a Se = Se();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (Se == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion adQ = com.baidu.swan.apps.core.turbo.d.adw().adQ();
        long qb = com.baidu.swan.apps.swancore.b.qb(Se.ajk());
        if (qb != 0 && adQ != null && qb > adQ.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion adQ2 = Se.adQ();
        ExtensionCore adR = com.baidu.swan.apps.core.turbo.d.adw().adR();
        ExtensionCore adR2 = Se.adR();
        boolean z2 = adQ != null && adQ2 != null && adQ.swanCoreVersion < adQ2.swanCoreVersion && com.baidu.swan.apps.u.c.a.fU(Se.ajt());
        if (adR != null && adR2 != null && adR.extensionCoreVersionCode < adR2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.fV(Se.ajt())) {
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
    protected void agc() {
        this.ckW.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.f.a
    public void abf() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void age() {
        super.age();
        if (com.baidu.swan.apps.core.turbo.d.adw().adM() != null) {
            com.baidu.swan.apps.core.turbo.d.adw().adM().attachActivity(this.bVJ);
        }
    }
}
