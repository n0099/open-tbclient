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
import com.baidu.swan.games.f.c.d;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
import com.baidu.swan.games.glsurface.DuMixGameSurfaceView;
import com.baidu.swan.games.inspector.SwanInspectorEndpoint;
import com.baidu.swan.games.inspector.a;
import com.baidu.swan.games.l.a;
import java.io.File;
import java.io.IOException;
/* loaded from: classes11.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a bSB;
    private com.baidu.swan.games.binding.a bXf = new com.baidu.swan.games.binding.a();
    private String bXk;
    private boolean bXl;
    private DuMixGameSurfaceView cYs;
    private InterfaceC0429c cYt;
    private boolean cYu;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0429c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        ct(str, str2);
    }

    private void ct(@NonNull String str, @NonNull String str2) {
        this.cYs = com.baidu.swan.games.glsurface.b.aAy().dn(AppRuntime.getAppContext());
        this.cYs.setRenderMode(1);
        this.bSB = g.a(ZG(), new b(str, str2), new a(this.cYs));
        this.bSB.setContext(com.baidu.swan.apps.u.a.aeR());
        this.cYs.setV8Engine(this.bSB);
    }

    private h ZG() {
        return new h.a().iq(2).rx("master").azJ();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bSB.finish();
        if (!this.cYs.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.cYs.onDestroy();
        }
    }

    public void U(Activity activity) {
        this.bXf.T(activity);
    }

    public void a(InterfaceC0429c interfaceC0429c) {
        this.cYt = interfaceC0429c;
    }

    public com.baidu.swan.games.f.a aAq() {
        return this.bSB;
    }

    public DuMixGameSurfaceView aAf() {
        return this.cYs;
    }

    public int ZJ() {
        return com.baidu.swan.apps.core.b.a.k(this.bXl, this.cYu);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bXk = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aAr();
                    c.this.aAs();
                    c.this.aAt();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bSB.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.cZy == null ? null : bVar.cZy.dbv;
                    a.C0427a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aAK().a(aVar, c.this.bSB, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aAK().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAr() {
        this.cYs.aAu();
        this.bSB.setFileSystemDelegatePolicy(new d());
        this.bSB.azx();
        this.bSB.azw();
        if (com.baidu.swan.apps.u.a.aeU().eg(1)) {
            this.bSB.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aV("gamejs", this.bXk));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAs() {
        if (DEBUG && com.baidu.swan.apps.af.a.a.ame() && new File(com.baidu.swan.games.e.b.acK(), com.baidu.swan.games.e.b.azt()).exists()) {
            this.bSB.ck(com.baidu.swan.games.e.b.acK().getAbsolutePath(), com.baidu.swan.games.e.b.azt());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aAt() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        com.baidu.swan.apps.performance.g.mp("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bSB.dispatchEvent(new com.baidu.swan.games.p.c());
        this.bSB.ck(this.bXk, "index.js");
        this.bSB.dispatchEvent(new com.baidu.swan.games.p.d());
        com.baidu.swan.apps.performance.g.mp("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bSB.onLoad();
        this.cYs.aAv();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.bXf.a(aVar, com.baidu.swan.apps.u.a.aeR());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.u.a.aeR());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            com.baidu.swan.apps.performance.g.mp("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            com.baidu.swan.apps.performance.g.mp("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.cYt != null) {
                c.this.cYt.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String ZI() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting ZH() {
            if (com.baidu.swan.apps.u.a.aeU().eg(1)) {
                return com.baidu.swan.apps.core.b.a.aV("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.bXk) && file.getCanonicalPath().startsWith(new File(c.this.bXk).getCanonicalPath())) {
                                c.this.cYu = true;
                            }
                        } else {
                            c.this.bXl = true;
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
        private DuMixGameSurfaceView bWp;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.bWp = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.bWp.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.bWp.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.bWp.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.bWp.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.bWp.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.bWp.getThread();
        }
    }
}
