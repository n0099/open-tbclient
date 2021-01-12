package com.baidu.swan.apps.api.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cCW;
    private d cCX;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b aM(@NonNull JSONObject jSONObject);

    protected abstract boolean ajq();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.cCW = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.cCX = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cCW + " is called, can use sync mode: " + ajq() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return ajq() ? aL(jSONObject) : m(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b aL(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cCW + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b aM = aM(jSONObject);
        if (!aM.k("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cCW + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cCW + " end handle sync, result: " + aM.toString());
            return aM;
        } else {
            return aM;
        }
    }

    private com.baidu.swan.apps.api.c.b m(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cCW + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.cCW + " async callback: " + bVar.toString());
                }
                c.this.cCX.a(str, bVar);
            }
        });
        if (!a2.k("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cCW + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cCW + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
