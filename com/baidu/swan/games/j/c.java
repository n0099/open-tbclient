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
/* loaded from: classes7.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cEX;
    private String cKD;
    private boolean cKE;
    private com.baidu.swan.games.binding.a cKy = new com.baidu.swan.games.binding.a();
    private DuMixGameSurfaceView dTL;
    private InterfaceC0532c dTM;
    private boolean dTN;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0532c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        dd(str, str2);
    }

    private void dd(@NonNull String str, @NonNull String str2) {
        this.dTL = com.baidu.swan.games.glsurface.b.aVg().dD(AppRuntime.getAppContext());
        this.dTL.setRenderMode(1);
        this.cEX = g.a(apj(), new b(str, str2), new a(this.dTL));
        this.cEX.setContext(com.baidu.swan.apps.t.a.avS());
        this.dTL.setV8Engine(this.cEX);
    }

    private h apj() {
        return new h.a().ma(2).wD("master").aUp();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cEX.finish();
        if (!this.dTL.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.dTL.onDestroy();
        }
    }

    public void W(Activity activity) {
        this.cKy.V(activity);
    }

    public void a(InterfaceC0532c interfaceC0532c) {
        this.dTM = interfaceC0532c;
    }

    public com.baidu.swan.games.f.a aUY() {
        return this.cEX;
    }

    public DuMixGameSurfaceView aUK() {
        return this.dTL;
    }

    public int apm() {
        return com.baidu.swan.apps.core.b.a.l(this.cKE, this.dTN);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cKD = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aUZ();
                    c.this.aVa();
                    c.this.aVb();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cEX.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.dUR == null ? null : bVar.dUR.dWJ;
                    a.C0530a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aVs().a(aVar, c.this.cEX, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aVs().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aUZ() {
        this.dTL.aVc();
        this.cEX.setFileSystemDelegatePolicy(new d());
        this.cEX.aUd();
        this.cEX.aUc();
        if (com.baidu.swan.apps.t.a.avV().ho(1)) {
            this.cEX.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.br("gamejs", this.cKD));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVa() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aDW() && new File(com.baidu.swan.games.e.b.atx(), com.baidu.swan.games.e.b.aTZ()).exists()) {
            this.cEX.cU(com.baidu.swan.games.e.b.atx().getAbsolutePath(), com.baidu.swan.games.e.b.aTZ());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aVb() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.qD("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cEX.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cEX.cU(this.cKD, "index.js");
        this.cEX.dispatchEvent(new com.baidu.swan.games.p.d());
        i.qD("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cEX.onLoad();
        this.dTL.aVd();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.cKy.a(aVar, com.baidu.swan.apps.t.a.avS());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.avS());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.qD("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.qD("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.dTM != null) {
                c.this.dTM.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String apl() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting apk() {
            if (com.baidu.swan.apps.t.a.avV().ho(1)) {
                return com.baidu.swan.apps.core.b.a.br("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cKD) && file.getCanonicalPath().startsWith(new File(c.this.cKD).getCanonicalPath())) {
                                c.this.dTN = true;
                            }
                        } else {
                            c.this.cKE = true;
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
    /* loaded from: classes7.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView cJF;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cJF = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cJF.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cJF.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cJF.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cJF.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cJF.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cJF.getThread();
        }
    }
}
