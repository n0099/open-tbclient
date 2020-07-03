package com.baidu.swan.b.d;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.ap;
import java.util.HashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes11.dex */
public class b implements ap {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<String, a> cXO = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        aqU();
    }

    private void aqU() {
        a(new com.baidu.swan.b.c.a());
        a(new com.baidu.swan.b.c.b());
        a(new com.baidu.swan.b.a.a.a());
        a(new com.baidu.swan.b.a.a.d());
        a(new com.baidu.swan.b.a.a.b());
        a(new com.baidu.swan.b.f.b.a());
        a(new com.baidu.swan.b.a.a.c());
        a(new com.baidu.swan.b.e.a());
        a(new com.baidu.swan.b.f.a.a());
    }

    public void a(a aVar) {
        if (DEBUG && TextUtils.isEmpty(aVar.name)) {
            throw new IllegalArgumentException("action name is null");
        }
        if (DEBUG && this.cXO.containsKey(aVar.name)) {
            throw new IllegalArgumentException("duplicate action: " + aVar);
        }
        this.cXO.put(aVar.name, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ap
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        return b(str, jSONObject, bVar);
    }

    private com.baidu.swan.apps.api.c.b b(String str, JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        a aVar = this.cXO.get(str);
        if (aVar != null) {
            if (DEBUG) {
                Log.i("GameCenterDispatcher", "action: " + str + " params: " + jSONObject);
            }
            return aVar.b(jSONObject, bVar);
        } else if (DEBUG) {
            throw new NullPointerException("action has not found: " + str + ", params: " + jSONObject);
        } else {
            return new com.baidu.swan.apps.api.c.b(10002, "no such api.");
        }
    }
}
