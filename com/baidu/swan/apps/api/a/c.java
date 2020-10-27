package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String crN;
    private d crO;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes10.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b aC(@NonNull JSONObject jSONObject);

    protected abstract boolean agZ();

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.crN = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.crO = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.crN + " is called, can use sync mode: " + agZ() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return agZ() ? aB(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b aB(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.crN + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b aC = aC(jSONObject);
        if (!aC.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.crN + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.crN + " end handle sync, result: " + aC.toString());
            return aC;
        } else {
            return aC;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.crN + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.crN + " async callback: " + bVar.toString());
                }
                c.this.crO.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.crN + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.crN + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
