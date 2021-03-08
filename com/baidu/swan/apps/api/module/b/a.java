package com.baidu.swan.apps.api.module.b;

import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.searchbox.elasticthread.ExecutorUtilsExt;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.apps.console.c;
import com.baidu.swan.apps.runtime.e;
import com.baidu.swan.apps.scheme.actions.k.g;
import org.json.JSONObject;
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ko(String str) {
        if (DEBUG) {
            Log.d("Api-LoadSubPackage", "start pre load sub package");
        }
        return a(str, true, new d.a() { // from class: com.baidu.swan.apps.api.module.b.a.1
            @Override // com.baidu.swan.apps.api.a.d.a
            public com.baidu.swan.apps.api.c.b a(e eVar, JSONObject jSONObject, @Nullable String str2) {
                String optString = jSONObject.optString("root");
                if (!TextUtils.isEmpty(optString)) {
                    a.this.a(eVar, optString, str2);
                    return new com.baidu.swan.apps.api.c.b(0);
                }
                c.e("Api-LoadSubPackage", "subPackage root is null");
                return new com.baidu.swan.apps.api.c.b(202);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(final e eVar, final String str, @Nullable final String str2) {
        ExecutorUtilsExt.postOnElastic(new Runnable() { // from class: com.baidu.swan.apps.api.module.b.a.2
            @Override // java.lang.Runnable
            public void run() {
                if (eVar.rJ(str) && eVar.rK(str)) {
                    c.i("Api-LoadSubPackage", "subPackage have existed");
                    a.this.a(str2, new com.baidu.swan.apps.api.c.b(1001, "subPackage have existed"));
                    return;
                }
                String rL = eVar.rL(str);
                if (!TextUtils.isEmpty(rL)) {
                    a.this.a(eVar, str, rL, str2);
                    return;
                }
                c.i("Api-LoadSubPackage", "subPackage cannot find aps key");
                a.this.a(str2, new com.baidu.swan.apps.api.c.b(202));
            }
        }, "doLoadSubPackageAsync", 2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(e eVar, String str, String str2, @Nullable final String str3) {
        g.a(eVar.id, eVar.getVersion(), str, str2, null, new g.a() { // from class: com.baidu.swan.apps.api.module.b.a.3
            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void kp(String str4) {
                c.i("Api-LoadSubPackage", "preload subPackage success");
                a.this.a(str3, new com.baidu.swan.apps.api.c.b(0, "preload subPackage success"));
            }

            @Override // com.baidu.swan.apps.scheme.actions.k.g.a
            public void gh(int i) {
                c.e("Api-LoadSubPackage", "preload subPackage failed");
                a.this.a(str3, new com.baidu.swan.apps.api.c.b(202, "No SubPackage"));
            }
        });
    }
}
