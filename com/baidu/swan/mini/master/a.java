package com.baidu.swan.mini.master;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.searchbox.v8engine.V8EngineConfiguration;
import com.baidu.swan.games.f.g;
import com.baidu.swan.games.f.h;
/* loaded from: classes11.dex */
public class a {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private com.baidu.swan.games.f.a bXp;
    private com.baidu.swan.games.binding.a cbT = new com.baidu.swan.games.binding.a();
    private b dpq;
    private String dpr;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.bXp = g.a(aaM(), new C0461a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bXp.setCodeCacheSetting(codeCacheSetting);
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

    public void a(b bVar) {
        this.dpq = bVar;
    }

    @Nullable
    public String aGu() {
        return this.dpr;
    }

    public void tg(@NonNull String str) {
        this.dpr = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0461a extends com.baidu.swan.games.f.d.a {
        private Object dps;
        private String mBasePath;
        private String mFileName;

        C0461a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.dps = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting aaN() {
            if (com.baidu.swan.apps.u.a.aga().er(0)) {
                if (a.DEBUG) {
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
            if (this.dps != null) {
                aVar.addJavascriptInterface(this.dps, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (a.this.dpq != null) {
                a.this.dpq.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
