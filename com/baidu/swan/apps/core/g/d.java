package com.baidu.swan.apps.core.g;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.e.f;
import com.baidu.swan.games.e.g;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a arY;
    private com.baidu.swan.games.binding.a arZ = new com.baidu.swan.games.binding.a();
    private b asa;

    /* loaded from: classes2.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.arY = f.a(As(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.arY.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.arY.a(jSCacheCallback);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.arY;
    }

    public void finish() {
        this.arY.finish();
    }

    private g As() {
        return new g.a().eS(1).iU("master").QW();
    }

    public void v(Activity activity) {
        this.arZ.R(activity);
    }

    public void a(b bVar) {
        this.asa = bVar;
    }

    /* loaded from: classes2.dex */
    private class a extends com.baidu.swan.games.e.d.a {
        private String mBasePath;
        private String mFileName;

        public a(String str, @NonNull String str2) {
            this.mBasePath = str;
            this.mFileName = str2;
            if (d.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting At() {
            if (com.baidu.swan.apps.u.a.DE().vS()) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.Y("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Au() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Av() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            d.this.arZ.a(aVar, com.baidu.swan.apps.u.a.DB());
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (d.this.asa != null) {
                d.this.asa.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
