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
/* loaded from: classes8.dex */
public final class d implements h {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int cnI = 10150;
    public static boolean cnJ = false;
    private static PreloadState cnK = PreloadState.UNKNOWN;
    private static boolean cnL = false;
    private static final boolean cnQ = com.baidu.swan.apps.core.prefetch.a.a.isOn();
    private static volatile d cnv;
    private com.baidu.swan.apps.core.g.a cjI;
    private com.baidu.swan.apps.adaptation.b.c cnA;
    private boolean cnB;
    private boolean cnC;
    private boolean cnD;
    private final HashMap<String, e> cnE;
    private String cnH;
    private b cnM;
    private ba cnN;
    private i cnO;
    private com.baidu.swan.apps.core.container.a.b cnw;
    private com.baidu.swan.apps.core.g.a.e cny;
    private boolean cnz;
    @Nullable
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private List<b> cnx = new CopyOnWriteArrayList();
    private LinkedList<com.baidu.swan.apps.event.a.a> cjS = new LinkedList<>();
    private final Object cnF = new Object();
    private final String cnG = UUID.randomUUID().toString();
    private volatile boolean cnP = false;

    private static PreloadState ajP() {
        return cnK;
    }

    @NonNull
    public HashMap<String, e> ajQ() {
        return this.cnE;
    }

    public static int ajR() {
        return ajP().statsCode(cnL);
    }

    private d() {
        com.baidu.swan.apps.v.i.a(this);
        this.cnE = new HashMap<>();
        this.cnN = new com.baidu.swan.apps.adaptation.b.a.b();
        this.cnO = com.baidu.swan.apps.adaptation.b.a.c.abd().abe().abb();
        if (cnQ) {
            this.cny = new com.baidu.swan.apps.core.g.a.e();
        }
    }

    public static d ajS() {
        if (cnv == null) {
            synchronized (d.class) {
                if (cnv == null) {
                    cnv = new d();
                }
            }
        }
        return cnv;
    }

