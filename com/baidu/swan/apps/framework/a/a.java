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
/* loaded from: classes7.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String auA = auA();
        JSONObject parseString = v.parseString(afg().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + auA);
        }
        String op = op(auA);
        if (z) {
            e.aJC();
            f.aBO().fS(z2);
            HybridUbcFlow qD = i.qD("startup");
            b.a afg = afg();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + op);
                }
                g.kt(2);
                if (!TextUtils.isEmpty(op)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", "message", op);
                    } else {
                        e.a(op, afg);
                        com.baidu.swan.apps.core.f.eF(true);
                        qD.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.oL("2");
                        boolean sw = com.baidu.swan.apps.scheme.actions.forbidden.a.aHW().sw(op);
                        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", sw ? "message" : "relaunch", op);
                        if (com.baidu.swan.apps.scheme.actions.k.a.sC(op) && !sw) {
                            com.baidu.swan.apps.scheme.actions.k.a.sD("reLaunch");
                        }
                    }
                } else if (d.aKa()) {
                    com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", "relaunch", com.baidu.swan.apps.v.f.azg().ayP());
                } else {
                    f.aBO().fS(false);
                    qD.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.oL("3");
                    e.n(afg);
                    e.d(afg);
                }
                if (auj().hasResumed()) {
                    qD.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aJk().sN("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aJk().sN("frame_new_intent");
                com.baidu.swan.apps.runtime.e aGE = com.baidu.swan.apps.runtime.d.aGI().aGE();
                aGE.aGY().aIv();
                aGE.aGZ().clear();
                if (com.baidu.swan.apps.core.i.a.cMX) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aGV = aGE.aGV();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.aqq().aqr();
                    }
                    com.baidu.swan.apps.core.i.a.aqq().b(aGV);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aJK();
            } else {
                qD.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            auz();
            fj(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cCy.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.O(this.cCy);
        if (com.baidu.swan.apps.core.e.agv()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aJk().clear();
        com.baidu.swan.apps.ak.a.aJk().sN("frame_create");
        f.aBO().fS(true);
        f.aBO().aBR();
        auB();
        aux();
        V8Engine.setCrashKeyValue("app_title", afg().arW());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void atS() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aIg();
                com.baidu.swan.apps.v.f.azg().ch(a.this.cCy);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aCY().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aJk().sN("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aIh();
        f.aBO().aBP();
        com.baidu.swan.apps.t.a.avU().ahb();
        com.baidu.swan.apps.v.f.azg().ci(this.cCy);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int aeW() {
        return 0;
    }

    private void aux() {
        e.aJA();
        if (aEV()) {
            auC();
            b.a afg = afg();
            if (g(afg)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.azg().b(afg, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.azg().a(afg, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aGV = com.baidu.swan.apps.runtime.d.aGI().aGE().aGV();
            if (aGV == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0462d.bM(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aGV);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String op(String str) {
        b.a afg = afg();
        if (TextUtils.isEmpty(str) && afg != null && oo(afg.getAppId())) {
            return com.baidu.swan.apps.v.f.azg().ayP();
        }
        return str;
    }

    private boolean auy() {
        com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
        if (aGI.aEV()) {
            b.a afg = aGI.aGE().afg();
            String axV = afg.axV();
            String axW = afg.axW();
            if (TextUtils.isEmpty(afg.axV()) || TextUtils.equals(axV, axW)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aHe = aGE().aHe();
            if (aHe.containsKey(afg.axV())) {
                return aHe.b(axV, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void auz() {
        if (auy()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aCc().aCe();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.auD().auE()) {
                com.baidu.swan.apps.p.a.auD().a(this.cCy, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: e */
                    public void O(Boolean bool) {
                        if (a.this.cCy != null && bool.booleanValue()) {
                            a.this.cCy.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cTf != null && this.cTf.aow() == 1) {
                com.baidu.swan.apps.p.b auF = new com.baidu.swan.apps.p.b().auF();
                if (auF.isShow()) {
                    com.baidu.swan.apps.p.c.auK().a(this.cCy, auF.getImageUrl(), auF.auJ(), any());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a any() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void anV() {
                if (a.this.cCy != null) {
                    a.this.cCy.moveTaskToBack(true);
                    ap.aMC().ln(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cTf.aow());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c aot = this.cTf.aot();
        if (aot == null || !aot.ahT()) {
            if (aut()) {
                com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
                if (aGM != null) {
                    aGM.aHd().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aGO());
                com.baidu.swan.apps.v.f.azg().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.azp().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(afe(), this.cCy);
            this.cTf.mV("navigateBack").al(com.baidu.swan.apps.core.d.f.cJk, com.baidu.swan.apps.core.d.f.cJj).aoA().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aup() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aEw().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.aum();
                        com.baidu.swan.apps.runtime.d.aGI().aGF();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awo().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.awo().eo(nightModeSwitcherState);
                        if (a.this.cCy != null) {
                            a.this.cCy.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aGM = com.baidu.swan.apps.runtime.e.aGM();
                        if (aGM != null) {
                            aGM.aGY().clear();
                            com.baidu.swan.apps.network.c.a.aCc().aCh();
                        }
                        a.this.aum();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aGI().aGF();
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
                        com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBi()));
                        return true;
                    case 129:
                        int aLv = com.baidu.swan.apps.ap.b.aLr().aLv();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aLv);
                        if (a.this.cCy == null || !a.this.cCy.isBackground() || aLv == -1 || a.this.cCy.getTaskId() == aLv) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aGI().aGF();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String auA() {
        return com.baidu.swan.apps.u.c.b.a(afg(), com.baidu.swan.apps.v.f.azg().ayL());
    }

    private void fj(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(afg());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dyP = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void auB() {
        b.a afg = afg();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + afg.arv());
        }
        if (afg.arv() == null || !afg.arv().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            afg.b(com.baidu.swan.apps.swancore.b.kC(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + afg.arv());
            }
        }
    }

    private void auC() {
        boolean z = false;
        b.a afg = afg();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (afg == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion arv = com.baidu.swan.apps.core.turbo.d.ara().arv();
        long tK = com.baidu.swan.apps.swancore.b.tK(afg.axZ());
        if (tK != 0 && arv != null && tK > arv.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion arv2 = afg.arv();
        ExtensionCore arw = com.baidu.swan.apps.core.turbo.d.ara().arw();
        ExtensionCore arw2 = afg.arw();
        boolean z2 = arv != null && arv2 != null && arv.swanCoreVersion < arv2.swanCoreVersion && com.baidu.swan.apps.u.c.a.iW(afg.ayi());
        if (arw != null && arw2 != null && arw.extensionCoreVersionCode < arw2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.iX(afg.ayi())) {
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
    protected void aus() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void auu() {
        super.auu();
        if (com.baidu.swan.apps.core.turbo.d.ara().arr() != null) {
            com.baidu.swan.apps.core.turbo.d.ara().arr().attachActivity(this.cCy);
        }
    }
}
