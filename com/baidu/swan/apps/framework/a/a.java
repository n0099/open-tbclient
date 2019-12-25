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
/* loaded from: classes9.dex */
public class a extends c implements e.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void k(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        String Qo = Qo();
        JSONObject parseString = s.parseString(DR().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + Qo);
        }
        String hB = hB(Qo);
        if (z) {
            com.baidu.swan.apps.statistic.c.ach();
            f.Wb().cT(z2);
            HybridUbcFlow jx = com.baidu.swan.apps.performance.f.jx("startup");
            b.a DR = DR();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + hB);
                }
                com.baidu.swan.apps.statistic.e.fZ(2);
                if (!TextUtils.isEmpty(hB)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "message", hB);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(hB, DR);
                        jx.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).k("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "relaunch", hB);
                    }
                } else if (d.acB()) {
                    com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "relaunch", com.baidu.swan.apps.y.f.Uf().TP());
                } else {
                    f.Wb().cT(false);
                    jx.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).k("type", "3");
                    com.baidu.swan.apps.statistic.c.n(DR);
                    com.baidu.swan.apps.statistic.c.c(DR);
                }
                if (PX().hasResumed()) {
                    jx.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.abU().lk("na_page_show");
                }
                com.baidu.swan.apps.an.a.abU().lk("frame_new_intent");
            } else {
                jx.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            Qn();
            Qa();
            cr(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bdF.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.T(this.bdF);
        if (com.baidu.swan.apps.core.a.Fi()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.abU().clear();
        com.baidu.swan.apps.an.a.abU().lk("frame_create");
        f.Wb().cT(true);
        f.Wb().Wd();
        Qp();
        Ql();
        V8Engine.setCrashKeyValue("app_title", DR().Op());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void PH() {
        com.baidu.swan.apps.ak.b.abd();
        com.baidu.swan.apps.y.f.Uf().cc(this.bdF);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.Xi().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.abU().lk("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.abe();
        f.Wb().Wc();
        com.baidu.swan.apps.w.a.Rm().EW();
        com.baidu.swan.apps.y.f.Uf().cd(this.bdF);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int DH() {
        return 0;
    }

    private void Ql() {
        com.baidu.swan.apps.statistic.c.acf();
        if (Yw()) {
            Qq();
            b.a DR = DR();
            if (g(DR)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.Uf().b(DR, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.Uf().a(DR, (com.baidu.swan.apps.t.b) null);
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
            SwanAppConfigData ZY = com.baidu.swan.apps.runtime.d.ZP().ZM().ZY();
            if (ZY == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aA(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, ZY);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String hB(String str) {
        b.a DR = DR();
        if (TextUtils.isEmpty(str) && DR != null && hA(DR.getAppId())) {
            return com.baidu.swan.apps.y.f.Uf().TP();
        }
        return str;
    }

    private boolean Qm() {
        com.baidu.swan.apps.runtime.d ZP = com.baidu.swan.apps.runtime.d.ZP();
        if (ZP.Yw()) {
            b.a DR = ZP.ZM().DR();
            String SW = DR.SW();
            String SX = DR.SX();
            if (TextUtils.isEmpty(DR.SW()) || TextUtils.equals(SW, SX)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aai = ZM().aai();
            if (aai.containsKey(DR.SW())) {
                return aai.b(SW, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void Qn() {
        if (Qm()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.Wo().Wq();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.bqy.LE() == 1) {
            com.baidu.swan.apps.q.b Qt = new com.baidu.swan.apps.q.b().Qt();
            if (Qt.isShow()) {
                com.baidu.swan.apps.q.c.Qy().a(this.bdF, Qt.getImageUrl(), Qt.Qx(), KN());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a KN() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void Lh() {
                if (a.this.bdF != null) {
                    a.this.bdF.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.bqy.LE());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b LB = this.bqy.LB();
        if (LB == null || !LB.FX()) {
            if (Qi()) {
                com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                if (ZS != null) {
                    ZS.aah().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.ZU());
                com.baidu.swan.apps.y.f.Uf().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(DP(), this.bdF);
            this.bqy.gJ("navigateBack").U(com.baidu.swan.apps.core.d.e.bjh, com.baidu.swan.apps.core.d.e.bjg).LJ().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b Qe() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.XY().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.Qb();
                        com.baidu.swan.apps.runtime.d.ZP().ZN();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.RG().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.RG().bH(nightModeSwitcherState);
                        if (a.this.bdF != null) {
                            a.this.bdF.h(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                        if (ZS != null) {
                            ZS.aac().clear();
                            com.baidu.swan.apps.network.c.a.Wo().Wu();
                        }
                        a.this.Qb();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.ZP().ZN();
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

    private String Qo() {
        return com.baidu.swan.apps.x.b.b.a(DR(), com.baidu.swan.apps.y.f.Uf().TL());
    }

    private void cr(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(DR());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bQK = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void Qp() {
        b.a DR = DR();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + DR.Oe());
        }
        if (DR.Oe() == null || !DR.Oe().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            DR.b(com.baidu.swan.apps.swancore.b.gh(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + DR.Oe());
            }
        }
    }

    private void Qq() {
        boolean z = true;
        b.a DR = DR();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (DR == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion Oe = com.baidu.swan.apps.core.k.d.NK().Oe();
        long lX = com.baidu.swan.apps.swancore.b.lX(DR.Ta());
        if (lX != 0 && Oe != null && lX > Oe.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion Oe2 = DR.Oe();
        ExtensionCore Of = com.baidu.swan.apps.core.k.d.NK().Of();
        ExtensionCore Of2 = DR.Of();
        boolean z2 = Oe != null && Oe2 != null && Oe.swanCoreVersion < Oe2.swanCoreVersion && com.baidu.swan.apps.x.b.a.eO(DR.Tj());
        if (Of == null || Of2 == null || Of.extensionCoreVersionCode >= Of2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.eP(DR.Tj())) {
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
    protected void Qh() {
        this.bqy.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void LH() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void Qj() {
        super.Qj();
        if (com.baidu.swan.apps.core.k.d.NK().NZ() != null) {
            com.baidu.swan.apps.core.k.d.NK().NZ().F(this.bdF);
        }
    }
}
