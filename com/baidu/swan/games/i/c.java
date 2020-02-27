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
    private com.baidu.swan.games.e.a bld;
    private String bpE;
    private boolean bpF;
    private com.baidu.swan.games.binding.a bpz = new com.baidu.swan.games.binding.a();
    private DuMixGameSurfaceView cok;
    private InterfaceC0336c col;

    /* renamed from: com  reason: collision with root package name */
    private boolean f1013com;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0336c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bO(str, str2);
    }

    private void bO(@NonNull String str, @NonNull String str2) {
        this.cok = com.baidu.swan.games.glsurface.b.aor().dx(AppRuntime.getAppContext());
        this.cok.setRenderMode(1);
        this.bld = g.a(Pb(), new b(str, str2), new a(this.cok));
        this.bld.setContext(com.baidu.swan.apps.w.a.TU());
        this.cok.setV8Engine(this.bld);
    }

    private h Pb() {
        return new h.a().hQ(2).oJ("master").anC();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bld.finish();
        if (!this.cok.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.cok.onDestroy();
        }
    }

    public void aa(Activity activity) {
        this.bpz.Z(activity);
    }

    public void a(InterfaceC0336c interfaceC0336c) {
        this.col = interfaceC0336c;
    }

    public com.baidu.swan.games.e.a aoj() {
        return this.bld;
    }

    public DuMixGameSurfaceView anY() {
        return this.cok;
    }

    public int Pe() {
        return com.baidu.swan.apps.core.b.a.j(this.bpF, this.f1013com);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bpE = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aok();
                    c.this.aol();
                    c.this.aom();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bld.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.cpr == null ? null : bVar.cpr.crm;
                    a.C0337a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aoD().a(aVar, c.this.bld, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aoD().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aok() {
        this.cok.aon();
        this.bld.setFileSystemDelegatePolicy(new d());
        this.bld.anq();
        this.bld.anp();
        if (com.baidu.swan.apps.w.a.TX().dT(1)) {
            this.bld.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ax("gamejs", this.bpE));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aol() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aao() && new File(com.baidu.swan.games.d.b.RR(), com.baidu.swan.games.d.b.anm()).exists()) {
            this.bld.bF(com.baidu.swan.games.d.b.RR().getAbsolutePath(), com.baidu.swan.games.d.b.anm());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aom() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.jP("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bld.dispatchEvent(new com.baidu.swan.games.o.c());
        this.bld.bF(this.bpE, "index.js");
        this.bld.dispatchEvent(new com.baidu.swan.games.o.d());
        f.jP("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bld.onLoad();
        this.cok.aoo();
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
            c.this.bpz.a(aVar, com.baidu.swan.apps.w.a.TU());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.TU());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.i.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            f.jP("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            f.jP("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.col != null) {
                c.this.col.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Pd() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Pc() {
            if (com.baidu.swan.apps.w.a.TX().dT(1)) {
                return com.baidu.swan.apps.core.b.a.ax("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.bpE) && file.getCanonicalPath().startsWith(new File(c.this.bpE).getCanonicalPath())) {
                                c.this.f1013com = true;
                            }
                        } else {
                            c.this.bpF = true;
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
        private DuMixGameSurfaceView boJ;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.boJ = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.boJ.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
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
            this.boJ.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.boJ.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.boJ.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.boJ.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.boJ.getThread();
        }
    }
}
