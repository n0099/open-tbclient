package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cG */
    public com.baidu.swan.pms.c.c.b cE(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cP(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.b bVar) {
        this.egj.apE();
        f fVar = new f();
        a(bVar.egR, fVar);
        a(bVar.egS, fVar);
        a(bVar.egV, fVar);
        a(bVar.egX, fVar);
        v(bVar.egW);
        if (fVar.bbR() == 0) {
            this.egj.amI();
            return null;
        }
        this.egj.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.egj);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.egR == null && ((bVar.egS == null || bVar.egS.isEmpty()) && bVar.egV == null && bVar.egX == null && bVar.egW == null)) {
            return false;
        }
        if (bVar.egR == null || bVar.egR.aqw()) {
            if (bVar.egS != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.egS) {
                    if (!gVar.aqw()) {
                        return false;
                    }
                }
            }
            if (bVar.egV == null || bVar.egV.aqw()) {
                if (bVar.egX == null || bVar.egX.aqw()) {
                    return bVar.egW == null || bVar.egW.aqw();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String baP() {
        return "getpkg";
    }
}
