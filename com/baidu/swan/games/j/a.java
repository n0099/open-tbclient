package com.baidu.swan.games.j;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.j.c;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.utils.so.d;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dcX;
    private String cbY;
    private boolean cfB;
    private boolean cfy;
    private c dcZ;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int dcY = -1;
    private final Object cfF = new Object();
    private List<InterfaceC0434a> cfw = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0434a {
        void onReady();
    }

    private a() {
    }

    public static a aBj() {
        if (dcX == null) {
            synchronized (a.class) {
                if (dcX == null) {
                    dcX = new a();
                }
            }
        }
        return dcX;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (dcX != null) {
                dcX.cfB = true;
                if (dcX.dcZ != null) {
                    dcX.dcZ.finish();
                }
                dcX = null;
                aBj().acu();
            }
        }
    }

    public com.baidu.swan.games.f.a aBk() {
        if (this.dcZ != null) {
            return this.dcZ.aBw();
        }
        return null;
    }

    public DuMixGameSurfaceView aBl() {
        if (this.dcZ != null) {
            return this.dcZ.aBl();
        }
        return null;
    }

    private void acu() {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
        }
        p(null);
    }

    public void p(Intent intent) {
        if (DEBUG) {
            String str = null;
            if (intent != null) {
                str = intent.getStringExtra("bundle_key_preload_preload_scene");
            }
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + str);
        }
        if (!acx() && w(intent)) {
            boolean aDu = d.aDu();
            boolean aDv = d.aDv();
            if (aDu && aDv) {
                a(new InterfaceC0434a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0434a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).gT(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0434a interfaceC0434a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0434a != null && !this.cfw.contains(interfaceC0434a)) {
            this.cfw.add(interfaceC0434a);
        }
        if (acx()) {
            acA();
        } else {
            acI();
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        acL();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aBm() {
        if (this.dcZ != null) {
            this.dcZ.aBw().aAC();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.dcZ != null) {
            this.dcZ.aBw().dispatchEvent(jSEvent);
        }
    }

    public void U(Activity activity) {
        if (this.dcZ != null) {
            this.dcZ.U(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cbY = bVar.appBundlePath;
            g.mx("startup").bF("preload", acx() ? "1" : "0");
            g.mx("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0434a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0434a
                public void onReady() {
                    g.mx("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity aiL;
                            if (!a.this.cfB && a.this.dcZ != null && (aiL = f.ajb().aiL()) != null && !aiL.isFinishing() && aiL.RN() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cbY);
                                }
                                a.this.dcZ.U(aiL);
                                a.this.dcZ.b(bVar);
                                if (a.this.aBn()) {
                                    a.this.l(aiL);
                                }
                            }
                        }
                    });
                }
            });
            if (this.dcZ != null) {
                com.baidu.swan.games.network.b.d.aCg().a(this.dcZ.aBw(), bVar);
            }
        }
    }

    public int aaP() {
        if (this.dcZ != null) {
            return this.dcZ.aaP();
        }
        return 0;
    }

    public boolean acx() {
        boolean z;
        synchronized (this.cfF) {
            z = this.cfy && this.dcZ != null;
        }
        return z;
    }

    public boolean aBn() {
        DuMixGameSurfaceView aBl;
        return (this.cfB || (aBl = aBl()) == null || aBl.getParent() != null) ? false : true;
    }

    public SwanCoreVersion acM() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore acN() {
        return this.mExtensionCore;
    }

    public void a(ExtensionCore extensionCore) {
        if (extensionCore == null || !extensionCore.isAvailable()) {
            if (DEBUG) {
                StringBuilder append = new StringBuilder().append("setExtensionCore invalid: ");
                Object obj = extensionCore;
                if (extensionCore == null) {
                    obj = " null";
                }
                Log.w("SwanGameCoreRuntime", append.append(obj).toString());
                return;
            }
            return;
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "setExtensionCore: " + this.mExtensionCore);
        }
        this.mExtensionCore = extensionCore;
    }

    private void acO() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.fr(1));
        }
    }

    public void f(com.baidu.swan.apps.v.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.acN();
        }
    }

    private boolean w(Intent intent) {
        switch (aBo()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aBo() {
        if (this.dcY < 0) {
            this.dcY = com.baidu.swan.apps.u.a.aga().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.dcY);
        }
        return this.dcY;
    }

    public boolean aBp() {
        boolean z = com.baidu.swan.apps.u.a.aga().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e RN;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (RN = swanAppActivity.RN()) != null) {
            RN.ZZ().ag(0, 0).aaf().f(i.aap()).aah();
        }
    }

    private void a(SwanCoreVersion swanCoreVersion) {
        if (swanCoreVersion != null && swanCoreVersion.isAvailable()) {
            this.mSwanCoreVersion = swanCoreVersion;
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "setSwanCoreVersion: " + this.mSwanCoreVersion);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void acA() {
        if (!this.cfB && !this.cfw.isEmpty() && acx()) {
            for (InterfaceC0434a interfaceC0434a : this.cfw) {
                if (interfaceC0434a != null) {
                    interfaceC0434a.onReady();
                }
            }
            this.cfw.clear();
        }
    }

    private String aBq() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void acI() {
        synchronized (this.cfF) {
            if (!this.cfy && this.dcZ == null) {
                acL();
                acO();
                String aBq = aBq();
                if (!TextUtils.isEmpty(aBq) && !this.cfB) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aBq);
                    }
                    this.dcZ = new c(aBq, "swan-game.js");
                    this.dcZ.a(new c.InterfaceC0435c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0435c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cfF) {
                                a.this.cfy = true;
                                a.this.acA();
                            }
                        }
                    });
                }
            }
        }
    }

    private void acL() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aBr());
        }
    }

    private SwanCoreVersion aBr() {
        if (com.baidu.swan.games.k.a.c.sc("package")) {
            if (TextUtils.isEmpty(this.cbY)) {
                return null;
            }
            if (!new File(this.cbY, "swan-game.js").exists()) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.hn(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cbY;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.sc("normal") || com.baidu.swan.apps.af.a.a.ans()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.adQ().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.hn(1);
        }
    }
}
