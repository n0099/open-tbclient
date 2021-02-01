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
/* loaded from: classes9.dex */
public final class d implements h {
    private static volatile d cXK;
    private com.baidu.swan.apps.core.g.a cUb;
    private com.baidu.swan.apps.core.container.a.b cXL;
    private e cXN;
    private boolean cXO;
    private com.baidu.swan.apps.adaptation.b.c cXP;
    private boolean cXQ;
    private boolean cXR;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cXS;
    private String cXV;
    private b cYa;
    private ba cYb;
    private i cYc;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cXW = 10150;
    public static boolean cXX = false;
    private static PreloadState cXY = PreloadState.UNKNOWN;
    private static boolean cXZ = false;
    private static final boolean cYe = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> cXM = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cUl = new LinkedList<>();
    private final Object cXT = new Object();
    private final String cXU = UUID.randomUUID().toString();
    private volatile boolean cYd = false;

    private static PreloadState asb() {
        return cXY;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> asc() {
        return this.cXS;
    }

    public static int asd() {
        return asb().statsCode(cXZ);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cXS = new HashMap<>();
        this.cYb = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cYc = com.baidu.swan.apps.adaptation.b.a.c.ajh().aji().ajf();
        if (cYe) {
            this.cXN = new e();
        }
    }

    public static d ase() {
        if (cXK == null) {
            synchronized (d.class) {
                if (cXK == null) {
                    cXK = new d();
                }
            }
        }
        return cXK;
    }

    public ba asf() {
        return this.cYb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void asg() {
        synchronized (d.class) {
            p(false, true);
        }
    }

    public static synchronized void ash() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aEz()) {
                com.baidu.swan.apps.runtime.d.aIG().aIB().iv(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cXK == null || cXK.aso()) {
                    com.baidu.swan.apps.runtime.d.aIG().aIB().iv(15);
                    release(false);
                } else {
                    if (cXK.cYa == null) {
                        cXK.cYa = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aIG().getAppId());
                                com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aIG().aIB().iv(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cXK.a(cXK.cYa);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "release");
            p(z, false);
        }
    }

    private static synchronized void p(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cXK != null) {
                cXY = PreloadState.UNKNOWN;
                cXK.mIsReleased = true;
                cXK.cYa = null;
                cXX = false;
                if (z2) {
                    c.asP();
                    copyOnWriteArrayList = c.asO();
                }
                if (cXK.cXL != null) {
                    cXK.cYc.b(cXK.cXL);
                }
                com.baidu.swan.apps.api.module.l.e.akC();
                com.baidu.swan.apps.swancore.a.a.aMn();
                asi();
                com.baidu.swan.apps.v.i.b(cXK);
                cXK = null;
                com.baidu.swan.apps.core.h.b.arr().reset();
                cXZ = z;
                ase().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void asi() {
        if (cXK.cXS != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cXK.cXS.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        asj();
        if (cXK.cXP != null) {
            cXK.cXP = null;
        }
    }

    private static void asj() {
        if (cYe) {
            if (cXK.cXN != null) {
                cXK.cXN.reset();
            }
        } else if (cXK.cUb != null) {
            if (cXK.cUb instanceof com.baidu.swan.apps.core.g.e) {
                cXK.cUb.destroy();
            }
            cXK.cUb = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (asn()) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cXX = true;
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        nh("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.jC(0);
            extensionCore = com.baidu.swan.apps.extcore.b.hk(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.axt().gb(intent.getIntExtra("bundle_key_preload_switch", cXW));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            nh("event_preload_error");
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0416d.asV();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ao.i.aNH();
            }
        }, "prepare ab description");
        if (asx()) {
            f aYY = com.baidu.swan.games.utils.so.d.aYY();
            if (!aYY.isSuccess() && !aYY.aZi()) {
                nh("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            ask();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void ask() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.u(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).jj(1).aIs();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.k(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.asH();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aFJ().iv(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cXM == null) {
            this.cXM = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cXM.contains(next)) {
                this.cXM.add(next);
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

    private void nh(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cXY.statsCode(cXZ));
        com.baidu.swan.apps.runtime.d.aIG().g(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.asA();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.asA());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aEb().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.aj.a.aLi().sz("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.mIsReleased) {
                            com.baidu.swan.apps.performance.i.qk("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.aj.a.aLi().sz("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.ci("preload", "startup");
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
        if (cYe) {
            e eVar = dVar.cXN;
            aVar = eVar.aqw() ? eVar.mM(bVar.getAppId()).aqt() : null;
        } else {
            aVar = dVar.cUb;
        }
        if (aVar != null && dVar.cXP != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cXP, bVar, fVar);
            dVar.cXP = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cUb != null) + " startFirstPage mSlaveManager " + (dVar.cXP != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cXP != null) {
                    if (a.C0408a.arq()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.aAl(), eVar.afZ(), eVar.aIT());
                        SwanAppConfigData aIT = eVar.aIT();
                        equals = "main".equals(aIT != null ? aIT.rF(a2) : null);
                    }
                    if (equals && eVar.aIT() != null) {
                        com.baidu.swan.apps.core.h.b.arr().a(d.cYe ? d.this.cXN.mM(eVar.getAppId()).aqt() : d.this.cUb, d.this.cXP, eVar.afZ(), eVar.aIT(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cXM.contains(bVar)) {
            this.cXM.add(bVar);
        }
        boolean asn = asn();
        com.baidu.swan.apps.performance.i.aEb().cg("preload", asn ? "1" : "0");
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareRuntime preload = " + asn);
        if (asn) {
            asq();
            return;
        }
        cXY = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_start"));
        asz();
        final boolean asx = asx();
        if (asx) {
            f aYY = com.baidu.swan.games.utils.so.d.aYY();
            if (!aYY.isSuccess() && aYY.aZi()) {
                asx = false;
            }
        }
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "useV8Master:" + asx);
        if (asx) {
            fx(true);
        }
        if (this.cXL == null) {
            this.cXL = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void agz() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
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
                            d.this.asz();
                            d.this.asC();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.fx(asx);
                                d.this.asy();
                                return;
                            }
                            PreloadState unused = d.cXY = PreloadState.LOAD_FAILED;
                            d.this.asl();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cYc.a(this.cXL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asl() {
        synchronized (this.cXT) {
            this.cXO = false;
            if (cYe) {
                this.cXN.reset();
            } else {
                this.cUb = null;
            }
        }
        this.cXQ = false;
        this.cXP = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.jT(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", aqB());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion jC = com.baidu.swan.apps.swancore.b.jC(0);
            jSONObject.put("swan app core", jC == null ? "null" : Long.valueOf(jC.swanCoreVersion));
            SwanCoreVersion jC2 = com.baidu.swan.apps.swancore.b.jC(1);
            jSONObject.put("swan game core", jC2 == null ? "null" : Long.valueOf(jC2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).sD(com.baidu.swan.apps.runtime.e.aIK() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aIK().getAppKey()).sE(jSONObject.toString()).auo();
    }

    public boolean asn() {
        boolean z;
        synchronized (this.cXT) {
            z = this.cXO && this.cXQ;
        }
        return z;
    }

    public boolean aso() {
        boolean z;
        synchronized (this.cXT) {
            z = this.cXO;
        }
        return z;
    }

    public boolean asp() {
        boolean z;
        synchronized (this.cXT) {
            z = this.cXQ;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asq() {
        if (!this.cXM.isEmpty() && asn()) {
            cXY = PreloadState.LOADED;
            c.asQ();
            nh("event_preload_finish");
            com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cXM) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.L(this);
                }
            }
            this.cXM.clear();
        }
    }

    private String U(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.M(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String asr() {
        return !TextUtils.isEmpty(ass()) ? ass() + "runtime/index.js" : "";
    }

    public String ass() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String ast() {
        String str;
        asz();
        if (aqB()) {
            str = asr();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.ahq()) {
            U(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.amk()) {
            com.baidu.swan.apps.console.debugger.a.d.amh();
            com.baidu.swan.apps.console.debugger.a.d.amd().lX("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.amn();
        } else {
            com.baidu.swan.apps.core.e.mg(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String asu() {
        asz();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.ahq()) {
            U(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.amk()) {
            return com.baidu.swan.apps.console.debugger.a.e.amo();
        } else {
            com.baidu.swan.apps.core.e.mg(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asv() {
        if (!this.cUl.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cUl.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cIt);
                }
                b(next);
            }
            this.cUl.clear();
        }
    }

    public boolean aqB() {
        return cYe ? this.cXN.aqB() : this.cUb instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a asw() {
        if (cYe) {
            if (!this.cXN.aqy()) {
                return null;
            }
            return this.cXN.aqz().aqt();
        }
        return this.cUb;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(boolean z) {
        boolean z2;
        synchronized (this.cXT) {
            if (cYe) {
                z2 = this.cXN.aqx();
            } else {
                z2 = this.cUb != null;
            }
            if (!this.cXO && !z2) {
                com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cYe) {
                    this.cXN.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cXT) {
                                d.this.cXO = true;
                                d.this.asv();
                                d.this.asq();
                            }
                        }
                    });
                    return;
                }
                this.cUb = this.cYb.r(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cUb.loadUrl(ast());
                this.cUb.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void iu(String str) {
                        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cXT) {
                            d.this.cXO = true;
                            d.this.asv();
                            d.this.asq();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a r = this.cYb.r(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        r.loadUrl(ast());
        r.a(gVar);
        return r;
    }

    private boolean asx() {
        if (com.baidu.swan.apps.console.debugger.a.e.amk() || com.baidu.swan.apps.t.a.axi().ahq()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aZd() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aZd()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0416d.agL() && new File(asr()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asy() {
        if (!this.cXQ && this.cXP == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cXP = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void iu(String str) {
                    com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cXQ = true;
                    d.this.asq();
                }
            });
            asE();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c cf = this.cYb.cf(context);
            com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String asu = asu();
            if (asu != null) {
                com.baidu.swan.apps.runtime.e aIL = com.baidu.swan.apps.runtime.e.aIL();
                if (aIL != null && !TextUtils.isEmpty(aIL.getAppKey())) {
                    asu = Uri.parse(asu).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aIL.getAppKey(), aIL.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!asu.endsWith(File.separator)) {
                        asu = asu + File.separator;
                    }
                }
                cf.loadUrl(asu);
            }
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareSlave loadUrl " + asu);
            cf.a(gVar);
            return cf;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.cG(context);
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
    public void asz() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.jC(0));
        }
    }

    public SwanCoreVersion asA() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore asB() {
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
    public void asC() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.hk(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.asB();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cXS.put(eVar.aiY(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String aiY = eVar.aiY();
        this.cXS.remove(aiY);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", aiY);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.aIh();
    }

    public com.baidu.swan.apps.adaptation.b.e ni(String str) {
        if (this.cXS.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cXS.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a ajM;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cXT) {
            if (!this.cXO) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cIt)));
                }
                this.cUl.add(aVar);
                return;
            }
            if (cYe) {
                if (!this.cXN.aqy()) {
                    this.cXN.a(aVar);
                    return;
                } else if (this.cXN.aqz() != null) {
                    ajM = this.cXN.aqz().aqt().ajM();
                } else {
                    return;
                }
            } else if (this.cUb != null) {
                ajM = this.cUb.ajM();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cIt);
            }
            com.baidu.swan.apps.event.a.a(ajM, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.mJ(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cXS.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.aiW(), aVar);
    }

    @Nullable
    public String asD() {
        asE();
        return this.cXV;
    }

    private void asE() {
        if (TextUtils.isEmpty(this.cXV)) {
            this.cXV = this.cXP != null ? this.cXP.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cXV);
        }
    }

    public void fy(boolean z) {
        boolean z2;
        if (cYe) {
            z2 = this.cXN.aqx();
        } else {
            z2 = this.cUb != null;
        }
        if (z && !this.cXO && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cXT) {
                this.cXO = true;
                asv();
                asq();
            }
        } else if (!z && this.cXP != null && !this.cXQ) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.qk("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cXQ = true;
            asq();
        }
    }

    public void fz(boolean z) {
        this.cXR = z;
    }

    public boolean asF() {
        return this.cXR;
    }

    public String asG() {
        return this.cXU;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asH() {
        boolean z = true;
        if (this.cYd) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cYd = true;
        com.baidu.swan.apps.runtime.d aIG = com.baidu.swan.apps.runtime.d.aIG();
        z = (aIG == null || !aIG.aFY()) ? false : false;
        boolean agZ = com.baidu.swan.apps.t.a.awZ().agZ();
        if (!z && agZ) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.cL(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + agZ);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cYe && com.baidu.swan.apps.core.prefetch.a.a.aro()) {
            this.cXN.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cY(this.mSwanCoreVersion.swanCoreVersion));
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
    public static class C0416d {
        private static final boolean cYt;
        private static boolean cYu;
        private static boolean cYv;

        static {
            cYt = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.ahk() : com.baidu.swan.apps.t.a.awZ().ahk();
            cYu = cYt ? true : com.baidu.swan.apps.t.a.awZ().agL();
            cYv = cYu;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cYu = intent.getBooleanExtra("bundle_key_v8_ab", cYu);
            }
        }

        public static void asV() {
            cYv = cYu;
        }

        public static String asW() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void nj(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean agL() {
            if (d.DEBUG) {
                String asW = asW();
                char c = 65535;
                switch (asW.hashCode()) {
                    case -1406842887:
                        if (asW.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (asW.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (asW.equals("V8")) {
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
            return cYv;
        }

        public static boolean asX() {
            String asW = asW();
            if (asW.equals("V8")) {
                return true;
            }
            if (asW.equals("AB")) {
                if (cYt) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.awZ().agL();
            }
            return false;
        }

        public static String hc(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void fA(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aIG().aIC().aJd()) {
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
            } else if (asn()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ao.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: g */
                    public void L(Boolean bool) {
                        d.this.hb(c.h(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hb(int i) {
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
                boolean ahO = com.baidu.swan.apps.t.a.axu().ahO();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + ahO);
                }
                if (bVar != null) {
                    bVar.L(Boolean.valueOf(ahO));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes9.dex */
    public static class c {
        private static final int cYo = a.asL();
        private static final int cYp = a.asM();
        private static int cYq = 0;
        private static int cYr = cYq;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cXK.asn()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cYr >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cYs)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cYs, a.asN());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.asg();
                    c.a(new com.baidu.swan.apps.al.a().db(5L).dc(49L).tH("start retry"));
                }
            }
        };
        private static final Runnable cYs = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cXK.asn()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cYr >= 1) {
                    com.baidu.swan.apps.al.a tH = new com.baidu.swan.apps.al.a().db(5L).dc(49L).tH("retry timeout");
                    c.a(tH);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), tH, 0, com.baidu.swan.apps.runtime.d.aIG().getAppId());
                    com.baidu.swan.apps.ao.e.H(com.baidu.swan.apps.runtime.d.aIG().aIE());
                }
            }
        };

        static void a(com.baidu.swan.apps.al.a aVar) {
            int frameType;
            com.baidu.swan.apps.runtime.e aIC = com.baidu.swan.apps.runtime.d.aIG().aIC();
            if (aIC != null && (frameType = aIC.getFrameType()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aIC.afZ()).sP(com.baidu.swan.apps.statistic.h.ju(frameType)).sQ(com.baidu.swan.apps.runtime.e.aIM()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> asO() {
            return new CopyOnWriteArrayList<>(d.cXK.cXM);
        }

        static void asP() {
            cYr++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cYr);
            }
        }

        static void asQ() {
            cYr = cYq;
        }

        public static int h(Boolean bool) {
            return bool.booleanValue() ? cYo : cYp;
        }
    }

    /* loaded from: classes9.dex */
    public static class a {
        private static int cYn = -1;

        static int asK() {
            if (cYn < 0) {
                cYn = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cYn;
        }

        public static boolean isEnable() {
            boolean z = asK() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int asL() {
            int i = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int asM() {
            int i = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_core_runtime_high_end_timeout", SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int asN() {
            int i = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
