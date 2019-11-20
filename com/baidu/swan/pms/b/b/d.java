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
    /* renamed from: bg */
    public com.baidu.swan.pms.b.c.d bc(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bj(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.d dVar) {
        this.bLt.Gn();
        com.baidu.swan.pms.d.a.d(this.bLu.getCategory(), dVar.aOB);
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(dVar.bLX, eVar);
        a(dVar.bLZ, eVar);
        if (eVar.abL() == 0) {
            this.bLt.Gj();
            return null;
        }
        this.bLt.a(eVar);
        com.baidu.swan.pms.b.a.a.a(dVar, this.bLt);
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
        if (dVar.bLX == null || dVar.bLX.abf()) {
            return dVar.bLZ == null || dVar.bLZ.abf();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abh() {
        return "updatecore";
    }
}
