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
    private static volatile a coe;
    private String bpG;
    private boolean bsA;
    private c cog;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int cof = -1;
    private final Object bsG = new Object();
    private List<InterfaceC0335a> bsy = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0335a {
        void onReady();
    }

    private a() {
    }

    public static a anY() {
        if (coe == null) {
            synchronized (a.class) {
                if (coe == null) {
                    coe = new a();
                }
            }
        }
        return coe;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (coe != null) {
                coe.mIsReleased = true;
                if (coe.cog != null) {
                    coe.cog.finish();
                }
                coe = null;
                anY().Qz();
            }
        }
    }

    public com.baidu.swan.games.e.a anZ() {
        if (this.cog != null) {
            return this.cog.aol();
        }
        return null;
    }

    public DuMixGameSurfaceView aoa() {
        if (this.cog != null) {
            return this.cog.aoa();
        }
        return null;
    }

    private void Qz() {
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
        if (!QB() && O(intent)) {
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
        if (interfaceC0335a != null && !this.bsy.contains(interfaceC0335a)) {
            this.bsy.add(interfaceC0335a);
        }
        if (QB()) {
            QE();
        } else {
            QM();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        QP();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aob() {
        if (this.cog != null) {
            this.cog.aol().anr();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cog != null) {
            this.cog.aol().dispatchEvent(jSEvent);
        }
    }

    public void aa(Activity activity) {
        if (this.cog != null) {
            this.cog.aa(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bpG = bVar.appBundlePath;
            f.jP("startup").bb("preload", QB() ? "1" : "0");
            f.jP("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0335a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0335a
                public void onReady() {
                    f.jP("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity WD;
                            if (!a.this.mIsReleased && a.this.cog != null && (WD = com.baidu.swan.apps.y.f.WS().WD()) != null && !WD.isFinishing() && WD.GC() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bpG);
                                }
                                a.this.cog.aa(WD);
                                a.this.cog.b(bVar);
                                if (a.this.aoc()) {
                                    a.this.l(WD);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cog != null) {
                com.baidu.swan.games.network.b.d.aoT().a(this.cog.aol(), bVar);
            }
        }
    }

    public int Pg() {
        if (this.cog != null) {
            return this.cog.Pg();
        }
        return 0;
    }

    public boolean QB() {
        boolean z;
        synchronized (this.bsG) {
            z = this.bsA && this.cog != null;
        }
        return z;
    }

    public boolean aoc() {
        DuMixGameSurfaceView aoa;
        return (this.mIsReleased || (aoa = aoa()) == null || aoa.getParent() != null) ? false : true;
    }

    public SwanCoreVersion QQ() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore QR() {
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

    private void QS() {
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
            this.mExtensionCore = bVar.QR();
        }
    }

    private boolean O(Intent intent) {
        switch (aod()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aod() {
        if (this.cof < 0) {
            this.cof = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cof);
        }
        return this.cof;
    }

    public boolean aoe() {
        boolean z = com.baidu.swan.apps.w.a.TZ().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e GC;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (GC = swanAppActivity.GC()) != null) {
            GC.Or().Y(0, 0).Ox().e(i.OG()).Oz();
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
    public void QE() {
        if (!this.mIsReleased && !this.bsy.isEmpty() && QB()) {
            for (InterfaceC0335a interfaceC0335a : this.bsy) {
                if (interfaceC0335a != null) {
                    interfaceC0335a.onReady();
                }
            }
            this.bsy.clear();
        }
    }

    private String aof() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void QM() {
        synchronized (this.bsG) {
            if (!this.bsA && this.cog == null) {
                QP();
                QS();
                String aof = aof();
                if (!TextUtils.isEmpty(aof) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aof);
                    }
                    this.cog = new c(aof, "swan-game.js");
                    this.cog.a(new c.InterfaceC0336c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0336c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bsG) {
                                a.this.bsA = true;
                                a.this.QE();
                            }
                        }
                    });
                }
            }
        }
    }

    private void QP() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aog());
        }
    }

    private SwanCoreVersion aog() {
        if (com.baidu.swan.games.j.a.c.pf("package")) {
            if (TextUtils.isEmpty(this.bpG)) {
                return null;
            }
            if (!new File(this.bpG, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gz(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bpG;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.pf("normal") || com.baidu.swan.apps.ah.a.a.aay()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.RT().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gz(1);
        }
    }
}
