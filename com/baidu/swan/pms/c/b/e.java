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
    /* renamed from: bS */
    public com.baidu.swan.pms.c.c.e bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bV(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a R(com.baidu.swan.pms.c.c.e eVar) {
        this.cBy.Pp();
        com.baidu.swan.pms.e.a.j(this.cBz.getCategory(), eVar.maxAge);
        com.baidu.swan.pms.f.e eVar2 = new com.baidu.swan.pms.f.e();
        a(eVar.cCg, eVar2);
        a(eVar.cCi, eVar2);
        if (eVar2.auw() == 0) {
            this.cBy.Pl();
            return null;
        }
        this.cBy.a(eVar2);
        com.baidu.swan.pms.c.a.a.a(eVar, this.cBy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean Q(com.baidu.swan.pms.c.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.cCg == null || eVar.cCg.PX()) {
            return eVar.cCi == null || eVar.cCi.PX();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajo() {
        return "updatecore";
    }
}
