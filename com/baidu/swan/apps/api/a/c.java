package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bOA;
    private d bOB;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.swan.apps.api.c.b bVar);
    }

    protected abstract boolean UZ();

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b am(@NonNull JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.bOA = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.bOB = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bOA + " is called, can use sync mode: " + UZ() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return UZ() ? al(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b al(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bOA + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b am = am(jSONObject);
        if (!am.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bOA + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bOA + " end handle sync, result: " + am.toString());
            return am;
        } else {
            return am;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bOA + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void a(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.bOA + " async callback: " + bVar.toString());
                }
                c.this.bOB.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bOA + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bOA + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
