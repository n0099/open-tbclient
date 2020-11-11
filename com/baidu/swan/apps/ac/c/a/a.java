package com.baidu.swan.apps.ac.c.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.ac.c.d.c;
import com.baidu.swan.apps.ac.c.d.e;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b ri(String str) {
        com.baidu.swan.apps.ac.c.b.b rl = rl(str);
        if (rl.aEs()) {
            com.baidu.swan.apps.ac.d.a.print(rl.toString());
            return rl.dkK;
        }
        return new e().c(rl, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void O(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b rj(String str) {
        com.baidu.swan.apps.ac.c.b.b rl = rl(str);
        if (rl.aEs()) {
            com.baidu.swan.apps.ac.d.a.print(rl.toString());
            return rl.dkK;
        }
        return new c().c(rl, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void O(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b rk(String str) {
        com.baidu.swan.apps.ac.c.b.b rl = rl(str);
        if (rl.aEs()) {
            com.baidu.swan.apps.ac.d.a.print(rl.toString());
            return rl.dkK;
        }
        return new com.baidu.swan.apps.ac.c.d.d().c(rl, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void O(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ac.c.c.a aVar) {
        if (aVar != null) {
            aVar.aEu();
        }
    }

    private com.baidu.swan.apps.ac.c.b.b rl(String str) {
        com.baidu.swan.apps.ac.c.b.b bVar = new com.baidu.swan.apps.ac.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bj = com.baidu.swan.apps.api.d.b.bj("Api-Base", str);
        bVar.dkK = (com.baidu.swan.apps.api.c.b) bj.first;
        JSONObject jSONObject = (JSONObject) bj.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.dkK = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h rn = com.baidu.swan.apps.ac.g.b.rn(optString);
        if (rn != null) {
            String str2 = rn.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.dkK = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.dkK = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.dkK = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.dkG = str2;
                bVar.dkH = optString;
                bVar.dkI = optString2;
                bVar.dkJ = optString5;
                bVar.cDL = optString3;
                bVar.cDK = optString4;
                bVar.pageParams = optJSONObject;
                bVar.cvk = optString6;
                return bVar;
            }
        }
        bVar.dkK = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
