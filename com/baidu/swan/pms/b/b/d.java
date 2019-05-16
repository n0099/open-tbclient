package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.b.d.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class d extends com.baidu.swan.pms.b.d<com.baidu.swan.pms.b.c.d> {
    public d(f fVar, e eVar) {
        super(fVar, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: aH */
    public com.baidu.swan.pms.b.c.d aD(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.aK(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a V(com.baidu.swan.pms.b.c.d dVar) {
        this.bsl.AF();
        com.baidu.swan.pms.d.a.f(this.bsm.AP(), dVar.auC);
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(dVar.bsP, eVar);
        a(dVar.bsR, eVar);
        if (eVar.Wa() == 0) {
            this.bsl.AB();
            return null;
        }
        this.bsl.a(eVar);
        com.baidu.swan.pms.b.a.a.a(dVar, this.bsl);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.b.c.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar.bsP == null || dVar.bsP.Vv()) {
            return dVar.bsR == null || dVar.bsR.Vv();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Vx() {
        return "updatecore";
    }
}
