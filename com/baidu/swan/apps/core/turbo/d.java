package com.baidu.swan.apps.core.turbo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.searchbox.ui.CoolPraiseGuideLottieView;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.ba;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.g;
import com.baidu.swan.apps.core.g.a.e;
import com.baidu.swan.apps.core.h.a;
import com.baidu.swan.apps.core.prefetch.PrefetchEvent;
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
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public final class d implements h {
    private static volatile d cBQ;
    private com.baidu.swan.apps.core.container.a.b cBR;
    private e cBT;
    private boolean cBU;
    private com.baidu.swan.apps.adaptation.b.c cBV;
    private boolean cBW;
    private boolean cBX;
    private boolean cBY;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cBZ;
    private String cCc;
    private b cCh;
    private ba cCi;
    private i cCj;
    private com.baidu.swan.apps.core.g.a cyf;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cCd = 10150;
    public static boolean cCe = false;
    private static PreloadState cCf = PreloadState.UNKNOWN;
    private static boolean cCg = false;
    private static final boolean cCl = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> cBS = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cyp = new LinkedList<>();
    private final Object cCa = new Object();
    private final String cCb = UUID.randomUUID().toString();
    private volatile boolean cCk = false;

    private static PreloadState ank() {
        return cCf;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> anl() {
        return this.cBZ;
    }

    public static int anm() {
        return ank().statsCode(cCg);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cBZ = new HashMap<>();
        this.cCi = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cCj = com.baidu.swan.apps.adaptation.b.a.c.aey().aez().aew();
        if (cCl) {
            this.cBT = new e();
        }
    }

    public static d ann() {
        if (cBQ == null) {
            synchronized (d.class) {
                if (cBQ == null) {
                    cBQ = new d();
                }
            }
        }
        return cBQ;
    }

    public ba ano() {
        return this.cCi;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void anp() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void anq() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.azK()) {
                com.baidu.swan.apps.runtime.d.aCW().aCR().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cBQ == null || cBQ.anw()) {
                    com.baidu.swan.apps.runtime.d.aCW().aCR().sendMessage(15);
                    release(false);
                } else {
                    if (cBQ.cCh == null) {
                        cBQ.cCh = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aCW().getAppId());
                                com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aCW().aCR().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cBQ.a(cBQ.cCh);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cBQ != null) {
                cCf = PreloadState.UNKNOWN;
                cBQ.cBX = true;
                cBQ.cCh = null;
                cCe = false;
                if (z2) {
                    c.anX();
                    copyOnWriteArrayList = c.anW();
                }
                if (cBQ.cBR != null) {
                    cBQ.cCj.b(cBQ.cBR);
                }
                com.baidu.swan.apps.api.module.l.e.afT();
                com.baidu.swan.apps.swancore.a.a.aGE();
                anr();
                com.baidu.swan.apps.v.i.b(cBQ);
                cBQ = null;
                com.baidu.swan.apps.core.h.b.amB().reset();
                cCg = z;
                ann().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void anr() {
        if (cBQ.cBZ != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cBQ.cBZ.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        ans();
        if (cBQ.cBV != null) {
            cBQ.cBV = null;
        }
    }

    private static void ans() {
        if (cCl) {
            if (cBQ.cBT != null) {
                cBQ.cBT.reset();
            }
        } else if (cBQ.cyf != null) {
            if (cBQ.cyf instanceof com.baidu.swan.apps.core.g.e) {
                cBQ.cyf.destroy();
            }
            cBQ.cyf = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (anv()) {
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cCe = true;
        com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        mY("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.kl(0);
            extensionCore = com.baidu.swan.apps.extcore.b.id(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.asD().gW(intent.getIntExtra("bundle_key_preload_switch", cCd));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            mY("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0408d.aoc();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aHX();
            }
        }, "prepare ab description");
        if (anF()) {
            f aTu = com.baidu.swan.games.utils.so.d.aTu();
            if (!aTu.isSuccess() && !aTu.aTE()) {
                mY("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            ant();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void ant() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).jR(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.anP();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aAU().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cBS == null) {
            this.cBS = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cBS.contains(next)) {
                this.cBS.add(next);
            }
        }
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.7
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(d dVar) {
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: retry successfully.");
                }
            }

            @NonNull
            public String toString() {
                return "retry" + super.toString();
            }
        });
    }

    private void mY(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cCf.statsCode(cCg));
        com.baidu.swan.apps.runtime.d.aCW().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.anI();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.anI());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.azm().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aFy().sk("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cBX) {
                            com.baidu.swan.apps.performance.i.qc("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aFy().sk("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.cd("preload", "startup");
                            d.this.a(dVar, bVar, fVar);
                            com.baidu.swan.apps.performance.i.a(bVar, false);
                        }
                    }
                });
            }

            @NonNull
            public String toString() {
                return "startFirstPage " + super.toString();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(d dVar, com.baidu.swan.apps.u.c.b bVar, d.f fVar) {
        com.baidu.swan.apps.core.g.a aVar;
        if (cCl) {
            e eVar = dVar.cBT;
            aVar = eVar.alG() ? eVar.mD(bVar.getAppId()).alD() : null;
        } else {
            aVar = dVar.cyf;
        }
        if (aVar != null && dVar.cBV != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cBV, bVar, fVar);
            dVar.cBV = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cyf != null) + " startFirstPage mSlaveManager " + (dVar.cBV != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cBV != null) {
                    if (a.C0400a.amA()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.avu(), eVar.abu(), eVar.aDj());
                        SwanAppConfigData aDj = eVar.aDj();
                        equals = "main".equals(aDj != null ? aDj.rs(a2) : null);
                    }
                    if (equals && eVar.aDj() != null) {
                        com.baidu.swan.apps.core.h.b.amB().a(d.cCl ? d.this.cBT.mD(eVar.getAppId()).alD() : d.this.cyf, d.this.cBV, eVar.abu(), eVar.aDj(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cBS.contains(bVar)) {
            this.cBS.add(bVar);
        }
        boolean anv = anv();
        com.baidu.swan.apps.performance.i.azm().cb("preload", anv ? "1" : "0");
        com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "prepareRuntime preload = " + anv);
        if (anv) {
            any();
            return;
        }
        cCf = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_start"));
        anH();
        final boolean anF = anF();
        if (anF) {
            f aTu = com.baidu.swan.games.utils.so.d.aTu();
            if (!aTu.isSuccess() && aTu.aTE()) {
                anF = false;
            }
        }
        com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "useV8Master:" + anF);
        if (anF) {
            eC(true);
        }
        if (this.cBR == null) {
            this.cBR = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void abS() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cBX);
                            }
                            if (d.this.cBX) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.anH();
                            d.this.anK();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.eC(anF);
                                d.this.anG();
                                return;
                            }
                            PreloadState unused = d.cCf = PreloadState.LOAD_FAILED;
                            d.this.anu();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cCj.a(this.cBR);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anu() {
        synchronized (this.cCa) {
            this.cBU = false;
            if (cCl) {
                this.cBT.reset();
            } else {
                this.cyf = null;
            }
        }
        this.cBW = false;
        this.cBV = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.kC(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", alL());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion kl = com.baidu.swan.apps.swancore.b.kl(0);
            jSONObject.put("swan app core", kl == null ? "null" : Long.valueOf(kl.swanCoreVersion));
            SwanCoreVersion kl2 = com.baidu.swan.apps.swancore.b.kl(1);
            jSONObject.put("swan game core", kl2 == null ? "null" : Long.valueOf(kl2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).so(com.baidu.swan.apps.runtime.e.aDa() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aDa().getAppKey()).sp(jSONObject.toString()).apw();
    }

    public boolean anv() {
        boolean z;
        synchronized (this.cCa) {
            z = this.cBU && this.cBW;
        }
        return z;
    }

    public boolean anw() {
        boolean z;
        synchronized (this.cCa) {
            z = this.cBU;
        }
        return z;
    }

    public boolean anx() {
        boolean z;
        synchronized (this.cCa) {
            z = this.cBW;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void any() {
        if (!this.cBS.isEmpty() && anv()) {
            cCf = PreloadState.LOADED;
            c.anY();
            mY("event_preload_finish");
            com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cBS) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.M(this);
                }
            }
            this.cBS.clear();
        }
    }

    private String S(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.z(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String anz() {
        return !TextUtils.isEmpty(anA()) ? anA() + "runtime/index.js" : "";
    }

    public String anA() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String anB() {
        String str;
        anH();
        if (alL()) {
            str = anz();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.acJ()) {
            S(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.ahz()) {
            com.baidu.swan.apps.console.debugger.a.d.ahw();
            com.baidu.swan.apps.console.debugger.a.d.ahs().lO("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.ahC();
        } else {
            com.baidu.swan.apps.core.e.lX(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String anC() {
        anH();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.acJ()) {
            S(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.ahz()) {
            return com.baidu.swan.apps.console.debugger.a.e.ahD();
        } else {
            com.baidu.swan.apps.core.e.lX(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anD() {
        if (!this.cyp.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cyp.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cmp);
                }
                b(next);
            }
            this.cyp.clear();
        }
    }

    public boolean alL() {
        return cCl ? this.cBT.alL() : this.cyf instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a anE() {
        if (cCl) {
            if (!this.cBT.alI()) {
                return null;
            }
            return this.cBT.alJ().alD();
        }
        return this.cyf;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eC(boolean z) {
        boolean z2;
        synchronized (this.cCa) {
            if (cCl) {
                z2 = this.cBT.alH();
            } else {
                z2 = this.cyf != null;
            }
            if (!this.cBU && !z2) {
                com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cCl) {
                    this.cBT.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cCa) {
                                d.this.cBU = true;
                                d.this.anD();
                                d.this.any();
                            }
                        }
                    });
                    return;
                }
                this.cyf = this.cCi.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cyf.loadUrl(anB());
                this.cyf.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void hG(String str) {
                        com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cCa) {
                            d.this.cBU = true;
                            d.this.anD();
                            d.this.any();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a h = this.cCi.h(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        h.loadUrl(anB());
        h.a(gVar);
        return h;
    }

    private boolean anF() {
        if (com.baidu.swan.apps.console.debugger.a.e.ahz() || com.baidu.swan.apps.t.a.ass().acJ()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aTz() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aTz()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0408d.ace() && new File(anz()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anG() {
        if (!this.cBW && this.cBV == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cBV = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void hG(String str) {
                    com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cBW = true;
                    d.this.any();
                }
            });
            anM();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c bu = this.cCi.bu(context);
            com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String anC = anC();
            if (anC != null) {
                com.baidu.swan.apps.runtime.e aDb = com.baidu.swan.apps.runtime.e.aDb();
                if (aDb != null && !TextUtils.isEmpty(aDb.getAppKey())) {
                    anC = Uri.parse(anC).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aDb.getAppKey(), aDb.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!anC.endsWith(File.separator)) {
                        anC = anC + File.separator;
                    }
                }
                bu.loadUrl(anC);
            }
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "prepareSlave loadUrl " + anC);
            bu.a(gVar);
            return bu;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.bU(context);
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
    public void anH() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.kl(0));
        }
    }

    public SwanCoreVersion anI() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore anJ() {
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
    public void anK() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.id(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.anJ();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cBZ.put(eVar.aep(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String aep = eVar.aep();
        this.cBZ.remove(aep);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", aep);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e mZ(String str) {
        if (this.cBZ.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cBZ.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a afd;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cCa) {
            if (!this.cBU) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cmp)));
                }
                this.cyp.add(aVar);
                return;
            }
            if (cCl) {
                if (!this.cBT.alI()) {
                    this.cBT.a(aVar);
                    return;
                } else if (this.cBT.alJ() != null) {
                    afd = this.cBT.alJ().alD().afd();
                } else {
                    return;
                }
            } else if (this.cyf != null) {
                afd = this.cyf.afd();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cmp);
            }
            com.baidu.swan.apps.event.a.a(afd, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.mA(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cBZ.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.aen(), aVar);
    }

    @Nullable
    public String anL() {
        anM();
        return this.cCc;
    }

    private void anM() {
        if (TextUtils.isEmpty(this.cCc)) {
            this.cCc = this.cBV != null ? this.cBV.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bg("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cCc);
        }
    }

    public void eD(boolean z) {
        boolean z2;
        if (cCl) {
            z2 = this.cBT.alH();
        } else {
            z2 = this.cyf != null;
        }
        if (z && !this.cBU && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cCa) {
                this.cBU = true;
                anD();
                any();
            }
        } else if (!z && this.cBV != null && !this.cBW) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.qc("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cBW = true;
            any();
        }
    }

    public void eE(boolean z) {
        this.cBY = z;
    }

    public boolean anN() {
        return this.cBY;
    }

    public String anO() {
        return this.cCb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anP() {
        boolean z = true;
        if (this.cCk) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cCk = true;
        com.baidu.swan.apps.runtime.d aCW = com.baidu.swan.apps.runtime.d.aCW();
        z = (aCW == null || !aCW.aBj()) ? false : false;
        boolean acs = com.baidu.swan.apps.t.a.asi().acs();
        if (!z && acs) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bZ(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + acs);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cCl && com.baidu.swan.apps.core.prefetch.a.a.amy()) {
            this.cBT.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.bU(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes10.dex */
    public static abstract class b implements com.baidu.swan.apps.ap.e.b<d> {
        protected abstract void o(d dVar);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public void M(d dVar) {
            o(dVar);
        }
    }

    /* renamed from: com.baidu.swan.apps.core.turbo.d$d  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public static class C0408d {
        private static final boolean cCA;
        private static boolean cCB;
        private static boolean cCC;

        static {
            cCA = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.acD() : com.baidu.swan.apps.t.a.asi().acD();
            cCB = cCA ? true : com.baidu.swan.apps.t.a.asi().ace();
            cCC = cCB;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cCB = intent.getBooleanExtra("bundle_key_v8_ab", cCB);
            }
        }

        public static void aoc() {
            cCC = cCB;
        }

        public static String aod() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void na(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean ace() {
            if (d.DEBUG) {
                String aod = aod();
                char c = 65535;
                switch (aod.hashCode()) {
                    case -1406842887:
                        if (aod.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (aod.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (aod.equals("V8")) {
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
            return cCC;
        }

        public static boolean aoe() {
            String aod = aod();
            if (aod.equals("V8")) {
                return true;
            }
            if (aod.equals("AB")) {
                if (cCA) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.asi().ace();
            }
            return false;
        }

        public static String hV(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void eF(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aCW().aCS().aDt()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: is game frame, return.");
                    return;
                }
                return;
            }
            boolean hasCallbacks = com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.mRetryRunnable);
            if (!z && hasCallbacks) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isReuse " + z + ", return.");
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isRunning " + hasCallbacks + ", return.");
                }
            } else if (anv()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: f */
                    public void M(Boolean bool) {
                        d.this.hU(c.g(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hU(int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (mainHandler.hasCallbacks(c.mRetryRunnable)) {
            mainHandler.removeCallbacks(c.mRetryRunnable);
        }
        mainHandler.postDelayed(c.mRetryRunnable, i);
    }

    private void f(final com.baidu.swan.apps.ap.e.b<Boolean> bVar) {
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.4
            @Override // java.lang.Runnable
            public void run() {
                boolean adh = com.baidu.swan.apps.t.a.asE().adh();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + adh);
                }
                if (bVar != null) {
                    bVar.M(Boolean.valueOf(adh));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes10.dex */
    public static class c {
        private static final int cCv = a.anT();
        private static final int cCw = a.anU();
        private static int cCx = 0;
        private static int cCy = cCx;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cBQ.anv()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cCy >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cCz)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cCz, a.anV());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.anp();
                    c.a(new com.baidu.swan.apps.am.a().bX(5L).bY(49L).tt("start retry"));
                }
            }
        };
        private static final Runnable cCz = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cBQ.anv()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cCy >= 1) {
                    com.baidu.swan.apps.am.a tt = new com.baidu.swan.apps.am.a().bX(5L).bY(49L).tt("retry timeout");
                    c.a(tt);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), tt, 0, com.baidu.swan.apps.runtime.d.aCW().getAppId());
                    com.baidu.swan.apps.ap.e.N(com.baidu.swan.apps.runtime.d.aCW().aCU());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int abk;
            com.baidu.swan.apps.runtime.e aCS = com.baidu.swan.apps.runtime.d.aCW().aCS();
            if (aCS != null && (abk = aCS.abk()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aCS.abu()).sB(com.baidu.swan.apps.statistic.h.kd(abk)).sC(com.baidu.swan.apps.runtime.e.aDc()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> anW() {
            return new CopyOnWriteArrayList<>(d.cBQ.cBS);
        }

        static void anX() {
            cCy++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cCy);
            }
        }

        static void anY() {
            cCy = cCx;
        }

        public static int g(Boolean bool) {
            return bool.booleanValue() ? cCv : cCw;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static int cCu = -1;

        static int anS() {
            if (cCu < 0) {
                cCu = com.baidu.swan.apps.t.a.asi().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cCu;
        }

        public static boolean isEnable() {
            boolean z = anS() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int anT() {
            int i = com.baidu.swan.apps.t.a.asi().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int anU() {
            int i = com.baidu.swan.apps.t.a.asi().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int anV() {
            int i = com.baidu.swan.apps.t.a.asi().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
