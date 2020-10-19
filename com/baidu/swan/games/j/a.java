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
    private static volatile a dGW;
    private boolean cBU;
    private boolean cBX;
    private String cxY;
    private c dGY;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int dGX = -1;
    private final Object cCa = new Object();
    private List<InterfaceC0507a> cBS = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0507a {
        void onReady();
    }

    private a() {
    }

    public static a aQW() {
        if (dGW == null) {
            synchronized (a.class) {
                if (dGW == null) {
                    dGW = new a();
                }
            }
        }
        return dGW;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (dGW != null) {
                dGW.cBX = true;
                if (dGW.dGY != null) {
                    dGW.dGY.finish();
                }
                dGW = null;
                aQW().aQZ();
            }
        }
    }

    public com.baidu.swan.games.f.a aQX() {
        if (this.dGY != null) {
            return this.dGY.aRm();
        }
        return null;
    }

    public DuMixGameSurfaceView aQY() {
        if (this.dGY != null) {
            return this.dGY.aQY();
        }
        return null;
    }

    private void aQZ() {
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
        if (!anv() && y(intent)) {
            boolean isSuccess = d.aTu().isSuccess();
            boolean aTv = d.aTv();
            if (isSuccess && aTv) {
                a(new InterfaceC0507a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0507a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).jR(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0507a interfaceC0507a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0507a != null && !this.cBS.contains(interfaceC0507a)) {
            this.cBS.add(interfaceC0507a);
        }
        if (anv()) {
            any();
        } else {
            aRf();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        anH();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aRa() {
        if (this.dGY != null) {
            this.dGY.aRm().aQq();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.dGY != null) {
            this.dGY.aRm().dispatchEvent(jSEvent);
        }
    }

    public void X(Activity activity) {
        if (this.dGY != null) {
            this.dGY.X(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cxY = bVar.appBundlePath;
            i.qc("startup").cb("preload", anv() ? "1" : "0");
            i.qc("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0507a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0507a
                public void onReady() {
                    i.qc("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity ave;
                            if (!a.this.cBX && a.this.dGY != null && (ave = f.avu().ave()) != null && !ave.isFinishing() && ave.abs() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cxY);
                                }
                                a.this.dGY.X(ave);
                                a.this.dGY.b(bVar);
                                if (a.this.aRb()) {
                                    a.this.m(ave);
                                }
                            }
                        }
                    });
                }
            });
            if (this.dGY != null) {
                com.baidu.swan.games.network.b.d.aRY().a(this.dGY.aRm(), bVar);
            }
        }
    }

    public int alz() {
        if (this.dGY != null) {
            return this.dGY.alz();
        }
        return 0;
    }

    public boolean anv() {
        boolean z;
        synchronized (this.cCa) {
            z = this.cBU && this.dGY != null;
        }
        return z;
    }

    public boolean aRb() {
        DuMixGameSurfaceView aQY;
        return (this.cBX || (aQY = aQY()) == null || aQY.getParent() != null) ? false : true;
    }

    public SwanCoreVersion anI() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore anJ() {
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

    private void anK() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.id(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.anJ();
        }
    }

    private boolean y(Intent intent) {
        switch (aRc()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aRc() {
        if (this.dGX < 0) {
            this.dGX = com.baidu.swan.apps.t.a.asi().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.dGX);
        }
        return this.dGX;
    }

    public boolean aRd() {
        boolean z = com.baidu.swan.apps.t.a.asi().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f abs;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (abs = swanAppActivity.abs()) != null) {
            abs.akL().ak(0, 0).akQ().f(j.akY()).akS();
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
    public void any() {
        if (!this.cBX && !this.cBS.isEmpty() && anv()) {
            for (InterfaceC0507a interfaceC0507a : this.cBS) {
                if (interfaceC0507a != null) {
                    interfaceC0507a.onReady();
                }
            }
            this.cBS.clear();
        }
    }

    private String aRe() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aRf() {
        synchronized (this.cCa) {
            if (!this.cBU && this.dGY == null) {
                anH();
                anK();
                String aRe = aRe();
                if (!TextUtils.isEmpty(aRe) && !this.cBX) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aRe);
                    }
                    this.dGY = new c(aRe, "swan-game.js");
                    this.dGY.a(new c.InterfaceC0508c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0508c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cCa) {
                                a.this.cBU = true;
                                a.this.any();
                            }
                        }
                    });
                }
            }
        }
    }

    private void anH() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aRg());
        }
    }

    private SwanCoreVersion aRg() {
        if (com.baidu.swan.games.k.a.c.wx("package")) {
            if (TextUtils.isEmpty(this.cxY)) {
                return null;
            }
            if (!new File(this.cxY, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.kl(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cxY;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.wx("normal") || com.baidu.swan.apps.ad.a.a.aAs()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.apK().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.kl(1);
        }
    }
}
