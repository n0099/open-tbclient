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
/* loaded from: classes3.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a duV;
    private String clG;
    private boolean cpG;
    private boolean cpJ;
    private c duX;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int duW = -1;
    private final Object cpM = new Object();
    private List<InterfaceC0490a> cpE = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0490a {
        void onReady();
    }

    private a() {
    }

    public static a aOn() {
        if (duV == null) {
            synchronized (a.class) {
                if (duV == null) {
                    duV = new a();
                }
            }
        }
        return duV;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (duV != null) {
                duV.cpJ = true;
                if (duV.duX != null) {
                    duV.duX.finish();
                }
                duV = null;
                aOn().aOq();
            }
        }
    }

    public com.baidu.swan.games.f.a aOo() {
        if (this.duX != null) {
            return this.duX.aOD();
        }
        return null;
    }

    public DuMixGameSurfaceView aOp() {
        if (this.duX != null) {
            return this.duX.aOp();
        }
        return null;
    }

    private void aOq() {
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
        if (!akK() && y(intent)) {
            boolean isSuccess = d.aQL().isSuccess();
            boolean aQM = d.aQM();
            if (isSuccess && aQM) {
                a(new InterfaceC0490a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0490a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).ju(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0490a interfaceC0490a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0490a != null && !this.cpE.contains(interfaceC0490a)) {
            this.cpE.add(interfaceC0490a);
        }
        if (akK()) {
            akN();
        } else {
            aOw();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        akW();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aOr() {
        if (this.duX != null) {
            this.duX.aOD().aNH();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.duX != null) {
            this.duX.aOD().dispatchEvent(jSEvent);
        }
    }

    public void W(Activity activity) {
        if (this.duX != null) {
            this.duX.W(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.clG = bVar.appBundlePath;
            i.pq("startup").bW("preload", akK() ? "1" : "0");
            i.pq("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0490a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0490a
                public void onReady() {
                    i.pq("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity ast;
                            if (!a.this.cpJ && a.this.duX != null && (ast = f.asJ().ast()) != null && !ast.isFinishing() && ast.YG() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.clG);
                                }
                                a.this.duX.W(ast);
                                a.this.duX.b(bVar);
                                if (a.this.aOs()) {
                                    a.this.m(ast);
                                }
                            }
                        }
                    });
                }
            });
            if (this.duX != null) {
                com.baidu.swan.games.network.b.d.aPp().a(this.duX.aOD(), bVar);
            }
        }
    }

    public int aiO() {
        if (this.duX != null) {
            return this.duX.aiO();
        }
        return 0;
    }

    public boolean akK() {
        boolean z;
        synchronized (this.cpM) {
            z = this.cpG && this.duX != null;
        }
        return z;
    }

    public boolean aOs() {
        DuMixGameSurfaceView aOp;
        return (this.cpJ || (aOp = aOp()) == null || aOp.getParent() != null) ? false : true;
    }

    public SwanCoreVersion akX() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore akY() {
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

    private void akZ() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.hG(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.akY();
        }
    }

    private boolean y(Intent intent) {
        switch (aOt()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aOt() {
        if (this.duW < 0) {
            this.duW = com.baidu.swan.apps.t.a.apx().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.duW);
        }
        return this.duW;
    }

    public boolean aOu() {
        boolean z = com.baidu.swan.apps.t.a.apx().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f YG;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (YG = swanAppActivity.YG()) != null) {
            YG.aia().al(0, 0).aif().f(j.ain()).aih();
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
    public void akN() {
        if (!this.cpJ && !this.cpE.isEmpty() && akK()) {
            for (InterfaceC0490a interfaceC0490a : this.cpE) {
                if (interfaceC0490a != null) {
                    interfaceC0490a.onReady();
                }
            }
            this.cpE.clear();
        }
    }

    private String aOv() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aOw() {
        synchronized (this.cpM) {
            if (!this.cpG && this.duX == null) {
                akW();
                akZ();
                String aOv = aOv();
                if (!TextUtils.isEmpty(aOv) && !this.cpJ) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aOv);
                    }
                    this.duX = new c(aOv, "swan-game.js");
                    this.duX.a(new c.InterfaceC0491c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0491c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cpM) {
                                a.this.cpG = true;
                                a.this.akN();
                            }
                        }
                    });
                }
            }
        }
    }

    private void akW() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aOx());
        }
    }

    private SwanCoreVersion aOx() {
        if (com.baidu.swan.games.k.a.c.vL("package")) {
            if (TextUtils.isEmpty(this.clG)) {
                return null;
            }
            if (!new File(this.clG, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.jO(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.clG;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.vL("normal") || com.baidu.swan.apps.ad.a.a.axH()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.amY().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.jO(1);
        }
    }
}
