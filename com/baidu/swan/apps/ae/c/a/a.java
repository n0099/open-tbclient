package com.baidu.swan.apps.ae.c.a;

import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.util.Pair;
import com.baidu.swan.apps.ae.c.d.c;
import com.baidu.swan.apps.ae.c.d.e;
import com.baidu.swan.apps.api.a.b;
import com.baidu.swan.apps.api.a.d;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b mQ(String str) {
        com.baidu.swan.apps.ae.c.b.b mT = mT(str);
        if (mT.amY()) {
            com.baidu.swan.apps.ae.d.a.print(mT.toString());
            return mT.cxy;
        }
        return new e().c(mT, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>() { // from class: com.baidu.swan.apps.ae.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void K(com.baidu.swan.apps.ae.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b mR(String str) {
        com.baidu.swan.apps.ae.c.b.b mT = mT(str);
        if (mT.amY()) {
            com.baidu.swan.apps.ae.d.a.print(mT.toString());
            return mT.cxy;
        }
        return new c().c(mT, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>() { // from class: com.baidu.swan.apps.ae.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void K(com.baidu.swan.apps.ae.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b mS(String str) {
        com.baidu.swan.apps.ae.c.b.b mT = mT(str);
        if (mT.amY()) {
            com.baidu.swan.apps.ae.d.a.print(mT.toString());
            return mT.cxy;
        }
        return new com.baidu.swan.apps.ae.c.d.d().c(mT, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ae.c.c.a>() { // from class: com.baidu.swan.apps.ae.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void K(com.baidu.swan.apps.ae.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ae.c.c.a aVar) {
        if (aVar != null) {
            aVar.ana();
        }
    }

    private com.baidu.swan.apps.ae.c.b.b mT(String str) {
        com.baidu.swan.apps.ae.c.b.b bVar = new com.baidu.swan.apps.ae.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> aR = com.baidu.swan.apps.api.d.b.aR("Api-Base", str);
        bVar.cxy = (com.baidu.swan.apps.api.c.b) aR.first;
        JSONObject jSONObject = (JSONObject) aR.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.cxy = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h mV = com.baidu.swan.apps.ae.g.b.mV(optString);
        if (mV != null) {
            String str2 = mV.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.cxy = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.cxy = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.cxy = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.cxu = str2;
                bVar.cxv = optString;
                bVar.cxw = optString2;
                bVar.cxx = optString5;
                bVar.bUu = optString3;
                bVar.bUt = optString4;
                bVar.pageParams = optJSONObject;
                bVar.cii = optString6;
                return bVar;
            }
        }
        bVar.cxy = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
