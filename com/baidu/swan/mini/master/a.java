package com.baidu.swan.mini.master;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.e.h;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bJA;
    private com.baidu.swan.games.binding.a bNU = new com.baidu.swan.games.binding.a();
    private b cZw;
    private String cZx;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.bJA = g.a(WV(), new C0393a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bJA.setCodeCacheSetting(codeCacheSetting);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bJA;
    }

    public void finish() {
        this.bJA.finish();
    }

    private h WV() {
        return new h.a().hX(1).pV("master").avU();
    }

    public void a(b bVar) {
        this.cZw = bVar;
    }

    @Nullable
    public String aBw() {
        return this.cZx;
    }

    public void rv(@NonNull String str) {
        this.cZx = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0393a extends com.baidu.swan.games.e.d.a {
        private Object cZy;
        private String mBasePath;
        private String mFileName;

        C0393a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.cZy = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting WW() {
            if (com.baidu.swan.apps.w.a.abR().dY(0)) {
                if (a.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.aF("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String WX() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            if (this.cZy != null) {
                aVar.addJavascriptInterface(this.cZy, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (a.this.cZw != null) {
                a.this.cZw.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
