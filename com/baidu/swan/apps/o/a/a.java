package com.baidu.swan.apps.o.a;

import android.content.Intent;
import android.os.Bundle;
import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.i;
import com.baidu.swan.apps.core.c.e;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.statistic.b.c;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import java.util.HashMap;
/* loaded from: classes2.dex */
public class a extends d implements e.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity) {
        super(swanAppActivity);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onCreate(Bundle bundle) {
        this.avZ.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.M(this.avZ);
        if (com.baidu.swan.apps.core.a.vw()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.EP().fm("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.b.dA(bundle == null ? 0 : 1);
        if (bundle == null) {
            BJ();
            bc(false);
            c.s(this.ajy);
        }
        BV();
        h(this.ajy);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.JK();
        com.baidu.swan.apps.w.e.Ea().bL(this.avZ);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.FQ().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.EP().fm("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int us() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            BW();
            com.baidu.swan.apps.w.e.Ea().f(this.avZ);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.Ea().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.Ea().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.ayb != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c ed = com.baidu.swan.apps.core.g.a.zN().ed(bVar.mAppId);
            if (ed == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (c.d.ah(bVar.mAppId, bVar.mVersion).exists()) {
                return !com.baidu.swan.apps.scheme.actions.h.f.b(bVar, ed);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        long currentTimeMillis = System.currentTimeMillis();
        com.baidu.swan.apps.v.b.b G = com.baidu.swan.apps.v.b.b.G(intent);
        com.baidu.swan.apps.statistic.b.c.s(G);
        f.aEg = false;
        f.c(currentTimeMillis, true);
        if (!TextUtils.equals(G.mAppId, this.ajy.mAppId) || com.baidu.swan.apps.console.a.d.wO()) {
            com.baidu.swan.apps.statistic.b.dA(3);
            this.avZ.B(intent);
            BI();
            g(G);
            BG();
            com.baidu.swan.apps.w.e.release();
            h(this.ajy);
            BH();
        } else {
            HybridUbcFlow fz = f.fz("startup");
            com.baidu.swan.apps.statistic.b.dA(2);
            fz.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(currentTimeMillis));
            this.ajy = G;
            this.ajy.ayf = currentTimeMillis;
            String BU = BU();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + BU);
            }
            if (!TextUtils.isEmpty(BU)) {
                fz.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).i("type", "2");
                com.baidu.swan.apps.scheme.actions.h.a.t("backtohome", "relaunch", BU);
            } else {
                fz.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).i("type", "3");
            }
            fz.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.ajy);
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.statistic.c.a(G, "clientready");
            com.baidu.swan.apps.y.f.EP().fm("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.ajy);
        BJ();
        bc(true);
        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
        if (IV != null) {
            IV.IZ().JU();
            IV.Ja().clear();
        }
        com.baidu.swan.apps.y.f.EP().fm("frame_new_intent");
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.awa.yQ() == 1) {
                this.avZ.bK(2);
                if (uD()) {
                    return true;
                }
            }
            if (com.baidu.swan.apps.u.a.CJ().Du()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.awa.yQ());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.c.b yN = this.awa.yN();
        if (yN == null || !yN.vX()) {
            if (BT()) {
                com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
                if (IV != null) {
                    IV.Je().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.Jg());
                com.baidu.swan.apps.w.e.Ea().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.awa.ea("navigateBack").A(e.aqQ, e.aqP).yV().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d BN() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.1
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Go().sendMessage(4);
                        a.this.BK();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Dq = com.baidu.swan.apps.u.a.CR().Dq();
                        com.baidu.swan.apps.u.a.CR().bg(Dq);
                        a.this.g(Dq, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b IV = com.baidu.swan.apps.ae.b.IV();
                        if (IV != null) {
                            IV.IZ().clear();
                        }
                        a.this.BK();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        com.baidu.swan.apps.scheme.actions.h.f.JJ().w((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        com.baidu.swan.apps.scheme.actions.h.f.JJ().v((Bundle) message.obj);
                        return true;
                    case 106:
                        a.this.reset();
                        return true;
                    case 107:
                        i.i(message);
                        return true;
                    case 301:
                        com.baidu.swan.apps.process.messaging.a.a.l(message);
                        return true;
                    case 302:
                        com.baidu.swan.apps.process.messaging.a.a.o(message);
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.o.d
    public void onDestroy() {
        com.baidu.swan.apps.ag.b.JL();
        com.baidu.swan.apps.y.f.EP().ES();
        com.baidu.swan.apps.u.a.Cy().uZ();
        com.baidu.swan.apps.w.e.Ea().bM(this.avZ);
        com.baidu.swan.apps.w.e.Ea().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String BU() {
        if (this.ajy != null) {
            String str = this.ajy.axM;
            String a = com.baidu.swan.apps.v.b.b.a(this.ajy, com.baidu.swan.apps.w.e.Ea().DI());
            this.ajy.axM = str;
            return a;
        }
        return null;
    }

    private void bc(boolean z) {
        com.baidu.swan.apps.statistic.search.b.u(this.ajy);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.aSP = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void BV() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.ajy.atv);
        }
        if (this.ajy.atv == null || !this.ajy.atv.isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.ajy.atv = com.baidu.swan.apps.swancore.b.dI(0);
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.ajy.atv);
            }
        }
    }

    private void BW() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.ajy == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion Ar = com.baidu.swan.apps.core.i.c.Aa().Ar();
        long hh = com.baidu.swan.apps.swancore.b.hh(this.ajy.axQ);
        if (hh != 0 && Ar != null && hh > Ar.aTh) {
            com.baidu.swan.apps.core.i.c.release();
            return;
        }
        SwanCoreVersion swanCoreVersion = this.ajy.atv;
        ExtensionCore As = com.baidu.swan.apps.core.i.c.Aa().As();
        ExtensionCore extensionCore = this.ajy.atw;
        boolean z2 = Ar != null && swanCoreVersion != null && Ar.aTh < swanCoreVersion.aTh && com.baidu.swan.apps.v.b.a.cB(this.ajy.ayd);
        if (As == null || extensionCore == null || As.avP >= extensionCore.avP || !com.baidu.swan.apps.v.b.a.cC(this.ajy.ayd)) {
            z = false;
        }
        if (z2 || z) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            com.baidu.swan.apps.core.i.c.release();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BS() {
        this.awa.a(this);
    }

    @Override // com.baidu.swan.apps.core.c.e.a
    public void yT() {
        com.baidu.swan.apps.y.f.EP().h(this.avZ);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BG() {
        if (this.awg == null) {
            this.awg = new com.baidu.swan.apps.view.b(this.avZ);
        }
        this.awg.h(false, false);
    }
}
