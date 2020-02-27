package com.baidu.swan.games.i;

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
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.apps.res.widget.b.d;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.i.c;
import com.baidu.swan.games.k.a;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a coc;
    private String bpE;
    private boolean bsy;
    private c coe;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int cod = -1;
    private final Object bsE = new Object();
    private List<InterfaceC0335a> bsw = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0335a {
        void onReady();
    }

    private a() {
    }

    public static a anW() {
        if (coc == null) {
            synchronized (a.class) {
                if (coc == null) {
                    coc = new a();
                }
            }
        }
        return coc;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (coc != null) {
                coc.mIsReleased = true;
                if (coc.coe != null) {
                    coc.coe.finish();
                }
                coc = null;
                anW().Qx();
            }
        }
    }

    public com.baidu.swan.games.e.a anX() {
        if (this.coe != null) {
            return this.coe.aoj();
        }
        return null;
    }

    public DuMixGameSurfaceView anY() {
        if (this.coe != null) {
            return this.coe.anY();
        }
        return null;
    }

    private void Qx() {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
        }
        E(null);
    }

    public void E(Intent intent) {
        if (DEBUG) {
            String str = null;
            if (intent != null) {
                str = intent.getStringExtra("bundle_key_preload_preload_scene");
            }
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + str);
        }
        if (!Qz() && O(intent)) {
            a(new InterfaceC0335a() { // from class: com.baidu.swan.games.i.a.1
                @Override // com.baidu.swan.games.i.a.InterfaceC0335a
                public void onReady() {
                    if (a.DEBUG) {
                        d.q(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).gh(1).showToast();
                    }
                }
            });
        }
    }

    public void a(InterfaceC0335a interfaceC0335a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0335a != null && !this.bsw.contains(interfaceC0335a)) {
            this.bsw.add(interfaceC0335a);
        }
        if (Qz()) {
            QC();
        } else {
            QK();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        QN();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void anZ() {
        if (this.coe != null) {
            this.coe.aoj().anp();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.coe != null) {
            this.coe.aoj().dispatchEvent(jSEvent);
        }
    }

    public void aa(Activity activity) {
        if (this.coe != null) {
            this.coe.aa(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bpE = bVar.appBundlePath;
            f.jP("startup").bb("preload", Qz() ? "1" : "0");
            f.jP("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0335a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0335a
                public void onReady() {
                    f.jP("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity WB;
                            if (!a.this.mIsReleased && a.this.coe != null && (WB = com.baidu.swan.apps.y.f.WQ().WB()) != null && !WB.isFinishing() && WB.GA() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bpE);
                                }
                                a.this.coe.aa(WB);
                                a.this.coe.b(bVar);
                                if (a.this.aoa()) {
                                    a.this.l(WB);
                                }
                            }
                        }
                    });
                }
            });
            if (this.coe != null) {
                com.baidu.swan.games.network.b.d.aoR().a(this.coe.aoj(), bVar);
            }
        }
    }

    public int Pe() {
        if (this.coe != null) {
            return this.coe.Pe();
        }
        return 0;
    }

    public boolean Qz() {
        boolean z;
        synchronized (this.bsE) {
            z = this.bsy && this.coe != null;
        }
        return z;
    }

    public boolean aoa() {
        DuMixGameSurfaceView anY;
        return (this.mIsReleased || (anY = anY()) == null || anY.getParent() != null) ? false : true;
    }

    public SwanCoreVersion QO() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore QP() {
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

    private void QQ() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.eO(1));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.QP();
        }
    }

    private boolean O(Intent intent) {
        switch (aob()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aob() {
        if (this.cod < 0) {
            this.cod = com.baidu.swan.apps.w.a.TX().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cod);
        }
        return this.cod;
    }

    public boolean aoc() {
        boolean z = com.baidu.swan.apps.w.a.TX().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e GA;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (GA = swanAppActivity.GA()) != null) {
            GA.Op().Y(0, 0).Ov().e(i.OE()).Ox();
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
    public void QC() {
        if (!this.mIsReleased && !this.bsw.isEmpty() && Qz()) {
            for (InterfaceC0335a interfaceC0335a : this.bsw) {
                if (interfaceC0335a != null) {
                    interfaceC0335a.onReady();
                }
            }
            this.bsw.clear();
        }
    }

    private String aod() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void QK() {
        synchronized (this.bsE) {
            if (!this.bsy && this.coe == null) {
                QN();
                QQ();
                String aod = aod();
                if (!TextUtils.isEmpty(aod) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aod);
                    }
                    this.coe = new c(aod, "swan-game.js");
                    this.coe.a(new c.InterfaceC0336c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0336c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bsE) {
                                a.this.bsy = true;
                                a.this.QC();
                            }
                        }
                    });
                }
            }
        }
    }

    private void QN() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aoe());
        }
    }

    private SwanCoreVersion aoe() {
        if (com.baidu.swan.games.j.a.c.pf("package")) {
            if (TextUtils.isEmpty(this.bpE)) {
                return null;
            }
            if (!new File(this.bpE, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gz(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bpE;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.pf("normal") || com.baidu.swan.apps.ah.a.a.aaw()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.RR().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gz(1);
        }
    }
}