    public ba ajT() {
        return this.cnN;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized void ajU() {
        synchronized (d.class) {
            o(false, true);
        }
    }

    public static synchronized void ajV() {
        synchronized (d.class) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "releaseForCoreUpdate");
            if (!com.baidu.swan.apps.performance.b.c.awq()) {
                com.baidu.swan.apps.runtime.d.azE().azz().sendMessage(15);
                release(false);
            } else {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "releaseForCoreUpdate:ReleaseRuntimeWaitMaster:true.");
                }
                if (cnv == null || cnv.akb()) {
                    com.baidu.swan.apps.runtime.d.azE().azz().sendMessage(15);
                    release(false);
                } else {
                    if (cnv.cnM == null) {
                        cnv.cnM = new b() { // from class: com.baidu.swan.apps.core.turbo.d.1
                            @Override // com.baidu.swan.apps.core.turbo.d.b
                            protected void o(d dVar) {
                                boolean z = !TextUtils.isEmpty(com.baidu.swan.apps.runtime.d.azE().getAppId());
                                com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "sReleaseCallback:isSwanAppRunning" + z);
                                if (!z) {
                                    com.baidu.swan.apps.runtime.d.azE().azz().sendMessage(15);
                                    d.release(false);
                                }
                            }
                        };
                    }
                    cnv.a(cnv.cnM);
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
            if (cnv != null) {
                cnK = PreloadState.UNKNOWN;
                cnv.cnC = true;
                cnv.cnM = null;
                cnJ = false;
                if (z2) {
                    c.akC();
                    copyOnWriteArrayList = c.akB();
                }
                if (cnv.cnw != null) {
                    cnv.cnO.b(cnv.cnw);
                }
                com.baidu.swan.apps.api.module.l.e.acy();
                com.baidu.swan.apps.swancore.a.a.aDl();
                ajW();
                com.baidu.swan.apps.v.i.b(cnv);
                cnv = null;
                com.baidu.swan.apps.core.h.b.ajg().reset();
                cnL = z;
                ajS().a((Intent) null, copyOnWriteArrayList);
            }
        }
    }

    private static void ajW() {
        if (cnv.cnE != null) {
            for (e eVar : ((HashMap) cnv.cnE.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        ajX();
        if (cnv.cnA != null) {
            cnv.cnA = null;
        }
    }

    private static void ajX() {
        if (cnQ) {
            if (cnv.cny != null) {
                cnv.cny.reset();
            }
        } else if (cnv.cjI != null) {
            if (cnv.cjI instanceof com.baidu.swan.apps.core.g.e) {
                cnv.cjI.destroy();
            }
            cnv.cjI = null;
        }
    }

    public void r(Intent intent) {
        a(intent, (CopyOnWriteArrayList<b>) null);
    }

    private void a(Intent intent, CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (aka()) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
            return;
        }
        cnJ = true;
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        lS("event_preload_start");
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.jD(0);
            extensionCore = com.baidu.swan.apps.extcore.b.hx(0);
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.t.a.apg().gq(intent.getIntExtra("bundle_key_preload_switch", cnI));
        }
        if (swanCoreVersion == null) {
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            lS("event_preload_error");
            com.baidu.swan.apps.console.c.f("SwanAppCoreRuntime", "preloadCoreRuntime", new Exception("version is invalid"));
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        C0396d.akH();
        p.postOnIO(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.5
            @Override // java.lang.Runnable
            public void run() {
                com.baidu.swan.apps.ap.i.aEE();
            }
        }, "prepare ab description");
        if (akk()) {
            f aQa = com.baidu.swan.games.utils.so.d.aQa();
            if (!aQa.isSuccess() && !aQa.aQj()) {
                lS("event_preload_error");
                return;
            }
        }
        if (!(copyOnWriteArrayList != null && copyOnWriteArrayList.size() > 0)) {
            ajY();
        } else {
            a(copyOnWriteArrayList);
        }
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "preloadCoreRuntime end.");
    }

    private void ajY() {
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.6
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                if (d.DEBUG) {
                    com.baidu.swan.apps.res.widget.b.d.k(d.getContext(), a.h.aiapps_preloadCoreRuntime_end).jj(1).showToast();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                ak.m(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.6.1
                    @Override // java.lang.Runnable
                    public void run() {
                        dVar.aku();
                    }
                });
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "onReady: successfully.");
                }
                com.baidu.swan.apps.process.messaging.client.a.axC().sendMessage(14);
            }

            @NonNull
            public String toString() {
                return "prepare " + super.toString();
            }
        });
    }

    private void a(CopyOnWriteArrayList<b> copyOnWriteArrayList) {
        if (this.cnx == null) {
            this.cnx = new CopyOnWriteArrayList();
        }
        Iterator<b> it = copyOnWriteArrayList.iterator();
        while (it.hasNext()) {
            b next = it.next();
            if (!this.cnx.contains(next)) {
                this.cnx.add(next);
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

    private void lS(String str) {
        Bundle bundle = new Bundle();
        bundle.putInt("KEY_PRELOAD_STATE", cnK.statsCode(cnL));
        com.baidu.swan.apps.runtime.d.azE().f(str, bundle);
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        } else {
            this.mSwanCoreVersion = bVar.akn();
        }
    }

    public void a(final com.baidu.swan.apps.u.c.b bVar, final d.f fVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.mSwanCoreVersion);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.akn());
        }
        e(bVar);
        f(bVar);
        com.baidu.swan.apps.performance.i.avS().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.ak.a.aCf().re("na_pre_load_check");
        a(new b() { // from class: com.baidu.swan.apps.core.turbo.d.8
            @Override // com.baidu.swan.apps.core.turbo.d.b
            public void o(final d dVar) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.8.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!dVar.cnC) {
                            com.baidu.swan.apps.performance.i.oW("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.ak.a.aCf().re("na_pre_load_ok");
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
        if (cnQ) {
            com.baidu.swan.apps.core.g.a.e eVar = dVar.cny;
            aVar = eVar.ail() ? eVar.lx(bVar.getAppId()).aii() : null;
        } else {
            aVar = dVar.cjI;
        }
        if (aVar != null && dVar.cnA != null) {
            com.baidu.swan.apps.scheme.actions.k.c.a(aVar, dVar.cnA, bVar, fVar);
            dVar.cnA = null;
        } else if (DEBUG) {
            Log.e("SwanAppCoreRuntime", "startFirstPage mMasterManager " + (dVar.cjI != null) + " startFirstPage mSlaveManager " + (dVar.cnA != null));
        }
    }

    public void c(@NonNull final com.baidu.swan.apps.runtime.e eVar) {
        ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.9
            @Override // java.lang.Runnable
            public void run() {
                boolean equals;
                if (d.this.cnA != null) {
                    if (a.C0388a.ajf()) {
                        equals = true;
                    } else {
                        String a2 = com.baidu.swan.apps.scheme.actions.k.c.a(com.baidu.swan.apps.v.f.arY(), eVar.XZ(), eVar.azR());
                        SwanAppConfigData azR = eVar.azR();
                        equals = "main".equals(azR != null ? azR.qm(a2) : null);
                    }
                    if (equals && eVar.azR() != null) {
                        com.baidu.swan.apps.core.h.b.ajg().a(d.cnQ ? d.this.cny.lx(eVar.getAppId()).aii() : d.this.cjI, d.this.cnA, eVar.XZ(), eVar.azR(), null);
                    }
                }
            }
        });
    }

    public void a(b bVar) {
        if (bVar != null && !this.cnx.contains(bVar)) {
            this.cnx.add(bVar);
        }
        boolean aka = aka();
        com.baidu.swan.apps.performance.i.avS().bW("preload", aka ? "1" : "0");
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareRuntime preload = " + aka);
        if (aka) {
            akd();
            return;
        }
        cnK = PreloadState.LOADING;
        com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_start"));
        akm();
        final boolean akk = akk();
        if (akk) {
            f aQa = com.baidu.swan.games.utils.so.d.aQa();
            if (!aQa.isSuccess() && aQa.aQj()) {
                akk = false;
            }
        }
        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "useV8Master:" + akk);
        if (akk) {
            eh(true);
        }
        if (this.cnw == null) {
            this.cnw = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.turbo.d.10
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Yx() {
                    if (d.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.10.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (d.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + d.this.cnC);
                            }
                            if (d.this.cnC) {
                                if (d.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            d.this.akm();
                            d.this.akp();
                            if (d.this.mSwanCoreVersion != null) {
                                d.this.eh(akk);
                                d.this.akl();
                                return;
                            }
                            PreloadState unused = d.cnK = PreloadState.LOAD_FAILED;
                            d.this.ajZ();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.cnO.a(this.cnw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajZ() {
        synchronized (this.cnF) {
            this.cnz = false;
            if (cnQ) {
                this.cny.reset();
            } else {
                this.cjI = null;
            }
        }
        this.cnB = false;
        this.cnA = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.d.a.jU(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", aiq());
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
        new c.a(10001).ri(com.baidu.swan.apps.runtime.e.azI() == null ? "null appKey" : com.baidu.swan.apps.runtime.e.azI().getAppKey()).rj(jSONObject.toString()).ama();
    }

    public boolean aka() {
        boolean z;
        synchronized (this.cnF) {
            z = this.cnz && this.cnB;
        }
        return z;
    }

    public boolean akb() {
        boolean z;
        synchronized (this.cnF) {
            z = this.cnz;
        }
        return z;
    }

    public boolean akc() {
        boolean z;
        synchronized (this.cnF) {
            z = this.cnB;
        }
        return z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akd() {
        if (!this.cnx.isEmpty() && aka()) {
            cnK = PreloadState.LOADED;
            c.akD();
            lS("event_preload_finish");
            com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_end"));
            for (b bVar : this.cnx) {
                if (bVar != null) {
                    if (DEBUG) {
                        Log.i("SwanAppCoreRuntime", "onReady result: " + bVar.toString());
                    }
                    bVar.I(this);
                }
            }
            this.cnx.clear();
        }
    }

    private String O(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.e.y(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    public String ake() {
        return !TextUtils.isEmpty(akf()) ? akf() + "runtime/index.js" : "";
    }

    public String akf() {
        return this.mSwanCoreVersion == null ? "" : this.mSwanCoreVersion.swanCorePath + File.separator;
    }

    public String akg() {
        String str;
        akm();
        if (aiq()) {
            str = ake();
        } else {
            str = this.mSwanCoreVersion.swanCorePath + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.e.Zo()) {
            O(str, false);
        } else if (com.baidu.swan.apps.console.debugger.a.e.aee()) {
            com.baidu.swan.apps.console.debugger.a.d.aeb();
            com.baidu.swan.apps.console.debugger.a.d.adX().kI("loadmaster");
            return com.baidu.swan.apps.console.debugger.a.e.aeh();
        } else {
            com.baidu.swan.apps.core.e.kR(str);
        }
        return ai.toFileUriString(str);
    }

    @Nullable
    public String akh() {
        akm();
        if (this.mSwanCoreVersion == null) {
            return null;
        }
        String str = this.mSwanCoreVersion.swanCorePath + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.e.Zo()) {
            O(str, true);
        } else if (com.baidu.swan.apps.console.debugger.a.e.aee()) {
            return com.baidu.swan.apps.console.debugger.a.e.aei();
        } else {
            com.baidu.swan.apps.core.e.kR(str);
        }
        return ai.toFileUriString(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aki() {
        if (!this.cjS.isEmpty()) {
            Iterator<com.baidu.swan.apps.event.a.a> it = this.cjS.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.event.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.bXU);
                }
                b(next);
            }
            this.cjS.clear();
        }
    }

    public boolean aiq() {
        return cnQ ? this.cny.aiq() : this.cjI instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a akj() {
        if (cnQ) {
            if (!this.cny.ain()) {
                return null;
            }
            return this.cny.aio().aii();
        }
        return this.cjI;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void eh(boolean z) {
        boolean z2;
        synchronized (this.cnF) {
            if (cnQ) {
                z2 = this.cny.aim();
            } else {
                z2 = this.cjI != null;
            }
            if (!this.cnz && !z2) {
                com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareMaster start.");
                com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                if (cnQ) {
                    this.cny.a(z, new com.baidu.swan.apps.core.g.a.c() { // from class: com.baidu.swan.apps.core.turbo.d.11
                        @Override // com.baidu.swan.apps.core.g.a.c
                        public void onReady() {
                            com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                            synchronized (d.this.cnF) {
                                d.this.cnz = true;
                                d.this.aki();
                                d.this.akd();
                            }
                        }
                    });
                    return;
                }
                this.cjI = this.cnN.h(getContext(), z ? 1 : 0);
                com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.cjI.loadUrl(akg());
                this.cjI.a(new g() { // from class: com.baidu.swan.apps.core.turbo.d.12
                    @Override // com.baidu.swan.apps.core.g
                    public void hs(String str) {
                        com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (d.this.cnF) {
                            d.this.cnz = true;
                            d.this.aki();
                            d.this.akd();
                        }
                    }
                });
            }
        }
    }

    public com.baidu.swan.apps.core.g.a a(boolean z, g gVar) {
        com.baidu.swan.apps.core.g.a h = this.cnN.h(getContext(), z ? 1 : 0);
        com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
        h.loadUrl(akg());
        h.a(gVar);
        return h;
    }

    private boolean akk() {
        if (com.baidu.swan.apps.console.debugger.a.e.aee() || com.baidu.swan.apps.t.a.aoV().Zo()) {
            return false;
        }
        if (com.baidu.swan.games.utils.so.d.aQf() != null) {
            boolean exists = new File(com.baidu.swan.games.utils.so.d.aQf()).exists();
            if (DEBUG) {
                Log.d("V8LoadChecker", "is v8 load success: " + exists);
            }
            if (!exists) {
                return false;
            }
        }
        return C0396d.YJ() && new File(ake()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akl() {
        if (!this.cnB && this.cnA == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.cnA = a(getContext(), new g() { // from class: com.baidu.swan.apps.core.turbo.d.2
                @Override // com.baidu.swan.apps.core.g
                public void hs(String str) {
                    com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    d.this.cnB = true;
                    d.this.akd();
                }
            });
            akr();
        }
    }

    public com.baidu.swan.apps.adaptation.b.c a(Context context, g gVar) {
        try {
            com.baidu.swan.apps.adaptation.b.c bp = this.cnN.bp(context);
            com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
            String akh = akh();
            if (akh != null) {
                com.baidu.swan.apps.runtime.e azJ = com.baidu.swan.apps.runtime.e.azJ();
                if (azJ != null && !TextUtils.isEmpty(azJ.getAppKey())) {
                    akh = Uri.parse(akh).buildUpon().appendQueryParameter("appPath", com.baidu.swan.apps.r.d.a(azJ.getAppKey(), azJ.getVersion(), false, null, null).getAbsolutePath()).toString();
                    if (!akh.endsWith(File.separator)) {
                        akh = akh + File.separator;
                    }
                }
                bp.loadUrl(akh);
            }
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "prepareSlave loadUrl " + akh);
            bp.a(gVar);
            return bp;
        } catch (NullPointerException e) {
            com.baidu.swan.apps.core.e.bP(context);
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
    public void akm() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            a(com.baidu.swan.apps.swancore.b.jD(0));
        }
    }

    public SwanCoreVersion akn() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore ako() {
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
    public void akp() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            a(com.baidu.swan.apps.extcore.b.hx(0));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.ako();
        }
    }

    @Override // com.baidu.swan.apps.v.h
    public void a(e eVar) {
        this.cnE.put(eVar.aaU(), eVar);
    }

    @Override // com.baidu.swan.apps.v.h
    public void b(e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void c(e eVar) {
    }

    @Override // com.baidu.swan.apps.v.h
    public void d(e eVar) {
        String aaU = eVar.aaU();
        this.cnE.remove(aaU);
        if (eVar instanceof com.baidu.swan.apps.adaptation.b.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", aaU);
            b(new com.baidu.swan.apps.event.a.c(hashMap));
            com.baidu.swan.apps.console.c.i("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.clearCachedLoadingViews();
    }

    public e lT(String str) {
        if (this.cnE.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.cnE.get(str);
    }

    public void b(com.baidu.swan.apps.event.a.a aVar) {
        com.baidu.swan.apps.core.container.a abI;
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.cnF) {
            if (!this.cnz) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.bXU)));
                }
                this.cjS.add(aVar);
                return;
            }
            if (cnQ) {
                if (!this.cny.ain()) {
                    this.cny.a(aVar);
                    return;
                } else if (this.cny.aio() != null) {
                    abI = this.cny.aio().aii().abI();
                } else {
                    return;
                }
            } else if (this.cjI != null) {
                abI = this.cjI.abI();
            } else {
                return;
            }
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "master dispatch msg:" + aVar.bXU);
            }
            com.baidu.swan.apps.event.a.a(abI, aVar);
        }
    }

    public void a(String str, com.baidu.swan.apps.event.a.a aVar) {
        if (com.baidu.swan.apps.core.g.a.a.lu(str)) {
            b(aVar);
            return;
        }
        e eVar = this.cnE.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.event.a.a(eVar.aaS(), aVar);
    }

    @Nullable
    public String akq() {
        akr();
        return this.cnH;
    }

    private void akr() {
        if (TextUtils.isEmpty(this.cnH)) {
            this.cnH = this.cnA != null ? this.cnA.getUserAgent() : "";
            com.baidu.swan.apps.console.c.bb("SwanAppCoreRuntime", "initWebViewUa ua: " + this.cnH);
        }
    }

    public void ei(boolean z) {
        boolean z2;
        if (cnQ) {
            z2 = this.cny.aim();
        } else {
            z2 = this.cjI != null;
        }
        if (z && !this.cnz && z2) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- master");
            }
            com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_master_js_ok"));
            synchronized (this.cnF) {
                this.cnz = true;
                aki();
                akd();
            }
        } else if (!z && this.cnA != null && !this.cnB) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "onJSLoaded -- slave");
            }
            com.baidu.swan.apps.performance.i.oW("preload").f(new UbcFlowEvent("na_pre_load_slave_js_ok"));
            this.cnB = true;
            akd();
        }
    }

    public void ej(boolean z) {
        this.cnD = z;
    }

    public boolean aks() {
        return this.cnD;
    }

    public String akt() {
        return this.cnG;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aku() {
        boolean z = true;
        if (this.cnP) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Cancel preload additional slave, already tried");
                return;
            }
            return;
        }
        this.cnP = true;
        com.baidu.swan.apps.runtime.d azE = com.baidu.swan.apps.runtime.d.azE();
        z = (azE == null || !azE.axR()) ? false : false;
        boolean YX = com.baidu.swan.apps.t.a.aoM().YX();
        if (!z && YX) {
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "Start preload additional slave manager");
            }
            com.baidu.swan.apps.core.slave.b.bU(getContext());
        } else if (DEBUG) {
            Log.i("SwanAppCoreRuntime", "Can't preload additional slave manager, isOccupied: " + z + ", ab: " + YX);
        }
    }

    public void a(String str, PrefetchEvent.b bVar) {
        if (cnQ && com.baidu.swan.apps.core.prefetch.a.a.ajd()) {
            this.cny.a(str, bVar);
            if (DEBUG) {
                Log.i("SwanAppCoreRuntime", "swan-core version - " + com.baidu.swan.apps.swancore.b.bL(this.mSwanCoreVersion.swanCoreVersion));
                Log.i("SwanAppCoreRuntime", "swan-core support preload ,fire a preload event");
            }
        }
    }

    /* loaded from: classes8.dex */
    public static abstract class b implements com.baidu.swan.apps.ap.e.b<d> {
        protected abstract void o(d dVar);

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.swan.apps.ap.e.b
        /* renamed from: p */
        public void I(d dVar) {
            o(dVar);
        }
    }

    /* renamed from: com.baidu.swan.apps.core.turbo.d$d  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public static class C0396d {
        private static final boolean cof;
        private static boolean cog;
        private static boolean coh;

        static {
            cof = ProcessUtils.isMainProcess() ? com.baidu.swan.apps.performance.b.c.Zi() : com.baidu.swan.apps.t.a.aoM().Zi();
            cog = cof ? true : com.baidu.swan.apps.t.a.aoM().YJ();
            coh = cog;
        }

        public static void s(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                cog = intent.getBooleanExtra("bundle_key_v8_ab", cog);
            }
        }

        public static void akH() {
            coh = cog;
        }

        public static String akI() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static void lU(String str) {
            PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).edit().putString("aiapps_v8_master_switch", str).apply();
        }

        public static boolean YJ() {
            if (d.DEBUG) {
                String akI = akI();
                char c = 65535;
                switch (akI.hashCode()) {
                    case -1406842887:
                        if (akI.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (akI.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (akI.equals("V8")) {
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
            return coh;
        }

        public static boolean akJ() {
            String akI = akI();
            if (akI.equals("V8")) {
                return true;
            }
            if (akI.equals("AB")) {
                if (cof) {
                    return true;
                }
                return com.baidu.swan.apps.t.a.aoM().YJ();
            }
            return false;
        }

        public static String hp(int i) {
            if (i == 1) {
                return "V8";
            }
            if (i == 0) {
                return "WebView";
            }
            return "AB";
        }
    }

    public void ek(boolean z) {
        if (a.isEnable()) {
            if (com.baidu.swan.apps.runtime.d.azE().azA().aAb()) {
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
            } else if (aka()) {
                if (DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: runtime ready, return.");
                }
            } else {
                f(new com.baidu.swan.apps.ap.e.b<Boolean>() { // from class: com.baidu.swan.apps.core.turbo.d.3
                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.swan.apps.ap.e.b
                    /* renamed from: e */
                    public void I(Boolean bool) {
                        d.this.ho(c.f(bool));
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ho(int i) {
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
                boolean ZM = com.baidu.swan.apps.t.a.aph().ZM();
                if (d.DEBUG) {
                    Log.i("SwanAppCoreRuntime", "checkRuntimeRetry: isLowDevice " + ZM);
                }
                if (bVar != null) {
                    bVar.I(Boolean.valueOf(ZM));
                }
            }
        }, "SWAN_DEVICE_PERFORMANCE_CHECK");
    }

    /* loaded from: classes8.dex */
    public static class c {
        private static final int coa = a.aky();
        private static final int cob = a.akz();
        private static int coc = 0;
        private static int cod = coc;
        private static final Runnable mRetryRunnable = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.1
            @Override // java.lang.Runnable
            public void run() {
                if (d.cnv.aka()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: runtimeReady is true, return.");
                    }
                } else if (c.cod >= 1) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "checkAndRetry: over max retry count, return.");
                    }
                } else {
                    if (!com.baidu.swan.apps.runtime.d.getMainHandler().hasCallbacks(c.coe)) {
                        com.baidu.swan.apps.runtime.d.getMainHandler().postDelayed(c.coe, a.akA());
                    }
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "start retry runtime.");
                    }
                    d.ajU();
                    c.a(new com.baidu.swan.apps.am.a().bO(5L).bP(49L).sm("start retry"));
                }
            }
        };
        private static final Runnable coe = new Runnable() { // from class: com.baidu.swan.apps.core.turbo.d.c.2
            @Override // java.lang.Runnable
            public void run() {
                if (d.cnv.aka()) {
                    if (d.DEBUG) {
                        Log.i("SwanAppCoreRuntime", "Retry: successfully.");
                    }
                } else if (c.cod >= 1) {
                    com.baidu.swan.apps.am.a sm = new com.baidu.swan.apps.am.a().bO(5L).bP(49L).sm("retry timeout");
                    c.a(sm);
                    com.baidu.swan.apps.u.b.a.a(d.getContext(), sm, 0, com.baidu.swan.apps.runtime.d.azE().getAppId());
                    com.baidu.swan.apps.ap.e.K(com.baidu.swan.apps.runtime.d.azE().azC());
                }
            }
        };

        static void a(com.baidu.swan.apps.am.a aVar) {
            int XP;
            com.baidu.swan.apps.runtime.e azA = com.baidu.swan.apps.runtime.d.azE().azA();
            if (azA != null && (XP = azA.XP()) == 0) {
                com.baidu.swan.apps.statistic.h.b(new com.baidu.swan.apps.statistic.a.d().i(aVar).a(azA.XZ()).ru(com.baidu.swan.apps.statistic.h.jv(XP)).rv(com.baidu.swan.apps.runtime.e.azK()));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static CopyOnWriteArrayList<b> akB() {
            return new CopyOnWriteArrayList<>(d.cnv.cnx);
        }

        static void akC() {
            cod++;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "incrementRetryTimes: retry times " + cod);
            }
        }

        static void akD() {
            cod = coc;
        }

        public static int f(Boolean bool) {
            return bool.booleanValue() ? coa : cob;
        }
    }

    /* loaded from: classes8.dex */
    public static class a {
        private static int cnZ = -1;

        static int akx() {
            if (cnZ < 0) {
                cnZ = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_core_runtime_delayed_retry_switch", 1);
            }
            return cnZ;
        }

        public static boolean isEnable() {
            boolean z = akx() > 0;
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "isEnable: " + z);
            }
            return z;
        }

        static int aky() {
            int i = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_core_runtime_low_end_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getLowDeviceTimeout: timeoutMs " + i);
            }
            return i;
        }

        static int akz() {
            int i = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_core_runtime_high_end_timeout", 6000);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getHighDeviceTimeout: " + i);
            }
            return i;
        }

        static int akA() {
            int i = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_core_runtime_retry_process_timeout", CoolPraiseGuideLottieView.ANIM_DURATION);
            if (d.DEBUG) {
                Log.i("SwanAppCoreRuntime", "getRetryProcessTimeout: " + i);
            }
            return i;
        }
    }
}
