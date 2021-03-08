package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.v;
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
import com.thunder.livesdk.system.ThunderNetStateService;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void q(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String avH = avH();
        JSONObject parseString = v.parseString(agc().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + avH);
        }
        String ob = ob(avH);
        if (z) {
            e.aLD();
            f.aCX().go(z2);
            HybridUbcFlow qr = i.qr("startup");
            b.a agc = agc();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + ob);
                }
                g.setStartType(2);
                if (!TextUtils.isEmpty(ob)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "message", ob);
                    } else {
                        e.a(ob, agc);
                        com.baidu.swan.apps.core.f.fb(true);
                        qr.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).p("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.oz("2");
                        boolean so = com.baidu.swan.apps.scheme.actions.forbidden.a.aJX().so(ob);
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", so ? "message" : "relaunch", ob);
                        if (com.baidu.swan.apps.scheme.actions.k.a.sv(ob) && !so) {
                            com.baidu.swan.apps.scheme.actions.k.a.sw("reLaunch");
                        }
                    }
                } else if (d.aMa()) {
                    com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "relaunch", com.baidu.swan.apps.v.f.aAo().azX());
                } else {
                    f.aCX().go(false);
                    qr.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).p("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.oz("3");
                    e.n(agc);
                    e.d(agc);
                }
                if (avq().hasResumed()) {
                    qr.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.aj.a.aLl().sG("na_page_show");
                }
                com.baidu.swan.apps.aj.a.aLl().sG("frame_new_intent");
                com.baidu.swan.apps.runtime.e aIF = com.baidu.swan.apps.runtime.d.aIJ().aIF();
                aIF.aIZ().aKw();
                aIF.aJa().clear();
                if (com.baidu.swan.apps.core.i.a.cXN) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aIW = aIF.aIW();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.arw().arx();
                    }
                    com.baidu.swan.apps.core.i.a.arw().b(aIW);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aLK();
            } else {
                qr.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            avG();
            fF(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cNq.setRequestedOrientation(1);
        com.baidu.swan.apps.ao.e.J(this.cNq);
        if (com.baidu.swan.apps.core.e.aht()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.aj.a.aLl().clear();
        com.baidu.swan.apps.aj.a.aLl().sG("frame_create");
        f.aCX().go(true);
        f.aCX().aDa();
        avI();
        avE();
        V8Engine.setCrashKeyValue("app_title", agc().atf());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auZ() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ag.b.aKh();
                com.baidu.swan.apps.v.f.aAo().cS(a.this.cNq);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aEe().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.aj.a.aLl().sG("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ag.b.aKi();
        f.aCX().aCY();
        com.baidu.swan.apps.t.a.axb().ahZ();
        com.baidu.swan.apps.v.f.aAo().cT(this.cNq);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return 0;
    }

    private void avE() {
        e.aLB();
        if (aGb()) {
            avJ();
            b.a agc = agc();
            if (g(agc)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.aAo().b(agc, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.aAo().a(agc, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aIW = com.baidu.swan.apps.runtime.d.aIJ().aIF().aIW();
            if (aIW == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0452d.bL(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aIW);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String ob(String str) {
        b.a agc = agc();
        if (TextUtils.isEmpty(str) && agc != null && oa(agc.getAppId())) {
            return com.baidu.swan.apps.v.f.aAo().azX();
        }
        return str;
    }

    private boolean avF() {
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        if (aIJ.aGb()) {
            b.a agc = aIJ.aIF().agc();
            String azd = agc.azd();
            String aze = agc.aze();
            if (TextUtils.isEmpty(agc.azd()) || TextUtils.equals(azd, aze)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aJf = aIF().aJf();
            if (aJf.containsKey(agc.azd())) {
                return aJf.c(azd, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void avG() {
        if (avF()) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aDl().aDn();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.avK().avL()) {
                com.baidu.swan.apps.p.a.avK().a(this.cNq, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: f */
                    public void P(Boolean bool) {
                        if (a.this.cNq != null && bool.booleanValue()) {
                            a.this.cNq.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.ddU != null && this.ddU.apD() == 1) {
                com.baidu.swan.apps.p.b avM = new com.baidu.swan.apps.p.b().avM();
                if (avM.isShow()) {
                    com.baidu.swan.apps.p.c.avR().a(this.cNq, avM.getImageUrl(), avM.avQ(), aoz());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a aoz() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void apb() {
                if (a.this.cNq != null) {
                    a.this.cNq.moveTaskToBack(true);
                    ap.aOD().ko(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.ddU.apD());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c apA = this.ddU.apA();
        if (apA == null || !apA.aiT()) {
            if (avA()) {
                com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
                if (aIN != null) {
                    aIN.aJe().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIP());
                com.baidu.swan.apps.v.f.aAo().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.aAx().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ao.f.b(aga(), this.cNq);
            this.ddU.mJ("navigateBack").af(com.baidu.swan.apps.core.d.f.cUb, com.baidu.swan.apps.core.d.f.cUa).apH().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b avw() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFC().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.avt();
                        com.baidu.swan.apps.runtime.d.aIJ().aIG();
                        return true;
                    case 102:
                        boolean ail = com.baidu.swan.apps.t.a.axv().ail();
                        com.baidu.swan.apps.t.a.axv().eK(ail);
                        if (a.this.cNq != null) {
                            a.this.cNq.l(ail, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aIN = com.baidu.swan.apps.runtime.e.aIN();
                        if (aIN != null) {
                            aIN.aIZ().clear();
                            com.baidu.swan.apps.network.c.a.aDl().aDq();
                        }
                        a.this.avt();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aIJ().aIG();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.m(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        com.baidu.swan.apps.ao.b.O(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        com.baidu.swan.apps.ao.b.P(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case ThunderNetStateService.NetState.SYSNET_UNKNOWN /* 127 */:
                        com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aCr()));
                        return true;
                    case 129:
                        int aNw = com.baidu.swan.apps.ao.b.aNs().aNw();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aNw);
                        if (a.this.cNq == null || !a.this.cNq.isBackground() || aNw == -1 || a.this.cNq.getTaskId() == aNw) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aIJ().aIG();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String avH() {
        return com.baidu.swan.apps.u.c.b.a(agc(), com.baidu.swan.apps.v.f.aAo().azT());
    }

    private void fF(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(agc());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dNl = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void avI() {
        b.a agc = agc();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + agc.asD());
        }
        if (agc.asD() == null || !agc.asD().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            agc.b(com.baidu.swan.apps.swancore.b.jD(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + agc.asD());
            }
        }
    }

    private void avJ() {
        boolean z = false;
        b.a agc = agc();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (agc == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion asD = com.baidu.swan.apps.core.turbo.d.ash().asD();
        long tD = com.baidu.swan.apps.swancore.b.tD(agc.azh());
        if (tD != 0 && asD != null && tD > asD.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion asD2 = agc.asD();
        ExtensionCore asE = com.baidu.swan.apps.core.turbo.d.ash().asE();
        ExtensionCore asE2 = agc.asE();
        boolean z2 = asD != null && asD2 != null && asD.swanCoreVersion < asD2.swanCoreVersion && com.baidu.swan.apps.u.c.a.hN(agc.azq());
        if (asE != null && asE2 != null && asE.extensionCoreVersionCode < asE2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.hO(agc.azq())) {
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
    protected void avz() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void avB() {
        super.avB();
        if (com.baidu.swan.apps.core.turbo.d.ash().asz() != null) {
            com.baidu.swan.apps.core.turbo.d.ash().asz().attachActivity(this.cNq);
        }
    }
}
