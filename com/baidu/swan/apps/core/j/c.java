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
    private static volatile c atJ;
    private SwanCoreVersion atK;
    @Nullable
    private ExtensionCore atL;
    private com.baidu.swan.apps.core.container.a.b atM;
    private com.baidu.swan.apps.core.g.a atO;
    private boolean atP;
    private com.baidu.swan.apps.b.c.c atQ;
    private boolean atR;
    private boolean atS;
    private HashMap<String, e> atT;
    private String atW;
    private p atZ;
    private i aua;
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int atX = 10150;
    public static boolean atY = false;
    private ArrayList<a> atN = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> atU = new LinkedList<>();
    private final Object atV = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.atT = new HashMap<>();
        this.atZ = com.baidu.swan.apps.ae.e.LH().aQg.get().vy().a(this);
        this.aua = com.baidu.swan.apps.b.c.a.a.wY().wZ().wW();
    }

    public static c Bi() {
        if (atJ == null) {
            synchronized (c.class) {
                if (atJ == null) {
                    atJ = new c();
                }
            }
        }
        return atJ;
    }

    public p Bj() {
        return this.atZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (atJ != null) {
            atJ.atS = true;
            atY = false;
            if (atJ.atM != null) {
                atJ.aua.b(atJ.atM);
            }
            Bk();
            h.b(atJ);
            atJ = null;
            Bi().Bl();
        }
    }

    private static void Bk() {
        if (atJ.atT != null) {
            for (e eVar : ((HashMap) atJ.atT.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (atJ.atO != null) {
            if (atJ.atO instanceof com.baidu.swan.apps.core.g.e) {
                atJ.atO.destroy();
            }
            atJ.atO = null;
        }
        if (atJ.atQ != null) {
            atJ.atQ = null;
        }
    }

    private void Bl() {
        C(null);
    }

    public void C(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Bn()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        atY = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.dT(0);
            extensionCore = com.baidu.swan.apps.extcore.a.Ck().BB();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.DX().bL(intent.getIntExtra("bundle_key_preload_switch", atX));
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
        b.BF();
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.1
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                if (c.DEBUG) {
                    d.k(c.getContext(), a.h.aiapps_preloadCoreRuntime_end).dG(1).Ld();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.IE().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.atK != null) {
            bVar.a(this.atK);
        } else {
            this.atK = bVar.BA();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.atK);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.BA());
        }
        d(bVar);
        e(bVar);
        f.HY().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.GN().fy("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.2
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.atS) {
                            f.fN("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.y.f.GN().fy("na_pre_load_ok");
                            f.at("preload", "startup");
                            if (c.this.atO != null && c.this.atQ != null) {
                                com.baidu.swan.apps.scheme.actions.i.c.a(c.this.atO, c.this.atQ, bVar, gVar);
                                c.this.atQ = null;
                            }
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.atN.contains(aVar)) {
            this.atN.add(aVar);
        }
        boolean Bn = Bn();
        f.HY().ar("preload", Bn ? "1" : "0");
        if (Bn) {
            Bo();
            return;
        }
        f.fN("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Bz();
        if (Bx()) {
            Bw();
        }
        if (this.atM == null) {
            this.atM = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.j.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void yL() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.fN("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.atS);
                            }
                            if (c.this.atS) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Bz();
                            c.this.BC();
                            if (c.this.atK != null) {
                                c.this.Bw();
                                c.this.By();
                                return;
                            }
                            c.this.Bm();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.aua.a(this.atM);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bm() {
        synchronized (this.atV) {
            this.atP = false;
            this.atO = null;
        }
        this.atR = false;
        this.atQ = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.ek(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", Bu());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion dT = com.baidu.swan.apps.swancore.b.dT(0);
            jSONObject.put("swan app core", dT == null ? "null" : Long.valueOf(dT.aVW));
            SwanCoreVersion dT2 = com.baidu.swan.apps.swancore.b.dT(1);
            jSONObject.put("swan game core", dT2 == null ? "null" : Long.valueOf(dT2.aVW));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0181a(10001).hi(com.baidu.swan.apps.ae.b.Lq() == null ? "null appkey" : com.baidu.swan.apps.ae.b.Lq().getAppKey()).hj(jSONObject.toString()).Fr();
    }

    public boolean Bn() {
        boolean z;
        synchronized (this.atV) {
            z = this.atP && this.atR;
        }
        return z;
    }

    public void Bo() {
        if (!this.atN.isEmpty() && Bn()) {
            f.fN("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.atN.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.atN.clear();
        }
    }

    private String n(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.k(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String Bp() {
        return !TextUtils.isEmpty(Bq()) ? Bq() + "runtime/index.js" : "";
    }

    public String Bq() {
        return this.atK == null ? "" : this.atK.aVZ + File.separator;
    }

    public String Br() {
        String str;
        Bz();
        if (Bu()) {
            str = Bp();
        } else {
            str = this.atK.aVZ + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.wl()) {
            n(str, false);
        } else if (com.baidu.swan.apps.console.a.d.xG()) {
            return com.baidu.swan.apps.console.a.d.xH();
        } else {
            com.baidu.swan.apps.core.a.dp(str);
        }
        return aa.il(str);
    }

    public String Bs() {
        Bz();
        String str = this.atK.aVZ + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.wl()) {
            n(str, true);
        } else if (com.baidu.swan.apps.console.a.d.xG()) {
            return com.baidu.swan.apps.console.a.d.xI();
        } else {
            com.baidu.swan.apps.core.a.dp(str);
        }
        return aa.il(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt() {
        if (!this.atU.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.atU.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.avG);
                }
                a(next);
            }
            this.atU.clear();
        }
    }

    public boolean Bu() {
        return this.atO instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a Bv() {
        return this.atO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw() {
        synchronized (this.atV) {
            if (!this.atP && this.atO == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.fN("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.atO = this.atZ.h(getContext(), Bx() ? 1 : 0);
                f.fN("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.atO.loadUrl(Br());
                this.atO.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void dr(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.fN("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.atV) {
                            c.this.atP = true;
                            c.this.Bt();
                            c.this.Bo();
                        }
                    }
                });
            }
        }
    }

    private boolean Bx() {
        if (com.baidu.swan.apps.console.a.d.xG() || com.baidu.swan.apps.u.a.DN().wl()) {
            return false;
        }
        return b.vR() && new File(Bp()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void By() {
        if (!this.atR && this.atQ == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.fN("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.atQ = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.5
                @Override // com.baidu.swan.apps.core.c
                public void dr(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.fN("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.atR = true;
                    c.this.Bo();
                }
            });
            BE();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c aG = this.atZ.aG(context);
        f.fN("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        aG.loadUrl(Bs());
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.atK);
        }
        this.atK = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.atK);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bz() {
        if (this.atK == null || !this.atK.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.dT(0));
        }
    }

    public SwanCoreVersion BA() {
        return this.atK;
    }

    @Nullable
    public ExtensionCore BB() {
        return this.atL;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.atL);
        }
        this.atL = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.atL);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BC() {
        if (this.atL == null || !this.atL.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.Ck().BB());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.atL != null) {
            bVar.a(this.atL);
        } else {
            this.atL = bVar.BB();
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(com.baidu.swan.apps.b.c.e eVar) {
        this.atT.put(eVar.wU(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(com.baidu.swan.apps.b.c.e eVar) {
        String wU = eVar.wU();
        this.atT.remove(wU);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", wU);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.KR();
    }

    public com.baidu.swan.apps.b.c.e dT(String str) {
        if (this.atT.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atT.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.atV) {
            if (!this.atP) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.avG)));
                }
                this.atU.add(aVar);
            } else if (this.atO != null) {
                com.baidu.swan.apps.m.a.a(this.atO.Ar(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.b.c.e eVar = this.atT.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.wS(), aVar);
    }

    @Nullable
    public String BD() {
        BE();
        return this.atW;
    }

    private void BE() {
        if (TextUtils.isEmpty(this.atW)) {
            this.atW = this.atQ != null ? this.atQ.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.atW);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean auf = com.baidu.swan.apps.u.a.DE().vR();
        private static boolean aug = false;

        public static void D(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                auf = intent.getBooleanExtra("bundle_key_v8_ab", auf);
            }
        }

        public static void BF() {
            aug = auf;
        }

        public static String BG() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean vR() {
            if (c.DEBUG) {
                String BG = BG();
                char c = 65535;
                switch (BG.hashCode()) {
                    case -1406842887:
                        if (BG.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (BG.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (BG.equals("V8")) {
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
            return aug;
        }
    }
}
