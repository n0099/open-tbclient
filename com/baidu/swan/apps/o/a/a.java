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
        this.axz.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.Q(this.axz);
        if (com.baidu.swan.apps.core.a.wQ()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.HC().fF("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.d.dP(bundle == null ? 0 : 1);
        if (bundle == null) {
            Dy();
            bk(false);
            c.u(this.akM);
        }
        DK();
        h(this.akM);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.Nc();
        com.baidu.swan.apps.w.e.GJ().bh(this.axz);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.IP().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.HC().fF("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int vH() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        com.baidu.swan.apps.statistic.e.NJ();
        if (bVar != null) {
            DL();
            com.baidu.swan.apps.w.e.GJ().f(this.axz);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.GJ().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.GJ().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.FU() != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c dX = com.baidu.swan.apps.core.h.a.BI().dX(bVar.getAppId());
            if (dX == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.ae(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, dX);
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
        f.aHe = false;
        f.c(currentTimeMillis, true);
        boolean ad = ad(F.FK(), this.akM.FK());
        if (!TextUtils.equals(F.getAppId(), this.akM.getAppId()) || com.baidu.swan.apps.console.a.d.yp()) {
            com.baidu.swan.apps.statistic.d.dP(3);
            this.axz.A(intent);
            Dx();
            g(F);
            Dv();
            com.baidu.swan.apps.w.e.release();
            h(this.akM);
            Dw();
        } else {
            HybridUbcFlow fU = f.fU("startup");
            com.baidu.swan.apps.statistic.d.dP(2);
            fU.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).M(currentTimeMillis));
            this.akM = com.baidu.swan.apps.v.b.b.a(this.akM, F);
            this.akM.H(currentTimeMillis);
            String DJ = DJ();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + DJ);
            }
            if (!TextUtils.isEmpty(DJ)) {
                fU.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).j("type", "2");
                com.baidu.swan.apps.scheme.actions.i.a.t("backtohome", "relaunch", DJ);
                com.baidu.swan.apps.statistic.e.NJ();
            } else {
                fU.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).j("type", "3");
            }
            fU.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.akM);
            c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.y.f.HC().fF("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.akM);
        bj(ad);
        Dy();
        bk(true);
        com.baidu.swan.apps.statistic.e.r(this.akM);
        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
        if (Mh != null) {
            Mh.Ml().Nm();
            Mh.Mm().clear();
        }
        com.baidu.swan.apps.y.f.HC().fF("frame_new_intent");
    }

    private boolean ad(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, str2)) {
            return false;
        }
        com.baidu.swan.apps.ae.d Mr = com.baidu.swan.apps.ae.b.Mh().Mr();
        if (Mr.containsKey(str)) {
            return Mr.getBoolean(str, false) ? false : true;
        }
        return true;
    }

    private void bj(boolean z) {
        if (z) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.o.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.HX().update();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.axA.Ay() == 1) {
            this.axz.bL(2);
            if (vS()) {
                com.baidu.swan.apps.p.a DM = com.baidu.swan.apps.p.a.DM();
                DM.a(this.axz, DM.DO(), new a.InterfaceC0164a() { // from class: com.baidu.swan.apps.o.a.a.2
                    @Override // com.baidu.swan.apps.p.a.InterfaceC0164a
                    public void Aa() {
                        if (a.this.axz != null) {
                            a.this.axz.moveTaskToBack(true);
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.axA.Ay());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Av = this.axA.Av();
        if (Av == null || !Av.xt()) {
            if (DI()) {
                com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                if (Mh != null) {
                    Mh.Mq().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.Ms());
                com.baidu.swan.apps.w.e.GJ().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.axA.dU("navigateBack").B(com.baidu.swan.apps.core.d.e.arW, com.baidu.swan.apps.core.d.e.arV).AD().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d DC() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Jv().sendMessage(4);
                        a.this.Dz();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Fi = com.baidu.swan.apps.u.a.EJ().Fi();
                        com.baidu.swan.apps.u.a.EJ().bq(Fi);
                        a.this.g(Fi, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                        if (Mh != null) {
                            Mh.Ml().clear();
                        }
                        a.this.Dz();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        g.Nb().x((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        g.Nb().w((Bundle) message.obj);
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
        com.baidu.swan.apps.ag.b.Nd();
        com.baidu.swan.apps.y.f.HC().HI();
        com.baidu.swan.apps.u.a.Eq().wJ();
        com.baidu.swan.apps.w.e.GJ().bi(this.axz);
        com.baidu.swan.apps.w.e.GJ().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String DJ() {
        if (this.akM != null) {
            String page = this.akM.getPage();
            String a = com.baidu.swan.apps.v.b.b.a(this.akM, com.baidu.swan.apps.w.e.GJ().Gr());
            this.akM.setPage(page);
            return a;
        }
        return null;
    }

    private void bk(boolean z) {
        com.baidu.swan.apps.statistic.search.b.w(this.akM);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.aWM = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void DK() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.akM.Cm());
        }
        if (this.akM.Cm() == null || !this.akM.Cm().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.akM.a(com.baidu.swan.apps.swancore.b.dX(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.akM.Cm());
            }
        }
    }

    private void DL() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.akM == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion Cm = com.baidu.swan.apps.core.j.c.BU().Cm();
        long hQ = com.baidu.swan.apps.swancore.b.hQ(this.akM.FN());
        if (hQ != 0 && Cm != null && hQ > Cm.aXe) {
            com.baidu.swan.apps.core.j.c.release();
            return;
        }
        SwanCoreVersion Cm2 = this.akM.Cm();
        ExtensionCore Cn = com.baidu.swan.apps.core.j.c.BU().Cn();
        ExtensionCore Cn2 = this.akM.Cn();
        boolean z2 = Cm != null && Cm2 != null && Cm.aXe < Cm2.aXe && com.baidu.swan.apps.v.b.a.cE(this.akM.FW());
        if (Cn == null || Cn2 == null || Cn.axp >= Cn2.axp || !com.baidu.swan.apps.v.b.a.cF(this.akM.FW())) {
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
    protected void DH() {
        this.axA.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void AB() {
        com.baidu.swan.apps.y.f.HC().h(this.axz);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Dv() {
        if (this.axG == null) {
            this.axG = new com.baidu.swan.apps.view.b(this.axz);
        }
        this.axG.h(false, false);
    }
}
