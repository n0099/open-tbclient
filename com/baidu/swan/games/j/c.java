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
/* loaded from: classes9.dex */
public class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cOo;
    private com.baidu.swan.games.binding.a cTP = new com.baidu.swan.games.binding.a();
    private String cTU;
    private boolean cTV;
    private DuMixGameSurfaceView ehb;
    private InterfaceC0517c ehc;
    private boolean ehd;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0517c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        dc(str, str2);
    }

    private void dc(@NonNull String str, @NonNull String str2) {
        this.ehb = com.baidu.swan.games.glsurface.b.aWY().eA(AppRuntime.getAppContext());
        this.ehb.setRenderMode(1);
        this.cOo = g.a(aqm(), new b(str, str2), new a(this.ehb));
        this.cOo.setContext(com.baidu.swan.apps.t.a.awW());
        this.ehb.setV8Engine(this.cOo);
    }

    private h aqm() {
        return new h.a().ld(2).wr("master").aWh();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cOo.finish();
        if (!this.ehb.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.ehb.onDestroy();
        }
    }

    public void S(Activity activity) {
        this.cTP.R(activity);
    }

    public void a(InterfaceC0517c interfaceC0517c) {
        this.ehc = interfaceC0517c;
    }

    public com.baidu.swan.games.f.a aWQ() {
        return this.cOo;
    }

    public DuMixGameSurfaceView aWC() {
        return this.ehb;
    }

    public int aqp() {
        return com.baidu.swan.apps.core.b.a.m(this.cTV, this.ehd);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cTU = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aWR();
                    c.this.aWS();
                    c.this.aWT();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cOo.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.eih == null ? null : bVar.eih.eka;
                    a.C0515a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aXk().a(aVar, c.this.cOo, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aXk().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWR() {
        this.ehb.aWU();
        this.cOo.setFileSystemDelegatePolicy(new d());
        this.cOo.aVV();
        this.cOo.aVU();
        if (com.baidu.swan.apps.t.a.awZ().gc(1)) {
            this.cOo.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bq("gamejs", this.cTU));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWS() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aEZ() && new File(com.baidu.swan.games.e.b.auC(), com.baidu.swan.games.e.b.aVR()).exists()) {
            this.cOo.cT(com.baidu.swan.games.e.b.auC().getAbsolutePath(), com.baidu.swan.games.e.b.aVR());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWT() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.qk("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cOo.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cOo.cT(this.cTU, "index.js");
        this.cOo.dispatchEvent(new com.baidu.swan.games.p.d());
        i.qk("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cOo.onLoad();
        this.ehb.aWV();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class b extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public b(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            c.this.cTP.a(aVar, com.baidu.swan.apps.t.a.awW());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.awW());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.qk("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.qk("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.ehc != null) {
                c.this.ehc.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aqo() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting aqn() {
            if (com.baidu.swan.apps.t.a.awZ().gc(1)) {
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
                            if (!TextUtils.isEmpty(c.this.cTU) && file.getCanonicalPath().startsWith(new File(c.this.cTU).getCanonicalPath())) {
                                c.this.ehd = true;
                            }
                        } else {
                            c.this.cTV = true;
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
    /* loaded from: classes9.dex */
    public class a implements V8ThreadDelegatePolicy {
        private DuMixGameSurfaceView cSW;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cSW = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cSW.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cSW.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cSW.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cSW.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cSW.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cSW.getThread();
        }
    }
}
