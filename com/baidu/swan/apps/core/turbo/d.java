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
    private static volatile d caF;
    private com.baidu.swan.apps.core.container.a.b caG;
    private com.baidu.swan.apps.core.g.a caI;
    private boolean caJ;
    private com.baidu.swan.apps.adaptation.b.c caK;
    private boolean caL;
    private boolean caM;
    private boolean caN;
    private HashMap<String, e> caO;
    private String caR;
    private as caW;
    private i caX;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int caS = 10150;
    public static boolean caT = false;
    private static PreloadState caU = PreloadState.UNKNOWN;
    private static boolean caV = false;
    private List<a> caH = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> caP = new LinkedList<>();
    private final Object caQ = new Object();
    private volatile boolean caY = false;

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    public static PreloadState abj() {
        return caU;
    }

    public static int abk() {
        return abj().statsCode(caV);
    }

    private d() {
        com.baidu.swan.apps.w.i.a(this);
        this.caO = new HashMap<>();
        this.caW = new com.baidu.swan.apps.adaptation.b.a.b();
        this.caX = com.baidu.swan.apps.adaptation.b.a.c.Tq().Tr().To();
    }

    public static d abl() {
        if (caF == null) {
            synchronized (d.class) {
                if (caF == null) {
                    caF = new d();
                }
            }
        }
        return caF;
    }

    public as abm() {
        return this.caW;
    }

    private static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (caF != null) {
                caU = PreloadState.UNKNOWN;
                caF.caM = true;
                caT = false;
                if (caF.caG != null) {
                    caF.caX.b(caF.caG);
                }
                com.baidu.swan.apps.api.module.l.d.UF();
                com.baidu.swan.apps.swancore.a.a.arU();
                abn();
                com.baidu.swan.apps.w.i.b(caF);
                caF = null;
                if (a.b.aaU()) {
                    com.baidu.swan.apps.core.slave.a.aaQ().clear();
                }
                com.baidu.swan.apps.core.h.b.aaz().reset();
                caV = z;
                abl().abo();
            }
        }
    }

    private static void abn() {
        if (caF.caO != null) {
            for (e eVar : ((HashMap) caF.caO.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (caF.caI != null) {
            if (caF.caI instanceof com.baidu.swan.apps.core.g.e) {
                caF.caI.destroy();
            }
            caF.caI = null;
        }
        if (caF.caK != null) {
            caF.caK = null;
        }
    }

    private void abo() {
        p(null);
    }

    public void p(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (abr()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        caT = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.hc(0);
            extensionCore = com.baidu.swan.apps.extcore.b.fg(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.afn().ef(intent.getIntExtra("bundle_key_preload_switch", caS));
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
        b.abN();
        n.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.1
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.aq.h.atm();
            }
        }, "prepare ab description");
        if (!abD() || com.baidu.swan.games.utils.so.d.aCo()) {
            a(new a() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.turbo.d.a
                public void onReady() {
                    aj.p(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            d.this.abM();
                        }
                    });
                    com.baidu.swan.apps.process.messaging.client.a.amQ().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.abG();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.abG());
        }
        e(bVar);
        f(bVar);
        g.alx().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.al.a.aqT().oo("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.turbo.d.3
            @Override // com.baidu.swan.apps.core.turbo.d.a
            public void onReady() {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.caM) {
                            g.mp("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.al.a.aqT().oo("na_pre_load_ok");
                            g.bF("preload", "startup");
                            if (d.this.caI != null && d.this.caK != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.caI, d.this.caK, bVar, fVar);
                                d.this.caK = null;
                            }
                            g.i(bVar);
                        }
                    }
                });
            }
        });
    }

    public void abp() {
        aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.4
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.runtime.e aoG;
                if (d.this.caK != null && (aoG = com.baidu.swan.apps.runtime.e.aoG()) != null) {
                    String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(f.ahV(), aoG.QJ(), aoG.aoO());
                    SwanAppConfigData aoO = aoG.aoO();
                    if (TextUtils.equals(aoO != null ? aoO.nz(a2) : null, "main")) {
                        com.baidu.swan.apps.core.h.b.aaz().a(d.this.caI, d.this.caK, aoG.QJ(), aoG.aoO(), null);
                    }
                }
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.caH.contains(aVar)) {
            this.caH.add(aVar);
        }
        boolean abr = abr();
        g.alx().bD("preload", abr ? "1" : "0");
        if (abr) {
            abu();
            return;
        }
        caU = PreloadState.LOADING;
        g.mp("preload").f(new UbcFlowEvent("na_pre_load_start"));
        abF();
        if (a.b.aaU()) {
            com.baidu.swan.apps.core.slave.a.aaQ().a(aby(), (a.InterfaceC0345a) null);
        }
        if (abD()) {
            abC();
        }
        if (this.caG == null) {
            this.caG = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.5
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Rf() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    g.mp("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.caM);
                            }
                            if (d.this.caM) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.abF();
                            d.this.abI();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.abC();
                                d.this.abE();
                                return;
                            }
                            PreloadState unused = d.caU = PreloadState.LOAD_FAILED;
                            d.this.abq();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.caX.a(this.caG);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abq() {
        synchronized (this.caQ) {
            this.caJ = false;
            this.caI = null;
        }
        this.caL = false;
        this.caK = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.hs(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", abA());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion hc = com.baidu.swan.apps.swancore.b.hc(0);
            jSONObject.put("swan app core", hc == null ? "null" : Long.valueOf(hc.swanCoreVersion));
            SwanCoreVersion hc2 = com.baidu.swan.apps.swancore.b.hc(1);
            jSONObject.put("swan game core", hc2 == null ? "null" : Long.valueOf(hc2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).or(com.baidu.swan.apps.runtime.e.aoF() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aoF().getAppKey()).os(jSONObject.toString()).ahn();
    }

    public boolean abr() {
        boolean z;
        synchronized (this.caQ) {
            z = this.caJ && this.caL;
        }
        return z;
    }

    public boolean abs() {
        boolean z;
        synchronized (this.caQ) {
            z = this.caJ;
        }
        return z;
    }

    public boolean abt() {
        boolean z;
        synchronized (this.caQ) {
            z = this.caL;
        }
        return z;
    }

    public void abu() {
        if (!this.caH.isEmpty() && abr()) {
            caU = PreloadState.LOADED;
            g.mp("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.caH) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.caH.clear();
        }
    }

    private String I(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.t(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String abv() {
        return !TextUtils.isEmpty(abw()) ? abw() + "runtime/index.js" : "";
    }

    public String abw() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String abx() {
        String str;
        abF();
        if (abA()) {
            str = abv();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.RN()) {
            I(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Wm()) {
            com.baidu.swan.apps.console.debugger.a.d.Wj();
            com.baidu.swan.apps.console.debugger.a.d.Wf().iQ("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.Wp();
        } else {
            com.baidu.swan.apps.core.a.iZ(str);
        }
        return ah.toFileUriString(str);
    }

    public String aby() {
        abF();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.RN()) {
            I(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.Wm()) {
            return com.baidu.swan.apps.console.debugger.a.e.Wq();
        } else {
            com.baidu.swan.apps.core.a.iZ(str);
        }
        return ah.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abz() {
        if (!this.caP.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.caP.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bMG);
                }
                a(next);
            }
            this.caP.clear();
        }
    }

    public boolean abA() {
        return this.caI instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a abB() {
        return this.caI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abC() {
        synchronized (this.caQ) {
            if (!this.caJ && this.caI == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                g.mp("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.caI = this.caW.h(getContext(), abD() ? 1 : 0);
                g.mp("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.caI.loadUrl(abx());
                this.caI.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.turbo.d.6
                    @Override // com.baidu.swan.apps.core.b
                    public void fQ(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        g.mp("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.caQ) {
                            d.this.caJ = true;
                            d.this.abz();
                            d.this.abu();
                        }
                    }
                });
            }
        }
    }

    private boolean abD() {
        if (com.baidu.swan.apps.console.debugger.a.e.Wm() || com.baidu.swan.apps.u.a.afd().RN()) {
            return false;
        }
        return b.Rq() && new File(abv()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abE() {
        if (!this.caL && this.caK == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            g.mp("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.caK = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.turbo.d.7
                @Override // com.baidu.swan.apps.core.b
                public void fQ(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    g.mp("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.caL = true;
                    d.this.abu();
                }
            });
            abK();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bf = this.caW.bf(context);
            g.mp("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.aaU()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String aby = aby();
                com.baidu.swan.apps.core.slave.a.aaQ().a(aby, new a.InterfaceC0345a() { // from class: com.baidu.swan.apps.core.turbo.d.8
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0345a
                    public void jK(final String str) {
                        aj.p(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bf.loadDataWithBaseURL(aby, str, "text/html", "utf-8", aby);
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
                bf.loadUrl(aby());
            }
            bf.a(bVar);
            return bf;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bE(context);
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
    public void abF() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.hc(0));
        }
    }

    public SwanCoreVersion abG() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore abH() {
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
    public void abI() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.fg(0));
        }
    }

    public void f(com.baidu.swan.apps.v.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.abH();
        }
    }

    @Override // com.baidu.swan.apps.w.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.caO.put(eVar.Tj(), eVar);
    }

    @Override // com.baidu.swan.apps.w.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String Tj = eVar.Tj();
        this.caO.remove(Tj);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", Tj);
            a(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e jO(String str) {
        if (this.caO.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.caO.get(str);
    }

    public void a(com.baidu.swan.apps.event.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.caQ) {
            if (!this.caJ) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bMG)));
                }
                this.caP.add(aVar);
            } else if (this.caI != null) {
                com.baidu.swan.apps.event.a.a(this.caI.TR(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.caO.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.Th(), aVar);
    }

    @Nullable
    public String abJ() {
        abK();
        return this.caR;
    }

    private void abK() {
        if (TextUtils.isEmpty(this.caR)) {
            this.caR = this.caK != null ? this.caK.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.caR);
            }
        }
    }

    public void dM(boolean z) {
        if (z && this.caI != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            g.mp("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.caQ) {
                this.caJ = true;
                abz();
                abu();
            }
        } else if (!z && this.caK != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            g.mp("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.caL = true;
            abu();
        }
    }

    public void dN(boolean z) {
        this.caN = z;
    }

    public boolean abL() {
        return this.caN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void abM() {
        boolean z = true;
        if (this.caY) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.caY = true;
        com.baidu.swan.apps.runtime.d aoB = com.baidu.swan.apps.runtime.d.aoB();
        z = (aoB == null || !aoB.ane()) ? false : false;
        boolean RI = com.baidu.swan.apps.u.a.aeU().RI();
        if (!z && RI) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bJ(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + RI);
        }
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean cbi = com.baidu.swan.apps.u.a.aeU().Rq();
        private static boolean cbj = cbi;

        public static void q(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cbi = intent.getBooleanExtra("bundle_key_v8_ab", cbi);
            }
        }

        public static void abN() {
            cbj = cbi;
        }

        public static String abO() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void jP(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean Rq() {
            if (d.DEBUG) {
                String abO = abO();
                char c = 65535;
                switch (abO.hashCode()) {
                    case -1406842887:
                        if (abO.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (abO.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (abO.equals("V8")) {
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
            return cbj;
        }

        public static boolean abP() {
            String abO = abO();
            if (abO.equals("V8")) {
                return true;
            }
            if (abO.equals("AB")) {
                return com.baidu.swan.apps.u.a.aeU().Rq();
            }
            return false;
        }

        public static String fc(int i) {
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
