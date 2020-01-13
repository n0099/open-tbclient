package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.e.h;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bgR;
    private com.baidu.swan.games.binding.a blp = new com.baidu.swan.games.binding.a();
    private b blq;

    /* loaded from: classes10.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.bgR = g.a(MN(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bgR.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.bgR.a(jSCacheCallback);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bgR;
    }

    public void finish() {
        this.bgR.finish();
    }

    private h MN() {
        return new h.a().hz(1).ou("master").alp();
    }

    public void G(Activity activity) {
        this.blp.Y(activity);
    }

    public void a(b bVar) {
        this.blq = bVar;
    }

    /* loaded from: classes10.dex */
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
        public V8EngineConfiguration.CodeCacheSetting MO() {
            if (com.baidu.swan.apps.w.a.RJ().dD(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.an("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String MP() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            d.this.blp.a(aVar, com.baidu.swan.apps.w.a.RG());
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (d.this.blq != null) {
                d.this.blq.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
