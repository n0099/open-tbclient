package com.baidu.swan.games.j;

import android.app.Activity;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
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
    private com.baidu.swan.games.f.a cPO;
    private com.baidu.swan.games.binding.a cVp = new com.baidu.swan.games.binding.a();
    private String cVu;
    private boolean cVv;
    private DuMixGameSurfaceView eiC;
    private InterfaceC0523c eiD;
    private boolean eiE;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0523c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        dc(str, str2);
    }

    private void dc(@NonNull String str, @NonNull String str2) {
        this.eiC = com.baidu.swan.games.glsurface.b.aXb().ez(AppRuntime.getAppContext());
        this.eiC.setRenderMode(1);
        this.cPO = g.a(aqp(), new b(str, str2), new a(this.eiC));
        this.cPO.setContext(com.baidu.swan.apps.t.a.awZ());
        this.eiC.setV8Engine(this.cPO);
    }

    private h aqp() {
        return new h.a().le(2).wy("master").aWk();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cPO.finish();
        if (!this.eiC.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.eiC.onDestroy();
        }
    }

    public void S(Activity activity) {
        this.cVp.R(activity);
    }

    public void a(InterfaceC0523c interfaceC0523c) {
        this.eiD = interfaceC0523c;
    }

    public com.baidu.swan.games.f.a aWT() {
        return this.cPO;
    }

    public DuMixGameSurfaceView aWF() {
        return this.eiC;
    }

    public int aqs() {
        return com.baidu.swan.apps.core.b.a.m(this.cVv, this.eiE);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cVu = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aWU();
                    c.this.aWV();
                    c.this.aWW();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cPO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.ejI == null ? null : bVar.ejI.elB;
                    a.C0521a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aXn().a(aVar, c.this.cPO, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aXn().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWU() {
        this.eiC.aWX();
        this.cPO.setFileSystemDelegatePolicy(new d());
        this.cPO.aVY();
        this.cPO.aVX();
        if (com.baidu.swan.apps.t.a.axc().gd(1)) {
            this.cPO.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bq("gamejs", this.cVu));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWV() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aFc() && new File(com.baidu.swan.games.e.b.auF(), com.baidu.swan.games.e.b.aVU()).exists()) {
            this.cPO.cT(com.baidu.swan.games.e.b.auF().getAbsolutePath(), com.baidu.swan.games.e.b.aVU());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWW() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.qr("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cPO.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cPO.cT(this.cVu, "index.js");
        this.cPO.dispatchEvent(new com.baidu.swan.games.p.d());
        i.qr("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cPO.onLoad();
        this.eiC.aWY();
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
            c.this.cVp.a(aVar, com.baidu.swan.apps.t.a.awZ());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.awZ());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.qr("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.qr("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.eiD != null) {
                c.this.eiD.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aqr() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting aqq() {
            if (com.baidu.swan.apps.t.a.axc().gd(1)) {
                return com.baidu.swan.apps.core.b.a.bq("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cVu) && file.getCanonicalPath().startsWith(new File(c.this.cVu).getCanonicalPath())) {
                                c.this.eiE = true;
                            }
                        } else {
                            c.this.cVv = true;
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
        private DuMixGameSurfaceView cUw;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cUw = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cUw.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cUw.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cUw.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cUw.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cUw.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cUw.getThread();
        }
    }
}
