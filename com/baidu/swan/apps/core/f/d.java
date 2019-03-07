package com.baidu.swan.apps.core.f;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.util.Log;
import com.baidu.swan.games.e.f;
import com.baidu.swan.games.e.g;
/* loaded from: classes2.dex */
public class d {
    private static final boolean DEBUG = com.baidu.swan.apps.c.DEBUG;
    private com.baidu.swan.games.e.a arM;
    private com.baidu.swan.games.binding.a arN = new com.baidu.swan.games.binding.a();
    private b arO;

    /* loaded from: classes2.dex */
    public interface b {
    }

    public d(@NonNull String str, @NonNull String str2) {
        this.arM = f.a(zt(), new a(str, str2), null);
    }

    public com.baidu.swan.games.e.a getV8Engine() {
        return this.arM;
    }

    public void finish() {
        this.arM.finish();
    }

    private g zt() {
        return new g.a().eD(1).il("master").Od();
    }

    public void v(Activity activity) {
        this.arN.P(activity);
    }

    public void a(b bVar) {
        this.arO = bVar;
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

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String zu() {
            return this.mBasePath;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public String zv() {
            return this.mFileName;
        }

        @Override // com.baidu.swan.games.e.d.a, com.baidu.swan.games.e.d.b
        public void a(com.baidu.swan.games.e.a aVar) {
            d.this.arN.a(aVar, com.baidu.swan.apps.u.a.Cy());
        }
    }
}
