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
/* loaded from: classes8.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String anr = anr();
        JSONObject parseString = v.parseString(XZ().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + anr);
        }
        String mH = mH(anr);
        if (z) {
            e.aCx();
            f.auI().eZ(z2);
            HybridUbcFlow oX = i.oX("startup");
            b.a XZ = XZ();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + mH);
                }
                g.ju(2);
                if (!TextUtils.isEmpty(mH)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", "message", mH);
                    } else {
                        e.a(mH, XZ);
                        com.baidu.swan.apps.core.f.dM(true);
                        oX.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.nd("2");
                        boolean qO = com.baidu.swan.apps.scheme.actions.forbidden.a.aAS().qO(mH);
                        com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", qO ? "message" : "relaunch", mH);
                        if (com.baidu.swan.apps.scheme.actions.k.a.qU(mH) && !qO) {
                            com.baidu.swan.apps.scheme.actions.k.a.qV("reLaunch");
                        }
                    }
                } else if (d.aCV()) {
                    com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", "relaunch", com.baidu.swan.apps.v.f.arY().arH());
                } else {
                    f.auI().eZ(false);
                    oX.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.nd("3");
                    e.n(XZ);
                    e.d(XZ);
                }
                if (ana().hasResumed()) {
                    oX.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aCf().rf("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aCf().rf("frame_new_intent");
                com.baidu.swan.apps.runtime.e azA = com.baidu.swan.apps.runtime.d.azE().azA();
                azA.azU().aBq();
                azA.azV().clear();
                if (com.baidu.swan.apps.core.i.a.clZ) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData azR = azA.azR();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.aji().ajj();
                    }
                    com.baidu.swan.apps.core.i.a.aji().b(azR);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aCF();
            } else {
                oX.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            anq();
            eq(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cbv.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.M(this.cbv);
        if (com.baidu.swan.apps.core.e.Zo()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aCf().clear();
        com.baidu.swan.apps.ak.a.aCf().rf("frame_create");
        f.auI().eZ(true);
        f.auI().auL();
        ans();
        ano();
        V8Engine.setCrashKeyValue("app_title", XZ().akO());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void amJ() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aBc();
                com.baidu.swan.apps.v.f.arY().cc(a.this.cbv);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.avS().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aCf().rf("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aBd();
        f.auI().auJ();
        com.baidu.swan.apps.t.a.aoL().ZU();
        com.baidu.swan.apps.v.f.arY().cd(this.cbv);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int XP() {
        return 0;
    }

    private void ano() {
        e.aCv();
        if (axR()) {
            ant();
            b.a XZ = XZ();
            if (g(XZ)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.arY().b(XZ, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.arY().a(XZ, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData azR = com.baidu.swan.apps.runtime.d.azE().azA().azR();
            if (azR == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0426d.bB(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, azR);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String mH(String str) {
        b.a XZ = XZ();
        if (TextUtils.isEmpty(str) && XZ != null && mG(XZ.getAppId())) {
            return com.baidu.swan.apps.v.f.arY().arH();
        }
        return str;
    }

    private boolean anp() {
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        if (azE.axR()) {
            b.a XZ = azE.azA().XZ();
            String aqN = XZ.aqN();
            String aqO = XZ.aqO();
            if (TextUtils.isEmpty(XZ.aqN()) || TextUtils.equals(aqN, aqO)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aAa = azA().aAa();
            if (aAa.containsKey(XZ.aqN())) {
                return aAa.b(aqN, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void anq() {
        if (anp()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.auW().auY();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.anu().anv()) {
                com.baidu.swan.apps.p.a.anu().a(this.cbv, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: d */
                    public void K(Boolean bool) {
                        if (a.this.cbv != null && bool.booleanValue()) {
                            a.this.cbv.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.csn != null && this.csn.ahp() == 1) {
                com.baidu.swan.apps.p.b anw = new com.baidu.swan.apps.p.b().anw();
                if (anw.isShow()) {
                    com.baidu.swan.apps.p.c.anB().a(this.cbv, anw.getImageUrl(), anw.anA(), agr());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a agr() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void agO() {
                if (a.this.cbv != null) {
                    a.this.cbv.moveTaskToBack(true);
                    ap.aFx().ko(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.csn.ahp());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c ahm = this.csn.ahm();
        if (ahm == null || !ahm.aaM()) {
            if (ank()) {
                com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
                if (azI != null) {
                    azI.azZ().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.azK());
                com.baidu.swan.apps.v.f.arY().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.ash().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(XX(), this.cbv);
            this.csn.lo("navigateBack").al(com.baidu.swan.apps.core.d.f.cim, com.baidu.swan.apps.core.d.f.cil).aht().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ang() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.axs().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.and();
                        com.baidu.swan.apps.runtime.d.azE().azB();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apf().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.apf().dv(nightModeSwitcherState);
                        if (a.this.cbv != null) {
                            a.this.cbv.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e azI = com.baidu.swan.apps.runtime.e.azI();
                        if (azI != null) {
                            azI.azU().clear();
                            com.baidu.swan.apps.network.c.a.auW().avb();
                        }
                        a.this.and();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.azE().azB();
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
                        com.baidu.swan.apps.menu.fontsize.a.c(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.auc()));
                        return true;
                    case 129:
                        int aEq = com.baidu.swan.apps.ap.b.aEm().aEq();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aEq);
                        if (a.this.cbv == null || !a.this.cbv.isBackground() || aEq == -1 || a.this.cbv.getTaskId() == aEq) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.azE().azB();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String anr() {
        return com.baidu.swan.apps.u.c.b.a(XZ(), com.baidu.swan.apps.v.f.arY().arD());
    }

    private void eq(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(XZ());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cXS = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void ans() {
        b.a XZ = XZ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + XZ.akn());
        }
        if (XZ.akn() == null || !XZ.akn().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            XZ.b(com.baidu.swan.apps.swancore.b.jD(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + XZ.akn());
            }
        }
    }

    private void ant() {
        boolean z = false;
        b.a XZ = XZ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (XZ == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion akn = com.baidu.swan.apps.core.turbo.d.ajS().akn();
        long sc = com.baidu.swan.apps.swancore.b.sc(XZ.aqR());
        if (sc != 0 && akn != null && sc > akn.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion akn2 = XZ.akn();
        ExtensionCore ako = com.baidu.swan.apps.core.turbo.d.ajS().ako();
        ExtensionCore ako2 = XZ.ako();
        boolean z2 = akn != null && akn2 != null && akn.swanCoreVersion < akn2.swanCoreVersion && com.baidu.swan.apps.u.c.a.hY(XZ.ara());
        if (ako != null && ako2 != null && ako.extensionCoreVersionCode < ako2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.hZ(XZ.ara())) {
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
    protected void anj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void anl() {
        super.anl();
        if (com.baidu.swan.apps.core.turbo.d.ajS().akj() != null) {
            com.baidu.swan.apps.core.turbo.d.ajS().akj().attachActivity(this.cbv);
        }
    }
}
