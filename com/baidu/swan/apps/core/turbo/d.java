package com.baidu.swan.apps.core.turbo;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.android.imsdk.chatmessage.sync.SyncStrategy;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.adaptation.a.ba;
import com.baidu.swan.apps.adaptation.b.i;
import com.baidu.swan.apps.ao.ai;
import com.baidu.swan.apps.ao.ak;
import com.baidu.swan.apps.ao.p;
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
/* loaded from: classes8.dex */
public final class d implements h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cVK = 10150;
    public static boolean cVL = false;
    private static PreloadState cVM = PreloadState.UNKNOWN;
    private static boolean cVN = false;
    private static final boolean cVS = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private static volatile d cVy;
    private com.baidu.swan.apps.core.g.a cRO;
    private e cVB;
    private boolean cVC;
    private com.baidu.swan.apps.adaptation.b.c cVD;
    private boolean cVE;
    private boolean cVF;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cVG;
    private String cVJ;
    private b cVO;
    private ba cVP;
    private i cVQ;
    private com.baidu.swan.apps.core.container.a.b cVz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private List<b> cVA = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cRY = new LinkedList<>();
    private final Object cVH = new Object();
    private final String cVI = UUID.randomUUID().toString();
    private volatile boolean cVR = false;

    private static PreloadState arD() {
        return cVM;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> arE() {
        return this.cVG;
    }

    public static int arF() {
        return arD().statsCode(cVN);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cVG = new HashMap<>();
        this.cVP = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cVQ = com.baidu.swan.apps.adaptation.b.a.c.aiJ().aiK().aiH();
        if (cVS) {
            this.cVB = new e();
        }
    }

    public static d arG() {
        if (cVy == null) {
            synchronized (d.class) {
                if (cVy == null) {
                    cVy = new d();
                }
            }
        }
        return cVy;
    }

    public ba arH() {
        return this.cVP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void arI() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void arJ() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aEe()) {
                com.baidu.swan.apps.runtime.d.aIn().aIi().is(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cVy == null || cVy.arP()) {
                    com.baidu.swan.apps.runtime.d.aIn().aIi().is(15);
                    release(false);
                } else {
                    if (cVy.cVO == null) {
                        cVy.cVO = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aIn().getAppId());
                                com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aIn().aIi().is(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cVy.a(cVy.cVO);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cVy != null) {
                cVM = PreloadState.UNKNOWN;
                cVy.mIsReleased = true;
                cVy.cVO = null;
                cVL = false;
                if (z2) {
                    c.asr();
                    copyOnWriteArrayList = c.asq();
                }
                if (cVy.cVz != null) {
                    cVy.cVQ.b(cVy.cVz);
                }
                com.baidu.swan.apps.api.module.l.e.ake();
                com.baidu.swan.apps.swancore.a.a.aLU();
                arK();
                com.baidu.swan.apps.v.i.b(cVy);
                cVy = null;
                com.baidu.swan.apps.core.h.b.aqT().reset();
                cVN = z;
                arG().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void arK() {
        if (cVy.cVG != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cVy.cVG.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        arL();
        if (cVy.cVD != null) {
            cVy.cVD = null;
        }
    }

    private static void arL() {
        if (cVS) {
            if (cVy.cVB != null) {
                cVy.cVB.reset();
            }
        } else if (cVy.cRO != null) {
            if (cVy.cRO instanceof com.baidu.swan.apps.core.g.e) {
                cVy.cRO.destroy();
            }
            cVy.cRO = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (arO()) {
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cVL = true;
        com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        mP("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.jz(0);
            extensionCore = com.baidu.swan.apps.extcore.b.hh(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.awV().fY(intent.getIntExtra("bundle_key_preload_switch", cVK));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            mP("event_preload_error");
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0419d.asx();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ao.i.aNo();
            }
        }, "prepare ab description");
        if (arY()) {
            f aYM = com.baidu.swan.games.utils.so.d.aYM();
            if (!aYM.isSuccess() && !aYM.aYW()) {
                mP("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            arM();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void arM() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.u(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).jg(1).aHZ();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.l(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.asi();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aFo().is(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cVA == null) {
            this.cVA = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cVA.contains(next)) {
                this.cVA.add(next);
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

    private void mP(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cVM.statsCode(cVN));
        com.baidu.swan.apps.runtime.d.aIn().g(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.asb();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.asb());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aDG().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.aj.a.aKP().sf("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.mIsReleased) {
                            com.baidu.swan.apps.performance.i.pS("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.aj.a.aKP().sf("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.co("preload", "startup");
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
        if (cVS) {
            e eVar = dVar.cVB;
            aVar = eVar.apY() ? eVar.mu(bVar.getAppId()).apV() : null;
        } else {
            aVar = dVar.cRO;
        }
        if (aVar != null && dVar.cVD != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cVD, bVar, fVar);
            dVar.cVD = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cRO != null) + " startFirstPage mSlaveManager " + (dVar.cVD != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cVD != null) {
                    if (a.C0411a.aqS()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.azN(), eVar.afB(), eVar.aIA());
                        SwanAppConfigData aIA = eVar.aIA();
                        equals = "main".equals(aIA != null ? aIA.rm(a2) : null);
                    }
                    if (equals && eVar.aIA() != null) {
                        com.baidu.swan.apps.core.h.b.aqT().a(d.cVS ? d.this.cVB.mu(eVar.getAppId()).apV() : d.this.cRO, d.this.cVD, eVar.afB(), eVar.aIA(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cVA.contains(bVar)) {
            this.cVA.add(bVar);
        }
        boolean arO = arO();
        com.baidu.swan.apps.performance.i.aDG().cm("preload", arO ? "1" : "0");
        com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "prepareRuntime preload = " + arO);
        if (arO) {
            arR();
            return;
        }
        cVM = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_start"));
        asa();
        final boolean arY = arY();
        if (arY) {
            f aYM = com.baidu.swan.games.utils.so.d.aYM();
            if (!aYM.isSuccess() && aYM.aYW()) {
                arY = false;
            }
        }
        com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "useV8Master:" + arY);
        if (arY) {
            fv(true);
        }
        if (this.cVz == null) {
            this.cVz = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void agb() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
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
                            d.this.asa();
                            d.this.asd();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.fv(arY);
                                d.this.arZ();
                                return;
                            }
                            PreloadState unused = d.cVM = PreloadState.LOAD_FAILED;
                            d.this.arN();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cVQ.a(this.cVz);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arN() {
        synchronized (this.cVH) {
            this.cVC = false;
            if (cVS) {
                this.cVB.reset();
            } else {
                this.cRO = null;
            }
        }
        this.cVE = false;
        this.cVD = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.jQ(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", aqd());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion jz = com.baidu.swan.apps.swancore.b.jz(0);
            jSONObject.put("swan app core", jz == null ? "null" : Long.valueOf(jz.swanCoreVersion));
            SwanCoreVersion jz2 = com.baidu.swan.apps.swancore.b.jz(1);
            jSONObject.put("swan game core", jz2 == null ? "null" : Long.valueOf(jz2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).sj(com.baidu.swan.apps.runtime.e.aIr() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aIr().getAppKey()).sk(jSONObject.toString()).atQ();
    }

    public boolean arO() {
        boolean z;
        synchronized (this.cVH) {
            z = this.cVC && this.cVE;
        }
        return z;
    }

    public boolean arP() {
        boolean z;
        synchronized (this.cVH) {
            z = this.cVC;
        }
        return z;
    }

    public boolean arQ() {
        boolean z;
        synchronized (this.cVH) {
            z = this.cVE;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arR() {
        if (!this.cVA.isEmpty() && arO()) {
            cVM = PreloadState.LOADED;
            c.ass();
            mP("event_preload_finish");
            com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cVA) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.L(this);
                }
            }
            this.cVA.clear();
        }
    }

    private String V(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.L(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String arS() {
        return !TextUtils.isEmpty(arT()) ? arT() + "runtime/index.js" : "";
    }

    public String arT() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String arU() {
        String str;
        asa();
        if (aqd()) {
            str = arS();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.agS()) {
            V(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.alM()) {
            com.baidu.swan.apps.console.debugger.a.d.alJ();
            com.baidu.swan.apps.console.debugger.a.d.alF().lF("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.alP();
        } else {
            com.baidu.swan.apps.core.e.lO(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String arV() {
        asa();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.agS()) {
            V(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.alM()) {
            return com.baidu.swan.apps.console.debugger.a.e.alQ();
        } else {
            com.baidu.swan.apps.core.e.lO(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arW() {
        if (!this.cRY.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cRY.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cFY);
                }
                b(next);
            }
            this.cRY.clear();
        }
    }

    public boolean aqd() {
        return cVS ? this.cVB.aqd() : this.cRO instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a arX() {
        if (cVS) {
            if (!this.cVB.aqa()) {
                return null;
            }
            return this.cVB.aqb().apV();
        }
        return this.cRO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fv(boolean z) {
        boolean z2;
        synchronized (this.cVH) {
            if (cVS) {
                z2 = this.cVB.apZ();
            } else {
                z2 = this.cRO != null;
            }
            if (!this.cVC && !z2) {
                com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cVS) {
                    this.cVB.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cVH) {
                                d.this.cVC = true;
                                d.this.arW();
                                d.this.arR();
                            }
                        }
                    });
                    return;
                }
                this.cRO = this.cVP.r(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cRO.loadUrl(arU());
                this.cRO.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void gV(String str) {
                        com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cVH) {
                            d.this.cVC = true;
                            d.this.arW();
                            d.this.arR();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a r = this.cVP.r(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        r.loadUrl(arU());
        r.a(gVar);
        return r;
    }

    private boolean arY() {
        if (com.baidu.swan.apps.console.debugger.a.e.alM() || com.baidu.swan.apps.t.a.awK().agS()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aYR() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aYR()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0419d.agn() && new File(arS()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void arZ() {
        if (!this.cVE && this.cVD == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cVD = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void gV(String str) {
                    com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cVE = true;
                    d.this.arR();
                }
            });
            asf();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c cg = this.cVP.cg(context);
            com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String arV = arV();
            if (arV != null) {
                com.baidu.swan.apps.runtime.e aIs = com.baidu.swan.apps.runtime.e.aIs();
                if (aIs != null && !TextUtils.isEmpty(aIs.getAppKey())) {
                    arV = Uri.parse(arV).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aIs.getAppKey(), aIs.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!arV.endsWith(File.separator)) {
                        arV = arV + File.separator;
                    }
                }
                cg.loadUrl(arV);
            }
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "prepareSlave loadUrl " + arV);
            cg.a(gVar);
            return cg;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.cH(context);
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
    public void asa() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.jz(0));
        }
    }

    public SwanCoreVersion asb() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore asc() {
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
    public void asd() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.hh(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.asc();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cVG.put(eVar.aiA(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String aiA = eVar.aiA();
        this.cVG.remove(aiA);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", aiA);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.aHO();
    }

    public com.baidu.swan.apps.adaptation.b.e mQ(String str) {
        if (this.cVG.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cVG.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a ajo;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cVH) {
            if (!this.cVC) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cFY)));
                }
                this.cRY.add(aVar);
                return;
            }
            if (cVS) {
                if (!this.cVB.aqa()) {
                    this.cVB.a(aVar);
                    return;
                } else if (this.cVB.aqb() != null) {
                    ajo = this.cVB.aqb().apV().ajo();
                } else {
                    return;
                }
            } else if (this.cRO != null) {
                ajo = this.cRO.ajo();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cFY);
            }
            com.baidu.swan.apps.event.a.a(ajo, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.mr(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cVG.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.aiy(), aVar);
    }

    @Nullable
    public String ase() {
        asf();
        return this.cVJ;
    }

    private void asf() {
        if (TextUtils.isEmpty(this.cVJ)) {
            this.cVJ = this.cVD != null ? this.cVD.getUserAgent() : "";
            com.baidu.swan.apps.console.c.br("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cVJ);
        }
    }

    public void fw(boolean z) {
        boolean z2;
        if (cVS) {
            z2 = this.cVB.apZ();
        } else {
            z2 = this.cRO != null;
        }
        if (z && !this.cVC && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cVH) {
                this.cVC = true;
                arW();
                arR();
            }
        } else if (!z && this.cVD != null && !this.cVE) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.pS("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cVE = true;
            arR();
        }
    }

    public void fx(boolean z) {
        this.cVF = z;
    }

    public boolean asg() {
        return this.cVF;
    }

    public String ash() {
        return this.cVI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asi() {
        boolean z = true;
        if (this.cVR) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cVR = true;
        com.baidu.swan.apps.runtime.d aIn = com.baidu.swan.apps.runtime.d.aIn();
        z = (aIn == null || !aIn.aFD()) ? false : false;
        boolean agB = com.baidu.swan.apps.t.a.awB().agB();
        if (!z && agB) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.cM(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + agB);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cVS && com.baidu.swan.apps.core.prefetch.a.a.aqQ()) {
            this.cVB.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cS(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b implements com.baidu.swan.apps.ao.e.b<d> {
        protected abstract void o(d dVar);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ao.e.b
        /* renamed from: p */
        public void L(d dVar) {
            o(dVar);
        }
    }

    /* renamed from: com.baidu.swan.apps.core.turbo.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0419d {
        private static final boolean cWh;
        private static boolean cWi;
        private static boolean cWj;

        static {
            cWh = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.agM() : com.baidu.swan.apps.t.a.awB().agM();
            cWi = cWh ? true : com.baidu.swan.apps.t.a.awB().agn();
            cWj = cWi;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cWi = intent.getBooleanExtra("bundle_key_v8_ab", cWi);
            }
        }

        public static void asx() {
            cWj = cWi;
        }

        public static String asy() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void mR(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean agn() {
            if (d.DEBUG) {
                String asy = asy();
                char c = 65535;
                switch (asy.hashCode()) {
                    case -1406842887:
                        if (asy.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (asy.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (asy.equals("V8")) {
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
            return cWj;
        }

        public static boolean asz() {
            String asy = asy();
            if (asy.equals("V8")) {
                return true;
            }
            if (asy.equals("AB")) {
                if (cWh) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.awB().agn();
            }
            return false;
        }

        public static String gZ(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void fy(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aIn().aIj().aIK()) {
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
            } else if (arO()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ao.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: g */
                    public void L(Boolean bool) {
                        d.this.gY(c.h(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void gY(int i) {
        Handler mainHandler = com.baidu.swan.apps.runtime.d.getMainHandler();
        if (mainHandler.hasCallbacks(c.mRetryRunnable)) {
            mainHandler.removeCallbacks(c.mRetryRunnable);
        }
        mainHandler.postDelayed(c.mRetryRunnable, i);
    }

    private void f(final com.baidu.swan.apps.ao.e.b<Boolean> bVar) {
        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.4
            @Override // java.lang.Runnable
            public void run() {
                boolean ahq = com.baidu.swan.apps.t.a.awW().ahq();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + ahq);
                }
                if (bVar != null) {
                    bVar.L(Boolean.valueOf(ahq));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes8.dex */
    public static class c {
        private static final int cWc = a.asn();
        private static final int cWd = a.aso();
        private static int cWe = 0;
        private static int cWf = cWe;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cVy.arO()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cWf >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cWg)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cWg, a.asp());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.arI();
                    c.a(new com.baidu.swan.apps.al.a().cV(5L).cW(49L).to("start retry"));
                }
            }
        };
        private static final Runnable cWg = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cVy.arO()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cWf >= 1) {
                    com.baidu.swan.apps.al.a aVar = new com.baidu.swan.apps.al.a().cV(5L).cW(49L).to("retry timeout");
                    c.a(aVar);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), aVar, 0, com.baidu.swan.apps.runtime.d.aIn().getAppId());
                    com.baidu.swan.apps.ao.e.N(com.baidu.swan.apps.runtime.d.aIn().aIl());
                }
            }
        };

        static void a(com.baidu.swan.apps.al.a aVar) {
            int afr;
            com.baidu.swan.apps.runtime.e aIj = com.baidu.swan.apps.runtime.d.aIn().aIj();
            if (aIj != null && (afr = aIj.afr()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aIj.afB()).sw(com.baidu.swan.apps.statistic.h.jr(afr)).sx(com.baidu.swan.apps.runtime.e.aIt()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> asq() {
            return new CopyOnWriteArrayList<>(d.cVy.cVA);
        }

        static void asr() {
            cWf++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cWf);
            }
        }

        static void ass() {
            cWf = cWe;
        }

        public static int h(Boolean bool) {
            return bool.booleanValue() ? cWc : cWd;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static int cWb = -1;

        static int asl() {
            if (cWb < 0) {
                cWb = com.baidu.swan.apps.t.a.awB().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cWb;
        }

        public static boolean isEnable() {
            boolean z = asl() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int asn() {
            int i = com.baidu.swan.apps.t.a.awB().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int aso() {
            int i = com.baidu.swan.apps.t.a.awB().getSwitch("swan_core_runtime_high_end_timeout", SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int asp() {
            int i = com.baidu.swan.apps.t.a.awB().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
