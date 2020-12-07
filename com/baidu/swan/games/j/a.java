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
/* loaded from: classes25.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a eaB;
    private String cRw;
    private boolean cVs;
    private boolean cVv;
    private c eaD;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int eaC = -1;
    private final Object cVy = new Object();
    private List<InterfaceC0543a> cVq = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0543a {
        void onReady();
    }

    private a() {
    }

    public static a aXN() {
        if (eaB == null) {
            synchronized (a.class) {
                if (eaB == null) {
                    eaB = new a();
                }
            }
        }
        return eaB;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (eaB != null) {
                eaB.cVv = true;
                if (eaB.eaD != null) {
                    eaB.eaD.finish();
                }
                eaB = null;
                aXN().aXQ();
            }
        }
    }

    public com.baidu.swan.games.f.a aXO() {
        if (this.eaD != null) {
            return this.eaD.aYd();
        }
        return null;
    }

    public DuMixGameSurfaceView aXP() {
        if (this.eaD != null) {
            return this.eaD.aXP();
        }
        return null;
    }

    private void aXQ() {
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
        if (!auq() && y(intent)) {
            boolean isSuccess = d.bal().isSuccess();
            boolean bam = d.bam();
            if (isSuccess && bam) {
                a(new InterfaceC0543a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0543a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.t(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).kG(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0543a interfaceC0543a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0543a != null && !this.cVq.contains(interfaceC0543a)) {
            this.cVq.add(interfaceC0543a);
        }
        if (auq()) {
            aut();
        } else {
            aXW();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        auC();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aXR() {
        if (this.eaD != null) {
            this.eaD.aYd().aXh();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.eaD != null) {
            this.eaD.aYd().dispatchEvent(jSEvent);
        }
    }

    public void W(Activity activity) {
        if (this.eaD != null) {
            this.eaD.W(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cRw = bVar.appBundlePath;
            i.rk("startup").co("preload", auq() ? "1" : "0");
            i.rk("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0543a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0543a
                public void onReady() {
                    i.rk("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity aBZ;
                            if (!a.this.cVv && a.this.eaD != null && (aBZ = f.aCp().aBZ()) != null && !aBZ.isFinishing() && aBZ.aim() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cRw);
                                }
                                a.this.eaD.W(aBZ);
                                a.this.eaD.b(bVar);
                                if (a.this.aXS()) {
                                    a.this.m(aBZ);
                                }
                            }
                        }
                    });
                }
            });
            if (this.eaD != null) {
                com.baidu.swan.games.network.b.d.aYP().a(this.eaD.aYd(), bVar);
            }
        }
    }

    public int asu() {
        if (this.eaD != null) {
            return this.eaD.asu();
        }
        return 0;
    }

    public boolean auq() {
        boolean z;
        synchronized (this.cVy) {
            z = this.cVs && this.eaD != null;
        }
        return z;
    }

    public boolean aXS() {
        DuMixGameSurfaceView aXP;
        return (this.cVv || (aXP = aXP()) == null || aXP.getParent() != null) ? false : true;
    }

    public SwanCoreVersion auD() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore auE() {
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

    private void auF() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.iS(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.auE();
        }
    }

    private boolean y(Intent intent) {
        switch (aXT()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aXT() {
        if (this.eaC < 0) {
            this.eaC = com.baidu.swan.apps.t.a.azd().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.eaC);
        }
        return this.eaC;
    }

    public boolean aXU() {
        boolean z = com.baidu.swan.apps.t.a.azd().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f aim;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (aim = swanAppActivity.aim()) != null) {
            aim.arF().an(0, 0).arK().f(j.arS()).arM();
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
    public void aut() {
        if (!this.cVv && !this.cVq.isEmpty() && auq()) {
            for (InterfaceC0543a interfaceC0543a : this.cVq) {
                if (interfaceC0543a != null) {
                    interfaceC0543a.onReady();
                }
            }
            this.cVq.clear();
        }
    }

    private String aXV() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aXW() {
        synchronized (this.cVy) {
            if (!this.cVs && this.eaD == null) {
                auC();
                auF();
                String aXV = aXV();
                if (!TextUtils.isEmpty(aXV) && !this.cVv) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aXV);
                    }
                    this.eaD = new c(aXV, "swan-game.js");
                    this.eaD.a(new c.InterfaceC0544c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0544c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cVy) {
                                a.this.cVs = true;
                                a.this.aut();
                            }
                        }
                    });
                }
            }
        }
    }

    private void auC() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aXX());
        }
    }

    private SwanCoreVersion aXX() {
        if (com.baidu.swan.games.k.a.c.xG("package")) {
            if (TextUtils.isEmpty(this.cRw)) {
                return null;
            }
            if (!new File(this.cRw, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.la(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cRw;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.xG("normal") || com.baidu.swan.apps.ad.a.a.aHm()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.awF().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.la(1);
        }
    }
}
