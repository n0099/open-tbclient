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
    /* renamed from: cM */
    public com.baidu.swan.pms.c.c.b cK(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cV(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.b bVar) {
        this.ehR.aqm();
        f fVar = new f();
        a(bVar.eiy, fVar);
        a(bVar.eiz, fVar);
        a(bVar.eiC, fVar);
        a(bVar.eiE, fVar);
        v(bVar.eiD);
        if (fVar.bcy() == 0) {
            this.ehR.anq();
            return null;
        }
        this.ehR.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.ehR);
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
        if (bVar.eiy == null && ((bVar.eiz == null || bVar.eiz.isEmpty()) && bVar.eiC == null && bVar.eiE == null && bVar.eiD == null)) {
            return false;
        }
        if (bVar.eiy == null || bVar.eiy.are()) {
            if (bVar.eiz != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.eiz) {
                    if (!gVar.are()) {
                        return false;
                    }
                }
            }
            if (bVar.eiC == null || bVar.eiC.are()) {
                if (bVar.eiE == null || bVar.eiE.are()) {
                    return bVar.eiD == null || bVar.eiD.are();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bbw() {
        return "getpkg";
    }
}
