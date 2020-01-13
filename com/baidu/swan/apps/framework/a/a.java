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
/* loaded from: classes10.dex */
public class a extends c implements e.a {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void j(boolean z, boolean z2) {
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent");
        }
        com.baidu.swan.apps.console.c.d("SwanApp", "SwanAppActivity onNewIntent");
        String QK = QK();
        JSONObject parseString = s.parseString(En().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + QK);
        }
        String hE = hE(QK);
        if (z) {
            com.baidu.swan.apps.statistic.c.acE();
            f.Wy().cY(z2);
            HybridUbcFlow jA = com.baidu.swan.apps.performance.f.jA("startup");
            b.a En = En();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + hE);
                }
                com.baidu.swan.apps.statistic.e.ga(2);
                if (!TextUtils.isEmpty(hE)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "message", hE);
                    } else {
                        com.baidu.swan.apps.statistic.c.a(hE, En);
                        jA.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).k("type", "2");
                        com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "relaunch", hE);
                    }
                } else if (d.acY()) {
                    com.baidu.swan.apps.scheme.actions.k.a.E("backtohome", "relaunch", com.baidu.swan.apps.y.f.UC().Um());
                } else {
                    f.Wy().cY(false);
                    jA.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).k("type", "3");
                    com.baidu.swan.apps.statistic.c.n(En);
                    com.baidu.swan.apps.statistic.c.c(En);
                }
                if (Qt().hasResumed()) {
                    jA.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.an.a.acr().ln("na_page_show");
                }
                com.baidu.swan.apps.an.a.acr().ln("frame_new_intent");
            } else {
                jA.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            QJ();
            Qw();
            cw(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.bev.setRequestedOrientation(1);
        com.baidu.swan.apps.as.c.U(this.bev);
        if (com.baidu.swan.apps.core.a.FE()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.an.a.acr().clear();
        com.baidu.swan.apps.an.a.acr().ln("frame_create");
        f.Wy().cY(true);
        f.Wy().WA();
        QL();
        QH();
        V8Engine.setCrashKeyValue("app_title", En().OL());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void Qd() {
        com.baidu.swan.apps.ak.b.abA();
        com.baidu.swan.apps.y.f.UC().cc(this.bev);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        com.baidu.swan.apps.performance.f.XF().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.an.a.acr().ln("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ak.b.abB();
        f.Wy().Wz();
        com.baidu.swan.apps.w.a.RI().Fs();
        com.baidu.swan.apps.y.f.UC().cd(this.bev);
    }

    @Override // com.baidu.swan.apps.runtime.l, com.baidu.swan.apps.runtime.h
    public int Ed() {
        return 0;
    }

    private void QH() {
        com.baidu.swan.apps.statistic.c.acC();
        if (YT()) {
            QM();
            b.a En = En();
            if (g(En)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.y.f.UC().b(En, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.y.f.UC().a(En, (com.baidu.swan.apps.t.b) null);
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
            SwanAppConfigData aav = com.baidu.swan.apps.runtime.d.aam().aaj().aav();
            if (aav == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (e.d.aB(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !g.b(bVar, aav);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String hE(String str) {
        b.a En = En();
        if (TextUtils.isEmpty(str) && En != null && hD(En.getAppId())) {
            return com.baidu.swan.apps.y.f.UC().Um();
        }
        return str;
    }

    private boolean QI() {
        com.baidu.swan.apps.runtime.d aam = com.baidu.swan.apps.runtime.d.aam();
        if (aam.YT()) {
            b.a En = aam.aaj().En();
            String Tt = En.Tt();
            String Tu = En.Tu();
            if (TextUtils.isEmpty(En.Tt()) || TextUtils.equals(Tt, Tu)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aaF = aaj().aaF();
            if (aaF.containsKey(En.Tt())) {
                return aaF.b(Tt, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void QJ() {
        if (QI()) {
            m.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.WL().WN();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4 && this.brm.Ma() == 1) {
            com.baidu.swan.apps.q.b QP = new com.baidu.swan.apps.q.b().QP();
            if (QP.isShow()) {
                com.baidu.swan.apps.q.c.QU().a(this.bev, QP.getImageUrl(), QP.QT(), Lj());
                return true;
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a Lj() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.2
            @Override // com.baidu.swan.apps.q.c.a
            public void LD() {
                if (a.this.bev != null) {
                    a.this.bev.moveTaskToBack(true);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.d("SwanApp", "onBackPressed back stack count:" + this.brm.Ma());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.b LX = this.brm.LX();
        if (LX == null || !LX.Gt()) {
            if (QE()) {
                com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                if (aap != null) {
                    aap.aaE().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onBack");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aar());
                com.baidu.swan.apps.y.f.UC().a(new com.baidu.swan.apps.n.a.c(hashMap));
                com.baidu.swan.apps.console.c.d("SwanAppFrame", "onBack");
                return;
            }
            com.baidu.swan.apps.as.d.b(El(), this.bev);
            this.brm.gM("navigateBack").Y(com.baidu.swan.apps.core.d.e.bjW, com.baidu.swan.apps.core.d.e.bjV).Mf().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b QA() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.3
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean m(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.Yv().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.Qx();
                        com.baidu.swan.apps.runtime.d.aam().aak();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.w.a.Sc().getNightModeSwitcherState();
                        com.baidu.swan.apps.w.a.Sc().bM(nightModeSwitcherState);
                        if (a.this.bev != null) {
                            a.this.bev.g(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                        if (aap != null) {
                            aap.aaz().clear();
                            com.baidu.swan.apps.network.c.a.WL().WR();
                        }
                        a.this.Qx();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aam().aak();
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

    private String QK() {
        return com.baidu.swan.apps.x.b.b.a(En(), com.baidu.swan.apps.y.f.UC().Ui());
    }

    private void cw(boolean z) {
        com.baidu.swan.apps.statistic.search.b.o(En());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.bRu = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void QL() {
        b.a En = En();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + En.OA());
        }
        if (En.OA() == null || !En.OA().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            En.b(com.baidu.swan.apps.swancore.b.gi(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + En.OA());
            }
        }
    }

    private void QM() {
        boolean z = true;
        b.a En = En();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (En == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion OA = com.baidu.swan.apps.core.k.d.Og().OA();
        long ma = com.baidu.swan.apps.swancore.b.ma(En.Tx());
        if (ma != 0 && OA != null && ma > OA.swanCoreVersion) {
            com.baidu.swan.apps.core.k.d.release();
            return;
        }
        SwanCoreVersion OA2 = En.OA();
        ExtensionCore OB = com.baidu.swan.apps.core.k.d.Og().OB();
        ExtensionCore OB2 = En.OB();
        boolean z2 = OA != null && OA2 != null && OA.swanCoreVersion < OA2.swanCoreVersion && com.baidu.swan.apps.x.b.a.eP(En.TG());
        if (OB == null || OB2 == null || OB.extensionCoreVersionCode >= OB2.extensionCoreVersionCode || !com.baidu.swan.apps.x.b.a.eQ(En.TG())) {
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
    protected void QD() {
        this.brm.a(this);
    }

    @Override // com.baidu.swan.apps.core.d.e.a
    public void Md() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void QF() {
        super.QF();
        if (com.baidu.swan.apps.core.k.d.Og().Ov() != null) {
            com.baidu.swan.apps.core.k.d.Og().Ov().G(this.bev);
        }
    }
}
