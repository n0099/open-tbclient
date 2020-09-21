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
/* loaded from: classes3.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cfX;
    private com.baidu.swan.games.binding.a clB = new com.baidu.swan.games.binding.a();
    private String clG;
    private boolean clH;
    private DuMixGameSurfaceView dvd;
    private InterfaceC0491c dve;
    private boolean dvf;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes3.dex */
    public interface InterfaceC0491c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        cS(str, str2);
    }

    private void cS(@NonNull String str, @NonNull String str2) {
        this.dvd = com.baidu.swan.games.glsurface.b.aOL().dx(AppRuntime.getAppContext());
        this.dvd.setRenderMode(1);
        this.cfX = g.a(aiL(), new b(str, str2), new a(this.dvd));
        this.cfX.setContext(com.baidu.swan.apps.t.a.apu());
        this.dvd.setV8Engine(this.cfX);
    }

    private h aiL() {
        return new h.a().lm(2).vp("master").aNU();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cfX.finish();
        if (!this.dvd.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.dvd.onDestroy();
        }
    }

    public void W(Activity activity) {
        this.clB.V(activity);
    }

    public void a(InterfaceC0491c interfaceC0491c) {
        this.dve = interfaceC0491c;
    }

    public com.baidu.swan.games.f.a aOD() {
        return this.cfX;
    }

    public DuMixGameSurfaceView aOp() {
        return this.dvd;
    }

    public int aiO() {
        return com.baidu.swan.apps.core.b.a.l(this.clH, this.dvf);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.clG = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aOE();
                    c.this.aOF();
                    c.this.aOG();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cfX.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.dwj == null ? null : bVar.dwj.dyb;
                    a.C0489a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aOX().a(aVar, c.this.cfX, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aOX().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOE() {
        this.dvd.aOH();
        this.cfX.setFileSystemDelegatePolicy(new d());
        this.cfX.aNI();
        this.cfX.aNH();
        if (com.baidu.swan.apps.t.a.apx().gA(1)) {
            this.cfX.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bg("gamejs", this.clG));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOF() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.axz() && new File(com.baidu.swan.games.e.b.amY(), com.baidu.swan.games.e.b.aNE()).exists()) {
            this.cfX.cJ(com.baidu.swan.games.e.b.amY().getAbsolutePath(), com.baidu.swan.games.e.b.aNE());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aOG() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.pq("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cfX.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cfX.cJ(this.clG, "index.js");
        this.cfX.dispatchEvent(new com.baidu.swan.games.p.d());
        i.pq("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cfX.onLoad();
        this.dvd.aOI();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes3.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.clB.a(aVar, com.baidu.swan.apps.t.a.apu());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.apu());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.pq("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.pq("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.dve != null) {
                c.this.dve.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aiN() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting aiM() {
            if (com.baidu.swan.apps.t.a.apx().gA(1)) {
                return com.baidu.swan.apps.core.b.a.bg("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.clG) && file.getCanonicalPath().startsWith(new File(c.this.clG).getCanonicalPath())) {
                                c.this.dvf = true;
                            }
                        } else {
                            c.this.clH = true;
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
    /* loaded from: classes3.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView ckI;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.ckI = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.ckI.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.ckI.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.ckI.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.ckI.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.ckI.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.ckI.getThread();
        }
    }
}
