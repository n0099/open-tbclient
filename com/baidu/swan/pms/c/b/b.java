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
        this.dFu.aiw();
        f fVar = new f();
        a(bVar.dGb, fVar);
        a(bVar.dGc, fVar);
        a(bVar.dGf, fVar);
        a(bVar.dGh, fVar);
        v(bVar.dGg);
        if (fVar.aUK() == 0) {
            this.dFu.afB();
            return null;
        }
        this.dFu.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dFu);
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
        if (bVar.dGb == null && ((bVar.dGc == null || bVar.dGc.isEmpty()) && bVar.dGf == null && bVar.dGh == null && bVar.dGg == null)) {
            return false;
        }
        if (bVar.dGb == null || bVar.dGb.ajo()) {
            if (bVar.dGc != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dGc) {
                    if (!gVar.ajo()) {
                        return false;
                    }
                }
            }
            if (bVar.dGf == null || bVar.dGf.ajo()) {
                if (bVar.dGh == null || bVar.dGh.ajo()) {
                    return bVar.dGg == null || bVar.dGg.ajo();
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
