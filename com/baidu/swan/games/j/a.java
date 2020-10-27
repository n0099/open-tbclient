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
import com.baidu.swan.apps.ap.ak;
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
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private static volatile a dPt;
    private String cGu;
    private boolean cKq;
    private boolean cKt;
    private c dPv;
    private ExtensionCore mExtensionCore;
    private SwanCoreVersion mSwanCoreVersion;
    private int dPu = -1;
    private final Object cKw = new Object();
    private List<InterfaceC0521a> cKo = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0521a {
        void onReady();
    }

    private a() {
    }

    public static a aSQ() {
        if (dPt == null) {
            synchronized (a.class) {
                if (dPt == null) {
                    dPt = new a();
                }
            }
        }
        return dPt;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (dPt != null) {
                dPt.cKt = true;
                if (dPt.dPv != null) {
                    dPt.dPv.finish();
                }
                dPt = null;
                aSQ().aST();
            }
        }
    }

    public com.baidu.swan.games.f.a aSR() {
        if (this.dPv != null) {
            return this.dPv.aTg();
        }
        return null;
    }

    public DuMixGameSurfaceView aSS() {
        if (this.dPv != null) {
            return this.dPv.aSS();
        }
        return null;
    }

    private void aST() {
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
        if (!apq() && y(intent)) {
            boolean isSuccess = d.aVo().isSuccess();
            boolean aVp = d.aVp();
            if (isSuccess && aVp) {
                a(new InterfaceC0521a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0521a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.k(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).kc(1).showToast();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0521a interfaceC0521a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0521a != null && !this.cKo.contains(interfaceC0521a)) {
            this.cKo.add(interfaceC0521a);
        }
        if (apq()) {
            apt();
        } else {
            aSZ();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        apC();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aSU() {
        if (this.dPv != null) {
            this.dPv.aTg().aSk();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.dPv != null) {
            this.dPv.aTg().dispatchEvent(jSEvent);
        }
    }

    public void X(Activity activity) {
        if (this.dPv != null) {
            this.dPv.X(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cGu = bVar.appBundlePath;
            i.qv("startup").ci("preload", apq() ? "1" : "0");
            i.qv("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0521a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0521a
                public void onReady() {
                    i.qv("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity awY;
                            if (!a.this.cKt && a.this.dPv != null && (awY = f.axo().awY()) != null && !awY.isFinishing() && awY.adm() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cGu);
                                }
                                a.this.dPv.X(awY);
                                a.this.dPv.b(bVar);
                                if (a.this.aSV()) {
                                    a.this.m(awY);
                                }
                            }
                        }
                    });
                }
            });
            if (this.dPv != null) {
                com.baidu.swan.games.network.b.d.aTS().a(this.dPv.aTg(), bVar);
            }
        }
    }

    public int ant() {
        if (this.dPv != null) {
            return this.dPv.ant();
        }
        return 0;
    }

    public boolean apq() {
        boolean z;
        synchronized (this.cKw) {
            z = this.cKq && this.dPv != null;
        }
        return z;
    }

    public boolean aSV() {
        DuMixGameSurfaceView aSS;
        return (this.cKt || (aSS = aSS()) == null || aSS.getParent() != null) ? false : true;
    }

    public SwanCoreVersion apD() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore apE() {
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

    private void apF() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.io(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.apE();
        }
    }

    private boolean y(Intent intent) {
        switch (aSW()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aSW() {
        if (this.dPu < 0) {
            this.dPu = com.baidu.swan.apps.t.a.aud().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.dPu);
        }
        return this.dPu;
    }

    public boolean aSX() {
        boolean z = com.baidu.swan.apps.t.a.aud().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f adm;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (adm = swanAppActivity.adm()) != null) {
            adm.amF().al(0, 0).amK().f(j.amS()).amM();
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
    public void apt() {
        if (!this.cKt && !this.cKo.isEmpty() && apq()) {
            for (InterfaceC0521a interfaceC0521a : this.cKo) {
                if (interfaceC0521a != null) {
                    interfaceC0521a.onReady();
                }
            }
            this.cKo.clear();
        }
    }

    private String aSY() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aSZ() {
        synchronized (this.cKw) {
            if (!this.cKq && this.dPv == null) {
                apC();
                apF();
                String aSY = aSY();
                if (!TextUtils.isEmpty(aSY) && !this.cKt) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aSY);
                    }
                    this.dPv = new c(aSY, "swan-game.js");
                    this.dPv.a(new c.InterfaceC0522c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0522c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cKw) {
                                a.this.cKq = true;
                                a.this.apt();
                            }
                        }
                    });
                }
            }
        }
    }

    private void apC() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aTa());
        }
    }

    private SwanCoreVersion aTa() {
        if (com.baidu.swan.games.k.a.c.wQ("package")) {
            if (TextUtils.isEmpty(this.cGu)) {
                return null;
            }
            if (!new File(this.cGu, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.kw(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cGu;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.wQ("normal") || com.baidu.swan.apps.ad.a.a.aCm()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.arE().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.kw(1);
        }
    }
}
