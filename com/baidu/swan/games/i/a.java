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
    private static volatile a cop;
    private String bpS;
    private boolean bsM;
    private c cor;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int coq = -1;
    private final Object bsS = new Object();
    private List<InterfaceC0335a> bsK = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0335a {
        void onReady();
    }

    private a() {
    }

    public static a aob() {
        if (cop == null) {
            synchronized (a.class) {
                if (cop == null) {
                    cop = new a();
                }
            }
        }
        return cop;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (cop != null) {
                cop.mIsReleased = true;
                if (cop.cor != null) {
                    cop.cor.finish();
                }
                cop = null;
                aob().QC();
            }
        }
    }

    public com.baidu.swan.games.e.a aoc() {
        if (this.cor != null) {
            return this.cor.aoo();
        }
        return null;
    }

    public DuMixGameSurfaceView aod() {
        if (this.cor != null) {
            return this.cor.aod();
        }
        return null;
    }

    private void QC() {
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
        if (!QE() && O(intent)) {
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
        if (interfaceC0335a != null && !this.bsK.contains(interfaceC0335a)) {
            this.bsK.add(interfaceC0335a);
        }
        if (QE()) {
            QH();
        } else {
            QP();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        QS();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aoe() {
        if (this.cor != null) {
            this.cor.aoo().anu();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cor != null) {
            this.cor.aoo().dispatchEvent(jSEvent);
        }
    }

    public void aa(Activity activity) {
        if (this.cor != null) {
            this.cor.aa(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bpS = bVar.appBundlePath;
            f.jO("startup").ba("preload", QE() ? "1" : "0");
            f.jO("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0335a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0335a
                public void onReady() {
                    f.jO("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity WG;
                            if (!a.this.mIsReleased && a.this.cor != null && (WG = com.baidu.swan.apps.y.f.WV().WG()) != null && !WG.isFinishing() && WG.GH() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bpS);
                                }
                                a.this.cor.aa(WG);
                                a.this.cor.b(bVar);
                                if (a.this.aof()) {
                                    a.this.l(WG);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cor != null) {
                com.baidu.swan.games.network.b.d.aoW().a(this.cor.aoo(), bVar);
            }
        }
    }

    public int Pj() {
        if (this.cor != null) {
            return this.cor.Pj();
        }
        return 0;
    }

    public boolean QE() {
        boolean z;
        synchronized (this.bsS) {
            z = this.bsM && this.cor != null;
        }
        return z;
    }

    public boolean aof() {
        DuMixGameSurfaceView aod;
        return (this.mIsReleased || (aod = aod()) == null || aod.getParent() != null) ? false : true;
    }

    public SwanCoreVersion QT() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore QU() {
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

    private void QV() {
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
            this.mExtensionCore = bVar.QU();
        }
    }

    private boolean O(Intent intent) {
        switch (aog()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aog() {
        if (this.coq < 0) {
            this.coq = com.baidu.swan.apps.w.a.Uc().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.coq);
        }
        return this.coq;
    }

    public boolean aoh() {
        boolean z = com.baidu.swan.apps.w.a.Uc().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e GH;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (GH = swanAppActivity.GH()) != null) {
            GH.Ou().Y(0, 0).OA().e(i.OJ()).OC();
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
    public void QH() {
        if (!this.mIsReleased && !this.bsK.isEmpty() && QE()) {
            for (InterfaceC0335a interfaceC0335a : this.bsK) {
                if (interfaceC0335a != null) {
                    interfaceC0335a.onReady();
                }
            }
            this.bsK.clear();
        }
    }

    private String aoi() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void QP() {
        synchronized (this.bsS) {
            if (!this.bsM && this.cor == null) {
                QS();
                QV();
                String aoi = aoi();
                if (!TextUtils.isEmpty(aoi) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aoi);
                    }
                    this.cor = new c(aoi, "swan-game.js");
                    this.cor.a(new c.InterfaceC0336c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0336c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bsS) {
                                a.this.bsM = true;
                                a.this.QH();
                            }
                        }
                    });
                }
            }
        }
    }

    private void QS() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aoj());
        }
    }

    private SwanCoreVersion aoj() {
        if (com.baidu.swan.games.j.a.c.pe("package")) {
            if (TextUtils.isEmpty(this.bpS)) {
                return null;
            }
            if (!new File(this.bpS, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gz(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bpS;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.pe("normal") || com.baidu.swan.apps.ah.a.a.aaB()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.RW().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gz(1);
        }
    }
}
