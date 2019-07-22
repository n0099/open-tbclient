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
        this.btb.Bn();
        com.baidu.swan.pms.d.a.f(this.btc.Bx(), dVar.avg);
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(dVar.btF, eVar);
        a(dVar.btH, eVar);
        if (eVar.WU() == 0) {
            this.btb.Bj();
            return null;
        }
        this.btb.a(eVar);
        com.baidu.swan.pms.b.a.a.a(dVar, this.btb);
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
        if (dVar.btF == null || dVar.btF.Wo()) {
            return dVar.btH == null || dVar.btH.Wo();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Wq() {
        return "updatecore";
    }
}
