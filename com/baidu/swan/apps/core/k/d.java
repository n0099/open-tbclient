package com.baidu.swan.apps.core.k;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.am;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.as.ag;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.as.g;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.apps.core.slave.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.statistic.a;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.t.e;
import com.baidu.swan.apps.y.h;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d implements h {
    private static volatile d bol;
    private i boA;
    private com.baidu.swan.apps.core.container.a.b bom;
    private com.baidu.swan.apps.core.g.a boo;
    private boolean bop;
    private com.baidu.swan.apps.adaptation.b.c boq;
    private boolean bor;
    private boolean bos;
    private HashMap<String, e> bot;
    private String bow;
    private am boz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int box = 10150;
    public static boolean boy = false;
    private List<a> bon = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bou = new LinkedList<>();
    private final Object bov = new Object();

    /* loaded from: classes10.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bot = new HashMap<>();
        this.boz = new com.baidu.swan.apps.adaptation.b.a.b();
        this.boA = com.baidu.swan.apps.adaptation.b.a.c.GH().GI().GF();
    }

    public static d Og() {
        if (bol == null) {
            synchronized (d.class) {
                if (bol == null) {
                    bol = new d();
                }
            }
        }
        return bol;
    }

    public am Oh() {
        return this.boz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static synchronized void release() {
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (bol != null) {
                bol.mIsReleased = true;
                boy = false;
                if (bol.bom != null) {
                    bol.boA.b(bol.bom);
                }
                com.baidu.swan.apps.api.module.l.d.HO();
                com.baidu.swan.apps.swancore.b.a.adh();
                Oi();
                com.baidu.swan.apps.y.i.b(bol);
                bol = null;
                if (a.b.NS()) {
                    com.baidu.swan.apps.core.slave.a.NO().clear();
                }
                Og().Oj();
            }
        }
    }

    private static void Oi() {
        if (bol.bot != null) {
            for (e eVar : ((HashMap) bol.bot.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bol.boo != null) {
            if (bol.boo instanceof com.baidu.swan.apps.core.g.e) {
                bol.boo.destroy();
            }
            bol.boo = null;
        }
        if (bol.boq != null) {
            bol.boq = null;
        }
    }

    private void Oj() {
        E(null);
    }

    public void E(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Ol()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        boy = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.gi(0);
            extensionCore = com.baidu.swan.apps.extcore.b.ey(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.w.a.Sd().dC(intent.getIntExtra("bundle_key_preload_switch", box));
        }
        if (swanCoreVersion == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("preloadCoreRuntime version is invalid.")));
                return;
            }
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null && DEBUG) {
            Log.w("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        b.OG();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.aeo();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.q(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).fR(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.YF().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.OA();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.OA());
        }
        e(bVar);
        f(bVar);
        f.XF().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.acr().ln("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.mIsReleased) {
                            f.jA("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.acr().ln("na_pre_load_ok");
                            f.aU("preload", "startup");
                            if (d.this.boo != null && d.this.boq != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.boo, d.this.boq, bVar, fVar);
                                d.this.boq = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bon.contains(aVar)) {
            this.bon.add(aVar);
        }
        boolean Ol = Ol();
        f.XF().aS("preload", Ol ? "1" : "0");
        if (Ol) {
            Oo();
            return;
        }
        f.jA("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Oz();
        if (a.b.NS()) {
            com.baidu.swan.apps.core.slave.a.NO().a(Os(), (a.InterfaceC0244a) null);
        }
        if (Ox()) {
            Ow();
        }
        if (this.bom == null) {
            this.bom = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void EM() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.jA("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.mIsReleased);
                            }
                            if (d.this.mIsReleased) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.Oz();
                            d.this.OC();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.Ow();
                                d.this.Oy();
                                return;
                            }
                            d.this.Ok();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.boA.a(this.bom);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ok() {
        synchronized (this.bov) {
            this.bop = false;
            this.boo = null;
        }
        this.bor = false;
        this.boq = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gz(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", Ou());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion gi = com.baidu.swan.apps.swancore.b.gi(0);
            jSONObject.put("swan app core", gi == null ? "null" : Long.valueOf(gi.swanCoreVersion));
            SwanCoreVersion gi2 = com.baidu.swan.apps.swancore.b.gi(1);
            jSONObject.put("swan game core", gi2 == null ? "null" : Long.valueOf(gi2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0287a(10001).lp(com.baidu.swan.apps.runtime.e.aap() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.aap().getAppKey()).lq(jSONObject.toString()).TW();
    }

    public boolean Ol() {
        boolean z;
        synchronized (this.bov) {
            z = this.bop && this.bor;
        }
        return z;
    }

    public boolean Om() {
        boolean z;
        synchronized (this.bov) {
            z = this.bop;
        }
        return z;
    }

    public boolean On() {
        boolean z;
        synchronized (this.bov) {
            z = this.bor;
        }
        return z;
    }

    public void Oo() {
        if (!this.bon.isEmpty() && Ol()) {
            f.jA("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bon) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bon.clear();
        }
    }

    private String t(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.p(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String Op() {
        return !TextUtils.isEmpty(Oq()) ? Oq() + "runtime/index.js" : "";
    }

    public String Oq() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String Or() {
        String str;
        Oz();
        if (Ou()) {
            str = Op();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.FE()) {
            t(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Jy()) {
            com.baidu.swan.apps.console.debugger.a.d.Jv();
            com.baidu.swan.apps.console.debugger.a.d.Jr().gn("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.JB();
        } else {
            com.baidu.swan.apps.core.a.gw(str);
        }
        return ag.toFileUriString(str);
    }

    public String Os() {
        Oz();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.FE()) {
            t(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Jy()) {
            return com.baidu.swan.apps.console.debugger.a.e.JC();
        } else {
            com.baidu.swan.apps.core.a.gw(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ot() {
        if (!this.bou.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bou.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bqi);
                }
                a(next);
            }
            this.bou.clear();
        }
    }

    public boolean Ou() {
        return this.boo instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a Ov() {
        return this.boo;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ow() {
        synchronized (this.bov) {
            if (!this.bop && this.boo == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.jA("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.boo = this.boz.n(getContext(), Ox() ? 1 : 0);
                f.jA("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.boo.loadUrl(Or());
                this.boo.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void dX(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.jA("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bov) {
                            d.this.bop = true;
                            d.this.Ot();
                            d.this.Oo();
                        }
                    }
                });
            }
        }
    }

    private boolean Ox() {
        if (com.baidu.swan.apps.console.debugger.a.e.Jy() || com.baidu.swan.apps.w.a.RS().FE()) {
            return false;
        }
        return b.EW() && new File(Op()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oy() {
        if (!this.bor && this.boq == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.jA("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.boq = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void dX(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.jA("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bor = true;
                    d.this.Oo();
                }
            });
            OE();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bq = this.boz.bq(context);
            f.jA("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.NS()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String Os = Os();
                com.baidu.swan.apps.core.slave.a.NO().a(Os, new a.InterfaceC0244a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0244a
                    public void hc(final String str) {
                        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bq.loadDataWithBaseURL(Os, str, "text/html", "utf-8", Os);
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData end");
                                }
                            }
                        });
                    }
                });
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadUrl");
                }
                bq.loadUrl(Os());
            }
            bq.a(bVar);
            return bq;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bP(context);
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
    public void Oz() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gi(0));
        }
    }

    public SwanCoreVersion OA() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore OB() {
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
    public void OC() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.ey(0));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.OB();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bot.put(eVar.GA(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String GA = eVar.GA();
        this.bot.remove(GA);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", GA);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e hg(String str) {
        if (this.bot.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bot.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bov) {
            if (!this.bop) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bqi)));
                }
                this.bou.add(aVar);
            } else if (this.boo != null) {
                com.baidu.swan.apps.n.a.a(this.boo.Hm(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bot.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.Gy(), aVar);
    }

    @Nullable
    public String OD() {
        OE();
        return this.bow;
    }

    private void OE() {
        if (TextUtils.isEmpty(this.bow)) {
            this.bow = this.boq != null ? this.boq.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bow);
            }
        }
    }

    public void ct(boolean z) {
        if (z && this.boo != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.jA("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bov) {
                this.bop = true;
                Ot();
                Oo();
            }
        } else if (!z && this.boq != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.jA("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bor = true;
            Oo();
        }
    }

    public void cu(boolean z) {
        this.bos = z;
    }

    public boolean OF() {
        return this.bos;
    }

    /* loaded from: classes10.dex */
    public static class b {
        private static boolean boJ = com.baidu.swan.apps.w.a.RJ().EW();
        private static boolean boK = boJ;

        public static void F(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                boJ = intent.getBooleanExtra("bundle_key_v8_ab", boJ);
            }
        }

        public static void OG() {
            boK = boJ;
        }

        public static String OH() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean EW() {
            if (d.DEBUG) {
                String OH = OH();
                char c = 65535;
                switch (OH.hashCode()) {
                    case -1406842887:
                        if (OH.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (OH.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (OH.equals("V8")) {
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
            return boK;
        }
    }
}
