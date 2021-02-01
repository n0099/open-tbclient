package com.baidu.swan.apps.api.a;

import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String cFs;
    private d cFt;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes9.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b aJ(@NonNull JSONObject jSONObject);

    protected abstract boolean ajO();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.cFs = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.cFt = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cFs + " is called, can use sync mode: " + ajO() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return ajO() ? aI(jSONObject) : l(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b aI(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cFs + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b aJ = aJ(jSONObject);
        if (!aJ.i("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cFs + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cFs + " end handle sync, result: " + aJ.toString());
            return aJ;
        } else {
            return aJ;
        }
    }

    private com.baidu.swan.apps.api.c.b l(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cFs + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.cFs + " async callback: " + bVar.toString());
                }
                c.this.cFt.a(str, bVar);
            }
        });
        if (!a2.i("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.cFs + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.cFs + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
