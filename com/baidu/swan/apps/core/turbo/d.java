package com.baidu.swan.apps.core.turbo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.av;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.al;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.slave.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.r.d;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.h;
import com.baidu.swan.games.utils.so.f;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public final class d implements h {
    private static volatile d che;
    private com.baidu.swan.apps.core.container.a.b chf;
    private com.baidu.swan.apps.core.g.a chh;
    private boolean chi;
    private com.baidu.swan.apps.adaptation.b.c chj;
    private boolean chk;
    private boolean chl;
    private boolean chm;
    private HashMap<String, e> chn;
    private String chq;
    private av chv;
    private i chw;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int chr = 10150;
    public static boolean chs = false;
    private static PreloadState cht = PreloadState.UNKNOWN;
    private static boolean chu = false;
    private List<a> chg = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cho = new LinkedList<>();
    private final Object chp = new Object();
    private volatile boolean chx = false;

    /* loaded from: classes7.dex */
    public interface a {
        void onReady();
    }

    public static PreloadState adu() {
        return cht;
    }

    public static int adv() {
        return adu().statsCode(chu);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.chn = new HashMap<>();
        this.chv = new com.baidu.swan.apps.adaptation.b.a.b();
        this.chw = com.baidu.swan.apps.adaptation.b.a.c.UY().UZ().UW();
    }

    public static d adw() {
        if (che == null) {
            synchronized (d.class) {
                if (che == null) {
                    che = new d();
                }
            }
        }
        return che;
    }

    public av adx() {
        return this.chv;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "release");
            if (che != null) {
                cht = PreloadState.UNKNOWN;
                che.chl = true;
                chs = false;
                if (che.chf != null) {
                    che.chw.b(che.chf);
                }
                com.baidu.swan.apps.api.module.l.d.Ws();
                com.baidu.swan.apps.swancore.a.a.avc();
                ady();
                com.baidu.swan.apps.v.i.b(che);
                che = null;
                if (a.b.ade()) {
                    com.baidu.swan.apps.core.slave.a.ada().clear();
                }
                com.baidu.swan.apps.core.h.b.acH().reset();
                chu = z;
                adw().adz();
            }
        }
    }

    private static void ady() {
        if (che.chn != null) {
            for (e eVar : ((HashMap) che.chn.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (che.chh != null) {
            if (che.chh instanceof com.baidu.swan.apps.core.g.e) {
                che.chh.destroy();
            }
            che.chh = null;
        }
        if (che.chj != null) {
            che.chj = null;
        }
    }

    private void adz() {
        p(null);
    }

    public void p(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (adC()) {
            com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        chs = true;
        com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        kp("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.hw(0);
            extensionCore = com.baidu.swan.apps.extcore.b.fA(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.ahG().es(intent.getIntExtra("bundle_key_preload_switch", chr));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            kp("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        b.adX();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.aq.i.awu();
            }
        }, "prepare ab description");
        if (adN()) {
            f aHi = com.baidu.swan.games.utils.so.d.aHi();
            if (!aHi.isSuccess() && !aHi.aHr()) {
                kp("event_preload_error");
                return;
            }
        }
        a(new a() { // from class: com.baidu.swan.apps.core.turbo.d.2
            @Override // com.baidu.swan.apps.core.turbo.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).hc(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                al.p(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        d.this.adW();
                    }
                });
                com.baidu.swan.apps.process.messaging.client.a.apG().sendMessage(14);
            }
        });
        com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void kp(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cht.statsCode(chu));
        com.baidu.swan.apps.runtime.d.arr().g(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.adQ();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.adQ());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.anX().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.al.a.atW().pf("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.turbo.d.3
            @Override // com.baidu.swan.apps.core.turbo.d.a
            public void onReady() {
                al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.chl) {
                            com.baidu.swan.apps.performance.i.mX("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.al.a.atW().pf("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.bJ("preload", "startup");
                            if (d.this.chh != null && d.this.chj != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.chh, d.this.chj, bVar, fVar);
                                d.this.chj = null;
                            }
                            com.baidu.swan.apps.performance.i.a(bVar, false);
                        }
                    }
                });
            }
        });
    }

    public void adA() {
        al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.runtime.e arw;
                boolean equals;
                if (d.this.chj != null && (arw = com.baidu.swan.apps.runtime.e.arw()) != null) {
                    if (a.C0347a.acG()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.akr(), arw.Se(), arw.arE());
                        SwanAppConfigData arE = arw.arE();
                        equals = "main".equals(arE != null ? arE.op(a2) : null);
                    }
                    if (equals && arw.arE() != null) {
                        com.baidu.swan.apps.core.h.b.acH().a(d.this.chh, d.this.chj, arw.Se(), arw.arE(), null);
                    }
                }
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.chg.contains(aVar)) {
            this.chg.add(aVar);
        }
        boolean adC = adC();
        com.baidu.swan.apps.performance.i.anX().bH("preload", adC ? "1" : "0");
        com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareRuntime preload = " + adC);
        if (adC) {
            adF();
            return;
        }
        cht = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_start"));
        adP();
        if (a.b.ade()) {
            String adJ = adJ();
            if (!TextUtils.isEmpty(adJ)) {
                com.baidu.swan.apps.core.slave.a.ada().a(adJ, (a.InterfaceC0352a) null);
            }
        }
        final boolean adN = adN();
        if (adN) {
            f aHi = com.baidu.swan.games.utils.so.d.aHi();
            if (!aHi.isSuccess() && aHi.aHr()) {
                adN = false;
            }
        }
        com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "useV8Master:" + adN);
        if (adN) {
            dW(true);
        }
        if (this.chf == null) {
            this.chf = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.5
                @Override // com.baidu.swan.apps.core.container.a.b
                public void SC() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.chl);
                            }
                            if (d.this.chl) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.adP();
                            d.this.adS();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.dW(adN);
                                d.this.adO();
                                return;
                            }
                            PreloadState unused = d.cht = PreloadState.LOAD_FAILED;
                            d.this.adB();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.chw.a(this.chf);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adB() {
        synchronized (this.chp) {
            this.chi = false;
            this.chh = null;
        }
        this.chk = false;
        this.chj = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.hM(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", adL());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion hw = com.baidu.swan.apps.swancore.b.hw(0);
            jSONObject.put("swan app core", hw == null ? "null" : Long.valueOf(hw.swanCoreVersion));
            SwanCoreVersion hw2 = com.baidu.swan.apps.swancore.b.hw(1);
            jSONObject.put("swan game core", hw2 == null ? "null" : Long.valueOf(hw2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).pi(com.baidu.swan.apps.runtime.e.arv() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.arv().getAppKey()).pj(jSONObject.toString()).aeU();
    }

    public boolean adC() {
        boolean z;
        synchronized (this.chp) {
            z = this.chi && this.chk;
        }
        return z;
    }

    public boolean adD() {
        boolean z;
        synchronized (this.chp) {
            z = this.chi;
        }
        return z;
    }

    public boolean adE() {
        boolean z;
        synchronized (this.chp) {
            z = this.chk;
        }
        return z;
    }

    public void adF() {
        if (!this.chg.isEmpty() && adC()) {
            cht = PreloadState.LOADED;
            kp("event_preload_finish");
            com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.chg) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.chg.clear();
        }
    }

    private String K(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.c.u(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String adG() {
        return !TextUtils.isEmpty(adH()) ? adH() + "runtime/index.js" : "";
    }

    public String adH() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String adI() {
        String str;
        adP();
        if (adL()) {
            str = adG();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.c.To()) {
            K(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.XY()) {
            com.baidu.swan.apps.console.debugger.a.d.XV();
            com.baidu.swan.apps.console.debugger.a.d.XR().ji("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.Yb();
        } else {
            com.baidu.swan.apps.core.c.jr(str);
        }
        return aj.toFileUriString(str);
    }

    @Nullable
    public String adJ() {
        adP();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.c.To()) {
            K(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.XY()) {
            return com.baidu.swan.apps.console.debugger.a.e.Yc();
        } else {
            com.baidu.swan.apps.core.c.jr(str);
        }
        return aj.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adK() {
        if (!this.cho.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cho.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bSl);
                }
                a(next);
            }
            this.cho.clear();
        }
    }

    public boolean adL() {
        return this.chh instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a adM() {
        return this.chh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dW(boolean z) {
        synchronized (this.chp) {
            if (!this.chi && this.chh == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.chh = this.chv.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.chh.loadUrl(adI());
                this.chh.a(new com.baidu.swan.apps.core.e() { // from class: com.baidu.swan.apps.core.turbo.d.6
                    @Override // com.baidu.swan.apps.core.e
                    public void fH(String str) {
                        com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.chp) {
                            d.this.chi = true;
                            d.this.adK();
                            d.this.adF();
                        }
                    }
                });
            }
        }
    }

    private boolean adN() {
        if (com.baidu.swan.apps.console.debugger.a.e.XY() || com.baidu.swan.apps.t.a.ahv().To()) {
            return false;
        }
        return b.SO() && new File(adG()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adO() {
        if (!this.chk && this.chj == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.chj = a(getContext(), new com.baidu.swan.apps.core.e() { // from class: com.baidu.swan.apps.core.turbo.d.7
                @Override // com.baidu.swan.apps.core.e
                public void fH(String str) {
                    com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.chk = true;
                    d.this.adF();
                }
            });
            adU();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.e eVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bi = this.chv.bi(context);
            com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            final String adJ = adJ();
            if (a.b.ade()) {
                com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareSlave loadData");
                com.baidu.swan.apps.core.slave.a.ada().a(adJ, new a.InterfaceC0352a() { // from class: com.baidu.swan.apps.core.turbo.d.8
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0352a
                    public void kl(final String str) {
                        al.p(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareSlave loadData start");
                                bi.loadDataWithBaseURL(adJ, str, "text/html", "utf-8", adJ);
                                com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareSlave loadData end");
                            }
                        });
                    }
                });
            } else {
                com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "prepareSlave loadUrl");
                bi.loadUrl(adJ);
            }
            bi.a(eVar);
            return bi;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.c.bI(context);
            throw e;
        }
    }

    public void a(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion == null || !swanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("setSwanCoreVersion failed.")));
                Log.e("SwanAppCoreRuntime", "setSwanCoreVersion swanCoreVersion is invalid: " + swanCoreVersion);
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.mSwanCoreVersion);
        }
        this.mSwanCoreVersion = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.mSwanCoreVersion);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adP() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.hw(0));
        }
    }

    public SwanCoreVersion adQ() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore adR() {
        return this.mExtensionCore;
    }

    public void a(ExtensionCore extensionCore) {
        if (extensionCore == null || !extensionCore.isAvailable()) {
            if (DEBUG) {
                StringBuilder append = new StringBuilder().append("setExtensionCore extensionCore is invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                Log.w("SwanAppCoreRuntime", append.append(obj).toString());
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.mExtensionCore);
        }
        this.mExtensionCore = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.mExtensionCore);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adS() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.aW("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.fA(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.adR();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(e eVar) {
        this.chn.put(eVar.UR(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(e eVar) {
        String UR = eVar.UR();
        this.chn.remove(UR);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", UR);
            a(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public e kq(String str) {
        if (this.chn.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.chn.get(str);
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.chp) {
            if (!this.chi) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bSl)));
                }
                this.cho.add(aVar);
            } else if (this.chh != null) {
                com.baidu.swan.apps.event.a.a(this.chh.VC(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        e eVar = this.chn.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.UP(), aVar);
    }

    @Nullable
    public String adT() {
        adU();
        return this.chq;
    }

    private void adU() {
        if (TextUtils.isEmpty(this.chq)) {
            this.chq = this.chj != null ? this.chj.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.chq);
            }
        }
    }

    public void dX(boolean z) {
        if (z && this.chh != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.chp) {
                this.chi = true;
                adK();
                adF();
            }
        } else if (!z && this.chj != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.mX("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.chk = true;
            adF();
        }
    }

    public void dY(boolean z) {
        this.chm = z;
    }

    public boolean adV() {
        return this.chm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adW() {
        boolean z = true;
        if (this.chx) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.chx = true;
        com.baidu.swan.apps.runtime.d arr = com.baidu.swan.apps.runtime.d.arr();
        z = (arr == null || !arr.apU()) ? false : false;
        boolean Td = com.baidu.swan.apps.t.a.ahm().Td();
        if (!z && Td) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bN(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + Td);
        }
    }

    /* loaded from: classes7.dex */
    public static class b {
        private static boolean chI = com.baidu.swan.apps.t.a.ahm().SO();
        private static boolean chJ = chI;

        public static void q(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                chI = intent.getBooleanExtra("bundle_key_v8_ab", chI);
            }
        }

        public static void adX() {
            chJ = chI;
        }

        public static String adY() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void kr(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean SO() {
            if (d.DEBUG) {
                String adY = adY();
                char c = 65535;
                switch (adY.hashCode()) {
                    case -1406842887:
                        if (adY.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (adY.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (adY.equals("V8")) {
                            c = 0;
                            break;
                        }
                        break;
                }
                switch (c) {
                    case 0:
                        return true;
                    case 1:
                        return false;
                }
            }
            return chJ;
        }

        public static boolean adZ() {
            String adY = adY();
            if (adY.equals("V8")) {
                return true;
            }
            if (adY.equals("AB")) {
                return com.baidu.swan.apps.t.a.ahm().SO();
            }
            return false;
        }

        public static String fs(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }
}
