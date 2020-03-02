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
        this.cBm.Pm();
        com.baidu.swan.pms.e.a.j(this.cBn.getCategory(), eVar.maxAge);
        com.baidu.swan.pms.f.e eVar2 = new com.baidu.swan.pms.f.e();
        a(eVar.cBU, eVar2);
        a(eVar.cBW, eVar2);
        if (eVar2.aut() == 0) {
            this.cBm.Pi();
            return null;
        }
        this.cBm.a(eVar2);
        com.baidu.swan.pms.c.a.a.a(eVar, this.cBm);
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
        if (eVar.cBU == null || eVar.cBU.PU()) {
            return eVar.cBW == null || eVar.cBW.PU();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajl() {
        return "updatecore";
    }
}
