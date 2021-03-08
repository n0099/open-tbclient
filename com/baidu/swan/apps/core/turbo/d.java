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
    private static volatile d cZk;
    private com.baidu.swan.apps.core.g.a cVB;
    private b cZA;
    private ba cZB;
    private i cZC;
    private com.baidu.swan.apps.core.container.a.b cZl;
    private e cZn;
    private boolean cZo;
    private com.baidu.swan.apps.adaptation.b.c cZp;
    private boolean cZq;
    private boolean cZr;
    private final HashMap<String, com.baidu.swan.apps.adaptation.b.e> cZs;
    private String cZv;
    @Nullable
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cZw = 10150;
    public static boolean cZx = false;
    private static PreloadState cZy = PreloadState.UNKNOWN;
    private static boolean cZz = false;
    private static final boolean cZE = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private List<b> cZm = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cVL = new LinkedList<>();
    private final Object cZt = new Object();
    private final String cZu = UUID.randomUUID().toString();
    private volatile boolean cZD = false;

    private static PreloadState ase() {
        return cZy;
    }

    @NonNull
    public HashMap<String, com.baidu.swan.apps.adaptation.b.e> asf() {
        return this.cZs;
    }

    public static int asg() {
        return ase().statsCode(cZz);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cZs = new HashMap<>();
        this.cZB = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cZC = com.baidu.swan.apps.adaptation.b.a.c.ajk().ajl().aji();
        if (cZE) {
            this.cZn = new e();
        }
    }

    public static d ash() {
        if (cZk == null) {
            synchronized (d.class) {
                if (cZk == null) {
                    cZk = new d();
                }
            }
        }
        return cZk;
    }

    public ba asi() {
        return this.cZB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void asj() {
        synchronized (d.class) {
            p(false, true);
        }
    }

    public static synchronized void ask() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.aEC()) {
                com.baidu.swan.apps.runtime.d.aIJ().aIE().iw(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cZk == null || cZk.asr()) {
                    com.baidu.swan.apps.runtime.d.aIJ().aIE().iw(15);
                    release(false);
                } else {
                    if (cZk.cZA == null) {
                        cZk.cZA = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.aIJ().getAppId());
                                com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.aIJ().aIE().iw(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cZk.a(cZk.cZA);
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
            if (cZk != null) {
                cZy = PreloadState.UNKNOWN;
                cZk.mIsReleased = true;
                cZk.cZA = null;
                cZx = false;
                if (z2) {
                    c.asS();
                    copyOnWriteArrayList = c.asR();
                }
                if (cZk.cZl != null) {
                    cZk.cZC.b(cZk.cZl);
                }
                com.baidu.swan.apps.api.module.l.e.akF();
                com.baidu.swan.apps.swancore.a.a.aMq();
                asl();
                com.baidu.swan.apps.v.i.b(cZk);
                cZk = null;
                com.baidu.swan.apps.core.h.b.aru().reset();
                cZz = z;
                ash().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void asl() {
        if (cZk.cZs != null) {
            for (com.baidu.swan.apps.adaptation.b.e eVar : ((HashMap) cZk.cZs.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        asn();
        if (cZk.cZp != null) {
            cZk.cZp = null;
        }
    }

    private static void asn() {
        if (cZE) {
            if (cZk.cZn != null) {
                cZk.cZn.reset();
            }
        } else if (cZk.cVB != null) {
            if (cZk.cVB instanceof com.baidu.swan.apps.core.g.e) {
                cZk.cVB.destroy();
            }
            cZk.cVB = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (asq()) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cZx = true;
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        no("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.jD(0);
            extensionCore = com.baidu.swan.apps.extcore.b.hl(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.axw().gc(intent.getIntExtra("bundle_key_preload_switch", cZw));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            no("event_preload_error");
            com.baidu.swan.apps.console.c.g("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0422d.asY();
        p.a(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ao.i.aNK();
            }
        }, "prepare ab description");
        if (asA()) {
            f aZb = com.baidu.swan.games.utils.so.d.aZb();
            if (!aZb.isSuccess() && !aZb.aZl()) {
                no("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            aso();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void aso() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.u(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).jk(1).aIv();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.j(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.asK();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.aFM().iw(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cZm == null) {
            this.cZm = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cZm.contains(next)) {
                this.cZm.add(next);
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

    private void no(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cZy.statsCode(cZz));
        com.baidu.swan.apps.runtime.d.aIJ().g(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.asD();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.asD());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.aEe().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.aj.a.aLl().sG("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.mIsReleased) {
                            com.baidu.swan.apps.performance.i.qr("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.aj.a.aLl().sG("na_pre_load_ok");
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
        if (cZE) {
            e eVar = dVar.cZn;
            aVar = eVar.aqz() ? eVar.mT(bVar.getAppId()).aqw() : null;
        } else {
            aVar = dVar.cVB;
        }
        if (aVar != null && dVar.cZp != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cZp, bVar, fVar);
            dVar.cZp = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cVB != null) + " startFirstPage mSlaveManager " + (dVar.cZp != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cZp != null) {
                    if (a.C0414a.art()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.aAo(), eVar.agc(), eVar.aIW());
                        SwanAppConfigData aIW = eVar.aIW();
                        equals = "main".equals(aIW != null ? aIW.rM(a2) : null);
                    }
                    if (equals && eVar.aIW() != null) {
                        com.baidu.swan.apps.core.h.b.aru().a(d.cZE ? d.this.cZn.mT(eVar.getAppId()).aqw() : d.this.cVB, d.this.cZp, eVar.agc(), eVar.aIW(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cZm.contains(bVar)) {
            this.cZm.add(bVar);
        }
        boolean asq = asq();
        com.baidu.swan.apps.performance.i.aEe().cg("preload", asq ? "1" : "0");
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareRuntime preload = " + asq);
        if (asq) {
            ast();
            return;
        }
        cZy = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_start"));
        asC();
        final boolean asA = asA();
        if (asA) {
            f aZb = com.baidu.swan.games.utils.so.d.aZb();
            if (!aZb.isSuccess() && aZb.aZl()) {
                asA = false;
            }
        }
        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "useV8Master:" + asA);
        if (asA) {
            fx(true);
        }
        if (this.cZl == null) {
            this.cZl = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void agC() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
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
                            d.this.asC();
                            d.this.asF();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.fx(asA);
                                d.this.asB();
                                return;
                            }
                            PreloadState unused = d.cZy = PreloadState.LOAD_FAILED;
                            d.this.asp();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cZC.a(this.cZl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asp() {
        synchronized (this.cZt) {
            this.cZo = false;
            if (cZE) {
                this.cZn.reset();
            } else {
                this.cVB = null;
            }
        }
        this.cZq = false;
        this.cZp = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.jU(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", aqE());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion jD = com.baidu.swan.apps.swancore.b.jD(0);
            jSONObject.put("swan app core", jD == null ? "null" : Long.valueOf(jD.swanCoreVersion));
            SwanCoreVersion jD2 = com.baidu.swan.apps.swancore.b.jD(1);
            jSONObject.put("swan game core", jD2 == null ? "null" : Long.valueOf(jD2.swanCoreVersion));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new c.a(10001).sK(com.baidu.swan.apps.runtime.e.aIN() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.aIN().getAppKey()).sL(jSONObject.toString()).aur();
    }

    public boolean asq() {
        boolean z;
        synchronized (this.cZt) {
            z = this.cZo && this.cZq;
        }
        return z;
    }

    public boolean asr() {
        boolean z;
        synchronized (this.cZt) {
            z = this.cZo;
        }
        return z;
    }

    public boolean ass() {
        boolean z;
        synchronized (this.cZt) {
            z = this.cZq;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ast() {
        if (!this.cZm.isEmpty() && asq()) {
            cZy = PreloadState.LOADED;
            c.asT();
            no("event_preload_finish");
            com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cZm) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.N(this);
                }
            }
            this.cZm.clear();
        }
    }

    private String U(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.M(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String asu() {
        return !TextUtils.isEmpty(asv()) ? asv() + "runtime/index.js" : "";
    }

    public String asv() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String asw() {
        String str;
        asC();
        if (aqE()) {
            str = asu();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.aht()) {
            U(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.amn()) {
            com.baidu.swan.apps.console.debugger.a.d.amk();
            com.baidu.swan.apps.console.debugger.a.d.amg().me("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.amq();
        } else {
            com.baidu.swan.apps.core.e.mn(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String asx() {
        asC();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.aht()) {
            U(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.amn()) {
            return com.baidu.swan.apps.console.debugger.a.e.amr();
        } else {
            com.baidu.swan.apps.core.e.mn(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asy() {
        if (!this.cVL.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cVL.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.cJT);
                }
                b(next);
            }
            this.cVL.clear();
        }
    }

    public boolean aqE() {
        return cZE ? this.cZn.aqE() : this.cVB instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a asz() {
        if (cZE) {
            if (!this.cZn.aqB()) {
                return null;
            }
            return this.cZn.aqC().aqw();
        }
        return this.cVB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fx(boolean z) {
        boolean z2;
        synchronized (this.cZt) {
            if (cZE) {
                z2 = this.cZn.aqA();
            } else {
                z2 = this.cVB != null;
            }
            if (!this.cZo && !z2) {
                com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cZE) {
                    this.cZn.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cZt) {
                                d.this.cZo = true;
                                d.this.asy();
                                d.this.ast();
                            }
                        }
                    });
                    return;
                }
                this.cVB = this.cZB.r(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cVB.loadUrl(asw());
                this.cVB.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void iA(String str) {
                        com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cZt) {
                            d.this.cZo = true;
                            d.this.asy();
                            d.this.ast();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a r = this.cZB.r(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        r.loadUrl(asw());
        r.a(gVar);
        return r;
    }

    private boolean asA() {
        if (com.baidu.swan.apps.console.debugger.a.e.amn() || com.baidu.swan.apps.t.a.axl().aht()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aZg() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aZg()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0422d.agO() && new File(asu()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asB() {
        if (!this.cZq && this.cZp == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cZp = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void iA(String str) {
                    com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cZq = true;
                    d.this.ast();
                }
            });
            asH();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c ce = this.cZB.ce(context);
            com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String asx = asx();
            if (asx != null) {
                com.baidu.swan.apps.runtime.e aIO = com.baidu.swan.apps.runtime.e.aIO();
                if (aIO != null && !TextUtils.isEmpty(aIO.getAppKey())) {
                    asx = Uri.parse(asx).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(aIO.getAppKey(), aIO.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!asx.endsWith(File.separator)) {
                        asx = asx + File.separator;
                    }
                }
                ce.loadUrl(asx);
            }
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "prepareSlave loadUrl " + asx);
            ce.a(gVar);
            return ce;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.cF(context);
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
    public void asC() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.jD(0));
        }
    }

    public SwanCoreVersion asD() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore asE() {
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
    public void asF() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.hl(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.asE();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(com.baidu.swan.apps.adaptation.b.e eVar) {
        this.cZs.put(eVar.ajb(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(com.baidu.swan.apps.adaptation.b.e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(com.baidu.swan.apps.adaptation.b.e eVar) {
        String ajb = eVar.ajb();
        this.cZs.remove(ajb);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", ajb);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.aIk();
    }

    public com.baidu.swan.apps.adaptation.b.e np(String str) {
        if (this.cZs.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cZs.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a ajP;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cZt) {
            if (!this.cZo) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.cJT)));
                }
                this.cVL.add(aVar);
                return;
            }
            if (cZE) {
                if (!this.cZn.aqB()) {
                    this.cZn.a(aVar);
                    return;
                } else if (this.cZn.aqC() != null) {
                    ajP = this.cZn.aqC().aqw().ajP();
                } else {
                    return;
                }
            } else if (this.cVB != null) {
                ajP = this.cVB.ajP();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.cJT);
            }
            com.baidu.swan.apps.event.a.a(ajP, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.mQ(str)) {
            b(aVar);
            return;
        }
        com.baidu.swan.apps.adaptation.b.e eVar = this.cZs.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.aiZ(), aVar);
    }

    @Nullable
    public String asG() {
        asH();
        return this.cZv;
    }

    private void asH() {
        if (TextUtils.isEmpty(this.cZv)) {
            this.cZv = this.cZp != null ? this.cZp.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bl("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cZv);
        }
    }

    public void fy(boolean z) {
        boolean z2;
        if (cZE) {
            z2 = this.cZn.aqA();
        } else {
            z2 = this.cVB != null;
        }
        if (z && !this.cZo && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cZt) {
                this.cZo = true;
                asy();
                ast();
            }
        } else if (!z && this.cZp != null && !this.cZq) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.qr("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cZq = true;
            ast();
        }
    }

    public void fz(boolean z) {
        this.cZr = z;
    }

    public boolean asI() {
        return this.cZr;
    }

    public String asJ() {
        return this.cZu;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asK() {
        boolean z = true;
        if (this.cZD) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cZD = true;
        com.baidu.swan.apps.runtime.d aIJ = com.baidu.swan.apps.runtime.d.aIJ();
        z = (aIJ == null || !aIJ.aGb()) ? false : false;
        boolean ahc = com.baidu.swan.apps.t.a.axc().ahc();
        if (!z && ahc) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.cK(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + ahc);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cZE && com.baidu.swan.apps.core.prefetch.a.a.arr()) {
            this.cZn.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.cY(this.mSwanCoreVersion.swanCoreVersion));
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
        public void N(d dVar) {
            o(dVar);
        }
    }

    /* renamed from: com.baidu.swan.apps.core.turbo.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0422d {
        private static final boolean cZT;
        private static boolean cZU;
        private static boolean cZV;

        static {
            cZT = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.ahn() : com.baidu.swan.apps.t.a.axc().ahn();
            cZU = cZT ? true : com.baidu.swan.apps.t.a.axc().agO();
            cZV = cZU;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cZU = intent.getBooleanExtra("bundle_key_v8_ab", cZU);
            }
        }

        public static void asY() {
            cZV = cZU;
        }

        public static String asZ() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void nq(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean agO() {
            if (d.DEBUG) {
                String asZ = asZ();
                char c = 65535;
                switch (asZ.hashCode()) {
                    case -1406842887:
                        if (asZ.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (asZ.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (asZ.equals("V8")) {
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
            return cZV;
        }

        public static boolean ata() {
            String asZ = asZ();
            if (asZ.equals("V8")) {
                return true;
            }
            if (asZ.equals("AB")) {
                if (cZT) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.axc().agO();
            }
            return false;
        }

        public static String hd(int i) {
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
            if (com.baidu.swan.apps.runtime.d.aIJ().aIF().aJg()) {
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
            } else if (asq()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ao.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ao.e.b
                    /* renamed from: g */
                    public void N(Boolean bool) {
                        d.this.hc(c.h(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hc(int i) {
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
                boolean ahR = com.baidu.swan.apps.t.a.axx().ahR();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + ahR);
                }
                if (bVar != null) {
                    bVar.N(Boolean.valueOf(ahR));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes8.dex */
    public static class c {
        private static final int cZO = a.asO();
        private static final int cZP = a.asP();
        private static int cZQ = 0;
        private static int cZR = cZQ;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cZk.asq()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cZR >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.cZS)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.cZS, a.asQ());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.asj();
                    c.a(new com.baidu.swan.apps.al.a().db(5L).dc(49L).tO("start retry"));
                }
            }
        };
        private static final Runnable cZS = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cZk.asq()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cZR >= 1) {
                    com.baidu.swan.apps.al.a tO = new com.baidu.swan.apps.al.a().db(5L).dc(49L).tO("retry timeout");
                    c.a(tO);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), tO, 0, com.baidu.swan.apps.runtime.d.aIJ().getAppId());
                    com.baidu.swan.apps.ao.e.H(com.baidu.swan.apps.runtime.d.aIJ().aIH());
                }
            }
        };

        static void a(com.baidu.swan.apps.al.a aVar) {
            int frameType;
            com.baidu.swan.apps.runtime.e aIF = com.baidu.swan.apps.runtime.d.aIJ().aIF();
            if (aIF != null && (frameType = aIF.getFrameType()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(aIF.agc()).sW(com.baidu.swan.apps.statistic.h.jv(frameType)).sX(com.baidu.swan.apps.runtime.e.aIP()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> asR() {
            return new CopyOnWriteArrayList<>(d.cZk.cZm);
        }

        static void asS() {
            cZR++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cZR);
            }
        }

        static void asT() {
            cZR = cZQ;
        }

        public static int h(Boolean bool) {
            return bool.booleanValue() ? cZO : cZP;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static int cZN = -1;

        static int asN() {
            if (cZN < 0) {
                cZN = com.baidu.swan.apps.t.a.axc().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cZN;
        }

        public static boolean isEnable() {
            boolean z = asN() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int asO() {
            int i = com.baidu.swan.apps.t.a.axc().getSwitch("swan_core_runtime_low_end_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int asP() {
            int i = com.baidu.swan.apps.t.a.axc().getSwitch("swan_core_runtime_high_end_timeout", SyncStrategy.DEFAULT_LOGIN_FETCH_SLEEP_TIME);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int asQ() {
            int i = com.baidu.swan.apps.t.a.axc().getSwitch("swan_core_runtime_retry_process_timeout", 8000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
