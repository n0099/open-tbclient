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
        this.cBl.Pk();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.cBP, eVar);
        a(bVar.cBS, eVar);
        a(bVar.cBT, eVar);
        a(bVar.cBV, eVar);
        p(bVar.cBU);
        if (eVar.aur() == 0) {
            this.cBl.Pg();
            return null;
        }
        this.cBl.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.cBl);
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
        if (bVar.cBP == null && ((bVar.cBS == null || bVar.cBS.isEmpty()) && bVar.cBT == null && bVar.cBV == null && bVar.cBU == null)) {
            return false;
        }
        if (bVar.cBP == null || bVar.cBP.PS()) {
            if (bVar.cBS != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.cBS) {
                    if (!gVar.PS()) {
                        return false;
                    }
                }
            }
            if (bVar.cBT == null || bVar.cBT.PS()) {
                if (bVar.cBV == null || bVar.cBV.PS()) {
                    return bVar.cBU == null || bVar.cBU.PS();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajj() {
        return "getpkg";
    }
}
