package com.baidu.swan.mini.master;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
/* loaded from: classes7.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a bYi;
    private com.baidu.swan.games.binding.a cdx = new com.baidu.swan.games.binding.a();
    private b dvh;
    private String dvi;

    /* loaded from: classes7.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.bYi = g.a(abO(), new C0473a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bYi.setCodeCacheSetting(codeCacheSetting);
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

    public void a(b bVar) {
        this.dvh = bVar;
    }

    @Nullable
    public String aKl() {
        return this.dvi;
    }

    public void uj(@NonNull String str) {
        this.dvi = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes7.dex */
    private class C0473a extends com.baidu.swan.games.f.d.a {
        private Object dvj;
        private String mBasePath;
        private String mFileName;

        C0473a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.dvj = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting abP() {
            if (com.baidu.swan.apps.t.a.ahm().et(0)) {
                if (a.DEBUG) {
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
            if (this.dvj != null) {
                aVar.addJavascriptInterface(this.dvj, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (a.this.dvh != null) {
                a.this.dvh.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
