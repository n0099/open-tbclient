package com.baidu.swan.apps.ac.c.a;

import android.text.TextUtils;
import android.util.Pair;
import androidx.annotation.NonNull;
import com.baidu.swan.apps.ac.c.d.c;
import com.baidu.swan.apps.ac.c.d.e;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b rC(String str) {
        com.baidu.swan.apps.ac.c.b.b rF = rF(str);
        if (rF.aIl()) {
            com.baidu.swan.apps.ac.d.a.print(rF.toString());
            return rF.dvb;
        }
        return new e().c(rF, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b rD(String str) {
        com.baidu.swan.apps.ac.c.b.b rF = rF(str);
        if (rF.aIl()) {
            com.baidu.swan.apps.ac.d.a.print(rF.toString());
            return rF.dvb;
        }
        return new c().c(rF, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b rE(String str) {
        com.baidu.swan.apps.ac.c.b.b rF = rF(str);
        if (rF.aIl()) {
            com.baidu.swan.apps.ac.d.a.print(rF.toString());
            return rF.dvb;
        }
        return new com.baidu.swan.apps.ac.c.d.d().c(rF, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ac.c.c.a aVar) {
        if (aVar != null) {
            aVar.aIn();
        }
    }

    private com.baidu.swan.apps.ac.c.b.b rF(String str) {
        com.baidu.swan.apps.ac.c.b.b bVar = new com.baidu.swan.apps.ac.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bo = com.baidu.swan.apps.api.d.b.bo("Api-Base", str);
        bVar.dvb = (com.baidu.swan.apps.api.c.b) bo.first;
        JSONObject jSONObject = (JSONObject) bo.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.dvb = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h rH = com.baidu.swan.apps.ac.g.b.rH(optString);
        if (rH != null) {
            String str2 = rH.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.dvb = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.dvb = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.dvb = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.duX = str2;
                bVar.duY = optString;
                bVar.duZ = optString2;
                bVar.dva = optString5;
                bVar.cNP = optString3;
                bVar.cNO = optString4;
                bVar.pageParams = optJSONObject;
                bVar.cFi = optString6;
                return bVar;
            }
        }
        bVar.dvb = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
