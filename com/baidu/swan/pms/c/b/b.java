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
        this.ewT.aud();
        f fVar = new f();
        a(bVar.exA, fVar);
        a(bVar.exB, fVar);
        a(bVar.exE, fVar);
        a(bVar.exG, fVar);
        v(bVar.exF);
        if (fVar.bhr() == 0) {
            this.ewT.arc();
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
        if (bVar.exA == null || bVar.exA.auV()) {
            if (bVar.exB != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.exB) {
                    if (!gVar.auV()) {
                        return false;
                    }
                }
            }
            if (bVar.exE == null || bVar.exE.auV()) {
                if (bVar.exG == null || bVar.exG.auV()) {
                    return bVar.exF == null || bVar.exF.auV();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bgq() {
        return "getpkg";
    }
}
