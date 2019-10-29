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
        this.aQO.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.P(this.aQO);
        if (com.baidu.swan.apps.core.a.BK()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.Mw().gj("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.d.eK(bundle == null ? 0 : 1);
        if (bundle == null) {
            Is();
            bC(false);
            c.u(this.aEi);
        }
        IE();
        h(this.aEi);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.RS();
        com.baidu.swan.apps.w.e.LD().bj(this.aQO);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.NJ().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.Mw().gj("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int AB() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        com.baidu.swan.apps.statistic.e.Sz();
        if (bVar != null) {
            IF();
            com.baidu.swan.apps.w.e.LD().f(this.aQO);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.LD().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.LD().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.KO() != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c eE = com.baidu.swan.apps.core.h.a.GC().eE(bVar.getAppId());
            if (eE == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.am(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, eE);
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
        com.baidu.swan.apps.v.b.b L = com.baidu.swan.apps.v.b.b.L(intent);
        c.u(L);
        f.bat = false;
        f.c(currentTimeMillis, true);
        boolean al = al(L.KE(), this.aEi.KE());
        if (!TextUtils.equals(L.getAppId(), this.aEi.getAppId()) || com.baidu.swan.apps.console.a.d.Dk()) {
            com.baidu.swan.apps.statistic.d.eK(3);
            this.aQO.G(intent);
            Ir();
            g(L);
            Ip();
            com.baidu.swan.apps.w.e.release();
            h(this.aEi);
            Iq();
        } else {
            HybridUbcFlow gz = f.gz("startup");
            com.baidu.swan.apps.statistic.d.eK(2);
            gz.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).af(currentTimeMillis));
            this.aEi = com.baidu.swan.apps.v.b.b.a(this.aEi, L);
            this.aEi.aa(currentTimeMillis);
            String ID = ID();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + ID);
            }
            if (!TextUtils.isEmpty(ID)) {
                gz.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).g("type", "2");
                com.baidu.swan.apps.scheme.actions.i.a.z("backtohome", "relaunch", ID);
                com.baidu.swan.apps.statistic.e.Sz();
            } else {
                gz.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).g("type", "3");
            }
            gz.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.aEi);
            c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.y.f.Mw().gj("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.aEi);
        bB(al);
        Is();
        bC(true);
        com.baidu.swan.apps.statistic.e.r(this.aEi);
        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
        if (QZ != null) {
            QZ.Rd().Sc();
            QZ.Re().clear();
        }
        com.baidu.swan.apps.y.f.Mw().gj("frame_new_intent");
    }

    private boolean al(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, str2)) {
            return false;
        }
        com.baidu.swan.apps.ae.d Rj = com.baidu.swan.apps.ae.b.QZ().Rj();
        if (Rj.containsKey(str)) {
            return Rj.getBoolean(str, false) ? false : true;
        }
        return true;
    }

    private void bB(boolean z) {
        if (z) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.o.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.MR().update();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.aQP.Ft() == 1) {
            this.aQO.cH(2);
            if (AM()) {
                com.baidu.swan.apps.p.a IG = com.baidu.swan.apps.p.a.IG();
                IG.a(this.aQO, IG.II(), new a.InterfaceC0196a() { // from class: com.baidu.swan.apps.o.a.a.2
                    @Override // com.baidu.swan.apps.p.a.InterfaceC0196a
                    public void EV() {
                        if (a.this.aQO != null) {
                            a.this.aQO.moveTaskToBack(true);
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.aQP.Ft());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Fq = this.aQP.Fq();
        if (Fq == null || !Fq.Cn()) {
            if (IC()) {
                com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                if (QZ != null) {
                    QZ.Ri().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.Rk());
                com.baidu.swan.apps.w.e.LD().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.aQP.eC("navigateBack").H(com.baidu.swan.apps.core.d.e.aLn, com.baidu.swan.apps.core.d.e.aLm).Fy().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d Iw() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Op().sendMessage(4);
                        a.this.It();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Kc = com.baidu.swan.apps.u.a.JD().Kc();
                        com.baidu.swan.apps.u.a.JD().bI(Kc);
                        a.this.k(Kc, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                        if (QZ != null) {
                            QZ.Rd().clear();
                        }
                        a.this.It();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        g.RR().x((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        g.RR().w((Bundle) message.obj);
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
        com.baidu.swan.apps.ag.b.RT();
        com.baidu.swan.apps.y.f.Mw().MC();
        com.baidu.swan.apps.u.a.Jk().BD();
        com.baidu.swan.apps.w.e.LD().bk(this.aQO);
        com.baidu.swan.apps.w.e.LD().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String ID() {
        if (this.aEi != null) {
            String page = this.aEi.getPage();
            String a = com.baidu.swan.apps.v.b.b.a(this.aEi, com.baidu.swan.apps.w.e.LD().Ll());
            this.aEi.setPage(page);
            return a;
        }
        return null;
    }

    private void bC(boolean z) {
        com.baidu.swan.apps.statistic.search.b.w(this.aEi);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bpQ = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void IE() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.aEi.Hg());
        }
        if (this.aEi.Hg() == null || !this.aEi.Hg().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.aEi.a(com.baidu.swan.apps.swancore.b.eS(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.aEi.Hg());
            }
        }
    }

    private void IF() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.aEi == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion Hg = com.baidu.swan.apps.core.j.c.GO().Hg();
        long iu = com.baidu.swan.apps.swancore.b.iu(this.aEi.KH());
        if (iu != 0 && Hg != null && iu > Hg.bqi) {
            com.baidu.swan.apps.core.j.c.release();
            return;
        }
        SwanCoreVersion Hg2 = this.aEi.Hg();
        ExtensionCore Hh = com.baidu.swan.apps.core.j.c.GO().Hh();
        ExtensionCore Hh2 = this.aEi.Hh();
        boolean z2 = Hg != null && Hg2 != null && Hg.bqi < Hg2.bqi && com.baidu.swan.apps.v.b.a.dz(this.aEi.KQ());
        if (Hh == null || Hh2 == null || Hh.aQE >= Hh2.aQE || !com.baidu.swan.apps.v.b.a.dA(this.aEi.KQ())) {
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
    protected void IB() {
        this.aQP.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Fw() {
        com.baidu.swan.apps.y.f.Mw().h(this.aQO);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Ip() {
        if (this.aQV == null) {
            this.aQV = new com.baidu.swan.apps.view.b(this.aQO);
        }
        this.aQV.l(false, false);
    }
}
