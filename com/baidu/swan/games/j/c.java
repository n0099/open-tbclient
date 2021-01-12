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
    private com.baidu.swan.games.f.a cMa;
    private com.baidu.swan.games.binding.a cRC = new com.baidu.swan.games.binding.a();
    private String cRH;
    private boolean cRI;
    private DuMixGameSurfaceView eeT;
    private InterfaceC0520c eeU;
    private boolean eeV;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes8.dex */
    public interface InterfaceC0520c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        di(str, str2);
    }

    private void di(@NonNull String str, @NonNull String str2) {
        this.eeT = com.baidu.swan.games.glsurface.b.aWM().eB(AppRuntime.getAppContext());
        this.eeT.setRenderMode(1);
        this.cMa = g.a(apO(), new b(str, str2), new a(this.eeT));
        this.cMa.setContext(com.baidu.swan.apps.t.a.awy());
        this.eeT.setV8Engine(this.cMa);
    }

    private h apO() {
        return new h.a().la(2).vY("master").aVV();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cMa.finish();
        if (!this.eeT.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.eeT.onDestroy();
        }
    }

    public void Y(Activity activity) {
        this.cRC.X(activity);
    }

    public void a(InterfaceC0520c interfaceC0520c) {
        this.eeU = interfaceC0520c;
    }

    public com.baidu.swan.games.f.a aWE() {
        return this.cMa;
    }

    public DuMixGameSurfaceView aWq() {
        return this.eeT;
    }

    public int apR() {
        return com.baidu.swan.apps.core.b.a.l(this.cRI, this.eeV);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cRH = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.aWF();
                    c.this.aWG();
                    c.this.aWH();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cMa.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.efZ == null ? null : bVar.efZ.ehT;
                    a.C0518a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.aWY().a(aVar, c.this.cMa, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.aWY().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWF() {
        this.eeT.aWI();
        this.cMa.setFileSystemDelegatePolicy(new d());
        this.cMa.aVJ();
        this.cMa.aVI();
        if (com.baidu.swan.apps.t.a.awB().fZ(1)) {
            this.cMa.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bw("gamejs", this.cRH));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWG() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aEE() && new File(com.baidu.swan.games.e.b.aue(), com.baidu.swan.games.e.b.aVF()).exists()) {
            this.cMa.cZ(com.baidu.swan.games.e.b.aue().getAbsolutePath(), com.baidu.swan.games.e.b.aVF());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWH() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.pS("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cMa.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cMa.cZ(this.cRH, "index.js");
        this.cMa.dispatchEvent(new com.baidu.swan.games.p.d());
        i.pS("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cMa.onLoad();
        this.eeT.aWJ();
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
            c.this.cRC.a(aVar, com.baidu.swan.apps.t.a.awy());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.awy());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.pS("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.pS("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.eeU != null) {
                c.this.eeU.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String apQ() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting apP() {
            if (com.baidu.swan.apps.t.a.awB().fZ(1)) {
                return com.baidu.swan.apps.core.b.a.bw("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cRH) && file.getCanonicalPath().startsWith(new File(c.this.cRH).getCanonicalPath())) {
                                c.this.eeV = true;
                            }
                        } else {
                            c.this.cRI = true;
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
        private DuMixGameSurfaceView cQJ;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cQJ = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cQJ.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cQJ.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cQJ.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cQJ.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cQJ.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cQJ.getThread();
        }
    }
}
