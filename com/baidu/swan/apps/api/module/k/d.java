package com.baidu.swan.apps.api.module.k;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import com.baidu.swan.apps.am.e.a;
import com.baidu.swan.apps.api.a.d;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.apps.api.a.d {
    public d(@NonNull com.baidu.swan.apps.api.a.b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ig(String str) {
        if (DEBUG) {
            Log.d("Api-Compass", "start listen compass");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.k.d.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(com.baidu.swan.apps.runtime.e eVar, JSONObject jSONObject, @Nullable String str2) {
                com.baidu.swan.apps.console.c.i("Api-Compass", " init ");
                final i iVar = new i("compassChange", jSONObject, str2);
                com.baidu.swan.apps.am.e.a aso = com.baidu.swan.apps.am.e.a.aso();
                aso.init(d.this.getContext());
                aso.a(new a.InterfaceC0292a() { // from class: com.baidu.swan.apps.api.module.k.d.1.1
                    @Override // com.baidu.swan.apps.am.e.a.InterfaceC0292a
                    public void b(float f, int i) {
                        com.baidu.swan.apps.console.c.i("Api-Compass", "handle compass change, angle:" + f + ",accuracy: " + i);
                        JSONObject jSONObject2 = new JSONObject();
                        try {
                            jSONObject2.put("direction", f);
                            jSONObject2.put("accuracy", com.baidu.swan.apps.am.e.a.hu(i));
                            iVar.a(d.this, jSONObject2);
                        } catch (JSONException e) {
                            com.baidu.swan.apps.console.c.e("Api-Compass", "handle compass,json error，" + e.toString());
                            iVar.a(d.this, "Json error");
                        }
                    }
                });
                com.baidu.swan.apps.console.c.i("Api-Compass", "start listen compass");
                aso.asp();
                iVar.a(d.this);
                return new com.baidu.swan.apps.api.c.b(0);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b Us() {
        if (DEBUG) {
            Log.d("Api-Compass", "stop accelerometer");
        }
        com.baidu.swan.apps.console.c.i("Api-Compass", "stop listen compass");
        com.baidu.swan.apps.am.e.a.aso().asq();
        return new com.baidu.swan.apps.api.c.b(0);
    }
}
