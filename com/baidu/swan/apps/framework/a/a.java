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
        String asI = asI();
        JSONObject parseString = v.parseString(ado().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + asI);
        }
        String og = og(asI);
        if (z) {
            e.aHK();
            f.azW().fG(z2);
            HybridUbcFlow qv = i.qv("startup");
            b.a ado = ado();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + og);
                }
                g.kn(2);
                if (!TextUtils.isEmpty(og)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", "message", og);
                    } else {
                        e.a(og, ado);
                        com.baidu.swan.apps.core.f.et(true);
                        qv.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.oD("2");
                        boolean sm = com.baidu.swan.apps.scheme.actions.forbidden.a.aGe().sm(og);
                        com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", sm ? "message" : "relaunch", og);
                        if (com.baidu.swan.apps.scheme.actions.k.a.st(og) && !sm) {
                            com.baidu.swan.apps.scheme.actions.k.a.su("reLaunch");
                        }
                    }
                } else if (d.aIi()) {
                    com.baidu.swan.apps.scheme.actions.k.a.U("backtohome", "relaunch", com.baidu.swan.apps.v.f.axo().awX());
                } else {
                    f.azW().fG(false);
                    qv.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.oD("3");
                    e.n(ado);
                    e.d(ado);
                }
                if (asr().hasResumed()) {
                    qv.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aHs().sE("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aHs().sE("frame_new_intent");
                com.baidu.swan.apps.runtime.e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
                aEM.aFg().aGD();
                aEM.aFh().clear();
                if (com.baidu.swan.apps.core.i.a.cIO) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aFd = aEM.aFd();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.aox().aoy();
                    }
                    com.baidu.swan.apps.core.i.a.aox().b(aFd);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aHS();
            } else {
                qv.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            asH();
            eX(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cyp.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.P(this.cyp);
        if (com.baidu.swan.apps.core.e.aeD()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aHs().clear();
        com.baidu.swan.apps.ak.a.aHs().sE("frame_create");
        f.azW().fG(true);
        f.azW().azZ();
        asJ();
        asF();
        V8Engine.setCrashKeyValue("app_title", ado().aqe());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void arZ() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aGo();
                com.baidu.swan.apps.v.f.axo().ch(a.this.cyp);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aBg().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aHs().sE("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aGp();
        f.azW().azX();
        com.baidu.swan.apps.t.a.auc().afj();
        com.baidu.swan.apps.v.f.axo().ci(this.cyp);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ade() {
        return 0;
    }

    private void asF() {
        e.aHI();
        if (aDd()) {
            asK();
            b.a ado = ado();
            if (g(ado)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.axo().b(ado, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.axo().a(ado, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aFd = com.baidu.swan.apps.runtime.d.aEQ().aEM().aFd();
            if (aFd == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0452d.bN(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aFd);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String og(String str) {
        b.a ado = ado();
        if (TextUtils.isEmpty(str) && ado != null && oe(ado.getAppId())) {
            return com.baidu.swan.apps.v.f.axo().awX();
        }
        return str;
    }

    private boolean asG() {
        com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
        if (aEQ.aDd()) {
            b.a ado = aEQ.aEM().ado();
            String awd = ado.awd();
            String awe = ado.awe();
            if (TextUtils.isEmpty(ado.awd()) || TextUtils.equals(awd, awe)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aFm = aEM().aFm();
            if (aFm.containsKey(ado.awd())) {
                return aFm.b(awd, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void asH() {
        if (asG()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aAk().aAm();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.asL().asM()) {
                com.baidu.swan.apps.p.a.asL().a(this.cyp, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: e */
                    public void O(Boolean bool) {
                        if (a.this.cyp != null && bool.booleanValue()) {
                            a.this.cyp.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cOW != null && this.cOW.amE() == 1) {
                com.baidu.swan.apps.p.b asN = new com.baidu.swan.apps.p.b().asN();
                if (asN.isShow()) {
                    com.baidu.swan.apps.p.c.asS().a(this.cyp, asN.getImageUrl(), asN.asR(), alG());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a alG() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void amd() {
                if (a.this.cyp != null) {
                    a.this.cyp.moveTaskToBack(true);
                    ap.aKK().lh(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cOW.amE());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c amB = this.cOW.amB();
        if (amB == null || !amB.agb()) {
            if (asB()) {
                com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
                if (aEU != null) {
                    aEU.aFl().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aEW());
                com.baidu.swan.apps.v.f.axo().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.axx().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(adm(), this.cyp);
            this.cOW.mM("navigateBack").al(com.baidu.swan.apps.core.d.f.cFb, com.baidu.swan.apps.core.d.f.cFa).amI().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b asx() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aCE().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.asu();
                        com.baidu.swan.apps.runtime.d.aEQ().aEN();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.auw().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.auw().ec(nightModeSwitcherState);
                        if (a.this.cyp != null) {
                            a.this.cyp.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aEU = com.baidu.swan.apps.runtime.e.aEU();
                        if (aEU != null) {
                            aEU.aFg().clear();
                            com.baidu.swan.apps.network.c.a.aAk().aAp();
                        }
                        a.this.asu();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aEQ().aEN();
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
                        com.baidu.swan.apps.menu.fontsize.a.e(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.azq()));
                        return true;
                    case 129:
                        int aJD = com.baidu.swan.apps.ap.b.aJz().aJD();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aJD);
                        if (a.this.cyp == null || !a.this.cyp.isBackground() || aJD == -1 || a.this.cyp.getTaskId() == aJD) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aEQ().aEN();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String asI() {
        return com.baidu.swan.apps.u.c.b.a(ado(), com.baidu.swan.apps.v.f.axo().awT());
    }

    private void eX(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(ado());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.duE = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void asJ() {
        b.a ado = ado();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + ado.apD());
        }
        if (ado.apD() == null || !ado.apD().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            ado.b(com.baidu.swan.apps.swancore.b.kw(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + ado.apD());
            }
        }
    }

    private void asK() {
        boolean z = false;
        b.a ado = ado();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (ado == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion apD = com.baidu.swan.apps.core.turbo.d.aph().apD();
        long tB = com.baidu.swan.apps.swancore.b.tB(ado.awh());
        if (tB != 0 && apD != null && tB > apD.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion apD2 = ado.apD();
        ExtensionCore apE = com.baidu.swan.apps.core.turbo.d.aph().apE();
        ExtensionCore apE2 = ado.apE();
        boolean z2 = apD != null && apD2 != null && apD.swanCoreVersion < apD2.swanCoreVersion && com.baidu.swan.apps.u.c.a.iQ(ado.awq());
        if (apE != null && apE2 != null && apE.extensionCoreVersionCode < apE2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.iR(ado.awq())) {
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
    protected void asA() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void asC() {
        super.asC();
        if (com.baidu.swan.apps.core.turbo.d.aph().apz() != null) {
            com.baidu.swan.apps.core.turbo.d.aph().apz().attachActivity(this.cyp);
        }
    }
}
