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
    private com.baidu.swan.games.e.a bld;
    private b bpA;
    private com.baidu.swan.games.binding.a bpz = new com.baidu.swan.games.binding.a();

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.bld = g.a(Pb(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bld.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.bld.a(jSCacheCallback);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bld;
    }

    public void finish() {
        this.bld.finish();
    }

    private h Pb() {
        return new h.a().hQ(1).oJ("master").anC();
    }

    public void H(Activity activity) {
        this.bpz.Z(activity);
    }

    public void a(b bVar) {
        this.bpA = bVar;
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
        public V8EngineConfiguration.CodeCacheSetting Pc() {
            if (com.baidu.swan.apps.w.a.TX().dT(0)) {
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
        public String Pd() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            d.this.bpz.a(aVar, com.baidu.swan.apps.w.a.TU());
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (d.this.bpA != null) {
                d.this.bpA.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
