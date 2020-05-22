package com.baidu.swan.apps.api.module.b;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.g;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b hf(String str) {
        if (DEBUG) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.b.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable final String str2) {
                String optString = jSONObject.optString("root");
                if (TextUtils.isEmpty(optString)) {
                    c.e("Api-LoadSubPackage", "subPackage root is null");
                    return new com.baidu.swan.apps.api.c.b(202);
                } else if (eVar.nv(optString) && eVar.nw(optString)) {
                    c.i("Api-LoadSubPackage", "subPackage have existed");
                    return new com.baidu.swan.apps.api.c.b(1001, "subPackage have existed");
                } else {
                    String ny = eVar.ny(optString);
                    if (TextUtils.isEmpty(ny)) {
                        c.i("Api-LoadSubPackage", "subPackage cannot find aps key");
                        return new com.baidu.swan.apps.api.c.b(202);
                    }
                    g.a(eVar.id, eVar.getVersion(), optString, ny, null, new g.a() { // from class: com.baidu.swan.apps.api.module.b.a.1.1
                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void hg(String str3) {
                            c.i("Api-LoadSubPackage", "preload subPackage success");
                            a.this.a(str2, new com.baidu.swan.apps.api.c.b(0, "preload subPackage success"));
                        }

                        @Override // com.baidu.swan.apps.scheme.actions.k.g.a
                        public void ej(int i) {
                            c.e("Api-LoadSubPackage", "preload subPackage failed");
                            a.this.a(str2, new com.baidu.swan.apps.api.c.b(202, "No SubPackage"));
                        }
                    });
                    return new com.baidu.swan.apps.api.c.b(0);
                }
            }
        });
    }
}
