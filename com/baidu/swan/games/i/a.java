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
    private static volatile a cNs;
    private String bOe;
    private boolean bQX;
    private boolean bRa;
    private c cNu;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int cNt = -1;
    private final Object bRe = new Object();
    private List<InterfaceC0386a> bQV = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0386a {
        void onReady();
    }

    private a() {
    }

    public static a awo() {
        if (cNs == null) {
            synchronized (a.class) {
                if (cNs == null) {
                    cNs = new a();
                }
            }
        }
        return cNs;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (cNs != null) {
                cNs.bRa = true;
                if (cNs.cNu != null) {
                    cNs.cNu.finish();
                }
                cNs = null;
                awo().Yq();
            }
        }
    }

    public com.baidu.swan.games.e.a awp() {
        if (this.cNu != null) {
            return this.cNu.awB();
        }
        return null;
    }

    public DuMixGameSurfaceView awq() {
        if (this.cNu != null) {
            return this.cNu.awq();
        }
        return null;
    }

    private void Yq() {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime by release");
        }
        q(null);
    }

    public void q(Intent intent) {
        if (DEBUG) {
            String str = null;
            if (intent != null) {
                str = intent.getStringExtra("bundle_key_preload_preload_scene");
            }
            Log.d("SwanGameCoreRuntime", "preloadCoreRuntime preloadScene:" + str);
        }
        if (!Ys() && A(intent)) {
            a(new InterfaceC0386a() { // from class: com.baidu.swan.games.i.a.1
                @Override // com.baidu.swan.games.i.a.InterfaceC0386a
                public void onReady() {
                    if (a.DEBUG) {
                        d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).gp(1).showToast();
                    }
                }
            });
        }
    }

    public void a(InterfaceC0386a interfaceC0386a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0386a != null && !this.bQV.contains(interfaceC0386a)) {
            this.bQV.add(interfaceC0386a);
        }
        if (Ys()) {
            Yv();
        } else {
            YD();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        YG();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void awr() {
        if (this.cNu != null) {
            this.cNu.awB().avH();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cNu != null) {
            this.cNu.awB().dispatchEvent(jSEvent);
        }
    }

    public void W(Activity activity) {
        if (this.cNu != null) {
            this.cNu.W(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bOe = bVar.appBundlePath;
            f.lb("startup").bk("preload", Ys() ? "1" : "0");
            f.lb("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0386a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0386a
                public void onReady() {
                    f.lb("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity aeu;
                            if (!a.this.bRa && a.this.cNu != null && (aeu = com.baidu.swan.apps.y.f.aeJ().aeu()) != null && !aeu.isFinishing() && aeu.Ot() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bOe);
                                }
                                a.this.cNu.W(aeu);
                                a.this.cNu.b(bVar);
                                if (a.this.aws()) {
                                    a.this.l(aeu);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cNu != null) {
                com.baidu.swan.games.network.b.d.axj().a(this.cNu.awB(), bVar);
            }
        }
    }

    public int WX() {
        if (this.cNu != null) {
            return this.cNu.WX();
        }
        return 0;
    }

    public boolean Ys() {
        boolean z;
        synchronized (this.bRe) {
            z = this.bQX && this.cNu != null;
        }
        return z;
    }

    public boolean aws() {
        DuMixGameSurfaceView awq;
        return (this.bRa || (awq = awq()) == null || awq.getParent() != null) ? false : true;
    }

    public SwanCoreVersion YH() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore YI() {
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

    private void YJ() {
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
            this.mExtensionCore = bVar.YI();
        }
    }

    private boolean A(Intent intent) {
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
        if (this.cNt < 0) {
            this.cNt = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cNt);
        }
        return this.cNt;
    }

    public boolean awu() {
        boolean z = com.baidu.swan.apps.w.a.abQ().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e Ot;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (Ot = swanAppActivity.Ot()) != null) {
            Ot.Wh().ab(0, 0).Wn().e(i.Wx()).Wp();
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
    public void Yv() {
        if (!this.bRa && !this.bQV.isEmpty() && Ys()) {
            for (InterfaceC0386a interfaceC0386a : this.bQV) {
                if (interfaceC0386a != null) {
                    interfaceC0386a.onReady();
                }
            }
            this.bQV.clear();
        }
    }

    private String awv() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void YD() {
        synchronized (this.bRe) {
            if (!this.bQX && this.cNu == null) {
                YG();
                YJ();
                String awv = awv();
                if (!TextUtils.isEmpty(awv) && !this.bRa) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + awv);
                    }
                    this.cNu = new c(awv, "swan-game.js");
                    this.cNu.a(new c.InterfaceC0387c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0387c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bRe) {
                                a.this.bQX = true;
                                a.this.Yv();
                            }
                        }
                    });
                }
            }
        }
    }

    private void YG() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aww());
        }
    }

    private SwanCoreVersion aww() {
        if (com.baidu.swan.games.j.a.c.qr("package")) {
            if (TextUtils.isEmpty(this.bOe)) {
                return null;
            }
            if (!new File(this.bOe, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gG(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bOe;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.qr("normal") || com.baidu.swan.apps.ah.a.a.aiF()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.ZK().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gG(1);
        }
    }
}
