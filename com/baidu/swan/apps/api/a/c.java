package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bUS;
    private d bUT;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes8.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    protected abstract boolean abK();

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b ap(@NonNull JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.bUS = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.bUT = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bUS + " is called, can use sync mode: " + abK() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return abK() ? ao(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b ao(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bUS + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b ap = ap(jSONObject);
        if (!ap.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bUS + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bUS + " end handle sync, result: " + ap.toString());
            return ap;
        } else {
            return ap;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bUS + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.bUS + " async callback: " + bVar.toString());
                }
                c.this.bUT.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bUS + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bUS + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
