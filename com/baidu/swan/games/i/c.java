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
    private com.baidu.swan.games.e.a bls;
    private com.baidu.swan.games.binding.a bpN = new com.baidu.swan.games.binding.a();
    private String bpS;
    private boolean bpT;
    private DuMixGameSurfaceView cox;
    private InterfaceC0336c coy;
    private boolean coz;

    /* renamed from: com.baidu.swan.games.i.c$c  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    public interface InterfaceC0336c {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        bN(str, str2);
    }

    private void bN(@NonNull String str, @NonNull String str2) {
        this.cox = com.baidu.swan.games.glsurface.b.aow().dw(AppRuntime.getAppContext());
        this.cox.setRenderMode(1);
        this.bls = g.a(Pg(), new b(str, str2), new a(this.cox));
        this.bls.setContext(com.baidu.swan.apps.w.a.TZ());
        this.cox.setV8Engine(this.bls);
    }

    private h Pg() {
        return new h.a().hQ(2).oI("master").anH();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bls.finish();
        if (!this.cox.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.cox.onDestroy();
        }
    }

    public void aa(Activity activity) {
        this.bpN.Z(activity);
    }

    public void a(InterfaceC0336c interfaceC0336c) {
        this.coy = interfaceC0336c;
    }

    public com.baidu.swan.games.e.a aoo() {
        return this.bls;
    }

    public DuMixGameSurfaceView aod() {
        return this.cox;
    }

    public int Pj() {
        return com.baidu.swan.apps.core.b.a.k(this.bpT, this.coz);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.bpS = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.i.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aop();
                    c.this.aoq();
                    c.this.aor();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bls.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.i.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.cpF == null ? null : bVar.cpF.crz;
                    a.C0337a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aoI().a(aVar, c.this.bls, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aoI().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aop() {
        this.cox.aos();
        this.bls.setFileSystemDelegatePolicy(new d());
        this.bls.anv();
        this.bls.anu();
        if (com.baidu.swan.apps.w.a.Uc().dT(1)) {
            this.bls.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aw("gamejs", this.bpS));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aoq() {
        if (DEBUG && com.baidu.swan.apps.ah.a.a.aat() && new File(com.baidu.swan.games.d.b.RW(), com.baidu.swan.games.d.b.anr()).exists()) {
            this.bls.bE(com.baidu.swan.games.d.b.RW().getAbsolutePath(), com.baidu.swan.games.d.b.anr());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aor() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        f.jO("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bls.dispatchEvent(new com.baidu.swan.games.o.c());
        this.bls.bE(this.bpS, "index.js");
        this.bls.dispatchEvent(new com.baidu.swan.games.o.d());
        f.jO("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bls.onLoad();
        this.cox.aot();
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
            c.this.bpN.a(aVar, com.baidu.swan.apps.w.a.TZ());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.w.a.TZ());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.i.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            f.jO("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            f.jO("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.coy != null) {
                c.this.coy.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Pi() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public V8EngineConfiguration.CodeCacheSetting Ph() {
            if (com.baidu.swan.apps.w.a.Uc().dT(1)) {
                return com.baidu.swan.apps.core.b.a.aw("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.bpS) && file.getCanonicalPath().startsWith(new File(c.this.bpS).getCanonicalPath())) {
                                c.this.coz = true;
                            }
                        } else {
                            c.this.bpT = true;
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
        private DuMixGameSurfaceView boX;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.boX = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.boX.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.i.c.a.1
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
            this.boX.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.boX.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.boX.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.boX.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.boX.getThread();
        }
    }
}
