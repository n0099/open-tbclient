package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ac.f;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.as.s;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.pms.h;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.q.c;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.scheme.actions.k.g;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.storage.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.x.b.b;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c implements e.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void l(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        String aaS = aaS();
        JSONObject parseString = s.parseString(Ow().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + aaS);
        }
        String jg = jg(aaS);
        if (z) {
            com.baidu.swan.apps.statistic.c.anc();
            f.agX().ec(z2);
            HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            b.a Ow = Ow();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + jg);
                }
                com.baidu.swan.apps.statistic.e.gy(2);
                if (!TextUtils.isEmpty(jg)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "message", jg);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(jg, Ow);
                        lb.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).p("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", jg);
                    }
                } else if (d.anw()) {
                    com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", com.baidu.swan.apps.y.f.aeK().aeu());
                } else {
                    f.agX().ec(false);
                    lb.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).p("type", "3");
                    com.baidu.swan.apps.statistic.c.n(Ow);
                    com.baidu.swan.apps.statistic.c.c(Ow);
                }
                if (aaB().hasResumed()) {
                    lb.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.amP().mO("na_page_show");
                }
                com.baidu.swan.apps.an.a.amP().mO("frame_new_intent");
            } else {
                lb.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            aaR();
            aaE();
            dA(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bHg.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.R(this.bHg);
        if (com.baidu.swan.apps.core.a.PK()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.amP().clear();
        com.baidu.swan.apps.an.a.amP().mO("frame_create");
        f.agX().ec(true);
        f.agX().agZ();
        aaT();
        aaP();
        V8Engine.setCrashKeyValue("app_title", Ow().YT());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aal() {
        com.baidu.swan.apps.ak.b.alY();
        com.baidu.swan.apps.y.f.aeK().bT(this.bHg);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.aid().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.amP().mO("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.alZ();
        f.agX().agY();
        com.baidu.swan.apps.w.a.abQ().Pz();
        com.baidu.swan.apps.y.f.aeK().bU(this.bHg);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Om() {
        return 0;
    }

    private void aaP() {
        com.baidu.swan.apps.statistic.c.ana();
        if (ajr()) {
            aaU();
            b.a Ow = Ow();
            if (g(Ow)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.aeK().b(Ow, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.aeK().a(Ow, (com.baidu.swan.apps.t.b) null);
        }
    }

    private boolean g(com.baidu.swan.apps.x.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ah.a.a.k(bVar)) {
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
            SwanAppConfigData akT = com.baidu.swan.apps.runtime.d.akK().akH().akT();
            if (akT == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aT(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, akT);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String jg(String str) {
        b.a Ow = Ow();
        if (TextUtils.isEmpty(str) && Ow != null && jf(Ow.getAppId())) {
            return com.baidu.swan.apps.y.f.aeK().aeu();
        }
        return str;
    }

    private boolean aaQ() {
        com.baidu.swan.apps.runtime.d akK = com.baidu.swan.apps.runtime.d.akK();
        if (akK.ajr()) {
            b.a Ow = akK.akH().Ow();
            String adB = Ow.adB();
            String adC = Ow.adC();
            if (TextUtils.isEmpty(Ow.adB()) || TextUtils.equals(adB, adC)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g ald = akH().ald();
            if (ald.containsKey(Ow.adB())) {
                return ald.b(adB, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void aaR() {
        if (aaQ()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.ahk().ahm();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bTQ.Wh() == 1) {
            com.baidu.swan.apps.q.b aaX = new com.baidu.swan.apps.q.b().aaX();
            if (aaX.isShow()) {
                com.baidu.swan.apps.q.c.abc().a(this.bHg, aaX.getImageUrl(), aaX.abb(), Vp());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a Vp() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void VK() {
                if (a.this.bHg != null) {
                    a.this.bHg.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bTQ.Wh());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b We = this.bTQ.We();
        if (We == null || !We.Qz()) {
            if (aaM()) {
                com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
                if (akN != null) {
                    akN.alc().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.akP());
                com.baidu.swan.apps.y.f.aeK().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(Ou(), this.bHg);
            this.bTQ.io("navigateBack").ab(com.baidu.swan.apps.core.d.e.bMB, com.baidu.swan.apps.core.d.e.bMA).Wm().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aaI() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aiT().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.aaF();
                        com.baidu.swan.apps.runtime.d.akK().akI();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.ack().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.ack().cR(nightModeSwitcherState);
                        if (a.this.bHg != null) {
                            a.this.bHg.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
                        if (akN != null) {
                            akN.akX().clear();
                            com.baidu.swan.apps.network.c.a.ahk().ahq();
                        }
                        a.this.aaF();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.akK().akI();
                        return true;
                    case 107:
                        h.l(message);
                        return true;
                    case 301:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case 302:
                        com.baidu.swan.apps.process.messaging.a.a.q(message);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String aaS() {
        return com.baidu.swan.apps.x.b.b.a(Ow(), com.baidu.swan.apps.y.f.aeK().aeq());
    }

    private void dA(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(Ow());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cuE = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void aaT() {
        b.a Ow = Ow();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Ow.YI());
        }
        if (Ow.YI() == null || !Ow.YI().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            Ow.b(com.baidu.swan.apps.swancore.b.gG(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Ow.YI());
            }
        }
    }

    private void aaU() {
        boolean z = true;
        b.a Ow = Ow();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (Ow == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion YI = com.baidu.swan.apps.core.k.d.Yo().YI();
        long nB = com.baidu.swan.apps.swancore.b.nB(Ow.adF());
        if (nB != 0 && YI != null && nB > YI.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion YI2 = Ow.YI();
        ExtensionCore YJ = com.baidu.swan.apps.core.k.d.Yo().YJ();
        ExtensionCore YJ2 = Ow.YJ();
        boolean z2 = YI != null && YI2 != null && YI.swanCoreVersion < YI2.swanCoreVersion && com.baidu.swan.apps.x.b.a.fk(Ow.adO());
        if (YJ == null || YJ2 == null || YJ.extensionCoreVersionCode >= YJ2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.fl(Ow.adO())) {
            z = false;
        }
        if (z2 || z) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            com.baidu.swan.apps.core.k.d.release();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aaL() {
        this.bTQ.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Wk() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aaN() {
        super.aaN();
        if (com.baidu.swan.apps.core.k.d.Yo().YD() != null) {
            com.baidu.swan.apps.core.k.d.Yo().YD().D(this.bHg);
        }
    }
}
