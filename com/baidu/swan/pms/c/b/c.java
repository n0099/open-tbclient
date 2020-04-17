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
    /* renamed from: cb */
    public com.baidu.swan.pms.c.c.c bA(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.ci(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a S(com.baidu.swan.pms.c.c.c cVar) {
        this.dax.Xe();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(cVar.dbj, eVar);
        if (eVar.aCH() == 0) {
            this.dax.Xa();
            return null;
        }
        this.dax.a(eVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dax);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean R(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dbj == null || cVar.dbj.XM();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arw() {
        return "getplugin";
    }
}
