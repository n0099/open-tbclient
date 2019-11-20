package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.b.d.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.pms.b.d<com.baidu.swan.pms.b.c.b> {
    public b(f fVar, e eVar) {
        super(fVar, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: be */
    public com.baidu.swan.pms.b.c.b bc(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bk(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.b bVar) {
        this.bLt.Gn();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(bVar.bMa, eVar);
        if (eVar.abL() == 0) {
            this.bLt.Gj();
            return null;
        }
        this.bLt.a(eVar);
        com.baidu.swan.pms.b.a.a.a(bVar, this.bLt);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean U(com.baidu.swan.pms.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        return bVar.bMa == null || bVar.bMa.abf();
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abh() {
        return "getplugin";
    }
}
