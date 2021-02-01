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
    private static volatile a egT;
    private String cTU;
    private boolean cXO;
    private c egV;
    private ExtensionCore mExtensionCore;
    private boolean mIsReleased;
    private SwanCoreVersion mSwanCoreVersion;
    private int egU = -1;
    private final Object cXT = new Object();
    private List<InterfaceC0516a> cXM = new CopyOnWriteArrayList();

    /* renamed from: com.baidu.swan.games.j.a$a  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0516a {
        void onReady();
    }

    private a() {
    }

    public static a aWA() {
        if (egT == null) {
            synchronized (a.class) {
                if (egT == null) {
                    egT = new a();
                }
            }
        }
        return egT;
    }

    public static synchronized void release() {
        synchronized (a.class) {
            if (DEBUG) {
                Log.d("SwanGameCoreRuntime", "release");
            }
            if (egT != null) {
                egT.mIsReleased = true;
                if (egT.egV != null) {
                    egT.egV.finish();
                }
                egT = null;
                aWA().aWD();
            }
        }
    }

    public com.baidu.swan.games.f.a aWB() {
        if (this.egV != null) {
            return this.egV.aWQ();
        }
        return null;
    }

    public DuMixGameSurfaceView aWC() {
        if (this.egV != null) {
            return this.egV.aWC();
        }
        return null;
    }

    private void aWD() {
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
        if (!asn() && z(intent)) {
            boolean isSuccess = d.aYY().isSuccess();
            boolean aYZ = d.aYZ();
            if (isSuccess && aYZ) {
                a(new InterfaceC0516a() { // from class: com.baidu.swan.games.j.a.1
                    @Override // com.baidu.swan.games.j.a.InterfaceC0516a
                    public void onReady() {
                        if (a.DEBUG) {
                            com.baidu.swan.apps.res.widget.b.d.u(AppRuntime.getAppContext(), a.h.aiapps_game_preload_core_runtime_end).jj(1).aIs();
                        }
                    }
                });
            }
        }
    }

    public void a(InterfaceC0516a interfaceC0516a) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "prepareRuntime");
        }
        if (interfaceC0516a != null && !this.cXM.contains(interfaceC0516a)) {
            this.cXM.add(interfaceC0516a);
        }
        if (asn()) {
            asq();
        } else {
            aWJ();
        }
    }

    public void e(com.baidu.swan.apps.u.c.b bVar) {
        asz();
        if (this.mSwanCoreVersion != null) {
            bVar.b(this.mSwanCoreVersion);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "syncSwanCore mSwanCoreVersion: " + this.mSwanCoreVersion);
        }
    }

    public void aWE() {
        if (this.egV != null) {
            this.egV.aWQ().aVU();
        }
    }

    public void a(JSEvent jSEvent) {
        if (this.egV != null) {
            this.egV.aWQ().dispatchEvent(jSEvent);
        }
    }

    public void S(Activity activity) {
        if (this.egV != null) {
            this.egV.S(activity);
        }
    }

    public void a(final a.b bVar) {
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "onAppReady");
        }
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cTU = bVar.appBundlePath;
            i.qk("startup").cg("preload", asn() ? "1" : "0");
            i.qk("startup").f(new UbcFlowEvent("na_prepare_runtime_start"));
            a(new InterfaceC0516a() { // from class: com.baidu.swan.games.j.a.2
                @Override // com.baidu.swan.games.j.a.InterfaceC0516a
                public void onReady() {
                    i.qk("startup").f(new UbcFlowEvent("na_prepare_runtime_end"));
                    ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.2.1
                        @Override // java.lang.Runnable
                        public void run() {
                            SwanAppActivity azV;
                            if (!a.this.mIsReleased && a.this.egV != null && (azV = f.aAl().azV()) != null && !azV.isFinishing() && azV.afX() != null) {
                                if (a.DEBUG) {
                                    Log.d("SwanGameCoreRuntime", "loadAppJs start: " + a.this.cTU);
                                }
                                a.this.egV.S(azV);
                                a.this.egV.b(bVar);
                                if (a.this.aWF()) {
                                    a.this.m(azV);
                                }
                            }
                        }
                    });
                }
            });
            if (this.egV != null) {
                com.baidu.swan.games.network.b.d.aXC().a(this.egV.aWQ(), bVar);
            }
        }
    }

    public int aqp() {
        if (this.egV != null) {
            return this.egV.aqp();
        }
        return 0;
    }

    public boolean asn() {
        boolean z;
        synchronized (this.cXT) {
            z = this.cXO && this.egV != null;
        }
        return z;
    }

    public boolean aWF() {
        DuMixGameSurfaceView aWC;
        return (this.mIsReleased || (aWC = aWC()) == null || aWC.getParent() != null) ? false : true;
    }

    public SwanCoreVersion asA() {
        return this.mSwanCoreVersion;
    }

    @Nullable
    public ExtensionCore asB() {
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

    private void asC() {
        if (this.mExtensionCore == null || !this.mExtensionCore.isAvailable()) {
            if (DEBUG) {
                Log.w("SwanGameCoreRuntime", "updateExtensionCoreIfNeeded: ExtensionCore is invalid");
            }
            a(com.baidu.swan.apps.extcore.b.hk(1));
        }
    }

    public void f(com.baidu.swan.apps.u.c.b bVar) {
        if (this.mExtensionCore != null) {
            bVar.c(this.mExtensionCore);
        } else {
            this.mExtensionCore = bVar.asB();
        }
    }

    private boolean z(Intent intent) {
        switch (aWG()) {
            case 1:
                return true;
            case 2:
                return intent == null;
            default:
                return false;
        }
    }

    private int aWG() {
        if (this.egU < 0) {
            this.egU = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_game_preload", 0);
        }
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPreLoadABSwitch:" + this.egU);
        }
        return this.egU;
    }

    public boolean aWH() {
        boolean z = com.baidu.swan.apps.t.a.awZ().getSwitch("swan_game_startup_improvement", false);
        if (DEBUG) {
            Log.d("SwanGameCoreRuntime", "getPushFragmentABSwitch:" + z);
        }
        return z;
    }

    public void m(SwanAppActivity swanAppActivity) {
        com.baidu.swan.apps.core.d.f afX;
        if (swanAppActivity != null && !swanAppActivity.isFinishing() && (afX = swanAppActivity.afX()) != null) {
            afX.apB().af(0, 0).apG().f(j.apO()).apI();
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
    public void asq() {
        if (!this.mIsReleased && !this.cXM.isEmpty() && asn()) {
            for (InterfaceC0516a interfaceC0516a : this.cXM) {
                if (interfaceC0516a != null) {
                    interfaceC0516a.onReady();
                }
            }
            this.cXM.clear();
        }
    }

    private String aWI() {
        return (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) ? "" : this.mSwanCoreVersion.swanCorePath;
    }

    private void aWJ() {
        synchronized (this.cXT) {
            if (!this.cXO && this.egV == null) {
                asz();
                asC();
                String aWI = aWI();
                if (!TextUtils.isEmpty(aWI) && !this.mIsReleased) {
                    if (DEBUG) {
                        Log.d("SwanGameCoreRuntime", "prepareMaster start: " + aWI);
                    }
                    this.egV = new c(aWI, "swan-game.js");
                    this.egV.a(new c.InterfaceC0517c() { // from class: com.baidu.swan.games.j.a.3
                        @Override // com.baidu.swan.games.j.c.InterfaceC0517c
                        public void c(com.baidu.swan.games.f.a aVar) {
                            if (a.DEBUG) {
                                Log.d("SwanGameCoreRuntime", "prepareMaster end.");
                            }
                            synchronized (a.this.cXT) {
                                a.this.cXO = true;
                                a.this.asq();
                            }
                        }
                    });
                }
            }
        }
    }

    private void asz() {
        if (this.mSwanCoreVersion == null || !this.mSwanCoreVersion.isAvailable()) {
            a(aWK());
        }
    }

    private SwanCoreVersion aWK() {
        if (com.baidu.swan.games.k.a.c.wN("package")) {
            if (TextUtils.isEmpty(this.cTU)) {
                return null;
            }
            if (!new File(this.cTU, "swan-game.js").exists()) {
                ak.runOnUiThread(new Runnable() { // from class: com.baidu.swan.games.j.a.4
                    @Override // java.lang.Runnable
                    public void run() {
                        Toast.makeText(AppRuntime.getAppContext(), a.h.debug_game_core_package_error, 1).show();
                    }
                });
                return com.baidu.swan.apps.swancore.b.jC(1);
            }
            SwanCoreVersion swanCoreVersion = new SwanCoreVersion();
            swanCoreVersion.swanCorePath = this.cTU;
            swanCoreVersion.swanCoreType = 2;
            return swanCoreVersion;
        } else if (com.baidu.swan.games.k.a.c.wN("normal") || com.baidu.swan.apps.ad.a.a.aFh()) {
            SwanCoreVersion swanCoreVersion2 = new SwanCoreVersion();
            swanCoreVersion2.swanCorePath = com.baidu.swan.games.k.a.b.auC().getAbsolutePath();
            swanCoreVersion2.swanCoreType = 2;
            return swanCoreVersion2;
        } else {
            return com.baidu.swan.apps.swancore.b.jC(1);
        }
    }
}
