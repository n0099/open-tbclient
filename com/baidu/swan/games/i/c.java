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
    private com.baidu.swan.games.e.a bJF;
    private com.baidu.swan.games.binding.a bNZ = new com.baidu.swan.games.binding.a();
    private String bOe;
    private boolean bOf;
    private DuMixGameSurfaceView cNA;
    private InterfaceC0387c cNB;
    private boolean cNC;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0387c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bY(str, str2);
    }

    private void bY(@NonNull String str, @NonNull String str2) {
        this.cNA = com.baidu.swan.games.glsurface.b.awJ().cY(AppRuntime.getAppContext());
        this.cNA.setRenderMode(1);
        this.bJF = g.a(WU(), new b(str, str2), new a(this.cNA));
        this.bJF.setContext(com.baidu.swan.apps.w.a.abN());
        this.cNA.setV8Engine(this.bJF);
    }

    private h WU() {
        return new h.a().hX(2).pV("master").avU();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bJF.finish();
        if (!this.cNA.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.cNA.onDestroy();
        }
    }

    public void W(Activity activity) {
        this.bNZ.V(activity);
    }

    public void a(InterfaceC0387c interfaceC0387c) {
        this.cNB = interfaceC0387c;
    }

    public com.baidu.swan.games.e.a awB() {
        return this.bJF;
    }

    public DuMixGameSurfaceView awq() {
        return this.cNA;
    }

    public int WX() {
        return com.baidu.swan.apps.core.b.a.j(this.bOf, this.cNC);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bOe = bVar.appBundlePath;
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
            this.bJF.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.cOG == null ? null : bVar.cOG.cQz;
                    a.C0388a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.awV().a(aVar, c.this.bJF, a2, runnable);
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
        this.cNA.awF();
        this.bJF.setFileSystemDelegatePolicy(new d());
        this.bJF.avI();
        this.bJF.avH();
        if (com.baidu.swan.apps.w.a.abQ().dY(1)) {
            this.bJF.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aF("gamejs", this.bOe));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awD() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aix() && new File(com.baidu.swan.games.d.b.ZK(), com.baidu.swan.games.d.b.avE()).exists()) {
            this.bJF.bP(com.baidu.swan.games.d.b.ZK().getAbsolutePath(), com.baidu.swan.games.d.b.avE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awE() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.lb("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bJF.dispatchEvent(new com.baidu.swan.games.o.c());
        this.bJF.bP(this.bOe, "index.js");
        this.bJF.dispatchEvent(new com.baidu.swan.games.o.d());
        f.lb("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bJF.onLoad();
        this.cNA.awG();
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
            c.this.bNZ.a(aVar, com.baidu.swan.apps.w.a.abN());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.abN());
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
            if (c.this.cNB != null) {
                c.this.cNB.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String WW() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting WV() {
            if (com.baidu.swan.apps.w.a.abQ().dY(1)) {
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
                            if (!TextUtils.isEmpty(c.this.bOe) && file.getCanonicalPath().startsWith(new File(c.this.bOe).getCanonicalPath())) {
                                c.this.cNC = true;
                            }
                        } else {
                            c.this.bOf = true;
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
        private DuMixGameSurfaceView bNj;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.bNj = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.bNj.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
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
            this.bNj.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.bNj.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.bNj.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.bNj.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.bNj.getThread();
        }
    }
}
