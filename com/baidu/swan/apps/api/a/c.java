package com.baidu.swan.apps.api.a;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public abstract class c {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private String bWX;
    private d bWY;

    /* JADX INFO: Access modifiers changed from: protected */
    /* loaded from: classes3.dex */
    public interface a {
        void b(com.baidu.swan.apps.api.c.b bVar);
    }

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull a aVar);

    protected abstract boolean act();

    @NonNull
    protected abstract com.baidu.swan.apps.api.c.b as(@NonNull JSONObject jSONObject);

    /* JADX INFO: Access modifiers changed from: protected */
    public c(@NonNull String str) {
        this.bWX = str;
    }

    public com.baidu.swan.apps.api.c.b a(@NonNull JSONObject jSONObject, @NonNull String str, @NonNull d dVar) {
        this.bWY = dVar;
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bWX + " is called, can use sync mode: " + act() + ", params" + jSONObject.toString() + ", callback: " + str);
        }
        return act() ? ar(jSONObject) : p(jSONObject, str);
    }

    private com.baidu.swan.apps.api.c.b ar(@NonNull JSONObject jSONObject) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bWX + " start handle sync");
        }
        com.baidu.swan.apps.api.c.b as = as(jSONObject);
        if (!as.l("isSync", true)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bWX + " handleSync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bWX + " end handle sync, result: " + as.toString());
            return as;
        } else {
            return as;
        }
    }

    private com.baidu.swan.apps.api.c.b p(@NonNull JSONObject jSONObject, @Nullable final String str) {
        if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bWX + " start handle async");
        }
        com.baidu.swan.apps.api.c.b a2 = a(jSONObject, new a() { // from class: com.baidu.swan.apps.api.a.c.1
            @Override // com.baidu.swan.apps.api.a.c.a
            public void b(com.baidu.swan.apps.api.c.b bVar) {
                if (c.DEBUG) {
                    Log.d("SwanAutoSyncApiHandler", c.this.bWX + " async callback: " + bVar.toString());
                }
                c.this.bWY.a(str, bVar);
            }
        });
        if (!a2.l("isSync", false)) {
            if (DEBUG) {
                Log.e("SwanAutoSyncApiHandler", this.bWX + " handleAsync encounter error, json exception");
            }
            return new com.baidu.swan.apps.api.c.b(1001, "make result json error");
        } else if (DEBUG) {
            Log.d("SwanAutoSyncApiHandler", this.bWX + " end handle async, processing in other thread, sync result: " + a2.toString());
            return a2;
        } else {
            return a2;
        }
    }
}
