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
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b pv(String str) {
        com.baidu.swan.apps.ac.c.b.b py = py(str);
        if (py.awE()) {
            com.baidu.swan.apps.ac.d.a.print(py.toString());
            return py.cIh;
        }
        return new e().c(py, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void K(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b pw(String str) {
        com.baidu.swan.apps.ac.c.b.b py = py(str);
        if (py.awE()) {
            com.baidu.swan.apps.ac.d.a.print(py.toString());
            return py.cIh;
        }
        return new c().c(py, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void K(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b px(String str) {
        com.baidu.swan.apps.ac.c.b.b py = py(str);
        if (py.awE()) {
            com.baidu.swan.apps.ac.d.a.print(py.toString());
            return py.cIh;
        }
        return new com.baidu.swan.apps.ac.c.d.d().c(py, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void K(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ac.c.c.a aVar) {
        if (aVar != null) {
            aVar.awG();
        }
    }

    private com.baidu.swan.apps.ac.c.b.b py(String str) {
        com.baidu.swan.apps.ac.c.b.b bVar = new com.baidu.swan.apps.ac.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aX = com.baidu.swan.apps.api.d.b.aX("Api-Base", str);
        bVar.cIh = (com.baidu.swan.apps.api.c.b) aX.first;
        JSONObject jSONObject = (JSONObject) aX.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.cIh = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h pA = com.baidu.swan.apps.ac.g.b.pA(optString);
        if (pA != null) {
            String str2 = pA.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.cIh = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.cIh = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.cIh = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.cId = str2;
                bVar.cIe = optString;
                bVar.cIf = optString2;
                bVar.cIg = optString5;
                bVar.caU = optString3;
                bVar.caT = optString4;
                bVar.pageParams = optJSONObject;
                bVar.bSt = optString6;
                return bVar;
            }
        }
        bVar.cIh = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
