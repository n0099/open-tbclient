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
        String SY = SY();
        JSONObject parseString = s.parseString(GC().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + SY);
        }
        String hT = hT(SY);
        if (z) {
            com.baidu.swan.apps.statistic.c.aeS();
            f.YM().df(z2);
            HybridUbcFlow jP = com.baidu.swan.apps.performance.f.jP("startup");
            b.a GC = GC();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + hT);
                }
                com.baidu.swan.apps.statistic.e.gr(2);
                if (!TextUtils.isEmpty(hT)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "message", hT);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(hT, GC);
                        jP.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).k("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", hT);
                    }
                } else if (d.afm()) {
                    com.baidu.swan.apps.scheme.actions.k.a.F("backtohome", "relaunch", com.baidu.swan.apps.y.f.WQ().WA());
                } else {
                    f.YM().df(false);
                    jP.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).k("type", "3");
                    com.baidu.swan.apps.statistic.c.n(GC);
                    com.baidu.swan.apps.statistic.c.c(GC);
                }
                if (SH().hasResumed()) {
                    jP.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.aeF().lC("na_page_show");
                }
                com.baidu.swan.apps.an.a.aeF().lC("frame_new_intent");
            } else {
                jP.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            SX();
            SK();
            cD(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.biJ.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.V(this.biJ);
        if (com.baidu.swan.apps.core.a.HT()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.aeF().clear();
        com.baidu.swan.apps.an.a.aeF().lC("frame_create");
        f.YM().df(true);
        f.YM().YO();
        SZ();
        SV();
        V8Engine.setCrashKeyValue("app_title", GC().QZ());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void Sr() {
        com.baidu.swan.apps.ak.b.adO();
        com.baidu.swan.apps.y.f.WQ().cg(this.biJ);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.ZT().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.aeF().lC("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.adP();
        f.YM().YN();
        com.baidu.swan.apps.w.a.TW().HH();
        com.baidu.swan.apps.y.f.WQ().ch(this.biJ);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Gs() {
        return 0;
    }

    private void SV() {
        com.baidu.swan.apps.statistic.c.aeQ();
        if (abh()) {
            Ta();
            b.a GC = GC();
            if (g(GC)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.WQ().b(GC, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.WQ().a(GC, (com.baidu.swan.apps.t.b) null);
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
            SwanAppConfigData acJ = com.baidu.swan.apps.runtime.d.acA().acx().acJ();
            if (acJ == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aL(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, acJ);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String hT(String str) {
        b.a GC = GC();
        if (TextUtils.isEmpty(str) && GC != null && hS(GC.getAppId())) {
            return com.baidu.swan.apps.y.f.WQ().WA();
        }
        return str;
    }

    private boolean SW() {
        com.baidu.swan.apps.runtime.d acA = com.baidu.swan.apps.runtime.d.acA();
        if (acA.abh()) {
            b.a GC = acA.acx().GC();
            String VH = GC.VH();
            String VI = GC.VI();
            if (TextUtils.isEmpty(GC.VH()) || TextUtils.equals(VH, VI)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g acT = acx().acT();
            if (acT.containsKey(GC.VH())) {
                return acT.b(VH, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void SX() {
        if (SW()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.YZ().Zb();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bvw.Oo() == 1) {
            com.baidu.swan.apps.q.b Td = new com.baidu.swan.apps.q.b().Td();
            if (Td.isShow()) {
                com.baidu.swan.apps.q.c.Ti().a(this.biJ, Td.getImageUrl(), Td.Th(), Nx());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a Nx() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void NR() {
                if (a.this.biJ != null) {
                    a.this.biJ.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bvw.Oo());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Ol = this.bvw.Ol();
        if (Ol == null || !Ol.II()) {
            if (SS()) {
                com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
                if (acD != null) {
                    acD.acS().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.acF());
                com.baidu.swan.apps.y.f.WQ().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(GA(), this.biJ);
            this.bvw.hb("navigateBack").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.bof).Ot().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b SO() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aaJ().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.SL();
                        com.baidu.swan.apps.runtime.d.acA().acy();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Uq().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Uq().bU(nightModeSwitcherState);
                        if (a.this.biJ != null) {
                            a.this.biJ.i(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
                        if (acD != null) {
                            acD.acN().clear();
                            com.baidu.swan.apps.network.c.a.YZ().Zf();
                        }
                        a.this.SL();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.acA().acy();
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

    private String SY() {
        return com.baidu.swan.apps.x.b.b.a(GC(), com.baidu.swan.apps.y.f.WQ().Ww());
    }

    private void cD(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(GC());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bVz = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void SZ() {
        b.a GC = GC();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + GC.QO());
        }
        if (GC.QO() == null || !GC.QO().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            GC.b(com.baidu.swan.apps.swancore.b.gz(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + GC.QO());
            }
        }
    }

    private void Ta() {
        boolean z = true;
        b.a GC = GC();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (GC == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion QO = com.baidu.swan.apps.core.k.d.Qu().QO();
        long mp = com.baidu.swan.apps.swancore.b.mp(GC.VL());
        if (mp != 0 && QO != null && mp > QO.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion QO2 = GC.QO();
        ExtensionCore QP = com.baidu.swan.apps.core.k.d.Qu().QP();
        ExtensionCore QP2 = GC.QP();
        boolean z2 = QO != null && QO2 != null && QO.swanCoreVersion < QO2.swanCoreVersion && com.baidu.swan.apps.x.b.a.ff(GC.VU());
        if (QP == null || QP2 == null || QP.extensionCoreVersionCode >= QP2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.fg(GC.VU())) {
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
    protected void SR() {
        this.bvw.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Or() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ST() {
        super.ST();
        if (com.baidu.swan.apps.core.k.d.Qu().QJ() != null) {
            com.baidu.swan.apps.core.k.d.Qu().QJ().H(this.biJ);
        }
    }
}
