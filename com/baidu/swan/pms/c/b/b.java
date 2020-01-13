package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes10.dex */
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
    public com.baidu.swan.pms.model.a P(com.baidu.swan.pms.c.c.b bVar) {
        this.cxn.MW();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.cxR, eVar);
        a(bVar.cxU, eVar);
        a(bVar.cxV, eVar);
        a(bVar.cxX, eVar);
        p(bVar.cxW);
        if (eVar.asd() == 0) {
            this.cxn.MS();
            return null;
        }
        this.cxn.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.cxn);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean O(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.cxR == null && ((bVar.cxU == null || bVar.cxU.isEmpty()) && bVar.cxV == null && bVar.cxX == null && bVar.cxW == null)) {
            return false;
        }
        if (bVar.cxR == null || bVar.cxR.NE()) {
            if (bVar.cxU != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.cxU) {
                    if (!gVar.NE()) {
                        return false;
                    }
                }
            }
            if (bVar.cxV == null || bVar.cxV.NE()) {
                if (bVar.cxX == null || bVar.cxX.NE()) {
                    return bVar.cxW == null || bVar.cxW.NE();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agV() {
        return "getpkg";
    }
}
