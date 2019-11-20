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
        this.aQw.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.P(this.aQw);
        if (com.baidu.swan.apps.core.a.BL()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.Mx().gj("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.d.eK(bundle == null ? 0 : 1);
        if (bundle == null) {
            It();
            bC(false);
            c.u(this.aDQ);
        }
        IF();
        h(this.aDQ);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.RU();
        com.baidu.swan.apps.w.e.LE().bj(this.aQw);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.NK().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.Mx().gj("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int AC() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        com.baidu.swan.apps.statistic.e.SB();
        if (bVar != null) {
            IG();
            com.baidu.swan.apps.w.e.LE().f(this.aQw);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.LE().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.LE().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.KP() != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c eE = com.baidu.swan.apps.core.h.a.GD().eE(bVar.getAppId());
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
        f.bab = false;
        f.c(currentTimeMillis, true);
        boolean al = al(L.KF(), this.aDQ.KF());
        if (!TextUtils.equals(L.getAppId(), this.aDQ.getAppId()) || com.baidu.swan.apps.console.a.d.Dl()) {
            com.baidu.swan.apps.statistic.d.eK(3);
            this.aQw.G(intent);
            Is();
            g(L);
            Iq();
            com.baidu.swan.apps.w.e.release();
            h(this.aDQ);
            Ir();
        } else {
            HybridUbcFlow gz = f.gz("startup");
            com.baidu.swan.apps.statistic.d.eK(2);
            gz.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).ae(currentTimeMillis));
            this.aDQ = com.baidu.swan.apps.v.b.b.a(this.aDQ, L);
            this.aDQ.Z(currentTimeMillis);
            String IE = IE();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + IE);
            }
            if (!TextUtils.isEmpty(IE)) {
                gz.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).g("type", "2");
                com.baidu.swan.apps.scheme.actions.i.a.z("backtohome", "relaunch", IE);
                com.baidu.swan.apps.statistic.e.SB();
            } else {
                gz.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).g("type", "3");
            }
            gz.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.aDQ);
            c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.y.f.Mx().gj("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.aDQ);
        bB(al);
        It();
        bC(true);
        com.baidu.swan.apps.statistic.e.r(this.aDQ);
        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
        if (Ra != null) {
            Ra.Rf().Se();
            Ra.Rg().clear();
        }
        com.baidu.swan.apps.y.f.Mx().gj("frame_new_intent");
    }

    private boolean al(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.equals(str, str2)) {
            return false;
        }
        com.baidu.swan.apps.ae.d Rl = com.baidu.swan.apps.ae.b.Ra().Rl();
        if (Rl.containsKey(str)) {
            return Rl.getBoolean(str, false) ? false : true;
        }
        return true;
    }

    private void bB(boolean z) {
        if (z) {
            j.b(new Runnable() { // from class: com.baidu.swan.apps.o.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.MS().update();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.aQx.Fu() == 1) {
            this.aQw.cH(2);
            if (AN()) {
                com.baidu.swan.apps.p.a IH = com.baidu.swan.apps.p.a.IH();
                IH.a(this.aQw, IH.IJ(), new a.InterfaceC0196a() { // from class: com.baidu.swan.apps.o.a.a.2
                    @Override // com.baidu.swan.apps.p.a.InterfaceC0196a
                    public void EW() {
                        if (a.this.aQw != null) {
                            a.this.aQw.moveTaskToBack(true);
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
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.aQx.Fu());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b Fr = this.aQx.Fr();
        if (Fr == null || !Fr.Co()) {
            if (ID()) {
                com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                if (Ra != null) {
                    Ra.Rk().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.Rm());
                com.baidu.swan.apps.w.e.LE().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.aQx.eC("navigateBack").F(com.baidu.swan.apps.core.d.e.aKV, com.baidu.swan.apps.core.d.e.aKU).Fz().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d Ix() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Oq().sendMessage(4);
                        a.this.Iu();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Kd = com.baidu.swan.apps.u.a.JE().Kd();
                        com.baidu.swan.apps.u.a.JE().bI(Kd);
                        a.this.k(Kd, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                        if (Ra != null) {
                            Ra.Rf().clear();
                        }
                        a.this.Iu();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        g.RT().x((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        g.RT().w((Bundle) message.obj);
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
        com.baidu.swan.apps.ag.b.RV();
        com.baidu.swan.apps.y.f.Mx().MD();
        com.baidu.swan.apps.u.a.Jl().BE();
        com.baidu.swan.apps.w.e.LE().bk(this.aQw);
        com.baidu.swan.apps.w.e.LE().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String IE() {
        if (this.aDQ != null) {
            String page = this.aDQ.getPage();
            String a = com.baidu.swan.apps.v.b.b.a(this.aDQ, com.baidu.swan.apps.w.e.LE().Lm());
            this.aDQ.setPage(page);
            return a;
        }
        return null;
    }

    private void bC(boolean z) {
        com.baidu.swan.apps.statistic.search.b.w(this.aDQ);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bpy = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void IF() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.aDQ.Hh());
        }
        if (this.aDQ.Hh() == null || !this.aDQ.Hh().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.aDQ.a(com.baidu.swan.apps.swancore.b.eS(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.aDQ.Hh());
            }
        }
    }

    private void IG() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.aDQ == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion Hh = com.baidu.swan.apps.core.j.c.GP().Hh();
        long iu = com.baidu.swan.apps.swancore.b.iu(this.aDQ.KI());
        if (iu != 0 && Hh != null && iu > Hh.bpQ) {
            com.baidu.swan.apps.core.j.c.release();
            return;
        }
        SwanCoreVersion Hh2 = this.aDQ.Hh();
        ExtensionCore Hi = com.baidu.swan.apps.core.j.c.GP().Hi();
        ExtensionCore Hi2 = this.aDQ.Hi();
        boolean z2 = Hh != null && Hh2 != null && Hh.bpQ < Hh2.bpQ && com.baidu.swan.apps.v.b.a.dz(this.aDQ.KR());
        if (Hi == null || Hi2 == null || Hi.aQm >= Hi2.aQm || !com.baidu.swan.apps.v.b.a.dA(this.aDQ.KR())) {
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
    protected void IC() {
        this.aQx.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Fx() {
        com.baidu.swan.apps.y.f.Mx().h(this.aQw);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void Iq() {
        if (this.aQD == null) {
            this.aQD = new com.baidu.swan.apps.view.b(this.aQw);
        }
        this.aQD.l(false, false);
    }
}
