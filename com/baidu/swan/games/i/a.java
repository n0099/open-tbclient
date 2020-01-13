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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a cjY;
    private String blu;
    private boolean bop;
    private c cka;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int cjZ = -1;
    private final Object bov = new Object();
    private List<InterfaceC0325a> bon = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.i.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0325a {
        void onReady();
    }

    private a() {
    }

    public static a alJ() {
        if (cjY == null) {
            synchronized (a.class) {
                if (cjY == null) {
                    cjY = new a();
                }
            }
        }
        return cjY;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (cjY != null) {
                cjY.mIsReleased = true;
                if (cjY.cka != null) {
                    cjY.cka.finish();
                }
                cjY = null;
                alJ().Oj();
            }
        }
    }

    public com.baidu.swan.games.e.a alK() {
        if (this.cka != null) {
            return this.cka.alW();
        }
        return null;
    }

    public DuMixGameSurfaceView alL() {
        if (this.cka != null) {
            return this.cka.alL();
        }
        return null;
    }

    private void Oj() {
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
        if (!Ol() && O(intent)) {
            a(new InterfaceC0325a() { // from class: com.baidu.swan.games.i.a.1
                @Override // com.baidu.swan.games.i.a.InterfaceC0325a
                public void onReady() {
                    if (a.DEBUG) {
                        d.q(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).fR(1).showToast();
                    }
                }
            });
        }
    }

    public void a(InterfaceC0325a interfaceC0325a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0325a != null && !this.bon.contains(interfaceC0325a)) {
            this.bon.add(interfaceC0325a);
        }
        if (Ol()) {
            Oo();
        } else {
            Ow();
        }
    }

    public void e(com.baidu.swan.apps.x.b.b bVar) {
        Oz();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void alM() {
        if (this.cka != null) {
            this.cka.alW().alb();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.cka != null) {
            this.cka.alW().dispatchEvent(jSEvent);
        }
    }

    public void Z(Activity activity) {
        if (this.cka != null) {
            this.cka.Z(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.clm)) {
            this.blu = bVar.clm;
            f.jA("startup").aS("preload", Ol() ? "1" : "0");
            f.jA("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0325a() { // from class: com.baidu.swan.games.i.a.2
                @Override // com.baidu.swan.games.i.a.InterfaceC0325a
                public void onReady() {
                    f.jA("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity Un;
                            if (!a.this.mIsReleased && a.this.cka != null && (Un = com.baidu.swan.apps.y.f.UC().Un()) != null && !Un.isFinishing() && Un.El() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.blu);
                                }
                                a.this.cka.Z(Un);
                                a.this.cka.b(bVar);
                                if (a.this.alN()) {
                                    a.this.l(Un);
                                }
                            }
                        }
                    });
                }
            });
            if (this.cka != null) {
                com.baidu.swan.games.network.b.d.amE().a(this.cka.alW(), bVar);
            }
        }
    }

    public int MQ() {
        if (this.cka != null) {
            return this.cka.MQ();
        }
        return 0;
    }

    public boolean Ol() {
        boolean z;
        synchronized (this.bov) {
            z = this.bop && this.cka != null;
        }
        return z;
    }

    public boolean alN() {
        DuMixGameSurfaceView alL;
        return (this.mIsReleased || (alL = alL()) == null || alL.getParent() != null) ? false : true;
    }

    public SwanCoreVersion OA() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore OB() {
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

    private void OC() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.ey(1));
        }
    }

    public void f(com.baidu.swan.apps.x.b.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.OB();
        }
    }

    private boolean O(Intent intent) {
        switch (alO()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int alO() {
        if (this.cjZ < 0) {
            this.cjZ = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.cjZ);
        }
        return this.cjZ;
    }

    public boolean alP() {
        boolean z = com.baidu.swan.apps.w.a.RJ().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void l(SwanAppActivity swanAppActivity) {
        e El;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (El = swanAppActivity.El()) != null) {
            El.Mb().Y(0, 0).Mh().e(i.Mq()).Mj();
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
    public void Oo() {
        if (!this.mIsReleased && !this.bon.isEmpty() && Ol()) {
            for (InterfaceC0325a interfaceC0325a : this.bon) {
                if (interfaceC0325a != null) {
                    interfaceC0325a.onReady();
                }
            }
            this.bon.clear();
        }
    }

    private String alQ() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void Ow() {
        synchronized (this.bov) {
            if (!this.bop && this.cka == null) {
                Oz();
                OC();
                String alQ = alQ();
                if (!TextUtils.isEmpty(alQ) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + alQ);
                    }
                    this.cka = new c(alQ, "swan-game.js");
                    this.cka.a(new c.InterfaceC0326c() { // from class: com.baidu.swan.games.i.a.3
                        @Override // com.baidu.swan.games.i.c.InterfaceC0326c
                        public void c(com.baidu.swan.games.e.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.bov) {
                                a.this.bop = true;
                                a.this.Oo();
                            }
                        }
                    });
                }
            }
        }
    }

    private void Oz() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(alR());
        }
    }

    private SwanCoreVersion alR() {
        if (com.baidu.swan.games.j.a.c.oQ("package")) {
            if (TextUtils.isEmpty(this.blu)) {
                return null;
            }
            if (!new File(this.blu, "swan-game.js").exists()) {
                ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.i.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.gi(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.blu;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.j.a.c.oQ("normal") || com.baidu.swan.apps.ah.a.a.Yi()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.j.a.b.PD().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.gi(1);
        }
    }
}
