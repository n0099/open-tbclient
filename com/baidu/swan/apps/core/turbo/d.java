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
import com.baidu.swan.apps.adaptation.b.e;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.ap.ai;
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.apps.core.g;
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
/* loaded from: classes7.dex */
public final class d implements h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cOI = 10150;
    public static boolean cOJ = false;
    private static PreloadState cOK = PreloadState.UNKNOWN;
    private static boolean cOL = false;
    private static final boolean cOQ = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private static volatile d cOv;
    private com.baidu.swan.apps.core.g.a cKK;
    private com.baidu.swan.apps.adaptation.b.c cOA;
    private boolean cOB;
    private boolean cOC;
    private boolean cOD;
    private final HashMap<String, e> cOE;
    private String cOH;
    private b cOM;
    private ba cON;
    private i cOO;
    private com.baidu.swan.apps.core.container.a.b cOw;
    private com.baidu.swan.apps.core.g.a.e cOy;
    private boolean cOz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private List<b> cOx = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cKU = new LinkedList<>();
    private final Object cOF = new Object();
    private final String cOG = UUID.randomUUID().toString();
    private volatile boolean cOP = false;

    private static PreloadState aqX() {
        return cOK;
    }

    @NonNull
    public HashMap<String, e> aqY() {
        return this.cOE;
    }

    public static int aqZ() {
        return aqX().statsCode(cOL);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cOE = new HashMap<>();
        this.cON = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cOO = com.baidu.swan.apps.adaptation.b.a.c.aik().ail().aii();
        if (cOQ) {
            this.cOy = new com.baidu.swan.apps.core.g.a.e();
        }
    }

    public static d ara() {
        if (cOv == null) {
            synchronized (d.class) {
                if (cOv == null) {
                    cOv = new d();
                }
            }
        }
        return cOv;
    }

    public ba arb() {
        return this.cON;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void arc() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void ard() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aDw()) {
                com.baidu.swan.apps.runtime.d.aGI().aGD().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cOv == null || cOv.arj()) {
                    com.baidu.swan.apps.runtime.d.aGI().aGD().sendMessage(15);
                    release(false);
                } else {
                    if (cOv.cOM == null) {
                        cOv.cOM = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aGI().getAppId());
                                com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aGI().aGD().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cOv.a(cOv.cOM);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cOv != null) {
                cOK = PreloadState.UNKNOWN;
                cOv.cOC = true;
                cOv.cOM = null;
                cOJ = false;
                if (z2) {
                    c.arK();
                    copyOnWriteArrayList = c.arJ();
                }
                if (cOv.cOw != null) {
                    cOv.cOO.b(cOv.cOw);
                }
                com.baidu.swan.apps.api.module.l.e.ajF();
                com.baidu.swan.apps.swancore.a.a.aKq();
                are();
                com.baidu.swan.apps.v.i.b(cOv);
                cOv = null;
                com.baidu.swan.apps.core.h.b.aqo().reset();
                cOL = z;
                ara().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void are() {
        if (cOv.cOE != null) {
            for (e eVar : ((HashMap) cOv.cOE.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        arf();
        if (cOv.cOA != null) {
            cOv.cOA = null;
        }
    }

    private static void arf() {
        if (cOQ) {
            if (cOv.cOy != null) {
                cOv.cOy.reset();
            }
        } else if (cOv.cKK != null) {
            if (cOv.cKK instanceof com.baidu.swan.apps.core.g.e) {
                cOv.cKK.destroy();
            }
            cOv.cKK = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (ari()) {
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cOJ = true;
        com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        nA("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.kC(0);
            extensionCore = com.baidu.swan.apps.extcore.b.iu(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.awp().hn(intent.getIntExtra("bundle_key_preload_switch", cOI));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            nA("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0432d.arP();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aLJ();
            }
        }, "prepare ab description");
        if (ars()) {
            f aXg = com.baidu.swan.games.utils.so.d.aXg();
            if (!aXg.isSuccess() && !aXg.aXq()) {
                nA("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            arg();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void arg() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).ki(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.arC();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aEG().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cOx == null) {
            this.cOx = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cOx.contains(next)) {
                this.cOx.add(next);
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

    private void nA(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cOK.statsCode(cOL));
        com.baidu.swan.apps.runtime.d.aGI().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.arv();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.arv());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aCY().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aJk().sN("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cOC) {
                            com.baidu.swan.apps.performance.i.qD("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aJk().sN("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.cj("preload", "startup");
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
        if (cOQ) {
            com.baidu.swan.apps.core.g.a.e eVar = dVar.cOy;
            aVar = eVar.apt() ? eVar.nf(bVar.getAppId()).apq() : null;
        } else {
            aVar = dVar.cKK;
        }
        if (aVar != null && dVar.cOA != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cOA, bVar, fVar);
            dVar.cOA = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cKK != null) + " startFirstPage mSlaveManager " + (dVar.cOA != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cOA != null) {
                    if (a.C0424a.aqn()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.azg(), eVar.afg(), eVar.aGV());
                        SwanAppConfigData aGV = eVar.aGV();
                        equals = "main".equals(aGV != null ? aGV.rT(a2) : null);
                    }
                    if (equals && eVar.aGV() != null) {
                        com.baidu.swan.apps.core.h.b.aqo().a(d.cOQ ? d.this.cOy.nf(eVar.getAppId()).apq() : d.this.cKK, d.this.cOA, eVar.afg(), eVar.aGV(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cOx.contains(bVar)) {
            this.cOx.add(bVar);
        }
        boolean ari = ari();
        com.baidu.swan.apps.performance.i.aCY().ch("preload", ari ? "1" : "0");
        com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "prepareRuntime preload = " + ari);
        if (ari) {
            arl();
            return;
        }
        cOK = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_start"));
        aru();
        final boolean ars = ars();
        if (ars) {
            f aXg = com.baidu.swan.games.utils.so.d.aXg();
            if (!aXg.isSuccess() && aXg.aXq()) {
                ars = false;
            }
        }
        com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "useV8Master:" + ars);
        if (ars) {
            fb(true);
        }
        if (this.cOw == null) {
            this.cOw = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void afE() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cOC);
                            }
                            if (d.this.cOC) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.aru();
                            d.this.arx();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.fb(ars);
                                d.this.art();
                                return;
                            }
                            PreloadState unused = d.cOK = PreloadState.LOAD_FAILED;
                            d.this.arh();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cOO.a(this.cOw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arh() {
        synchronized (this.cOF) {
            this.cOz = false;
            if (cOQ) {
                this.cOy.reset();
            } else {
                this.cKK = null;
            }
        }
        this.cOB = false;
        this.cOA = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.kT(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", apy());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion kC = com.baidu.swan.apps.swancore.b.kC(0);
            jSONObject.put("swan app core", kC == null ? "null" : Long.valueOf(kC.swanCoreVersion));
            SwanCoreVersion kC2 = com.baidu.swan.apps.swancore.b.kC(1);
            jSONObject.put("swan game core", kC2 == null ? "null" : Long.valueOf(kC2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).sR(com.baidu.swan.apps.runtime.e.aGM() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aGM().getAppKey()).sS(jSONObject.toString()).atj();
    }

    public boolean ari() {
        boolean z;
        synchronized (this.cOF) {
            z = this.cOz && this.cOB;
        }
        return z;
    }

    public boolean arj() {
        boolean z;
        synchronized (this.cOF) {
            z = this.cOz;
        }
        return z;
    }

    public boolean ark() {
        boolean z;
        synchronized (this.cOF) {
            z = this.cOB;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arl() {
        if (!this.cOx.isEmpty() && ari()) {
            cOK = PreloadState.LOADED;
            c.arL();
            nA("event_preload_finish");
            com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cOx) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.M(this);
                }
            }
            this.cOx.clear();
        }
    }

    private String U(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.G(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String arm() {
        return !TextUtils.isEmpty(arn()) ? arn() + "runtime/index.js" : "";
    }

    public String arn() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String aro() {
        String str;
        aru();
        if (apy()) {
            str = arm();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.agv()) {
            U(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.all()) {
            com.baidu.swan.apps.console.debugger.a.d.ali();
            com.baidu.swan.apps.console.debugger.a.d.ale().mq("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.alo();
        } else {
            com.baidu.swan.apps.core.e.mz(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String arp() {
        aru();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.agv()) {
            U(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.all()) {
            return com.baidu.swan.apps.console.debugger.a.e.alp();
        } else {
            com.baidu.swan.apps.core.e.mz(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arq() {
        if (!this.cKU.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cKU.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.czc);
                }
                b(next);
            }
            this.cKU.clear();
        }
    }

    public boolean apy() {
        return cOQ ? this.cOy.apy() : this.cKK instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a arr() {
        if (cOQ) {
            if (!this.cOy.apv()) {
                return null;
            }
            return this.cOy.apw().apq();
        }
        return this.cKK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fb(boolean z) {
        boolean z2;
        synchronized (this.cOF) {
            if (cOQ) {
                z2 = this.cOy.apu();
            } else {
                z2 = this.cKK != null;
            }
            if (!this.cOz && !z2) {
                com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cOQ) {
                    this.cOy.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cOF) {
                                d.this.cOz = true;
                                d.this.arq();
                                d.this.arl();
                            }
                        }
                    });
                    return;
                }
                this.cKK = this.cON.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cKK.loadUrl(aro());
                this.cKK.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void hP(String str) {
                        com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cOF) {
                            d.this.cOz = true;
                            d.this.arq();
                            d.this.arl();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a h = this.cON.h(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        h.loadUrl(aro());
        h.a(gVar);
        return h;
    }

    private boolean ars() {
        if (com.baidu.swan.apps.console.debugger.a.e.all() || com.baidu.swan.apps.t.a.awe().agv()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aXl() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aXl()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0432d.afQ() && new File(arm()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void art() {
        if (!this.cOB && this.cOA == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cOA = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void hP(String str) {
                    com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cOB = true;
                    d.this.arl();
                }
            });
            arz();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c bu = this.cON.bu(context);
            com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String arp = arp();
            if (arp != null) {
                com.baidu.swan.apps.runtime.e aGN = com.baidu.swan.apps.runtime.e.aGN();
                if (aGN != null && !TextUtils.isEmpty(aGN.getAppKey())) {
                    arp = Uri.parse(arp).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aGN.getAppKey(), aGN.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!arp.endsWith(File.separator)) {
                        arp = arp + File.separator;
                    }
                }
                bu.loadUrl(arp);
            }
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "prepareSlave loadUrl " + arp);
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
    public void aru() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.kC(0));
        }
    }

    public SwanCoreVersion arv() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore arw() {
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
    public void arx() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.iu(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.arw();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(e eVar) {
        this.cOE.put(eVar.aib(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(e eVar) {
        String aib = eVar.aib();
        this.cOE.remove(aib);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", aib);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public e nB(String str) {
        if (this.cOE.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cOE.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a aiP;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cOF) {
            if (!this.cOz) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.czc)));
                }
                this.cKU.add(aVar);
                return;
            }
            if (cOQ) {
                if (!this.cOy.apv()) {
                    this.cOy.a(aVar);
                    return;
                } else if (this.cOy.apw() != null) {
                    aiP = this.cOy.apw().apq().aiP();
                } else {
                    return;
                }
            } else if (this.cKK != null) {
                aiP = this.cKK.aiP();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.czc);
            }
            com.baidu.swan.apps.event.a.a(aiP, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.nc(str)) {
            b(aVar);
            return;
        }
        e eVar = this.cOE.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.ahZ(), aVar);
    }

    @Nullable
    public String ary() {
        arz();
        return this.cOH;
    }

    private void arz() {
        if (TextUtils.isEmpty(this.cOH)) {
            this.cOH = this.cOA != null ? this.cOA.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bm("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cOH);
        }
    }

    public void fc(boolean z) {
        boolean z2;
        if (cOQ) {
            z2 = this.cOy.apu();
        } else {
            z2 = this.cKK != null;
        }
        if (z && !this.cOz && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cOF) {
                this.cOz = true;
                arq();
                arl();
            }
        } else if (!z && this.cOA != null && !this.cOB) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.qD("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cOB = true;
            arl();
        }
    }

    public void fd(boolean z) {
        this.cOD = z;
    }

    public boolean arA() {
        return this.cOD;
    }

    public String arB() {
        return this.cOG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arC() {
        boolean z = true;
        if (this.cOP) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cOP = true;
        com.baidu.swan.apps.runtime.d aGI = com.baidu.swan.apps.runtime.d.aGI();
        z = (aGI == null || !aGI.aEV()) ? false : false;
        boolean age = com.baidu.swan.apps.t.a.avV().age();
        if (!z && age) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bZ(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + age);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cOQ && com.baidu.swan.apps.core.prefetch.a.a.aql()) {
            this.cOy.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cs(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes7.dex */
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
    /* loaded from: classes7.dex */
    public static class C0432d {
        private static final boolean cPf;
        private static boolean cPg;
        private static boolean cPh;

        static {
            cPf = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.agp() : com.baidu.swan.apps.t.a.avV().agp();
            cPg = cPf ? true : com.baidu.swan.apps.t.a.avV().afQ();
            cPh = cPg;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cPg = intent.getBooleanExtra("bundle_key_v8_ab", cPg);
            }
        }

        public static void arP() {
            cPh = cPg;
        }

        public static String arQ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void nC(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean afQ() {
            if (d.DEBUG) {
                String arQ = arQ();
                char c = 65535;
                switch (arQ.hashCode()) {
                    case -1406842887:
                        if (arQ.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (arQ.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (arQ.equals("V8")) {
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
            return cPh;
        }

        public static boolean arR() {
            String arQ = arQ();
            if (arQ.equals("V8")) {
                return true;
            }
            if (arQ.equals("AB")) {
                if (cPf) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.avV().afQ();
            }
            return false;
        }

        public static String im(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void fe(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aGI().aGE().aHf()) {
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
            } else if (ari()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: f */
                    public void M(Boolean bool) {
                        d.this.il(c.g(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void il(int i) {
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
                boolean agT = com.baidu.swan.apps.t.a.awq().agT();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + agT);
                }
                if (bVar != null) {
                    bVar.M(Boolean.valueOf(agT));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes7.dex */
    public static class c {
        private static final int cPa = a.arG();
        private static final int cPb = a.arH();
        private static int cPc = 0;
        private static int cPd = cPc;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cOv.ari()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cPd >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cPe)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cPe, a.arI());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.arc();
                    c.a(new com.baidu.swan.apps.am.a().cv(5L).cw(49L).tV("start retry"));
                }
            }
        };
        private static final Runnable cPe = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cOv.ari()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cPd >= 1) {
                    com.baidu.swan.apps.am.a tV = new com.baidu.swan.apps.am.a().cv(5L).cw(49L).tV("retry timeout");
                    c.a(tV);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), tV, 0, com.baidu.swan.apps.runtime.d.aGI().getAppId());
                    com.baidu.swan.apps.ap.e.M(com.baidu.swan.apps.runtime.d.aGI().aGG());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int aeW;
            com.baidu.swan.apps.runtime.e aGE = com.baidu.swan.apps.runtime.d.aGI().aGE();
            if (aGE != null && (aeW = aGE.aeW()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aGE.afg()).td(com.baidu.swan.apps.statistic.h.ku(aeW)).te(com.baidu.swan.apps.runtime.e.aGO()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> arJ() {
            return new CopyOnWriteArrayList<>(d.cOv.cOx);
        }

        static void arK() {
            cPd++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cPd);
            }
        }

        static void arL() {
            cPd = cPc;
        }

        public static int g(Boolean bool) {
            return bool.booleanValue() ? cPa : cPb;
        }
    }

    /* loaded from: classes7.dex */
    public static class a {
        private static int cOZ = -1;

        static int arF() {
            if (cOZ < 0) {
                cOZ = com.baidu.swan.apps.t.a.avV().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cOZ;
        }

        public static boolean isEnable() {
            boolean z = arF() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int arG() {
            int i = com.baidu.swan.apps.t.a.avV().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int arH() {
            int i = com.baidu.swan.apps.t.a.avV().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int arI() {
            int i = com.baidu.swan.apps.t.a.avV().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
