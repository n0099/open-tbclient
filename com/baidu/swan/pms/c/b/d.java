package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cc */
    public com.baidu.swan.pms.c.c.d bA(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cf(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a S(com.baidu.swan.pms.c.c.d dVar) {
        this.dax.Xe();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(dVar.dbf, eVar);
        if (eVar.aCH() == 0) {
            this.dax.Xa();
            return null;
        }
        this.dax.a(eVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dax);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean R(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.dbf == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.dbf) {
            if (!gVar.XM()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arw() {
        return "getpkg";
    }
}
