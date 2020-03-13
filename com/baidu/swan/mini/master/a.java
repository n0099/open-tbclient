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
    private com.baidu.swan.games.e.a blf;
    private com.baidu.swan.games.binding.a bpB = new com.baidu.swan.games.binding.a();
    private b cAn;
    private String cAo;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.e.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.blf = g.a(Pd(), new C0363a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.blf.setCodeCacheSetting(codeCacheSetting);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.blf;
    }

    public void finish() {
        this.blf.finish();
    }

    private h Pd() {
        return new h.a().hQ(1).oJ("master").anE();
    }

    public void a(b bVar) {
        this.cAn = bVar;
    }

    @Nullable
    public String atj() {
        return this.cAo;
    }

    public void qj(@NonNull String str) {
        this.cAo = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0363a extends com.baidu.swan.games.e.d.a {
        private Object cAp;
        private String mBasePath;
        private String mFileName;

        C0363a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.cAp = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting Pe() {
            if (com.baidu.swan.apps.w.a.TZ().dT(0)) {
                if (a.DEBUG) {
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
        public String Pf() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            if (this.cAp != null) {
                aVar.addJavascriptInterface(this.cAp, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void b(com.baidu.swan.games.e.a aVar) {
            if (a.this.cAn != null) {
                a.this.cAn.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
