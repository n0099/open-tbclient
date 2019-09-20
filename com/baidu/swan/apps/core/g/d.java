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
    private com.baidu.swan.games.e.a asZ;
    private com.baidu.swan.games.binding.a ata = new com.baidu.swan.games.binding.a();
    private b atb;

    /* loaded from: classes2.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.asZ = f.a(Be(), new a(str, str2), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.asZ.setCodeCacheSetting(codeCacheSetting);
    }

    public void a(V8EngineConfiguration.JSCacheCallback jSCacheCallback) {
        this.asZ.a(jSCacheCallback);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.asZ;
    }

    public void finish() {
        this.asZ.finish();
    }

    private g Be() {
        return new g.a().eX(1).je("master").RT();
    }

    public void y(Activity activity) {
        this.ata.U(activity);
    }

    public void a(b bVar) {
        this.atb = bVar;
    }

    /* loaded from: classes2.dex */
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

        @Override // com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting Bf() {
            if (com.baidu.swan.apps.u.a.Er().wx()) {
                if (d.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.Y("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Bg() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String Bh() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            d.this.ata.a(aVar, com.baidu.swan.apps.u.a.Eo());
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (d.this.atb != null) {
                d.this.atb.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
