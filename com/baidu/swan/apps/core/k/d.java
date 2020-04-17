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
    private static volatile d bQO;
    private com.baidu.swan.apps.core.container.a.b bQP;
    private com.baidu.swan.apps.core.g.a bQR;
    private boolean bQS;
    private com.baidu.swan.apps.adaptation.b.c bQT;
    private boolean bQU;
    private boolean bQV;
    private boolean bQW;
    private HashMap<String, e> bQX;
    private String bRa;
    private am bRd;
    private i bRe;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bRb = 10150;
    public static boolean bRc = false;
    private List<a> bQQ = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bQY = new LinkedList<>();
    private final Object bQZ = new Object();

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bQX = new HashMap<>();
        this.bRd = new com.baidu.swan.apps.adaptation.b.a.b();
        this.bRe = com.baidu.swan.apps.adaptation.b.a.c.QN().QO().QL();
    }

    public static d Yo() {
        if (bQO == null) {
            synchronized (d.class) {
                if (bQO == null) {
                    bQO = new d();
                }
            }
        }
        return bQO;
    }

    public am Yp() {
        return this.bRd;
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
            if (bQO != null) {
                bQO.bQV = true;
                bRc = false;
                if (bQO.bQP != null) {
                    bQO.bRe.b(bQO.bQP);
                }
                com.baidu.swan.apps.api.module.l.d.RV();
                com.baidu.swan.apps.swancore.b.a.anF();
                Yq();
                com.baidu.swan.apps.y.i.b(bQO);
                bQO = null;
                if (a.b.Ya()) {
                    com.baidu.swan.apps.core.slave.a.XW().clear();
                }
                Yo().Yr();
            }
        }
    }

    private static void Yq() {
        if (bQO.bQX != null) {
            for (e eVar : ((HashMap) bQO.bQX.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bQO.bQR != null) {
            if (bQO.bQR instanceof com.baidu.swan.apps.core.g.e) {
                bQO.bQR.destroy();
            }
            bQO.bQR = null;
        }
        if (bQO.bQT != null) {
            bQO.bQT = null;
        }
    }

    private void Yr() {
        D(null);
    }

    public void D(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Yt()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        bRc = true;
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
            com.baidu.swan.apps.w.a.acl().dX(intent.getIntExtra("bundle_key_preload_switch", bRb));
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
        b.YO();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.aoM();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).gp(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.ajd().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.YI();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.YI());
        }
        e(bVar);
        f(bVar);
        f.aid().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.amP().mO("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.bQV) {
                            f.lb("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.amP().mO("na_pre_load_ok");
                            f.bm("preload", "startup");
                            if (d.this.bQR != null && d.this.bQT != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.bQR, d.this.bQT, bVar, fVar);
                                d.this.bQT = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bQQ.contains(aVar)) {
            this.bQQ.add(aVar);
        }
        boolean Yt = Yt();
        f.aid().bk("preload", Yt ? "1" : "0");
        if (Yt) {
            Yw();
            return;
        }
        f.lb("preload").f(new UbcFlowEvent("na_pre_load_start"));
        YH();
        if (a.b.Ya()) {
            com.baidu.swan.apps.core.slave.a.XW().a(YA(), (a.InterfaceC0284a) null);
        }
        if (YF()) {
            YE();
        }
        if (this.bQP == null) {
            this.bQP = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void OV() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.lb("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.4.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.bQV);
                            }
                            if (d.this.bQV) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.YH();
                            d.this.YK();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.YE();
                                d.this.YG();
                                return;
                            }
                            d.this.Ys();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.bRe.a(this.bQP);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ys() {
        synchronized (this.bQZ) {
            this.bQS = false;
            this.bQR = null;
        }
        this.bQU = false;
        this.bQT = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gX(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", YC());
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
        new a.C0327a(10001).mQ(com.baidu.swan.apps.runtime.e.akN() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.akN().getAppKey()).mR(jSONObject.toString()).aee();
    }

    public boolean Yt() {
        boolean z;
        synchronized (this.bQZ) {
            z = this.bQS && this.bQU;
        }
        return z;
    }

    public boolean Yu() {
        boolean z;
        synchronized (this.bQZ) {
            z = this.bQS;
        }
        return z;
    }

    public boolean Yv() {
        boolean z;
        synchronized (this.bQZ) {
            z = this.bQU;
        }
        return z;
    }

    public void Yw() {
        if (!this.bQQ.isEmpty() && Yt()) {
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bQQ) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bQQ.clear();
        }
    }

    private String y(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.q(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String Yx() {
        return !TextUtils.isEmpty(Yy()) ? Yy() + "runtime/index.js" : "";
    }

    public String Yy() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String Yz() {
        String str;
        YH();
        if (YC()) {
            str = Yx();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.PK()) {
            y(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.TG()) {
            com.baidu.swan.apps.console.debugger.a.d.TD();
            com.baidu.swan.apps.console.debugger.a.d.Tz().hP("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.TJ();
        } else {
            com.baidu.swan.apps.core.a.hY(str);
        }
        return ag.toFileUriString(str);
    }

    public String YA() {
        YH();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.PK()) {
            y(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.TG()) {
            return com.baidu.swan.apps.console.debugger.a.e.TK();
        } else {
            com.baidu.swan.apps.core.a.hY(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YB() {
        if (!this.bQY.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bQY.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bSM);
                }
                a(next);
            }
            this.bQY.clear();
        }
    }

    public boolean YC() {
        return this.bQR instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a YD() {
        return this.bQR;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YE() {
        synchronized (this.bQZ) {
            if (!this.bQS && this.bQR == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.bQR = this.bRd.h(getContext(), YF() ? 1 : 0);
                f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.bQR.loadUrl(Yz());
                this.bQR.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void fe(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bQZ) {
                            d.this.bQS = true;
                            d.this.YB();
                            d.this.Yw();
                        }
                    }
                });
            }
        }
    }

    private boolean YF() {
        if (com.baidu.swan.apps.console.debugger.a.e.TG() || com.baidu.swan.apps.w.a.aca().PK()) {
            return false;
        }
        return b.Pf() && new File(Yx()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void YG() {
        if (!this.bQU && this.bQT == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.bQT = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void fe(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bQU = true;
                    d.this.Yw();
                }
            });
            YM();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bh = this.bRd.bh(context);
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.Ya()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String YA = YA();
                com.baidu.swan.apps.core.slave.a.XW().a(YA, new a.InterfaceC0284a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0284a
                    public void iE(final String str) {
                        ai.o(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bh.loadDataWithBaseURL(YA, str, "text/html", "utf-8", YA);
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
                bh.loadUrl(YA());
            }
            bh.a(bVar);
            return bh;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bG(context);
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
    public void YH() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gG(0));
        }
    }

    public SwanCoreVersion YI() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore YJ() {
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
    public void YK() {
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
            this.mExtensionCore = bVar.YJ();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bQX.put(eVar.QG(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String QG = eVar.QG();
        this.bQX.remove(QG);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", QG);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e iI(String str) {
        if (this.bQX.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bQX.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bQZ) {
            if (!this.bQS) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bSM)));
                }
                this.bQY.add(aVar);
            } else if (this.bQR != null) {
                com.baidu.swan.apps.n.a.a(this.bQR.Rs(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bQX.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.QE(), aVar);
    }

    @Nullable
    public String YL() {
        YM();
        return this.bRa;
    }

    private void YM() {
        if (TextUtils.isEmpty(this.bRa)) {
            this.bRa = this.bQT != null ? this.bQT.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bRa);
            }
        }
    }

    public void dx(boolean z) {
        if (z && this.bQR != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bQZ) {
                this.bQS = true;
                YB();
                Yw();
            }
        } else if (!z && this.bQT != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.lb("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bQU = true;
            Yw();
        }
    }

    public void dy(boolean z) {
        this.bQW = z;
    }

    public boolean YN() {
        return this.bQW;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean bRn = com.baidu.swan.apps.w.a.abR().Pf();
        private static boolean bRo = bRn;

        public static void E(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                bRn = intent.getBooleanExtra("bundle_key_v8_ab", bRn);
            }
        }

        public static void YO() {
            bRo = bRn;
        }

        public static String YP() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Pf() {
            if (d.DEBUG) {
                String YP = YP();
                char c = 65535;
                switch (YP.hashCode()) {
                    case -1406842887:
                        if (YP.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (YP.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (YP.equals("V8")) {
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
            return bRo;
        }
    }
}
