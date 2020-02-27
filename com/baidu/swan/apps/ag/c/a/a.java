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
/* loaded from: classes11.dex */
public class a extends c {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b kf(String str) {
        com.baidu.swan.apps.ag.c.b.b ki = ki(str);
        if (ki.aac()) {
            com.baidu.swan.apps.ag.d.a.print(ki.toString());
            return ki.bIt;
        }
        return new e().c(ki, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void F(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b kg(String str) {
        com.baidu.swan.apps.ag.c.b.b ki = ki(str);
        if (ki.aac()) {
            com.baidu.swan.apps.ag.d.a.print(ki.toString());
            return ki.bIt;
        }
        return new com.baidu.swan.apps.ag.c.d.c().c(ki, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void F(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b kh(String str) {
        com.baidu.swan.apps.ag.c.b.b ki = ki(str);
        if (ki.aac()) {
            com.baidu.swan.apps.ag.d.a.print(ki.toString());
            return ki.bIt;
        }
        return new d().c(ki, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void F(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ag.c.c.a aVar) {
        if (aVar != null) {
            aVar.aae();
        }
    }

    private com.baidu.swan.apps.ag.c.b.b ki(String str) {
        com.baidu.swan.apps.ag.c.b.b bVar = new com.baidu.swan.apps.ag.c.b.b();
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ar = com.baidu.swan.apps.api.c.b.ar("Api-Base", str);
        bVar.bIt = (com.baidu.swan.apps.api.b.b) ar.first;
        JSONObject jSONObject = (JSONObject) ar.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.bIt = new com.baidu.swan.apps.api.b.b(201, "pluginProvider is empty");
            return bVar;
        }
        h kk = com.baidu.swan.apps.ag.g.b.kk(optString);
        if (kk != null) {
            String str2 = kk.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.bIt = new com.baidu.swan.apps.api.b.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.bIt = new com.baidu.swan.apps.api.b.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.bIt = new com.baidu.swan.apps.api.b.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.bIp = str2;
                bVar.bIq = optString;
                bVar.bIr = optString2;
                bVar.bIs = optString5;
                bVar.bil = optString3;
                bVar.bik = optString4;
                bVar.pageParams = optJSONObject;
                bVar.bva = optString6;
                return bVar;
            }
        }
        bVar.bIt = new com.baidu.swan.apps.api.b.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
