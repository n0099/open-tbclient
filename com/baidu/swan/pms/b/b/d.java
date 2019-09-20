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
        this.btz.Br();
        com.baidu.swan.pms.d.a.f(this.btA.BB(), dVar.avE);
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(dVar.bud, eVar);
        a(dVar.bug, eVar);
        if (eVar.WY() == 0) {
            this.btz.Bn();
            return null;
        }
        this.btz.a(eVar);
        com.baidu.swan.pms.b.a.a.a(dVar, this.btz);
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
        if (dVar.bud == null || dVar.bud.Ws()) {
            return dVar.bug == null || dVar.bug.Ws();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Wu() {
        return "updatecore";
    }
}
