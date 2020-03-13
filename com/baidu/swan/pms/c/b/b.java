package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bP */
    public com.baidu.swan.pms.c.c.b bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bT(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a R(com.baidu.swan.pms.c.c.b bVar) {
        this.cBn.Pm();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.cBR, eVar);
        a(bVar.cBU, eVar);
        a(bVar.cBV, eVar);
        a(bVar.cBX, eVar);
        p(bVar.cBW);
        if (eVar.aut() == 0) {
            this.cBn.Pi();
            return null;
        }
        this.cBn.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.cBn);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean Q(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.cBR == null && ((bVar.cBU == null || bVar.cBU.isEmpty()) && bVar.cBV == null && bVar.cBX == null && bVar.cBW == null)) {
            return false;
        }
        if (bVar.cBR == null || bVar.cBR.PU()) {
            if (bVar.cBU != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.cBU) {
                    if (!gVar.PU()) {
                        return false;
                    }
                }
            }
            if (bVar.cBV == null || bVar.cBV.PU()) {
                if (bVar.cBX == null || bVar.cBX.PU()) {
                    return bVar.cBW == null || bVar.cBW.PU();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajl() {
        return "getpkg";
    }
}
