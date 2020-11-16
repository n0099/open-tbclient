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
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dTD;
    private String cKD;
    private boolean cOC;
    private boolean cOz;
    private c dTF;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int dTE = -1;
    private final Object cOF = new Object();
    private List<InterfaceC0531a> cOx = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0531a {
        void onReady();
    }

    private a() {
    }

    public static a aUI() {
        if (dTD == null) {
            synchronized (a.class) {
                if (dTD == null) {
                    dTD = new a();
                }
            }
        }
        return dTD;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (dTD != null) {
                dTD.cOC = true;
                if (dTD.dTF != null) {
                    dTD.dTF.finish();
                }
                dTD = null;
                aUI().aUL();
            }
        }
    }

    public com.baidu.swan.games.f.a aUJ() {
        if (this.dTF != null) {
            return this.dTF.aUY();
        }
        return null;
    }

    public DuMixGameSurfaceView aUK() {
        if (this.dTF != null) {
            return this.dTF.aUK();
        }
        return null;
    }

    private void aUL() {
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
        if (!ari() && y(intent)) {
            boolean isSuccess = d.aXg().isSuccess();
            boolean aXh = d.aXh();
            if (isSuccess && aXh) {
                a(new InterfaceC0531a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0531a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).ki(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0531a interfaceC0531a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0531a != null && !this.cOx.contains(interfaceC0531a)) {
            this.cOx.add(interfaceC0531a);
        }
        if (ari()) {
            arl();
        } else {
            aUR();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        aru();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aUM() {
        if (this.dTF != null) {
            this.dTF.aUY().aUc();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.dTF != null) {
            this.dTF.aUY().dispatchEvent(jSEvent);
        }
    }

    public void W(Activity activity) {
        if (this.dTF != null) {
            this.dTF.W(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cKD = bVar.appBundlePath;
            i.qD("startup").ch("preload", ari() ? "1" : "0");
            i.qD("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0531a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0531a
                public void onReady() {
                    i.qD("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity ayQ;
                            if (!a.this.cOC && a.this.dTF != null && (ayQ = f.azg().ayQ()) != null && !ayQ.isFinishing() && ayQ.afe() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cKD);
                                }
                                a.this.dTF.W(ayQ);
                                a.this.dTF.b(bVar);
                                if (a.this.aUN()) {
                                    a.this.m(ayQ);
                                }
                            }
                        }
                    });
                }
            });
            if (this.dTF != null) {
                com.baidu.swan.games.network.b.d.aVK().a(this.dTF.aUY(), bVar);
            }
        }
    }

    public int apm() {
        if (this.dTF != null) {
            return this.dTF.apm();
        }
        return 0;
    }

    public boolean ari() {
        boolean z;
        synchronized (this.cOF) {
            z = this.cOz && this.dTF != null;
        }
        return z;
    }

    public boolean aUN() {
        DuMixGameSurfaceView aUK;
        return (this.cOC || (aUK = aUK()) == null || aUK.getParent() != null) ? false : true;
    }

    public SwanCoreVersion arv() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore arw() {
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

    private void arx() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.iu(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.arw();
        }
    }

    private boolean y(Intent intent) {
        switch (aUO()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aUO() {
        if (this.dTE < 0) {
            this.dTE = com.baidu.swan.apps.t.a.avV().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.dTE);
        }
        return this.dTE;
    }

    public boolean aUP() {
        boolean z = com.baidu.swan.apps.t.a.avV().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afe;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (afe = swanAppActivity.afe()) != null) {
            afe.aox().al(0, 0).aoC().f(j.aoK()).aoE();
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
    public void arl() {
        if (!this.cOC && !this.cOx.isEmpty() && ari()) {
            for (InterfaceC0531a interfaceC0531a : this.cOx) {
                if (interfaceC0531a != null) {
                    interfaceC0531a.onReady();
                }
            }
            this.cOx.clear();
        }
    }

    private String aUQ() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aUR() {
        synchronized (this.cOF) {
            if (!this.cOz && this.dTF == null) {
                aru();
                arx();
                String aUQ = aUQ();
                if (!TextUtils.isEmpty(aUQ) && !this.cOC) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aUQ);
                    }
                    this.dTF = new c(aUQ, "swan-game.js");
                    this.dTF.a(new c.InterfaceC0532c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0532c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cOF) {
                                a.this.cOz = true;
                                a.this.arl();
                            }
                        }
                    });
                }
            }
        }
    }

    private void aru() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aUS());
        }
    }

    private SwanCoreVersion aUS() {
        if (com.baidu.swan.games.k.a.c.wZ("package")) {
            if (TextUtils.isEmpty(this.cKD)) {
                return null;
            }
            if (!new File(this.cKD, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.kC(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cKD;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.wZ("normal") || com.baidu.swan.apps.ad.a.a.aEe()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.atx().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.kC(1);
        }
    }
}
