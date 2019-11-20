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
    /* renamed from: bf */
    public com.baidu.swan.pms.b.c.c bc(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bi(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.c cVar) {
        this.bLt.Gn();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(cVar.bLW, eVar);
        if (eVar.abL() == 0) {
            this.bLt.Gj();
            return null;
        }
        this.bLt.a(eVar);
        com.baidu.swan.pms.b.a.a.a(cVar, this.bLt);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean U(com.baidu.swan.pms.b.c.c cVar) {
        if (cVar == null || cVar.bLW == null) {
            return false;
        }
        for (h hVar : cVar.bLW) {
            if (!hVar.abf()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abh() {
        return "getpkg";
    }
}
