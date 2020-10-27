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
    private static volatile d cKm;
    private com.baidu.swan.apps.core.g.a cGB;
    private b cKD;
    private ba cKE;
    private i cKF;
    private com.baidu.swan.apps.core.container.a.b cKn;
    private e cKp;
    private boolean cKq;
    private com.baidu.swan.apps.adaptation.b.c cKr;
    private boolean cKs;
    private boolean cKt;
    private boolean cKu;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cKv;
    private String cKy;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cKz = 10150;
    public static boolean cKA = false;
    private static PreloadState cKB = PreloadState.UNKNOWN;
    private static boolean cKC = false;
    private static final boolean cKH = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> cKo = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cGL = new LinkedList<>();
    private final Object cKw = new Object();
    private final String cKx = UUID.randomUUID().toString();
    private volatile boolean cKG = false;

    private static PreloadState ape() {
        return cKB;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> apf() {
        return this.cKv;
    }

    public static int apg() {
        return ape().statsCode(cKC);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cKv = new HashMap<>();
        this.cKE = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cKF = com.baidu.swan.apps.adaptation.b.a.c.ags().agt().agq();
        if (cKH) {
            this.cKp = new e();
        }
    }

    public static d aph() {
        if (cKm == null) {
            synchronized (d.class) {
                if (cKm == null) {
                    cKm = new d();
                }
            }
        }
        return cKm;
    }

    public ba apj() {
        return this.cKE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void apk() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void apl() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aBE()) {
                com.baidu.swan.apps.runtime.d.aEQ().aEL().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cKm == null || cKm.apr()) {
                    com.baidu.swan.apps.runtime.d.aEQ().aEL().sendMessage(15);
                    release(false);
                } else {
                    if (cKm.cKD == null) {
                        cKm.cKD = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aEQ().getAppId());
                                com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aEQ().aEL().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cKm.a(cKm.cKD);
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
            if (cKm != null) {
                cKB = PreloadState.UNKNOWN;
                cKm.cKt = true;
                cKm.cKD = null;
                cKA = false;
                if (z2) {
                    c.apS();
                    copyOnWriteArrayList = c.apR();
                }
                if (cKm.cKn != null) {
                    cKm.cKF.b(cKm.cKn);
                }
                com.baidu.swan.apps.api.module.l.e.ahN();
                com.baidu.swan.apps.swancore.a.a.aIy();
                apm();
                com.baidu.swan.apps.v.i.b(cKm);
                cKm = null;
                com.baidu.swan.apps.core.h.b.aov().reset();
                cKC = z;
                aph().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void apm() {
        if (cKm.cKv != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cKm.cKv.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        apn();
        if (cKm.cKr != null) {
            cKm.cKr = null;
        }
    }

    private static void apn() {
        if (cKH) {
            if (cKm.cKp != null) {
                cKm.cKp.reset();
            }
        } else if (cKm.cGB != null) {
            if (cKm.cGB instanceof com.baidu.swan.apps.core.g.e) {
                cKm.cGB.destroy();
            }
            cKm.cGB = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (apq()) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cKA = true;
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        nr("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.kw(0);
            extensionCore = com.baidu.swan.apps.extcore.b.io(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.aux().hh(intent.getIntExtra("bundle_key_preload_switch", cKz));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            nr("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0422d.apX();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aJR();
            }
        }, "prepare ab description");
        if (apA()) {
            f aVo = com.baidu.swan.games.utils.so.d.aVo();
            if (!aVo.isSuccess() && !aVo.aVy()) {
                nr("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            apo();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void apo() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).kc(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.apK();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aCO().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cKo == null) {
            this.cKo = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cKo.contains(next)) {
                this.cKo.add(next);
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

    private void nr(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cKB.statsCode(cKC));
        com.baidu.swan.apps.runtime.d.aEQ().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.apD();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.apD());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aBg().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aHs().sE("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cKt) {
                            com.baidu.swan.apps.performance.i.qv("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aHs().sE("na_pre_load_ok");
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
        if (cKH) {
            e eVar = dVar.cKp;
            aVar = eVar.anA() ? eVar.mW(bVar.getAppId()).anx() : null;
        } else {
            aVar = dVar.cGB;
        }
        if (aVar != null && dVar.cKr != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cKr, bVar, fVar);
            dVar.cKr = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cGB != null) + " startFirstPage mSlaveManager " + (dVar.cKr != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cKr != null) {
                    if (a.C0414a.aou()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.axo(), eVar.ado(), eVar.aFd());
                        SwanAppConfigData aFd = eVar.aFd();
                        equals = "main".equals(aFd != null ? aFd.rL(a2) : null);
                    }
                    if (equals && eVar.aFd() != null) {
                        com.baidu.swan.apps.core.h.b.aov().a(d.cKH ? d.this.cKp.mW(eVar.getAppId()).anx() : d.this.cGB, d.this.cKr, eVar.ado(), eVar.aFd(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cKo.contains(bVar)) {
            this.cKo.add(bVar);
        }
        boolean apq = apq();
        com.baidu.swan.apps.performance.i.aBg().ci("preload", apq ? "1" : "0");
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareRuntime preload = " + apq);
        if (apq) {
            apt();
            return;
        }
        cKB = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_start"));
        apC();
        final boolean apA = apA();
        if (apA) {
            f aVo = com.baidu.swan.games.utils.so.d.aVo();
            if (!aVo.isSuccess() && aVo.aVy()) {
                apA = false;
            }
        }
        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "useV8Master:" + apA);
        if (apA) {
            eP(true);
        }
        if (this.cKn == null) {
            this.cKn = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void adM() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cKt);
                            }
                            if (d.this.cKt) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.apC();
                            d.this.apF();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.eP(apA);
                                d.this.apB();
                                return;
                            }
                            PreloadState unused = d.cKB = PreloadState.LOAD_FAILED;
                            d.this.app();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cKF.a(this.cKn);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void app() {
        synchronized (this.cKw) {
            this.cKq = false;
            if (cKH) {
                this.cKp.reset();
            } else {
                this.cGB = null;
            }
        }
        this.cKs = false;
        this.cKr = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.kN(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", anF());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion kw = com.baidu.swan.apps.swancore.b.kw(0);
            jSONObject.put("swan app core", kw == null ? "null" : Long.valueOf(kw.swanCoreVersion));
            SwanCoreVersion kw2 = com.baidu.swan.apps.swancore.b.kw(1);
            jSONObject.put("swan game core", kw2 == null ? "null" : Long.valueOf(kw2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).sI(com.baidu.swan.apps.runtime.e.aEU() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aEU().getAppKey()).sJ(jSONObject.toString()).arq();
    }

    public boolean apq() {
        boolean z;
        synchronized (this.cKw) {
            z = this.cKq && this.cKs;
        }
        return z;
    }

    public boolean apr() {
        boolean z;
        synchronized (this.cKw) {
            z = this.cKq;
        }
        return z;
    }

    public boolean aps() {
        boolean z;
        synchronized (this.cKw) {
            z = this.cKs;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apt() {
        if (!this.cKo.isEmpty() && apq()) {
            cKB = PreloadState.LOADED;
            c.apT();
            nr("event_preload_finish");
            com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cKo) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.M(this);
                }
            }
            this.cKo.clear();
        }
    }

    private String U(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.G(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String apu() {
        return !TextUtils.isEmpty(apv()) ? apv() + "runtime/index.js" : "";
    }

    public String apv() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String apw() {
        String str;
        apC();
        if (anF()) {
            str = apu();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.aeD()) {
            U(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.ajt()) {
            com.baidu.swan.apps.console.debugger.a.d.ajq();
            com.baidu.swan.apps.console.debugger.a.d.ajm().mh("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.ajw();
        } else {
            com.baidu.swan.apps.core.e.mq(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String apx() {
        apC();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.aeD()) {
            U(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.ajt()) {
            return com.baidu.swan.apps.console.debugger.a.e.ajx();
        } else {
            com.baidu.swan.apps.core.e.mq(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apy() {
        if (!this.cGL.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cGL.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cuT);
                }
                b(next);
            }
            this.cGL.clear();
        }
    }

    public boolean anF() {
        return cKH ? this.cKp.anF() : this.cGB instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a apz() {
        if (cKH) {
            if (!this.cKp.anC()) {
                return null;
            }
            return this.cKp.anD().anx();
        }
        return this.cGB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eP(boolean z) {
        boolean z2;
        synchronized (this.cKw) {
            if (cKH) {
                z2 = this.cKp.anB();
            } else {
                z2 = this.cGB != null;
            }
            if (!this.cKq && !z2) {
                com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cKH) {
                    this.cKp.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cKw) {
                                d.this.cKq = true;
                                d.this.apy();
                                d.this.apt();
                            }
                        }
                    });
                    return;
                }
                this.cGB = this.cKE.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cGB.loadUrl(apw());
                this.cGB.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void hO(String str) {
                        com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cKw) {
                            d.this.cKq = true;
                            d.this.apy();
                            d.this.apt();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a h = this.cKE.h(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        h.loadUrl(apw());
        h.a(gVar);
        return h;
    }

    private boolean apA() {
        if (com.baidu.swan.apps.console.debugger.a.e.ajt() || com.baidu.swan.apps.t.a.aum().aeD()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aVt() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aVt()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0422d.adY() && new File(apu()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apB() {
        if (!this.cKs && this.cKr == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cKr = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void hO(String str) {
                    com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cKs = true;
                    d.this.apt();
                }
            });
            apH();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c bu = this.cKE.bu(context);
            com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String apx = apx();
            if (apx != null) {
                com.baidu.swan.apps.runtime.e aEV = com.baidu.swan.apps.runtime.e.aEV();
                if (aEV != null && !TextUtils.isEmpty(aEV.getAppKey())) {
                    apx = Uri.parse(apx).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aEV.getAppKey(), aEV.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!apx.endsWith(File.separator)) {
                        apx = apx + File.separator;
                    }
                }
                bu.loadUrl(apx);
            }
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "prepareSlave loadUrl " + apx);
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
    public void apC() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.kw(0));
        }
    }

    public SwanCoreVersion apD() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore apE() {
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
    public void apF() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.io(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.apE();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cKv.put(eVar.agj(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String agj = eVar.agj();
        this.cKv.remove(agj);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", agj);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e ns(String str) {
        if (this.cKv.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cKv.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a agX;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cKw) {
            if (!this.cKq) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cuT)));
                }
                this.cGL.add(aVar);
                return;
            }
            if (cKH) {
                if (!this.cKp.anC()) {
                    this.cKp.a(aVar);
                    return;
                } else if (this.cKp.anD() != null) {
                    agX = this.cKp.anD().anx().agX();
                } else {
                    return;
                }
            } else if (this.cGB != null) {
                agX = this.cGB.agX();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cuT);
            }
            com.baidu.swan.apps.event.a.a(agX, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.mT(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cKv.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.agh(), aVar);
    }

    @Nullable
    public String apG() {
        apH();
        return this.cKy;
    }

    private void apH() {
        if (TextUtils.isEmpty(this.cKy)) {
            this.cKy = this.cKr != null ? this.cKr.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bn("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cKy);
        }
    }

    public void eQ(boolean z) {
        boolean z2;
        if (cKH) {
            z2 = this.cKp.anB();
        } else {
            z2 = this.cGB != null;
        }
        if (z && !this.cKq && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cKw) {
                this.cKq = true;
                apy();
                apt();
            }
        } else if (!z && this.cKr != null && !this.cKs) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.qv("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cKs = true;
            apt();
        }
    }

    public void eR(boolean z) {
        this.cKu = z;
    }

    public boolean apI() {
        return this.cKu;
    }

    public String apJ() {
        return this.cKx;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void apK() {
        boolean z = true;
        if (this.cKG) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cKG = true;
        com.baidu.swan.apps.runtime.d aEQ = com.baidu.swan.apps.runtime.d.aEQ();
        z = (aEQ == null || !aEQ.aDd()) ? false : false;
        boolean aem = com.baidu.swan.apps.t.a.aud().aem();
        if (!z && aem) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bZ(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + aem);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cKH && com.baidu.swan.apps.core.prefetch.a.a.aos()) {
            this.cKp.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.bW(this.mSwanCoreVersion.swanCoreVersion));
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
    public static class C0422d {
        private static final boolean cKW;
        private static boolean cKX;
        private static boolean cKY;

        static {
            cKW = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.aex() : com.baidu.swan.apps.t.a.aud().aex();
            cKX = cKW ? true : com.baidu.swan.apps.t.a.aud().adY();
            cKY = cKX;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cKX = intent.getBooleanExtra("bundle_key_v8_ab", cKX);
            }
        }

        public static void apX() {
            cKY = cKX;
        }

        public static String apY() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void nt(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean adY() {
            if (d.DEBUG) {
                String apY = apY();
                char c = 65535;
                switch (apY.hashCode()) {
                    case -1406842887:
                        if (apY.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (apY.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (apY.equals("V8")) {
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
            return cKY;
        }

        public static boolean apZ() {
            String apY = apY();
            if (apY.equals("V8")) {
                return true;
            }
            if (apY.equals("AB")) {
                if (cKW) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.aud().adY();
            }
            return false;
        }

        public static String ig(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void eS(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aEQ().aEM().aFn()) {
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
            } else if (apq()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: f */
                    public void M(Boolean bool) {
                        d.this.m33if(c.g(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: if  reason: not valid java name */
    public void m33if(int i) {
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
                boolean afb = com.baidu.swan.apps.t.a.auy().afb();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + afb);
                }
                if (bVar != null) {
                    bVar.M(Boolean.valueOf(afb));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes10.dex */
    public static class c {
        private static final int cKR = a.apO();
        private static final int cKS = a.apP();
        private static int cKT = 0;
        private static int cKU = cKT;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cKm.apq()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cKU >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cKV)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cKV, a.apQ());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.apk();
                    c.a(new com.baidu.swan.apps.am.a().bZ(5L).ca(49L).tM("start retry"));
                }
            }
        };
        private static final Runnable cKV = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cKm.apq()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cKU >= 1) {
                    com.baidu.swan.apps.am.a tM = new com.baidu.swan.apps.am.a().bZ(5L).ca(49L).tM("retry timeout");
                    c.a(tM);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), tM, 0, com.baidu.swan.apps.runtime.d.aEQ().getAppId());
                    com.baidu.swan.apps.ap.e.N(com.baidu.swan.apps.runtime.d.aEQ().aEO());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int ade;
            com.baidu.swan.apps.runtime.e aEM = com.baidu.swan.apps.runtime.d.aEQ().aEM();
            if (aEM != null && (ade = aEM.ade()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aEM.ado()).sU(com.baidu.swan.apps.statistic.h.ko(ade)).sV(com.baidu.swan.apps.runtime.e.aEW()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> apR() {
            return new CopyOnWriteArrayList<>(d.cKm.cKo);
        }

        static void apS() {
            cKU++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cKU);
            }
        }

        static void apT() {
            cKU = cKT;
        }

        public static int g(Boolean bool) {
            return bool.booleanValue() ? cKR : cKS;
        }
    }

    /* loaded from: classes10.dex */
    public static class a {
        private static int cKQ = -1;

        static int apN() {
            if (cKQ < 0) {
                cKQ = com.baidu.swan.apps.t.a.aud().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cKQ;
        }

        public static boolean isEnable() {
            boolean z = apN() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int apO() {
            int i = com.baidu.swan.apps.t.a.aud().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int apP() {
            int i = com.baidu.swan.apps.t.a.aud().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int apQ() {
            int i = com.baidu.swan.apps.t.a.aud().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
