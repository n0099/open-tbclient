package com.baidu.swan.apps.core.i;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.an.aa;
import com.baidu.swan.apps.an.y;
import com.baidu.swan.apps.b.b.p;
import com.baidu.swan.apps.b.c.e;
import com.baidu.swan.apps.b.c.i;
import com.baidu.swan.apps.console.a.d;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.install.c;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
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
    private static int atD = 10150;
    public static boolean atE = false;
    private static volatile c atp;
    private String atC;
    private p atF;
    private i atG;
    private SwanCoreVersion atq;
    @Nullable
    private ExtensionCore atr;
    private com.baidu.swan.apps.core.container.a.b ats;
    private com.baidu.swan.apps.core.f.a atu;
    private boolean atv;
    private com.baidu.swan.apps.b.c.c atw;
    private boolean atx;
    private boolean aty;
    private HashMap<String, e> atz;
    private ArrayList<a> att = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> atA = new LinkedList<>();
    private final Object atB = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.atz = new HashMap<>();
        this.atF = com.baidu.swan.apps.ae.e.Jo().aNZ.get().uP().a(this);
        this.atG = com.baidu.swan.apps.b.c.a.a.wi().wj().wg();
    }

    public static c Ab() {
        if (atp == null) {
            synchronized (c.class) {
                if (atp == null) {
                    atp = new c();
                }
            }
        }
        return atp;
    }

    public p Ac() {
        return this.atF;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (atp != null) {
            atp.aty = true;
            atE = false;
            if (atp.ats != null) {
                atp.atG.b(atp.ats);
            }
            Ad();
            h.b(atp);
            atp = null;
            Ab().Ae();
        }
    }

    private static void Ad() {
        if (atp.atz != null) {
            for (e eVar : ((HashMap) atp.atz.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (atp.atu != null) {
            if (atp.atu instanceof com.baidu.swan.apps.core.f.e) {
                atp.atu.destroy();
            }
            atp.atu = null;
        }
        if (atp.atw != null) {
            atp.atw = null;
        }
    }

    private void Ae() {
        D(null);
    }

    public void D(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Ag()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        atE = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.dJ(0);
            extensionCore = com.baidu.swan.apps.extcore.a.Bj().At();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.CU().bM(intent.getIntExtra("bundle_key_preload_switch", atD));
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
        b.Ay();
        a(new a() { // from class: com.baidu.swan.apps.core.i.c.1
            @Override // com.baidu.swan.apps.core.i.c.a
            public void onReady() {
                if (c.DEBUG) {
                    Toast.makeText(c.getContext(), a.h.aiapps_preloadCoreRuntime_end, 1).show();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Gq().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.atq != null) {
            bVar.atq = this.atq;
        } else {
            this.atq = bVar.atq;
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final c.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur mSwanCoreVersion: " + this.atq);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.atq);
        }
        d(bVar);
        e(bVar);
        f.FS().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.ER().fl("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.i.c.2
            @Override // com.baidu.swan.apps.core.i.c.a
            public void onReady() {
                f.fy("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                com.baidu.swan.apps.y.f.ER().fl("na_pre_load_ok");
                f.at("preload", "startup");
                if (c.this.atu != null && c.this.atw != null) {
                    com.baidu.swan.apps.scheme.actions.h.c.a(c.this.atu, c.this.atw, bVar, gVar);
                    c.this.atw = null;
                }
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.att.contains(aVar)) {
            this.att.add(aVar);
        }
        boolean Ag = Ag();
        f.FS().aq("preload", Ag ? "1" : "0");
        if (Ag) {
            Ah();
            return;
        }
        f.fy("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Ar();
        if (Ap()) {
            Ao();
        }
        if (this.ats == null) {
            this.ats = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.i.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void xU() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.fy("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.i.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.aty);
                            }
                            if (c.this.aty) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Ar();
                            c.this.Au();
                            if (c.this.atq != null) {
                                c.this.Ao();
                                c.this.Aq();
                                return;
                            }
                            c.this.Af();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.atG.a(this.ats);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Af() {
        synchronized (this.atB) {
            this.atv = false;
            this.atu = null;
        }
        this.atx = false;
        this.atw = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.ea(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("webview ua", this.atC);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0174a(10001).gN(com.baidu.swan.apps.ae.b.IX() == null ? "" : com.baidu.swan.apps.ae.b.IX().getAppKey()).gO(jSONObject.toString()).Kq();
    }

    public boolean Ag() {
        boolean z;
        synchronized (this.atB) {
            z = this.atv && this.atx;
        }
        return z;
    }

    public void Ah() {
        if (!this.att.isEmpty() && Ag()) {
            f.fy("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.att.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.att.clear();
        }
    }

    private String n(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.k(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String Ai() {
        return !TextUtils.isEmpty(Aj()) ? Aj() + "runtime/index.js" : "";
    }

    public String Aj() {
        return this.atq == null ? "" : this.atq.aTg + File.separator;
    }

    public String Ak() {
        String str;
        Ar();
        if (An()) {
            str = Ai();
        } else {
            str = this.atq.aTg + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.vx()) {
            n(str, false);
        } else if (d.wP()) {
            return d.wQ();
        } else {
            com.baidu.swan.apps.core.a.dB(str);
        }
        return y.hH(str);
    }

    public String Al() {
        Ar();
        String str = this.atq.aTg + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.vx()) {
            n(str, true);
        } else if (d.wP()) {
            return d.wR();
        } else {
            com.baidu.swan.apps.core.a.dB(str);
        }
        return y.hH(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Am() {
        if (!this.atA.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.atA.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.avj);
                }
                a(next);
            }
            this.atA.clear();
        }
    }

    public boolean An() {
        return this.atu instanceof com.baidu.swan.apps.core.f.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ao() {
        synchronized (this.atB) {
            if (!this.atv && this.atu == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.fy("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.atu = this.atF.i(getContext(), Ap() ? 1 : 0);
                f.fy("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.atu.loadUrl(Ak());
                this.atu.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void dD(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.fy("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.atB) {
                            c.this.atv = true;
                            c.this.Am();
                            c.this.Ah();
                        }
                    }
                });
            }
        }
    }

    private boolean Ap() {
        if (d.wP() || com.baidu.swan.apps.u.a.CK().vx()) {
            return false;
        }
        return b.vp() && new File(Ai()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq() {
        if (!this.atx && this.atw == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.fy("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.atw = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.c.5
                @Override // com.baidu.swan.apps.core.c
                public void dD(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.fy("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.atx = true;
                    c.this.Ah();
                }
            });
            Aw();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c bn = this.atF.bn(context);
        f.fy("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        bn.loadUrl(Al());
        bn.a(cVar);
        return bn;
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.atq);
        }
        this.atq = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.atq);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ar() {
        if (this.atq == null || !this.atq.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.dJ(0));
        }
    }

    public SwanCoreVersion As() {
        return this.atq;
    }

    @Nullable
    public ExtensionCore At() {
        return this.atr;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.atr);
        }
        this.atr = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.atr);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Au() {
        if (this.atr == null || !this.atr.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.Bj().At());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.atr != null) {
            bVar.atr = this.atr;
        } else {
            this.atr = bVar.atr;
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(e eVar) {
        this.atz.put(eVar.we(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(e eVar) {
        String we = eVar.we();
        this.atz.remove(we);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", we);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.IA();
    }

    public e ee(String str) {
        if (this.atz.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atz.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.atB) {
            if (!this.atv) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.avj)));
                }
                this.atA.add(aVar);
            } else if (this.atu != null) {
                com.baidu.swan.apps.m.a.a(this.atu.zs(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        e eVar = this.atz.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.wc(), aVar);
    }

    @Nullable
    public String Av() {
        Aw();
        return this.atC;
    }

    private void Aw() {
        if (TextUtils.isEmpty(this.atC)) {
            this.atC = this.atw != null ? this.atw.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.atC);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean atK = com.baidu.swan.apps.u.a.CB().vp();
        private static boolean atL = false;

        public static void E(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                atK = intent.getBooleanExtra("bundle_key_v8_ab", atK);
            }
        }

        public static void Ay() {
            atL = atK;
        }

        public static String Az() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean vp() {
            if (c.DEBUG) {
                String Az = Az();
                char c = 65535;
                switch (Az.hashCode()) {
                    case -1406842887:
                        if (Az.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Az.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Az.equals("V8")) {
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
            return false;
        }
    }
}
