package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bR */
    public com.baidu.swan.pms.c.c.d bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bU(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a P(com.baidu.swan.pms.c.c.d dVar) {
        this.cxc.MA();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(dVar.cxJ, eVar);
        if (eVar.arK() == 0) {
            this.cxc.Mw();
            return null;
        }
        this.cxc.a(eVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.cxc);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean O(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.cxJ == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.cxJ) {
            if (!gVar.Ni()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agC() {
        return "getpkg";
    }
}
