package com.baidu.swan.games.j;

import android.app.Activity;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import androidx.annotation.Nullable;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.event.JSEvent;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.a;
import com.baidu.swan.apps.ao.ak;
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
    private static volatile a eiu;
    private String cVu;
    private boolean cZo;
    private c eiw;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int eiv = -1;
    private final Object cZt = new Object();
    private List<InterfaceC0522a> cZm = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0522a {
        void onReady();
    }

    private a() {
    }

    public static a aWD() {
        if (eiu == null) {
            synchronized (a.class) {
                if (eiu == null) {
                    eiu = new a();
                }
            }
        }
        return eiu;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (eiu != null) {
                eiu.mIsReleased = true;
                if (eiu.eiw != null) {
                    eiu.eiw.finish();
                }
                eiu = null;
                aWD().aWG();
            }
        }
    }

    public com.baidu.swan.games.f.a aWE() {
        if (this.eiw != null) {
            return this.eiw.aWT();
        }
        return null;
    }

    public DuMixGameSurfaceView aWF() {
        if (this.eiw != null) {
            return this.eiw.aWF();
        }
        return null;
    }

    private void aWG() {
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
        if (!asq() && z(intent)) {
            boolean isSuccess = d.aZb().isSuccess();
            boolean aZc = d.aZc();
            if (isSuccess && aZc) {
                a(new InterfaceC0522a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0522a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).jk(1).aIv();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0522a interfaceC0522a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0522a != null && !this.cZm.contains(interfaceC0522a)) {
            this.cZm.add(interfaceC0522a);
        }
        if (asq()) {
            ast();
        } else {
            aWM();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        asC();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aWH() {
        if (this.eiw != null) {
            this.eiw.aWT().aVX();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.eiw != null) {
            this.eiw.aWT().dispatchEvent(jSEvent);
        }
    }

    public void S(Activity activity) {
        if (this.eiw != null) {
            this.eiw.S(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cVu = bVar.appBundlePath;
            i.qr("startup").cg("preload", asq() ? "1" : "0");
            i.qr("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0522a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0522a
                public void onReady() {
                    i.qr("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity azY;
                            if (!a.this.mIsReleased && a.this.eiw != null && (azY = f.aAo().azY()) != null && !azY.isFinishing() && azY.aga() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cVu);
                                }
                                a.this.eiw.S(azY);
                                a.this.eiw.b(bVar);
                                if (a.this.aWI()) {
                                    a.this.m(azY);
                                }
                            }
                        }
                    });
                }
            });
            if (this.eiw != null) {
                com.baidu.swan.games.network.b.d.aXF().a(this.eiw.aWT(), bVar);
            }
        }
    }

    public int aqs() {
        if (this.eiw != null) {
            return this.eiw.aqs();
        }
        return 0;
    }

    public boolean asq() {
        boolean z;
        synchronized (this.cZt) {
            z = this.cZo && this.eiw != null;
        }
        return z;
    }

    public boolean aWI() {
        DuMixGameSurfaceView aWF;
        return (this.mIsReleased || (aWF = aWF()) == null || aWF.getParent() != null) ? false : true;
    }

    public SwanCoreVersion asD() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore asE() {
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

    private void asF() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.hl(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.asE();
        }
    }

    private boolean z(Intent intent) {
        switch (aWJ()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aWJ() {
        if (this.eiv < 0) {
            this.eiv = com.baidu.swan.apps.t.a.axc().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.eiv);
        }
        return this.eiv;
    }

    public boolean aWK() {
        boolean z = com.baidu.swan.apps.t.a.axc().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f aga;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (aga = swanAppActivity.aga()) != null) {
            aga.apE().af(0, 0).apJ().f(j.apR()).apL();
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
    public void ast() {
        if (!this.mIsReleased && !this.cZm.isEmpty() && asq()) {
            for (InterfaceC0522a interfaceC0522a : this.cZm) {
                if (interfaceC0522a != null) {
                    interfaceC0522a.onReady();
                }
            }
            this.cZm.clear();
        }
    }

    private String aWL() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aWM() {
        synchronized (this.cZt) {
            if (!this.cZo && this.eiw == null) {
                asC();
                asF();
                String aWL = aWL();
                if (!TextUtils.isEmpty(aWL) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aWL);
                    }
                    this.eiw = new c(aWL, "swan-game.js");
                    this.eiw.a(new c.InterfaceC0523c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0523c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cZt) {
                                a.this.cZo = true;
                                a.this.ast();
                            }
                        }
                    });
                }
            }
        }
    }

    private void asC() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aWN());
        }
    }

    private SwanCoreVersion aWN() {
        if (com.baidu.swan.games.k.a.c.wU("package")) {
            if (TextUtils.isEmpty(this.cVu)) {
                return null;
            }
            if (!new File(this.cVu, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.jD(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cVu;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.wU("normal") || com.baidu.swan.apps.ad.a.a.aFk()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.auF().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.jD(1);
        }
    }
}
