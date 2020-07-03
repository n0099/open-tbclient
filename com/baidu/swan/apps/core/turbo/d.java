package com.baidu.swan.apps.core.turbo;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.adaptation.a.as;
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.aq.ah;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.apps.core.slave.a;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.r.e;
import com.baidu.swan.apps.runtime.config.SwanAppConfigData;
import com.baidu.swan.apps.statistic.c;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.apps.w.h;
import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public final class d implements h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cfH = 10150;
    public static boolean cfI = false;
    private static PreloadState cfJ = PreloadState.UNKNOWN;
    private static boolean cfK = false;
    private static volatile d cfu;
    private boolean cfA;
    private boolean cfB;
    private boolean cfC;
    private HashMap<String, e> cfD;
    private String cfG;
    private as cfL;
    private i cfM;
    private com.baidu.swan.apps.core.container.a.b cfv;
    private com.baidu.swan.apps.core.g.a cfx;
    private boolean cfy;
    private com.baidu.swan.apps.adaptation.b.c cfz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private List<a> cfw = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cfE = new LinkedList<>();
    private final Object cfF = new Object();
    private volatile boolean cfN = false;

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    public static PreloadState acp() {
        return cfJ;
    }

    public static int acq() {
        return acp().statsCode(cfK);
    }

    private d() {
        com.baidu.swan.apps.w.i.a(this);
        this.cfD = new HashMap<>();
        this.cfL = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cfM = com.baidu.swan.apps.adaptation.b.a.c.Uw().Ux().Uu();
    }

    public static d acr() {
        if (cfu == null) {
            synchronized (d.class) {
                if (cfu == null) {
                    cfu = new d();
                }
            }
        }
        return cfu;
    }

    public as acs() {
        return this.cfL;
    }

    private static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cfu != null) {
                cfJ = PreloadState.UNKNOWN;
                cfu.cfB = true;
                cfI = false;
                if (cfu.cfv != null) {
                    cfu.cfM.b(cfu.cfv);
                }
                com.baidu.swan.apps.api.module.l.d.VL();
                com.baidu.swan.apps.swancore.a.a.atb();
                act();
                com.baidu.swan.apps.w.i.b(cfu);
                cfu = null;
                if (a.b.aca()) {
                    com.baidu.swan.apps.core.slave.a.abW().clear();
                }
                com.baidu.swan.apps.core.h.b.abF().reset();
                cfK = z;
                acr().acu();
            }
        }
    }

    private static void act() {
        if (cfu.cfD != null) {
            for (e eVar : ((HashMap) cfu.cfD.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (cfu.cfx != null) {
            if (cfu.cfx instanceof com.baidu.swan.apps.core.g.e) {
                cfu.cfx.destroy();
            }
            cfu.cfx = null;
        }
        if (cfu.cfz != null) {
            cfu.cfz = null;
        }
    }

    private void acu() {
        p(null);
    }

    public void p(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (acx()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        cfI = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.hn(0);
            extensionCore = com.baidu.swan.apps.extcore.b.fr(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.agt().eq(intent.getIntExtra("bundle_key_preload_switch", cfH));
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
        b.acT();
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.aq.h.aus();
            }
        }, "prepare ab description");
        if (!acJ() || com.baidu.swan.games.utils.so.d.aDu()) {
            a(new a() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.turbo.d.a
                public void onReady() {
                    aj.p(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.acS();
                        }
                    });
                    com.baidu.swan.apps.process.messaging.client.a.anW().sendMessage(14);
                }
            });
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
            }
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.acM();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.acM());
        }
        e(bVar);
        f(bVar);
        g.amD().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.al.a.arZ().ow("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.turbo.d.3
            @Override // com.baidu.swan.apps.core.turbo.d.a
            public void onReady() {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.cfB) {
                            g.mx("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.al.a.arZ().ow("na_pre_load_ok");
                            g.bH("preload", "startup");
                            if (d.this.cfx != null && d.this.cfz != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.cfx, d.this.cfz, bVar, fVar);
                                d.this.cfz = null;
                            }
                            g.i(bVar);
                        }
                    }
                });
            }
        });
    }

    public void acv() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.runtime.e apN;
                if (d.this.cfz != null && (apN = com.baidu.swan.apps.runtime.e.apN()) != null) {
                    String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.ajb(), apN.RP(), apN.apV());
                    SwanAppConfigData apV = apN.apV();
                    if (TextUtils.equals(apV != null ? apV.nH(a2) : null, "main")) {
                        com.baidu.swan.apps.core.h.b.abF().a(d.this.cfx, d.this.cfz, apN.RP(), apN.apV(), null);
                    }
                }
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.cfw.contains(aVar)) {
            this.cfw.add(aVar);
        }
        boolean acx = acx();
        g.amD().bF("preload", acx ? "1" : "0");
        if (acx) {
            acA();
            return;
        }
        cfJ = PreloadState.LOADING;
        g.mx("preload").f(new UbcFlowEvent("na_pre_load_start"));
        acL();
        if (a.b.aca()) {
            com.baidu.swan.apps.core.slave.a.abW().a(acE(), (a.InterfaceC0351a) null);
        }
        if (acJ()) {
            acI();
        }
        if (this.cfv == null) {
            this.cfv = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.5
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Sl() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    g.mx("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cfB);
                            }
                            if (d.this.cfB) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.acL();
                            d.this.acO();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.acI();
                                d.this.acK();
                                return;
                            }
                            PreloadState unused = d.cfJ = PreloadState.LOAD_FAILED;
                            d.this.acw();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cfM.a(this.cfv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acw() {
        synchronized (this.cfF) {
            this.cfy = false;
            this.cfx = null;
        }
        this.cfA = false;
        this.cfz = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.hD(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", acG());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion hn = com.baidu.swan.apps.swancore.b.hn(0);
            jSONObject.put("swan app core", hn == null ? "null" : Long.valueOf(hn.swanCoreVersion));
            SwanCoreVersion hn2 = com.baidu.swan.apps.swancore.b.hn(1);
            jSONObject.put("swan game core", hn2 == null ? "null" : Long.valueOf(hn2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).oz(com.baidu.swan.apps.runtime.e.apM() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.apM().getAppKey()).oA(jSONObject.toString()).ait();
    }

    public boolean acx() {
        boolean z;
        synchronized (this.cfF) {
            z = this.cfy && this.cfA;
        }
        return z;
    }

    public boolean acy() {
        boolean z;
        synchronized (this.cfF) {
            z = this.cfy;
        }
        return z;
    }

    public boolean acz() {
        boolean z;
        synchronized (this.cfF) {
            z = this.cfA;
        }
        return z;
    }

    public void acA() {
        if (!this.cfw.isEmpty() && acx()) {
            cfJ = PreloadState.LOADED;
            g.mx("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.cfw) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.cfw.clear();
        }
    }

    private String K(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.u(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String acB() {
        return !TextUtils.isEmpty(acC()) ? acC() + "runtime/index.js" : "";
    }

    public String acC() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String acD() {
        String str;
        acL();
        if (acG()) {
            str = acB();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.ST()) {
            K(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Xs()) {
            com.baidu.swan.apps.console.debugger.a.d.Xp();
            com.baidu.swan.apps.console.debugger.a.d.Xl().iY("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.Xv();
        } else {
            com.baidu.swan.apps.core.a.jh(str);
        }
        return ah.toFileUriString(str);
    }

    public String acE() {
        acL();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.ST()) {
            K(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Xs()) {
            return com.baidu.swan.apps.console.debugger.a.e.Xw();
        } else {
            com.baidu.swan.apps.core.a.jh(str);
        }
        return ah.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acF() {
        if (!this.cfE.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cfE.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bRu);
                }
                a(next);
            }
            this.cfE.clear();
        }
    }

    public boolean acG() {
        return this.cfx instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a acH() {
        return this.cfx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acI() {
        synchronized (this.cfF) {
            if (!this.cfy && this.cfx == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                g.mx("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.cfx = this.cfL.h(getContext(), acJ() ? 1 : 0);
                g.mx("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cfx.loadUrl(acD());
                this.cfx.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.turbo.d.6
                    @Override // com.baidu.swan.apps.core.b
                    public void fJ(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        g.mx("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cfF) {
                            d.this.cfy = true;
                            d.this.acF();
                            d.this.acA();
                        }
                    }
                });
            }
        }
    }

    private boolean acJ() {
        if (com.baidu.swan.apps.console.debugger.a.e.Xs() || com.baidu.swan.apps.u.a.agj().ST()) {
            return false;
        }
        return b.Sw() && new File(acB()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acK() {
        if (!this.cfA && this.cfz == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            g.mx("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cfz = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.turbo.d.7
                @Override // com.baidu.swan.apps.core.b
                public void fJ(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    g.mx("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cfA = true;
                    d.this.acA();
                }
            });
            acQ();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bg = this.cfL.bg(context);
            g.mx("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.aca()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String acE = acE();
                com.baidu.swan.apps.core.slave.a.abW().a(acE, new a.InterfaceC0351a() { // from class: com.baidu.swan.apps.core.turbo.d.8
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0351a
                    public void jS(final String str) {
                        aj.p(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bg.loadDataWithBaseURL(acE, str, "text/html", "utf-8", acE);
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
                bg.loadUrl(acE());
            }
            bg.a(bVar);
            return bg;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bF(context);
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
    public void acL() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.hn(0));
        }
    }

    public SwanCoreVersion acM() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore acN() {
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
    public void acO() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.fr(0));
        }
    }

    public void f(com.baidu.swan.apps.v.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.acN();
        }
    }

    @Override // com.baidu.swan.apps.w.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cfD.put(eVar.Up(), eVar);
    }

    @Override // com.baidu.swan.apps.w.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String Up = eVar.Up();
        this.cfD.remove(Up);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", Up);
            a(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e jW(String str) {
        if (this.cfD.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cfD.get(str);
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cfF) {
            if (!this.cfy) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bRu)));
                }
                this.cfE.add(aVar);
            } else if (this.cfx != null) {
                com.baidu.swan.apps.event.a.a(this.cfx.UX(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cfD.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.Un(), aVar);
    }

    @Nullable
    public String acP() {
        acQ();
        return this.cfG;
    }

    private void acQ() {
        if (TextUtils.isEmpty(this.cfG)) {
            this.cfG = this.cfz != null ? this.cfz.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cfG);
            }
        }
    }

    public void dR(boolean z) {
        if (z && this.cfx != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            g.mx("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cfF) {
                this.cfy = true;
                acF();
                acA();
            }
        } else if (!z && this.cfz != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            g.mx("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cfA = true;
            acA();
        }
    }

    public void dS(boolean z) {
        this.cfC = z;
    }

    public boolean acR() {
        return this.cfC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acS() {
        boolean z = true;
        if (this.cfN) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cfN = true;
        com.baidu.swan.apps.runtime.d apI = com.baidu.swan.apps.runtime.d.apI();
        z = (apI == null || !apI.aok()) ? false : false;
        boolean SO = com.baidu.swan.apps.u.a.aga().SO();
        if (!z && SO) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bK(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + SO);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean cfX = com.baidu.swan.apps.u.a.aga().Sw();
        private static boolean cfY = cfX;

        public static void q(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cfX = intent.getBooleanExtra("bundle_key_v8_ab", cfX);
            }
        }

        public static void acT() {
            cfY = cfX;
        }

        public static String acU() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void jX(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean Sw() {
            if (d.DEBUG) {
                String acU = acU();
                char c = 65535;
                switch (acU.hashCode()) {
                    case -1406842887:
                        if (acU.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (acU.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (acU.equals("V8")) {
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
            return cfY;
        }

        public static boolean acV() {
            String acU = acU();
            if (acU.equals("V8")) {
                return true;
            }
            if (acU.equals("AB")) {
                return com.baidu.swan.apps.u.a.aga().Sw();
            }
            return false;
        }

        public static String fn(int i) {
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
