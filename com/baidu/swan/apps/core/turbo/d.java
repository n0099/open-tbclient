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
/* loaded from: classes25.dex */
public final class d implements h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cVB = 10150;
    public static boolean cVC = false;
    private static PreloadState cVD = PreloadState.UNKNOWN;
    private static boolean cVE = false;
    private static final boolean cVJ = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private static volatile d cVo;
    private com.baidu.swan.apps.core.g.a cRD;
    private String cVA;
    private b cVF;
    private ba cVG;
    private i cVH;
    private com.baidu.swan.apps.core.container.a.b cVp;
    private e cVr;
    private boolean cVs;
    private com.baidu.swan.apps.adaptation.b.c cVt;
    private boolean cVu;
    private boolean cVv;
    private boolean cVw;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cVx;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private List<b> cVq = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cRN = new LinkedList<>();
    private final Object cVy = new Object();
    private final String cVz = UUID.randomUUID().toString();
    private volatile boolean cVI = false;

    private static PreloadState auf() {
        return cVD;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> aug() {
        return this.cVx;
    }

    public static int auh() {
        return auf().statsCode(cVE);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cVx = new HashMap<>();
        this.cVG = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cVH = com.baidu.swan.apps.adaptation.b.a.c.als().alt().alq();
        if (cVJ) {
            this.cVr = new e();
        }
    }

    public static d aui() {
        if (cVo == null) {
            synchronized (d.class) {
                if (cVo == null) {
                    cVo = new d();
                }
            }
        }
        return cVo;
    }

    public ba auj() {
        return this.cVG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void auk() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void aul() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aGE()) {
                com.baidu.swan.apps.runtime.d.aJQ().aJL().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cVo == null || cVo.aur()) {
                    com.baidu.swan.apps.runtime.d.aJQ().aJL().sendMessage(15);
                    release(false);
                } else {
                    if (cVo.cVF == null) {
                        cVo.cVF = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aJQ().getAppId());
                                com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aJQ().aJL().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cVo.a(cVo.cVF);
                }
            }
        }
    }

    public static synchronized void release(boolean z) {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "release");
            o(z, false);
        }
    }

    private static synchronized void o(boolean z, boolean z2) {
        CopyOnWriteArrayList<b> copyOnWriteArrayList = null;
        synchronized (d.class) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "release");
            }
            if (cVo != null) {
                cVD = PreloadState.UNKNOWN;
                cVo.cVv = true;
                cVo.cVF = null;
                cVC = false;
                if (z2) {
                    c.auS();
                    copyOnWriteArrayList = c.auR();
                }
                if (cVo.cVp != null) {
                    cVo.cVH.b(cVo.cVp);
                }
                com.baidu.swan.apps.api.module.l.e.amN();
                com.baidu.swan.apps.swancore.a.a.aNx();
                aum();
                com.baidu.swan.apps.v.i.b(cVo);
                cVo = null;
                com.baidu.swan.apps.core.h.b.atw().reset();
                cVE = z;
                aui().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void aum() {
        if (cVo.cVx != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cVo.cVx.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        aun();
        if (cVo.cVt != null) {
            cVo.cVt = null;
        }
    }

    private static void aun() {
        if (cVJ) {
            if (cVo.cVr != null) {
                cVo.cVr.reset();
            }
        } else if (cVo.cRD != null) {
            if (cVo.cRD instanceof com.baidu.swan.apps.core.g.e) {
                cVo.cRD.destroy();
            }
            cVo.cRD = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (auq()) {
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cVC = true;
        com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        oi("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.la(0);
            extensionCore = com.baidu.swan.apps.extcore.b.iS(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.azx().hL(intent.getIntExtra("bundle_key_preload_switch", cVB));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            oi("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0444d.auY();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aOQ();
            }
        }, "prepare ab description");
        if (auA()) {
            f bal = com.baidu.swan.games.utils.so.d.bal();
            if (!bal.isSuccess() && !bal.bav()) {
                oi("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            auo();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void auo() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.t(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).kG(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.auK();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aHO().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cVq == null) {
            this.cVq = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cVq.contains(next)) {
                this.cVq.add(next);
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

    private void oi(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cVD.statsCode(cVE));
        com.baidu.swan.apps.runtime.d.aJQ().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.auD();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.auD());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aGg().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aMs().tu("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cVv) {
                            com.baidu.swan.apps.performance.i.rk("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aMs().tu("na_pre_load_ok");
                            com.baidu.swan.apps.performance.i.cq("preload", "startup");
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
        if (cVJ) {
            e eVar = dVar.cVr;
            aVar = eVar.asB() ? eVar.nM(bVar.getAppId()).asy() : null;
        } else {
            aVar = dVar.cRD;
        }
        if (aVar != null && dVar.cVt != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cVt, bVar, fVar);
            dVar.cVt = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cRD != null) + " startFirstPage mSlaveManager " + (dVar.cVt != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cVt != null) {
                    if (a.C0436a.atv()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.aCp(), eVar.aio(), eVar.aKd());
                        SwanAppConfigData aKd = eVar.aKd();
                        equals = "main".equals(aKd != null ? aKd.sB(a2) : null);
                    }
                    if (equals && eVar.aKd() != null) {
                        com.baidu.swan.apps.core.h.b.atw().a(d.cVJ ? d.this.cVr.nM(eVar.getAppId()).asy() : d.this.cRD, d.this.cVt, eVar.aio(), eVar.aKd(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cVq.contains(bVar)) {
            this.cVq.add(bVar);
        }
        boolean auq = auq();
        com.baidu.swan.apps.performance.i.aGg().co("preload", auq ? "1" : "0");
        com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "prepareRuntime preload = " + auq);
        if (auq) {
            aut();
            return;
        }
        cVD = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_start"));
        auC();
        final boolean auA = auA();
        if (auA) {
            f bal = com.baidu.swan.games.utils.so.d.bal();
            if (!bal.isSuccess() && bal.bav()) {
                auA = false;
            }
        }
        com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "useV8Master:" + auA);
        if (auA) {
            fq(true);
        }
        if (this.cVp == null) {
            this.cVp = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void aiM() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cVv);
                            }
                            if (d.this.cVv) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.auC();
                            d.this.auF();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.fq(auA);
                                d.this.auB();
                                return;
                            }
                            PreloadState unused = d.cVD = PreloadState.LOAD_FAILED;
                            d.this.aup();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cVH.a(this.cVp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aup() {
        synchronized (this.cVy) {
            this.cVs = false;
            if (cVJ) {
                this.cVr.reset();
            } else {
                this.cRD = null;
            }
        }
        this.cVu = false;
        this.cVt = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.lr(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", asG());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion la = com.baidu.swan.apps.swancore.b.la(0);
            jSONObject.put("swan app core", la == null ? "null" : Long.valueOf(la.swanCoreVersion));
            SwanCoreVersion la2 = com.baidu.swan.apps.swancore.b.la(1);
            jSONObject.put("swan game core", la2 == null ? "null" : Long.valueOf(la2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).ty(com.baidu.swan.apps.runtime.e.aJU() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aJU().getAppKey()).tz(jSONObject.toString()).awr();
    }

    public boolean auq() {
        boolean z;
        synchronized (this.cVy) {
            z = this.cVs && this.cVu;
        }
        return z;
    }

    public boolean aur() {
        boolean z;
        synchronized (this.cVy) {
            z = this.cVs;
        }
        return z;
    }

    public boolean aus() {
        boolean z;
        synchronized (this.cVy) {
            z = this.cVu;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aut() {
        if (!this.cVq.isEmpty() && auq()) {
            cVD = PreloadState.LOADED;
            c.auT();
            oi("event_preload_finish");
            com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cVq) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.M(this);
                }
            }
            this.cVq.clear();
        }
    }

    private String V(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.J(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String auu() {
        return !TextUtils.isEmpty(auv()) ? auv() + "runtime/index.js" : "";
    }

    public String auv() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String auw() {
        String str;
        auC();
        if (asG()) {
            str = auu();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.ajD()) {
            V(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.aot()) {
            com.baidu.swan.apps.console.debugger.a.d.aoq();
            com.baidu.swan.apps.console.debugger.a.d.aom().mX("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.aow();
        } else {
            com.baidu.swan.apps.core.e.ng(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String aux() {
        auC();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.ajD()) {
            V(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.aot()) {
            return com.baidu.swan.apps.console.debugger.a.e.aox();
        } else {
            com.baidu.swan.apps.core.e.ng(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auy() {
        if (!this.cRN.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cRN.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cFU);
                }
                b(next);
            }
            this.cRN.clear();
        }
    }

    public boolean asG() {
        return cVJ ? this.cVr.asG() : this.cRD instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a auz() {
        if (cVJ) {
            if (!this.cVr.asD()) {
                return null;
            }
            return this.cVr.asE().asy();
        }
        return this.cRD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fq(boolean z) {
        boolean z2;
        synchronized (this.cVy) {
            if (cVJ) {
                z2 = this.cVr.asC();
            } else {
                z2 = this.cRD != null;
            }
            if (!this.cVs && !z2) {
                com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cVJ) {
                    this.cVr.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cVy) {
                                d.this.cVs = true;
                                d.this.auy();
                                d.this.aut();
                            }
                        }
                    });
                    return;
                }
                this.cRD = this.cVG.q(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cRD.loadUrl(auw());
                this.cRD.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void it(String str) {
                        com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cVy) {
                            d.this.cVs = true;
                            d.this.auy();
                            d.this.aut();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a q = this.cVG.q(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        q.loadUrl(auw());
        q.a(gVar);
        return q;
    }

    private boolean auA() {
        if (com.baidu.swan.apps.console.debugger.a.e.aot() || com.baidu.swan.apps.t.a.azm().ajD()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.baq() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.baq()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0444d.aiY() && new File(auu()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auB() {
        if (!this.cVu && this.cVt == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cVt = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void it(String str) {
                    com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cVu = true;
                    d.this.aut();
                }
            });
            auH();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c ca = this.cVG.ca(context);
            com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String aux = aux();
            if (aux != null) {
                com.baidu.swan.apps.runtime.e aJV = com.baidu.swan.apps.runtime.e.aJV();
                if (aJV != null && !TextUtils.isEmpty(aJV.getAppKey())) {
                    aux = Uri.parse(aux).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aJV.getAppKey(), aJV.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!aux.endsWith(File.separator)) {
                        aux = aux + File.separator;
                    }
                }
                ca.loadUrl(aux);
            }
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "prepareSlave loadUrl " + aux);
            ca.a(gVar);
            return ca;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.cA(context);
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
    public void auC() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.la(0));
        }
    }

    public SwanCoreVersion auD() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore auE() {
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
    public void auF() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.iS(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.auE();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cVx.put(eVar.alj(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String alj = eVar.alj();
        this.cVx.remove(alj);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", alj);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public com.baidu.swan.apps.adaptation.b.e oj(String str) {
        if (this.cVx.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cVx.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a alX;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cVy) {
            if (!this.cVs) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cFU)));
                }
                this.cRN.add(aVar);
                return;
            }
            if (cVJ) {
                if (!this.cVr.asD()) {
                    this.cVr.a(aVar);
                    return;
                } else if (this.cVr.asE() != null) {
                    alX = this.cVr.asE().asy().alX();
                } else {
                    return;
                }
            } else if (this.cRD != null) {
                alX = this.cRD.alX();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cFU);
            }
            com.baidu.swan.apps.event.a.a(alX, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.nJ(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cVx.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.alh(), aVar);
    }

    @Nullable
    public String auG() {
        auH();
        return this.cVA;
    }

    private void auH() {
        if (TextUtils.isEmpty(this.cVA)) {
            this.cVA = this.cVt != null ? this.cVt.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bt("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cVA);
        }
    }

    public void fr(boolean z) {
        boolean z2;
        if (cVJ) {
            z2 = this.cVr.asC();
        } else {
            z2 = this.cRD != null;
        }
        if (z && !this.cVs && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cVy) {
                this.cVs = true;
                auy();
                aut();
            }
        } else if (!z && this.cVt != null && !this.cVu) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.rk("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cVu = true;
            aut();
        }
    }

    public void fs(boolean z) {
        this.cVw = z;
    }

    public boolean auI() {
        return this.cVw;
    }

    public String auJ() {
        return this.cVz;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void auK() {
        boolean z = true;
        if (this.cVI) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cVI = true;
        com.baidu.swan.apps.runtime.d aJQ = com.baidu.swan.apps.runtime.d.aJQ();
        z = (aJQ == null || !aJQ.aId()) ? false : false;
        boolean ajm = com.baidu.swan.apps.t.a.azd().ajm();
        if (!z && ajm) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.cF(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + ajm);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cVJ && com.baidu.swan.apps.core.prefetch.a.a.att()) {
            this.cVr.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cR(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes25.dex */
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
    /* loaded from: classes25.dex */
    public static class C0444d {
        private static final boolean cVY;
        private static boolean cVZ;
        private static boolean cWa;

        static {
            cVY = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.ajx() : com.baidu.swan.apps.t.a.azd().ajx();
            cVZ = cVY ? true : com.baidu.swan.apps.t.a.azd().aiY();
            cWa = cVZ;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cVZ = intent.getBooleanExtra("bundle_key_v8_ab", cVZ);
            }
        }

        public static void auY() {
            cWa = cVZ;
        }

        public static String auZ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void ok(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean aiY() {
            if (d.DEBUG) {
                String auZ = auZ();
                char c = 65535;
                switch (auZ.hashCode()) {
                    case -1406842887:
                        if (auZ.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (auZ.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (auZ.equals("V8")) {
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
            return cWa;
        }

        public static boolean ava() {
            String auZ = auZ();
            if (auZ.equals("V8")) {
                return true;
            }
            if (auZ.equals("AB")) {
                if (cVY) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.azd().aiY();
            }
            return false;
        }

        public static String iK(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void ft(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.aJQ().aJM().aKn()) {
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
            } else if (auq()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: f */
                    public void M(Boolean bool) {
                        d.this.iJ(c.g(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void iJ(int i) {
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
                boolean akb = com.baidu.swan.apps.t.a.azy().akb();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + akb);
                }
                if (bVar != null) {
                    bVar.M(Boolean.valueOf(akb));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes25.dex */
    public static class c {
        private static final int cVT = a.auO();
        private static final int cVU = a.auP();
        private static int cVV = 0;
        private static int cVW = cVV;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cVo.auq()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cVW >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cVX)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cVX, a.auQ());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.auk();
                    c.a(new com.baidu.swan.apps.am.a().cU(5L).cV(49L).uC("start retry"));
                }
            }
        };
        private static final Runnable cVX = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cVo.auq()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cVW >= 1) {
                    com.baidu.swan.apps.am.a uC = new com.baidu.swan.apps.am.a().cU(5L).cV(49L).uC("retry timeout");
                    c.a(uC);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), uC, 0, com.baidu.swan.apps.runtime.d.aJQ().getAppId());
                    com.baidu.swan.apps.ap.e.M(com.baidu.swan.apps.runtime.d.aJQ().aJO());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int aie;
            com.baidu.swan.apps.runtime.e aJM = com.baidu.swan.apps.runtime.d.aJQ().aJM();
            if (aJM != null && (aie = aJM.aie()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aJM.aio()).tK(com.baidu.swan.apps.statistic.h.kS(aie)).tL(com.baidu.swan.apps.runtime.e.aJW()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> auR() {
            return new CopyOnWriteArrayList<>(d.cVo.cVq);
        }

        static void auS() {
            cVW++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cVW);
            }
        }

        static void auT() {
            cVW = cVV;
        }

        public static int g(Boolean bool) {
            return bool.booleanValue() ? cVT : cVU;
        }
    }

    /* loaded from: classes25.dex */
    public static class a {
        private static int cVS = -1;

        static int auN() {
            if (cVS < 0) {
                cVS = com.baidu.swan.apps.t.a.azd().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cVS;
        }

        public static boolean isEnable() {
            boolean z = auN() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int auO() {
            int i = com.baidu.swan.apps.t.a.azd().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int auP() {
            int i = com.baidu.swan.apps.t.a.azd().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int auQ() {
            int i = com.baidu.swan.apps.t.a.azd().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
