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
    private com.baidu.swan.games.f.a bXp;
    private com.baidu.swan.games.binding.a cbT = new com.baidu.swan.games.binding.a();
    private String cbY;
    private boolean cbZ;
    private DuMixGameSurfaceView ddf;
    private InterfaceC0435c ddg;
    private boolean ddh;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0435c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        cv(str, str2);
    }

    private void cv(@NonNull String str, @NonNull String str2) {
        this.ddf = com.baidu.swan.games.glsurface.b.aBE().m28do(AppRuntime.getAppContext());
        this.ddf.setRenderMode(1);
        this.bXp = g.a(aaM(), new b(str, str2), new a(this.ddf));
        this.bXp.setContext(com.baidu.swan.apps.u.a.afX());
        this.ddf.setV8Engine(this.bXp);
    }

    private h aaM() {
        return new h.a().iB(2).rF("master").aAP();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bXp.finish();
        if (!this.ddf.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.ddf.onDestroy();
        }
    }

    public void U(Activity activity) {
        this.cbT.T(activity);
    }

    public void a(InterfaceC0435c interfaceC0435c) {
        this.ddg = interfaceC0435c;
    }

    public com.baidu.swan.games.f.a aBw() {
        return this.bXp;
    }

    public DuMixGameSurfaceView aBl() {
        return this.ddf;
    }

    public int aaP() {
        return com.baidu.swan.apps.core.b.a.k(this.cbZ, this.ddh);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cbY = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aBx();
                    c.this.aBy();
                    c.this.aBz();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bXp.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.dem == null ? null : bVar.dem.dgi;
                    a.C0433a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aBQ().a(aVar, c.this.bXp, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aBQ().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBx() {
        this.ddf.aBA();
        this.bXp.setFileSystemDelegatePolicy(new d());
        this.bXp.aAD();
        this.bXp.aAC();
        if (com.baidu.swan.apps.u.a.aga().er(1)) {
            this.bXp.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aX("gamejs", this.cbY));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBy() {
        if (DEBUG && com.baidu.swan.apps.af.a.a.ank() && new File(com.baidu.swan.games.e.b.adQ(), com.baidu.swan.games.e.b.aAz()).exists()) {
            this.bXp.cm(com.baidu.swan.games.e.b.adQ().getAbsolutePath(), com.baidu.swan.games.e.b.aAz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aBz() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        com.baidu.swan.apps.performance.g.mx("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bXp.dispatchEvent(new com.baidu.swan.games.p.c());
        this.bXp.cm(this.cbY, "index.js");
        this.bXp.dispatchEvent(new com.baidu.swan.games.p.d());
        com.baidu.swan.apps.performance.g.mx("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bXp.onLoad();
        this.ddf.aBB();
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
            c.this.cbT.a(aVar, com.baidu.swan.apps.u.a.afX());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.u.a.afX());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            com.baidu.swan.apps.performance.g.mx("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            com.baidu.swan.apps.performance.g.mx("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.ddg != null) {
                c.this.ddg.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aaO() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting aaN() {
            if (com.baidu.swan.apps.u.a.aga().er(1)) {
                return com.baidu.swan.apps.core.b.a.aX("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cbY) && file.getCanonicalPath().startsWith(new File(c.this.cbY).getCanonicalPath())) {
                                c.this.ddh = true;
                            }
                        } else {
                            c.this.cbZ = true;
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
        private DuMixGameSurfaceView cbd;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cbd = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cbd.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cbd.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cbd.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cbd.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cbd.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cbd.getThread();
        }
    }
}
