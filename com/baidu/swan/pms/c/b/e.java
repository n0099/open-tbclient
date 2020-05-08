package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    public e(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cd */
    public com.baidu.swan.pms.c.c.e bA(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cg(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.c.c.e eVar) {
        this.daD.Xd();
        com.baidu.swan.pms.e.a.j(this.daE.getCategory(), eVar.maxAge);
        com.baidu.swan.pms.f.e eVar2 = new com.baidu.swan.pms.f.e();
        a(eVar.dbl, eVar2);
        a(eVar.dbn, eVar2);
        if (eVar2.aCH() == 0) {
            this.daD.WZ();
            return null;
        }
        this.daD.a(eVar2);
        com.baidu.swan.pms.c.a.a.a(eVar, this.daD);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean S(com.baidu.swan.pms.c.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.dbl == null || eVar.dbl.XL()) {
            return eVar.dbn == null || eVar.dbn.XL();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arv() {
        return "updatecore";
    }
}
