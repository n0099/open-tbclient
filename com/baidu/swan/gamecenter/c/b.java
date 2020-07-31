package com.baidu.swan.gamecenter.c;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.adaptation.a.ar;
import com.baidu.swan.gamecenter.appmanager.a.f;
import java.util.HashMap;
import org.json.JSONObject;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class b implements ar {
    private static final boolean DEBUG = com.baidu.swan.apps.b.DEBUG;
    private HashMap<String, a> ddy = new HashMap<>();

    /* JADX INFO: Access modifiers changed from: package-private */
    public b() {
        asD();
    }

    private void asD() {
        a(new com.baidu.swan.gamecenter.b.a());
        a(new com.baidu.swan.gamecenter.b.b());
        a(new com.baidu.swan.gamecenter.appmanager.a.b());
        a(new com.baidu.swan.gamecenter.appmanager.a.e());
        a(new com.baidu.swan.gamecenter.appmanager.a.c());
        a(new com.baidu.swan.gamecenter.e.b.a());
        a(new com.baidu.swan.gamecenter.appmanager.a.d());
        a(new com.baidu.swan.gamecenter.d.a());
        a(new com.baidu.swan.gamecenter.e.a.a());
        a(new com.baidu.swan.gamecenter.appmanager.a.a());
        a(new f());
    }

    public void a(a aVar) {
        if (DEBUG && TextUtils.isEmpty(aVar.name)) {
            throw new IllegalArgumentException("action name is null");
        }
        if (DEBUG && this.ddy.containsKey(aVar.name)) {
            throw new IllegalArgumentException("duplicate action: " + aVar);
        }
        this.ddy.put(aVar.name, aVar);
    }

    @Override // com.baidu.swan.apps.adaptation.a.ar
    public com.baidu.swan.apps.api.c.b a(@NonNull String str, @NonNull JSONObject jSONObject, @NonNull com.baidu.swan.apps.n.b bVar) {
        return b(str, jSONObject, bVar);
    }

    private com.baidu.swan.apps.api.c.b b(String str, JSONObject jSONObject, com.baidu.swan.apps.n.b bVar) {
        a aVar = this.ddy.get(str);
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
