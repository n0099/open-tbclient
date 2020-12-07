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
/* loaded from: classes25.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b rJ(String str) {
        com.baidu.swan.apps.ac.c.b.b rM = rM(str);
        if (rM.aGS()) {
            com.baidu.swan.apps.ac.d.a.print(rM.toString());
            return rM.dqc;
        }
        return new e().c(rM, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void O(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b rK(String str) {
        com.baidu.swan.apps.ac.c.b.b rM = rM(str);
        if (rM.aGS()) {
            com.baidu.swan.apps.ac.d.a.print(rM.toString());
            return rM.dqc;
        }
        return new c().c(rM, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void O(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b rL(String str) {
        com.baidu.swan.apps.ac.c.b.b rM = rM(str);
        if (rM.aGS()) {
            com.baidu.swan.apps.ac.d.a.print(rM.toString());
            return rM.dqc;
        }
        return new com.baidu.swan.apps.ac.c.d.d().c(rM, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.3
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
            aVar.aGU();
        }
    }

    private com.baidu.swan.apps.ac.c.b.b rM(String str) {
        com.baidu.swan.apps.ac.c.b.b bVar = new com.baidu.swan.apps.ac.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bp = com.baidu.swan.apps.api.d.b.bp("Api-Base", str);
        bVar.dqc = (com.baidu.swan.apps.api.c.b) bp.first;
        JSONObject jSONObject = (JSONObject) bp.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.dqc = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h rO = com.baidu.swan.apps.ac.g.b.rO(optString);
        if (rO != null) {
            String str2 = rO.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.dqc = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.dqc = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.dqc = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.dpY = str2;
                bVar.dpZ = optString;
                bVar.dqa = optString2;
                bVar.dqb = optString5;
                bVar.cIW = optString3;
                bVar.cIV = optString4;
                bVar.pageParams = optJSONObject;
                bVar.cAs = optString6;
                return bVar;
            }
        }
        bVar.dqc = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
