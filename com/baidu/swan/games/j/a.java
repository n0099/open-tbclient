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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.core.d.e;
import com.baidu.swan.apps.core.d.i;
import com.baidu.swan.apps.extcore.model.ExtensionCore;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.g;
import com.baidu.swan.apps.swancore.model.SwanCoreVersion;
import com.baidu.swan.apps.w.f;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.j.c;
import com.baidu.swan.games.l.a;
import com.baidu.swan.games.utils.so.d;
import java.io.File;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cYk;
    private String bXk;
    private c cYm;
    private boolean caJ;
    private boolean caM;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int cYl = -1;
    private final Object caQ = new Object();
    private List<InterfaceC0428a> caH = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0428a {
        void onReady();
    }

    private a() {
    }

    public static a aAd() {
        if (cYk == null) {
            synchronized (a.class) {
                if (cYk == null) {
                    cYk = new a();
                }
            }
        }
        return cYk;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (cYk != null) {
                cYk.caM = true;
                if (cYk.cYm != null) {
                    cYk.cYm.finish();
                }
                cYk = null;
                aAd().abo();
            }
        }
    }

    public com.baidu.swan.games.f.a aAe() {
        if (this.cYm != null) {
            return this.cYm.aAq();
        }
        return null;
    }

    public DuMixGameSurfaceView aAf() {
        if (this.cYm != null) {
            return this.cYm.aAf();
        }
        return null;
    }

    private void abo() {
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
        if (!abr() && w(intent)) {
            boolean aCo = d.aCo();
            boolean aCp = d.aCp();
            if (aCo && aCp) {
                a(new InterfaceC0428a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0428a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).gI(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0428a interfaceC0428a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0428a != null && !this.caH.contains(interfaceC0428a)) {
            this.caH.add(interfaceC0428a);
        }
        if (abr()) {
            abu();
        } else {
            abC();
        }
    }

    public void e(com.baidu.swan.apps.v.b.b bVar) {
        abF();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aAg() {
        if (this.cYm != null) {
            this.cYm.aAq().azw();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cYm != null) {
            this.cYm.aAq().dispatchEvent(jSEvent);
        }
    }

    public void U(Activity activity) {
        if (this.cYm != null) {
            this.cYm.U(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bXk = bVar.appBundlePath;
            g.mp("startup").bD("preload", abr() ? "1" : "0");
            g.mp("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0428a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0428a
                public void onReady() {
                    g.mp("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity ahF;
                            if (!a.this.caM && a.this.cYm != null && (ahF = f.ahV().ahF()) != null && !ahF.isFinishing() && ahF.QH() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.bXk);
                                }
                                a.this.cYm.U(ahF);
                                a.this.cYm.b(bVar);
                                if (a.this.aAh()) {
                                    a.this.l(ahF);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cYm != null) {
                com.baidu.swan.games.network.b.d.aBa().a(this.cYm.aAq(), bVar);
            }
        }
    }

    public int ZJ() {
        if (this.cYm != null) {
            return this.cYm.ZJ();
        }
        return 0;
    }

    public boolean abr() {
        boolean z;
        synchronized (this.caQ) {
            z = this.caJ && this.cYm != null;
        }
        return z;
    }

    public boolean aAh() {
        DuMixGameSurfaceView aAf;
        return (this.caM || (aAf = aAf()) == null || aAf.getParent() != null) ? false : true;
    }

    public SwanCoreVersion abG() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore abH() {
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

    private void abI() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.fg(1));
        }
    }

    public void f(com.baidu.swan.apps.v.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.abH();
        }
    }

    private boolean w(Intent intent) {
        switch (aAi()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aAi() {
        if (this.cYl < 0) {
            this.cYl = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cYl);
        }
        return this.cYl;
    }

    public boolean aAj() {
        boolean z = com.baidu.swan.apps.u.a.aeU().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e QH;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (QH = swanAppActivity.QH()) != null) {
            QH.YT().ae(0, 0).YZ().f(i.Zj()).Zb();
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
    public void abu() {
        if (!this.caM && !this.caH.isEmpty() && abr()) {
            for (InterfaceC0428a interfaceC0428a : this.caH) {
                if (interfaceC0428a != null) {
                    interfaceC0428a.onReady();
                }
            }
            this.caH.clear();
        }
    }

    private String aAk() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void abC() {
        synchronized (this.caQ) {
            if (!this.caJ && this.cYm == null) {
                abF();
                abI();
                String aAk = aAk();
                if (!TextUtils.isEmpty(aAk) && !this.caM) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aAk);
                    }
                    this.cYm = new c(aAk, "swan-game.js");
                    this.cYm.a(new c.InterfaceC0429c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0429c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.caQ) {
                                a.this.caJ = true;
                                a.this.abu();
                            }
                        }
                    });
                }
            }
        }
    }

    private void abF() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aAl());
        }
    }

    private SwanCoreVersion aAl() {
        if (com.baidu.swan.games.k.a.c.rU("package")) {
            if (TextUtils.isEmpty(this.bXk)) {
                return null;
            }
            if (!new File(this.bXk, "swan-game.js").exists()) {
                aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.hc(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.bXk;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.rU("normal") || com.baidu.swan.apps.af.a.a.amm()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.acK().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.hc(1);
        }
    }
}
