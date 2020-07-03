package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.aa.f;
import com.baidu.swan.apps.aq.an;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.aq.t;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.pms.h;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.o.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.storage.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.b.b;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends c implements e.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void m(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        String aeY = aeY();
        JSONObject parseString = t.parseString(RP().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + aeY);
        }
        String kw = kw(aeY);
        if (z) {
            com.baidu.swan.apps.statistic.e.asr();
            f.alv().ey(z2);
            HybridUbcFlow mx = g.mx("startup");
            b.a RP = RP();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + kw);
                }
                com.baidu.swan.apps.statistic.g.he(2);
                if (!TextUtils.isEmpty(kw)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "message", kw);
                    } else {
                        com.baidu.swan.apps.statistic.e.a(kw, RP);
                        mx.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "relaunch", kw);
                        if (com.baidu.swan.apps.scheme.actions.k.a.om(kw)) {
                            com.baidu.swan.apps.scheme.actions.k.a.oo("reLaunch");
                        }
                    }
                } else if (d.asL()) {
                    com.baidu.swan.apps.scheme.actions.k.a.J("backtohome", "relaunch", com.baidu.swan.apps.w.f.ajb().aiK());
                } else {
                    f.alv().ey(false);
                    mx.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.statistic.e.p(RP);
                    com.baidu.swan.apps.statistic.e.c(RP);
                }
                if (aeH().hasResumed()) {
                    mx.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.al.a.arZ().ow("na_page_show");
                }
                com.baidu.swan.apps.al.a.arZ().ow("frame_new_intent");
                com.baidu.swan.apps.runtime.e apE = com.baidu.swan.apps.runtime.d.apI().apE();
                apE.apY().arq();
                apE.apZ().clear();
            } else {
                mx.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            aeX();
            aeK();
            dV(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bUR.setRequestedOrientation(1);
        com.baidu.swan.apps.aq.d.P(this.bUR);
        if (com.baidu.swan.apps.core.a.ST()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.al.a.arZ().clear();
        com.baidu.swan.apps.al.a.arZ().ow("frame_create");
        f.alv().ey(true);
        f.alv().alx();
        aeZ();
        aeV();
        V8Engine.setCrashKeyValue("app_title", RP().acZ());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void aeq() {
        com.baidu.swan.apps.ai.b.ard();
        com.baidu.swan.apps.w.f.ajb().bT(this.bUR);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        g.amD().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.al.a.arZ().ow("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ai.b.are();
        f.alv().alw();
        com.baidu.swan.apps.u.a.afZ().Tv();
        com.baidu.swan.apps.w.f.ajb().bU(this.bUR);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int RF() {
        return 0;
    }

    private void aeV() {
        com.baidu.swan.apps.statistic.e.asp();
        if (aok()) {
            afa();
            b.a RP = RP();
            if (g(RP)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.f.ajb().b(RP, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.f.ajb().a(RP, (com.baidu.swan.apps.r.b) null);
        }
    }

    private boolean g(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.af.a.a.m(bVar)) {
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
            SwanAppConfigData apV = com.baidu.swan.apps.runtime.d.apI().apE().apV();
            if (apV == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.bm(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, apV);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String kw(String str) {
        b.a RP = RP();
        if (TextUtils.isEmpty(str) && RP != null && kv(RP.getAppId())) {
            return com.baidu.swan.apps.w.f.ajb().aiK();
        }
        return str;
    }

    private boolean aeW() {
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        if (apI.aok()) {
            b.a RP = apI.apE().RP();
            String ahQ = RP.ahQ();
            String ahR = RP.ahR();
            if (TextUtils.isEmpty(RP.ahQ()) || TextUtils.equals(ahQ, ahR)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aqe = apE().aqe();
            if (aqe.containsKey(RP.ahQ())) {
                return aqe.b(ahQ, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void aeX() {
        if (aeW()) {
            n.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.alJ().alL();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.o.a.afb().afc()) {
                com.baidu.swan.apps.o.a.afb().a(this.bUR, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.2
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: d */
                    public void K(Boolean bool) {
                        if (a.this.bUR != null && bool.booleanValue()) {
                            a.this.bUR.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.ciX != null && this.ciX.ZY() == 1) {
                com.baidu.swan.apps.o.b afd = new com.baidu.swan.apps.o.b().afd();
                if (afd.isShow()) {
                    com.baidu.swan.apps.o.c.afi().a(this.bUR, afd.getImageUrl(), afd.afh(), Zd());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a Zd() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.o.c.a
            public void ZB() {
                if (a.this.bUR != null) {
                    a.this.bUR.moveTaskToBack(true);
                    an.ave().hV(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.ciX.ZY());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b ZV = this.ciX.ZV();
        if (ZV == null || !ZV.Ui()) {
            if (aeS()) {
                com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                if (apM != null) {
                    apM.aqd().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.apO());
                com.baidu.swan.apps.w.f.ajb().a(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.aq.e.b(RN(), this.bUR);
            this.ciX.jx("navigateBack").ag(com.baidu.swan.apps.core.d.e.caD, com.baidu.swan.apps.core.d.e.caC).aad().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b aeO() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.anM().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.aeL();
                        com.baidu.swan.apps.runtime.d.apI().apF();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.u.a.ags().getNightModeSwitcherState();
                        com.baidu.swan.apps.u.a.ags().dj(nightModeSwitcherState);
                        if (a.this.bUR != null) {
                            a.this.bUR.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                        if (apM != null) {
                            apM.apY().clear();
                            com.baidu.swan.apps.network.c.a.alJ().alP();
                        }
                        a.this.aeL();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.apI().apF();
                        return true;
                    case 107:
                        h.l(message);
                        return true;
                    case 123:
                        com.baidu.swan.apps.aq.a.N(message);
                        return true;
                    case 124:
                        com.baidu.swan.apps.aq.a.O(message);
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

    private String aeY() {
        return com.baidu.swan.apps.v.b.b.a(RP(), com.baidu.swan.apps.w.f.ajb().aiG());
    }

    private void dV(boolean z) {
        com.baidu.swan.apps.statistic.search.b.q(RP());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cLt = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void aeZ() {
        b.a RP = RP();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + RP.acM());
        }
        if (RP.acM() == null || !RP.acM().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            RP.b(com.baidu.swan.apps.swancore.b.hn(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + RP.acM());
            }
        }
    }

    private void afa() {
        boolean z = false;
        b.a RP = RP();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (RP == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion acM = com.baidu.swan.apps.core.turbo.d.acr().acM();
        long pq = com.baidu.swan.apps.swancore.b.pq(RP.ahU());
        if (pq != 0 && acM != null && pq > acM.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion acM2 = RP.acM();
        ExtensionCore acN = com.baidu.swan.apps.core.turbo.d.acr().acN();
        ExtensionCore acN2 = RP.acN();
        boolean z2 = acM != null && acM2 != null && acM.swanCoreVersion < acM2.swanCoreVersion && com.baidu.swan.apps.v.b.a.fK(RP.aid());
        if (acN != null && acN2 != null && acN.extensionCoreVersionCode < acN2.extensionCoreVersionCode && com.baidu.swan.apps.v.b.a.fL(RP.aid())) {
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
    protected void aeR() {
        this.ciX.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void aab() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void aeT() {
        super.aeT();
        if (com.baidu.swan.apps.core.turbo.d.acr().acH() != null) {
            com.baidu.swan.apps.core.turbo.d.acr().acH().attachActivity(this.bUR);
        }
    }
}
