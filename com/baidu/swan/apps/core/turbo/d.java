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
/* loaded from: classes3.dex */
public final class d implements h {
    private static volatile d cpC;
    private com.baidu.swan.apps.core.g.a clN;
    private com.baidu.swan.apps.core.container.a.b cpD;
    private e cpF;
    private boolean cpG;
    private com.baidu.swan.apps.adaptation.b.c cpH;
    private boolean cpI;
    private boolean cpJ;
    private boolean cpK;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cpL;
    private String cpO;
    private b cpT;
    private ba cpU;
    private i cpV;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cpP = 10150;
    public static boolean cpQ = false;
    private static PreloadState cpR = PreloadState.UNKNOWN;
    private static boolean cpS = false;
    private static final boolean cpX = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> cpE = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> clX = new LinkedList<>();
    private final Object cpM = new Object();
    private final String cpN = UUID.randomUUID().toString();
    private volatile boolean cpW = false;

    private static PreloadState akz() {
        return cpR;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> akA() {
        return this.cpL;
    }

    public static int akB() {
        return akz().statsCode(cpS);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cpL = new HashMap<>();
        this.cpU = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cpV = com.baidu.swan.apps.adaptation.b.a.c.abM().abN().abK();
        if (cpX) {
            this.cpF = new e();
        }
    }

    public static d akC() {
        if (cpC == null) {
            synchronized (d.class) {
                if (cpC == null) {
                    cpC = new d();
                }
            }
        }
        return cpC;
    }

    public ba akD() {
        return this.cpU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void akE() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void akF() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.awZ()) {
                com.baidu.swan.apps.runtime.d.aAn().aAi().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cpC == null || cpC.akL()) {
                    com.baidu.swan.apps.runtime.d.aAn().aAi().sendMessage(15);
                    release(false);
                } else {
                    if (cpC.cpT == null) {
                        cpC.cpT = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aAn().getAppId());
                                com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aAn().aAi().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cpC.a(cpC.cpT);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cpC != null) {
                cpR = PreloadState.UNKNOWN;
                cpC.cpJ = true;
                cpC.cpT = null;
                cpQ = false;
                if (z2) {
                    c.alm();
                    copyOnWriteArrayList = c.all();
                }
                if (cpC.cpD != null) {
                    cpC.cpV.b(cpC.cpD);
                }
                com.baidu.swan.apps.api.module.l.e.adh();
                com.baidu.swan.apps.swancore.a.a.aDV();
                akG();
                com.baidu.swan.apps.v.i.b(cpC);
                cpC = null;
                com.baidu.swan.apps.core.h.b.ajQ().reset();
                cpS = z;
                akC().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void akG() {
        if (cpC.cpL != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cpC.cpL.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        akH();
        if (cpC.cpH != null) {
            cpC.cpH = null;
        }
    }

    private static void akH() {
        if (cpX) {
            if (cpC.cpF != null) {
                cpC.cpF.reset();
            }
        } else if (cpC.clN != null) {
            if (cpC.clN instanceof com.baidu.swan.apps.core.g.e) {
                cpC.clN.destroy();
            }
            cpC.clN = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (akK()) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cpQ = true;
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        mm("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.jO(0);
            extensionCore = com.baidu.swan.apps.extcore.b.hG(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.apR().gz(intent.getIntExtra("bundle_key_preload_switch", cpP));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            mm("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0391d.alr();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aFo();
            }
        }, "prepare ab description");
        if (akU()) {
            f aQL = com.baidu.swan.games.utils.so.d.aQL();
            if (!aQL.isSuccess() && !aQL.aQV()) {
                mm("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            akI();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void akI() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).ju(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.ale();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.ayl().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cpE == null) {
            this.cpE = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cpE.contains(next)) {
                this.cpE.add(next);
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

    private void mm(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cpR.statsCode(cpS));
        com.baidu.swan.apps.runtime.d.aAn().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.akX();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.akX());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.awB().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aCP().ry("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cpJ) {
                            com.baidu.swan.apps.performance.i.pq("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aCP().ry("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.bY("preload", "startup");
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
        if (cpX) {
            e eVar = dVar.cpF;
            aVar = eVar.aiV() ? eVar.lR(bVar.getAppId()).aiS() : null;
        } else {
            aVar = dVar.clN;
        }
        if (aVar != null && dVar.cpH != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cpH, bVar, fVar);
            dVar.cpH = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.clN != null) + " startFirstPage mSlaveManager " + (dVar.cpH != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cpH != null) {
                    if (a.C0383a.ajP()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.asJ(), eVar.YI(), eVar.aAA());
                        SwanAppConfigData aAA = eVar.aAA();
                        equals = "main".equals(aAA != null ? aAA.qG(a2) : null);
                    }
                    if (equals && eVar.aAA() != null) {
                        com.baidu.swan.apps.core.h.b.ajQ().a(d.cpX ? d.this.cpF.lR(eVar.getAppId()).aiS() : d.this.clN, d.this.cpH, eVar.YI(), eVar.aAA(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cpE.contains(bVar)) {
            this.cpE.add(bVar);
        }
        boolean akK = akK();
        com.baidu.swan.apps.performance.i.awB().bW("preload", akK ? "1" : "0");
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareRuntime preload = " + akK);
        if (akK) {
            akN();
            return;
        }
        cpR = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_start"));
        akW();
        final boolean akU = akU();
        if (akU) {
            f aQL = com.baidu.swan.games.utils.so.d.aQL();
            if (!aQL.isSuccess() && aQL.aQV()) {
                akU = false;
            }
        }
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "useV8Master:" + akU);
        if (akU) {
            eg(true);
        }
        if (this.cpD == null) {
            this.cpD = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Zg() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cpJ);
                            }
                            if (d.this.cpJ) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.akW();
                            d.this.akZ();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.eg(akU);
                                d.this.akV();
                                return;
                            }
                            PreloadState unused = d.cpR = PreloadState.LOAD_FAILED;
                            d.this.akJ();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cpV.a(this.cpD);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        synchronized (this.cpM) {
            this.cpG = false;
            if (cpX) {
                this.cpF.reset();
            } else {
                this.clN = null;
            }
        }
        this.cpI = false;
        this.cpH = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.kf(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", aja());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion jO = com.baidu.swan.apps.swancore.b.jO(0);
            jSONObject.put("swan app core", jO == null ? "null" : Long.valueOf(jO.swanCoreVersion));
            SwanCoreVersion jO2 = com.baidu.swan.apps.swancore.b.jO(1);
            jSONObject.put("swan game core", jO2 == null ? "null" : Long.valueOf(jO2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).rC(com.baidu.swan.apps.runtime.e.aAr() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aAr().getAppKey()).rD(jSONObject.toString()).amK();
    }

    public boolean akK() {
        boolean z;
        synchronized (this.cpM) {
            z = this.cpG && this.cpI;
        }
        return z;
    }

    public boolean akL() {
        boolean z;
        synchronized (this.cpM) {
            z = this.cpG;
        }
        return z;
    }

    public boolean akM() {
        boolean z;
        synchronized (this.cpM) {
            z = this.cpI;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akN() {
        if (!this.cpE.isEmpty() && akK()) {
            cpR = PreloadState.LOADED;
            c.aln();
            mm("event_preload_finish");
            com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cpE) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.J(this);
                }
            }
            this.cpE.clear();
        }
    }

    private String O(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.y(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String akO() {
        return !TextUtils.isEmpty(akP()) ? akP() + "runtime/index.js" : "";
    }

    public String akP() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String akQ() {
        String str;
        akW();
        if (aja()) {
            str = akO();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.ZX()) {
            O(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.aeO()) {
            com.baidu.swan.apps.console.debugger.a.d.aeL();
            com.baidu.swan.apps.console.debugger.a.d.aeH().lc("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.aeR();
        } else {
            com.baidu.swan.apps.core.e.ll(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String akR() {
        akW();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.ZX()) {
            O(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.aeO()) {
            return com.baidu.swan.apps.console.debugger.a.e.aeS();
        } else {
            com.baidu.swan.apps.core.e.ll(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akS() {
        if (!this.clX.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.clX.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bZZ);
                }
                b(next);
            }
            this.clX.clear();
        }
    }

    public boolean aja() {
        return cpX ? this.cpF.aja() : this.clN instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a akT() {
        if (cpX) {
            if (!this.cpF.aiX()) {
                return null;
            }
            return this.cpF.aiY().aiS();
        }
        return this.clN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eg(boolean z) {
        boolean z2;
        synchronized (this.cpM) {
            if (cpX) {
                z2 = this.cpF.aiW();
            } else {
                z2 = this.clN != null;
            }
            if (!this.cpG && !z2) {
                com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cpX) {
                    this.cpF.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cpM) {
                                d.this.cpG = true;
                                d.this.akS();
                                d.this.akN();
                            }
                        }
                    });
                    return;
                }
                this.clN = this.cpU.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.clN.loadUrl(akQ());
                this.clN.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void hp(String str) {
                        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cpM) {
                            d.this.cpG = true;
                            d.this.akS();
                            d.this.akN();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a h = this.cpU.h(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        h.loadUrl(akQ());
        h.a(gVar);
        return h;
    }

    private boolean akU() {
        if (com.baidu.swan.apps.console.debugger.a.e.aeO() || com.baidu.swan.apps.t.a.apG().ZX()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aQQ() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aQQ()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0391d.Zs() && new File(akO()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akV() {
        if (!this.cpI && this.cpH == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cpH = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void hp(String str) {
                    com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cpI = true;
                    d.this.akN();
                }
            });
            alb();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c bo = this.cpU.bo(context);
            com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String akR = akR();
            if (akR != null) {
                com.baidu.swan.apps.runtime.e aAs = com.baidu.swan.apps.runtime.e.aAs();
                if (aAs != null && !TextUtils.isEmpty(aAs.getAppKey())) {
                    akR = Uri.parse(akR).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aAs.getAppKey(), aAs.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!akR.endsWith(File.separator)) {
                        akR = akR + File.separator;
                    }
                }
                bo.loadUrl(akR);
            }
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareSlave loadUrl " + akR);
            bo.a(gVar);
            return bo;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.bO(context);
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
    public void akW() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.jO(0));
        }
    }

    public SwanCoreVersion akX() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore akY() {
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
    public void akZ() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.hG(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.akY();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cpL.put(eVar.abD(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String abD = eVar.abD();
        this.cpL.remove(abD);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", abD);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e mn(String str) {
        if (this.cpL.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cpL.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a acr;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cpM) {
            if (!this.cpG) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bZZ)));
                }
                this.clX.add(aVar);
                return;
            }
            if (cpX) {
                if (!this.cpF.aiX()) {
                    this.cpF.a(aVar);
                    return;
                } else if (this.cpF.aiY() != null) {
                    acr = this.cpF.aiY().aiS().acr();
                } else {
                    return;
                }
            } else if (this.clN != null) {
                acr = this.clN.acr();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.bZZ);
            }
            com.baidu.swan.apps.event.a.a(acr, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.lO(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cpL.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.abB(), aVar);
    }

    @Nullable
    public String ala() {
        alb();
        return this.cpO;
    }

    private void alb() {
        if (TextUtils.isEmpty(this.cpO)) {
            this.cpO = this.cpH != null ? this.cpH.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cpO);
        }
    }

    public void eh(boolean z) {
        boolean z2;
        if (cpX) {
            z2 = this.cpF.aiW();
        } else {
            z2 = this.clN != null;
        }
        if (z && !this.cpG && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cpM) {
                this.cpG = true;
                akS();
                akN();
            }
        } else if (!z && this.cpH != null && !this.cpI) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.pq("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cpI = true;
            akN();
        }
    }

    public void ei(boolean z) {
        this.cpK = z;
    }

    public boolean alc() {
        return this.cpK;
    }

    public String ald() {
        return this.cpN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ale() {
        boolean z = true;
        if (this.cpW) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cpW = true;
        com.baidu.swan.apps.runtime.d aAn = com.baidu.swan.apps.runtime.d.aAn();
        z = (aAn == null || !aAn.ayA()) ? false : false;
        boolean ZG = com.baidu.swan.apps.t.a.apx().ZG();
        if (!z && ZG) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bT(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + ZG);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cpX && com.baidu.swan.apps.core.prefetch.a.a.ajN()) {
            this.cpF.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.bM(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes3.dex */
    public static abstract class b implements com.baidu.swan.apps.ap.e.b<d> {
        protected abstract void o(d dVar);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public void J(d dVar) {
            o(dVar);
        }
    }

    /* renamed from: com.baidu.swan.apps.core.turbo.d$d  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public static class C0391d {
        private static final boolean cqm;
        private static boolean cqn;
        private static boolean cqo;

        static {
            cqm = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.ZR() : com.baidu.swan.apps.t.a.apx().ZR();
            cqn = cqm ? true : com.baidu.swan.apps.t.a.apx().Zs();
            cqo = cqn;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cqn = intent.getBooleanExtra("bundle_key_v8_ab", cqn);
            }
        }

        public static void alr() {
            cqo = cqn;
        }

        public static String als() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void mo(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean Zs() {
            if (d.DEBUG) {
                String als = als();
                char c = 65535;
                switch (als.hashCode()) {
                    case -1406842887:
                        if (als.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (als.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (als.equals("V8")) {
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
            return cqo;
        }

        public static boolean alt() {
            String als = als();
            if (als.equals("V8")) {
                return true;
            }
            if (als.equals("AB")) {
                if (cqm) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.apx().Zs();
            }
            return false;
        }

        public static String hy(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void ej(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aAn().aAj().aAK()) {
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
            } else if (akK()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: e */
                    public void J(Boolean bool) {
                        d.this.hx(c.f(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hx(int i) {
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
                boolean aav = com.baidu.swan.apps.t.a.apS().aav();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + aav);
                }
                if (bVar != null) {
                    bVar.J(Boolean.valueOf(aav));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes3.dex */
    public static class c {
        private static final int cqh = a.ali();
        private static final int cqi = a.alj();
        private static int cqj = 0;
        private static int cqk = cqj;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cpC.akK()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cqk >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cql)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cql, a.alk());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.akE();
                    c.a(new com.baidu.swan.apps.am.a().bP(5L).bQ(49L).sH("start retry"));
                }
            }
        };
        private static final Runnable cql = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cpC.akK()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cqk >= 1) {
                    com.baidu.swan.apps.am.a sH = new com.baidu.swan.apps.am.a().bP(5L).bQ(49L).sH("retry timeout");
                    c.a(sH);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), sH, 0, com.baidu.swan.apps.runtime.d.aAn().getAppId());
                    com.baidu.swan.apps.ap.e.M(com.baidu.swan.apps.runtime.d.aAn().aAl());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int Yy;
            com.baidu.swan.apps.runtime.e aAj = com.baidu.swan.apps.runtime.d.aAn().aAj();
            if (aAj != null && (Yy = aAj.Yy()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aAj.YI()).rO(com.baidu.swan.apps.statistic.h.jG(Yy)).rP(com.baidu.swan.apps.runtime.e.aAt()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> all() {
            return new CopyOnWriteArrayList<>(d.cpC.cpE);
        }

        static void alm() {
            cqk++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cqk);
            }
        }

        static void aln() {
            cqk = cqj;
        }

        public static int f(Boolean bool) {
            return bool.booleanValue() ? cqh : cqi;
        }
    }

    /* loaded from: classes3.dex */
    public static class a {
        private static int cqg = -1;

        static int alh() {
            if (cqg < 0) {
                cqg = com.baidu.swan.apps.t.a.apx().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cqg;
        }

        public static boolean isEnable() {
            boolean z = alh() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int ali() {
            int i = com.baidu.swan.apps.t.a.apx().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int alj() {
            int i = com.baidu.swan.apps.t.a.apx().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int alk() {
            int i = com.baidu.swan.apps.t.a.apx().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
