package com.baidu.swan.apps.api.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cGS;
    private d cGT;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b aL(@NonNull JSONObject jSONObject);

    protected abstract boolean ajR();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.cGS = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.cGT = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cGS + " is called, can use sync mode: " + ajR() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return ajR() ? aK(jSONObject) : l(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b aK(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cGS + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b aL = aL(jSONObject);
        if (!aL.j("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cGS + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cGS + " end handle sync, result: " + aL.toString());
            return aL;
        } else {
            return aL;
        }
    }

    private com.baidu.swan.apps.api.c.b l(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cGS + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.cGS + " async callback: " + bVar.toString());
                }
                c.this.cGT.a(str, bVar);
            }
        });
        if (!a2.j("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cGS + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cGS + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
