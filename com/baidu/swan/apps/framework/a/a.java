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
/* loaded from: classes8.dex */
public class a extends c {
    private static final boolean DEBUG = b.DEBUG;

    public a(SwanAppActivity swanAppActivity, String str) {
        super(swanAppActivity, str);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void p(boolean z, boolean z2) {
        com.baidu.swan.apps.console.c.i("SwanApp", "onUpdate isLaunch=" + z + ";isRelaunch=" + z2);
        String avg = avg();
        JSONObject parseString = v.parseString(afB().getString("_naExtParams"));
        if (DEBUG) {
            Log.d("SwanAppFrame", "onNewIntent launchPage : " + avg);
        }
        String nC = nC(avg);
        if (z) {
            e.aLh();
            f.aCy().gm(z2);
            HybridUbcFlow pS = i.pS("startup");
            b.a afB = afB();
            if (z2) {
                if (DEBUG) {
                    Log.d("SwanAppFrame", "onRelaunch launchPage : " + nC);
                }
                g.setStartType(2);
                if (!TextUtils.isEmpty(nC)) {
                    if (parseString.optString("_naScene", "").equals("message")) {
                        com.baidu.swan.apps.scheme.actions.k.a.Z("backtohome", "message", nC);
                    } else {
                        e.a(nC, afB);
                        com.baidu.swan.apps.core.f.eZ(true);
                        pS.a(HybridUbcFlow.SubmitStrategy.RELAUNCH).q("type", "2");
                        com.baidu.swan.apps.inlinewidget.f.b.b.nY("2");
                        boolean rO = com.baidu.swan.apps.scheme.actions.forbidden.a.aJB().rO(nC);
                        com.baidu.swan.apps.scheme.actions.k.a.Z("backtohome", rO ? "message" : "relaunch", nC);
                        if (com.baidu.swan.apps.scheme.actions.k.a.rU(nC) && !rO) {
                            com.baidu.swan.apps.scheme.actions.k.a.rV("reLaunch");
                        }
                    }
                } else if (d.aLE()) {
                    com.baidu.swan.apps.scheme.actions.k.a.Z("backtohome", "relaunch", com.baidu.swan.apps.v.f.azN().azw());
                } else {
                    f.aCy().gm(false);
                    pS.a(HybridUbcFlow.SubmitStrategy.NA_ONLY).q("type", "3");
                    com.baidu.swan.apps.inlinewidget.f.b.b.nY("3");
                    e.n(afB);
                    e.d(afB);
                }
                if (auP().hasResumed()) {
                    pS.f(new UbcFlowEvent("na_page_show").a(UbcFlowEvent.RecordType.UPDATE_RECENT));
                    com.baidu.swan.apps.aj.a.aKP().sf("na_page_show");
                }
                com.baidu.swan.apps.aj.a.aKP().sf("frame_new_intent");
                com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
                aIj.aID().aKa();
                aIj.aIE().clear();
                if (com.baidu.swan.apps.core.i.a.cUa) {
                    if (DEBUG) {
                        Log.d("SwanAppFrame", "hot start: hit prelink");
                        Log.d("SwanPrelink", "hot start: hit prelink");
                    }
                    SwanAppConfigData aIA = aIj.aIA();
                    if (DEBUG) {
                        com.baidu.swan.apps.core.i.a.aqV().aqW();
                    }
                    com.baidu.swan.apps.core.i.a.aqV().b(aIA);
                } else if (DEBUG) {
                    Log.d("SwanPrelink", "hot start: miss prelink");
                }
                h.aLo();
            } else {
                pS.a(HybridUbcFlow.SubmitStrategy.HYBRID);
            }
            avf();
            fD(true);
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onRelease() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onCreate() {
        this.cJC.setRequestedOrientation(1);
        com.baidu.swan.apps.ao.e.P(this.cJC);
        if (com.baidu.swan.apps.core.e.agS()) {
            WebView.setWebContentsDebuggingEnabled(true);
        }
        com.baidu.swan.apps.aj.a.aKP().clear();
        com.baidu.swan.apps.aj.a.aKP().sf("frame_create");
        f.aCy().gm(true);
        f.aCy().aCB();
        avh();
        avd();
        V8Engine.setCrashKeyValue("app_title", afB().asE());
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void auy() {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ag.b.aJL();
                com.baidu.swan.apps.v.f.azN().cU(a.this.cJC);
            }
        }, "registerScreenshotEvent", 2);
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStart() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onResume() {
        i.aDG().f(new UbcFlowEvent("frame_start_end"));
        com.baidu.swan.apps.aj.a.aKP().sf("frame_start_end");
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onPause() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onStop() {
    }

    @Override // com.baidu.swan.apps.framework.c
    protected void onDestroy() {
        com.baidu.swan.apps.ag.b.aJM();
        f.aCy().aCz();
        com.baidu.swan.apps.t.a.awA().ahy();
        com.baidu.swan.apps.v.f.azN().cV(this.cJC);
    }

    @Override // com.baidu.swan.apps.runtime.m, com.baidu.swan.apps.runtime.h
    public int afr() {
        return 0;
    }

    private void avd() {
        e.aLf();
        if (aFD()) {
            avi();
            b.a afB = afB();
            if (g(afB)) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "start load aiapps sync ");
                }
                com.baidu.swan.apps.v.f.azN().b(afB, null);
                return;
            }
            if (DEBUG) {
                Log.i("SwanAppFrame", "start load aiapps async ");
            }
            com.baidu.swan.apps.v.f.azN().a(afB, (com.baidu.swan.apps.r.b) null);
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
            SwanAppConfigData aIA = com.baidu.swan.apps.runtime.d.aIn().aIj().aIA();
            if (aIA == null) {
                if (DEBUG) {
                    Log.i("SwanAppFrame", "checkSyncLegal error : none configData");
                    return false;
                }
                return false;
            } else if (d.C0449d.bR(bVar.getAppId(), bVar.getVersion()).exists()) {
                return !com.baidu.swan.apps.scheme.actions.k.g.b(bVar, aIA);
            } else if (DEBUG) {
                Log.i("SwanAppFrame", "checkSyncLegal error : unzip foldr is not exist");
                return false;
            } else {
                return false;
            }
        }
    }

