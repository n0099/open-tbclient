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
    private com.baidu.swan.games.f.a cso;
    private com.baidu.swan.games.binding.a cxT = new com.baidu.swan.games.binding.a();
    private String cxY;
    private boolean cxZ;
    private DuMixGameSurfaceView dHe;
    private InterfaceC0508c dHf;
    private boolean dHg;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0508c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        cX(str, str2);
    }

    private void cX(@NonNull String str, @NonNull String str2) {
        this.dHe = com.baidu.swan.games.glsurface.b.aRu().dD(AppRuntime.getAppContext());
        this.dHe.setRenderMode(1);
        this.cso = g.a(alw(), new b(str, str2), new a(this.dHe));
        this.cso.setContext(com.baidu.swan.apps.t.a.asf());
        this.dHe.setV8Engine(this.cso);
    }

    private h alw() {
        return new h.a().lJ(2).wb("master").aQD();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cso.finish();
        if (!this.dHe.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.dHe.onDestroy();
        }
    }

    public void X(Activity activity) {
        this.cxT.W(activity);
    }

    public void a(InterfaceC0508c interfaceC0508c) {
        this.dHf = interfaceC0508c;
    }

    public com.baidu.swan.games.f.a aRm() {
        return this.cso;
    }

    public DuMixGameSurfaceView aQY() {
        return this.dHe;
    }

    public int alz() {
        return com.baidu.swan.apps.core.b.a.l(this.cxZ, this.dHg);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cxY = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aRn();
                    c.this.aRo();
                    c.this.aRp();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cso.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.dIk == null ? null : bVar.dIk.dKc;
                    a.C0506a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aRG().a(aVar, c.this.cso, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aRG().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRn() {
        this.dHe.aRq();
        this.cso.setFileSystemDelegatePolicy(new d());
        this.cso.aQr();
        this.cso.aQq();
        if (com.baidu.swan.apps.t.a.asi().gX(1)) {
            this.cso.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bl("gamejs", this.cxY));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRo() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aAk() && new File(com.baidu.swan.games.e.b.apK(), com.baidu.swan.games.e.b.aQn()).exists()) {
            this.cso.cO(com.baidu.swan.games.e.b.apK().getAbsolutePath(), com.baidu.swan.games.e.b.aQn());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aRp() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.qc("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cso.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cso.cO(this.cxY, "index.js");
        this.cso.dispatchEvent(new com.baidu.swan.games.p.d());
        i.qc("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cso.onLoad();
        this.dHe.aRr();
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
            c.this.cxT.a(aVar, com.baidu.swan.apps.t.a.asf());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.asf());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.qc("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.qc("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.dHf != null) {
                c.this.dHf.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aly() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting alx() {
            if (com.baidu.swan.apps.t.a.asi().gX(1)) {
                return com.baidu.swan.apps.core.b.a.bl("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cxY) && file.getCanonicalPath().startsWith(new File(c.this.cxY).getCanonicalPath())) {
                                c.this.dHg = true;
                            }
                        } else {
                            c.this.cxZ = true;
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
        private DuMixGameSurfaceView cxa;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cxa = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cxa.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cxa.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cxa.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cxa.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cxa.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cxa.getThread();
        }
    }
}
