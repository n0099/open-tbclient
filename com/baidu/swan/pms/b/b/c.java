package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.b.d.e;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class c extends com.baidu.swan.pms.b.d<com.baidu.swan.pms.b.c.c> {
    public c(f fVar, e eVar) {
        super(fVar, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: be */
    public com.baidu.swan.pms.b.c.c bb(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bh(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.c cVar) {
        this.bMk.Gm();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(cVar.bMN, eVar);
        if (eVar.abN() == 0) {
            this.bMk.Gi();
            return null;
        }
        this.bMk.a(eVar);
        com.baidu.swan.pms.b.a.a.a(cVar, this.bMk);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean U(com.baidu.swan.pms.b.c.c cVar) {
        if (cVar == null || cVar.bMN == null) {
            return false;
        }
        for (h hVar : cVar.bMN) {
            if (!hVar.abh()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abj() {
        return "getpkg";
    }
}
