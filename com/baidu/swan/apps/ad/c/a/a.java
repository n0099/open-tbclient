package com.baidu.swan.apps.ad.c.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.ad.c.d.c;
import com.baidu.swan.apps.ad.c.d.e;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b nx(String str) {
        com.baidu.swan.apps.ad.c.b.b nA = nA(str);
        if (nA.aoH()) {
            com.baidu.swan.apps.ad.d.a.print(nA.toString());
            return nA.czY;
        }
        return new e().c(nA, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>() { // from class: com.baidu.swan.apps.ad.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void J(com.baidu.swan.apps.ad.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b ny(String str) {
        com.baidu.swan.apps.ad.c.b.b nA = nA(str);
        if (nA.aoH()) {
            com.baidu.swan.apps.ad.d.a.print(nA.toString());
            return nA.czY;
        }
        return new c().c(nA, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>() { // from class: com.baidu.swan.apps.ad.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void J(com.baidu.swan.apps.ad.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b nz(String str) {
        com.baidu.swan.apps.ad.c.b.b nA = nA(str);
        if (nA.aoH()) {
            com.baidu.swan.apps.ad.d.a.print(nA.toString());
            return nA.czY;
        }
        return new com.baidu.swan.apps.ad.c.d.d().c(nA, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ad.c.c.a>() { // from class: com.baidu.swan.apps.ad.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void J(com.baidu.swan.apps.ad.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ad.c.c.a aVar) {
        if (aVar != null) {
            aVar.aoJ();
        }
    }

    private com.baidu.swan.apps.ad.c.b.b nA(String str) {
        com.baidu.swan.apps.ad.c.b.b bVar = new com.baidu.swan.apps.ad.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aS = com.baidu.swan.apps.api.d.b.aS("Api-Base", str);
        bVar.czY = (com.baidu.swan.apps.api.c.b) aS.first;
        JSONObject jSONObject = (JSONObject) aS.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.czY = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h nC = com.baidu.swan.apps.ad.g.b.nC(optString);
        if (nC != null) {
            String str2 = nC.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.czY = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.czY = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.czY = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.czU = str2;
                bVar.czV = optString;
                bVar.czW = optString2;
                bVar.czX = optString5;
                bVar.bVm = optString3;
                bVar.bVl = optString4;
                bVar.pageParams = optJSONObject;
                bVar.ckg = optString6;
                return bVar;
            }
        }
        bVar.czY = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
