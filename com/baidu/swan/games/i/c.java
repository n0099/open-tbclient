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
/* loaded from: classes10.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bgR;
    private com.baidu.swan.games.binding.a blp = new com.baidu.swan.games.binding.a();
    private String blu;
    private boolean blv;
    private DuMixGameSurfaceView ckg;
    private InterfaceC0326c ckh;
    private boolean cki;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0326c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bF(str, str2);
    }

    private void bF(@NonNull String str, @NonNull String str2) {
        this.ckg = com.baidu.swan.games.glsurface.b.ame().dt(AppRuntime.getAppContext());
        this.ckg.setRenderMode(1);
        this.bgR = g.a(MN(), new b(str, str2), new a(this.ckg));
        this.bgR.setContext(com.baidu.swan.apps.w.a.RG());
        this.ckg.setV8Engine(this.bgR);
    }

    private h MN() {
        return new h.a().hz(2).ou("master").alp();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bgR.finish();
        if (!this.ckg.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.ckg.onDestroy();
        }
    }

    public void Z(Activity activity) {
        this.blp.Y(activity);
    }

    public void a(InterfaceC0326c interfaceC0326c) {
        this.ckh = interfaceC0326c;
    }

    public com.baidu.swan.games.e.a alW() {
        return this.bgR;
    }

    public DuMixGameSurfaceView alL() {
        return this.ckg;
    }

    public int MQ() {
        return com.baidu.swan.apps.core.b.a.h(this.blv, this.cki);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.clm)) {
            this.blu = bVar.clm;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.alX();
                    c.this.alY();
                    c.this.alZ();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bgR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.clo == null ? null : bVar.clo.cnj;
                    a.C0327a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.amq().a(aVar, c.this.bgR, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.amq().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alX() {
        this.ckg.ama();
        this.bgR.setFileSystemDelegatePolicy(new d());
        this.bgR.alc();
        this.bgR.alb();
        if (com.baidu.swan.apps.w.a.RJ().dD(1)) {
            this.bgR.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.an("gamejs", this.blu));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alY() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.Ya() && new File(com.baidu.swan.games.d.b.PD(), com.baidu.swan.games.d.b.akY()).exists()) {
            this.bgR.bw(com.baidu.swan.games.d.b.PD().getAbsolutePath(), com.baidu.swan.games.d.b.akY());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alZ() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.jA("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bgR.dispatchEvent(new com.baidu.swan.games.o.c());
        this.bgR.bw(this.blu, "index.js");
        this.bgR.dispatchEvent(new com.baidu.swan.games.o.d());
        f.jA("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bgR.onLoad();
        this.ckg.amb();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class b extends com.baidu.swan.games.e.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            c.this.blp.a(aVar, com.baidu.swan.apps.w.a.RG());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.RG());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.i.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            f.jA("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            f.jA("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.ckh != null) {
                c.this.ckh.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String MP() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting MO() {
            if (com.baidu.swan.apps.w.a.RJ().dD(1)) {
                return com.baidu.swan.apps.core.b.a.an("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.blu) && file.getCanonicalPath().startsWith(new File(c.this.blu).getCanonicalPath())) {
                                c.this.cki = true;
                            }
                        } else {
                            c.this.blv = true;
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
        private DuMixGameSurfaceView bkz;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.bkz = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.bkz.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
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
            this.bkz.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.bkz.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.bkz.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.bkz.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.bkz.getThread();
        }
    }
}
