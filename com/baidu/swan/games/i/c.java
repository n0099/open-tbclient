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
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bgb;
    private com.baidu.swan.games.binding.a bkA = new com.baidu.swan.games.binding.a();
    private String bkF;
    private boolean bkG;
    private DuMixGameSurfaceView cjT;
    private InterfaceC0324c cjU;
    private boolean cjV;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0324c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bE(str, str2);
    }

    private void bE(@NonNull String str, @NonNull String str2) {
        this.cjT = com.baidu.swan.games.glsurface.b.alL().dt(AppRuntime.getAppContext());
        this.cjT.setRenderMode(1);
        this.bgb = g.a(Mr(), new b(str, str2), new a(this.cjT));
        this.bgb.setContext(com.baidu.swan.apps.w.a.Rk());
        this.cjT.setV8Engine(this.bgb);
    }

    private h Mr() {
        return new h.a().hz(2).or("master").akW();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bgb.finish();
        if (!this.cjT.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.cjT.onDestroy();
        }
    }

    public void Y(Activity activity) {
        this.bkA.X(activity);
    }

    public void a(InterfaceC0324c interfaceC0324c) {
        this.cjU = interfaceC0324c;
    }

    public com.baidu.swan.games.e.a alD() {
        return this.bgb;
    }

    public DuMixGameSurfaceView als() {
        return this.cjT;
    }

    public int Mu() {
        return com.baidu.swan.apps.core.b.a.i(this.bkG, this.cjV);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.ckZ)) {
            this.bkF = bVar.ckZ;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.alE();
                    c.this.alF();
                    c.this.alG();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bgb.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.clb == null ? null : bVar.clb.cmW;
                    a.C0325a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.alX().a(aVar, c.this.bgb, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.alX().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alE() {
        this.cjT.alH();
        this.bgb.setFileSystemDelegatePolicy(new d());
        this.bgb.akJ();
        this.bgb.akI();
        if (com.baidu.swan.apps.w.a.Rn().dC(1)) {
            this.bgb.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.am("gamejs", this.bkF));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alF() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.XD() && new File(com.baidu.swan.games.d.b.Ph(), com.baidu.swan.games.d.b.akF()).exists()) {
            this.bgb.bv(com.baidu.swan.games.d.b.Ph().getAbsolutePath(), com.baidu.swan.games.d.b.akF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void alG() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.jx("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bgb.dispatchEvent(new com.baidu.swan.games.o.c());
        this.bgb.bv(this.bkF, "index.js");
        this.bgb.dispatchEvent(new com.baidu.swan.games.o.d());
        f.jx("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bgb.onLoad();
        this.cjT.alI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends com.baidu.swan.games.e.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            c.this.bkA.a(aVar, com.baidu.swan.apps.w.a.Rk());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.Rk());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.i.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            f.jx("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            f.jx("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.cjU != null) {
                c.this.cjU.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Mt() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Ms() {
            if (com.baidu.swan.apps.w.a.Rn().dC(1)) {
                return com.baidu.swan.apps.core.b.a.am("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.bkF) && file.getCanonicalPath().startsWith(new File(c.this.bkF).getCanonicalPath())) {
                                c.this.cjV = true;
                            }
                        } else {
                            c.this.bkG = true;
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
    /* loaded from: classes9.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView bjK;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.bjK = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.bjK.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
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
            this.bjK.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.bjK.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.bjK.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.bjK.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.bjK.getThread();
        }
    }
}
