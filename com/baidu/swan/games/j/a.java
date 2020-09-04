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
/* loaded from: classes8.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dsT;
    private String cjF;
    private boolean cnD;
    private boolean cnG;
    private c dsV;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int dsU = -1;
    private final Object cnJ = new Object();
    private List<InterfaceC0495a> cnB = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0495a {
        void onReady();
    }

    private a() {
    }

    public static a aNC() {
        if (dsT == null) {
            synchronized (a.class) {
                if (dsT == null) {
                    dsT = new a();
                }
            }
        }
        return dsT;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (dsT != null) {
                dsT.cnG = true;
                if (dsT.dsV != null) {
                    dsT.dsV.finish();
                }
                dsT = null;
                aNC().aNF();
            }
        }
    }

    public com.baidu.swan.games.f.a aND() {
        if (this.dsV != null) {
            return this.dsV.aNS();
        }
        return null;
    }

    public DuMixGameSurfaceView aNE() {
        if (this.dsV != null) {
            return this.dsV.aNE();
        }
        return null;
    }

    private void aNF() {
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
        if (!aka() && y(intent)) {
            boolean isSuccess = d.aQa().isSuccess();
            boolean aQb = d.aQb();
            if (isSuccess && aQb) {
                a(new InterfaceC0495a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0495a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).jj(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0495a interfaceC0495a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0495a != null && !this.cnB.contains(interfaceC0495a)) {
            this.cnB.add(interfaceC0495a);
        }
        if (aka()) {
            akd();
        } else {
            aNL();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        akm();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aNG() {
        if (this.dsV != null) {
            this.dsV.aNS().aMW();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.dsV != null) {
            this.dsV.aNS().dispatchEvent(jSEvent);
        }
    }

    public void U(Activity activity) {
        if (this.dsV != null) {
            this.dsV.U(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cjF = bVar.appBundlePath;
            i.oX("startup").bW("preload", aka() ? "1" : "0");
            i.oX("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0495a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0495a
                public void onReady() {
                    i.oX("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity arI;
                            if (!a.this.cnG && a.this.dsV != null && (arI = f.arY().arI()) != null && !arI.isFinishing() && arI.XX() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cjF);
                                }
                                a.this.dsV.U(arI);
                                a.this.dsV.b(bVar);
                                if (a.this.aNH()) {
                                    a.this.m(arI);
                                }
                            }
                        }
                    });
                }
            });
            if (this.dsV != null) {
                com.baidu.swan.games.network.b.d.aOE().a(this.dsV.aNS(), bVar);
            }
        }
    }

    public int aie() {
        if (this.dsV != null) {
            return this.dsV.aie();
        }
        return 0;
    }

    public boolean aka() {
        boolean z;
        synchronized (this.cnJ) {
            z = this.cnD && this.dsV != null;
        }
        return z;
    }

    public boolean aNH() {
        DuMixGameSurfaceView aNE;
        return (this.cnG || (aNE = aNE()) == null || aNE.getParent() != null) ? false : true;
    }

    public SwanCoreVersion akn() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore ako() {
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

    private void akp() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.hx(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.ako();
        }
    }

    private boolean y(Intent intent) {
        switch (aNI()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aNI() {
        if (this.dsU < 0) {
            this.dsU = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.dsU);
        }
        return this.dsU;
    }

    public boolean aNJ() {
        boolean z = com.baidu.swan.apps.t.a.aoM().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f XX;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (XX = swanAppActivity.XX()) != null) {
            XX.ahq().al(0, 0).ahv().f(j.ahD()).ahx();
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
    public void akd() {
        if (!this.cnG && !this.cnB.isEmpty() && aka()) {
            for (InterfaceC0495a interfaceC0495a : this.cnB) {
                if (interfaceC0495a != null) {
                    interfaceC0495a.onReady();
                }
            }
            this.cnB.clear();
        }
    }

    private String aNK() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aNL() {
        synchronized (this.cnJ) {
            if (!this.cnD && this.dsV == null) {
                akm();
                akp();
                String aNK = aNK();
                if (!TextUtils.isEmpty(aNK) && !this.cnG) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aNK);
                    }
                    this.dsV = new c(aNK, "swan-game.js");
                    this.dsV.a(new c.InterfaceC0496c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0496c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cnJ) {
                                a.this.cnD = true;
                                a.this.akd();
                            }
                        }
                    });
                }
            }
        }
    }

    private void akm() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aNM());
        }
    }

    private SwanCoreVersion aNM() {
        if (com.baidu.swan.games.k.a.c.vs("package")) {
            if (TextUtils.isEmpty(this.cjF)) {
                return null;
            }
            if (!new File(this.cjF, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.jD(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cjF;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.vs("normal") || com.baidu.swan.apps.ad.a.a.awY()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.amo().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.jD(1);
        }
    }
}
