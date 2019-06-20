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
import com.baidu.swan.apps.an.j;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.core.a.i;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.o.d;
import com.baidu.swan.apps.p.a;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.scheme.actions.i.g;
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
        this.aww.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.N(this.aww);
        if (com.baidu.swan.apps.core.a.wl()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.GN().fy("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.d.dL(bundle == null ? 0 : 1);
        if (bundle == null) {
            CL();
            bh(false);
            c.u(this.ajM);
        }
        CX();
        h(this.ajM);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.Mk();
        com.baidu.swan.apps.w.e.FV().bh(this.aww);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.HY().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.GN().fy("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int vc() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        com.baidu.swan.apps.statistic.e.MQ();
        if (bVar != null) {
            CY();
            com.baidu.swan.apps.w.e.FV().f(this.aww);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.FV().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.FV().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.Fg() != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c dQ = com.baidu.swan.apps.core.h.a.AW().dQ(bVar.getAppId());
            if (dQ == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.ae(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, dQ);
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
        com.baidu.swan.apps.v.b.b F = com.baidu.swan.apps.v.b.b.F(intent);
        c.u(F);
        f.aFY = false;
        f.c(currentTimeMillis, true);
        boolean ad = ad(F.EW(), this.ajM.EW());
        if (!TextUtils.equals(F.getAppId(), this.ajM.getAppId()) || com.baidu.swan.apps.console.a.d.xG()) {
            com.baidu.swan.apps.statistic.d.dL(3);
            this.aww.A(intent);
            CK();
            g(F);
            CI();
            com.baidu.swan.apps.w.e.release();
            h(this.ajM);
            CJ();
        } else {
            HybridUbcFlow fN = f.fN("startup");
            com.baidu.swan.apps.statistic.d.dL(2);
            fN.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(currentTimeMillis));
            this.ajM = com.baidu.swan.apps.v.b.b.a(this.ajM, F);
            this.ajM.H(currentTimeMillis);
            String CW = CW();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + CW);
            }
            if (!TextUtils.isEmpty(CW)) {
                fN.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).j("type", "2");
                com.baidu.swan.apps.scheme.actions.i.a.t("backtohome", "relaunch", CW);
                com.baidu.swan.apps.statistic.e.MQ();
            } else {
                fN.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).j("type", "3");
            }
            fN.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.ajM);
            c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.y.f.GN().fy("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.ajM);
        bg(ad);
        CL();
        bh(true);
        com.baidu.swan.apps.statistic.e.r(this.ajM);
        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
        if (Lq != null) {
            Lq.Lu().Mu();
            Lq.Lv().clear();
        }
        com.baidu.swan.apps.y.f.GN().fy("frame_new_intent");
    }

    private boolean ad(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, str2)) {
            return false;
        }
        com.baidu.swan.apps.ae.d LA = com.baidu.swan.apps.ae.b.Lq().LA();
        if (LA.containsKey(str)) {
            return LA.getBoolean(str, false) ? false : true;
        }
        return true;
    }

    private void bg(boolean z) {
        if (z) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.o.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.Hi().update();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.awx.zN() == 1) {
            this.aww.bK(2);
            if (vn()) {
                com.baidu.swan.apps.p.a CZ = com.baidu.swan.apps.p.a.CZ();
                CZ.a(this.aww, CZ.Db(), new a.InterfaceC0153a() { // from class: com.baidu.swan.apps.o.a.a.2
                    @Override // com.baidu.swan.apps.p.a.InterfaceC0153a
                    public void zp() {
                        if (a.this.aww != null) {
                            a.this.aww.moveTaskToBack(true);
                        }
                    }
                });
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.awx.zN());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b zK = this.awx.zK();
        if (zK == null || !zK.wO()) {
            if (CV()) {
                com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                if (Lq != null) {
                    Lq.Lz().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.LB());
                com.baidu.swan.apps.w.e.FV().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.awx.dN("navigateBack").y(com.baidu.swan.apps.core.d.e.aqV, com.baidu.swan.apps.core.d.e.aqU).zS().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d CP() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.IE().sendMessage(4);
                        a.this.CM();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Ev = com.baidu.swan.apps.u.a.DW().Ev();
                        com.baidu.swan.apps.u.a.DW().bn(Ev);
                        a.this.g(Ev, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                        if (Lq != null) {
                            Lq.Lu().clear();
                        }
                        a.this.CM();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        g.Mj().x((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        g.Mj().w((Bundle) message.obj);
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
        com.baidu.swan.apps.ag.b.Ml();
        com.baidu.swan.apps.y.f.GN().GT();
        com.baidu.swan.apps.u.a.DD().we();
        com.baidu.swan.apps.w.e.FV().bi(this.aww);
        com.baidu.swan.apps.w.e.FV().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String CW() {
        if (this.ajM != null) {
            String page = this.ajM.getPage();
            String a = com.baidu.swan.apps.v.b.b.a(this.ajM, com.baidu.swan.apps.w.e.FV().FD());
            this.ajM.setPage(page);
            return a;
        }
        return null;
    }

    private void bh(boolean z) {
        com.baidu.swan.apps.statistic.search.b.w(this.ajM);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.aVE = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void CX() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.ajM.BA());
        }
        if (this.ajM.BA() == null || !this.ajM.BA().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.ajM.a(com.baidu.swan.apps.swancore.b.dT(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.ajM.BA());
            }
        }
    }

    private void CY() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.ajM == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion BA = com.baidu.swan.apps.core.j.c.Bi().BA();
        long hH = com.baidu.swan.apps.swancore.b.hH(this.ajM.EZ());
        if (hH != 0 && BA != null && hH > BA.aVW) {
            com.baidu.swan.apps.core.j.c.release();
            return;
        }
        SwanCoreVersion BA2 = this.ajM.BA();
        ExtensionCore BB = com.baidu.swan.apps.core.j.c.Bi().BB();
        ExtensionCore BB2 = this.ajM.BB();
        boolean z2 = BA != null && BA2 != null && BA.aVW < BA2.aVW && com.baidu.swan.apps.v.b.a.cC(this.ajM.Fi());
        if (BB == null || BB2 == null || BB.awm >= BB2.awm || !com.baidu.swan.apps.v.b.a.cD(this.ajM.Fi())) {
            z = false;
        }
        if (z2 || z) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            com.baidu.swan.apps.core.j.c.release();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    protected void CU() {
        this.awx.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void zQ() {
        com.baidu.swan.apps.y.f.GN().h(this.aww);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void CI() {
        if (this.awD == null) {
            this.awD = new com.baidu.swan.apps.view.b(this.aww);
        }
        this.awD.h(false, false);
    }
}
