package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: ct */
    public com.baidu.swan.pms.c.c.b cr(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cC(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ag(com.baidu.swan.pms.c.c.b bVar) {
        this.dFy.aiw();
        f fVar = new f();
        a(bVar.dGf, fVar);
        a(bVar.dGg, fVar);
        a(bVar.dGj, fVar);
        a(bVar.dGl, fVar);
        v(bVar.dGk);
        if (fVar.aUK() == 0) {
            this.dFy.afB();
            return null;
        }
        this.dFy.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dFy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ah(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.dGf == null && ((bVar.dGg == null || bVar.dGg.isEmpty()) && bVar.dGj == null && bVar.dGl == null && bVar.dGk == null)) {
            return false;
        }
        if (bVar.dGf == null || bVar.dGf.ajo()) {
            if (bVar.dGg != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dGg) {
                    if (!gVar.ajo()) {
                        return false;
                    }
                }
            }
            if (bVar.dGj == null || bVar.dGj.ajo()) {
                if (bVar.dGl == null || bVar.dGl.ajo()) {
                    return bVar.dGk == null || bVar.dGk.ajo();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aTI() {
        return "getpkg";
    }
}
