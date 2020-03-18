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
    private static volatile d bsI;
    private com.baidu.swan.apps.core.container.a.b bsJ;
    private com.baidu.swan.apps.core.g.a bsL;
    private boolean bsM;
    private com.baidu.swan.apps.adaptation.b.c bsN;
    private boolean bsO;
    private boolean bsP;
    private HashMap<String, e> bsQ;
    private String bsT;
    private am bsW;
    private i bsX;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int bsU = 10150;
    public static boolean bsV = false;
    private List<a> bsK = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.n.a.a> bsR = new LinkedList<>();
    private final Object bsS = new Object();

    /* loaded from: classes11.dex */
    public interface a {
        void onReady();
    }

    private d() {
        com.baidu.swan.apps.y.i.a(this);
        this.bsQ = new HashMap<>();
        this.bsW = new com.baidu.swan.apps.adaptation.b.a.b();
        this.bsX = com.baidu.swan.apps.adaptation.b.a.c.Jb().Jc().IZ();
    }

    public static d Qz() {
        if (bsI == null) {
            synchronized (d.class) {
                if (bsI == null) {
                    bsI = new d();
                }
            }
        }
        return bsI;
    }

    public am QA() {
        return this.bsW;
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
            if (bsI != null) {
                bsI.mIsReleased = true;
                bsV = false;
                if (bsI.bsJ != null) {
                    bsI.bsX.b(bsI.bsJ);
                }
                com.baidu.swan.apps.api.module.l.d.Ki();
                com.baidu.swan.apps.swancore.b.a.afA();
                QB();
                com.baidu.swan.apps.y.i.b(bsI);
                bsI = null;
                if (a.b.Ql()) {
                    com.baidu.swan.apps.core.slave.a.Qh().clear();
                }
                Qz().QC();
            }
        }
    }

    private static void QB() {
        if (bsI.bsQ != null) {
            for (e eVar : ((HashMap) bsI.bsQ.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (bsI.bsL != null) {
            if (bsI.bsL instanceof com.baidu.swan.apps.core.g.e) {
                bsI.bsL.destroy();
            }
            bsI.bsL = null;
        }
        if (bsI.bsN != null) {
            bsI.bsN = null;
        }
    }

    private void QC() {
        E(null);
    }

    public void E(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (QE()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        bsV = true;
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
            com.baidu.swan.apps.w.a.Uw().dS(intent.getIntExtra("bundle_key_preload_switch", bsU));
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
        b.QZ();
        m.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.1
            @Override // java.lang.Runnable
            public void run() {
                g.agH();
            }
        }, "prepare ab description");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.2
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.q(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).gh(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aaY().sendMessage(14);
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
            this.mSwanCoreVersion = bVar.QT();
        }
    }

    public void a(final com.baidu.swan.apps.x.b.b bVar, final e.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.QT());
        }
        e(bVar);
        f(bVar);
        f.ZY().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.an.a.aeK().lB("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.k.d.3
            @Override // com.baidu.swan.apps.core.k.d.a
            public void onReady() {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.3.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!d.this.mIsReleased) {
                            f.jO("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.an.a.aeK().lB("na_pre_load_ok");
                            f.bc("preload", "startup");
                            if (d.this.bsL != null && d.this.bsN != null) {
                                com.baidu.swan.apps.scheme.actions.k.c.a(d.this.bsL, d.this.bsN, bVar, fVar);
                                d.this.bsN = null;
                            }
                            f.h(bVar);
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.bsK.contains(aVar)) {
            this.bsK.add(aVar);
        }
        boolean QE = QE();
        f.ZY().ba("preload", QE ? "1" : "0");
        if (QE) {
            QH();
            return;
        }
        f.jO("preload").f(new UbcFlowEvent("na_pre_load_start"));
        QS();
        if (a.b.Ql()) {
            com.baidu.swan.apps.core.slave.a.Qh().a(QL(), (a.InterfaceC0254a) null);
        }
        if (QQ()) {
            QP();
        }
        if (this.bsJ == null) {
            this.bsJ = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.k.d.4
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Hi() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.jO("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
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
                            d.this.QS();
                            d.this.QV();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.QP();
                                d.this.QR();
                                return;
                            }
                            d.this.QD();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.bsX.a(this.bsJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QD() {
        synchronized (this.bsS) {
            this.bsM = false;
            this.bsL = null;
        }
        this.bsO = false;
        this.bsN = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.gQ(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", QN());
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
        new a.C0297a(10001).lD(com.baidu.swan.apps.runtime.e.acI() == null ? "null appkey" : com.baidu.swan.apps.runtime.e.acI().getAppKey()).lE(jSONObject.toString()).Wp();
    }

    public boolean QE() {
        boolean z;
        synchronized (this.bsS) {
            z = this.bsM && this.bsO;
        }
        return z;
    }

    public boolean QF() {
        boolean z;
        synchronized (this.bsS) {
            z = this.bsM;
        }
        return z;
    }

    public boolean QG() {
        boolean z;
        synchronized (this.bsS) {
            z = this.bsO;
        }
        return z;
    }

    public void QH() {
        if (!this.bsK.isEmpty() && QE()) {
            f.jO("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (a aVar : this.bsK) {
                if (aVar != null) {
                    aVar.onReady();
                }
            }
            this.bsK.clear();
        }
    }

    private String t(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.q(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String QI() {
        return !TextUtils.isEmpty(QJ()) ? QJ() + "runtime/index.js" : "";
    }

    public String QJ() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String QK() {
        String str;
        QS();
        if (QN()) {
            str = QI();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.HY()) {
            t(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.LS()) {
            com.baidu.swan.apps.console.debugger.a.d.LP();
            com.baidu.swan.apps.console.debugger.a.d.LL().gC("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.LV();
        } else {
            com.baidu.swan.apps.core.a.gK(str);
        }
        return ag.toFileUriString(str);
    }

    public String QL() {
        QS();
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.HY()) {
            t(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.LS()) {
            return com.baidu.swan.apps.console.debugger.a.e.LW();
        } else {
            com.baidu.swan.apps.core.a.gK(str);
        }
        return ag.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QM() {
        if (!this.bsR.isEmpty()) {
            Iterator<com.baidu.swan.apps.n.a.a> it = this.bsR.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.n.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.buG);
                }
                a(next);
            }
            this.bsR.clear();
        }
    }

    public boolean QN() {
        return this.bsL instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a QO() {
        return this.bsL;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QP() {
        synchronized (this.bsS) {
            if (!this.bsM && this.bsL == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.jO("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.bsL = this.bsW.n(getContext(), QQ() ? 1 : 0);
                f.jO("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.bsL.loadUrl(QK());
                this.bsL.a(new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.5
                    @Override // com.baidu.swan.apps.core.b
                    public void el(String str) {
                        if (d.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.jO("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.bsS) {
                            d.this.bsM = true;
                            d.this.QM();
                            d.this.QH();
                        }
                    }
                });
            }
        }
    }

    private boolean QQ() {
        if (com.baidu.swan.apps.console.debugger.a.e.LS() || com.baidu.swan.apps.w.a.Ul().HY()) {
            return false;
        }
        return b.Hs() && new File(QI()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void QR() {
        if (!this.bsO && this.bsN == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.jO("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.bsN = a(getContext(), new com.baidu.swan.apps.core.b() { // from class: com.baidu.swan.apps.core.k.d.6
                @Override // com.baidu.swan.apps.core.b
                public void el(String str) {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.jO("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.bsO = true;
                    d.this.QH();
                }
            });
            QX();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, com.baidu.swan.apps.core.b bVar) {
        try {
            final com.baidu.swan.apps.adaptation.b.c bt = this.bsW.bt(context);
            f.jO("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            if (a.b.Ql()) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData");
                }
                final String QL = QL();
                com.baidu.swan.apps.core.slave.a.Qh().a(QL, new a.InterfaceC0254a() { // from class: com.baidu.swan.apps.core.k.d.7
                    @Override // com.baidu.swan.apps.core.slave.a.InterfaceC0254a
                    public void hq(final String str) {
                        ai.l(new Runnable() { // from class: com.baidu.swan.apps.core.k.d.7.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", "prepareSlave loadData start");
                                }
                                bt.loadDataWithBaseURL(QL, str, "text/html", "utf-8", QL);
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
                bt.loadUrl(QL());
            }
            bt.a(bVar);
            return bt;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.a.bS(context);
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
    public void QS() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.gz(0));
        }
    }

    public SwanCoreVersion QT() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore QU() {
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
    public void QV() {
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
            this.mExtensionCore = bVar.QU();
        }
    }

    @Override // com.baidu.swan.apps.y.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.bsQ.put(eVar.IU(), eVar);
    }

    @Override // com.baidu.swan.apps.y.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.y.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String IU = eVar.IU();
        this.bsQ.remove(IU);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", IU);
            a(new com.baidu.swan.apps.n.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e hu(String str) {
        if (this.bsQ.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.bsQ.get(str);
    }

    public void a(com.baidu.swan.apps.n.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.bsS) {
            if (!this.bsM) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.buG)));
                }
                this.bsR.add(aVar);
            } else if (this.bsL != null) {
                com.baidu.swan.apps.n.a.a(this.bsL.JG(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.n.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.bsQ.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.n.a.a(eVar.IS(), aVar);
    }

    @Nullable
    public String QW() {
        QX();
        return this.bsT;
    }

    private void QX() {
        if (TextUtils.isEmpty(this.bsT)) {
            this.bsT = this.bsN != null ? this.bsN.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.bsT);
            }
        }
    }

    public void cB(boolean z) {
        if (z && this.bsL != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            f.jO("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.bsS) {
                this.bsM = true;
                QM();
                QH();
            }
        } else if (!z && this.bsN != null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            f.jO("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.bsO = true;
            QH();
        }
    }

    public void cC(boolean z) {
        this.bsP = z;
    }

    public boolean QY() {
        return this.bsP;
    }

    /* loaded from: classes11.dex */
    public static class b {
        private static boolean btg = com.baidu.swan.apps.w.a.Uc().Hs();
        private static boolean bth = btg;

        public static void F(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                btg = intent.getBooleanExtra("bundle_key_v8_ab", btg);
            }
        }

        public static void QZ() {
            bth = btg;
        }

        public static String Ra() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Hs() {
            if (d.DEBUG) {
                String Ra = Ra();
                char c = 65535;
                switch (Ra.hashCode()) {
                    case -1406842887:
                        if (Ra.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Ra.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Ra.equals("V8")) {
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
            return bth;
        }
    }
}
