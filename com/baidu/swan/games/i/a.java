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
/* loaded from: classes9.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cjL;
    private String bkF;
    private boolean bnB;
    private c cjN;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int cjM = -1;
    private final Object bnH = new Object();
    private List<InterfaceC0323a> bnz = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0323a {
        void onReady();
    }

    private a() {
    }

    public static a alq() {
        if (cjL == null) {
            synchronized (a.class) {
                if (cjL == null) {
                    cjL = new a();
                }
            }
        }
        return cjL;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (cjL != null) {
                cjL.mIsReleased = true;
                if (cjL.cjN != null) {
                    cjL.cjN.finish();
                }
                cjL = null;
                alq().NN();
            }
        }
    }

    public com.baidu.swan.games.e.a alr() {
        if (this.cjN != null) {
            return this.cjN.alD();
        }
        return null;
    }

    public DuMixGameSurfaceView als() {
        if (this.cjN != null) {
            return this.cjN.als();
        }
        return null;
    }

    private void NN() {
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
        if (!NP() && O(intent)) {
            a(new InterfaceC0323a() { // from class: com.baidu.swan.games.i.a.1
                @Override // com.baidu.swan.games.i.a.InterfaceC0323a
                public void onReady() {
                    if (a.DEBUG) {
                        d.q(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).fQ(1).showToast();
                    }
                }
            });
        }
    }

    public void a(InterfaceC0323a interfaceC0323a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0323a != null && !this.bnz.contains(interfaceC0323a)) {
            this.bnz.add(interfaceC0323a);
        }
        if (NP()) {
            NS();
        } else {
            Oa();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        Od();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void alt() {
        if (this.cjN != null) {
            this.cjN.alD().akI();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cjN != null) {
            this.cjN.alD().dispatchEvent(jSEvent);
        }
    }

    public void Y(Activity activity) {
        if (this.cjN != null) {
            this.cjN.Y(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.ckZ)) {
            this.bkF = bVar.ckZ;
            f.jx("startup").aR("preload", NP() ? "1" : "0");
            f.jx("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0323a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0323a
                public void onReady() {
                    f.jx("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity TQ;
                            if (!a.this.mIsReleased && a.this.cjN != null && (TQ = com.baidu.swan.apps.y.f.Uf().TQ()) != null && !TQ.isFinishing() && TQ.DP() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bkF);
                                }
                                a.this.cjN.Y(TQ);
                                a.this.cjN.b(bVar);
                                if (a.this.alu()) {
                                    a.this.l(TQ);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cjN != null) {
                com.baidu.swan.games.network.b.d.aml().a(this.cjN.alD(), bVar);
            }
        }
    }

    public int Mu() {
        if (this.cjN != null) {
            return this.cjN.Mu();
        }
        return 0;
    }

    public boolean NP() {
        boolean z;
        synchronized (this.bnH) {
            z = this.bnB && this.cjN != null;
        }
        return z;
    }

    public boolean alu() {
        DuMixGameSurfaceView als;
        return (this.mIsReleased || (als = als()) == null || als.getParent() != null) ? false : true;
    }

    public SwanCoreVersion Oe() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore Of() {
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

    private void Og() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.ex(1));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.Of();
        }
    }

    private boolean O(Intent intent) {
        switch (alv()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int alv() {
        if (this.cjM < 0) {
            this.cjM = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cjM);
        }
        return this.cjM;
    }

    public boolean alw() {
        boolean z = com.baidu.swan.apps.w.a.Rn().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e DP;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (DP = swanAppActivity.DP()) != null) {
            DP.LF().U(0, 0).LL().e(i.LU()).LN();
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
    public void NS() {
        if (!this.mIsReleased && !this.bnz.isEmpty() && NP()) {
            for (InterfaceC0323a interfaceC0323a : this.bnz) {
                if (interfaceC0323a != null) {
                    interfaceC0323a.onReady();
                }
            }
            this.bnz.clear();
        }
    }

    private String alx() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void Oa() {
        synchronized (this.bnH) {
            if (!this.bnB && this.cjN == null) {
                Od();
                Og();
                String alx = alx();
                if (!TextUtils.isEmpty(alx) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + alx);
                    }
                    this.cjN = new c(alx, "swan-game.js");
                    this.cjN.a(new c.InterfaceC0324c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0324c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bnH) {
                                a.this.bnB = true;
                                a.this.NS();
                            }
                        }
                    });
                }
            }
        }
    }

    private void Od() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aly());
        }
    }

    private SwanCoreVersion aly() {
        if (com.baidu.swan.games.j.a.c.oN("package")) {
            if (TextUtils.isEmpty(this.bkF)) {
                return null;
            }
            if (!new File(this.bkF, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gh(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bkF;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.oN("normal") || com.baidu.swan.apps.ah.a.a.XL()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.Ph().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gh(1);
        }
    }
}
