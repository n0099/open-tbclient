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
        this.cBm.Pm();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.cBQ, eVar);
        a(bVar.cBT, eVar);
        a(bVar.cBU, eVar);
        a(bVar.cBW, eVar);
        p(bVar.cBV);
        if (eVar.aut() == 0) {
            this.cBm.Pi();
            return null;
        }
        this.cBm.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.cBm);
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
        if (bVar.cBQ == null && ((bVar.cBT == null || bVar.cBT.isEmpty()) && bVar.cBU == null && bVar.cBW == null && bVar.cBV == null)) {
            return false;
        }
        if (bVar.cBQ == null || bVar.cBQ.PU()) {
            if (bVar.cBT != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.cBT) {
                    if (!gVar.PU()) {
                        return false;
                    }
                }
            }
            if (bVar.cBU == null || bVar.cBU.PU()) {
                if (bVar.cBW == null || bVar.cBW.PU()) {
                    return bVar.cBV == null || bVar.cBV.PU();
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
