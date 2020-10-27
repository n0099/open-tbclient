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
    private com.baidu.swan.games.f.a cAO;
    private com.baidu.swan.games.binding.a cGp = new com.baidu.swan.games.binding.a();
    private String cGu;
    private boolean cGv;
    private DuMixGameSurfaceView dPB;
    private InterfaceC0522c dPC;
    private boolean dPD;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    public interface InterfaceC0522c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        de(str, str2);
    }

    private void de(@NonNull String str, @NonNull String str2) {
        this.dPB = com.baidu.swan.games.glsurface.b.aTo().dD(AppRuntime.getAppContext());
        this.dPB.setRenderMode(1);
        this.cAO = g.a(anq(), new b(str, str2), new a(this.dPB));
        this.cAO.setContext(com.baidu.swan.apps.t.a.aua());
        this.dPB.setV8Engine(this.cAO);
    }

    private h anq() {
        return new h.a().lU(2).wu("master").aSx();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cAO.finish();
        if (!this.dPB.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.dPB.onDestroy();
        }
    }

    public void X(Activity activity) {
        this.cGp.W(activity);
    }

    public void a(InterfaceC0522c interfaceC0522c) {
        this.dPC = interfaceC0522c;
    }

    public com.baidu.swan.games.f.a aTg() {
        return this.cAO;
    }

    public DuMixGameSurfaceView aSS() {
        return this.dPB;
    }

    public int ant() {
        return com.baidu.swan.apps.core.b.a.l(this.cGv, this.dPD);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cGu = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aTh();
                    c.this.aTi();
                    c.this.aTj();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cAO.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.dQH == null ? null : bVar.dQH.dSz;
                    a.C0520a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aTA().a(aVar, c.this.cAO, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aTA().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTh() {
        this.dPB.aTk();
        this.cAO.setFileSystemDelegatePolicy(new d());
        this.cAO.aSl();
        this.cAO.aSk();
        if (com.baidu.swan.apps.t.a.aud().hi(1)) {
            this.cAO.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bs("gamejs", this.cGu));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTi() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aCe() && new File(com.baidu.swan.games.e.b.arE(), com.baidu.swan.games.e.b.aSh()).exists()) {
            this.cAO.cV(com.baidu.swan.games.e.b.arE().getAbsolutePath(), com.baidu.swan.games.e.b.aSh());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aTj() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.qv("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cAO.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cAO.cV(this.cGu, "index.js");
        this.cAO.dispatchEvent(new com.baidu.swan.games.p.d());
        i.qv("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cAO.onLoad();
        this.dPB.aTl();
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
            c.this.cGp.a(aVar, com.baidu.swan.apps.t.a.aua());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.aua());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.qv("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.qv("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.dPC != null) {
                c.this.dPC.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String ans() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting anr() {
            if (com.baidu.swan.apps.t.a.aud().hi(1)) {
                return com.baidu.swan.apps.core.b.a.bs("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cGu) && file.getCanonicalPath().startsWith(new File(c.this.cGu).getCanonicalPath())) {
                                c.this.dPD = true;
                            }
                        } else {
                            c.this.cGv = true;
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
        private DuMixGameSurfaceView cFw;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cFw = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cFw.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cFw.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cFw.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cFw.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cFw.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cFw.getThread();
        }
    }
}
