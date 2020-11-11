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
    private static volatile d cQf;
    private com.baidu.swan.apps.core.g.a cMu;
    private com.baidu.swan.apps.core.container.a.b cQg;
    private e cQi;
    private boolean cQj;
    private com.baidu.swan.apps.adaptation.b.c cQk;
    private boolean cQl;
    private boolean cQm;
    private boolean cQn;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cQo;
    private String cQr;
    private b cQw;
    private ba cQx;
    private i cQy;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cQs = 10150;
    public static boolean cQt = false;
    private static PreloadState cQu = PreloadState.UNKNOWN;
    private static boolean cQv = false;
    private static final boolean cQA = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> cQh = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cME = new LinkedList<>();
    private final Object cQp = new Object();
    private final String cQq = UUID.randomUUID().toString();
    private volatile boolean cQz = false;

    private static PreloadState arF() {
        return cQu;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> arG() {
        return this.cQo;
    }

    public static int arH() {
        return arF().statsCode(cQv);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cQo = new HashMap<>();
        this.cQx = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cQy = com.baidu.swan.apps.adaptation.b.a.c.aiS().aiT().aiQ();
        if (cQA) {
            this.cQi = new e();
        }
    }

    public static d arI() {
        if (cQf == null) {
            synchronized (d.class) {
                if (cQf == null) {
                    cQf = new d();
                }
            }
        }
        return cQf;
    }

    public ba arJ() {
        return this.cQx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void arK() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void arL() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aEe()) {
                com.baidu.swan.apps.runtime.d.aHq().aHl().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cQf == null || cQf.arR()) {
                    com.baidu.swan.apps.runtime.d.aHq().aHl().sendMessage(15);
                    release(false);
                } else {
                    if (cQf.cQw == null) {
                        cQf.cQw = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aHq().getAppId());
                                com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aHq().aHl().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cQf.a(cQf.cQw);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cQf != null) {
                cQu = PreloadState.UNKNOWN;
                cQf.cQm = true;
                cQf.cQw = null;
                cQt = false;
                if (z2) {
                    c.ast();
                    copyOnWriteArrayList = c.ass();
                }
                if (cQf.cQg != null) {
                    cQf.cQy.b(cQf.cQg);
                }
                com.baidu.swan.apps.api.module.l.e.akn();
                com.baidu.swan.apps.swancore.a.a.aKY();
                arM();
                com.baidu.swan.apps.v.i.b(cQf);
                cQf = null;
                com.baidu.swan.apps.core.h.b.aqW().reset();
                cQv = z;
                arI().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void arM() {
        if (cQf.cQo != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cQf.cQo.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        arN();
        if (cQf.cQk != null) {
            cQf.cQk = null;
        }
    }

    private static void arN() {
        if (cQA) {
            if (cQf.cQi != null) {
                cQf.cQi.reset();
            }
        } else if (cQf.cMu != null) {
            if (cQf.cMu instanceof com.baidu.swan.apps.core.g.e) {
                cQf.cMu.destroy();
            }
            cQf.cMu = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (arQ()) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cQt = true;
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        nG("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.kG(0);
            extensionCore = com.baidu.swan.apps.extcore.b.iy(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.awX().hr(intent.getIntExtra("bundle_key_preload_switch", cQs));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            nG("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0434d.asy();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aMr();
            }
        }, "prepare ab description");
        if (asa()) {
            f aXO = com.baidu.swan.games.utils.so.d.aXO();
            if (!aXO.isSuccess() && !aXO.aXY()) {
                nG("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            arO();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void arO() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).km(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.ask();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aFo().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cQh == null) {
            this.cQh = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cQh.contains(next)) {
                this.cQh.add(next);
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

    private void nG(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cQu.statsCode(cQv));
        com.baidu.swan.apps.runtime.d.aHq().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.asd();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.asd());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aJS().sS("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cQm) {
                            com.baidu.swan.apps.performance.i.qJ("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aJS().sS("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.ck("preload", "startup");
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
        if (cQA) {
            e eVar = dVar.cQi;
            aVar = eVar.aqb() ? eVar.nl(bVar.getAppId()).apY() : null;
        } else {
            aVar = dVar.cMu;
        }
        if (aVar != null && dVar.cQk != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cQk, bVar, fVar);
            dVar.cQk = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cMu != null) + " startFirstPage mSlaveManager " + (dVar.cQk != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cQk != null) {
                    if (a.C0426a.aqV()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.azO(), eVar.afO(), eVar.aHD());
                        SwanAppConfigData aHD = eVar.aHD();
                        equals = "main".equals(aHD != null ? aHD.rZ(a2) : null);
                    }
                    if (equals && eVar.aHD() != null) {
                        com.baidu.swan.apps.core.h.b.aqW().a(d.cQA ? d.this.cQi.nl(eVar.getAppId()).apY() : d.this.cMu, d.this.cQk, eVar.afO(), eVar.aHD(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cQh.contains(bVar)) {
            this.cQh.add(bVar);
        }
        boolean arQ = arQ();
        com.baidu.swan.apps.performance.i.aDG().ci("preload", arQ ? "1" : "0");
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareRuntime preload = " + arQ);
        if (arQ) {
            arT();
            return;
        }
        cQu = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_start"));
        asc();
        final boolean asa = asa();
        if (asa) {
            f aXO = com.baidu.swan.games.utils.so.d.aXO();
            if (!aXO.isSuccess() && aXO.aXY()) {
                asa = false;
            }
        }
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "useV8Master:" + asa);
        if (asa) {
            eY(true);
        }
        if (this.cQg == null) {
            this.cQg = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void agm() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cQm);
                            }
                            if (d.this.cQm) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.asc();
                            d.this.asf();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.eY(asa);
                                d.this.asb();
                                return;
                            }
                            PreloadState unused = d.cQu = PreloadState.LOAD_FAILED;
                            d.this.arP();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cQy.a(this.cQg);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arP() {
        synchronized (this.cQp) {
            this.cQj = false;
            if (cQA) {
                this.cQi.reset();
            } else {
                this.cMu = null;
            }
        }
        this.cQl = false;
        this.cQk = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.kX(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", aqg());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion kG = com.baidu.swan.apps.swancore.b.kG(0);
            jSONObject.put("swan app core", kG == null ? "null" : Long.valueOf(kG.swanCoreVersion));
            SwanCoreVersion kG2 = com.baidu.swan.apps.swancore.b.kG(1);
            jSONObject.put("swan game core", kG2 == null ? "null" : Long.valueOf(kG2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).sW(com.baidu.swan.apps.runtime.e.aHu() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aHu().getAppKey()).sX(jSONObject.toString()).atR();
    }

    public boolean arQ() {
        boolean z;
        synchronized (this.cQp) {
            z = this.cQj && this.cQl;
        }
        return z;
    }

    public boolean arR() {
        boolean z;
        synchronized (this.cQp) {
            z = this.cQj;
        }
        return z;
    }

    public boolean arS() {
        boolean z;
        synchronized (this.cQp) {
            z = this.cQl;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arT() {
        if (!this.cQh.isEmpty() && arQ()) {
            cQu = PreloadState.LOADED;
            c.asu();
            nG("event_preload_finish");
            com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cQh) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.M(this);
                }
            }
            this.cQh.clear();
        }
    }

    private String U(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.G(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String arU() {
        return !TextUtils.isEmpty(arV()) ? arV() + "runtime/index.js" : "";
    }

    public String arV() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String arW() {
        String str;
        asc();
        if (aqg()) {
            str = arU();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.ahd()) {
            U(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.alT()) {
            com.baidu.swan.apps.console.debugger.a.d.alQ();
            com.baidu.swan.apps.console.debugger.a.d.alM().mw("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.alW();
        } else {
            com.baidu.swan.apps.core.e.mF(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String arX() {
        asc();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.ahd()) {
            U(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.alT()) {
            return com.baidu.swan.apps.console.debugger.a.e.alX();
        } else {
            com.baidu.swan.apps.core.e.mF(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arY() {
        if (!this.cME.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cME.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cAM);
                }
                b(next);
            }
            this.cME.clear();
        }
    }

    public boolean aqg() {
        return cQA ? this.cQi.aqg() : this.cMu instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a arZ() {
        if (cQA) {
            if (!this.cQi.aqd()) {
                return null;
            }
            return this.cQi.aqe().apY();
        }
        return this.cMu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eY(boolean z) {
        boolean z2;
        synchronized (this.cQp) {
            if (cQA) {
                z2 = this.cQi.aqc();
            } else {
                z2 = this.cMu != null;
            }
            if (!this.cQj && !z2) {
                com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cQA) {
                    this.cQi.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cQp) {
                                d.this.cQj = true;
                                d.this.arY();
                                d.this.arT();
                            }
                        }
                    });
                    return;
                }
                this.cMu = this.cQx.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cMu.loadUrl(arW());
                this.cMu.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void hV(String str) {
                        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cQp) {
                            d.this.cQj = true;
                            d.this.arY();
                            d.this.arT();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a h = this.cQx.h(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        h.loadUrl(arW());
        h.a(gVar);
        return h;
    }

    private boolean asa() {
        if (com.baidu.swan.apps.console.debugger.a.e.alT() || com.baidu.swan.apps.t.a.awM().ahd()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aXT() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aXT()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0434d.agy() && new File(arU()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asb() {
        if (!this.cQl && this.cQk == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cQk = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void hV(String str) {
                    com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cQl = true;
                    d.this.arT();
                }
            });
            ash();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c bu = this.cQx.bu(context);
            com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String arX = arX();
            if (arX != null) {
                com.baidu.swan.apps.runtime.e aHv = com.baidu.swan.apps.runtime.e.aHv();
                if (aHv != null && !TextUtils.isEmpty(aHv.getAppKey())) {
                    arX = Uri.parse(arX).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aHv.getAppKey(), aHv.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!arX.endsWith(File.separator)) {
                        arX = arX + File.separator;
                    }
                }
                bu.loadUrl(arX);
            }
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareSlave loadUrl " + arX);
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
    public void asc() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.kG(0));
        }
    }

    public SwanCoreVersion asd() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore ase() {
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
    public void asf() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.iy(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.ase();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cQo.put(eVar.aiJ(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String aiJ = eVar.aiJ();
        this.cQo.remove(aiJ);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", aiJ);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e nH(String str) {
        if (this.cQo.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cQo.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a ajx;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cQp) {
            if (!this.cQj) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cAM)));
                }
                this.cME.add(aVar);
                return;
            }
            if (cQA) {
                if (!this.cQi.aqd()) {
                    this.cQi.a(aVar);
                    return;
                } else if (this.cQi.aqe() != null) {
                    ajx = this.cQi.aqe().apY().ajx();
                } else {
                    return;
                }
            } else if (this.cMu != null) {
                ajx = this.cMu.ajx();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cAM);
            }
            com.baidu.swan.apps.event.a.a(ajx, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.ni(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cQo.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.aiH(), aVar);
    }

    @Nullable
    public String asg() {
        ash();
        return this.cQr;
    }

    private void ash() {
        if (TextUtils.isEmpty(this.cQr)) {
            this.cQr = this.cQk != null ? this.cQk.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cQr);
        }
    }

    public void eZ(boolean z) {
        boolean z2;
        if (cQA) {
            z2 = this.cQi.aqc();
        } else {
            z2 = this.cMu != null;
        }
        if (z && !this.cQj && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cQp) {
                this.cQj = true;
                arY();
                arT();
            }
        } else if (!z && this.cQk != null && !this.cQl) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.qJ("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cQl = true;
            arT();
        }
    }

    public void fa(boolean z) {
        this.cQn = z;
    }

    public boolean asi() {
        return this.cQn;
    }

    public String asj() {
        return this.cQq;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ask() {
        boolean z = true;
        if (this.cQz) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cQz = true;
        com.baidu.swan.apps.runtime.d aHq = com.baidu.swan.apps.runtime.d.aHq();
        z = (aHq == null || !aHq.aFD()) ? false : false;
        boolean agM = com.baidu.swan.apps.t.a.awD().agM();
        if (!z && agM) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bZ(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + agM);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cQA && com.baidu.swan.apps.core.prefetch.a.a.aqT()) {
            this.cQi.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cs(this.mSwanCoreVersion.swanCoreVersion));
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
    public static class C0434d {
        private static final boolean cQP;
        private static boolean cQQ;
        private static boolean cQR;

        static {
            cQP = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.agX() : com.baidu.swan.apps.t.a.awD().agX();
            cQQ = cQP ? true : com.baidu.swan.apps.t.a.awD().agy();
            cQR = cQQ;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cQQ = intent.getBooleanExtra("bundle_key_v8_ab", cQQ);
            }
        }

        public static void asy() {
            cQR = cQQ;
        }

        public static String asz() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void nI(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean agy() {
            if (d.DEBUG) {
                String asz = asz();
                char c = 65535;
                switch (asz.hashCode()) {
                    case -1406842887:
                        if (asz.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (asz.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (asz.equals("V8")) {
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
            return cQR;
        }

        public static boolean asA() {
            String asz = asz();
            if (asz.equals("V8")) {
                return true;
            }
            if (asz.equals("AB")) {
                if (cQP) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.awD().agy();
            }
            return false;
        }

        public static String iq(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void fb(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aHq().aHm().aHN()) {
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
            } else if (arQ()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: f */
                    public void M(Boolean bool) {
                        d.this.ip(c.g(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ip(int i) {
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
                boolean ahB = com.baidu.swan.apps.t.a.awY().ahB();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + ahB);
                }
                if (bVar != null) {
                    bVar.M(Boolean.valueOf(ahB));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes10.dex */
    public static class c {
        private static final int cQK = a.asp();
        private static final int cQL = a.asq();
        private static int cQM = 0;
        private static int cQN = cQM;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cQf.arQ()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cQN >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cQO)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cQO, a.asr());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.arK();
                    c.a(new com.baidu.swan.apps.am.a().cv(5L).cw(49L).ua("start retry"));
                }
            }
        };
        private static final Runnable cQO = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cQf.arQ()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cQN >= 1) {
                    com.baidu.swan.apps.am.a ua = new com.baidu.swan.apps.am.a().cv(5L).cw(49L).ua("retry timeout");
                    c.a(ua);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), ua, 0, com.baidu.swan.apps.runtime.d.aHq().getAppId());
                    com.baidu.swan.apps.ap.e.N(com.baidu.swan.apps.runtime.d.aHq().aHo());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int afE;
            com.baidu.swan.apps.runtime.e aHm = com.baidu.swan.apps.runtime.d.aHq().aHm();
            if (aHm != null && (afE = aHm.afE()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aHm.afO()).ti(com.baidu.swan.apps.statistic.h.ky(afE)).tj(com.baidu.swan.apps.runtime.e.aHw()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> ass() {
            return new CopyOnWriteArrayList<>(d.cQf.cQh);
        }

        static void ast() {
            cQN++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cQN);
            }
        }

        static void asu() {
            cQN = cQM;
        }

        public static int g(Boolean bool) {
            return bool.booleanValue() ? cQK : cQL;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static int cQJ = -1;

        static int aso() {
            if (cQJ < 0) {
                cQJ = com.baidu.swan.apps.t.a.awD().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cQJ;
        }

        public static boolean isEnable() {
            boolean z = aso() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int asp() {
            int i = com.baidu.swan.apps.t.a.awD().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int asq() {
            int i = com.baidu.swan.apps.t.a.awD().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int asr() {
            int i = com.baidu.swan.apps.t.a.awD().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
