package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cj */
    public com.baidu.swan.pms.c.c.c bG(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cv(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.c cVar) {
        this.dqy.aaV();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(cVar.drl, eVar);
        if (eVar.aIt() == 0) {
            this.dqy.aaR();
            return null;
        }
        this.dqy.a(eVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dqy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.drl == null || cVar.drl.abL();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String awk() {
        return "getplugin";
    }
}
