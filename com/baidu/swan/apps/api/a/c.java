package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bJM;
    private d bJN;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes11.dex */
    public interface a {
        void a(com.baidu.swan.apps.api.c.b bVar);
    }

    protected abstract boolean TT();

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b af(@NonNull JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.bJM = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.bJN = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bJM + " is called, can use sync mode: " + TT() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return TT() ? ae(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b ae(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bJM + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b af = af(jSONObject);
        if (!af.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bJM + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bJM + " end handle sync, result: " + af.toString());
            return af;
        } else {
            return af;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bJM + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void a(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.bJM + " async callback: " + bVar.toString());
                }
                c.this.bJN.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bJM + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bJM + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