    private String nC(String str) {
        b.a afB = afB();
        if (TextUtils.isEmpty(str) && afB != null && nB(afB.getAppId())) {
            return com.baidu.swan.apps.v.f.azN().azw();
        }
        return str;
    }

    private boolean ave() {
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        if (aIn.aFD()) {
            b.a afB = aIn.aIj().afB();
            String ayC = afB.ayC();
            String ayD = afB.ayD();
            if (TextUtils.isEmpty(afB.ayC()) || TextUtils.equals(ayC, ayD)) {
                return false;
            }
            com.baidu.swan.apps.runtime.g aIJ = aIj().aIJ();
            if (aIJ.containsKey(afB.ayC())) {
                return aIJ.b(ayC, (Boolean) false).booleanValue() ? false : true;
            }
            return true;
        }
        return false;
    }

    private void avf() {
        if (ave()) {
            p.b(new Runnable() { // from class: com.baidu.swan.apps.framework.a.a.2
                @Override // java.lang.Runnable
                public void run() {
                    com.baidu.swan.apps.network.c.a.aCM().aCO();
                }
            }, "saveUpdateList");
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (i == 4) {
            if (com.baidu.swan.apps.p.a.avj().avk()) {
                com.baidu.swan.apps.p.a.avj().a(this.cJC, new com.baidu.swan.apps.core.f.b<Boolean>() { // from class: com.baidu.swan.apps.framework.a.a.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.core.f.b
                    /* renamed from: f */
                    public void N(Boolean bool) {
                        if (a.this.cJC != null && bool.booleanValue()) {
                            a.this.cJC.onBackPressed();
                        }
                    }
                });
                return true;
            } else if (this.daf != null && this.daf.apb() == 1) {
                com.baidu.swan.apps.p.b avl = new com.baidu.swan.apps.p.b().avl();
                if (avl.isShow()) {
                    com.baidu.swan.apps.p.c.avq().a(this.cJC, avl.getImageUrl(), avl.avp(), anY());
                    return true;
                }
            }
        }
        return super.onKeyDown(i, keyEvent);
    }

    private c.a anY() {
        return new c.a() { // from class: com.baidu.swan.apps.framework.a.a.4
            @Override // com.baidu.swan.apps.p.c.a
            public void aoA() {
                if (a.this.cJC != null) {
                    a.this.cJC.moveTaskToBack(true);
                    ap.aOh().kk(1);
                }
            }
        };
    }

    @Override // com.baidu.swan.apps.framework.c
    public void onBackPressed() {
        com.baidu.swan.apps.console.c.i("SwanApp", "onBackPressed back stack count:" + this.daf.apb());
        com.baidu.swan.apps.statistic.a.f fVar = new com.baidu.swan.apps.statistic.a.f();
        fVar.mValue = "back";
        a(fVar);
        com.baidu.swan.apps.core.d.c aoY = this.daf.aoY();
        if (aoY == null || !aoY.ais()) {
            if (auZ()) {
                com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
                if (aIr != null) {
                    aIr.aII().release();
                }
                HashMap hashMap = new HashMap();
                hashMap.put("lcType", "onClose");
                hashMap.put("appId", com.baidu.swan.apps.runtime.e.aIt());
                com.baidu.swan.apps.v.f.azN().b(new com.baidu.swan.apps.event.a.c(hashMap));
                com.baidu.swan.apps.console.c.i("SwanAppFrame", "onBack");
                com.baidu.swan.apps.v.g.azW().setForeground(false);
                return;
            }
            com.baidu.swan.apps.ao.f.b(afz(), this.cJC);
            this.daf.mk("navigateBack").ai(com.baidu.swan.apps.core.d.f.cQo, com.baidu.swan.apps.core.d.f.cQn).apf().commit();
        }
    }

    @Override // com.baidu.swan.apps.framework.c
    @NonNull
    protected a.b auV() {
        return new a.b() { // from class: com.baidu.swan.apps.framework.a.a.5
            @Override // com.baidu.swan.apps.process.messaging.client.a.b
            public boolean l(Message message) {
                switch (message.what) {
                    case 100:
                        com.baidu.swan.apps.process.messaging.a.aFe().a(new com.baidu.swan.apps.process.messaging.c(4));
                        a.this.auS();
                        com.baidu.swan.apps.runtime.d.aIn().aIk();
                        return true;
                    case 102:
                        boolean ahK = com.baidu.swan.apps.t.a.awU().ahK();
                        com.baidu.swan.apps.t.a.awU().eI(ahK);
                        if (a.this.cJC != null) {
                            a.this.cJC.k(ahK, false);
                            return true;
                        }
                        return true;
                    case 103:
                        com.baidu.swan.apps.runtime.e aIr = com.baidu.swan.apps.runtime.e.aIr();
                        if (aIr != null) {
                            aIr.aID().clear();
                            com.baidu.swan.apps.network.c.a.aCM().aCR();
                        }
                        a.this.auS();
                        return true;
                    case 106:
                        com.baidu.swan.apps.runtime.d.aIn().aIk();
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
                        com.baidu.swan.apps.menu.fontsize.a.g(Integer.valueOf(com.baidu.swan.apps.menu.fontsize.b.aBR()));
                        return true;
                    case 129:
                        int aNa = com.baidu.swan.apps.ao.b.aMW().aNa();
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: client receive msg topTaskId = " + aNa);
                        if (a.this.cJC == null || !a.this.cJC.isBackground() || aNa == -1 || a.this.cJC.getTaskId() == aNa) {
                            return true;
                        }
                        com.baidu.swan.apps.console.c.i("SwanAppFrame", "resetCore: purgeSwanApp");
                        com.baidu.swan.apps.runtime.d.aIn().aIk();
                        return true;
                    default:
                        return false;
                }
            }
        };
    }

    private String avg() {
        return com.baidu.swan.apps.u.c.b.a(afB(), com.baidu.swan.apps.v.f.azN().azs());
    }

    private void fD(boolean z) {
        com.baidu.swan.apps.statistic.search.b.p(afB());
        if (z) {
            SearchFlowEvent searchFlowEvent = new SearchFlowEvent("dom_first_paint");
            searchFlowEvent.dJG = SearchFlowEvent.EventType.END;
            com.baidu.swan.apps.statistic.search.b.a(searchFlowEvent);
        }
    }

    private void avh() {
        b.a afB = afB();
        if (DEBUG) {
            Log.d("SwanAppFrame", "updateInvalidSwanCore cur swanCore: " + afB.asb());
        }
        if (afB.asb() == null || !afB.asb().isAvailable()) {
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore start.");
            }
            afB.b(com.baidu.swan.apps.swancore.b.jz(0));
            if (DEBUG) {
                Log.d("SwanAppFrame", "updateInvalidSwanCore end. new swan core: " + afB.asb());
            }
        }
    }

