package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
/* loaded from: classes11.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a bXp;
    private com.baidu.swan.games.binding.a cbT = new com.baidu.swan.games.binding.a();
    private b cbU;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.bXp = g.a(aaM(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bXp.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.bXp.a(jSCacheCallback);
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.bXp;
    }

    public void finish() {
        this.bXp.finish();
    }

    private h aaM() {
        return new h.a().iB(1).rF("master").aAP();
    }

    public void E(Activity activity) {
        this.cbT.T(activity);
    }

    public void a(b bVar) {
        this.cbU = bVar;
    }

    /* loaded from: classes11.dex */
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
        public V8EngineConfiguration.CodeCacheSetting aaN() {
            if (com.baidu.swan.apps.u.a.aga().er(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.aX("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String aaO() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            d.this.cbT.a(aVar, com.baidu.swan.apps.u.a.afX());
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (d.this.cbU != null) {
                d.this.cbU.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
