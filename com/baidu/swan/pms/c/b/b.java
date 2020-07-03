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
    /* renamed from: ci */
    public com.baidu.swan.pms.c.c.b bG(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cr(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.b bVar) {
        this.dqy.aaV();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.dre, eVar);
        a(bVar.drh, eVar);
        a(bVar.dri, eVar);
        a(bVar.drk, eVar);
        r(bVar.drj);
        if (eVar.aIt() == 0) {
            this.dqy.aaR();
            return null;
        }
        this.dqy.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dqy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.dre == null && ((bVar.drh == null || bVar.drh.isEmpty()) && bVar.dri == null && bVar.drk == null && bVar.drj == null)) {
            return false;
        }
        if (bVar.dre == null || bVar.dre.abL()) {
            if (bVar.drh != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.drh) {
                    if (!gVar.abL()) {
                        return false;
                    }
                }
            }
            if (bVar.dri == null || bVar.dri.abL()) {
                if (bVar.drk == null || bVar.drk.abL()) {
                    return bVar.drj == null || bVar.drj.abL();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String awk() {
        return "getpkg";
    }
}
