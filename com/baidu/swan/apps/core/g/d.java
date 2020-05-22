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
    private com.baidu.swan.games.f.a bSB;
    private com.baidu.swan.games.binding.a bXf = new com.baidu.swan.games.binding.a();
    private b bXg;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.bSB = g.a(ZG(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bSB.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.bSB.a(jSCacheCallback);
    }

    public com.baidu.swan.games.f.a getV8Engine() {
        return this.bSB;
    }

    public void finish() {
        this.bSB.finish();
    }

    private h ZG() {
        return new h.a().io(1).rx("master").azJ();
    }

    public void E(Activity activity) {
        this.bXf.T(activity);
    }

    public void a(b bVar) {
        this.bXg = bVar;
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
        public V8EngineConfiguration.CodeCacheSetting ZH() {
            if (com.baidu.swan.apps.u.a.aeU().ee(0)) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.aV("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public String ZI() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void a(com.baidu.swan.games.f.a aVar) {
            d.this.bXf.a(aVar, com.baidu.swan.apps.u.a.aeR());
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (d.this.bXg != null) {
                d.this.bXg.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
