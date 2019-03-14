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
        this.avV.setRequestedOrientation(1);
        com.baidu.swan.apps.an.b.M(this.avV);
        if (com.baidu.swan.apps.core.a.vx()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        if (DEBUG) {
            Log.i("SwanAppFrame", "SwanAppFrame#onCreate: savedInstanceState=" + bundle);
        }
        f.a(bundle != null, getIntent());
        f.c(System.currentTimeMillis(), false);
        com.baidu.swan.apps.y.f.ER().fl("frame_create");
        super.onCreate(bundle);
        com.baidu.swan.apps.statistic.b.dB(bundle == null ? 0 : 1);
        if (bundle == null) {
            BL();
            bc(false);
            c.s(this.ajt);
        }
        BX();
        h(this.ajt);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onPostCreate(Bundle bundle) {
        super.onPostCreate(bundle);
        com.baidu.swan.apps.ag.b.JM();
        com.baidu.swan.apps.w.e.Ec().bL(this.avV);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onResume() {
        super.onResume();
        f.FS().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.y.f.ER().fl("frame_start_end");
    }

    @Override // com.baidu.swan.apps.o.d
    public int ut() {
        return 0;
    }

    private void h(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar != null) {
            BY();
            com.baidu.swan.apps.w.e.Ec().f(this.avV);
            if (i(bVar)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.w.e.Ec().b(bVar, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.w.e.Ec().a(bVar, (com.baidu.swan.apps.install.b) null);
        }
    }

    private boolean i(com.baidu.swan.apps.v.b.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ac.a.a.l(bVar)) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: info is null or debug model");
                return false;
            }
            return false;
        } else if (bVar.axX != 0) {
            if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error: games category");
                return false;
            }
            return false;
        } else {
            com.baidu.swan.apps.ae.a.c eb = com.baidu.swan.apps.core.g.a.zO().eb(bVar.mAppId);
            if (eb == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (c.d.ah(bVar.mAppId, bVar.mVersion).exists()) {
                return !com.baidu.swan.apps.scheme.actions.h.f.b(bVar, eb);
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
        f.aEc = false;
        f.c(currentTimeMillis, true);
        if (!TextUtils.equals(G.mAppId, this.ajt.mAppId) || com.baidu.swan.apps.console.a.d.wP()) {
            com.baidu.swan.apps.statistic.b.dB(3);
            this.avV.B(intent);
            BK();
            g(G);
            BI();
            com.baidu.swan.apps.w.e.release();
            h(this.ajt);
            BJ();
        } else {
            HybridUbcFlow fy = f.fy("startup");
            com.baidu.swan.apps.statistic.b.dB(2);
            fy.f(new UbcFlowEvent("na_last_start").a(UbcFlowEvent.RecordType.UPDATE_RECENT).A(currentTimeMillis));
            this.ajt = G;
            this.ajt.ayb = currentTimeMillis;
            String BW = BW();
            if (DEBUG) {
                Log.d("SwanAppFrame", "onNewIntent launchPage : " + BW);
            }
            if (!TextUtils.isEmpty(BW)) {
                fy.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).i("type", "2");
                com.baidu.swan.apps.scheme.actions.h.a.t("backtohome", "relaunch", BW);
            } else {
                fy.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).i("type", "3");
            }
            fy.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
            f.k(this.ajt);
            com.baidu.swan.apps.statistic.b.c.c(new com.baidu.swan.apps.statistic.b.a("narun"));
            com.baidu.swan.apps.statistic.c.a(G, "clientready");
            com.baidu.swan.apps.y.f.ER().fl("na_page_show");
        }
        com.baidu.swan.apps.ae.b.n(this.ajt);
        BL();
        bc(true);
        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
        if (IX != null) {
            IX.Jb().JW();
            IX.Jc().clear();
        }
        com.baidu.swan.apps.y.f.ER().fl("frame_new_intent");
    }

    @Override // com.baidu.swan.apps.o.d
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (this.avW.yR() == 1) {
                this.avV.bL(2);
                if (uE()) {
                    return true;
                }
            }
            if (com.baidu.swan.apps.u.a.CL().Dw()) {
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    @Override // com.baidu.swan.apps.o.d
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.avW.yR());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.c.b yO = this.avW.yO();
        if (yO == null || !yO.vY()) {
            if (BV()) {
                com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                if (IX != null) {
                    IX.Jg().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.ae.b.Ji());
                com.baidu.swan.apps.w.e.Ec().a(new com.baidu.swan.apps.m.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            this.avW.dY("navigateBack").A(e.aqL, e.aqK).yW().commit();
        }
    }

    @Override // com.baidu.swan.apps.o.d
    @NonNull
    protected a.d BP() {
        return new a.d() { // from class: com.baidu.swan.apps.o.a.a.1
            @Override // com.baidu.swan.apps.process.messaging.client.a.d
            public boolean j(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.client.a.Gq().sendMessage(4);
                        a.this.BM();
                        a.this.reset();
                        return true;
                    case 102:
                        boolean Ds = com.baidu.swan.apps.u.a.CT().Ds();
                        com.baidu.swan.apps.u.a.CT().bg(Ds);
                        a.this.g(Ds, false);
                        return true;
                    case 103:
                        com.baidu.swan.apps.ae.b IX = com.baidu.swan.apps.ae.b.IX();
                        if (IX != null) {
                            IX.Jb().clear();
                        }
                        a.this.BM();
                        return true;
                    case 104:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_FAILED");
                        }
                        com.baidu.swan.apps.scheme.actions.h.f.JL().w((Bundle) message.obj);
                        return true;
                    case 105:
                        if (a.DEBUG) {
                            Log.e("SwanAppFrame", "MSG_TYPE_SC_GET_SUB_PACKAGE_SUCCESS");
                        }
                        com.baidu.swan.apps.scheme.actions.h.f.JL().v((Bundle) message.obj);
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
        com.baidu.swan.apps.ag.b.JN();
        com.baidu.swan.apps.y.f.ER().EU();
        com.baidu.swan.apps.u.a.CA().va();
        com.baidu.swan.apps.w.e.Ec().bM(this.avV);
        com.baidu.swan.apps.w.e.Ec().f(null);
        com.baidu.swan.apps.w.e.release();
        super.onDestroy();
    }

    private String BW() {
        if (this.ajt != null) {
            String str = this.ajt.axI;
            String a = com.baidu.swan.apps.v.b.b.a(this.ajt, com.baidu.swan.apps.w.e.Ec().DK());
            this.ajt.axI = str;
            return a;
        }
        return null;
    }

    private void bc(boolean z) {
        com.baidu.swan.apps.statistic.search.b.u(this.ajt);
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.aSL = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void BX() {
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + this.ajt.atq);
        }
        if (this.ajt.atq == null || !this.ajt.atq.isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            this.ajt.atq = com.baidu.swan.apps.swancore.b.dJ(0);
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + this.ajt.atq);
            }
        }
    }

    private void BY() {
        boolean z = true;
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (this.ajt == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion As = com.baidu.swan.apps.core.i.c.Ab().As();
        long hg = com.baidu.swan.apps.swancore.b.hg(this.ajt.axM);
        if (hg != 0 && As != null && hg > As.aTd) {
            com.baidu.swan.apps.core.i.c.release();
            return;
        }
        SwanCoreVersion swanCoreVersion = this.ajt.atq;
        ExtensionCore At = com.baidu.swan.apps.core.i.c.Ab().At();
        ExtensionCore extensionCore = this.ajt.atr;
        boolean z2 = As != null && swanCoreVersion != null && As.aTd < swanCoreVersion.aTd && com.baidu.swan.apps.v.b.a.cC(this.ajt.axZ);
        if (At == null || extensionCore == null || At.avL >= extensionCore.avL || !com.baidu.swan.apps.v.b.a.cD(this.ajt.axZ)) {
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
    protected void BU() {
        this.avW.a(this);
    }

    @Override // com.baidu.swan.apps.core.c.e.a
    public void yU() {
        com.baidu.swan.apps.y.f.ER().h(this.avV);
    }

    @Override // com.baidu.swan.apps.o.d
    protected void BI() {
        if (this.awc == null) {
            this.awc = new com.baidu.swan.apps.view.b(this.avV);
        }
        this.awc.h(false, false);
    }
}
