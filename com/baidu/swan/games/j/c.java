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
    private com.baidu.swan.games.f.a cQM;
    private com.baidu.swan.games.binding.a cWo = new com.baidu.swan.games.binding.a();
    private String cWt;
    private boolean cWu;
    private DuMixGameSurfaceView ejG;
    private InterfaceC0537c ejH;
    private boolean ejI;

    /* renamed from: com.baidu.swan.games.j.c$c  reason: collision with other inner class name */
    /* loaded from: classes9.dex */
    public interface InterfaceC0537c {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public c(@NonNull String str, @NonNull String str2) {
        dj(str, str2);
    }

    private void dj(@NonNull String str, @NonNull String str2) {
        this.ejG = com.baidu.swan.games.glsurface.b.baG().eC(AppRuntime.getAppContext());
        this.ejG.setRenderMode(1);
        this.cQM = g.a(atJ(), new b(str, str2), new a(this.ejG));
        this.cQM.setContext(com.baidu.swan.apps.t.a.aAs());
        this.ejG.setV8Engine(this.cQM);
    }

    private h atJ() {
        return new h.a().mG(2).xj("master").aZP();
    }

    public void finish() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish engine");
        }
        this.cQM.finish();
        if (!this.ejG.isAttachedToWindow()) {
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime finish surfaceView");
            }
            this.ejG.onDestroy();
        }
    }

    public void Y(Activity activity) {
        this.cWo.X(activity);
    }

    public void a(InterfaceC0537c interfaceC0537c) {
        this.ejH = interfaceC0537c;
    }

    public com.baidu.swan.games.f.a bay() {
        return this.cQM;
    }

    public DuMixGameSurfaceView bak() {
        return this.ejG;
    }

    public int atM() {
        return com.baidu.swan.apps.core.b.a.l(this.cWu, this.ejI);
    }

    public void b(final a.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(bVar.appBundlePath)) {
            this.cWt = bVar.appBundlePath;
            final Runnable runnable = new Runnable() { // from class: com.baidu.swan.games.j.c.1
                @Override // java.lang.Runnable
                public void run() {
                    c.this.baz();
                    c.this.baA();
                    c.this.baB();
                }
            };
            if (DEBUG) {
                Log.d("SwanGameV8Master", "SwanGameCoreRuntime loadAppJs run event");
            }
            this.cQM.runOnJSThread(new Runnable() { // from class: com.baidu.swan.games.j.c.2
                @Override // java.lang.Runnable
                public void run() {
                    if (c.DEBUG) {
                        Log.d("SwanGameV8Master", "SwanGameCoreRuntime JSThread run event start");
                    }
                    com.baidu.swan.games.inspector.a aVar = bVar.ekM == null ? null : bVar.ekM.emF;
                    a.C0535a a2 = com.baidu.swan.games.inspector.a.a(aVar);
                    if (a2.isEnabled()) {
                        SwanInspectorEndpoint.baS().a(aVar, c.this.cQM, a2, runnable);
                        return;
                    }
                    SwanInspectorEndpoint.baS().a(a2);
                    runnable.run();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baz() {
        this.ejG.baC();
        this.cQM.setFileSystemDelegatePolicy(new d());
        this.cQM.aZD();
        this.cQM.aZC();
        if (com.baidu.swan.apps.t.a.aAv().hG(1)) {
            this.cQM.setCodeCacheSetting(com.baidu.swan.apps.core.b.a.bx("gamejs", this.cWt));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baA() {
        if (DEBUG && com.baidu.swan.apps.ad.a.a.aIy() && new File(com.baidu.swan.games.e.b.axY(), com.baidu.swan.games.e.b.aZz()).exists()) {
            this.cQM.da(com.baidu.swan.games.e.b.axY().getAbsolutePath(), com.baidu.swan.games.e.b.aZz());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baB() {
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js start.");
        }
        i.rd("startup").a(HybridUbcFlow.SubmitStrategy.NA_ONLY).f(new UbcFlowEvent("na_load_index_js_start"));
        this.cQM.dispatchEvent(new com.baidu.swan.games.p.c());
        this.cQM.da(this.cWt, "index.js");
        this.cQM.dispatchEvent(new com.baidu.swan.games.p.d());
        i.rd("startup").f(new UbcFlowEvent("na_load_index_js_end"));
        if (DEBUG) {
            Log.d("SwanGameV8Master", "SwanGameCoreRuntime load index.js end.");
        }
        this.cQM.onLoad();
        this.ejG.baD();
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
            c.this.cWo.a(aVar, com.baidu.swan.apps.t.a.aAs());
            new com.baidu.swan.games.binding.b().a(aVar, com.baidu.swan.apps.t.a.aAs());
            aVar.a(new V8EngineConfiguration.JSCacheCallback() { // from class: com.baidu.swan.games.j.c.b.1
                @Override // com.baidu.searchbox.v8engine.V8EngineConfiguration.JSCacheCallback
                public void onCacheResult(V8EngineConfiguration.CacheInfo cacheInfo) {
                    b.this.a(cacheInfo);
                }
            });
            i.rd("preload").f(new UbcFlowEvent("na_load_swan_game_js_start"));
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            i.rd("preload").f(new UbcFlowEvent("na_load_swan_game_js_end"));
            if (c.this.ejH != null) {
                c.this.ejH.c(aVar);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String atL() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public V8EngineConfiguration.CodeCacheSetting atK() {
            if (com.baidu.swan.apps.t.a.aAv().hG(1)) {
                return com.baidu.swan.apps.core.b.a.bx("gameframe", getInitBasePath());
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
                            if (!TextUtils.isEmpty(c.this.cWt) && file.getCanonicalPath().startsWith(new File(c.this.cWt).getCanonicalPath())) {
                                c.this.ejI = true;
                            }
                        } else {
                            c.this.cWu = true;
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
        private DuMixGameSurfaceView cVv;

        a(DuMixGameSurfaceView duMixGameSurfaceView) {
            this.cVv = duMixGameSurfaceView;
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void startV8Engine(final V8Engine v8Engine) {
            if (c.DEBUG) {
                Log.d("SwanGameV8Master", "startV8Engine");
            }
            this.cVv.runOnGLThread(new Runnable() { // from class: com.baidu.swan.games.j.c.a.1
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
            this.cVv.queueEvent(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnable(Runnable runnable, long j) {
            this.cVv.queueEvent(runnable, j);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void doDelegateRunnableDirectly(Runnable runnable) {
            this.cVv.runOnGLThread(runnable);
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public void shutdown() {
            this.cVv.clearOldEvents();
        }

        @Override // com.baidu.searchbox.v8engine.thread.V8ThreadDelegatePolicy
        public Thread getThread() {
            return this.cVv.getThread();
        }
    }
}
