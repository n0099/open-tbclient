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
        String aza = aza();
        JSONObject parseString = v.parseString(ajv().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + aza);
        }
        String oP = oP(aza);
        if (z) {
            e.aPb();
            f.aGs().gq(z2);
            HybridUbcFlow rd = i.rd("startup");
            b.a ajv = ajv();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + oP);
                }
                g.setStartType(2);
                if (!TextUtils.isEmpty(oP)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "message", oP);
                    } else {
                        e.a(oP, ajv);
                        com.baidu.swan.apps.core.f.fd(true);
                        rd.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).q("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.pl("2");
                        boolean ta = com.baidu.swan.apps.scheme.actions.forbidden.a.aNv().ta(oP);
                        com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", ta ? "message" : "relaunch", oP);
                        if (com.baidu.swan.apps.scheme.actions.k.a.tg(oP) && !ta) {
                            com.baidu.swan.apps.scheme.actions.k.a.th("reLaunch");
                        }
                    }
                } else if (d.aPy()) {
                    com.baidu.swan.apps.scheme.actions.k.a.aa("backtohome", "relaunch", com.baidu.swan.apps.v.f.aDH().aDq());
                } else {
                    f.aGs().gq(false);
                    rd.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).q("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.pl("3");
                    e.n(ajv);
                    e.d(ajv);
                }
                if (ayJ().hasResumed()) {
                    rd.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.aj.a.aOJ().tr("na_page_show");
                }
                com.baidu.swan.apps.aj.a.aOJ().tr("frame_new_intent");
                com.baidu.swan.apps.runtime.e aMd = com.baidu.swan.apps.runtime.d.aMh().aMd();
                aMd.aMx().aNU();
                aMd.aMy().clear();
                if (com.baidu.swan.apps.core.i.a.cYM) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aMu = aMd.aMu();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.auQ().auR();
                    }
                    com.baidu.swan.apps.core.i.a.auQ().b(aMu);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aPi();
            } else {
                rd.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            ayZ();
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
        if (com.baidu.swan.apps.core.e.akM()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.aj.a.aOJ().clear();
        com.baidu.swan.apps.aj.a.aOJ().tr("frame_create");
        f.aGs().gq(true);
        f.aGs().aGv();
        azb();
        ayX();
        V8Engine.setCrashKeyValue("app_title", ajv().awy());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void ays() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ag.b.aNF();
                com.baidu.swan.apps.v.f.aDH().cV(a.this.cOo);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aHA().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.aj.a.aOJ().tr("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ag.b.aNG();
        f.aGs().aGt();
        com.baidu.swan.apps.t.a.aAu().als();
        com.baidu.swan.apps.v.f.aDH().cW(this.cOo);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int ajl() {
        return 0;
    }

    private void ayX() {
        e.aOZ();
        if (aJx()) {
            azc();
            b.a ajv = ajv();
            if (g(ajv)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.aDH().b(ajv, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.aDH().a(ajv, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aMu = com.baidu.swan.apps.runtime.d.aMh().aMd().aMu();
            if (aMu == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0466d.bS(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aMu);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String oP(String str) {
        b.a ajv = ajv();
        if (TextUtils.isEmpty(str) && ajv != null && oO(ajv.getAppId())) {
            return com.baidu.swan.apps.v.f.aDH().aDq();
        }
        return str;
    }

    private boolean ayY() {
        com.baidu.swan.apps.runtime.d aMh = com.baidu.swan.apps.runtime.d.aMh();
        if (aMh.aJx()) {
            b.a ajv = aMh.aMd().ajv();
            String aCw = ajv.aCw();
            String aCx = ajv.aCx();
            if (TextUtils.isEmpty(ajv.aCw()) || TextUtils.equals(aCw, aCx)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aMD = aMd().aMD();
            if (aMD.containsKey(ajv.aCw())) {
                return aMD.b(aCw, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void ayZ() {
        if (ayY()) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aGG().aGI();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.azd().aze()) {
                com.baidu.swan.apps.p.a.azd().a(this.cOo, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
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
            } else if (this.deW != null && this.deW.asX() == 1) {
                com.baidu.swan.apps.p.b azf = new com.baidu.swan.apps.p.b().azf();
                if (azf.isShow()) {
                    com.baidu.swan.apps.p.c.azk().a(this.cOo, azf.getImageUrl(), azf.azj(), arT());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a arT() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void asw() {
                if (a.this.cOo != null) {
                    a.this.cOo.moveTaskToBack(true);
                    ap.aSb().lQ(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.deW.asX());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c asU = this.deW.asU();
        if (asU == null || !asU.amm()) {
            if (ayT()) {
                com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
                if (aMl != null) {
                    aMl.aMC().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aMn());
                com.baidu.swan.apps.v.f.aDH().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.aDQ().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ao.f.b(ajt(), this.cOo);
            this.deW.nv("navigateBack").ai(com.baidu.swan.apps.core.d.f.cVa, com.baidu.swan.apps.core.d.f.cUZ).atb().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b ayP() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aIY().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.ayM();
                        com.baidu.swan.apps.runtime.d.aMh().aMe();
                        return true;
                    case 102:
                        boolean alE = com.baidu.swan.apps.t.a.aAO().alE();
                        com.baidu.swan.apps.t.a.aAO().eM(alE);
                        if (a.this.cOo != null) {
                            a.this.cOo.k(alE, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
                        if (aMl != null) {
                            aMl.aMx().clear();
                            com.baidu.swan.apps.network.c.a.aGG().aGL();
                        }
                        a.this.ayM();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aMh().aMe();
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
                        com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aFL()));
                        return true;
                    case 129:
                        int aQU = com.baidu.swan.apps.ao.b.aQQ().aQU();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aQU);
                        if (a.this.cOo == null || !a.this.cOo.isBackground() || aQU == -1 || a.this.cOo.getTaskId() == aQU) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aMh().aMe();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String aza() {
        return com.baidu.swan.apps.u.c.b.a(ajv(), com.baidu.swan.apps.v.f.aDH().aDm());
    }

    private void fH(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(ajv());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dOs = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void azb() {
        b.a ajv = ajv();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + ajv.avW());
        }
        if (ajv.avW() == null || !ajv.avW().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            ajv.b(com.baidu.swan.apps.swancore.b.lf(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + ajv.avW());
            }
        }
    }

    private void azc() {
        boolean z = false;
        b.a ajv = ajv();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (ajv == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion avW = com.baidu.swan.apps.core.turbo.d.avB().avW();
        long uo = com.baidu.swan.apps.swancore.b.uo(ajv.aCA());
        if (uo != 0 && avW != null && uo > avW.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion avW2 = ajv.avW();
        ExtensionCore avX = com.baidu.swan.apps.core.turbo.d.avB().avX();
        ExtensionCore avX2 = ajv.avX();
        boolean z2 = avW != null && avW2 != null && avW.swanCoreVersion < avW2.swanCoreVersion && com.baidu.swan.apps.u.c.a.jp(ajv.aCJ());
        if (avX != null && avX2 != null && avX.extensionCoreVersionCode < avX2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.jq(ajv.aCJ())) {
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
    protected void ayS() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ayU() {
        super.ayU();
        if (com.baidu.swan.apps.core.turbo.d.avB().avS() != null) {
            com.baidu.swan.apps.core.turbo.d.avB().avS().attachActivity(this.cOo);
        }
    }
}
