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
/* loaded from: classes25.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String axI = axI();
        JSONObject parseString = v.parseString(aio().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + axI);
        }
        String oW = oW(axI);
        if (z) {
            e.aMK();
            f.aEX().gh(z2);
            HybridUbcFlow rk = i.rk("startup");
            b.a aio = aio();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + oW);
                }
                g.kR(2);
                if (!TextUtils.isEmpty(oW)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.X("backtohome", "message", oW);
                    } else {
                        e.a(oW, aio);
                        com.baidu.swan.apps.core.f.eU(true);
                        rk.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).q("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.ps("2");
                        boolean td = com.baidu.swan.apps.scheme.actions.forbidden.a.aLe().td(oW);
                        com.baidu.swan.apps.scheme.actions.k.a.X("backtohome", td ? "message" : "relaunch", oW);
                        if (com.baidu.swan.apps.scheme.actions.k.a.tj(oW) && !td) {
                            com.baidu.swan.apps.scheme.actions.k.a.tk("reLaunch");
                        }
                    }
                } else if (d.aNh()) {
                    com.baidu.swan.apps.scheme.actions.k.a.X("backtohome", "relaunch", com.baidu.swan.apps.v.f.aCp().aBY());
                } else {
                    f.aEX().gh(false);
                    rk.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).q("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.ps("3");
                    e.n(aio);
                    e.d(aio);
                }
                if (axr().hasResumed()) {
                    rk.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aMs().tu("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aMs().tu("frame_new_intent");
                com.baidu.swan.apps.runtime.e aJM = com.baidu.swan.apps.runtime.d.aJQ().aJM();
                aJM.aKg().aLD();
                aJM.aKh().clear();
                if (com.baidu.swan.apps.core.i.a.cTQ) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aKd = aJM.aKd();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.aty().atz();
                    }
                    com.baidu.swan.apps.core.i.a.aty().b(aKd);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aMR();
            } else {
                rk.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            axH();
            fy(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cJt.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.O(this.cJt);
        if (com.baidu.swan.apps.core.e.ajD()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aMs().clear();
        com.baidu.swan.apps.ak.a.aMs().tu("frame_create");
        f.aEX().gh(true);
        f.aEX().aFa();
        axJ();
        axF();
        V8Engine.setCrashKeyValue("app_title", aio().avf());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void axa() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aLo();
                com.baidu.swan.apps.v.f.aCp().cN(a.this.cJt);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aGg().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aMs().tu("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aLp();
        f.aEX().aEY();
        com.baidu.swan.apps.t.a.azc().akj();
        com.baidu.swan.apps.v.f.aCp().cO(this.cJt);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int aie() {
        return 0;
    }

    private void axF() {
        e.aMI();
        if (aId()) {
            axK();
            b.a aio = aio();
            if (g(aio)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.aCp().b(aio, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.aCp().a(aio, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aKd = com.baidu.swan.apps.runtime.d.aJQ().aJM().aKd();
            if (aKd == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0474d.bT(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aKd);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String oW(String str) {
        b.a aio = aio();
        if (TextUtils.isEmpty(str) && aio != null && oV(aio.getAppId())) {
            return com.baidu.swan.apps.v.f.aCp().aBY();
        }
        return str;
    }

    private boolean axG() {
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        if (aJQ.aId()) {
            b.a aio = aJQ.aJM().aio();
            String aBe = aio.aBe();
            String aBf = aio.aBf();
            if (TextUtils.isEmpty(aio.aBe()) || TextUtils.equals(aBe, aBf)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aKm = aJM().aKm();
            if (aKm.containsKey(aio.aBe())) {
                return aKm.b(aBe, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void axH() {
        if (axG()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aFl().aFn();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.axL().axM()) {
                com.baidu.swan.apps.p.a.axL().a(this.cJt, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: e */
                    public void O(Boolean bool) {
                        if (a.this.cJt != null && bool.booleanValue()) {
                            a.this.cJt.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cZZ != null && this.cZZ.arE() == 1) {
                com.baidu.swan.apps.p.b axN = new com.baidu.swan.apps.p.b().axN();
                if (axN.isShow()) {
                    com.baidu.swan.apps.p.c.axS().a(this.cJt, axN.getImageUrl(), axN.axR(), aqG());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a aqG() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void ard() {
                if (a.this.cJt != null) {
                    a.this.cJt.moveTaskToBack(true);
                    ap.aPI().lL(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cZZ.arE());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c arB = this.cZZ.arB();
        if (arB == null || !arB.alb()) {
            if (axB()) {
                com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
                if (aJU != null) {
                    aJU.aKl().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aJW());
                com.baidu.swan.apps.v.f.aCp().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.aCy().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(aim(), this.cJt);
            this.cZZ.nC("navigateBack").an(com.baidu.swan.apps.core.d.f.cQd, com.baidu.swan.apps.core.d.f.cQc).arI().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b axx() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aHE().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.axu();
                        com.baidu.swan.apps.runtime.d.aJQ().aJN();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.azw().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.azw().eD(nightModeSwitcherState);
                        if (a.this.cJt != null) {
                            a.this.cJt.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aJU = com.baidu.swan.apps.runtime.e.aJU();
                        if (aJU != null) {
                            aJU.aKg().clear();
                            com.baidu.swan.apps.network.c.a.aFl().aFq();
                        }
                        a.this.axu();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aJQ().aJN();
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
                        com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aEr()));
                        return true;
                    case 129:
                        int aOC = com.baidu.swan.apps.ap.b.aOy().aOC();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aOC);
                        if (a.this.cJt == null || !a.this.cJt.isBackground() || aOC == -1 || a.this.cJt.getTaskId() == aOC) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aJQ().aJN();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String axI() {
        return com.baidu.swan.apps.u.c.b.a(aio(), com.baidu.swan.apps.v.f.aCp().aBU());
    }

    private void fy(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(aio());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dFO = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void axJ() {
        b.a aio = aio();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + aio.auD());
        }
        if (aio.auD() == null || !aio.auD().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            aio.b(com.baidu.swan.apps.swancore.b.la(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + aio.auD());
            }
        }
    }

    private void axK() {
        boolean z = false;
        b.a aio = aio();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (aio == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion auD = com.baidu.swan.apps.core.turbo.d.aui().auD();
        long ur = com.baidu.swan.apps.swancore.b.ur(aio.aBi());
        if (ur != 0 && auD != null && ur > auD.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion auD2 = aio.auD();
        ExtensionCore auE = com.baidu.swan.apps.core.turbo.d.aui().auE();
        ExtensionCore auE2 = aio.auE();
        boolean z2 = auD != null && auD2 != null && auD.swanCoreVersion < auD2.swanCoreVersion && com.baidu.swan.apps.u.c.a.ju(aio.aBr());
        if (auE != null && auE2 != null && auE.extensionCoreVersionCode < auE2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.jv(aio.aBr())) {
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
    protected void axA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void axC() {
        super.axC();
        if (com.baidu.swan.apps.core.turbo.d.aui().auz() != null) {
            com.baidu.swan.apps.core.turbo.d.aui().auz().attachActivity(this.cJt);
        }
    }
}
