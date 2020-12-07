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
/* loaded from: classes25.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cLR;
    private com.baidu.swan.games.binding.a cRr = new com.baidu.swan.games.binding.a();
    private String cRw;
    private boolean cRx;
    private DuMixGameSurfaceView eaJ;
    private InterfaceC0544c eaK;
    private boolean eaL;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes25.dex */
    public interface InterfaceC0544c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        dk(str, str2);
    }

    private void dk(@NonNull String str, @NonNull String str2) {
        this.eaJ = com.baidu.swan.games.glsurface.b.aYl().ej(AppRuntime.getAppContext());
        this.eaJ.setRenderMode(1);
        this.cLR = g.a(asr(), new b(str, str2), new a(this.eaJ));
        this.cLR.setContext(com.baidu.swan.apps.t.a.aza());
        this.eaJ.setV8Engine(this.cLR);
    }

    private h asr() {
        return new h.a().my(2).xk("master").aXu();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cLR.finish();
        if (!this.eaJ.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.eaJ.onDestroy();
        }
    }

    public void W(Activity activity) {
        this.cRr.V(activity);
    }

    public void a(InterfaceC0544c interfaceC0544c) {
        this.eaK = interfaceC0544c;
    }

    public com.baidu.swan.games.f.a aYd() {
        return this.cLR;
    }

    public DuMixGameSurfaceView aXP() {
        return this.eaJ;
    }

    public int asu() {
        return com.baidu.swan.apps.core.b.a.l(this.cRx, this.eaL);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cRw = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aYe();
                    c.this.aYf();
                    c.this.aYg();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cLR.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.ebP == null ? null : bVar.ebP.edI;
                    a.C0542a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aYx().a(aVar, c.this.cLR, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aYx().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYe() {
        this.eaJ.aYh();
        this.cLR.setFileSystemDelegatePolicy(new d());
        this.cLR.aXi();
        this.cLR.aXh();
        if (com.baidu.swan.apps.t.a.azd().hM(1)) {
            this.cLR.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.by("gamejs", this.cRw));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYf() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aHe() && new File(com.baidu.swan.games.e.b.awF(), com.baidu.swan.games.e.b.aXe()).exists()) {
            this.cLR.db(com.baidu.swan.games.e.b.awF().getAbsolutePath(), com.baidu.swan.games.e.b.aXe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aYg() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.rk("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cLR.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cLR.db(this.cRw, "index.js");
        this.cLR.dispatchEvent(new com.baidu.swan.games.p.d());
        i.rk("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cLR.onLoad();
        this.eaJ.aYi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes25.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.cRr.a(aVar, com.baidu.swan.apps.t.a.aza());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.aza());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.rk("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.rk("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.eaK != null) {
                c.this.eaK.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String ast() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting ass() {
            if (com.baidu.swan.apps.t.a.azd().hM(1)) {
                return com.baidu.swan.apps.core.b.a.by("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cRw) && file.getCanonicalPath().startsWith(new File(c.this.cRw).getCanonicalPath())) {
                                c.this.eaL = true;
                            }
                        } else {
                            c.this.cRx = true;
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
    /* loaded from: classes25.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView cQy;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cQy = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cQy.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cQy.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cQy.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cQy.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cQy.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cQy.getThread();
        }
    }
}
