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
    /* renamed from: bf */
    public com.baidu.swan.pms.b.c.d bb(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bi(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.d dVar) {
        this.bMk.Gm();
        com.baidu.swan.pms.d.a.f(this.bMl.getCategory(), dVar.aOT);
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(dVar.bMO, eVar);
        a(dVar.bMQ, eVar);
        if (eVar.abN() == 0) {
            this.bMk.Gi();
            return null;
        }
        this.bMk.a(eVar);
        com.baidu.swan.pms.b.a.a.a(dVar, this.bMk);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean U(com.baidu.swan.pms.b.c.d dVar) {
        if (dVar == null) {
            return false;
        }
        if (dVar.bMO == null || dVar.bMO.abh()) {
            return dVar.bMQ == null || dVar.bMQ.abh();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abj() {
        return "updatecore";
    }
}
