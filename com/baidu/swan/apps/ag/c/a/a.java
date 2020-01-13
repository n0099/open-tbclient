package com.baidu.swan.apps.ag.c.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.ag.c.d.d;
import com.baidu.swan.apps.ag.c.d.e;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.c;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes10.dex */
public class a extends c {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b jQ(String str) {
        com.baidu.swan.apps.ag.c.b.b jT = jT(str);
        if (jT.XO()) {
            com.baidu.swan.apps.ag.d.a.print(jT.toString());
            return jT.bEo;
        }
        return new e().c(jT, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void D(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b jR(String str) {
        com.baidu.swan.apps.ag.c.b.b jT = jT(str);
        if (jT.XO()) {
            com.baidu.swan.apps.ag.d.a.print(jT.toString());
            return jT.bEo;
        }
        return new com.baidu.swan.apps.ag.c.d.c().c(jT, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void D(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b jS(String str) {
        com.baidu.swan.apps.ag.c.b.b jT = jT(str);
        if (jT.XO()) {
            com.baidu.swan.apps.ag.d.a.print(jT.toString());
            return jT.bEo;
        }
        return new d().c(jT, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void D(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ag.c.c.a aVar) {
        if (aVar != null) {
            aVar.XQ();
        }
    }

    private com.baidu.swan.apps.ag.c.b.b jT(String str) {
        com.baidu.swan.apps.ag.c.b.b bVar = new com.baidu.swan.apps.ag.c.b.b();
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ah = com.baidu.swan.apps.api.c.b.ah("Api-Base", str);
        bVar.bEo = (com.baidu.swan.apps.api.b.b) ah.first;
        JSONObject jSONObject = (JSONObject) ah.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.bEo = new com.baidu.swan.apps.api.b.b(201, "pluginProvider is empty");
            return bVar;
        }
        h jV = com.baidu.swan.apps.ag.g.b.jV(optString);
        if (jV != null) {
            String str2 = jV.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.bEo = new com.baidu.swan.apps.api.b.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.bEo = new com.baidu.swan.apps.api.b.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.bEo = new com.baidu.swan.apps.api.b.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.bEk = str2;
                bVar.bEl = optString;
                bVar.bEm = optString2;
                bVar.bEn = optString5;
                bVar.bdW = optString3;
                bVar.bdV = optString4;
                bVar.pageParams = optJSONObject;
                bVar.bqQ = optString6;
                return bVar;
            }
        }
        bVar.bEo = new com.baidu.swan.apps.api.b.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
