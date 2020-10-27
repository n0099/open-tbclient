package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes15.dex */
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
        this.ebZ.anL();
        f fVar = new f();
        a(bVar.ecG, fVar);
        a(bVar.ecH, fVar);
        a(bVar.ecK, fVar);
        a(bVar.ecM, fVar);
        v(bVar.ecL);
        if (fVar.aZY() == 0) {
            this.ebZ.akQ();
            return null;
        }
        this.ebZ.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.ebZ);
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
        if (bVar.ecG == null && ((bVar.ecH == null || bVar.ecH.isEmpty()) && bVar.ecK == null && bVar.ecM == null && bVar.ecL == null)) {
            return false;
        }
        if (bVar.ecG == null || bVar.ecG.aoD()) {
            if (bVar.ecH != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.ecH) {
                    if (!gVar.aoD()) {
                        return false;
                    }
                }
            }
            if (bVar.ecK == null || bVar.ecK.aoD()) {
                if (bVar.ecM == null || bVar.ecM.aoD()) {
                    return bVar.ecL == null || bVar.ecL.aoD();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aYW() {
        return "getpkg";
    }
}
