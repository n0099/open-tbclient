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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a ejy;
    private String cWt;
    private boolean dao;
    private c ejA;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int ejz = -1;
    private final Object dau = new Object();
    private List<InterfaceC0536a> dam = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0536a {
        void onReady();
    }

    private a() {
    }

    public static a bai() {
        if (ejy == null) {
            synchronized (a.class) {
                if (ejy == null) {
                    ejy = new a();
                }
            }
        }
        return ejy;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (ejy != null) {
                ejy.mIsReleased = true;
                if (ejy.ejA != null) {
                    ejy.ejA.finish();
                }
                ejy = null;
                bai().bal();
            }
        }
    }

    public com.baidu.swan.games.f.a baj() {
        if (this.ejA != null) {
            return this.ejA.bay();
        }
        return null;
    }

    public DuMixGameSurfaceView bak() {
        if (this.ejA != null) {
            return this.ejA.bak();
        }
        return null;
    }

    private void bal() {
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
        if (!avJ() && z(intent)) {
            boolean isSuccess = d.bcG().isSuccess();
            boolean bcH = d.bcH();
            if (isSuccess && bcH) {
                a(new InterfaceC0536a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0536a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).kM(1).aLT();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0536a interfaceC0536a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0536a != null && !this.dam.contains(interfaceC0536a)) {
            this.dam.add(interfaceC0536a);
        }
        if (avJ()) {
            avM();
        } else {
            bar();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        avV();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void bam() {
        if (this.ejA != null) {
            this.ejA.bay().aZC();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.ejA != null) {
            this.ejA.bay().dispatchEvent(jSEvent);
        }
    }

    public void Y(Activity activity) {
        if (this.ejA != null) {
            this.ejA.Y(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cWt = bVar.appBundlePath;
            i.rd("startup").cn("preload", avJ() ? "1" : "0");
            i.rd("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0536a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0536a
                public void onReady() {
                    i.rd("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity aDr;
                            if (!a.this.mIsReleased && a.this.ejA != null && (aDr = f.aDH().aDr()) != null && !aDr.isFinishing() && aDr.ajt() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cWt);
                                }
                                a.this.ejA.Y(aDr);
                                a.this.ejA.b(bVar);
                                if (a.this.ban()) {
                                    a.this.m(aDr);
                                }
                            }
                        }
                    });
                }
            });
            if (this.ejA != null) {
                com.baidu.swan.games.network.b.d.bbk().a(this.ejA.bay(), bVar);
            }
        }
    }

    public int atM() {
        if (this.ejA != null) {
            return this.ejA.atM();
        }
        return 0;
    }

    public boolean avJ() {
        boolean z;
        synchronized (this.dau) {
            z = this.dao && this.ejA != null;
        }
        return z;
    }

    public boolean ban() {
        DuMixGameSurfaceView bak;
        return (this.mIsReleased || (bak = bak()) == null || bak.getParent() != null) ? false : true;
    }

    public SwanCoreVersion avW() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore avX() {
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

    private void avY() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.iN(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.avX();
        }
    }

    private boolean z(Intent intent) {
        switch (bao()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int bao() {
        if (this.ejz < 0) {
            this.ejz = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.ejz);
        }
        return this.ejz;
    }

    public boolean bap() {
        boolean z = com.baidu.swan.apps.t.a.aAv().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f ajt;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (ajt = swanAppActivity.ajt()) != null) {
            ajt.asY().ai(0, 0).atd().f(j.atl()).atf();
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
    public void avM() {
        if (!this.mIsReleased && !this.dam.isEmpty() && avJ()) {
            for (InterfaceC0536a interfaceC0536a : this.dam) {
                if (interfaceC0536a != null) {
                    interfaceC0536a.onReady();
                }
            }
            this.dam.clear();
        }
    }

    private String baq() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void bar() {
        synchronized (this.dau) {
            if (!this.dao && this.ejA == null) {
                avV();
                avY();
                String baq = baq();
                if (!TextUtils.isEmpty(baq) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + baq);
                    }
                    this.ejA = new c(baq, "swan-game.js");
                    this.ejA.a(new c.InterfaceC0537c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0537c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.dau) {
                                a.this.dao = true;
                                a.this.avM();
                            }
                        }
                    });
                }
            }
        }
    }

    private void avV() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(bas());
        }
    }

    private SwanCoreVersion bas() {
        if (com.baidu.swan.games.k.a.c.xF("package")) {
            if (TextUtils.isEmpty(this.cWt)) {
                return null;
            }
            if (!new File(this.cWt, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.lf(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cWt;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.xF("normal") || com.baidu.swan.apps.ad.a.a.aIG()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.axY().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.lf(1);
        }
    }
}
