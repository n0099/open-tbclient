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
/* loaded from: classes9.dex */
public final class d implements h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bnJ = 10150;
    public static boolean bnK = false;
    private static volatile d bnx;
    private com.baidu.swan.apps.core.g.a bnA;
    private boolean bnB;
    private com.baidu.swan.apps.adaptation.b.c bnC;
    private boolean bnD;
    private boolean bnE;
    private HashMap<String, e> bnF;
    private String bnI;
    private am bnL;
    private i bnM;
    private com.baidu.swan.apps.core.container.a.b bny;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private List<a> bnz = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bnG = new LinkedList<>();
    private final Object bnH = new Object();

    /* loaded from: classes9.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bnF = new HashMap<>();
        this.bnL = new com.baidu.swan.apps.adaptation.b.a.b();
        this.bnM = com.baidu.swan.apps.adaptation.b.a.c.Gl().Gm().Gj();
    }

    public static d NK() {
        if (bnx == null) {
            synchronized (d.class) {
                if (bnx == null) {
                    bnx = new d();
                }
            }
        }
        return bnx;
    }

    public am NL() {
        return this.bnL;
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
            if (bnx != null) {
                bnx.mIsReleased = true;
                bnK = false;
                if (bnx.bny != null) {
                    bnx.bnM.b(bnx.bny);
                }
                com.baidu.swan.apps.api.module.l.d.Hs();
                com.baidu.swan.apps.swancore.b.a.acK();
                NM();
                com.baidu.swan.apps.y.i.b(bnx);
                bnx = null;
                if (a.b.Nw()) {
                    com.baidu.swan.apps.core.slave.a.Ns().clear();
                }
                NK().NN();
            }
        }
    }

    private static void NM() {
        if (bnx.bnF != null) {
            for (e eVar : ((HashMap) bnx.bnF.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bnx.bnA != null) {
            if (bnx.bnA instanceof com.baidu.swan.apps.core.g.e) {
                bnx.bnA.destroy();
            }
            bnx.bnA = null;
        }
        if (bnx.bnC != null) {
            bnx.bnC = null;
        }
    }

    private void NN() {
        E(null);
    }

    public void E(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (NP()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        bnK = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.gh(0);
            extensionCore = com.baidu.swan.apps.extcore.b.ex(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.w.a.RH().dB(intent.getIntExtra("bundle_key_preload_switch", bnJ));
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
        b.Ok();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.adV();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.q(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).fQ(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Yi().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.Oe();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.Oe());
        }
        e(bVar);
        f(bVar);
        f.Xi().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.abU().lk("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.mIsReleased) {
                            f.jx("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.abU().lk("na_pre_load_ok");
                            f.aT("preload", "startup");
                            if (d.this.bnA != null && d.this.bnC != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.bnA, d.this.bnC, bVar, fVar);
                                d.this.bnC = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bnz.contains(aVar)) {
            this.bnz.add(aVar);
        }
        boolean NP = NP();
        f.Xi().aR("preload", NP ? "1" : "0");
        if (NP) {
            NS();
            return;
        }
        f.jx("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Od();
        if (a.b.Nw()) {
            com.baidu.swan.apps.core.slave.a.Ns().a(NW(), (a.InterfaceC0242a) null);
        }
        if (Ob()) {
            Oa();
        }
        if (this.bny == null) {
            this.bny = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Eq() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.jx("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
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
                            d.this.Od();
                            d.this.Og();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.Oa();
                                d.this.Oc();
                                return;
                            }
                            d.this.NO();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.bnM.a(this.bny);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NO() {
        synchronized (this.bnH) {
            this.bnB = false;
            this.bnA = null;
        }
        this.bnD = false;
        this.bnC = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gy(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", NY());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion gh = com.baidu.swan.apps.swancore.b.gh(0);
            jSONObject.put("swan app core", gh == null ? "null" : Long.valueOf(gh.swanCoreVersion));
            SwanCoreVersion gh2 = com.baidu.swan.apps.swancore.b.gh(1);
            jSONObject.put("swan game core", gh2 == null ? "null" : Long.valueOf(gh2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0285a(10001).lm(com.baidu.swan.apps.runtime.e.ZS() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.ZS().getAppKey()).ln(jSONObject.toString()).Tz();
    }

    public boolean NP() {
        boolean z;
        synchronized (this.bnH) {
            z = this.bnB && this.bnD;
        }
        return z;
    }

    public boolean NQ() {
        boolean z;
        synchronized (this.bnH) {
            z = this.bnB;
        }
        return z;
    }

    public boolean NR() {
        boolean z;
        synchronized (this.bnH) {
            z = this.bnD;
        }
        return z;
    }

    public void NS() {
        if (!this.bnz.isEmpty() && NP()) {
            f.jx("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bnz) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bnz.clear();
        }
    }

    private String t(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.p(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String NT() {
        return !TextUtils.isEmpty(NU()) ? NU() + "runtime/index.js" : "";
    }

    public String NU() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String NV() {
        String str;
        Od();
        if (NY()) {
            str = NT();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.Fi()) {
            t(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Jc()) {
            com.baidu.swan.apps.console.debugger.a.d.IZ();
            com.baidu.swan.apps.console.debugger.a.d.IV().gk("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.Jf();
        } else {
            com.baidu.swan.apps.core.a.gt(str);
        }
        return ag.toFileUriString(str);
    }

    public String NW() {
        Od();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.Fi()) {
            t(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Jc()) {
            return com.baidu.swan.apps.console.debugger.a.e.Jg();
        } else {
            com.baidu.swan.apps.core.a.gt(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void NX() {
        if (!this.bnG.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bnG.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bpu);
                }
                a(next);
            }
            this.bnG.clear();
        }
    }

    public boolean NY() {
        return this.bnA instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a NZ() {
        return this.bnA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oa() {
        synchronized (this.bnH) {
            if (!this.bnB && this.bnA == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.jx("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.bnA = this.bnL.n(getContext(), Ob() ? 1 : 0);
                f.jx("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.bnA.loadUrl(NV());
                this.bnA.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void dV(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.jx("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bnH) {
                            d.this.bnB = true;
                            d.this.NX();
                            d.this.NS();
                        }
                    }
                });
            }
        }
    }

    private boolean Ob() {
        if (com.baidu.swan.apps.console.debugger.a.e.Jc() || com.baidu.swan.apps.w.a.Rw().Fi()) {
            return false;
        }
        return b.EA() && new File(NT()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Oc() {
        if (!this.bnD && this.bnC == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.jx("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.bnC = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void dV(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.jx("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bnD = true;
                    d.this.NS();
                }
            });
            Oi();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bq = this.bnL.bq(context);
            f.jx("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.Nw()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String NW = NW();
                com.baidu.swan.apps.core.slave.a.Ns().a(NW, new a.InterfaceC0242a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0242a
                    public void gZ(final String str) {
                        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bq.loadDataWithBaseURL(NW, str, "text/html", "utf-8", NW);
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
                bq.loadUrl(NW());
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
    public void Od() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gh(0));
        }
    }

    public SwanCoreVersion Oe() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore Of() {
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
    public void Og() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.ex(0));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.Of();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bnF.put(eVar.Ge(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String Ge = eVar.Ge();
        this.bnF.remove(Ge);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", Ge);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e hd(String str) {
        if (this.bnF.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bnF.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bnH) {
            if (!this.bnB) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bpu)));
                }
                this.bnG.add(aVar);
            } else if (this.bnA != null) {
                com.baidu.swan.apps.n.a.a(this.bnA.GQ(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bnF.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.Gc(), aVar);
    }

    @Nullable
    public String Oh() {
        Oi();
        return this.bnI;
    }

    private void Oi() {
        if (TextUtils.isEmpty(this.bnI)) {
            this.bnI = this.bnC != null ? this.bnC.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bnI);
            }
        }
    }

    public void co(boolean z) {
        if (z && this.bnA != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.jx("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bnH) {
                this.bnB = true;
                NX();
                NS();
            }
        } else if (!z && this.bnC != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.jx("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bnD = true;
            NS();
        }
    }

    public void cp(boolean z) {
        this.bnE = z;
    }

    public boolean Oj() {
        return this.bnE;
    }

    /* loaded from: classes9.dex */
    public static class b {
        private static boolean bnV = com.baidu.swan.apps.w.a.Rn().EA();
        private static boolean bnW = bnV;

        public static void F(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                bnV = intent.getBooleanExtra("bundle_key_v8_ab", bnV);
            }
        }

        public static void Ok() {
            bnW = bnV;
        }

        public static String Ol() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean EA() {
            if (d.DEBUG) {
                String Ol = Ol();
                char c = 65535;
                switch (Ol.hashCode()) {
                    case -1406842887:
                        if (Ol.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Ol.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Ol.equals("V8")) {
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
            return bnW;
        }
    }
}
