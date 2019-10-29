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
    /* renamed from: bd */
    public com.baidu.swan.pms.b.c.b bb(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bj(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.b bVar) {
        this.bMk.Gm();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(bVar.bMR, eVar);
        if (eVar.abN() == 0) {
            this.bMk.Gi();
            return null;
        }
        this.bMk.a(eVar);
        com.baidu.swan.pms.b.a.a.a(bVar, this.bMk);
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
        return bVar.bMR == null || bVar.bMR.abh();
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abj() {
        return "getplugin";
    }
}
