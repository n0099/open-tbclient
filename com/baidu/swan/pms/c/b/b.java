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
        this.esg.aqj();
        f fVar = new f();
        a(bVar.esM, fVar);
        a(bVar.esN, fVar);
        a(bVar.esQ, fVar);
        a(bVar.esS, fVar);
        v(bVar.esR);
        if (fVar.bdy() == 0) {
            this.esg.ani();
            return null;
        }
        this.esg.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.esg);
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
        if (bVar.esM == null && ((bVar.esN == null || bVar.esN.isEmpty()) && bVar.esQ == null && bVar.esS == null && bVar.esR == null)) {
            return false;
        }
        if (bVar.esM == null || bVar.esM.arb()) {
            if (bVar.esN != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.esN) {
                    if (!gVar.arb()) {
                        return false;
                    }
                }
            }
            if (bVar.esQ == null || bVar.esQ.arb()) {
                if (bVar.esS == null || bVar.esS.arb()) {
                    return bVar.esR == null || bVar.esR.arb();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcx() {
        return "getpkg";
    }
}
