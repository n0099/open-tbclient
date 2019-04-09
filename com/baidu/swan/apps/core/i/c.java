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
    private static int atI = 10150;
    public static boolean atJ = false;
    private static volatile c atu;
    private boolean atA;
    private com.baidu.swan.apps.b.c.c atB;
    private boolean atC;
    private boolean atD;
    private HashMap<String, e> atE;
    private String atH;
    private p atK;
    private i atL;
    private SwanCoreVersion atv;
    @Nullable
    private ExtensionCore atw;
    private com.baidu.swan.apps.core.container.a.b atx;
    private com.baidu.swan.apps.core.f.a atz;
    private ArrayList<a> aty = new ArrayList<>();
    private LinkedList<com.baidu.swan.apps.m.a.a> atF = new LinkedList<>();
    private final Object atG = new Object();

    /* loaded from: classes2.dex */
    public interface a {
        void onReady();
    }

    private c() {
        h.a(this);
        this.atE = new HashMap<>();
        this.atK = com.baidu.swan.apps.ae.e.Jm().aOd.get().uO().a(this);
        this.atL = com.baidu.swan.apps.b.c.a.a.wh().wi().wf();
    }

    public static c Aa() {
        if (atu == null) {
            synchronized (c.class) {
                if (atu == null) {
                    atu = new c();
                }
            }
        }
        return atu;
    }

    public p Ab() {
        return this.atK;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Context getContext() {
        return AppRuntime.getAppContext();
    }

    public static void release() {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "release");
        }
        if (atu != null) {
            atu.atD = true;
            atJ = false;
            if (atu.atx != null) {
                atu.atL.b(atu.atx);
            }
            Ac();
            h.b(atu);
            atu = null;
            Aa().Ad();
        }
    }

    private static void Ac() {
        if (atu.atE != null) {
            for (e eVar : ((HashMap) atu.atE.clone()).values()) {
                if (eVar != null) {
                    eVar.destroy();
                }
            }
        }
        if (atu.atz != null) {
            if (atu.atz instanceof com.baidu.swan.apps.core.f.e) {
                atu.atz.destroy();
            }
            atu.atz = null;
        }
        if (atu.atB != null) {
            atu.atB = null;
        }
    }

    private void Ad() {
        D(null);
    }

    public void D(Intent intent) {
        SwanCoreVersion swanCoreVersion;
        ExtensionCore extensionCore;
        if (Af()) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "preloadCoreRuntime runtime is ready.");
                return;
            }
            return;
        }
        atJ = true;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime start.");
        }
        if (intent == null) {
            swanCoreVersion = com.baidu.swan.apps.swancore.b.dI(0);
            extensionCore = com.baidu.swan.apps.extcore.a.Bh().As();
        } else {
            intent.setExtrasClassLoader(SwanCoreVersion.class.getClassLoader());
            swanCoreVersion = (SwanCoreVersion) intent.getParcelableExtra("bundle_key_swan_core");
            extensionCore = (ExtensionCore) intent.getParcelableExtra("bundle_key_extension_core");
            com.baidu.swan.apps.u.a.CS().bL(intent.getIntExtra("bundle_key_preload_switch", atI));
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
        b.Ax();
        a(new a() { // from class: com.baidu.swan.apps.core.i.c.1
            @Override // com.baidu.swan.apps.core.i.c.a
            public void onReady() {
                if (c.DEBUG) {
                    Toast.makeText(c.getContext(), a.h.aiapps_preloadCoreRuntime_end, 1).show();
                    Log.d("SwanAppCoreRuntime", "PrepareStatusCallback onReady.");
                }
                com.baidu.swan.apps.process.messaging.client.a.Go().sendMessage(14);
            }
        });
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "preloadCoreRuntime end.");
        }
    }

    public void d(com.baidu.swan.apps.v.b.b bVar) {
        if (this.atv != null) {
            bVar.atv = this.atv;
        } else {
            this.atv = bVar.atv;
        }
    }

    public void a(final com.baidu.swan.apps.v.b.b bVar, final c.g gVar) {
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "startFirstPage cur mSwanCoreVersion: " + this.atv);
            Log.d("SwanAppCoreRuntime", "startFirstPage launchInfo coreVersion: " + bVar.atv);
        }
        d(bVar);
        e(bVar);
        f.FQ().f(new UbcFlowEvent("na_pre_load_check"));
        com.baidu.swan.apps.y.f.EP().fm("na_pre_load_check");
        a(new a() { // from class: com.baidu.swan.apps.core.i.c.2
            @Override // com.baidu.swan.apps.core.i.c.a
            public void onReady() {
                f.fz("startup").f(new UbcFlowEvent("na_pre_load_ok"));
                com.baidu.swan.apps.y.f.EP().fm("na_pre_load_ok");
                f.at("preload", "startup");
                if (c.this.atz != null && c.this.atB != null) {
                    com.baidu.swan.apps.scheme.actions.h.c.a(c.this.atz, c.this.atB, bVar, gVar);
                    c.this.atB = null;
                }
            }
        });
    }

    public void a(a aVar) {
        if (aVar != null && !this.aty.contains(aVar)) {
            this.aty.add(aVar);
        }
        boolean Af = Af();
        f.FQ().aq("preload", Af ? "1" : "0");
        if (Af) {
            Ag();
            return;
        }
        f.fz("preload").f(new UbcFlowEvent("na_pre_load_start"));
        Aq();
        if (Ao()) {
            An();
        }
        if (this.atx == null) {
            this.atx = new com.baidu.swan.apps.core.container.a.b() { // from class: com.baidu.swan.apps.core.i.c.3
                @Override // com.baidu.swan.apps.core.container.a.b
                public void xT() {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener blink loaded.");
                    }
                    f.fz("preload").f(new UbcFlowEvent("na_pre_load_blink_init_ok"));
                    aa.runOnUiThread(new Runnable() { // from class: com.baidu.swan.apps.core.i.c.3.1
                        @Override // java.lang.Runnable
                        public void run() {
                            if (c.DEBUG) {
                                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener do prepare. isReleased: " + c.this.atD);
                            }
                            if (c.this.atD) {
                                if (c.DEBUG) {
                                    Log.d("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("runtime object is release.")));
                                    return;
                                }
                                return;
                            }
                            c.this.Aq();
                            c.this.At();
                            if (c.this.atv != null) {
                                c.this.An();
                                c.this.Ap();
                                return;
                            }
                            c.this.Ae();
                        }
                    });
                }
            };
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareRuntime addBlinkInitListener.");
            }
            this.atL.a(this.atx);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ae() {
        synchronized (this.atG) {
            this.atA = false;
            this.atz = null;
        }
        this.atC = false;
        this.atB = null;
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("swanjs version", com.baidu.swan.apps.swancore.e.a.dZ(0));
            jSONObject.put("system model", Build.MODEL);
            jSONObject.put("webview ua", this.atH);
        } catch (JSONException e) {
            if (DEBUG) {
                e.printStackTrace();
            }
        }
        new a.C0174a(10001).gO(com.baidu.swan.apps.ae.b.IV() == null ? "" : com.baidu.swan.apps.ae.b.IV().getAppKey()).gP(jSONObject.toString()).Ko();
    }

    public boolean Af() {
        boolean z;
        synchronized (this.atG) {
            z = this.atA && this.atC;
        }
        return z;
    }

    public void Ag() {
        if (!this.aty.isEmpty() && Af()) {
            f.fz("preload").f(new UbcFlowEvent("na_pre_load_end"));
            Iterator<a> it = this.aty.iterator();
            while (it.hasNext()) {
                a next = it.next();
                if (next != null) {
                    next.onReady();
                }
            }
            this.aty.clear();
        }
    }

    private String n(String str, boolean z) {
        String str2 = z ? "slave" : "master";
        if (!TextUtils.isEmpty(str)) {
            com.baidu.swan.apps.core.a.k(str, "<title>", "        <script type=\"text/javascript\" src=\"file:///sdcard/socket.io.js\"></script>\n        <script type=\"text/javascript\" src=\"file:///sdcard/" + str2 + "_socket.js\"></script>");
        }
        return str;
    }

    private String Ah() {
        return !TextUtils.isEmpty(Ai()) ? Ai() + "runtime/index.js" : "";
    }

    public String Ai() {
        return this.atv == null ? "" : this.atv.aTk + File.separator;
    }

    public String Aj() {
        String str;
        Aq();
        if (Am()) {
            str = Ah();
        } else {
            str = this.atv.aTk + File.separator + "master/master.html";
        }
        if (com.baidu.swan.apps.core.a.vw()) {
            n(str, false);
        } else if (d.wO()) {
            return d.wP();
        } else {
            com.baidu.swan.apps.core.a.dD(str);
        }
        return y.hI(str);
    }

    public String Ak() {
        Aq();
        String str = this.atv.aTk + File.separator + "slaves/slaves.html";
        if (com.baidu.swan.apps.core.a.vw()) {
            n(str, true);
        } else if (d.wO()) {
            return d.wQ();
        } else {
            com.baidu.swan.apps.core.a.dD(str);
        }
        return y.hI(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Al() {
        if (!this.atF.isEmpty()) {
            Iterator<com.baidu.swan.apps.m.a.a> it = this.atF.iterator();
            while (it.hasNext()) {
                com.baidu.swan.apps.m.a.a next = it.next();
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "dispatchPendingEvents event: " + next.avn);
                }
                a(next);
            }
            this.atF.clear();
        }
    }

    public boolean Am() {
        return this.atz instanceof com.baidu.swan.apps.core.f.e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void An() {
        synchronized (this.atG) {
            if (!this.atA && this.atz == null) {
                if (DEBUG) {
                    Log.d("SwanAppCoreRuntime", "prepareMaster start.");
                }
                f.fz("preload").f(new UbcFlowEvent("na_pre_load_master_start"));
                this.atz = this.atK.i(getContext(), Ao() ? 1 : 0);
                f.fz("preload").f(new UbcFlowEvent("na_pre_load_master_created"));
                this.atz.loadUrl(Aj());
                this.atz.a(new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.c.4
                    @Override // com.baidu.swan.apps.core.c
                    public void dF(String str) {
                        if (c.DEBUG) {
                            Log.d("SwanAppCoreRuntime", "prepareMaster finish. url: " + str);
                        }
                        f.fz("preload").f(new UbcFlowEvent("na_pre_load_master_ok"));
                        synchronized (c.this.atG) {
                            c.this.atA = true;
                            c.this.Al();
                            c.this.Ag();
                        }
                    }
                });
            }
        }
    }

    private boolean Ao() {
        if (d.wO() || com.baidu.swan.apps.u.a.CI().vw()) {
            return false;
        }
        return b.vo() && new File(Ah()).exists();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ap() {
        if (!this.atC && this.atB == null) {
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "prepareSlave start.");
            }
            f.fz("preload").f(new UbcFlowEvent("na_pre_load_slave_start"));
            this.atB = a(getContext(), new com.baidu.swan.apps.core.c() { // from class: com.baidu.swan.apps.core.i.c.5
                @Override // com.baidu.swan.apps.core.c
                public void dF(String str) {
                    if (c.DEBUG) {
                        Log.d("SwanAppCoreRuntime", "prepareSlave finish. url: " + str);
                    }
                    f.fz("preload").f(new UbcFlowEvent("na_pre_load_slave_ok"));
                    c.this.atC = true;
                    c.this.Ag();
                }
            });
            Av();
        }
    }

    public com.baidu.swan.apps.b.c.c a(Context context, com.baidu.swan.apps.core.c cVar) {
        com.baidu.swan.apps.b.c.c bn = this.atK.bn(context);
        f.fz("preload").f(new UbcFlowEvent("na_pre_load_slave_created"));
        bn.loadUrl(Ak());
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
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion before. swan core: " + this.atv);
        }
        this.atv = swanCoreVersion;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setSwanCoreVersion after. swan core: " + this.atv);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Aq() {
        if (this.atv == null || !this.atv.isAvailable()) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("mSwanCoreVersion is invalid.")));
            }
            a(com.baidu.swan.apps.swancore.b.dI(0));
        }
    }

    public SwanCoreVersion Ar() {
        return this.atv;
    }

    @Nullable
    public ExtensionCore As() {
        return this.atw;
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
            Log.d("SwanAppCoreRuntime", "setExtensionCore before. extension core: " + this.atw);
        }
        this.atw = extensionCore;
        if (DEBUG) {
            Log.d("SwanAppCoreRuntime", "setExtensionCore after. extension core: " + this.atw);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void At() {
        if (this.atw == null || !this.atw.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanAppCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.a.Bh().As());
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        if (this.atw != null) {
            bVar.atw = this.atw;
        } else {
            this.atw = bVar.atw;
        }
    }

    @Override // com.baidu.swan.apps.w.g
    public void a(e eVar) {
        this.atE.put(eVar.wd(), eVar);
    }

    @Override // com.baidu.swan.apps.w.g
    public void b(e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void c(e eVar) {
    }

    @Override // com.baidu.swan.apps.w.g
    public void d(e eVar) {
        String wd = eVar.wd();
        this.atE.remove(wd);
        if (eVar instanceof com.baidu.swan.apps.b.c.c) {
            HashMap hashMap = new HashMap();
            hashMap.put("lcType", "onUnload");
            hashMap.put("wvID", wd);
            a(new com.baidu.swan.apps.m.a.c(hashMap));
            com.baidu.swan.apps.console.c.d("SwanApp", "onUnload");
        }
        com.baidu.swan.apps.res.widget.loadingview.a.Iy();
    }

    public e eg(String str) {
        if (this.atE.isEmpty() || TextUtils.isEmpty(str)) {
            return null;
        }
        return this.atE.get(str);
    }

    public void a(com.baidu.swan.apps.m.a.a aVar) {
        if (aVar == null) {
            throw new IllegalArgumentException("message must be non-null.");
        }
        synchronized (this.atG) {
            if (!this.atA) {
                if (DEBUG) {
                    Log.e("SwanAppCoreRuntime", Log.getStackTraceString(new Exception("message:" + aVar.avn)));
                }
                this.atF.add(aVar);
            } else if (this.atz != null) {
                com.baidu.swan.apps.m.a.a(this.atz.zr(), aVar);
            }
        }
    }

    public void a(String str, com.baidu.swan.apps.m.a.a aVar) {
        if (TextUtils.equals(str, "master")) {
            a(aVar);
            return;
        }
        e eVar = this.atE.get(str);
        if (eVar == null) {
            if (DEBUG) {
                Log.e("SwanAppCoreRuntime", "can't find view manager. webviewId: " + str + " message: " + aVar);
                return;
            }
            return;
        }
        com.baidu.swan.apps.m.a.a(eVar.wb(), aVar);
    }

    @Nullable
    public String Au() {
        Av();
        return this.atH;
    }

    private void Av() {
        if (TextUtils.isEmpty(this.atH)) {
            this.atH = this.atB != null ? this.atB.getUserAgent() : "";
            if (DEBUG) {
                Log.d("SwanAppCoreRuntime", "initWebViewUa ua: " + this.atH);
            }
        }
    }

    /* loaded from: classes2.dex */
    public static class b {
        private static boolean atP = com.baidu.swan.apps.u.a.Cz().vo();
        private static boolean atQ = false;

        public static void E(Intent intent) {
            if (intent != null && intent.hasExtra("bundle_key_v8_ab")) {
                atP = intent.getBooleanExtra("bundle_key_v8_ab", atP);
            }
        }

        public static void Ax() {
            atQ = atP;
        }

        public static String Ay() {
            return PreferenceManager.getDefaultSharedPreferences(AppRuntime.getAppContext()).getString("aiapps_v8_master_switch", "AB");
        }

        public static boolean vo() {
            if (c.DEBUG) {
                String Ay = Ay();
                char c = 65535;
                switch (Ay.hashCode()) {
                    case -1406842887:
                        if (Ay.equals("WebView")) {
                            c = 1;
                            break;
                        }
                        break;
                    case 2081:
                        if (Ay.equals("AB")) {
                            c = 2;
                            break;
                        }
                        break;
                    case 2722:
                        if (Ay.equals("V8")) {
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
