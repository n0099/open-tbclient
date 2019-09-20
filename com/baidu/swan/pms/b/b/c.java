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
    /* renamed from: aG */
    public com.baidu.swan.pms.b.c.c aD(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.aJ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a V(com.baidu.swan.pms.b.c.c cVar) {
        this.btz.Br();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(cVar.buc, eVar);
        if (eVar.WY() == 0) {
            this.btz.Bn();
            return null;
        }
        this.btz.a(eVar);
        com.baidu.swan.pms.b.a.a.a(cVar, this.btz);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.b.c.c cVar) {
        if (cVar == null || cVar.buc == null) {
            return false;
        }
        for (h hVar : cVar.buc) {
            if (!hVar.Ws()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Wu() {
        return "getpkg";
    }
}
