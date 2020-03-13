package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.e.h;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a blf;
    private com.baidu.swan.games.binding.a bpB = new com.baidu.swan.games.binding.a();
    private b bpC;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.blf = g.a(Pd(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.blf.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.blf.a(jSCacheCallback);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.blf;
    }

    public void finish() {
        this.blf.finish();
    }

    private h Pd() {
        return new h.a().hQ(1).oJ("master").anE();
    }

    public void H(Activity activity) {
        this.bpB.Z(activity);
    }

    public void a(b bVar) {
        this.bpC = bVar;
    }

    /* loaded from: classes11.dex */
    private class a extends com.baidu.swan.games.e.d.a {
        private String mBasePath;
        private String mFileName;

        public a(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
            if (d.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting Pe() {
            if (com.baidu.swan.apps.w.a.TZ().dT(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.ax("appframe", this.mBasePath);
            }
            return null;
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
        public void a(com.baidu.swan.games.e.a aVar) {
            d.this.bpB.a(aVar, com.baidu.swan.apps.w.a.TW());
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (d.this.bpC != null) {
                d.this.bpC.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
