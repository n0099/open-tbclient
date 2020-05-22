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
    private com.baidu.swan.games.f.a bSB;
    private com.baidu.swan.games.binding.a bXf = new com.baidu.swan.games.binding.a();
    private b dkF;
    private String dkG;

    /* loaded from: classes11.dex */
    public interface b {
        void c(com.baidu.swan.games.f.a aVar);
    }

    public a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
        this.bSB = g.a(ZG(), new C0455a(str, str2, obj), null);
    }

    public void setCodeCacheSetting(V8EngineConfiguration.CodeCacheSetting codeCacheSetting) {
        this.bSB.setCodeCacheSetting(codeCacheSetting);
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

    public void a(b bVar) {
        this.dkF = bVar;
    }

    @Nullable
    public String aFo() {
        return this.dkG;
    }

    public void sY(@NonNull String str) {
        this.dkG = str;
    }

    /* renamed from: com.baidu.swan.mini.master.a$a  reason: collision with other inner class name */
    /* loaded from: classes11.dex */
    private class C0455a extends com.baidu.swan.games.f.d.a {
        private Object dkH;
        private String mBasePath;
        private String mFileName;

        C0455a(@NonNull String str, @NonNull String str2, @Nullable Object obj) {
            this.mBasePath = str;
            this.mFileName = str2;
            this.dkH = obj;
            if (a.DEBUG) {
                Log.d("SwanAppV8Master", "basePath: " + str + ", jsFile: " + str2);
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        @Nullable
        public V8EngineConfiguration.CodeCacheSetting ZH() {
            if (com.baidu.swan.apps.u.a.aeU().ee(0)) {
                if (a.DEBUG) {
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
            if (this.dkH != null) {
                aVar.addJavascriptInterface(this.dkH, "___NA_SWAN_MINI___");
            }
        }

        @Override // com.baidu.swan.games.f.d.a, com.baidu.swan.games.f.d.b
        public void b(com.baidu.swan.games.f.a aVar) {
            if (a.this.dkF != null) {
                a.this.dkF.c(aVar);
            }
            aVar.onLoad();
        }
    }
}
