package com.baidu.swan.apps.framework.a;

import android.os.Message;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.WebView;
import androidx.annotation.NonNull;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.ao.ap;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.apps.ao.v;
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
/* loaded from: classes9.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String ayZ = ayZ();
        JSONObject parseString = v.parseString(aju().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + ayZ);
        }
        String oP = oP(ayZ);
        if (z) {
            e.aPa();
            f.aGr().gq(z2);
            HybridUbcFlow rd = i.rd("startup");
            b.a aju = aju();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + oP);
                }
                g.setStartType(2);
                if (!TextUtils.isEmpty(oP)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "message", oP);
                    } else {
                        e.a(oP, aju);
                        com.baidu.swan.apps.core.f.fd(true);
                        rd.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).q("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.pl("2");
                        boolean ta = com.baidu.swan.apps.scheme.actions.forbidden.a.aNu().ta(oP);
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", ta ? "message" : "relaunch", oP);
                        if (com.baidu.swan.apps.scheme.actions.k.a.tg(oP) && !ta) {
                            com.baidu.swan.apps.scheme.actions.k.a.th("reLaunch");
                        }
                    }
                } else if (d.aPx()) {
                    com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "relaunch", com.baidu.swan.apps.v.f.aDG().aDp());
                } else {
                    f.aGr().gq(false);
                    rd.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).q("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.pl("3");
                    e.n(aju);
                    e.d(aju);
                }
                if (ayI().hasResumed()) {
                    rd.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.aj.a.aOI().tr("na_page_show");
                }
                com.baidu.swan.apps.aj.a.aOI().tr("frame_new_intent");
                com.baidu.swan.apps.runtime.e aMc = com.baidu.swan.apps.runtime.d.aMg().aMc();
                aMc.aMw().aNT();
                aMc.aMx().clear();
                if (com.baidu.swan.apps.core.i.a.cYM) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aMt = aMc.aMt();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.auP().auQ();
                    }
                    com.baidu.swan.apps.core.i.a.auP().b(aMt);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aPh();
            } else {
                rd.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            ayY();
            fH(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cOo.setRequestedOrientation(1);
        com.baidu.swan.apps.ao.e.P(this.cOo);
        if (com.baidu.swan.apps.core.e.akL()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.aj.a.aOI().clear();
        com.baidu.swan.apps.aj.a.aOI().tr("frame_create");
        f.aGr().gq(true);
        f.aGr().aGu();
        aza();
        ayW();
        V8Engine.setCrashKeyValue("app_title", aju().awx());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void ayr() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ag.b.aNE();
                com.baidu.swan.apps.v.f.aDG().cV(a.this.cOo);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aHz().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.aj.a.aOI().tr("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ag.b.aNF();
        f.aGr().aGs();
        com.baidu.swan.apps.t.a.aAt().alr();
        com.baidu.swan.apps.v.f.aDG().cW(this.cOo);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ajk() {
        return 0;
    }

    private void ayW() {
        e.aOY();
        if (aJw()) {
            azb();
            b.a aju = aju();
            if (g(aju)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.aDG().b(aju, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.aDG().a(aju, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aMt = com.baidu.swan.apps.runtime.d.aMg().aMc().aMt();
            if (aMt == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0466d.bS(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aMt);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String oP(String str) {
        b.a aju = aju();
        if (TextUtils.isEmpty(str) && aju != null && oO(aju.getAppId())) {
            return com.baidu.swan.apps.v.f.aDG().aDp();
        }
        return str;
    }

    private boolean ayX() {
        com.baidu.swan.apps.runtime.d aMg = com.baidu.swan.apps.runtime.d.aMg();
        if (aMg.aJw()) {
            b.a aju = aMg.aMc().aju();
            String aCv = aju.aCv();
            String aCw = aju.aCw();
            if (TextUtils.isEmpty(aju.aCv()) || TextUtils.equals(aCv, aCw)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aMC = aMc().aMC();
            if (aMC.containsKey(aju.aCv())) {
                return aMC.b(aCv, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void ayY() {
        if (ayX()) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aGF().aGH();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.azc().azd()) {
                com.baidu.swan.apps.p.a.azc().a(this.cOo, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: f */
                    public void N(Boolean bool) {
                        if (a.this.cOo != null && bool.booleanValue()) {
                            a.this.cOo.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.deW != null && this.deW.asW() == 1) {
                com.baidu.swan.apps.p.b aze = new com.baidu.swan.apps.p.b().aze();
                if (aze.isShow()) {
                    com.baidu.swan.apps.p.c.azj().a(this.cOo, aze.getImageUrl(), aze.azi(), arS());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a arS() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void asv() {
                if (a.this.cOo != null) {
                    a.this.cOo.moveTaskToBack(true);
                    ap.aSa().lQ(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.deW.asW());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c asT = this.deW.asT();
        if (asT == null || !asT.aml()) {
            if (ayS()) {
                com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
                if (aMk != null) {
                    aMk.aMB().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aMm());
                com.baidu.swan.apps.v.f.aDG().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.aDP().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ao.f.b(ajs(), this.cOo);
            this.deW.nv("navigateBack").ai(com.baidu.swan.apps.core.d.f.cVa, com.baidu.swan.apps.core.d.f.cUZ).ata().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ayO() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aIX().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.ayL();
                        com.baidu.swan.apps.runtime.d.aMg().aMd();
                        return true;
                    case 102:
                        boolean alD = com.baidu.swan.apps.t.a.aAN().alD();
                        com.baidu.swan.apps.t.a.aAN().eM(alD);
                        if (a.this.cOo != null) {
                            a.this.cOo.k(alD, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aMk = com.baidu.swan.apps.runtime.e.aMk();
                        if (aMk != null) {
                            aMk.aMw().clear();
                            com.baidu.swan.apps.network.c.a.aGF().aGK();
                        }
                        a.this.ayL();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aMg().aMd();
                        return true;
                    case 107:
                        com.baidu.swan.apps.core.pms.h.m(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY /* 123 */:
                        com.baidu.swan.apps.ao.b.O(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_QUERY_MEMBER /* 124 */:
                        com.baidu.swan.apps.ao.b.P(message);
                        return true;
                    case Constants.METHOD_IM_FRIEND_GROUP_ASSIGN /* 125 */:
                        com.baidu.swan.apps.process.messaging.a.a.n(message);
                        return true;
                    case 127:
                        com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aFK()));
                        return true;
                    case 129:
                        int aQT = com.baidu.swan.apps.ao.b.aQP().aQT();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aQT);
                        if (a.this.cOo == null || !a.this.cOo.isBackground() || aQT == -1 || a.this.cOo.getTaskId() == aQT) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aMg().aMd();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String ayZ() {
        return com.baidu.swan.apps.u.c.b.a(aju(), com.baidu.swan.apps.v.f.aDG().aDl());
    }

    private void fH(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(aju());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dOs = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void aza() {
        b.a aju = aju();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + aju.avV());
        }
        if (aju.avV() == null || !aju.avV().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            aju.b(com.baidu.swan.apps.swancore.b.lf(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + aju.avV());
            }
        }
    }

    private void azb() {
        boolean z = false;
        b.a aju = aju();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (aju == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion avV = com.baidu.swan.apps.core.turbo.d.avA().avV();
        long uo = com.baidu.swan.apps.swancore.b.uo(aju.aCz());
        if (uo != 0 && avV != null && uo > avV.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion avV2 = aju.avV();
        ExtensionCore avW = com.baidu.swan.apps.core.turbo.d.avA().avW();
        ExtensionCore avW2 = aju.avW();
        boolean z2 = avV != null && avV2 != null && avV.swanCoreVersion < avV2.swanCoreVersion && com.baidu.swan.apps.u.c.a.jp(aju.aCI());
        if (avW != null && avW2 != null && avW.extensionCoreVersionCode < avW2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.jq(aju.aCI())) {
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
    protected void ayR() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ayT() {
        super.ayT();
        if (com.baidu.swan.apps.core.turbo.d.avA().avR() != null) {
            com.baidu.swan.apps.core.turbo.d.avA().avR().attachActivity(this.cOo);
        }
    }
}
