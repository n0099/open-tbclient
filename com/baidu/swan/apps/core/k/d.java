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
    private static int bsI = 10150;
    public static boolean bsJ = false;
    private static volatile d bsw;
    private boolean bsA;
    private com.baidu.swan.apps.adaptation.b.c bsB;
    private boolean bsC;
    private boolean bsD;
    private HashMap<String, e> bsE;
    private String bsH;
    private am bsK;
    private i bsL;
    private com.baidu.swan.apps.core.container.a.b bsx;
    private com.baidu.swan.apps.core.g.a bsz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private List<a> bsy = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bsF = new LinkedList<>();
    private final Object bsG = new Object();

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bsE = new HashMap<>();
        this.bsK = new com.baidu.swan.apps.adaptation.b.a.b();
        this.bsL = com.baidu.swan.apps.adaptation.b.a.c.IY().IZ().IW();
    }

    public static d Qw() {
        if (bsw == null) {
            synchronized (d.class) {
                if (bsw == null) {
                    bsw = new d();
                }
            }
        }
        return bsw;
    }

    public am Qx() {
        return this.bsK;
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
            if (bsw != null) {
                bsw.mIsReleased = true;
                bsJ = false;
                if (bsw.bsx != null) {
                    bsw.bsL.b(bsw.bsx);
                }
                com.baidu.swan.apps.api.module.l.d.Kf();
                com.baidu.swan.apps.swancore.b.a.afx();
                Qy();
                com.baidu.swan.apps.y.i.b(bsw);
                bsw = null;
                if (a.b.Qi()) {
                    com.baidu.swan.apps.core.slave.a.Qe().clear();
                }
                Qw().Qz();
            }
        }
    }

    private static void Qy() {
        if (bsw.bsE != null) {
            for (e eVar : ((HashMap) bsw.bsE.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bsw.bsz != null) {
            if (bsw.bsz instanceof com.baidu.swan.apps.core.g.e) {
                bsw.bsz.destroy();
            }
            bsw.bsz = null;
        }
        if (bsw.bsB != null) {
            bsw.bsB = null;
        }
    }

    private void Qz() {
        E(null);
    }

    public void E(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (QB()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        bsJ = true;
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
            com.baidu.swan.apps.w.a.Ut().dS(intent.getIntExtra("bundle_key_preload_switch", bsI));
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
        b.QW();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.agE();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.q(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).gh(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aaV().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.QQ();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.QQ());
        }
        e(bVar);
        f(bVar);
        f.ZV().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.aeH().lC("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.mIsReleased) {
                            f.jP("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.aeH().lC("na_pre_load_ok");
                            f.bd("preload", "startup");
                            if (d.this.bsz != null && d.this.bsB != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.bsz, d.this.bsB, bVar, fVar);
                                d.this.bsB = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bsy.contains(aVar)) {
            this.bsy.add(aVar);
        }
        boolean QB = QB();
        f.ZV().bb("preload", QB ? "1" : "0");
        if (QB) {
            QE();
            return;
        }
        f.jP("preload").f(new UbcFlowEvent("na_pre_load_start"));
        QP();
        if (a.b.Qi()) {
            com.baidu.swan.apps.core.slave.a.Qe().a(QI(), (a.InterfaceC0254a) null);
        }
        if (QN()) {
            QM();
        }
        if (this.bsx == null) {
            this.bsx = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Hd() {
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
                            d.this.QP();
                            d.this.QS();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.QM();
                                d.this.QO();
                                return;
                            }
                            d.this.QA();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.bsL.a(this.bsx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QA() {
        synchronized (this.bsG) {
            this.bsA = false;
            this.bsz = null;
        }
        this.bsC = false;
        this.bsB = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gQ(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", QK());
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
        new a.C0297a(10001).lE(com.baidu.swan.apps.runtime.e.acF() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.acF().getAppKey()).lF(jSONObject.toString()).Wm();
    }

    public boolean QB() {
        boolean z;
        synchronized (this.bsG) {
            z = this.bsA && this.bsC;
        }
        return z;
    }

    public boolean QC() {
        boolean z;
        synchronized (this.bsG) {
            z = this.bsA;
        }
        return z;
    }

    public boolean QD() {
        boolean z;
        synchronized (this.bsG) {
            z = this.bsC;
        }
        return z;
    }

    public void QE() {
        if (!this.bsy.isEmpty() && QB()) {
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bsy) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bsy.clear();
        }
    }

    private String t(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.q(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String QF() {
        return !TextUtils.isEmpty(QG()) ? QG() + "runtime/index.js" : "";
    }

    public String QG() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String QH() {
        String str;
        QP();
        if (QK()) {
            str = QF();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.HV()) {
            t(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.LP()) {
            com.baidu.swan.apps.console.debugger.a.d.LM();
            com.baidu.swan.apps.console.debugger.a.d.LI().gD("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.LS();
        } else {
            com.baidu.swan.apps.core.a.gL(str);
        }
        return ag.toFileUriString(str);
    }

    public String QI() {
        QP();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.HV()) {
            t(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.LP()) {
            return com.baidu.swan.apps.console.debugger.a.e.LT();
        } else {
            com.baidu.swan.apps.core.a.gL(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QJ() {
        if (!this.bsF.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bsF.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.buu);
                }
                a(next);
            }
            this.bsF.clear();
        }
    }

    public boolean QK() {
        return this.bsz instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a QL() {
        return this.bsz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        synchronized (this.bsG) {
            if (!this.bsA && this.bsz == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.bsz = this.bsK.n(getContext(), QN() ? 1 : 0);
                f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.bsz.loadUrl(QH());
                this.bsz.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void em(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bsG) {
                            d.this.bsA = true;
                            d.this.QJ();
                            d.this.QE();
                        }
                    }
                });
            }
        }
    }

    private boolean QN() {
        if (com.baidu.swan.apps.console.debugger.a.e.LP() || com.baidu.swan.apps.w.a.Ui().HV()) {
            return false;
        }
        return b.Hn() && new File(QF()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QO() {
        if (!this.bsC && this.bsB == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.bsB = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void em(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bsC = true;
                    d.this.QE();
                }
            });
            QU();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bu = this.bsK.bu(context);
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.Qi()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String QI = QI();
                com.baidu.swan.apps.core.slave.a.Qe().a(QI, new a.InterfaceC0254a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0254a
                    public void hr(final String str) {
                        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bu.loadDataWithBaseURL(QI, str, "text/html", "utf-8", QI);
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
                bu.loadUrl(QI());
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
    public void QP() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gz(0));
        }
    }

    public SwanCoreVersion QQ() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore QR() {
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
    public void QS() {
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
            this.mExtensionCore = bVar.QR();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bsE.put(eVar.IR(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String IR = eVar.IR();
        this.bsE.remove(IR);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", IR);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e hv(String str) {
        if (this.bsE.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bsE.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bsG) {
            if (!this.bsA) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.buu)));
                }
                this.bsF.add(aVar);
            } else if (this.bsz != null) {
                com.baidu.swan.apps.n.a.a(this.bsz.JD(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bsE.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.IP(), aVar);
    }

    @Nullable
    public String QT() {
        QU();
        return this.bsH;
    }

    private void QU() {
        if (TextUtils.isEmpty(this.bsH)) {
            this.bsH = this.bsB != null ? this.bsB.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bsH);
            }
        }
    }

    public void cA(boolean z) {
        if (z && this.bsz != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bsG) {
                this.bsA = true;
                QJ();
                QE();
            }
        } else if (!z && this.bsB != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.jP("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bsC = true;
            QE();
        }
    }

    public void cB(boolean z) {
        this.bsD = z;
    }

    public boolean QV() {
        return this.bsD;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean bsU = com.baidu.swan.apps.w.a.TZ().Hn();
        private static boolean bsV = bsU;

        public static void F(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                bsU = intent.getBooleanExtra("bundle_key_v8_ab", bsU);
            }
        }

        public static void QW() {
            bsV = bsU;
        }

        public static String QX() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Hn() {
            if (d.DEBUG) {
                String QX = QX();
                char c = 65535;
                switch (QX.hashCode()) {
                    case -1406842887:
                        if (QX.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (QX.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (QX.equals("V8")) {
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
            return bsV;
        }
    }
}
