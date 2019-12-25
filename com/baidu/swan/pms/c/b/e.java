package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
    public com.baidu.swan.pms.model.a P(com.baidu.swan.pms.c.c.e eVar) {
        this.cxc.MA();
        com.baidu.swan.pms.e.a.j(this.cxd.getCategory(), eVar.maxAge);
        com.baidu.swan.pms.f.e eVar2 = new com.baidu.swan.pms.f.e();
        a(eVar.cxK, eVar2);
        a(eVar.cxM, eVar2);
        if (eVar2.arK() == 0) {
            this.cxc.Mw();
            return null;
        }
        this.cxc.a(eVar2);
        com.baidu.swan.pms.c.a.a.a(eVar, this.cxc);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean O(com.baidu.swan.pms.c.c.e eVar) {
        if (eVar == null) {
            return false;
        }
        if (eVar.cxK == null || eVar.cxK.Ni()) {
            return eVar.cxM == null || eVar.cxM.Ni();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agC() {
        return "updatecore";
    }
}
