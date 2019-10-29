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
    private static volatile c aOb;
    private SwanCoreVersion aOc;
    @Nullable
    private ExtensionCore aOd;
    private com.baidu.swan.apps.core.container.a.b aOe;
    private com.baidu.swan.apps.core.g.a aOg;
    private boolean aOh;
    private com.baidu.swan.apps.b.c.c aOi;
    private boolean aOj;
    private boolean aOk;
    private HashMap<String, e> aOl;
    private String aOo;
    private p aOr;
    private i aOs;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aOp = 10150;
    public static boolean aOq = false;
    private ArrayList<a> aOf = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> aOm = new LinkedList<>();
    private final Object aOn = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.aOl = new HashMap<>();
        this.aOr = com.baidu.swan.apps.ae.e.Rr().bks.get().AX().a(this);
        this.aOs = com.baidu.swan.apps.b.c.a.a.Cx().Cy().Cv();
    }

    public static c GO() {
        if (aOb == null) {
            synchronized (c.class) {
                if (aOb == null) {
                    aOb = new c();
                }
            }
        }
        return aOb;
    }

    public p GP() {
        return this.aOr;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (aOb != null) {
            aOb.aOk = true;
            aOq = false;
            if (aOb.aOe != null) {
                aOb.aOs.b(aOb.aOe);
            }
            GQ();
            h.b(aOb);
            aOb = null;
            GO().GR();
        }
    }

    private static void GQ() {
        if (aOb.aOl != null) {
            for (e eVar : ((HashMap) aOb.aOl.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (aOb.aOg != null) {
            if (aOb.aOg instanceof com.baidu.swan.apps.core.g.e) {
                aOb.aOg.destroy();
            }
            aOb.aOg = null;
        }
        if (aOb.aOi != null) {
            aOb.aOi = null;
        }
    }

    private void GR() {
        I(null);
    }

    public void I(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (GT()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        aOq = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.eS(0);
            extensionCore = com.baidu.swan.apps.extcore.a.HR().Hh();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.JE().cI(intent.getIntExtra("bundle_key_preload_switch", aOp));
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
        b.Hl();
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.1
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                if (c.DEBUG) {
                    d.i(c.getContext(), a.h.aiapps_preloadCoreRuntime_end).eF(1).QN();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Op().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.aOc != null) {
            bVar.a(this.aOc);
        } else {
            this.aOc = bVar.Hg();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.aOc);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.Hg());
        }
        d(bVar);
        e(bVar);
        f.NJ().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.Mw().gj("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.2
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aOk) {
                            f.gz("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.y.f.Mw().gj("na_pre_load_ok");
                            f.aB("preload", "startup");
                            if (c.this.aOg != null && c.this.aOi != null) {
                                com.baidu.swan.apps.scheme.actions.i.c.a(c.this.aOg, c.this.aOi, bVar, gVar);
                                c.this.aOi = null;
                            }
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.aOf.contains(aVar)) {
            this.aOf.add(aVar);
        }
        boolean GT = GT();
        f.NJ().az("preload", GT ? "1" : "0");
        if (GT) {
            GU();
            return;
        }
        f.gz("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Hf();
        if (Hd()) {
            Hc();
        }
        if (this.aOe == null) {
            this.aOe = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.j.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Er() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.gz("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.aOk);
                            }
                            if (c.this.aOk) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Hf();
                            c.this.Hi();
                            if (c.this.aOc != null) {
                                c.this.Hc();
                                c.this.He();
                                return;
                            }
                            c.this.GS();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.aOs.a(this.aOe);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS() {
        synchronized (this.aOn) {
            this.aOh = false;
            this.aOg = null;
        }
        this.aOj = false;
        this.aOi = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.fj(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", Ha());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion eS = com.baidu.swan.apps.swancore.b.eS(0);
            jSONObject.put("swan app core", eS == null ? "null" : Long.valueOf(eS.bqi));
            SwanCoreVersion eS2 = com.baidu.swan.apps.swancore.b.eS(1);
            jSONObject.put("swan game core", eS2 == null ? "null" : Long.valueOf(eS2.bqi));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0224a(10001).hU(com.baidu.swan.apps.ae.b.QZ() == null ? "null appkey" : com.baidu.swan.apps.ae.b.QZ().getAppKey()).hV(jSONObject.toString()).KZ();
    }

    public boolean GT() {
        boolean z;
        synchronized (this.aOn) {
            z = this.aOh && this.aOj;
        }
        return z;
    }

    public void GU() {
        if (!this.aOf.isEmpty() && GT()) {
            f.gz("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.aOf.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.aOf.clear();
        }
    }

    private String q(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.o(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String GV() {
        return !TextUtils.isEmpty(GW()) ? GW() + "runtime/index.js" : "";
    }

    public String GW() {
        return this.aOc == null ? "" : this.aOc.bql + File.separator;
    }

    public String GX() {
        String str;
        Hf();
        if (Ha()) {
            str = GV();
        } else {
            str = this.aOc.bql + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.BK()) {
            q(str, false);
        } else if (com.baidu.swan.apps.console.a.d.Dk()) {
            return com.baidu.swan.apps.console.a.d.Dl();
        } else {
            com.baidu.swan.apps.core.a.ef(str);
        }
        return aa.iX(str);
    }

    public String GY() {
        Hf();
        String str = this.aOc.bql + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.BK()) {
            q(str, true);
        } else if (com.baidu.swan.apps.console.a.d.Dk()) {
            return com.baidu.swan.apps.console.a.d.Dm();
        } else {
            com.baidu.swan.apps.core.a.ef(str);
        }
        return aa.iX(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GZ() {
        if (!this.aOm.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.aOm.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.aPY);
                }
                a(next);
            }
            this.aOm.clear();
        }
    }

    public boolean Ha() {
        return this.aOg instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a Hb() {
        return this.aOg;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hc() {
        synchronized (this.aOn) {
            if (!this.aOh && this.aOg == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.gz("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.aOg = this.aOr.f(getContext(), Hd() ? 1 : 0);
                f.gz("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.aOg.loadUrl(GX());
                this.aOg.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void db(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.gz("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.aOn) {
                            c.this.aOh = true;
                            c.this.GZ();
                            c.this.GU();
                        }
                    }
                });
            }
        }
    }

    private boolean Hd() {
        if (com.baidu.swan.apps.console.a.d.Dk() || com.baidu.swan.apps.u.a.Ju().BK()) {
            return false;
        }
        return b.Bq() && new File(GV()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void He() {
        if (!this.aOj && this.aOi == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.gz("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.aOi = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.5
                @Override // com.baidu.swan.apps.core.c
                public void db(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.gz("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.aOj = true;
                    c.this.GU();
                }
            });
            Hk();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c aI = this.aOr.aI(context);
        f.gz("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        aI.loadUrl(GY());
        aI.a(cVar);
        return aI;
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.aOc);
        }
        this.aOc = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.aOc);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        if (this.aOc == null || !this.aOc.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.eS(0));
        }
    }

    public SwanCoreVersion Hg() {
        return this.aOc;
    }

    @Nullable
    public ExtensionCore Hh() {
        return this.aOd;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.aOd);
        }
        this.aOd = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.aOd);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hi() {
        if (this.aOd == null || !this.aOd.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.HR().Hh());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.aOd != null) {
            bVar.a(this.aOd);
        } else {
            this.aOd = bVar.Hh();
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(com.baidu.swan.apps.b.c.e eVar) {
        this.aOl.put(eVar.Ct(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(com.baidu.swan.apps.b.c.e eVar) {
        String Ct = eVar.Ct();
        this.aOl.remove(Ct);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", Ct);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.QB();
    }

    public com.baidu.swan.apps.b.c.e eH(String str) {
        if (this.aOl.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aOl.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.aOn) {
            if (!this.aOh) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.aPY)));
                }
                this.aOm.add(aVar);
            } else if (this.aOg != null) {
                com.baidu.swan.apps.m.a.a(this.aOg.FY(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.b.c.e eVar = this.aOl.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.Cr(), aVar);
    }

    @Nullable
    public String Hj() {
        Hk();
        return this.aOo;
    }

    private void Hk() {
        if (TextUtils.isEmpty(this.aOo)) {
            this.aOo = this.aOi != null ? this.aOi.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.aOo);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean aOx = com.baidu.swan.apps.u.a.Jl().Bq();
        private static boolean aOy = false;

        public static void J(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                aOx = intent.getBooleanExtra("bundle_key_v8_ab", aOx);
            }
        }

        public static void Hl() {
            aOy = aOx;
        }

        public static String Hm() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Bq() {
            if (c.DEBUG) {
                String Hm = Hm();
                char c = 65535;
                switch (Hm.hashCode()) {
                    case -1406842887:
                        if (Hm.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Hm.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Hm.equals("V8")) {
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
            return aOy;
        }
    }
}
