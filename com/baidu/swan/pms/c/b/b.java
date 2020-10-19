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
    /* renamed from: cD */
    public com.baidu.swan.pms.c.c.b cB(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cM(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.b bVar) {
        this.dTD.alR();
        f fVar = new f();
        a(bVar.dUk, fVar);
        a(bVar.dUl, fVar);
        a(bVar.dUo, fVar);
        a(bVar.dUq, fVar);
        v(bVar.dUp);
        if (fVar.aYf() == 0) {
            this.dTD.aiW();
            return null;
        }
        this.dTD.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dTD);
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
        if (bVar.dUk == null && ((bVar.dUl == null || bVar.dUl.isEmpty()) && bVar.dUo == null && bVar.dUq == null && bVar.dUp == null)) {
            return false;
        }
        if (bVar.dUk == null || bVar.dUk.amJ()) {
            if (bVar.dUl != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dUl) {
                    if (!gVar.amJ()) {
                        return false;
                    }
                }
            }
            if (bVar.dUo == null || bVar.dUo.amJ()) {
                if (bVar.dUq == null || bVar.dUq.amJ()) {
                    return bVar.dUp == null || bVar.dUp.amJ();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aXd() {
        return "getpkg";
    }
}
