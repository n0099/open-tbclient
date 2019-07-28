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
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static int auA = 10150;
    public static boolean auB = false;
    private static volatile c aum;
    private p auC;
    private i auD;
    private SwanCoreVersion aun;
    @Nullable
    private ExtensionCore auo;
    private com.baidu.swan.apps.core.container.a.b aup;
    private com.baidu.swan.apps.core.g.a aur;
    private boolean aus;
    private com.baidu.swan.apps.b.c.c aut;
    private boolean auu;
    private boolean auv;
    private HashMap<String, e> auw;
    private String auz;
    private ArrayList<a> auq = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> aux = new LinkedList<>();
    private final Object auy = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.auw = new HashMap<>();
        this.auC = com.baidu.swan.apps.ae.e.Mv().aQQ.get().vZ().a(this);
        this.auD = com.baidu.swan.apps.b.c.a.a.xz().xA().xx();
    }

    public static c BQ() {
        if (aum == null) {
            synchronized (c.class) {
                if (aum == null) {
                    aum = new c();
                }
            }
        }
        return aum;
    }

    public p BR() {
        return this.auC;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (aum != null) {
            aum.auv = true;
            auB = false;
            if (aum.aup != null) {
                aum.auD.b(aum.aup);
            }
            BS();
            h.b(aum);
            aum = null;
            BQ().BT();
        }
    }

    private static void BS() {
        if (aum.auw != null) {
            for (e eVar : ((HashMap) aum.auw.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (aum.aur != null) {
            if (aum.aur instanceof com.baidu.swan.apps.core.g.e) {
                aum.aur.destroy();
            }
            aum.aur = null;
        }
        if (aum.aut != null) {
            aum.aut = null;
        }
    }

    private void BT() {
        C(null);
    }

    public void C(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (BV()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        auB = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.dW(0);
            extensionCore = com.baidu.swan.apps.extcore.a.CT().Cj();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.EG().bL(intent.getIntExtra("bundle_key_preload_switch", auA));
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
        b.Cn();
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.1
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                if (c.DEBUG) {
                    d.k(c.getContext(), a.h.aiapps_preloadCoreRuntime_end).dJ(1).LQ();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Jr().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.aun != null) {
            bVar.a(this.aun);
        } else {
            this.aun = bVar.Ci();
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final e.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur swanCoreVersion: " + this.aun);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.Ci());
        }
        d(bVar);
        e(bVar);
        f.IL().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.Hy().fD("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.j.c.2
            @Override // com.baidu.swan.apps.core.j.c.a
            public void onReady() {
                ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.2.1
                    @Override // java.lang.Runnable
                    public void run() {
                        if (!c.this.auv) {
                            f.fS("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                            com.baidu.swan.apps.y.f.Hy().fD("na_pre_load_ok");
                            f.at("preload", "startup");
                            if (c.this.aur != null && c.this.aut != null) {
                                com.baidu.swan.apps.scheme.actions.i.c.a(c.this.aur, c.this.aut, bVar, gVar);
                                c.this.aut = null;
                            }
                        }
                    }
                });
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.auq.contains(aVar)) {
            this.auq.add(aVar);
        }
        boolean BV = BV();
        f.IL().ar("preload", BV ? "1" : "0");
        if (BV) {
            BW();
            return;
        }
        f.fS("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Ch();
        if (Cf()) {
            Ce();
        }
        if (this.aup == null) {
            this.aup = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.j.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void zs() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.fS("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.j.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.auv);
                            }
                            if (c.this.auv) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Ch();
                            c.this.Ck();
                            if (c.this.aun != null) {
                                c.this.Ce();
                                c.this.Cg();
                                return;
                            }
                            c.this.BU();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.auD.a(this.aup);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void BU() {
        synchronized (this.auy) {
            this.aus = false;
            this.aur = null;
        }
        this.auu = false;
        this.aut = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.en(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("is V8", Cc());
            jSONObject.put("in main", ProcessUtils.isMainProcess());
            SwanCoreVersion dW = com.baidu.swan.apps.swancore.b.dW(0);
            jSONObject.put("swan app core", dW == null ? "null" : Long.valueOf(dW.aWG));
            SwanCoreVersion dW2 = com.baidu.swan.apps.swancore.b.dW(1);
            jSONObject.put("swan game core", dW2 == null ? "null" : Long.valueOf(dW2.aWG));
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0183a(10001).hp(com.baidu.swan.apps.ae.b.Md() == null ? "null appkey" : com.baidu.swan.apps.ae.b.Md().getAppKey()).hq(jSONObject.toString()).Gb();
    }

    public boolean BV() {
        boolean z;
        synchronized (this.auy) {
            z = this.aus && this.auu;
        }
        return z;
    }

    public void BW() {
        if (!this.auq.isEmpty() && BV()) {
            f.fS("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.auq.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.auq.clear();
        }
    }

    private String n(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.k(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String BX() {
        return !TextUtils.isEmpty(BY()) ? BY() + "runtime/index.js" : "";
    }

    public String BY() {
        return this.aun == null ? "" : this.aun.aWJ + File.separator;
    }

    public String BZ() {
        String str;
        Ch();
        if (Cc()) {
            str = BX();
        } else {
            str = this.aun.aWJ + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.wM()) {
            n(str, false);
        } else if (com.baidu.swan.apps.console.a.d.yl()) {
            return com.baidu.swan.apps.console.a.d.ym();
        } else {
            com.baidu.swan.apps.core.a.du(str);
        }
        return aa.is(str);
    }

    public String Ca() {
        Ch();
        String str = this.aun.aWJ + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.wM()) {
            n(str, true);
        } else if (com.baidu.swan.apps.console.a.d.yl()) {
            return com.baidu.swan.apps.console.a.d.yn();
        } else {
            com.baidu.swan.apps.core.a.du(str);
        }
        return aa.is(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cb() {
        if (!this.aux.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.aux.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.awl);
                }
                a(next);
            }
            this.aux.clear();
        }
    }

    public boolean Cc() {
        return this.aur instanceof com.baidu.swan.apps.core.g.e;
    }

    public com.baidu.swan.apps.core.g.a Cd() {
        return this.aur;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ce() {
        synchronized (this.auy) {
            if (!this.aus && this.aur == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.fS("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.aur = this.auC.h(getContext(), Cf() ? 1 : 0);
                f.fS("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.aur.loadUrl(BZ());
                this.aur.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void dw(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.fS("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.auy) {
                            c.this.aus = true;
                            c.this.Cb();
                            c.this.BW();
                        }
                    }
                });
            }
        }
    }

    private boolean Cf() {
        if (com.baidu.swan.apps.console.a.d.yl() || com.baidu.swan.apps.u.a.Ew().wM()) {
            return false;
        }
        return b.ws() && new File(BX()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Cg() {
        if (!this.auu && this.aut == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.fS("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.aut = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.j.c.5
                @Override // com.baidu.swan.apps.core.c
                public void dw(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.fS("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.auu = true;
                    c.this.BW();
                }
            });
            Cm();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c aG = this.auC.aG(context);
        f.fS("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        aG.loadUrl(Ca());
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.aun);
        }
        this.aun = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.aun);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ch() {
        if (this.aun == null || !this.aun.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.dW(0));
        }
    }

    public SwanCoreVersion Ci() {
        return this.aun;
    }

    @Nullable
    public ExtensionCore Cj() {
        return this.auo;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.auo);
        }
        this.auo = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.auo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ck() {
        if (this.auo == null || !this.auo.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.CT().Cj());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.auo != null) {
            bVar.a(this.auo);
        } else {
            this.auo = bVar.Cj();
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(com.baidu.swan.apps.b.c.e eVar) {
        this.auw.put(eVar.xv(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(com.baidu.swan.apps.b.c.e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(com.baidu.swan.apps.b.c.e eVar) {
        String xv = eVar.xv();
        this.auw.remove(xv);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", xv);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.LE();
    }

    public com.baidu.swan.apps.b.c.e dY(String str) {
        if (this.auw.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.auw.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.auy) {
            if (!this.aus) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.awl)));
                }
                this.aux.add(aVar);
            } else if (this.aur != null) {
                com.baidu.swan.apps.m.a.a(this.aur.AZ(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        com.baidu.swan.apps.b.c.e eVar = this.auw.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.xt(), aVar);
    }

    @Nullable
    public String Cl() {
        Cm();
        return this.auz;
    }

    private void Cm() {
        if (TextUtils.isEmpty(this.auz)) {
            this.auz = this.aut != null ? this.aut.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.auz);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean auI = com.baidu.swan.apps.u.a.En().ws();
        private static boolean auJ = false;

        public static void D(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                auI = intent.getBooleanExtra("bundle_key_v8_ab", auI);
            }
        }

        public static void Cn() {
            auJ = auI;
        }

        public static String Co() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean ws() {
            if (c.DEBUG) {
                String Co = Co();
                char c = 65535;
                switch (Co.hashCode()) {
                    case -1406842887:
                        if (Co.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Co.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Co.equals("V8")) {
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
            return auJ;
        }
    }
}
