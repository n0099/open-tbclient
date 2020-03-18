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
        this.cBy.Pp();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.cCc, eVar);
        a(bVar.cCf, eVar);
        a(bVar.cCg, eVar);
        a(bVar.cCi, eVar);
        p(bVar.cCh);
        if (eVar.auw() == 0) {
            this.cBy.Pl();
            return null;
        }
        this.cBy.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.cBy);
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
        if (bVar.cCc == null && ((bVar.cCf == null || bVar.cCf.isEmpty()) && bVar.cCg == null && bVar.cCi == null && bVar.cCh == null)) {
            return false;
        }
        if (bVar.cCc == null || bVar.cCc.PX()) {
            if (bVar.cCf != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.cCf) {
                    if (!gVar.PX()) {
                        return false;
                    }
                }
            }
            if (bVar.cCg == null || bVar.cCg.PX()) {
                if (bVar.cCi == null || bVar.cCi.PX()) {
                    return bVar.cCh == null || bVar.cCh.PX();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajo() {
        return "getpkg";
    }
}
