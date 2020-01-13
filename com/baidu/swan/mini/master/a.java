package com.baidu.swan.mini.master;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.e.g;
import com.baidu.swan.games.e.h;
/* loaded from: classes10.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.e.a bgR;
    private com.baidu.swan.games.binding.a blp = new com.baidu.swan.games.binding.a();
    private b cwn;
    private String cwo;

    /* loaded from: classes10.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.bgR = g.a(MN(), new C0353a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bgR.setCodeCacheSetting(codeCacheSetting);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.bgR;
    }

    public void finish() {
        this.bgR.finish();
    }

    private h MN() {
        return new h.a().hz(1).ou("master").alp();
    }

    public void a(b bVar) {
        this.cwn = bVar;
    }

    @Nullable
    public String aqT() {
        return this.cwo;
    }

    public void pU(@NonNull String str) {
        this.cwo = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes10.dex */
    private class C0353a extends com.baidu.swan.games.e.d.a {
        private Object cwp;
        private String mBasePath;
        private String mFileName;

        C0353a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.cwp = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting MO() {
            if (com.baidu.swan.apps.w.a.RJ().dD(0)) {
                if (a.DEBUG) {
                    Log.d("SwanAppV8Master", "pathList item: " + this.mBasePath);
                }
                return com.baidu.swan.apps.core.b.a.an("appframe", this.mBasePath);
            }
            return null;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String getInitBasePath() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String MP() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            if (this.cwp != null) {
                aVar.addJavascriptInterface(this.cwp, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (a.this.cwn != null) {
                a.this.cwn.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
