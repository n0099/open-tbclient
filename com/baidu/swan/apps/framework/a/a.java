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
        String avi = avi();
        JSONObject parseString = v.parseString(afO().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + avi);
        }
        String ov = ov(avi);
        if (z) {
            e.aKk();
            f.aCw().fP(z2);
            HybridUbcFlow qJ = i.qJ("startup");
            b.a afO = afO();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + ov);
                }
                g.kx(2);
                if (!TextUtils.isEmpty(ov)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", "message", ov);
                    } else {
                        e.a(ov, afO);
                        com.baidu.swan.apps.core.f.eC(true);
                        qJ.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.oR("2");
                        boolean sB = com.baidu.swan.apps.scheme.actions.forbidden.a.aIE().sB(ov);
                        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", sB ? "message" : "relaunch", ov);
                        if (com.baidu.swan.apps.scheme.actions.k.a.sH(ov) && !sB) {
                            com.baidu.swan.apps.scheme.actions.k.a.sI("reLaunch");
                        }
                    }
                } else if (d.aKI()) {
                    com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", "relaunch", com.baidu.swan.apps.v.f.azO().azx());
                } else {
                    f.aCw().fP(false);
                    qJ.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.oR("3");
                    e.n(afO);
                    e.d(afO);
                }
                if (auR().hasResumed()) {
                    qJ.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aJS().sS("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aJS().sS("frame_new_intent");
                com.baidu.swan.apps.runtime.e aHm = com.baidu.swan.apps.runtime.d.aHq().aHm();
                aHm.aHG().aJd();
                aHm.aHH().clear();
                if (com.baidu.swan.apps.core.i.a.cOH) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aHD = aHm.aHD();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.aqY().aqZ();
                    }
                    com.baidu.swan.apps.core.i.a.aqY().b(aHD);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aKs();
            } else {
                qJ.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            avh();
            fg(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cEi.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.P(this.cEi);
        if (com.baidu.swan.apps.core.e.ahd()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aJS().clear();
        com.baidu.swan.apps.ak.a.aJS().sS("frame_create");
        f.aCw().fP(true);
        f.aCw().aCz();
        avj();
        avf();
        V8Engine.setCrashKeyValue("app_title", afO().asF());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auA() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aIO();
                com.baidu.swan.apps.v.f.azO().ch(a.this.cEi);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aDG().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aJS().sS("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aIP();
        f.aCw().aCx();
        com.baidu.swan.apps.t.a.awC().ahJ();
        com.baidu.swan.apps.v.f.azO().ci(this.cEi);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int afE() {
        return 0;
    }

    private void avf() {
        e.aKi();
        if (aFD()) {
            avk();
            b.a afO = afO();
            if (g(afO)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.azO().b(afO, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.azO().a(afO, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aHD = com.baidu.swan.apps.runtime.d.aHq().aHm().aHD();
            if (aHD == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0464d.bN(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aHD);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String ov(String str) {
        b.a afO = afO();
        if (TextUtils.isEmpty(str) && afO != null && ou(afO.getAppId())) {
            return com.baidu.swan.apps.v.f.azO().azx();
        }
        return str;
    }

    private boolean avg() {
        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
        if (aHq.aFD()) {
            b.a afO = aHq.aHm().afO();
            String ayD = afO.ayD();
            String ayE = afO.ayE();
            if (TextUtils.isEmpty(afO.ayD()) || TextUtils.equals(ayD, ayE)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aHM = aHm().aHM();
            if (aHM.containsKey(afO.ayD())) {
                return aHM.b(ayD, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void avh() {
        if (avg()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aCK().aCM();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.avl().avm()) {
                com.baidu.swan.apps.p.a.avl().a(this.cEi, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: e */
                    public void O(Boolean bool) {
                        if (a.this.cEi != null && bool.booleanValue()) {
                            a.this.cEi.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cUP != null && this.cUP.ape() == 1) {
                com.baidu.swan.apps.p.b avn = new com.baidu.swan.apps.p.b().avn();
                if (avn.isShow()) {
                    com.baidu.swan.apps.p.c.avs().a(this.cEi, avn.getImageUrl(), avn.avr(), aog());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a aog() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void aoD() {
                if (a.this.cEi != null) {
                    a.this.cEi.moveTaskToBack(true);
                    ap.aNk().lr(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cUP.ape());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c apb = this.cUP.apb();
        if (apb == null || !apb.aiB()) {
            if (avb()) {
                com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
                if (aHu != null) {
                    aHu.aHL().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aHw());
                com.baidu.swan.apps.v.f.azO().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.azX().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(afM(), this.cEi);
            this.cUP.nb("navigateBack").al(com.baidu.swan.apps.core.d.f.cKU, com.baidu.swan.apps.core.d.f.cKT).apj().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b auX() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.auU();
                        com.baidu.swan.apps.runtime.d.aHq().aHn();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.awW().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.awW().el(nightModeSwitcherState);
                        if (a.this.cEi != null) {
                            a.this.cEi.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aHu = com.baidu.swan.apps.runtime.e.aHu();
                        if (aHu != null) {
                            aHu.aHG().clear();
                            com.baidu.swan.apps.network.c.a.aCK().aCP();
                        }
                        a.this.auU();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aHq().aHn();
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
                        com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBQ()));
                        return true;
                    case 129:
                        int aMd = com.baidu.swan.apps.ap.b.aLZ().aMd();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aMd);
                        if (a.this.cEi == null || !a.this.cEi.isBackground() || aMd == -1 || a.this.cEi.getTaskId() == aMd) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aHq().aHn();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String avi() {
        return com.baidu.swan.apps.u.c.b.a(afO(), com.baidu.swan.apps.v.f.azO().azt());
    }

    private void fg(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(afO());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dAw = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void avj() {
        b.a afO = afO();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + afO.asd());
        }
        if (afO.asd() == null || !afO.asd().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            afO.b(com.baidu.swan.apps.swancore.b.kG(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + afO.asd());
            }
        }
    }

    private void avk() {
        boolean z = false;
        b.a afO = afO();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (afO == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion asd = com.baidu.swan.apps.core.turbo.d.arI().asd();
        long tP = com.baidu.swan.apps.swancore.b.tP(afO.ayH());
        if (tP != 0 && asd != null && tP > asd.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion asd2 = afO.asd();
        ExtensionCore ase = com.baidu.swan.apps.core.turbo.d.arI().ase();
        ExtensionCore ase2 = afO.ase();
        boolean z2 = asd != null && asd2 != null && asd.swanCoreVersion < asd2.swanCoreVersion && com.baidu.swan.apps.u.c.a.ja(afO.ayQ());
        if (ase != null && ase2 != null && ase.extensionCoreVersionCode < ase2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.jb(afO.ayQ())) {
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
    protected void ava() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void avc() {
        super.avc();
        if (com.baidu.swan.apps.core.turbo.d.arI().arZ() != null) {
            com.baidu.swan.apps.core.turbo.d.arI().arZ().attachActivity(this.cEi);
        }
    }
}