    private void avi() {
        boolean z = false;
        b.a afB = afB();
        if (DEBUG) {
            Log.d("SwanAppFrame", "tryReleaseInvalidCoreRuntime");
        }
        if (afB == null) {
            if (DEBUG) {
                Log.e("SwanAppFrame", "tryReleaseInvalidCoreRuntime: mLaunchInfo == null");
                return;
            }
            return;
        }
        SwanCoreVersion asb = com.baidu.swan.apps.core.turbo.d.arG().asb();
        long td = com.baidu.swan.apps.swancore.b.td(afB.ayG());
        if (td != 0 && asb != null && td > asb.swanCoreVersion) {
            com.baidu.swan.apps.core.turbo.d.release(true);
            return;
        }
        SwanCoreVersion asb2 = afB.asb();
        ExtensionCore asc = com.baidu.swan.apps.core.turbo.d.arG().asc();
        ExtensionCore asc2 = afB.asc();
        boolean z2 = asb != null && asb2 != null && asb.swanCoreVersion < asb2.swanCoreVersion && com.baidu.swan.apps.u.c.a.hJ(afB.ayP());
        if (asc != null && asc2 != null && asc.extensionCoreVersionCode < asc2.extensionCoreVersionCode && com.baidu.swan.apps.u.c.a.hK(afB.ayP())) {
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
    protected void auY() {
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.apps.framework.c
    public void ava() {
        super.ava();
        if (com.baidu.swan.apps.core.turbo.d.arG().arX() != null) {
            com.baidu.swan.apps.core.turbo.d.arG().arX().attachActivity(this.cJC);
        }
    }
}
