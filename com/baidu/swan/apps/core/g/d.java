package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
/* loaded from: classes7.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a bYi;
    private com.baidu.swan.games.binding.a cdx = new com.baidu.swan.games.binding.a();
    private b cdy;

    /* loaded from: classes7.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.bYi = g.a(abO(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bYi.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.bYi.a(jSCacheCallback);
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.bYi;
    }

    public void finish() {
        this.bYi.finish();
    }

    private h abO() {
        return new h.a().iS(1).sE("master").aEu();
    }

    public void D(Activity activity) {
        this.cdx.U(activity);
    }

    public void a(b bVar) {
        this.cdy = bVar;
    }

    /* loaded from: classes7.dex */
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
        public V8EngineConfiguration.CodeCacheSetting abP() {
            if (com.baidu.swan.apps.t.a.ahm().et(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.aZ("appframe", this.mBasePath);
            }
            return null;
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
        public void a(com.baidu.swan.games.f.a aVar) {
            d.this.cdx.a(aVar, com.baidu.swan.apps.t.a.ahj());
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (d.this.cdy != null) {
                d.this.cdy.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
