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
        String Td = Td();
        JSONObject parseString = s.parseString(GJ().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + Td);
        }
        String hS = hS(Td);
        if (z) {
            com.baidu.swan.apps.statistic.c.aeX();
            f.YR().dg(z2);
            HybridUbcFlow jO = com.baidu.swan.apps.performance.f.jO("startup");
            b.a GJ = GJ();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + hS);
                }
                com.baidu.swan.apps.statistic.e.gr(2);
                if (!TextUtils.isEmpty(hS)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "message", hS);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(hS, GJ);
                        jO.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).k("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", hS);
                    }
                } else if (d.afr()) {
                    com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", com.baidu.swan.apps.y.f.WV().WF());
                } else {
                    f.YR().dg(false);
                    jO.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).k("type", "3");
                    com.baidu.swan.apps.statistic.c.n(GJ);
                    com.baidu.swan.apps.statistic.c.c(GJ);
                }
                if (SM().hasResumed()) {
                    jO.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.aeK().lB("na_page_show");
                }
                com.baidu.swan.apps.an.a.aeK().lB("frame_new_intent");
            } else {
                jO.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            Tc();
            SP();
            cE(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.biY.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.V(this.biY);
        if (com.baidu.swan.apps.core.a.HY()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.aeK().clear();
        com.baidu.swan.apps.an.a.aeK().lB("frame_create");
        f.YR().dg(true);
        f.YR().YT();
        Te();
        Ta();
        V8Engine.setCrashKeyValue("app_title", GJ().Re());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void Sw() {
        com.baidu.swan.apps.ak.b.adT();
        com.baidu.swan.apps.y.f.WV().cf(this.biY);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.ZY().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.aeK().lB("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.adU();
        f.YR().YS();
        com.baidu.swan.apps.w.a.Ub().HM();
        com.baidu.swan.apps.y.f.WV().cg(this.biY);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gz() {
        return 0;
    }

    private void Ta() {
        com.baidu.swan.apps.statistic.c.aeV();
        if (abm()) {
            Tf();
            b.a GJ = GJ();
            if (g(GJ)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.WV().b(GJ, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.WV().a(GJ, (com.baidu.swan.apps.t.b) null);
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
            SwanAppConfigData acO = com.baidu.swan.apps.runtime.d.acF().acC().acO();
            if (acO == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aK(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, acO);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String hS(String str) {
        b.a GJ = GJ();
        if (TextUtils.isEmpty(str) && GJ != null && hR(GJ.getAppId())) {
            return com.baidu.swan.apps.y.f.WV().WF();
        }
        return str;
    }

    private boolean Tb() {
        com.baidu.swan.apps.runtime.d acF = com.baidu.swan.apps.runtime.d.acF();
        if (acF.abm()) {
            b.a GJ = acF.acC().GJ();
            String VM = GJ.VM();
            String VN = GJ.VN();
            if (TextUtils.isEmpty(GJ.VM()) || TextUtils.equals(VM, VN)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g acY = acC().acY();
            if (acY.containsKey(GJ.VM())) {
                return acY.b(VM, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void Tc() {
        if (Tb()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.Ze().Zg();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bvK.Ot() == 1) {
            com.baidu.swan.apps.q.b Ti = new com.baidu.swan.apps.q.b().Ti();
            if (Ti.isShow()) {
                com.baidu.swan.apps.q.c.Tn().a(this.biY, Ti.getImageUrl(), Ti.Tm(), NC());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a NC() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void NW() {
                if (a.this.biY != null) {
                    a.this.biY.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bvK.Ot());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Oq = this.bvK.Oq();
        if (Oq == null || !Oq.IN()) {
            if (SX()) {
                com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
                if (acI != null) {
                    acI.acX().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.acK());
                com.baidu.swan.apps.y.f.WV().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(GH(), this.biY);
            this.bvK.ha("navigateBack").Y(com.baidu.swan.apps.core.d.e.bou, com.baidu.swan.apps.core.d.e.bot).Oy().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ST() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aaO().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.SQ();
                        com.baidu.swan.apps.runtime.d.acF().acD();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uv().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Uv().bV(nightModeSwitcherState);
                        if (a.this.biY != null) {
                            a.this.biY.j(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
                        if (acI != null) {
                            acI.acS().clear();
                            com.baidu.swan.apps.network.c.a.Ze().Zk();
                        }
                        a.this.SQ();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.acF().acD();
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

    private String Td() {
        return com.baidu.swan.apps.x.b.b.a(GJ(), com.baidu.swan.apps.y.f.WV().WB());
    }

    private void cE(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(GJ());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bVM = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void Te() {
        b.a GJ = GJ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + GJ.QT());
        }
        if (GJ.QT() == null || !GJ.QT().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            GJ.b(com.baidu.swan.apps.swancore.b.gz(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + GJ.QT());
            }
        }
    }

    private void Tf() {
        boolean z = true;
        b.a GJ = GJ();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (GJ == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion QT = com.baidu.swan.apps.core.k.d.Qz().QT();
        long mo = com.baidu.swan.apps.swancore.b.mo(GJ.VQ());
        if (mo != 0 && QT != null && mo > QT.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion QT2 = GJ.QT();
        ExtensionCore QU = com.baidu.swan.apps.core.k.d.Qz().QU();
        ExtensionCore QU2 = GJ.QU();
        boolean z2 = QT != null && QT2 != null && QT.swanCoreVersion < QT2.swanCoreVersion && com.baidu.swan.apps.x.b.a.ff(GJ.VZ());
        if (QU == null || QU2 == null || QU.extensionCoreVersionCode >= QU2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.fg(GJ.VZ())) {
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
    protected void SW() {
        this.bvK.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Ow() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void SY() {
        super.SY();
        if (com.baidu.swan.apps.core.k.d.Qz().QO() != null) {
            com.baidu.swan.apps.core.k.d.Qz().QO().H(this.biY);
        }
    }
}
