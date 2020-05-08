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
    private com.baidu.swan.games.e.a bJF;
    private com.baidu.swan.games.binding.a bNZ = new com.baidu.swan.games.binding.a();
    private b cZB;
    private String cZC;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.bJF = g.a(WU(), new C0414a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bJF.setCodeCacheSetting(codeCacheSetting);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bJF;
    }

    public void finish() {
        this.bJF.finish();
    }

    private h WU() {
        return new h.a().hX(1).pV("master").avU();
    }

    public void a(b bVar) {
        this.cZB = bVar;
    }

    @Nullable
    public String aBw() {
        return this.cZC;
    }

    public void rv(@NonNull String str) {
        this.cZC = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0414a extends com.baidu.swan.games.e.d.a {
        private Object cZD;
        private String mBasePath;
        private String mFileName;

        C0414a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.cZD = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting WV() {
            if (com.baidu.swan.apps.w.a.abQ().dY(0)) {
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
        public String WW() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            if (this.cZD != null) {
                aVar.addJavascriptInterface(this.cZD, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (a.this.cZB != null) {
                a.this.cZB.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
