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
import com.baidu.swan.apps.aq.al;
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
    private static volatile a diI;
    private String cdC;
    private boolean chi;
    private boolean chl;
    private c diK;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int diJ = -1;
    private final Object chp = new Object();
    private List<InterfaceC0447a> chg = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0447a {
        void onReady();
    }

    private a() {
    }

    public static a aEO() {
        if (diI == null) {
            synchronized (a.class) {
                if (diI == null) {
                    diI = new a();
                }
            }
        }
        return diI;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (diI != null) {
                diI.chl = true;
                if (diI.diK != null) {
                    diI.diK.finish();
                }
                diI = null;
                aEO().adz();
            }
        }
    }

    public com.baidu.swan.games.f.a aEP() {
        if (this.diK != null) {
            return this.diK.aFd();
        }
        return null;
    }

    public DuMixGameSurfaceView aEQ() {
        if (this.diK != null) {
            return this.diK.aEQ();
        }
        return null;
    }

    private void adz() {
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
        if (!adC() && w(intent)) {
            boolean isSuccess = d.aHi().isSuccess();
            boolean aHj = d.aHj();
            if (isSuccess && aHj) {
                a(new InterfaceC0447a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0447a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).hc(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0447a interfaceC0447a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0447a != null && !this.chg.contains(interfaceC0447a)) {
            this.chg.add(interfaceC0447a);
        }
        if (adC()) {
            adF();
        } else {
            aEW();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        adP();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aER() {
        if (this.diK != null) {
            this.diK.aFd().aEh();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.diK != null) {
            this.diK.aFd().dispatchEvent(jSEvent);
        }
    }

    public void V(Activity activity) {
        if (this.diK != null) {
            this.diK.V(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cdC = bVar.appBundlePath;
            i.mX("startup").bH("preload", adC() ? "1" : "0");
            i.mX("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0447a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0447a
                public void onReady() {
                    i.mX("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity akb;
                            if (!a.this.chl && a.this.diK != null && (akb = f.akr().akb()) != null && !akb.isFinishing() && akb.Sc() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cdC);
                                }
                                a.this.diK.V(akb);
                                a.this.diK.b(bVar);
                                if (a.this.aES()) {
                                    a.this.m(akb);
                                }
                            }
                        }
                    });
                }
            });
            if (this.diK != null) {
                com.baidu.swan.games.network.b.d.aFN().a(this.diK.aFd(), bVar);
            }
        }
    }

    public int abR() {
        if (this.diK != null) {
            return this.diK.abR();
        }
        return 0;
    }

    public boolean adC() {
        boolean z;
        synchronized (this.chp) {
            z = this.chi && this.diK != null;
        }
        return z;
    }

    public boolean aES() {
        DuMixGameSurfaceView aEQ;
        return (this.chl || (aEQ = aEQ()) == null || aEQ.getParent() != null) ? false : true;
    }

    public SwanCoreVersion adQ() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore adR() {
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

    private void adS() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.fA(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.adR();
        }
    }

    private boolean w(Intent intent) {
        switch (aET()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aET() {
        if (this.diJ < 0) {
            this.diJ = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.diJ);
        }
        return this.diJ;
    }

    public boolean aEU() {
        boolean z = com.baidu.swan.apps.t.a.ahm().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f Sc;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (Sc = swanAppActivity.Sc()) != null) {
            Sc.abd().ag(0, 0).abj().f(j.abr()).abl();
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
    public void adF() {
        if (!this.chl && !this.chg.isEmpty() && adC()) {
            for (InterfaceC0447a interfaceC0447a : this.chg) {
                if (interfaceC0447a != null) {
                    interfaceC0447a.onReady();
                }
            }
            this.chg.clear();
        }
    }

    private String aEV() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aEW() {
        synchronized (this.chp) {
            if (!this.chi && this.diK == null) {
                adP();
                adS();
                String aEV = aEV();
                if (!TextUtils.isEmpty(aEV) && !this.chl) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aEV);
                    }
                    this.diK = new c(aEV, "swan-game.js");
                    this.diK.a(new c.InterfaceC0448c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0448c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.chp) {
                                a.this.chi = true;
                                a.this.adF();
                            }
                        }
                    });
                }
            }
        }
    }

    private void adP() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aEX());
        }
    }

    private SwanCoreVersion aEX() {
        if (com.baidu.swan.games.k.a.c.tb("package")) {
            if (TextUtils.isEmpty(this.cdC)) {
                return null;
            }
            if (!new File(this.cdC, "swan-game.js").exists()) {
                al.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.hw(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cdC;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.tb("normal") || com.baidu.swan.apps.ae.a.a.apb()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.afh().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.hw(1);
        }
    }
}
