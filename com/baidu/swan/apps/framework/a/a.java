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
        String aaR = aaR();
        JSONObject parseString = s.parseString(Ov().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + aaR);
        }
        String jg = jg(aaR);
        if (z) {
            com.baidu.swan.apps.statistic.c.anb();
            f.agW().ec(z2);
            HybridUbcFlow lb = com.baidu.swan.apps.performance.f.lb("startup");
            b.a Ov = Ov();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + jg);
                }
                com.baidu.swan.apps.statistic.e.gy(2);
                if (!TextUtils.isEmpty(jg)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "message", jg);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(jg, Ov);
                        lb.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).p("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", jg);
                    }
                } else if (d.anv()) {
                    com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", com.baidu.swan.apps.y.f.aeJ().aet());
                } else {
                    f.agW().ec(false);
                    lb.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).p("type", "3");
                    com.baidu.swan.apps.statistic.c.n(Ov);
                    com.baidu.swan.apps.statistic.c.c(Ov);
                }
                if (aaA().hasResumed()) {
                    lb.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.amO().mO("na_page_show");
                }
                com.baidu.swan.apps.an.a.amO().mO("frame_new_intent");
            } else {
                lb.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            aaQ();
            aaD();
            dA(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bHl.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.R(this.bHl);
        if (com.baidu.swan.apps.core.a.PJ()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.amO().clear();
        com.baidu.swan.apps.an.a.amO().mO("frame_create");
        f.agW().ec(true);
        f.agW().agY();
        aaS();
        aaO();
        V8Engine.setCrashKeyValue("app_title", Ov().YS());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aak() {
        com.baidu.swan.apps.ak.b.alX();
        com.baidu.swan.apps.y.f.aeJ().bH(this.bHl);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.aic().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.amO().mO("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.alY();
        f.agW().agX();
        com.baidu.swan.apps.w.a.abP().Py();
        com.baidu.swan.apps.y.f.aeJ().bI(this.bHl);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Ol() {
        return 0;
    }

    private void aaO() {
        com.baidu.swan.apps.statistic.c.amZ();
        if (ajq()) {
            aaT();
            b.a Ov = Ov();
            if (g(Ov)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.aeJ().b(Ov, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.aeJ().a(Ov, (com.baidu.swan.apps.t.b) null);
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
            SwanAppConfigData akS = com.baidu.swan.apps.runtime.d.akJ().akG().akS();
            if (akS == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aT(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, akS);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String jg(String str) {
        b.a Ov = Ov();
        if (TextUtils.isEmpty(str) && Ov != null && jf(Ov.getAppId())) {
            return com.baidu.swan.apps.y.f.aeJ().aet();
        }
        return str;
    }

    private boolean aaP() {
        com.baidu.swan.apps.runtime.d akJ = com.baidu.swan.apps.runtime.d.akJ();
        if (akJ.ajq()) {
            b.a Ov = akJ.akG().Ov();
            String adA = Ov.adA();
            String adB = Ov.adB();
            if (TextUtils.isEmpty(Ov.adA()) || TextUtils.equals(adA, adB)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g alc = akG().alc();
            if (alc.containsKey(Ov.adA())) {
                return alc.b(adA, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void aaQ() {
        if (aaP()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.ahj().ahl();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bTW.Wg() == 1) {
            com.baidu.swan.apps.q.b aaW = new com.baidu.swan.apps.q.b().aaW();
            if (aaW.isShow()) {
                com.baidu.swan.apps.q.c.abb().a(this.bHl, aaW.getImageUrl(), aaW.aba(), Vo());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a Vo() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void VJ() {
                if (a.this.bHl != null) {
                    a.this.bHl.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bTW.Wg());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Wd = this.bTW.Wd();
        if (Wd == null || !Wd.Qy()) {
            if (aaL()) {
                com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
                if (akM != null) {
                    akM.alb().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.akO());
                com.baidu.swan.apps.y.f.aeJ().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(Ot(), this.bHl);
            this.bTW.io("navigateBack").ab(com.baidu.swan.apps.core.d.e.bMG, com.baidu.swan.apps.core.d.e.bMF).Wl().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aaH() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aiS().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.aaE();
                        com.baidu.swan.apps.runtime.d.akJ().akH();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.acj().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.acj().cR(nightModeSwitcherState);
                        if (a.this.bHl != null) {
                            a.this.bHl.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
                        if (akM != null) {
                            akM.akW().clear();
                            com.baidu.swan.apps.network.c.a.ahj().ahp();
                        }
                        a.this.aaE();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.akJ().akH();
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

    private String aaR() {
        return com.baidu.swan.apps.x.b.b.a(Ov(), com.baidu.swan.apps.y.f.aeJ().aep());
    }

    private void dA(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(Ov());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cuK = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void aaS() {
        b.a Ov = Ov();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + Ov.YH());
        }
        if (Ov.YH() == null || !Ov.YH().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            Ov.b(com.baidu.swan.apps.swancore.b.gG(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + Ov.YH());
            }
        }
    }

    private void aaT() {
        boolean z = true;
        b.a Ov = Ov();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (Ov == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion YH = com.baidu.swan.apps.core.k.d.Yn().YH();
        long nB = com.baidu.swan.apps.swancore.b.nB(Ov.adE());
        if (nB != 0 && YH != null && nB > YH.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion YH2 = Ov.YH();
        ExtensionCore YI = com.baidu.swan.apps.core.k.d.Yn().YI();
        ExtensionCore YI2 = Ov.YI();
        boolean z2 = YH != null && YH2 != null && YH.swanCoreVersion < YH2.swanCoreVersion && com.baidu.swan.apps.x.b.a.fk(Ov.adN());
        if (YI == null || YI2 == null || YI.extensionCoreVersionCode >= YI2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.fl(Ov.adN())) {
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
    protected void aaK() {
        this.bTW.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Wj() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aaM() {
        super.aaM();
        if (com.baidu.swan.apps.core.k.d.Yn().YC() != null) {
            com.baidu.swan.apps.core.k.d.Yn().YC().D(this.bHl);
        }
    }
}
