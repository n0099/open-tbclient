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
    private static volatile a eeL;
    private String cRH;
    private boolean cVC;
    private c eeN;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int eeM = -1;
    private final Object cVH = new Object();
    private List<InterfaceC0519a> cVA = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0519a {
        void onReady();
    }

    private a() {
    }

    public static a aWo() {
        if (eeL == null) {
            synchronized (a.class) {
                if (eeL == null) {
                    eeL = new a();
                }
            }
        }
        return eeL;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (eeL != null) {
                eeL.mIsReleased = true;
                if (eeL.eeN != null) {
                    eeL.eeN.finish();
                }
                eeL = null;
                aWo().aWr();
            }
        }
    }

    public com.baidu.swan.games.f.a aWp() {
        if (this.eeN != null) {
            return this.eeN.aWE();
        }
        return null;
    }

    public DuMixGameSurfaceView aWq() {
        if (this.eeN != null) {
            return this.eeN.aWq();
        }
        return null;
    }

    private void aWr() {
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
        if (!arO() && z(intent)) {
            boolean isSuccess = d.aYM().isSuccess();
            boolean aYN = d.aYN();
            if (isSuccess && aYN) {
                a(new InterfaceC0519a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0519a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).jg(1).aHZ();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0519a interfaceC0519a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0519a != null && !this.cVA.contains(interfaceC0519a)) {
            this.cVA.add(interfaceC0519a);
        }
        if (arO()) {
            arR();
        } else {
            aWx();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        asa();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aWs() {
        if (this.eeN != null) {
            this.eeN.aWE().aVI();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.eeN != null) {
            this.eeN.aWE().dispatchEvent(jSEvent);
        }
    }

    public void Y(Activity activity) {
        if (this.eeN != null) {
            this.eeN.Y(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cRH = bVar.appBundlePath;
            i.pS("startup").cm("preload", arO() ? "1" : "0");
            i.pS("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0519a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0519a
                public void onReady() {
                    i.pS("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity azx;
                            if (!a.this.mIsReleased && a.this.eeN != null && (azx = f.azN().azx()) != null && !azx.isFinishing() && azx.afz() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cRH);
                                }
                                a.this.eeN.Y(azx);
                                a.this.eeN.b(bVar);
                                if (a.this.aWt()) {
                                    a.this.m(azx);
                                }
                            }
                        }
                    });
                }
            });
            if (this.eeN != null) {
                com.baidu.swan.games.network.b.d.aXq().a(this.eeN.aWE(), bVar);
            }
        }
    }

    public int apR() {
        if (this.eeN != null) {
            return this.eeN.apR();
        }
        return 0;
    }

    public boolean arO() {
        boolean z;
        synchronized (this.cVH) {
            z = this.cVC && this.eeN != null;
        }
        return z;
    }

    public boolean aWt() {
        DuMixGameSurfaceView aWq;
        return (this.mIsReleased || (aWq = aWq()) == null || aWq.getParent() != null) ? false : true;
    }

    public SwanCoreVersion asb() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore asc() {
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

    private void asd() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.hh(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.asc();
        }
    }

    private boolean z(Intent intent) {
        switch (aWu()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aWu() {
        if (this.eeM < 0) {
            this.eeM = com.baidu.swan.apps.t.a.awB().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.eeM);
        }
        return this.eeM;
    }

    public boolean aWv() {
        boolean z = com.baidu.swan.apps.t.a.awB().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afz;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (afz = swanAppActivity.afz()) != null) {
            afz.apc().ai(0, 0).aph().f(j.apq()).apk();
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
    public void arR() {
        if (!this.mIsReleased && !this.cVA.isEmpty() && arO()) {
            for (InterfaceC0519a interfaceC0519a : this.cVA) {
                if (interfaceC0519a != null) {
                    interfaceC0519a.onReady();
                }
            }
            this.cVA.clear();
        }
    }

    private String aWw() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aWx() {
        synchronized (this.cVH) {
            if (!this.cVC && this.eeN == null) {
                asa();
                asd();
                String aWw = aWw();
                if (!TextUtils.isEmpty(aWw) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aWw);
                    }
                    this.eeN = new c(aWw, "swan-game.js");
                    this.eeN.a(new c.InterfaceC0520c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0520c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cVH) {
                                a.this.cVC = true;
                                a.this.arR();
                            }
                        }
                    });
                }
            }
        }
    }

    private void asa() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aWy());
        }
    }

    private SwanCoreVersion aWy() {
        if (com.baidu.swan.games.k.a.c.wu("package")) {
            if (TextUtils.isEmpty(this.cRH)) {
                return null;
            }
            if (!new File(this.cRH, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.jz(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cRH;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.wu("normal") || com.baidu.swan.apps.ad.a.a.aEM()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.aue().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.jz(1);
        }
    }
}
