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
/* loaded from: classes9.dex */
public final class d implements h {
    private static volatile d dak;
    private com.baidu.swan.apps.core.g.a cWA;
    private b daC;
    private ba daD;
    private i daE;
    private com.baidu.swan.apps.core.container.a.b dal;
    private e dan;
    private boolean dao;
    private com.baidu.swan.apps.adaptation.b.c dap;
    private boolean daq;
    private boolean dar;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> das;
    private String daw;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int dax = 10150;
    public static boolean daz = false;
    private static PreloadState daA = PreloadState.UNKNOWN;
    private static boolean daB = false;
    private static final boolean daG = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> dam = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cWK = new LinkedList<>();
    private final Object dau = new Object();
    private final String dav = UUID.randomUUID().toString();
    private volatile boolean daF = false;

    private static PreloadState avx() {
        return daA;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> avy() {
        return this.das;
    }

    public static int avz() {
        return avx().statsCode(daB);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.das = new HashMap<>();
        this.daD = new com.baidu.swan.apps.adaptation.b.a.b();
        this.daE = com.baidu.swan.apps.adaptation.b.a.c.amC().amD().amA();
        if (daG) {
            this.dan = new e();
        }
    }

    public static d avA() {
        if (dak == null) {
            synchronized (d.class) {
                if (dak == null) {
                    dak = new d();
                }
            }
        }
        return dak;
    }

    public ba avB() {
        return this.daD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void avC() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void avD() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aHX()) {
                com.baidu.swan.apps.runtime.d.aMg().aMb().jY(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (dak == null || dak.avJ()) {
                    com.baidu.swan.apps.runtime.d.aMg().aMb().jY(15);
                    release(false);
                } else {
                    if (dak.daC == null) {
                        dak.daC = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aMg().getAppId());
                                com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aMg().aMb().jY(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    dak.a(dak.daC);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (dak != null) {
                daA = PreloadState.UNKNOWN;
                dak.mIsReleased = true;
                dak.daC = null;
                daz = false;
                if (z2) {
                    c.awk();
                    copyOnWriteArrayList = c.awj();
                }
                if (dak.dal != null) {
                    dak.daE.b(dak.dal);
                }
                com.baidu.swan.apps.api.module.l.e.anX();
                com.baidu.swan.apps.swancore.a.a.aPN();
                avE();
                com.baidu.swan.apps.v.i.b(dak);
                dak = null;
                com.baidu.swan.apps.core.h.b.auN().reset();
                daB = z;
                avA().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void avE() {
        if (dak.das != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) dak.das.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        avF();
        if (dak.dap != null) {
            dak.dap = null;
        }
    }

    private static void avF() {
        if (daG) {
            if (dak.dan != null) {
                dak.dan.reset();
            }
        } else if (dak.cWA != null) {
            if (dak.cWA instanceof com.baidu.swan.apps.core.g.e) {
                dak.cWA.destroy();
            }
            dak.cWA = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (avI()) {
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        daz = true;
        com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        oa("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.lf(0);
            extensionCore = com.baidu.swan.apps.extcore.b.iN(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.aAO().hF(intent.getIntExtra("bundle_key_preload_switch", dax));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            oa("event_preload_error");
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0436d.awq();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ao.i.aRh();
            }
        }, "prepare ab description");
        if (avS()) {
            f bcF = com.baidu.swan.games.utils.so.d.bcF();
            if (!bcF.isSuccess() && !bcF.bcP()) {
                oa("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            avG();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void avG() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.u(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).kM(1).aLS();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.l(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.awc();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aJh().jY(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.dam == null) {
            this.dam = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.dam.contains(next)) {
                this.dam.add(next);
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

    private void oa(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", daA.statsCode(daB));
        com.baidu.swan.apps.runtime.d.aMg().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.avV();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.avV());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aHz().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.aj.a.aOI().tr("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.mIsReleased) {
                            com.baidu.swan.apps.performance.i.rd("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.aj.a.aOI().tr("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.cp("preload", "startup");
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
        if (daG) {
            e eVar = dVar.dan;
            aVar = eVar.atS() ? eVar.nF(bVar.getAppId()).atP() : null;
        } else {
            aVar = dVar.cWA;
        }
        if (aVar != null && dVar.dap != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.dap, bVar, fVar);
            dVar.dap = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cWA != null) + " startFirstPage mSlaveManager " + (dVar.dap != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.dap != null) {
                    if (a.C0428a.auM()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.aDG(), eVar.aju(), eVar.aMt());
                        SwanAppConfigData aMt = eVar.aMt();
                        equals = "main".equals(aMt != null ? aMt.sy(a2) : null);
                    }
                    if (equals && eVar.aMt() != null) {
                        com.baidu.swan.apps.core.h.b.auN().a(d.daG ? d.this.dan.nF(eVar.getAppId()).atP() : d.this.cWA, d.this.dap, eVar.aju(), eVar.aMt(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.dam.contains(bVar)) {
            this.dam.add(bVar);
        }
        boolean avI = avI();
        com.baidu.swan.apps.performance.i.aHz().cn("preload", avI ? "1" : "0");
        com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "prepareRuntime preload = " + avI);
        if (avI) {
            avL();
            return;
        }
        daA = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_start"));
        avU();
        final boolean avS = avS();
        if (avS) {
            f bcF = com.baidu.swan.games.utils.so.d.bcF();
            if (!bcF.isSuccess() && bcF.bcP()) {
                avS = false;
            }
        }
        com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "useV8Master:" + avS);
        if (avS) {
            fz(true);
        }
        if (this.dal == null) {
            this.dal = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void ajU() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
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
                            d.this.avU();
                            d.this.avX();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.fz(avS);
                                d.this.avT();
                                return;
                            }
                            PreloadState unused = d.daA = PreloadState.LOAD_FAILED;
                            d.this.avH();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.daE.a(this.dal);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avH() {
        synchronized (this.dau) {
            this.dao = false;
            if (daG) {
                this.dan.reset();
            } else {
                this.cWA = null;
            }
        }
        this.daq = false;
        this.dap = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.lw(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", atX());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion lf = com.baidu.swan.apps.swancore.b.lf(0);
            jSONObject.put("swan app core", lf == null ? "null" : Long.valueOf(lf.swanCoreVersion));
            SwanCoreVersion lf2 = com.baidu.swan.apps.swancore.b.lf(1);
            jSONObject.put("swan game core", lf2 == null ? "null" : Long.valueOf(lf2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).tv(com.baidu.swan.apps.runtime.e.aMk() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aMk().getAppKey()).tw(jSONObject.toString()).axJ();
    }

    public boolean avI() {
        boolean z;
        synchronized (this.dau) {
            z = this.dao && this.daq;
        }
        return z;
    }

    public boolean avJ() {
        boolean z;
        synchronized (this.dau) {
            z = this.dao;
        }
        return z;
    }

    public boolean avK() {
        boolean z;
        synchronized (this.dau) {
            z = this.daq;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avL() {
        if (!this.dam.isEmpty() && avI()) {
            daA = PreloadState.LOADED;
            c.awl();
            oa("event_preload_finish");
            com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.dam) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.L(this);
                }
            }
            this.dam.clear();
        }
    }

    private String V(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.M(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String avM() {
        return !TextUtils.isEmpty(avN()) ? avN() + "runtime/index.js" : "";
    }

    public String avN() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String avO() {
        String str;
        avU();
        if (atX()) {
            str = avM();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.akL()) {
            V(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.apG()) {
            com.baidu.swan.apps.console.debugger.a.d.apD();
            com.baidu.swan.apps.console.debugger.a.d.apz().mQ("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.apJ();
        } else {
            com.baidu.swan.apps.core.e.mZ(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String avP() {
        avU();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.akL()) {
            V(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.apG()) {
            return com.baidu.swan.apps.console.debugger.a.e.apK();
        } else {
            com.baidu.swan.apps.core.e.mZ(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avQ() {
        if (!this.cWK.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cWK.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cKK);
                }
                b(next);
            }
            this.cWK.clear();
        }
    }

    public boolean atX() {
        return daG ? this.dan.atX() : this.cWA instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a avR() {
        if (daG) {
            if (!this.dan.atU()) {
                return null;
            }
            return this.dan.atV().atP();
        }
        return this.cWA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fz(boolean z) {
        boolean z2;
        synchronized (this.dau) {
            if (daG) {
                z2 = this.dan.atT();
            } else {
                z2 = this.cWA != null;
            }
            if (!this.dao && !z2) {
                com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (daG) {
                    this.dan.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.dau) {
                                d.this.dao = true;
                                d.this.avQ();
                                d.this.avL();
                            }
                        }
                    });
                    return;
                }
                this.cWA = this.daD.r(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cWA.loadUrl(avO());
                this.cWA.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void ig(String str) {
                        com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.dau) {
                            d.this.dao = true;
                            d.this.avQ();
                            d.this.avL();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a r = this.daD.r(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        r.loadUrl(avO());
        r.a(gVar);
        return r;
    }

    private boolean avS() {
        if (com.baidu.swan.apps.console.debugger.a.e.apG() || com.baidu.swan.apps.t.a.aAD().akL()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.bcK() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.bcK()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0436d.akg() && new File(avM()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avT() {
        if (!this.daq && this.dap == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.dap = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void ig(String str) {
                    com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.daq = true;
                    d.this.avL();
                }
            });
            avZ();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c ch = this.daD.ch(context);
            com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String avP = avP();
            if (avP != null) {
                com.baidu.swan.apps.runtime.e aMl = com.baidu.swan.apps.runtime.e.aMl();
                if (aMl != null && !TextUtils.isEmpty(aMl.getAppKey())) {
                    avP = Uri.parse(avP).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aMl.getAppKey(), aMl.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!avP.endsWith(File.separator)) {
                        avP = avP + File.separator;
                    }
                }
                ch.loadUrl(avP);
            }
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "prepareSlave loadUrl " + avP);
            ch.a(gVar);
            return ch;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.cI(context);
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
    public void avU() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.lf(0));
        }
    }

    public SwanCoreVersion avV() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore avW() {
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
    public void avX() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.iN(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.avW();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.das.put(eVar.amt(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String amt = eVar.amt();
        this.das.remove(amt);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", amt);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.aLH();
    }

    public com.baidu.swan.apps.adaptation.b.e ob(String str) {
        if (this.das.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.das.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a anh;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.dau) {
            if (!this.dao) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cKK)));
                }
                this.cWK.add(aVar);
                return;
            }
            if (daG) {
                if (!this.dan.atU()) {
                    this.dan.a(aVar);
                    return;
                } else if (this.dan.atV() != null) {
                    anh = this.dan.atV().atP().anh();
                } else {
                    return;
                }
            } else if (this.cWA != null) {
                anh = this.cWA.anh();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cKK);
            }
            com.baidu.swan.apps.event.a.a(anh, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.nC(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.das.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.amr(), aVar);
    }

    @Nullable
    public String avY() {
        avZ();
        return this.daw;
    }

    private void avZ() {
        if (TextUtils.isEmpty(this.daw)) {
            this.daw = this.dap != null ? this.dap.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bs("SwanAppCoreRuntime", "initWebViewUa ua: " + this.daw);
        }
    }

    public void fA(boolean z) {
        boolean z2;
        if (daG) {
            z2 = this.dan.atT();
        } else {
            z2 = this.cWA != null;
        }
        if (z && !this.dao && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.dau) {
                this.dao = true;
                avQ();
                avL();
            }
        } else if (!z && this.dap != null && !this.daq) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.rd("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.daq = true;
            avL();
        }
    }

    public void fB(boolean z) {
        this.dar = z;
    }

    public boolean awa() {
        return this.dar;
    }

    public String awb() {
        return this.dav;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awc() {
        boolean z = true;
        if (this.daF) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.daF = true;
        com.baidu.swan.apps.runtime.d aMg = com.baidu.swan.apps.runtime.d.aMg();
        z = (aMg == null || !aMg.aJw()) ? false : false;
        boolean aku = com.baidu.swan.apps.t.a.aAu().aku();
        if (!z && aku) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.cN(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + aku);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (daG && com.baidu.swan.apps.core.prefetch.a.a.auK()) {
            this.dan.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cS(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes9.dex */
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
    /* loaded from: classes9.dex */
    public static class C0436d {
        private static final boolean daV;
        private static boolean daW;
        private static boolean daX;

        static {
            daV = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.akF() : com.baidu.swan.apps.t.a.aAu().akF();
            daW = daV ? true : com.baidu.swan.apps.t.a.aAu().akg();
            daX = daW;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                daW = intent.getBooleanExtra("bundle_key_v8_ab", daW);
            }
        }

        public static void awq() {
            daX = daW;
        }

        public static String awr() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void oc(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean akg() {
            if (d.DEBUG) {
                String awr = awr();
                char c = 65535;
                switch (awr.hashCode()) {
                    case -1406842887:
                        if (awr.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (awr.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (awr.equals("V8")) {
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
            return daX;
        }

        public static boolean aws() {
            String awr = awr();
            if (awr.equals("V8")) {
                return true;
            }
            if (awr.equals("AB")) {
                if (daV) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.aAu().akg();
            }
            return false;
        }

        public static String iF(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void fC(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aMg().aMc().aMD()) {
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
            } else if (avI()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ao.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: g */
                    public void L(Boolean bool) {
                        d.this.iE(c.h(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iE(int i) {
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
                boolean alj = com.baidu.swan.apps.t.a.aAP().alj();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + alj);
                }
                if (bVar != null) {
                    bVar.L(Boolean.valueOf(alj));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes9.dex */
    public static class c {
        private static final int daQ = a.awg();
        private static final int daR = a.awh();
        private static int daS = 0;
        private static int daT = daS;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.dak.avI()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.daT >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.daU)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.daU, a.awi());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.avC();
                    c.a(new com.baidu.swan.apps.al.a().cV(5L).cW(49L).uz("start retry"));
                }
            }
        };
        private static final Runnable daU = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.dak.avI()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.daT >= 1) {
                    com.baidu.swan.apps.al.a uz = new com.baidu.swan.apps.al.a().cV(5L).cW(49L).uz("retry timeout");
                    c.a(uz);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), uz, 0, com.baidu.swan.apps.runtime.d.aMg().getAppId());
                    com.baidu.swan.apps.ao.e.N(com.baidu.swan.apps.runtime.d.aMg().aMe());
                }
            }
        };

        static void a(com.baidu.swan.apps.al.a aVar) {
            int ajk;
            com.baidu.swan.apps.runtime.e aMc = com.baidu.swan.apps.runtime.d.aMg().aMc();
            if (aMc != null && (ajk = aMc.ajk()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aMc.aju()).tH(com.baidu.swan.apps.statistic.h.kX(ajk)).tI(com.baidu.swan.apps.runtime.e.aMm()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> awj() {
            return new CopyOnWriteArrayList<>(d.dak.dam);
        }

        static void awk() {
            daT++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + daT);
            }
        }

        static void awl() {
            daT = daS;
        }

        public static int h(Boolean bool) {
            return bool.booleanValue() ? daQ : daR;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private static int daP = -1;

        static int awf() {
            if (daP < 0) {
                daP = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return daP;
        }

        public static boolean isEnable() {
            boolean z = awf() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int awg() {
            int i = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int awh() {
            int i = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int awi() {
            int i = com.baidu.swan.apps.t.a.aAu().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
