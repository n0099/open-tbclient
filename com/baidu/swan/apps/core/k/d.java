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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bsG = 10150;
    public static boolean bsH = false;
    private static volatile d bsu;
    private boolean bsA;
    private boolean bsB;
    private HashMap<String, e> bsC;
    private String bsF;
    private am bsI;
    private i bsJ;
    private com.baidu.swan.apps.core.container.a.b bsv;
    private com.baidu.swan.apps.core.g.a bsx;
    private boolean bsy;
    private com.baidu.swan.apps.adaptation.b.c bsz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private List<a> bsw = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bsD = new LinkedList<>();
    private final Object bsE = new Object();

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bsC = new HashMap<>();
        this.bsI = new com.baidu.swan.apps.adaptation.b.a.b();
        this.bsJ = com.baidu.swan.apps.adaptation.b.a.c.IW().IX().IU();
    }

    public static d Qu() {
        if (bsu == null) {
            synchronized (d.class) {
                if (bsu == null) {
                    bsu = new d();
                }
            }
        }
        return bsu;
    }

    public am Qv() {
        return this.bsI;
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
            if (bsu != null) {
                bsu.mIsReleased = true;
                bsH = false;
                if (bsu.bsv != null) {
                    bsu.bsJ.b(bsu.bsv);
                }
                com.baidu.swan.apps.api.module.l.d.Kd();
                com.baidu.swan.apps.swancore.b.a.afv();
                Qw();
                com.baidu.swan.apps.y.i.b(bsu);
                bsu = null;
                if (a.b.Qg()) {
                    com.baidu.swan.apps.core.slave.a.Qc().clear();
                }
                Qu().Qx();
            }
        }
    }

    private static void Qw() {
        if (bsu.bsC != null) {
            for (e eVar : ((HashMap) bsu.bsC.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bsu.bsx != null) {
            if (bsu.bsx instanceof com.baidu.swan.apps.core.g.e) {
                bsu.bsx.destroy();
            }
            bsu.bsx = null;
        }
        if (bsu.bsz != null) {
            bsu.bsz = null;
        }
    }

    private void Qx() {
        E(null);
    }

    public void E(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Qz()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        bsH = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.gz(0);
            extensionCore = com.baidu.swan.apps.extcore.b.eO(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.w.a.Ur().dS(intent.getIntExtra("bundle_key_preload_switch", bsG));
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
        b.QU();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.agC();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.q(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).gh(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aaT().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.QO();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.QO());
        }
        e(bVar);
        f(bVar);
        f.ZT().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.aeF().lC("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.mIsReleased) {
                            f.jP("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.aeF().lC("na_pre_load_ok");
                            f.bd("preload", "startup");
                            if (d.this.bsx != null && d.this.bsz != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.bsx, d.this.bsz, bVar, fVar);
                                d.this.bsz = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bsw.contains(aVar)) {
            this.bsw.add(aVar);
        }
        boolean Qz = Qz();
        f.ZT().bb("preload", Qz ? "1" : "0");
        if (Qz) {
            QC();
            return;
        }
        f.jP("preload").f(new UbcFlowEvent("na_pre_load_start"));
        QN();
        if (a.b.Qg()) {
            com.baidu.swan.apps.core.slave.a.Qc().a(QG(), (a.InterfaceC0254a) null);
        }
        if (QL()) {
            QK();
        }
        if (this.bsv == null) {
            this.bsv = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Hb() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.jP("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
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
                            d.this.QN();
                            d.this.QQ();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.QK();
                                d.this.QM();
                                return;
                            }
                            d.this.Qy();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.bsJ.a(this.bsv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qy() {
        synchronized (this.bsE) {
            this.bsy = false;
            this.bsx = null;
        }
        this.bsA = false;
        this.bsz = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gQ(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", QI());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion gz = com.baidu.swan.apps.swancore.b.gz(0);
            jSONObject.put("swan app core", gz == null ? "null" : Long.valueOf(gz.swanCoreVersion));
            SwanCoreVersion gz2 = com.baidu.swan.apps.swancore.b.gz(1);
            jSONObject.put("swan game core", gz2 == null ? "null" : Long.valueOf(gz2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0297a(10001).lE(com.baidu.swan.apps.runtime.e.acD() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.acD().getAppKey()).lF(jSONObject.toString()).Wk();
    }

    public boolean Qz() {
        boolean z;
        synchronized (this.bsE) {
            z = this.bsy && this.bsA;
        }
        return z;
    }

    public boolean QA() {
        boolean z;
        synchronized (this.bsE) {
            z = this.bsy;
        }
        return z;
    }

    public boolean QB() {
        boolean z;
        synchronized (this.bsE) {
            z = this.bsA;
        }
        return z;
    }

    public void QC() {
        if (!this.bsw.isEmpty() && Qz()) {
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bsw) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bsw.clear();
        }
    }

    private String t(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.q(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String QD() {
        return !TextUtils.isEmpty(QE()) ? QE() + "runtime/index.js" : "";
    }

    public String QE() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String QF() {
        String str;
        QN();
        if (QI()) {
            str = QD();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.HT()) {
            t(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.LN()) {
            com.baidu.swan.apps.console.debugger.a.d.LK();
            com.baidu.swan.apps.console.debugger.a.d.LG().gD("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.LQ();
        } else {
            com.baidu.swan.apps.core.a.gL(str);
        }
        return ag.toFileUriString(str);
    }

    public String QG() {
        QN();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.HT()) {
            t(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.LN()) {
            return com.baidu.swan.apps.console.debugger.a.e.LR();
        } else {
            com.baidu.swan.apps.core.a.gL(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QH() {
        if (!this.bsD.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bsD.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bus);
                }
                a(next);
            }
            this.bsD.clear();
        }
    }

    public boolean QI() {
        return this.bsx instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a QJ() {
        return this.bsx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QK() {
        synchronized (this.bsE) {
            if (!this.bsy && this.bsx == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.bsx = this.bsI.n(getContext(), QL() ? 1 : 0);
                f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.bsx.loadUrl(QF());
                this.bsx.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void em(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bsE) {
                            d.this.bsy = true;
                            d.this.QH();
                            d.this.QC();
                        }
                    }
                });
            }
        }
    }

    private boolean QL() {
        if (com.baidu.swan.apps.console.debugger.a.e.LN() || com.baidu.swan.apps.w.a.Ug().HT()) {
            return false;
        }
        return b.Hl() && new File(QD()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        if (!this.bsA && this.bsz == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.bsz = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void em(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bsA = true;
                    d.this.QC();
                }
            });
            QS();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bu = this.bsI.bu(context);
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.Qg()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String QG = QG();
                com.baidu.swan.apps.core.slave.a.Qc().a(QG, new a.InterfaceC0254a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0254a
                    public void hr(final String str) {
                        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bu.loadDataWithBaseURL(QG, str, "text/html", "utf-8", QG);
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
                bu.loadUrl(QG());
            }
            bu.a(bVar);
            return bu;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bT(context);
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
    public void QN() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gz(0));
        }
    }

    public SwanCoreVersion QO() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore QP() {
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
    public void QQ() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.eO(0));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.QP();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bsC.put(eVar.IP(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String IP = eVar.IP();
        this.bsC.remove(IP);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", IP);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        if (this.bsC.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bsC.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bsE) {
            if (!this.bsy) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bus)));
                }
                this.bsD.add(aVar);
            } else if (this.bsx != null) {
                com.baidu.swan.apps.n.a.a(this.bsx.JB(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bsC.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.IN(), aVar);
    }

    @Nullable
    public String QR() {
        QS();
        return this.bsF;
    }

    private void QS() {
        if (TextUtils.isEmpty(this.bsF)) {
            this.bsF = this.bsz != null ? this.bsz.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bsF);
            }
        }
    }

    public void cA(boolean z) {
        if (z && this.bsx != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bsE) {
                this.bsy = true;
                QH();
                QC();
            }
        } else if (!z && this.bsz != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bsA = true;
            QC();
        }
    }

    public void cB(boolean z) {
        this.bsB = z;
    }

    public boolean QT() {
        return this.bsB;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean bsS = com.baidu.swan.apps.w.a.TX().Hl();
        private static boolean bsT = bsS;

        public static void F(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                bsS = intent.getBooleanExtra("bundle_key_v8_ab", bsS);
            }
        }

        public static void QU() {
            bsT = bsS;
        }

        public static String QV() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Hl() {
            if (d.DEBUG) {
                String QV = QV();
                char c = 65535;
                switch (QV.hashCode()) {
                    case -1406842887:
                        if (QV.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (QV.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (QV.equals("V8")) {
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
            return bsT;
        }
    }
}
