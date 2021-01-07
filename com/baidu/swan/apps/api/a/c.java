package com.baidu.swan.apps.api.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cHI;
    private d cHJ;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b aM(@NonNull JSONObject jSONObject);

    protected abstract boolean ank();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.cHI = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.cHJ = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cHI + " is called, can use sync mode: " + ank() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return ank() ? aL(jSONObject) : m(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b aL(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cHI + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b aM = aM(jSONObject);
        if (!aM.k("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cHI + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cHI + " end handle sync, result: " + aM.toString());
            return aM;
        } else {
            return aM;
        }
    }

    private com.baidu.swan.apps.api.c.b m(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cHI + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.cHI + " async callback: " + bVar.toString());
                }
                c.this.cHJ.a(str, bVar);
            }
        });
        if (!a2.k("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cHI + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cHI + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
