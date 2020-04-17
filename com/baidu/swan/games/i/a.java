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
    private static volatile a cNm;
    private String bNZ;
    private boolean bQS;
    private boolean bQV;
    private c cNo;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int cNn = -1;
    private final Object bQZ = new Object();
    private List<InterfaceC0365a> bQQ = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0365a {
        void onReady();
    }

    private a() {
    }

    public static a awo() {
        if (cNm == null) {
            synchronized (a.class) {
                if (cNm == null) {
                    cNm = new a();
                }
            }
        }
        return cNm;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (cNm != null) {
                cNm.bQV = true;
                if (cNm.cNo != null) {
                    cNm.cNo.finish();
                }
                cNm = null;
                awo().Yr();
            }
        }
    }

    public com.baidu.swan.games.e.a awp() {
        if (this.cNo != null) {
            return this.cNo.awB();
        }
        return null;
    }

    public DuMixGameSurfaceView awq() {
        if (this.cNo != null) {
            return this.cNo.awq();
        }
        return null;
    }

    private void Yr() {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
        }
        D(null);
    }

    public void D(Intent intent) {
        if (DEBUG) {
            String str = null;
            if (intent != null) {
                str = intent.getStringExtra("bundle_key_preload_preload_scene");
            }
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + str);
        }
        if (!Yt() && N(intent)) {
            a(new InterfaceC0365a() { // from class: com.baidu.swan.games.i.a.1
                @Override // com.baidu.swan.games.i.a.InterfaceC0365a
                public void onReady() {
                    if (a.DEBUG) {
                        d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).gp(1).showToast();
                    }
                }
            });
        }
    }

    public void a(InterfaceC0365a interfaceC0365a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0365a != null && !this.bQQ.contains(interfaceC0365a)) {
            this.bQQ.add(interfaceC0365a);
        }
        if (Yt()) {
            Yw();
        } else {
            YE();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        YH();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void awr() {
        if (this.cNo != null) {
            this.cNo.awB().avH();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cNo != null) {
            this.cNo.awB().dispatchEvent(jSEvent);
        }
    }

    public void W(Activity activity) {
        if (this.cNo != null) {
            this.cNo.W(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bNZ = bVar.appBundlePath;
            f.lb("startup").bk("preload", Yt() ? "1" : "0");
            f.lb("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0365a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0365a
                public void onReady() {
                    f.lb("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity aev;
                            if (!a.this.bQV && a.this.cNo != null && (aev = com.baidu.swan.apps.y.f.aeK().aev()) != null && !aev.isFinishing() && aev.Ou() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bNZ);
                                }
                                a.this.cNo.W(aev);
                                a.this.cNo.b(bVar);
                                if (a.this.aws()) {
                                    a.this.l(aev);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cNo != null) {
                com.baidu.swan.games.network.b.d.axj().a(this.cNo.awB(), bVar);
            }
        }
    }

    public int WY() {
        if (this.cNo != null) {
            return this.cNo.WY();
        }
        return 0;
    }

    public boolean Yt() {
        boolean z;
        synchronized (this.bQZ) {
            z = this.bQS && this.cNo != null;
        }
        return z;
    }

    public boolean aws() {
        DuMixGameSurfaceView awq;
        return (this.bQV || (awq = awq()) == null || awq.getParent() != null) ? false : true;
    }

    public SwanCoreVersion YI() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore YJ() {
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

    private void YK() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.eT(1));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.YJ();
        }
    }

    private boolean N(Intent intent) {
        switch (awt()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int awt() {
        if (this.cNn < 0) {
            this.cNn = com.baidu.swan.apps.w.a.abR().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cNn);
        }
        return this.cNn;
    }

    public boolean awu() {
        boolean z = com.baidu.swan.apps.w.a.abR().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e Ou;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (Ou = swanAppActivity.Ou()) != null) {
            Ou.Wi().ab(0, 0).Wo().e(i.Wy()).Wq();
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
    public void Yw() {
        if (!this.bQV && !this.bQQ.isEmpty() && Yt()) {
            for (InterfaceC0365a interfaceC0365a : this.bQQ) {
                if (interfaceC0365a != null) {
                    interfaceC0365a.onReady();
                }
            }
            this.bQQ.clear();
        }
    }

    private String awv() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void YE() {
        synchronized (this.bQZ) {
            if (!this.bQS && this.cNo == null) {
                YH();
                YK();
                String awv = awv();
                if (!TextUtils.isEmpty(awv) && !this.bQV) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + awv);
                    }
                    this.cNo = new c(awv, "swan-game.js");
                    this.cNo.a(new c.InterfaceC0366c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0366c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bQZ) {
                                a.this.bQS = true;
                                a.this.Yw();
                            }
                        }
                    });
                }
            }
        }
    }

    private void YH() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aww());
        }
    }

    private SwanCoreVersion aww() {
        if (com.baidu.swan.games.j.a.c.qr("package")) {
            if (TextUtils.isEmpty(this.bNZ)) {
                return null;
            }
            if (!new File(this.bNZ, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gG(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bNZ;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.qr("normal") || com.baidu.swan.apps.ah.a.a.aiG()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.ZL().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gG(1);
        }
    }
}
