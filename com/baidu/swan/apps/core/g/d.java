package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
/* loaded from: classes8.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cdS;
    private com.baidu.swan.games.binding.a cjw = new com.baidu.swan.games.binding.a();
    private b cjx;

    /* loaded from: classes8.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.cdS = g.a(aib(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.cdS.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.cdS.a(jSCacheCallback);
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.cdS;
    }

    public String aia() {
        return this.cdS.dqZ;
    }

    public void finish() {
        this.cdS.finish();
    }

    private h aib() {
        return new h.a().lb(1).uV(com.baidu.swan.apps.core.g.a.a.next()).aNj();
    }

    public void E(Activity activity) {
        this.cjw.T(activity);
    }

    public void a(b bVar) {
        this.cjx = bVar;
    }

    /* loaded from: classes8.dex */
    private class a extends com.baidu.swan.games.f.d.a {
        private String mBasePath;
        private String mFileName;

        public a(@NonNull String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
            if (d.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting aic() {
            if (com.baidu.swan.apps.t.a.aoM().gr(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.bg("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aid() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            d.this.cjw.a(aVar, com.baidu.swan.apps.t.a.aoJ());
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (d.this.cjx != null) {
                d.this.cjx.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
