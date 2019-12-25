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
/* loaded from: classes9.dex */
public class a extends c {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.b.b jN(String str) {
        com.baidu.swan.apps.ag.c.b.b jQ = jQ(str);
        if (jQ.Xr()) {
            com.baidu.swan.apps.ag.d.a.print(jQ.toString());
            return jQ.bDD;
        }
        return new e().c(jQ, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void D(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b jO(String str) {
        com.baidu.swan.apps.ag.c.b.b jQ = jQ(str);
        if (jQ.Xr()) {
            com.baidu.swan.apps.ag.d.a.print(jQ.toString());
            return jQ.bDD;
        }
        return new com.baidu.swan.apps.ag.c.d.c().c(jQ, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void D(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b jP(String str) {
        com.baidu.swan.apps.ag.c.b.b jQ = jQ(str);
        if (jQ.Xr()) {
            com.baidu.swan.apps.ag.d.a.print(jQ.toString());
            return jQ.bDD;
        }
        return new d().c(jQ, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.3
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
            aVar.Xt();
        }
    }

    private com.baidu.swan.apps.ag.c.b.b jQ(String str) {
        com.baidu.swan.apps.ag.c.b.b bVar = new com.baidu.swan.apps.ag.c.b.b();
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> ag = com.baidu.swan.apps.api.c.b.ag("Api-Base", str);
        bVar.bDD = (com.baidu.swan.apps.api.b.b) ag.first;
        JSONObject jSONObject = (JSONObject) ag.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.bDD = new com.baidu.swan.apps.api.b.b(201, "pluginProvider is empty");
            return bVar;
        }
        h jS = com.baidu.swan.apps.ag.g.b.jS(optString);
        if (jS != null) {
            String str2 = jS.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.bDD = new com.baidu.swan.apps.api.b.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.bDD = new com.baidu.swan.apps.api.b.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.bDD = new com.baidu.swan.apps.api.b.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.bDz = str2;
                bVar.bDA = optString;
                bVar.bDB = optString2;
                bVar.bDC = optString5;
                bVar.bdi = optString3;
                bVar.bdh = optString4;
                bVar.pageParams = optJSONObject;
                bVar.bqc = optString6;
                return bVar;
            }
        }
        bVar.bDD = new com.baidu.swan.apps.api.b.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
