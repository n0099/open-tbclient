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
    protected void m(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        String Ta = Ta();
        JSONObject parseString = s.parseString(GE().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + Ta);
        }
        String hT = hT(Ta);
        if (z) {
            com.baidu.swan.apps.statistic.c.aeU();
            f.YO().df(z2);
            HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            b.a GE = GE();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + hT);
                }
                com.baidu.swan.apps.statistic.e.gr(2);
                if (!TextUtils.isEmpty(hT)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "message", hT);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(hT, GE);
                        jP.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).k("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", hT);
                    }
                } else if (d.afo()) {
                    com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", com.baidu.swan.apps.y.f.WS().WC());
                } else {
                    f.YO().df(false);
                    jP.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).k("type", "3");
                    com.baidu.swan.apps.statistic.c.n(GE);
                    com.baidu.swan.apps.statistic.c.c(GE);
                }
                if (SJ().hasResumed()) {
                    jP.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.aeH().lC("na_page_show");
                }
                com.baidu.swan.apps.an.a.aeH().lC("frame_new_intent");
            } else {
                jP.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            SZ();
            SM();
            cD(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.biL.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.V(this.biL);
        if (com.baidu.swan.apps.core.a.HV()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.aeH().clear();
        com.baidu.swan.apps.an.a.aeH().lC("frame_create");
        f.YO().df(true);
        f.YO().YQ();
        Tb();
        SX();
        V8Engine.setCrashKeyValue("app_title", GE().Rb());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void St() {
        com.baidu.swan.apps.ak.b.adQ();
        com.baidu.swan.apps.y.f.WS().cg(this.biL);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.ZV().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.aeH().lC("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.adR();
        f.YO().YP();
        com.baidu.swan.apps.w.a.TY().HJ();
        com.baidu.swan.apps.y.f.WS().ch(this.biL);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gu() {
        return 0;
    }

    private void SX() {
        com.baidu.swan.apps.statistic.c.aeS();
        if (abj()) {
            Tc();
            b.a GE = GE();
            if (g(GE)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.WS().b(GE, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.WS().a(GE, (com.baidu.swan.apps.t.b) null);
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
            SwanAppConfigData acL = com.baidu.swan.apps.runtime.d.acC().acz().acL();
            if (acL == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aL(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, acL);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String hT(String str) {
        b.a GE = GE();
        if (TextUtils.isEmpty(str) && GE != null && hS(GE.getAppId())) {
            return com.baidu.swan.apps.y.f.WS().WC();
        }
        return str;
    }

    private boolean SY() {
        com.baidu.swan.apps.runtime.d acC = com.baidu.swan.apps.runtime.d.acC();
        if (acC.abj()) {
            b.a GE = acC.acz().GE();
            String VJ = GE.VJ();
            String VK = GE.VK();
            if (TextUtils.isEmpty(GE.VJ()) || TextUtils.equals(VJ, VK)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g acV = acz().acV();
            if (acV.containsKey(GE.VJ())) {
                return acV.b(VJ, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void SZ() {
        if (SY()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.Zb().Zd();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bvy.Oq() == 1) {
            com.baidu.swan.apps.q.b Tf = new com.baidu.swan.apps.q.b().Tf();
            if (Tf.isShow()) {
                com.baidu.swan.apps.q.c.Tk().a(this.biL, Tf.getImageUrl(), Tf.Tj(), Nz());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a Nz() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void NT() {
                if (a.this.biL != null) {
                    a.this.biL.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bvy.Oq());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b On = this.bvy.On();
        if (On == null || !On.IK()) {
            if (SU()) {
                com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                if (acF != null) {
                    acF.acU().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.acH());
                com.baidu.swan.apps.y.f.WS().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(GC(), this.biL);
            this.bvy.hb("navigateBack").Y(com.baidu.swan.apps.core.d.e.boi, com.baidu.swan.apps.core.d.e.boh).Ov().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b SQ() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aaL().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.SN();
                        com.baidu.swan.apps.runtime.d.acC().acA();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Us().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Us().bU(nightModeSwitcherState);
                        if (a.this.biL != null) {
                            a.this.biL.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                        if (acF != null) {
                            acF.acP().clear();
                            com.baidu.swan.apps.network.c.a.Zb().Zh();
                        }
                        a.this.SN();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.acC().acA();
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

    private String Ta() {
        return com.baidu.swan.apps.x.b.b.a(GE(), com.baidu.swan.apps.y.f.WS().Wy());
    }

    private void cD(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(GE());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bVB = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void Tb() {
        b.a GE = GE();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + GE.QQ());
        }
        if (GE.QQ() == null || !GE.QQ().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            GE.b(com.baidu.swan.apps.swancore.b.gz(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + GE.QQ());
            }
        }
    }

    private void Tc() {
        boolean z = true;
        b.a GE = GE();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (GE == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion QQ = com.baidu.swan.apps.core.k.d.Qw().QQ();
        long mp = com.baidu.swan.apps.swancore.b.mp(GE.VN());
        if (mp != 0 && QQ != null && mp > QQ.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion QQ2 = GE.QQ();
        ExtensionCore QR = com.baidu.swan.apps.core.k.d.Qw().QR();
        ExtensionCore QR2 = GE.QR();
        boolean z2 = QQ != null && QQ2 != null && QQ.swanCoreVersion < QQ2.swanCoreVersion && com.baidu.swan.apps.x.b.a.ff(GE.VW());
        if (QR == null || QR2 == null || QR.extensionCoreVersionCode >= QR2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.fg(GE.VW())) {
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
    protected void ST() {
        this.bvy.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Ot() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void SV() {
        super.SV();
        if (com.baidu.swan.apps.core.k.d.Qw().QL() != null) {
            com.baidu.swan.apps.core.k.d.Qw().QL().H(this.biL);
        }
    }
}
