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
        this.axb.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.Q(this.axb);
        if (com.baidu.swan.apps.core.a.wM()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.Hy().fD("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.d.dO(bundle == null ? 0 : 1);
        if (bundle == null) {
            Du();
            bk(false);
            c.u(this.ako);
        }
        DG();
        h(this.ako);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.MY();
        com.baidu.swan.apps.w.e.GF().bh(this.axb);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.IL().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.Hy().fD("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int vD() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        com.baidu.swan.apps.statistic.e.NF();
        if (bVar != null) {
            DH();
            com.baidu.swan.apps.w.e.GF().f(this.axb);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.GF().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.GF().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.FQ() != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c dV = com.baidu.swan.apps.core.h.a.BE().dV(bVar.getAppId());
            if (dV == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.ae(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, dV);
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
        f.aGG = false;
        f.c(currentTimeMillis, true);
        boolean ad = ad(F.FG(), this.ako.FG());
        if (!TextUtils.equals(F.getAppId(), this.ako.getAppId()) || com.baidu.swan.apps.console.a.d.yl()) {
            com.baidu.swan.apps.statistic.d.dO(3);
            this.axb.A(intent);
            Dt();
            g(F);
            Dr();
            com.baidu.swan.apps.w.e.release();
            h(this.ako);
            Ds();
        } else {
            HybridUbcFlow fS = f.fS("startup");
            com.baidu.swan.apps.statistic.d.dO(2);
            fS.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(currentTimeMillis));
            this.ako = com.baidu.swan.apps.v.b.b.a(this.ako, F);
            this.ako.H(currentTimeMillis);
            String DF = DF();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + DF);
            }
            if (!TextUtils.isEmpty(DF)) {
                fS.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).j("type", "2");
                com.baidu.swan.apps.scheme.actions.i.a.t("backtohome", "relaunch", DF);
                com.baidu.swan.apps.statistic.e.NF();
            } else {
                fS.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).j("type", "3");
            }
            fS.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.ako);
            c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.y.f.Hy().fD("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.ako);
        bj(ad);
        Du();
        bk(true);
        com.baidu.swan.apps.statistic.e.r(this.ako);
        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
        if (Md != null) {
            Md.Mh().Ni();
            Md.Mi().clear();
        }
        com.baidu.swan.apps.y.f.Hy().fD("frame_new_intent");
    }

    private boolean ad(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, str2)) {
            return false;
        }
        com.baidu.swan.apps.ae.d Mn = com.baidu.swan.apps.ae.b.Md().Mn();
        if (Mn.containsKey(str)) {
            return Mn.getBoolean(str, false) ? false : true;
        }
        return true;
    }

    private void bj(boolean z) {
        if (z) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.o.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.HT().update();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.axc.Au() == 1) {
            this.axb.bK(2);
            if (vO()) {
                com.baidu.swan.apps.p.a DI = com.baidu.swan.apps.p.a.DI();
                DI.a(this.axb, DI.DK(), new a.InterfaceC0155a() { // from class: com.baidu.swan.apps.o.a.a.2
                    @Override // com.baidu.swan.apps.p.a.InterfaceC0155a
                    public void zW() {
                        if (a.this.axb != null) {
                            a.this.axb.moveTaskToBack(true);
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.axc.Au());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Ar = this.axc.Ar();
        if (Ar == null || !Ar.xp()) {
            if (DE()) {
                com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                if (Md != null) {
                    Md.Mm().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.Mo());
                com.baidu.swan.apps.w.e.GF().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.axc.dS("navigateBack").B(com.baidu.swan.apps.core.d.e.ary, com.baidu.swan.apps.core.d.e.arx).Az().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d Dy() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Jr().sendMessage(4);
                        a.this.Dv();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Fe = com.baidu.swan.apps.u.a.EF().Fe();
                        com.baidu.swan.apps.u.a.EF().bq(Fe);
                        a.this.g(Fe, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                        if (Md != null) {
                            Md.Mh().clear();
                        }
                        a.this.Dv();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        g.MX().x((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        g.MX().w((Bundle) message.obj);
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
        com.baidu.swan.apps.ag.b.MZ();
        com.baidu.swan.apps.y.f.Hy().HE();
        com.baidu.swan.apps.u.a.Em().wF();
        com.baidu.swan.apps.w.e.GF().bi(this.axb);
        com.baidu.swan.apps.w.e.GF().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String DF() {
        if (this.ako != null) {
            String page = this.ako.getPage();
            String a = com.baidu.swan.apps.v.b.b.a(this.ako, com.baidu.swan.apps.w.e.GF().Gn());
            this.ako.setPage(page);
            return a;
        }
        return null;
    }

    private void bk(boolean z) {
        com.baidu.swan.apps.statistic.search.b.w(this.ako);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.aWo = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void DG() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.ako.Ci());
        }
        if (this.ako.Ci() == null || !this.ako.Ci().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.ako.a(com.baidu.swan.apps.swancore.b.dW(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.ako.Ci());
            }
        }
    }

    private void DH() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.ako == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion Ci = com.baidu.swan.apps.core.j.c.BQ().Ci();
        long hO = com.baidu.swan.apps.swancore.b.hO(this.ako.FJ());
        if (hO != 0 && Ci != null && hO > Ci.aWG) {
            com.baidu.swan.apps.core.j.c.release();
            return;
        }
        SwanCoreVersion Ci2 = this.ako.Ci();
        ExtensionCore Cj = com.baidu.swan.apps.core.j.c.BQ().Cj();
        ExtensionCore Cj2 = this.ako.Cj();
        boolean z2 = Ci != null && Ci2 != null && Ci.aWG < Ci2.aWG && com.baidu.swan.apps.v.b.a.cD(this.ako.FS());
        if (Cj == null || Cj2 == null || Cj.awR >= Cj2.awR || !com.baidu.swan.apps.v.b.a.cE(this.ako.FS())) {
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
    protected void DD() {
        this.axc.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Ax() {
        com.baidu.swan.apps.y.f.Hy().h(this.axb);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Dr() {
        if (this.axi == null) {
            this.axi = new com.baidu.swan.apps.view.b(this.axb);
        }
        this.axi.h(false, false);
    }
}
