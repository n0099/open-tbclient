package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cd */
    public com.baidu.swan.pms.c.c.d bz(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cl(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.d dVar) {
        this.dlN.ZP();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(dVar.dmw, eVar);
        if (eVar.aHn() == 0) {
            this.dlN.ZL();
            return null;
        }
        this.dlN.a(eVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dlN);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.dmw == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.dmw) {
            if (!gVar.aaF()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ave() {
        return "getpkg";
    }
}
