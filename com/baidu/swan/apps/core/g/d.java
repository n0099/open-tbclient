package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
/* loaded from: classes10.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a cGH;
    private com.baidu.swan.games.binding.a cMi = new com.baidu.swan.games.binding.a();
    private b cMj;

    /* loaded from: classes10.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.cGH = g.a(apR(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.cGH.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.cGH.a(jSCacheCallback);
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.cGH;
    }

    public String apQ() {
        return this.cGH.dTx;
    }

    public void finish() {
        this.cGH.finish();
    }

    private h apR() {
        return new h.a().me(1).wI(com.baidu.swan.apps.core.g.a.a.next()).aUX();
    }

    public void G(Activity activity) {
        this.cMi.W(activity);
    }

    public void a(b bVar) {
        this.cMj = bVar;
    }

    /* loaded from: classes10.dex */
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
        public V8EngineConfiguration.CodeCacheSetting apS() {
            if (com.baidu.swan.apps.t.a.awD().hs(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.bs("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String apT() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            d.this.cMi.a(aVar, com.baidu.swan.apps.t.a.awA());
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (d.this.cMj != null) {
                d.this.cMj.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
