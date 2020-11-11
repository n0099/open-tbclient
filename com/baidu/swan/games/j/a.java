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
import com.baidu.swan.apps.ap.ak;
import com.baidu.swan.apps.core.d.j;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.v.f;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.j.c;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.utils.so.d;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dVl;
    private String cMn;
    private boolean cQj;
    private boolean cQm;
    private c dVn;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int dVm = -1;
    private final Object cQp = new Object();
    private List<InterfaceC0533a> cQh = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0533a {
        void onReady();
    }

    private a() {
    }

    public static a aVq() {
        if (dVl == null) {
            synchronized (a.class) {
                if (dVl == null) {
                    dVl = new a();
                }
            }
        }
        return dVl;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (dVl != null) {
                dVl.cQm = true;
                if (dVl.dVn != null) {
                    dVl.dVn.finish();
                }
                dVl = null;
                aVq().aVt();
            }
        }
    }

    public com.baidu.swan.games.f.a aVr() {
        if (this.dVn != null) {
            return this.dVn.aVG();
        }
        return null;
    }

    public DuMixGameSurfaceView aVs() {
        if (this.dVn != null) {
            return this.dVn.aVs();
        }
        return null;
    }

    private void aVt() {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
        }
        r(null);
    }

    public void r(Intent intent) {
        if (DEBUG) {
            String str = null;
            if (intent != null) {
                str = intent.getStringExtra("bundle_key_preload_preload_scene");
            }
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + str);
        }
        if (!arQ() && y(intent)) {
            boolean isSuccess = d.aXO().isSuccess();
            boolean aXP = d.aXP();
            if (isSuccess && aXP) {
                a(new InterfaceC0533a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0533a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).km(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0533a interfaceC0533a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0533a != null && !this.cQh.contains(interfaceC0533a)) {
            this.cQh.add(interfaceC0533a);
        }
        if (arQ()) {
            arT();
        } else {
            aVz();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        asc();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aVu() {
        if (this.dVn != null) {
            this.dVn.aVG().aUK();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.dVn != null) {
            this.dVn.aVG().dispatchEvent(jSEvent);
        }
    }

    public void X(Activity activity) {
        if (this.dVn != null) {
            this.dVn.X(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cMn = bVar.appBundlePath;
            i.qJ("startup").ci("preload", arQ() ? "1" : "0");
            i.qJ("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0533a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0533a
                public void onReady() {
                    i.qJ("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity azy;
                            if (!a.this.cQm && a.this.dVn != null && (azy = f.azO().azy()) != null && !azy.isFinishing() && azy.afM() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cMn);
                                }
                                a.this.dVn.X(azy);
                                a.this.dVn.b(bVar);
                                if (a.this.aVv()) {
                                    a.this.m(azy);
                                }
                            }
                        }
                    });
                }
            });
            if (this.dVn != null) {
                com.baidu.swan.games.network.b.d.aWs().a(this.dVn.aVG(), bVar);
            }
        }
    }

    public int apU() {
        if (this.dVn != null) {
            return this.dVn.apU();
        }
        return 0;
    }

    public boolean arQ() {
        boolean z;
        synchronized (this.cQp) {
            z = this.cQj && this.dVn != null;
        }
        return z;
    }

    public boolean aVv() {
        DuMixGameSurfaceView aVs;
        return (this.cQm || (aVs = aVs()) == null || aVs.getParent() != null) ? false : true;
    }

    public SwanCoreVersion asd() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore ase() {
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

    private void asf() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.iy(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.ase();
        }
    }

    private boolean y(Intent intent) {
        switch (aVw()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aVw() {
        if (this.dVm < 0) {
            this.dVm = com.baidu.swan.apps.t.a.awD().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.dVm);
        }
        return this.dVm;
    }

    public boolean aVx() {
        boolean z = com.baidu.swan.apps.t.a.awD().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afM;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (afM = swanAppActivity.afM()) != null) {
            afM.apf().al(0, 0).apl().f(j.apt()).apn();
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
    public void arT() {
        if (!this.cQm && !this.cQh.isEmpty() && arQ()) {
            for (InterfaceC0533a interfaceC0533a : this.cQh) {
                if (interfaceC0533a != null) {
                    interfaceC0533a.onReady();
                }
            }
            this.cQh.clear();
        }
    }

    private String aVy() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aVz() {
        synchronized (this.cQp) {
            if (!this.cQj && this.dVn == null) {
                asc();
                asf();
                String aVy = aVy();
                if (!TextUtils.isEmpty(aVy) && !this.cQm) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aVy);
                    }
                    this.dVn = new c(aVy, "swan-game.js");
                    this.dVn.a(new c.InterfaceC0534c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0534c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cQp) {
                                a.this.cQj = true;
                                a.this.arT();
                            }
                        }
                    });
                }
            }
        }
    }

    private void asc() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aVA());
        }
    }

    private SwanCoreVersion aVA() {
        if (com.baidu.swan.games.k.a.c.xe("package")) {
            if (TextUtils.isEmpty(this.cMn)) {
                return null;
            }
            if (!new File(this.cMn, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.kG(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cMn;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.xe("normal") || com.baidu.swan.apps.ad.a.a.aEM()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.auf().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.kG(1);
        }
    }
}
