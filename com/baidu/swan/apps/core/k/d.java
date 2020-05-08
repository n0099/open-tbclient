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
/* loaded from: classes11.dex */
public final class d implements h {
    private static volatile d bQT;
    private com.baidu.swan.apps.core.container.a.b bQU;
    private com.baidu.swan.apps.core.g.a bQW;
    private boolean bQX;
    private com.baidu.swan.apps.adaptation.b.c bQY;
    private boolean bQZ;
    private boolean bRa;
    private boolean bRb;
    private HashMap<String, e> bRc;
    private String bRf;
    private am bRi;
    private i bRj;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bRg = 10150;
    public static boolean bRh = false;
    private List<a> bQV = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bRd = new LinkedList<>();
    private final Object bRe = new Object();

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bRc = new HashMap<>();
        this.bRi = new com.baidu.swan.apps.adaptation.b.a.b();
        this.bRj = com.baidu.swan.apps.adaptation.b.a.c.QM().QN().QK();
    }

    public static d Yn() {
        if (bQT == null) {
            synchronized (d.class) {
                if (bQT == null) {
                    bQT = new d();
                }
            }
        }
        return bQT;
    }

    public am Yo() {
        return this.bRi;
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
            if (bQT != null) {
                bQT.bRa = true;
                bRh = false;
                if (bQT.bQU != null) {
                    bQT.bRj.b(bQT.bQU);
                }
                com.baidu.swan.apps.api.module.l.d.RU();
                com.baidu.swan.apps.swancore.b.a.anE();
                Yp();
                com.baidu.swan.apps.y.i.b(bQT);
                bQT = null;
                if (a.b.XZ()) {
                    com.baidu.swan.apps.core.slave.a.XV().clear();
                }
                Yn().Yq();
            }
        }
    }

    private static void Yp() {
        if (bQT.bRc != null) {
            for (e eVar : ((HashMap) bQT.bRc.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bQT.bQW != null) {
            if (bQT.bQW instanceof com.baidu.swan.apps.core.g.e) {
                bQT.bQW.destroy();
            }
            bQT.bQW = null;
        }
        if (bQT.bQY != null) {
            bQT.bQY = null;
        }
    }

    private void Yq() {
        q(null);
    }

    public void q(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Ys()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        bRh = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.gG(0);
            extensionCore = com.baidu.swan.apps.extcore.b.eT(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.w.a.ack().dX(intent.getIntExtra("bundle_key_preload_switch", bRg));
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
        b.YN();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.aoL();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).gp(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.ajc().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.YH();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.YH());
        }
        e(bVar);
        f(bVar);
        f.aic().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.amO().mO("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.bRa) {
                            f.lb("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.amO().mO("na_pre_load_ok");
                            f.bm("preload", "startup");
                            if (d.this.bQW != null && d.this.bQY != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.bQW, d.this.bQY, bVar, fVar);
                                d.this.bQY = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bQV.contains(aVar)) {
            this.bQV.add(aVar);
        }
        boolean Ys = Ys();
        f.aic().bk("preload", Ys ? "1" : "0");
        if (Ys) {
            Yv();
            return;
        }
        f.lb("preload").f(new UbcFlowEvent("na_pre_load_start"));
        YG();
        if (a.b.XZ()) {
            com.baidu.swan.apps.core.slave.a.XV().a(Yz(), (a.InterfaceC0305a) null);
        }
        if (YE()) {
            YD();
        }
        if (this.bQU == null) {
            this.bQU = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void OU() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.lb("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.bRa);
                            }
                            if (d.this.bRa) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.YG();
                            d.this.YJ();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.YD();
                                d.this.YF();
                                return;
                            }
                            d.this.Yr();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.bRj.a(this.bQU);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yr() {
        synchronized (this.bRe) {
            this.bQX = false;
            this.bQW = null;
        }
        this.bQZ = false;
        this.bQY = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gX(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", YB());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion gG = com.baidu.swan.apps.swancore.b.gG(0);
            jSONObject.put("swan app core", gG == null ? "null" : Long.valueOf(gG.swanCoreVersion));
            SwanCoreVersion gG2 = com.baidu.swan.apps.swancore.b.gG(1);
            jSONObject.put("swan game core", gG2 == null ? "null" : Long.valueOf(gG2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0348a(10001).mQ(com.baidu.swan.apps.runtime.e.akM() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.akM().getAppKey()).mR(jSONObject.toString()).aed();
    }

    public boolean Ys() {
        boolean z;
        synchronized (this.bRe) {
            z = this.bQX && this.bQZ;
        }
        return z;
    }

    public boolean Yt() {
        boolean z;
        synchronized (this.bRe) {
            z = this.bQX;
        }
        return z;
    }

    public boolean Yu() {
        boolean z;
        synchronized (this.bRe) {
            z = this.bQZ;
        }
        return z;
    }

    public void Yv() {
        if (!this.bQV.isEmpty() && Ys()) {
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bQV) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bQV.clear();
        }
    }

    private String y(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.q(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String Yw() {
        return !TextUtils.isEmpty(Yx()) ? Yx() + "runtime/index.js" : "";
    }

    public String Yx() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String Yy() {
        String str;
        YG();
        if (YB()) {
            str = Yw();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.PJ()) {
            y(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.TF()) {
            com.baidu.swan.apps.console.debugger.a.d.TC();
            com.baidu.swan.apps.console.debugger.a.d.Ty().hP("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.TI();
        } else {
            com.baidu.swan.apps.core.a.hY(str);
        }
        return ag.toFileUriString(str);
    }

    public String Yz() {
        YG();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.PJ()) {
            y(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.TF()) {
            return com.baidu.swan.apps.console.debugger.a.e.TJ();
        } else {
            com.baidu.swan.apps.core.a.hY(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YA() {
        if (!this.bRd.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bRd.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bSS);
                }
                a(next);
            }
            this.bRd.clear();
        }
    }

    public boolean YB() {
        return this.bQW instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a YC() {
        return this.bQW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YD() {
        synchronized (this.bRe) {
            if (!this.bQX && this.bQW == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.bQW = this.bRi.h(getContext(), YE() ? 1 : 0);
                f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.bQW.loadUrl(Yy());
                this.bQW.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void fe(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bRe) {
                            d.this.bQX = true;
                            d.this.YA();
                            d.this.Yv();
                        }
                    }
                });
            }
        }
    }

    private boolean YE() {
        if (com.baidu.swan.apps.console.debugger.a.e.TF() || com.baidu.swan.apps.w.a.abZ().PJ()) {
            return false;
        }
        return b.Pe() && new File(Yw()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YF() {
        if (!this.bQZ && this.bQY == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.bQY = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void fe(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bQZ = true;
                    d.this.Yv();
                }
            });
            YL();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c aV = this.bRi.aV(context);
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.XZ()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String Yz = Yz();
                com.baidu.swan.apps.core.slave.a.XV().a(Yz, new a.InterfaceC0305a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0305a
                    public void iE(final String str) {
                        ai.o(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                aV.loadDataWithBaseURL(Yz, str, "text/html", "utf-8", Yz);
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
                aV.loadUrl(Yz());
            }
            aV.a(bVar);
            return aV;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bu(context);
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
    public void YG() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gG(0));
        }
    }

    public SwanCoreVersion YH() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore YI() {
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
    public void YJ() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.eT(0));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.YI();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bRc.put(eVar.QF(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String QF = eVar.QF();
        this.bRc.remove(QF);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", QF);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e iI(String str) {
        if (this.bRc.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bRc.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bRe) {
            if (!this.bQX) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bSS)));
                }
                this.bRd.add(aVar);
            } else if (this.bQW != null) {
                com.baidu.swan.apps.n.a.a(this.bQW.Rr(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bRc.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.QD(), aVar);
    }

    @Nullable
    public String YK() {
        YL();
        return this.bRf;
    }

    private void YL() {
        if (TextUtils.isEmpty(this.bRf)) {
            this.bRf = this.bQY != null ? this.bQY.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bRf);
            }
        }
    }

    public void dx(boolean z) {
        if (z && this.bQW != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bRe) {
                this.bQX = true;
                YA();
                Yv();
            }
        } else if (!z && this.bQY != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bQZ = true;
            Yv();
        }
    }

    public void dy(boolean z) {
        this.bRb = z;
    }

    public boolean YM() {
        return this.bRb;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean bRs = com.baidu.swan.apps.w.a.abQ().Pe();
        private static boolean bRt = bRs;

        public static void r(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                bRs = intent.getBooleanExtra("bundle_key_v8_ab", bRs);
            }
        }

        public static void YN() {
            bRt = bRs;
        }

        public static String YO() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Pe() {
            if (d.DEBUG) {
                String YO = YO();
                char c = 65535;
                switch (YO.hashCode()) {
                    case -1406842887:
                        if (YO.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (YO.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (YO.equals("V8")) {
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
            return bRt;
        }
    }
}
