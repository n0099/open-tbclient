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
    private static volatile c aNJ;
    private SwanCoreVersion aNK;
    @Nullable
    private ExtensionCore aNL;
    private com.baidu.swan.apps.core.container.a.b aNM;
    private com.baidu.swan.apps.core.g.a aNO;
    private boolean aNP;
    private com.baidu.swan.apps.b.c.c aNQ;
    private boolean aNR;
    private boolean aNS;
    private HashMap<String, e> aNT;
    private String aNW;
    private p aNZ;
    private i aOa;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int aNX = 10150;
    public static boolean aNY = false;
    private ArrayList<a> aNN = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> aNU = new LinkedList<>();
    private final Object aNV = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.aNT = new HashMap<>();
        this.aNZ = com.baidu.swan.apps.ae.e.Rt().bka.get().AY().a(this);
        this.aOa = com.baidu.swan.apps.b.c.a.a.Cy().Cz().Cw();
    }

    public static c GP() {
        if (aNJ == null) {
            synchronized (c.class) {
                if (aNJ == null) {
                    aNJ = new c();
                }
            }
        }
        return aNJ;
    }

    public p GQ() {
        return this.aNZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (aNJ != null) {
            aNJ.aNS = true;
            aNY = false;
            if (aNJ.aNM != null) {
                aNJ.aOa.b(aNJ.aNM);
            }
            GR();
            h.b(aNJ);
            aNJ = null;
            GP().GS();
        }
    }

    private static void GR() {
        if (aNJ.aNT != null) {
            for (e eVar : ((HashMap) aNJ.aNT.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (aNJ.aNO != null) {
            if (aNJ.aNO instanceof com.baidu.swan.apps.core.g.e) {
                aNJ.aNO.destroy();
            }
            aNJ.aNO = null;
        }
        if (aNJ.aNQ != null) {
            aNJ.aNQ = null;
        }
    }

    private void GS() {
        I(null);
    }

    public void I(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (GU()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        aNY = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.eS(0);
            extensionCore = com.baidu.swan.apps.extcore.a.HS().Hi();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.JF().cI(intent.getIntExtra("bundle_key_preload_switch", aNX));
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
        b.Hm();
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.1
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                if (c.DEBUG) {
                    d.i(c.getContext(), a.h.aiapps_preloadCoreRuntime_end).eF(1).QO();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Oq().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.aNK != null) {
            bVar.a(this.aNK);
        } else {
            this.aNK = bVar.Hh();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.aNK);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.Hh());
        }
        d(bVar);
        e(bVar);
        f.NK().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.Mx().gj("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.2
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.aNS) {
                            f.gz("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.y.f.Mx().gj("na_pre_load_ok");
                            f.aB("preload", "startup");
                            if (c.this.aNO != null && c.this.aNQ != null) {
                                com.baidu.swan.apps.scheme.actions.i.c.a(c.this.aNO, c.this.aNQ, bVar, gVar);
                                c.this.aNQ = null;
                            }
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.aNN.contains(aVar)) {
            this.aNN.add(aVar);
        }
        boolean GU = GU();
        f.NK().az("preload", GU ? "1" : "0");
        if (GU) {
            GV();
            return;
        }
        f.gz("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Hg();
        if (He()) {
            Hd();
        }
        if (this.aNM == null) {
            this.aNM = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.j.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void Es() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.gz("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.aNS);
                            }
                            if (c.this.aNS) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Hg();
                            c.this.Hj();
                            if (c.this.aNK != null) {
                                c.this.Hd();
                                c.this.Hf();
                                return;
                            }
                            c.this.GT();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.aOa.a(this.aNM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GT() {
        synchronized (this.aNV) {
            this.aNP = false;
            this.aNO = null;
        }
        this.aNR = false;
        this.aNQ = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.fj(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", Hb());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion eS = com.baidu.swan.apps.swancore.b.eS(0);
            jSONObject.put("swan app core", eS == null ? "null" : Long.valueOf(eS.bpQ));
            SwanCoreVersion eS2 = com.baidu.swan.apps.swancore.b.eS(1);
            jSONObject.put("swan game core", eS2 == null ? "null" : Long.valueOf(eS2.bpQ));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0219a(10001).hU(com.baidu.swan.apps.ae.b.Ra() == null ? "null appkey" : com.baidu.swan.apps.ae.b.Ra().getAppKey()).hV(jSONObject.toString()).La();
    }

    public boolean GU() {
        boolean z;
        synchronized (this.aNV) {
            z = this.aNP && this.aNR;
        }
        return z;
    }

    public void GV() {
        if (!this.aNN.isEmpty() && GU()) {
            f.gz("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.aNN.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.aNN.clear();
        }
    }

    private String q(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.o(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String GW() {
        return !TextUtils.isEmpty(GX()) ? GX() + "runtime/index.js" : "";
    }

    public String GX() {
        return this.aNK == null ? "" : this.aNK.bpT + File.separator;
    }

    public String GY() {
        String str;
        Hg();
        if (Hb()) {
            str = GW();
        } else {
            str = this.aNK.bpT + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.BL()) {
            q(str, false);
        } else if (com.baidu.swan.apps.console.a.d.Dl()) {
            return com.baidu.swan.apps.console.a.d.Dm();
        } else {
            com.baidu.swan.apps.core.a.ef(str);
        }
        return aa.iX(str);
    }

    public String GZ() {
        Hg();
        String str = this.aNK.bpT + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.BL()) {
            q(str, true);
        } else if (com.baidu.swan.apps.console.a.d.Dl()) {
            return com.baidu.swan.apps.console.a.d.Dn();
        } else {
            com.baidu.swan.apps.core.a.ef(str);
        }
        return aa.iX(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ha() {
        if (!this.aNU.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.aNU.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.aPG);
                }
                a(next);
            }
            this.aNU.clear();
        }
    }

    public boolean Hb() {
        return this.aNO instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a Hc() {
        return this.aNO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hd() {
        synchronized (this.aNV) {
            if (!this.aNP && this.aNO == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.gz("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.aNO = this.aNZ.f(getContext(), He() ? 1 : 0);
                f.gz("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.aNO.loadUrl(GY());
                this.aNO.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void db(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.gz("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.aNV) {
                            c.this.aNP = true;
                            c.this.Ha();
                            c.this.GV();
                        }
                    }
                });
            }
        }
    }

    private boolean He() {
        if (com.baidu.swan.apps.console.a.d.Dl() || com.baidu.swan.apps.u.a.Jv().BL()) {
            return false;
        }
        return b.Br() && new File(GW()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hf() {
        if (!this.aNR && this.aNQ == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.gz("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.aNQ = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.5
                @Override // com.baidu.swan.apps.core.c
                public void db(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.gz("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.aNR = true;
                    c.this.GV();
                }
            });
            Hl();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c aI = this.aNZ.aI(context);
        f.gz("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        aI.loadUrl(GZ());
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.aNK);
        }
        this.aNK = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.aNK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hg() {
        if (this.aNK == null || !this.aNK.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.eS(0));
        }
    }

    public SwanCoreVersion Hh() {
        return this.aNK;
    }

    @Nullable
    public ExtensionCore Hi() {
        return this.aNL;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.aNL);
        }
        this.aNL = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.aNL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hj() {
        if (this.aNL == null || !this.aNL.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.HS().Hi());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.aNL != null) {
            bVar.a(this.aNL);
        } else {
            this.aNL = bVar.Hi();
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(com.baidu.swan.apps.b.c.e eVar) {
        this.aNT.put(eVar.Cu(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(com.baidu.swan.apps.b.c.e eVar) {
        String Cu = eVar.Cu();
        this.aNT.remove(Cu);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", Cu);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.QC();
    }

    public com.baidu.swan.apps.b.c.e eH(String str) {
        if (this.aNT.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.aNT.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.aNV) {
            if (!this.aNP) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.aPG)));
                }
                this.aNU.add(aVar);
            } else if (this.aNO != null) {
                com.baidu.swan.apps.m.a.a(this.aNO.FZ(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.b.c.e eVar = this.aNT.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.Cs(), aVar);
    }

    @Nullable
    public String Hk() {
        Hl();
        return this.aNW;
    }

    private void Hl() {
        if (TextUtils.isEmpty(this.aNW)) {
            this.aNW = this.aNQ != null ? this.aNQ.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.aNW);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean aOf = com.baidu.swan.apps.u.a.Jm().Br();
        private static boolean aOg = false;

        public static void J(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                aOf = intent.getBooleanExtra("bundle_key_v8_ab", aOf);
            }
        }

        public static void Hm() {
            aOg = aOf;
        }

        public static String Hn() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean Br() {
            if (c.DEBUG) {
                String Hn = Hn();
                char c = 65535;
                switch (Hn.hashCode()) {
                    case -1406842887:
                        if (Hn.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Hn.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Hn.equals("V8")) {
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
            return aOg;
        }
    }
}
