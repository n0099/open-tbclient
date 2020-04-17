package com.baidu.swan.games.i;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.searchbox.v8engine.V8Engine;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy;
import com.baidu.swan.apps.performance.HybridUbcFlow;
import com.baidu.swan.apps.performance.UbcFlowEvent;
import com.baidu.swan.apps.performance.f;
import com.baidu.swan.games.e.c.d;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.e.h;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.inspector.a;
import com.baidu.swan.games.k.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bJA;
    private com.baidu.swan.games.binding.a bNU = new com.baidu.swan.games.binding.a();
    private String bNZ;
    private boolean bOa;
    private DuMixGameSurfaceView cNu;
    private InterfaceC0366c cNv;
    private boolean cNw;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0366c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bY(str, str2);
    }

    private void bY(@NonNull String str, @NonNull String str2) {
        this.cNu = com.baidu.swan.games.glsurface.b.awJ().dk(AppRuntime.getAppContext());
        this.cNu.setRenderMode(1);
        this.bJA = g.a(WV(), new b(str, str2), new a(this.cNu));
        this.bJA.setContext(com.baidu.swan.apps.w.a.abO());
        this.cNu.setV8Engine(this.bJA);
    }

    private h WV() {
        return new h.a().hX(2).pV("master").avU();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bJA.finish();
        if (!this.cNu.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.cNu.onDestroy();
        }
    }

    public void W(Activity activity) {
        this.bNU.V(activity);
    }

    public void a(InterfaceC0366c interfaceC0366c) {
        this.cNv = interfaceC0366c;
    }

    public com.baidu.swan.games.e.a awB() {
        return this.bJA;
    }

    public DuMixGameSurfaceView awq() {
        return this.cNu;
    }

    public int WY() {
        return com.baidu.swan.apps.core.b.a.j(this.bOa, this.cNw);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bNZ = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.awC();
                    c.this.awD();
                    c.this.awE();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bJA.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.cOB == null ? null : bVar.cOB.cQu;
                    a.C0367a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.awV().a(aVar, c.this.bJA, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.awV().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awC() {
        this.cNu.awF();
        this.bJA.setFileSystemDelegatePolicy(new d());
        this.bJA.avI();
        this.bJA.avH();
        if (com.baidu.swan.apps.w.a.abR().dY(1)) {
            this.bJA.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aF("gamejs", this.bNZ));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awD() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aiy() && new File(com.baidu.swan.games.d.b.ZL(), com.baidu.swan.games.d.b.avE()).exists()) {
            this.bJA.bP(com.baidu.swan.games.d.b.ZL().getAbsolutePath(), com.baidu.swan.games.d.b.avE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awE() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.lb("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bJA.dispatchEvent(new com.baidu.swan.games.o.c());
        this.bJA.bP(this.bNZ, "index.js");
        this.bJA.dispatchEvent(new com.baidu.swan.games.o.d());
        f.lb("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bJA.onLoad();
        this.cNu.awG();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends com.baidu.swan.games.e.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            c.this.bNU.a(aVar, com.baidu.swan.apps.w.a.abO());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.abO());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.i.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            f.lb("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            f.lb("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.cNv != null) {
                c.this.cNv.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String WX() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting WW() {
            if (com.baidu.swan.apps.w.a.abR().dY(1)) {
                return com.baidu.swan.apps.core.b.a.aF("gameframe", getInitBasePath());
            }
            return null;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a(V8EngineConfiguration.CacheInfo cacheInfo) {
            if (cacheInfo != null) {
                if (c.DEBUG) {
                    Log.d("SwanGameV8Master", "onCacheResult cached:" + cacheInfo.cached + " ,jsPath: " + cacheInfo.jsPath);
                }
                if (cacheInfo.cached && !TextUtils.isEmpty(cacheInfo.jsPath)) {
                    File file = new File(cacheInfo.jsPath);
                    try {
                        if (TextUtils.isEmpty(getInitBasePath()) || !file.getCanonicalPath().startsWith(new File(getInitBasePath()).getCanonicalPath())) {
                            if (!TextUtils.isEmpty(c.this.bNZ) && file.getCanonicalPath().startsWith(new File(c.this.bNZ).getCanonicalPath())) {
                                c.this.cNw = true;
                            }
                        } else {
                            c.this.bOa = true;
                        }
                    } catch (IOException e) {
                        if (c.DEBUG) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView bNe;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.bNe = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.bNe.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "startEngineInternal");
                    }
                    v8Engine.startEngineInternal();
                }
            });
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable) {
            this.bNe.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.bNe.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.bNe.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.bNe.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.bNe.getThread();
        }
    }
}
