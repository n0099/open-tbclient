package com.baidu.swan.apps.core.j;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.process.ipc.util.ProcessUtils;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.b.b.p;
import com.baidu.swan.apps.b.c.e;
import com.baidu.swan.apps.b.c.i;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.install.e;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.statistic.a;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.g;
import com.baidu.swan.apps.w.h;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class c implements g {
    private static volatile c auK;
    private SwanCoreVersion auL;
    @Nullable
    private ExtensionCore auM;
    private com.baidu.swan.apps.core.container.a.b auN;
    private com.baidu.swan.apps.core.g.a auP;
    private boolean auQ;
    private com.baidu.swan.apps.b.c.c auR;
    private boolean auS;
    private boolean auT;
    private HashMap<String, e> auU;
    private String auX;
    private p ava;
    private i avb;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int auY = 10150;
    public static boolean auZ = false;
    private ArrayList<a> auO = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> auV = new LinkedList<>();
    private final Object auW = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.auU = new HashMap<>();
        this.ava = com.baidu.swan.apps.ae.e.Mz().aRo.get().wd().a(this);
        this.avb = com.baidu.swan.apps.b.c.a.a.xD().xE().xB();
    }

    public static c BU() {
        if (auK == null) {
            synchronized (c.class) {
                if (auK == null) {
                    auK = new c();
                }
            }
        }
        return auK;
    }

    public p BV() {
        return this.ava;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (auK != null) {
            auK.auT = true;
            auZ = false;
            if (auK.auN != null) {
                auK.avb.b(auK.auN);
            }
            BW();
            h.b(auK);
            auK = null;
            BU().BX();
        }
    }

    private static void BW() {
        if (auK.auU != null) {
            for (e eVar : ((HashMap) auK.auU.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (auK.auP != null) {
            if (auK.auP instanceof com.baidu.swan.apps.core.g.e) {
                auK.auP.destroy();
            }
            auK.auP = null;
        }
        if (auK.auR != null) {
            auK.auR = null;
        }
    }

    private void BX() {
        C(null);
    }

    public void C(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (BZ()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        auZ = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.dX(0);
            extensionCore = com.baidu.swan.apps.extcore.a.CX().Cn();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.EK().bM(intent.getIntExtra("bundle_key_preload_switch", auY));
        }
        if (swanCoreVersion == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("preloadCoreRuntime version is invalid.")));
                return;
            }
            return;
        }
        a(swanCoreVersion);
        if (extensionCore == null && DEBUG) {
            Log.w("SwanAppCoreRuntime", "preloadCoreRuntime with null extensionCore");
        }
        a(extensionCore);
        b.Cr();
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.1
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                if (c.DEBUG) {
                    d.k(c.getContext(), a.h.aiapps_preloadCoreRuntime_end).dK(1).LU();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Jv().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.auL != null) {
            bVar.a(this.auL);
        } else {
            this.auL = bVar.Cm();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.auL);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.Cm());
        }
        d(bVar);
        e(bVar);
        f.IP().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.HC().fF("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.2
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.auT) {
                            f.fU("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.y.f.HC().fF("na_pre_load_ok");
                            f.at("preload", "startup");
                            if (c.this.auP != null && c.this.auR != null) {
                                com.baidu.swan.apps.scheme.actions.i.c.a(c.this.auP, c.this.auR, bVar, gVar);
                                c.this.auR = null;
                            }
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.auO.contains(aVar)) {
            this.auO.add(aVar);
        }
        boolean BZ = BZ();
        f.IP().ar("preload", BZ ? "1" : "0");
        if (BZ) {
            Ca();
            return;
        }
        f.fU("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Cl();
        if (Cj()) {
            Ci();
        }
        if (this.auN == null) {
            this.auN = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.j.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void zw() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.fU("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.auT);
                            }
                            if (c.this.auT) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Cl();
                            c.this.Co();
                            if (c.this.auL != null) {
                                c.this.Ci();
                                c.this.Ck();
                                return;
                            }
                            c.this.BY();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.avb.a(this.auN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BY() {
        synchronized (this.auW) {
            this.auQ = false;
            this.auP = null;
        }
        this.auS = false;
        this.auR = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.eo(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", Cg());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion dX = com.baidu.swan.apps.swancore.b.dX(0);
            jSONObject.put("swan app core", dX == null ? "null" : Long.valueOf(dX.aXe));
            SwanCoreVersion dX2 = com.baidu.swan.apps.swancore.b.dX(1);
            jSONObject.put("swan game core", dX2 == null ? "null" : Long.valueOf(dX2.aXe));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0192a(10001).hr(com.baidu.swan.apps.ae.b.Mh() == null ? "null appkey" : com.baidu.swan.apps.ae.b.Mh().getAppKey()).hs(jSONObject.toString()).Gf();
    }

    public boolean BZ() {
        boolean z;
        synchronized (this.auW) {
            z = this.auQ && this.auS;
        }
        return z;
    }

    public void Ca() {
        if (!this.auO.isEmpty() && BZ()) {
            f.fU("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.auO.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.auO.clear();
        }
    }

    private String n(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.k(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String Cb() {
        return !TextUtils.isEmpty(Cc()) ? Cc() + "runtime/index.js" : "";
    }

    public String Cc() {
        return this.auL == null ? "" : this.auL.aXh + File.separator;
    }

    public String Cd() {
        String str;
        Cl();
        if (Cg()) {
            str = Cb();
        } else {
            str = this.auL.aXh + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.wQ()) {
            n(str, false);
        } else if (com.baidu.swan.apps.console.a.d.yp()) {
            return com.baidu.swan.apps.console.a.d.yq();
        } else {
            com.baidu.swan.apps.core.a.dw(str);
        }
        return aa.iu(str);
    }

    public String Ce() {
        Cl();
        String str = this.auL.aXh + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.wQ()) {
            n(str, true);
        } else if (com.baidu.swan.apps.console.a.d.yp()) {
            return com.baidu.swan.apps.console.a.d.yr();
        } else {
            com.baidu.swan.apps.core.a.dw(str);
        }
        return aa.iu(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cf() {
        if (!this.auV.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.auV.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.awJ);
                }
                a(next);
            }
            this.auV.clear();
        }
    }

    public boolean Cg() {
        return this.auP instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a Ch() {
        return this.auP;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ci() {
        synchronized (this.auW) {
            if (!this.auQ && this.auP == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.fU("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.auP = this.ava.h(getContext(), Cj() ? 1 : 0);
                f.fU("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.auP.loadUrl(Cd());
                this.auP.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void dy(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.fU("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.auW) {
                            c.this.auQ = true;
                            c.this.Cf();
                            c.this.Ca();
                        }
                    }
                });
            }
        }
    }

    private boolean Cj() {
        if (com.baidu.swan.apps.console.a.d.yp() || com.baidu.swan.apps.u.a.EA().wQ()) {
            return false;
        }
        return b.ww() && new File(Cb()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        if (!this.auS && this.auR == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.fU("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.auR = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.5
                @Override // com.baidu.swan.apps.core.c
                public void dy(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.fU("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.auS = true;
                    c.this.Ca();
                }
            });
            Cq();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c aG = this.ava.aG(context);
        f.fU("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        aG.loadUrl(Ce());
        aG.a(cVar);
        return aG;
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.auL);
        }
        this.auL = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.auL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cl() {
        if (this.auL == null || !this.auL.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.dX(0));
        }
    }

    public SwanCoreVersion Cm() {
        return this.auL;
    }

    @Nullable
    public ExtensionCore Cn() {
        return this.auM;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.auM);
        }
        this.auM = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.auM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Co() {
        if (this.auM == null || !this.auM.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.CX().Cn());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.auM != null) {
            bVar.a(this.auM);
        } else {
            this.auM = bVar.Cn();
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(com.baidu.swan.apps.b.c.e eVar) {
        this.auU.put(eVar.xz(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(com.baidu.swan.apps.b.c.e eVar) {
        String xz = eVar.xz();
        this.auU.remove(xz);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", xz);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.LI();
    }

    public com.baidu.swan.apps.b.c.e ea(String str) {
        if (this.auU.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.auU.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.auW) {
            if (!this.auQ) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.awJ)));
                }
                this.auV.add(aVar);
            } else if (this.auP != null) {
                com.baidu.swan.apps.m.a.a(this.auP.Bd(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.b.c.e eVar = this.auU.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.xx(), aVar);
    }

    @Nullable
    public String Cp() {
        Cq();
        return this.auX;
    }

    private void Cq() {
        if (TextUtils.isEmpty(this.auX)) {
            this.auX = this.auR != null ? this.auR.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.auX);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean avg = com.baidu.swan.apps.u.a.Er().ww();
        private static boolean avh = false;

        public static void D(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                avg = intent.getBooleanExtra("bundle_key_v8_ab", avg);
            }
        }

        public static void Cr() {
            avh = avg;
        }

        public static String Cs() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean ww() {
            if (c.DEBUG) {
                String Cs = Cs();
                char c = 65535;
                switch (Cs.hashCode()) {
                    case -1406842887:
                        if (Cs.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Cs.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Cs.equals("V8")) {
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
            return avh;
        }
    }
}
