package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ap.ap;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.ap.v;
import com.baidu.swan.apps.b;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.framework.c;
import com.baidu.swan.apps.p.c;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.process.messaging.client.a;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.e;
import com.baidu.swan.apps.statistic.g;
import com.baidu.swan.apps.statistic.h;
import com.baidu.swan.apps.statistic.search.SearchFlowEvent;
import com.baidu.swan.apps.storage.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.u.c.b;
import com.baidu.swan.apps.y.f;
import java.util.HashMap;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String aob = aob();
        JSONObject parseString = v.parseString(YI().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + aob);
        }
        String na = na(aob);
        if (z) {
            e.aDh();
            f.avr().eX(z2);
            HybridUbcFlow pq = i.pq("startup");
            b.a YI = YI();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + na);
                }
                g.jF(2);
                if (!TextUtils.isEmpty(na)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", "message", na);
                    } else {
                        e.a(na, YI);
                        com.baidu.swan.apps.core.f.dK(true);
                        pq.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).r("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.nw("2");
                        boolean rh = com.baidu.swan.apps.scheme.actions.forbidden.a.aBB().rh(na);
                        com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", rh ? "message" : "relaunch", na);
                        if (com.baidu.swan.apps.scheme.actions.k.a.rn(na) && !rh) {
                            com.baidu.swan.apps.scheme.actions.k.a.ro("reLaunch");
                        }
                    }
                } else if (d.aDF()) {
                    com.baidu.swan.apps.scheme.actions.k.a.M("backtohome", "relaunch", com.baidu.swan.apps.v.f.asJ().ass());
                } else {
                    f.avr().eX(false);
                    pq.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).r("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.nw("3");
                    e.n(YI);
                    e.d(YI);
                }
                if (anK().hasResumed()) {
                    pq.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.ak.a.aCP().ry("na_page_show");
                }
                com.baidu.swan.apps.ak.a.aCP().ry("frame_new_intent");
                com.baidu.swan.apps.runtime.e aAj = com.baidu.swan.apps.runtime.d.aAn().aAj();
                aAj.aAD().aCa();
                aAj.aAE().clear();
                if (com.baidu.swan.apps.core.i.a.coc) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aAA = aAj.aAA();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.ajS().ajT();
                    }
                    com.baidu.swan.apps.core.i.a.ajS().b(aAA);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aDp();
            } else {
                pq.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            aoa();
            eo(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cdy.setRequestedOrientation(1);
        com.baidu.swan.apps.ap.e.O(this.cdy);
        if (com.baidu.swan.apps.core.e.ZX()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.ak.a.aCP().clear();
        com.baidu.swan.apps.ak.a.aCP().ry("frame_create");
        f.avr().eX(true);
        f.avr().avu();
        aoc();
        anY();
        V8Engine.setCrashKeyValue("app_title", YI().aly());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void ant() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ah.b.aBL();
                com.baidu.swan.apps.v.f.asJ().cb(a.this.cdy);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.awB().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.ak.a.aCP().ry("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ah.b.aBM();
        f.avr().avs();
        com.baidu.swan.apps.t.a.apw().aaD();
        com.baidu.swan.apps.v.f.asJ().cc(this.cdy);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int Yy() {
        return 0;
    }

    private void anY() {
        e.aDf();
        if (ayA()) {
            aod();
            b.a YI = YI();
            if (g(YI)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.asJ().b(YI, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.asJ().a(YI, (com.baidu.swan.apps.r.b) null);
        }
    }

    private boolean g(com.baidu.swan.apps.u.c.b bVar) {
        if (bVar == null || com.baidu.swan.apps.ad.a.a.j(bVar)) {
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
            SwanAppConfigData aAA = com.baidu.swan.apps.runtime.d.aAn().aAj().aAA();
            if (aAA == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0421d.bB(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aAA);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String na(String str) {
        b.a YI = YI();
        if (TextUtils.isEmpty(str) && YI != null && mZ(YI.getAppId())) {
            return com.baidu.swan.apps.v.f.asJ().ass();
        }
        return str;
    }

    private boolean anZ() {
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        if (aAn.ayA()) {
            b.a YI = aAn.aAj().YI();
            String arx = YI.arx();
            String ary = YI.ary();
            if (TextUtils.isEmpty(YI.arx()) || TextUtils.equals(arx, ary)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aAJ = aAj().aAJ();
            if (aAJ.containsKey(YI.arx())) {
                return aAJ.b(arx, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void aoa() {
        if (anZ()) {
            p.postOnComputation(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.avF().avH();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.aoe().aof()) {
                com.baidu.swan.apps.p.a.aoe().a(this.cdy, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: d */
                    public void L(Boolean bool) {
                        if (a.this.cdy != null && bool.booleanValue()) {
                            a.this.cdy.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.cus != null && this.cus.ahZ() == 1) {
                com.baidu.swan.apps.p.b aog = new com.baidu.swan.apps.p.b().aog();
                if (aog.isShow()) {
                    com.baidu.swan.apps.p.c.aol().a(this.cdy, aog.getImageUrl(), aog.aok(), ahb());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a ahb() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void ahy() {
                if (a.this.cdy != null) {
                    a.this.cdy.moveTaskToBack(true);
                    ap.aGh().kz(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.cus.ahZ());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c ahW = this.cus.ahW();
        if (ahW == null || !ahW.abv()) {
            if (anU()) {
                com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
                if (aAr != null) {
                    aAr.aAI().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aAt());
                com.baidu.swan.apps.v.f.asJ().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.asS().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ap.f.b(YG(), this.cdy);
            this.cus.lH("navigateBack").al(com.baidu.swan.apps.core.d.f.ckn, com.baidu.swan.apps.core.d.f.ckm).aid().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b anQ() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.ayb().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.anN();
                        com.baidu.swan.apps.runtime.d.aAn().aAk();
                        return true;
                    case 102:
                        boolean nightModeSwitcherState = com.baidu.swan.apps.t.a.apQ().getNightModeSwitcherState();
                        com.baidu.swan.apps.t.a.apQ().dt(nightModeSwitcherState);
                        if (a.this.cdy != null) {
                            a.this.cdy.k(nightModeSwitcherState, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aAr = com.baidu.swan.apps.runtime.e.aAr();
                        if (aAr != null) {
                            aAr.aAD().clear();
                            com.baidu.swan.apps.network.c.a.avF().avK();
                        }
                        a.this.anN();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aAn().aAk();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.m(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        com.baidu.swan.apps.ap.b.O(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        com.baidu.swan.apps.ap.b.P(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case 127:
                        com.baidu.swan.apps.menu.fontsize.a.c(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.auL()));
                        return true;
                    case 129:
                        int aFa = com.baidu.swan.apps.ap.b.aEW().aFa();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aFa);
                        if (a.this.cdy == null || !a.this.cdy.isBackground() || aFa == -1 || a.this.cdy.getTaskId() == aFa) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aAn().aAk();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String aob() {
        return com.baidu.swan.apps.u.c.b.a(YI(), com.baidu.swan.apps.v.f.asJ().aso());
    }

    private void eo(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(YI());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.cZS = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void aoc() {
        b.a YI = YI();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + YI.akX());
        }
        if (YI.akX() == null || !YI.akX().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            YI.b(com.baidu.swan.apps.swancore.b.jO(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + YI.akX());
            }
        }
    }

    private void aod() {
        boolean z = false;
        b.a YI = YI();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (YI == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion akX = com.baidu.swan.apps.core.turbo.d.akC().akX();
        long sw = com.baidu.swan.apps.swancore.b.sw(YI.arB());
        if (sw != 0 && akX != null && sw > akX.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion akX2 = YI.akX();
        ExtensionCore akY = com.baidu.swan.apps.core.turbo.d.akC().akY();
        ExtensionCore akY2 = YI.akY();
        boolean z2 = akX != null && akX2 != null && akX.swanCoreVersion < akX2.swanCoreVersion && com.baidu.swan.apps.u.c.a.ii(YI.arK());
        if (akY != null && akY2 != null && akY.extensionCoreVersionCode < akY2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.ij(YI.arK())) {
            z = true;
        }
        if (z2 || z) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "预加载的swan-core或Extension版本过低时释放并重新加载");
            }
            com.baidu.swan.apps.core.turbo.d.release(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void anT() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void anV() {
        super.anV();
        if (com.baidu.swan.apps.core.turbo.d.akC().akT() != null) {
            com.baidu.swan.apps.core.turbo.d.akC().akT().attachActivity(this.cdy);
        }
    }
}
