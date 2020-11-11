package com.baidu.swan.games.j;

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
import com.baidu.swan.apps.performance.i;
import com.baidu.swan.games.f.c.d;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.inspector.a;
import com.baidu.swan.games.l.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cGH;
    private com.baidu.swan.games.binding.a cMi = new com.baidu.swan.games.binding.a();
    private String cMn;
    private boolean cMo;
    private DuMixGameSurfaceView dVt;
    private InterfaceC0534c dVu;
    private boolean dVv;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0534c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        de(str, str2);
    }

    private void de(@NonNull String str, @NonNull String str2) {
        this.dVt = com.baidu.swan.games.glsurface.b.aVO().dD(AppRuntime.getAppContext());
        this.dVt.setRenderMode(1);
        this.cGH = g.a(apR(), new b(str, str2), new a(this.dVt));
        this.cGH.setContext(com.baidu.swan.apps.t.a.awA());
        this.dVt.setV8Engine(this.cGH);
    }

    private h apR() {
        return new h.a().me(2).wI("master").aUX();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cGH.finish();
        if (!this.dVt.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.dVt.onDestroy();
        }
    }

    public void X(Activity activity) {
        this.cMi.W(activity);
    }

    public void a(InterfaceC0534c interfaceC0534c) {
        this.dVu = interfaceC0534c;
    }

    public com.baidu.swan.games.f.a aVG() {
        return this.cGH;
    }

    public DuMixGameSurfaceView aVs() {
        return this.dVt;
    }

    public int apU() {
        return com.baidu.swan.apps.core.b.a.l(this.cMo, this.dVv);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cMn = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aVH();
                    c.this.aVI();
                    c.this.aVJ();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cGH.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.dWz == null ? null : bVar.dWz.dYr;
                    a.C0532a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aWa().a(aVar, c.this.cGH, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aWa().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVH() {
        this.dVt.aVK();
        this.cGH.setFileSystemDelegatePolicy(new d());
        this.cGH.aUL();
        this.cGH.aUK();
        if (com.baidu.swan.apps.t.a.awD().hs(1)) {
            this.cGH.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bs("gamejs", this.cMn));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVI() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aEE() && new File(com.baidu.swan.games.e.b.auf(), com.baidu.swan.games.e.b.aUH()).exists()) {
            this.cGH.cV(com.baidu.swan.games.e.b.auf().getAbsolutePath(), com.baidu.swan.games.e.b.aUH());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVJ() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.qJ("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cGH.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cGH.cV(this.cMn, "index.js");
        this.cGH.dispatchEvent(new com.baidu.swan.games.p.d());
        i.qJ("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cGH.onLoad();
        this.dVt.aVL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.cMi.a(aVar, com.baidu.swan.apps.t.a.awA());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.awA());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.qJ("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.qJ("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.dVu != null) {
                c.this.dVu.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String apT() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting apS() {
            if (com.baidu.swan.apps.t.a.awD().hs(1)) {
                return com.baidu.swan.apps.core.b.a.bs("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cMn) && file.getCanonicalPath().startsWith(new File(c.this.cMn).getCanonicalPath())) {
                                c.this.dVv = true;
                            }
                        } else {
                            c.this.cMo = true;
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
    /* loaded from: classes10.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView cLp;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cLp = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cLp.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cLp.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cLp.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cLp.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cLp.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cLp.getThread();
        }
    }
}
