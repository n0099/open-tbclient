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
    /* renamed from: cQ */
    public com.baidu.swan.pms.c.c.b cO(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cZ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.b bVar) {
        this.ewT.aue();
        f fVar = new f();
        a(bVar.exA, fVar);
        a(bVar.exB, fVar);
        a(bVar.exE, fVar);
        a(bVar.exG, fVar);
        v(bVar.exF);
        if (fVar.bhs() == 0) {
            this.ewT.ard();
            return null;
        }
        this.ewT.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.ewT);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.exA == null && ((bVar.exB == null || bVar.exB.isEmpty()) && bVar.exE == null && bVar.exG == null && bVar.exF == null)) {
            return false;
        }
        if (bVar.exA == null || bVar.exA.auW()) {
            if (bVar.exB != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.exB) {
                    if (!gVar.auW()) {
                        return false;
                    }
                }
            }
            if (bVar.exE == null || bVar.exE.auW()) {
                if (bVar.exG == null || bVar.exG.auW()) {
                    return bVar.exF == null || bVar.exF.auW();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bgr() {
        return "getpkg";
    }
}
