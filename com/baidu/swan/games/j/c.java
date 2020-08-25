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
/* loaded from: classes8.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cdS;
    private String cjB;
    private boolean cjC;
    private com.baidu.swan.games.binding.a cjw = new com.baidu.swan.games.binding.a();
    private DuMixGameSurfaceView dsX;
    private InterfaceC0496c dsY;
    private boolean dsZ;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0496c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        cS(str, str2);
    }

    private void cS(@NonNull String str, @NonNull String str2) {
        this.dsX = com.baidu.swan.games.glsurface.b.aOa().dy(AppRuntime.getAppContext());
        this.dsX.setRenderMode(1);
        this.cdS = g.a(aib(), new b(str, str2), new a(this.dsX));
        this.cdS.setContext(com.baidu.swan.apps.t.a.aoJ());
        this.dsX.setV8Engine(this.cdS);
    }

    private h aib() {
        return new h.a().lb(2).uV("master").aNj();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cdS.finish();
        if (!this.dsX.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.dsX.onDestroy();
        }
    }

    public void U(Activity activity) {
        this.cjw.T(activity);
    }

    public void a(InterfaceC0496c interfaceC0496c) {
        this.dsY = interfaceC0496c;
    }

    public com.baidu.swan.games.f.a aNS() {
        return this.cdS;
    }

    public DuMixGameSurfaceView aNE() {
        return this.dsX;
    }

    public int aie() {
        return com.baidu.swan.apps.core.b.a.l(this.cjC, this.dsZ);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cjB = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aNT();
                    c.this.aNU();
                    c.this.aNV();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cdS.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.due == null ? null : bVar.due.dvW;
                    a.C0494a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aOm().a(aVar, c.this.cdS, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aOm().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNT() {
        this.dsX.aNW();
        this.cdS.setFileSystemDelegatePolicy(new d());
        this.cdS.aMX();
        this.cdS.aMW();
        if (com.baidu.swan.apps.t.a.aoM().gr(1)) {
            this.cdS.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bg("gamejs", this.cjB));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNU() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.awQ() && new File(com.baidu.swan.games.e.b.amo(), com.baidu.swan.games.e.b.aMT()).exists()) {
            this.cdS.cJ(com.baidu.swan.games.e.b.amo().getAbsolutePath(), com.baidu.swan.games.e.b.aMT());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aNV() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.oW("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cdS.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cdS.cJ(this.cjB, "index.js");
        this.cdS.dispatchEvent(new com.baidu.swan.games.p.d());
        i.oW("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cdS.onLoad();
        this.dsX.aNX();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes8.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.cjw.a(aVar, com.baidu.swan.apps.t.a.aoJ());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.aoJ());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.oW("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.oW("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.dsY != null) {
                c.this.dsY.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aid() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting aic() {
            if (com.baidu.swan.apps.t.a.aoM().gr(1)) {
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
                            if (!TextUtils.isEmpty(c.this.cjB) && file.getCanonicalPath().startsWith(new File(c.this.cjB).getCanonicalPath())) {
                                c.this.dsZ = true;
                            }
                        } else {
                            c.this.cjC = true;
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
    /* loaded from: classes8.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView ciD;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.ciD = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.ciD.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.ciD.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.ciD.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.ciD.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.ciD.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.ciD.getThread();
        }
    }
}
