package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.al.e.a;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b jV(String str) {
        if (DEBUG) {
            Log.d("Api-Compass", "start listen compass");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.d.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable String str2) {
                com.baidu.swan.apps.console.c.i("Api-Compass", " init ");
                final k kVar = new k("compassChange", jSONObject, str2);
                com.baidu.swan.apps.al.e.a aDE = com.baidu.swan.apps.al.e.a.aDE();
                aDE.init(d.this.getContext());
                aDE.a(new a.InterfaceC0340a() { // from class: com.baidu.swan.apps.api.module.k.d.1.1
                    @Override // com.baidu.swan.apps.al.e.a.InterfaceC0340a
                    public void b(float f, int i) {
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("direction", f);
                            jSONObject2.put("accuracy", com.baidu.swan.apps.al.e.a.jZ(i));
                            kVar.a(d.this, jSONObject2);
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Api-Compass", "handle compass,json error，" + e.toString());
                            kVar.a(d.this, "Json error");
                        }
                    }
                });
                com.baidu.swan.apps.console.c.i("Api-Compass", "start listen compass");
                aDE.aDF();
                kVar.a(d.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b ack() {
        if (DEBUG) {
            Log.d("Api-Compass", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Compass", "stop listen compass");
        com.baidu.swan.apps.al.e.a.aDE().aDG();
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
