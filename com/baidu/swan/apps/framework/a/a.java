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
/* loaded from: classes9.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void q(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String avE = avE();
        JSONObject parseString = v.parseString(afZ().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + avE);
        }
        String nU = nU(avE);
        if (z) {
            e.aLA();
            f.aCU().go(z2);
            HybridUbcFlow qk = i.qk("startup");
            b.a afZ = afZ();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + nU);
                }
                g.setStartType(2);
                if (!TextUtils.isEmpty(nU)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "message", nU);
                    } else {
                        e.a(nU, afZ);
                        com.baidu.swan.apps.core.f.fb(true);
                        qk.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).o("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.os("2");
                        boolean sh = com.baidu.swan.apps.scheme.actions.forbidden.a.aJU().sh(nU);
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", sh ? "message" : "relaunch", nU);
                        if (com.baidu.swan.apps.scheme.actions.k.a.sn(nU) && !sh) {
                            com.baidu.swan.apps.scheme.actions.k.a.so("reLaunch");
                        }
                    }
                } else if (d.aLX()) {
                    com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "relaunch", com.baidu.swan.apps.v.f.aAl().azU());
                } else {
                    f.aCU().go(false);
                    qk.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).o("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.os("3");
                    e.n(afZ);
                    e.d(afZ);
                }
                if (avn().hasResumed()) {
                    qk.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.aj.a.aLi().sz("na_page_show");
                }
                com.baidu.swan.apps.aj.a.aLi().sz("frame_new_intent");
                com.baidu.swan.apps.runtime.e aIC = com.baidu.swan.apps.runtime.d.aIG().aIC();
                aIC.aIW().aKt();
                aIC.aIX().clear();
                if (com.baidu.swan.apps.core.i.a.cWn) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aIT = aIC.aIT();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.art().aru();
                    }
                    com.baidu.swan.apps.core.i.a.art().b(aIT);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aLH();
            } else {
                qk.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            avD();
            fF(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cLQ.setRequestedOrientation(1);
        com.baidu.swan.apps.ao.e.J(this.cLQ);
        if (com.baidu.swan.apps.core.e.ahq()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.aj.a.aLi().clear();
        com.baidu.swan.apps.aj.a.aLi().sz("frame_create");
        f.aCU().go(true);
        f.aCU().aCX();
        avF();
        avB();
        V8Engine.setCrashKeyValue("app_title", afZ().atc());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auW() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ag.b.aKe();
                com.baidu.swan.apps.v.f.aAl().cT(a.this.cLQ);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aEb().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.aj.a.aLi().sz("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ag.b.aKf();
        f.aCU().aCV();
        com.baidu.swan.apps.t.a.awY().ahW();
        com.baidu.swan.apps.v.f.aAl().cU(this.cLQ);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int getFrameType() {
        return 0;
    }

    private void avB() {
        e.aLy();
        if (aFY()) {
            avG();
            b.a afZ = afZ();
            if (g(afZ)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.aAl().b(afZ, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.aAl().a(afZ, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aIT = com.baidu.swan.apps.runtime.d.aIG().aIC().aIT();
            if (aIT == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0446d.bL(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aIT);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String nU(String str) {
        b.a afZ = afZ();
        if (TextUtils.isEmpty(str) && afZ != null && nT(afZ.getAppId())) {
            return com.baidu.swan.apps.v.f.aAl().azU();
        }
        return str;
    }

    private boolean avC() {
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        if (aIG.aFY()) {
            b.a afZ = aIG.aIC().afZ();
            String aza = afZ.aza();
            String azb = afZ.azb();
            if (TextUtils.isEmpty(afZ.aza()) || TextUtils.equals(aza, azb)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aJc = aIC().aJc();
            if (aJc.containsKey(afZ.aza())) {
                return aJc.b(aza, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void avD() {
        if (avC()) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aDi().aDk();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.avH().avI()) {
                com.baidu.swan.apps.p.a.avH().a(this.cLQ, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: f */
                    public void N(Boolean bool) {
                        if (a.this.cLQ != null && bool.booleanValue()) {
                            a.this.cLQ.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.dcr != null && this.dcr.apA() == 1) {
                com.baidu.swan.apps.p.b avJ = new com.baidu.swan.apps.p.b().avJ();
                if (avJ.isShow()) {
                    com.baidu.swan.apps.p.c.avO().a(this.cLQ, avJ.getImageUrl(), avJ.avN(), aow());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a aow() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void aoY() {
                if (a.this.cLQ != null) {
                    a.this.cLQ.moveTaskToBack(true);
                    ap.aOA().kn(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.dcr.apA());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c apx = this.dcr.apx();
        if (apx == null || !apx.aiQ()) {
            if (avx()) {
                com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
                if (aIK != null) {
                    aIK.aJb().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIM());
                com.baidu.swan.apps.v.f.aAl().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.aAu().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ao.f.b(afX(), this.cLQ);
            this.dcr.mC("navigateBack").af(com.baidu.swan.apps.core.d.f.cSB, com.baidu.swan.apps.core.d.f.cSA).apE().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b avt() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFz().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.avq();
                        com.baidu.swan.apps.runtime.d.aIG().aID();
                        return true;
                    case 102:
                        boolean aii = com.baidu.swan.apps.t.a.axs().aii();
                        com.baidu.swan.apps.t.a.axs().eK(aii);
                        if (a.this.cLQ != null) {
                            a.this.cLQ.l(aii, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aIK = com.baidu.swan.apps.runtime.e.aIK();
                        if (aIK != null) {
                            aIK.aIW().clear();
                            com.baidu.swan.apps.network.c.a.aDi().aDn();
                        }
                        a.this.avq();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aIG().aID();
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
                        com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aCo()));
                        return true;
                    case 129:
                        int aNt = com.baidu.swan.apps.ao.b.aNp().aNt();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aNt);
                        if (a.this.cLQ == null || !a.this.cLQ.isBackground() || aNt == -1 || a.this.cLQ.getTaskId() == aNt) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aIG().aID();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String avE() {
        return com.baidu.swan.apps.u.c.b.a(afZ(), com.baidu.swan.apps.v.f.aAl().azQ());
    }

    private void fF(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(afZ());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dLK = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void avF() {
        b.a afZ = afZ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + afZ.asA());
        }
        if (afZ.asA() == null || !afZ.asA().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            afZ.b(com.baidu.swan.apps.swancore.b.jC(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + afZ.asA());
            }
        }
    }

    private void avG() {
        boolean z = false;
        b.a afZ = afZ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (afZ == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion asA = com.baidu.swan.apps.core.turbo.d.ase().asA();
        long tw = com.baidu.swan.apps.swancore.b.tw(afZ.aze());
        if (tw != 0 && asA != null && tw > asA.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion asA2 = afZ.asA();
        ExtensionCore asB = com.baidu.swan.apps.core.turbo.d.ase().asB();
        ExtensionCore asB2 = afZ.asB();
        boolean z2 = asA != null && asA2 != null && asA.swanCoreVersion < asA2.swanCoreVersion && com.baidu.swan.apps.u.c.a.hM(afZ.azn());
        if (asB != null && asB2 != null && asB.extensionCoreVersionCode < asB2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.hN(afZ.azn())) {
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
    protected void avw() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void avy() {
        super.avy();
        if (com.baidu.swan.apps.core.turbo.d.ase().asw() != null) {
            com.baidu.swan.apps.core.turbo.d.ase().asw().attachActivity(this.cLQ);
        }
    }
}
