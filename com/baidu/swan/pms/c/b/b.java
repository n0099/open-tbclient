package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
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
        this.cxc.MA();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.cxG, eVar);
        a(bVar.cxJ, eVar);
        a(bVar.cxK, eVar);
        a(bVar.cxM, eVar);
        p(bVar.cxL);
        if (eVar.arK() == 0) {
            this.cxc.Mw();
            return null;
        }
        this.cxc.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.cxc);
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
        if (bVar.cxG == null && ((bVar.cxJ == null || bVar.cxJ.isEmpty()) && bVar.cxK == null && bVar.cxM == null && bVar.cxL == null)) {
            return false;
        }
        if (bVar.cxG == null || bVar.cxG.Ni()) {
            if (bVar.cxJ != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.cxJ) {
                    if (!gVar.Ni()) {
                        return false;
                    }
                }
            }
            if (bVar.cxK == null || bVar.cxK.Ni()) {
                if (bVar.cxM == null || bVar.cxM.Ni()) {
                    return bVar.cxL == null || bVar.cxL.Ni();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agC() {
        return "getpkg";
    }
}
