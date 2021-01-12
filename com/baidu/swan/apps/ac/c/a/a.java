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
/* loaded from: classes8.dex */
public class a extends d {
    public a(@NonNull b bVar) {
        super(bVar);
    }

    public com.baidu.swan.apps.api.c.b qr(String str) {
        com.baidu.swan.apps.ac.c.b.b qu = qu(str);
        if (qu.aEs()) {
            com.baidu.swan.apps.ac.d.a.print(qu.toString());
            return qu.dqm;
        }
        return new e().c(qu, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b qs(String str) {
        com.baidu.swan.apps.ac.c.b.b qu = qu(str);
        if (qu.aEs()) {
            com.baidu.swan.apps.ac.d.a.print(qu.toString());
            return qu.dqm;
        }
        return new c().c(qu, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.swan.apps.core.f.b
            /* renamed from: b */
            public void N(com.baidu.swan.apps.ac.c.c.a aVar) {
                a.this.a(aVar);
            }
        });
    }

    public com.baidu.swan.apps.api.c.b qt(String str) {
        com.baidu.swan.apps.ac.c.b.b qu = qu(str);
        if (qu.aEs()) {
            com.baidu.swan.apps.ac.d.a.print(qu.toString());
            return qu.dqm;
        }
        return new com.baidu.swan.apps.ac.c.d.d().c(qu, new com.baidu.swan.apps.core.f.b<com.baidu.swan.apps.ac.c.c.a>() { // from class: com.baidu.swan.apps.ac.c.a.a.3
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
            aVar.aEu();
        }
    }

    private com.baidu.swan.apps.ac.c.b.b qu(String str) {
        com.baidu.swan.apps.ac.c.b.b bVar = new com.baidu.swan.apps.ac.c.b.b();
        Pair<com.baidu.swan.apps.api.c.b, JSONObject> bn = com.baidu.swan.apps.api.d.b.bn("Api-Base", str);
        bVar.dqm = (com.baidu.swan.apps.api.c.b) bn.first;
        JSONObject jSONObject = (JSONObject) bn.second;
        if (jSONObject == null) {
            return bVar;
        }
        String optString = jSONObject.optString("pluginProvider");
        if (TextUtils.isEmpty(optString)) {
            bVar.dqm = new com.baidu.swan.apps.api.c.b(201, "pluginProvider is empty");
            return bVar;
        }
        h qw = com.baidu.swan.apps.ac.g.b.qw(optString);
        if (qw != null) {
            String str2 = qw.appKey;
            if (!TextUtils.isEmpty(str2)) {
                String optString2 = jSONObject.optString("providerRootPath");
                if (TextUtils.isEmpty(optString2)) {
                    bVar.dqm = new com.baidu.swan.apps.api.c.b(201, "providerRootPath is empty");
                    return bVar;
                }
                String optString3 = jSONObject.optString("slaveId");
                if (TextUtils.isEmpty(optString3)) {
                    bVar.dqm = new com.baidu.swan.apps.api.c.b(201, "slaveId is empty");
                    return bVar;
                }
                String optString4 = jSONObject.optString("componentId");
                if (TextUtils.isEmpty(optString4)) {
                    bVar.dqm = new com.baidu.swan.apps.api.c.b(201, "componentId is empty");
                    return bVar;
                }
                String optString5 = jSONObject.optString("pluginVersion", "release");
                if (TextUtils.isEmpty(optString5)) {
                    optString5 = "release";
                }
                JSONObject optJSONObject = jSONObject.optJSONObject("args");
                String optString6 = jSONObject.optString("cb");
                bVar.dqi = str2;
                bVar.dqj = optString;
                bVar.dqk = optString2;
                bVar.dql = optString5;
                bVar.cJd = optString3;
                bVar.cJc = optString4;
                bVar.pageParams = optJSONObject;
                bVar.cAw = optString6;
                return bVar;
            }
        }
        bVar.dqm = new com.baidu.swan.apps.api.c.b(201, "pluginProvider exchange for truth app key，but empty");
        return bVar;
    }
}
