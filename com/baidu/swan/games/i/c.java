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
    private com.baidu.swan.games.e.a blf;
    private com.baidu.swan.games.binding.a bpB = new com.baidu.swan.games.binding.a();
    private String bpG;
    private boolean bpH;

    /* renamed from: com  reason: collision with root package name */
    private DuMixGameSurfaceView f1012com;
    private InterfaceC0336c con;
    private boolean coo;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0336c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bO(str, str2);
    }

    private void bO(@NonNull String str, @NonNull String str2) {
        this.f1012com = com.baidu.swan.games.glsurface.b.aot().dx(AppRuntime.getAppContext());
        this.f1012com.setRenderMode(1);
        this.blf = g.a(Pd(), new b(str, str2), new a(this.f1012com));
        this.blf.setContext(com.baidu.swan.apps.w.a.TW());
        this.f1012com.setV8Engine(this.blf);
    }

    private h Pd() {
        return new h.a().hQ(2).oJ("master").anE();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.blf.finish();
        if (!this.f1012com.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.f1012com.onDestroy();
        }
    }

    public void aa(Activity activity) {
        this.bpB.Z(activity);
    }

    public void a(InterfaceC0336c interfaceC0336c) {
        this.con = interfaceC0336c;
    }

    public com.baidu.swan.games.e.a aol() {
        return this.blf;
    }

    public DuMixGameSurfaceView aoa() {
        return this.f1012com;
    }

    public int Pg() {
        return com.baidu.swan.apps.core.b.a.k(this.bpH, this.coo);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bpG = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aom();
                    c.this.aon();
                    c.this.aoo();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.blf.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.cpt == null ? null : bVar.cpt.cro;
                    a.C0337a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aoF().a(aVar, c.this.blf, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aoF().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aom() {
        this.f1012com.aop();
        this.blf.setFileSystemDelegatePolicy(new d());
        this.blf.ans();
        this.blf.anr();
        if (com.baidu.swan.apps.w.a.TZ().dT(1)) {
            this.blf.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.ax("gamejs", this.bpG));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aon() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aaq() && new File(com.baidu.swan.games.d.b.RT(), com.baidu.swan.games.d.b.ano()).exists()) {
            this.blf.bF(com.baidu.swan.games.d.b.RT().getAbsolutePath(), com.baidu.swan.games.d.b.ano());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoo() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.jP("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.blf.dispatchEvent(new com.baidu.swan.games.o.c());
        this.blf.bF(this.bpG, "index.js");
        this.blf.dispatchEvent(new com.baidu.swan.games.o.d());
        f.jP("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.blf.onLoad();
        this.f1012com.aoq();
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
            c.this.bpB.a(aVar, com.baidu.swan.apps.w.a.TW());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.TW());
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
            if (c.this.con != null) {
                c.this.con.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Pf() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Pe() {
            if (com.baidu.swan.apps.w.a.TZ().dT(1)) {
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
                            if (!TextUtils.isEmpty(c.this.bpG) && file.getCanonicalPath().startsWith(new File(c.this.bpG).getCanonicalPath())) {
                                c.this.coo = true;
                            }
                        } else {
                            c.this.bpH = true;
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
        private DuMixGameSurfaceView boL;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.boL = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.boL.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
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
            this.boL.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.boL.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.boL.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.boL.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.boL.getThread();
        }
    }
}
