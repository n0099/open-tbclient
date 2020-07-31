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
    private com.baidu.swan.games.f.a bYi;
    private String cdC;
    private boolean cdD;
    private com.baidu.swan.games.binding.a cdx = new com.baidu.swan.games.binding.a();
    private DuMixGameSurfaceView diQ;
    private InterfaceC0448c diR;
    private boolean diS;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    public interface InterfaceC0448c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        cy(str, str2);
    }

    private void cy(@NonNull String str, @NonNull String str2) {
        this.diQ = com.baidu.swan.games.glsurface.b.aFl().ds(AppRuntime.getAppContext());
        this.diQ.setRenderMode(1);
        this.bYi = g.a(abO(), new b(str, str2), new a(this.diQ));
        this.bYi.setContext(com.baidu.swan.apps.t.a.ahj());
        this.diQ.setV8Engine(this.bYi);
    }

    private h abO() {
        return new h.a().iS(2).sE("master").aEu();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.bYi.finish();
        if (!this.diQ.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.diQ.onDestroy();
        }
    }

    public void V(Activity activity) {
        this.cdx.U(activity);
    }

    public void a(InterfaceC0448c interfaceC0448c) {
        this.diR = interfaceC0448c;
    }

    public com.baidu.swan.games.f.a aFd() {
        return this.bYi;
    }

    public DuMixGameSurfaceView aEQ() {
        return this.diQ;
    }

    public int abR() {
        return com.baidu.swan.apps.core.b.a.k(this.cdD, this.diS);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cdC = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aFe();
                    c.this.aFf();
                    c.this.aFg();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.bYi.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.djW == null ? null : bVar.djW.dlR;
                    a.C0446a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aFx().a(aVar, c.this.bYi, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aFx().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFe() {
        this.diQ.aFh();
        this.bYi.setFileSystemDelegatePolicy(new d());
        this.bYi.aEi();
        this.bYi.aEh();
        if (com.baidu.swan.apps.t.a.ahm().et(1)) {
            this.bYi.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.aZ("gamejs", this.cdC));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFf() {
        if (DEBUG && com.baidu.swan.apps.ae.a.a.aoT() && new File(com.baidu.swan.games.e.b.afh(), com.baidu.swan.games.e.b.aEe()).exists()) {
            this.bYi.cp(com.baidu.swan.games.e.b.afh().getAbsolutePath(), com.baidu.swan.games.e.b.aEe());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aFg() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.mX("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.bYi.dispatchEvent(new com.baidu.swan.games.p.c());
        this.bYi.cp(this.cdC, "index.js");
        this.bYi.dispatchEvent(new com.baidu.swan.games.p.d());
        i.mX("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.bYi.onLoad();
        this.diQ.aFi();
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
            c.this.cdx.a(aVar, com.baidu.swan.apps.t.a.ahj());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.ahj());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.mX("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.mX("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.diR != null) {
                c.this.diR.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String abQ() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting abP() {
            if (com.baidu.swan.apps.t.a.ahm().et(1)) {
                return com.baidu.swan.apps.core.b.a.aZ("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cdC) && file.getCanonicalPath().startsWith(new File(c.this.cdC).getCanonicalPath())) {
                                c.this.diS = true;
                            }
                        } else {
                            c.this.cdD = true;
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
        private DuMixGameSurfaceView ccG;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.ccG = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.ccG.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.ccG.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.ccG.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.ccG.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.ccG.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.ccG.getThread();
        }
    }
}
