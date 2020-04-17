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

    public com.baidu.swan.apps.api.b.b lr(String str) {
        com.baidu.swan.apps.ag.c.b.b lu = lu(str);
        if (lu.aim()) {
            com.baidu.swan.apps.ag.d.a.print(lu.toString());
            return lu.chp;
        }
        return new e().c(lu, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void G(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b ls(String str) {
        com.baidu.swan.apps.ag.c.b.b lu = lu(str);
        if (lu.aim()) {
            com.baidu.swan.apps.ag.d.a.print(lu.toString());
            return lu.chp;
        }
        return new com.baidu.swan.apps.ag.c.d.c().c(lu, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void G(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.b.b lt(String str) {
        com.baidu.swan.apps.ag.c.b.b lu = lu(str);
        if (lu.aim()) {
            com.baidu.swan.apps.ag.d.a.print(lu.toString());
            return lu.chp;
        }
        return new d().c(lu, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ag.c.c.a>() { // from class: com.baidu.swan.apps.ag.c.a.a.3
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void G(com.baidu.swan.apps.ag.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.swan.apps.ag.c.c.a aVar) {
        if (aVar != null) {
            aVar.aio();
        }
    }

    private com.baidu.swan.apps.ag.c.b.b lu(String str) {
        com.baidu.swan.apps.ag.c.b.b bVar = new com.baidu.swan.apps.ag.c.b.b();
        Pair<com.baidu.swan.apps.api.b.b, JSONObject> az = com.baidu.swan.apps.api.c.b.az("Api-Base", str);
        bVar.chp = (com.baidu.swan.apps.api.b.b) az.first;
        JSONObject jSONObject = (JSONObject) az.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.chp = new com.baidu.swan.apps.api.b.b(201, "pluginProvider is empty");
            return bVar;
        }
        h lw = com.baidu.swan.apps.ag.g.b.lw(optString);
        if (lw != null) {
            String str2 = lw.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.chp = new com.baidu.swan.apps.api.b.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.chp = new com.baidu.swan.apps.api.b.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.chp = new com.baidu.swan.apps.api.b.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.chl = str2;
                bVar.chm = optString;
                bVar.chn = optString2;
                bVar.cho = optString5;
                bVar.bGJ = optString3;
                bVar.bGI = optString4;
                bVar.pageParams = optJSONObject;
                bVar.bTu = optString6;
                return bVar;
            }
        }
        bVar.chp = new com.baidu.swan.apps.api.b.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
