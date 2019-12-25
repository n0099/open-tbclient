package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes9.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bQ */
    public com.baidu.swan.pms.c.c.c bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bX(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a P(com.baidu.swan.pms.c.c.c cVar) {
        this.cxc.MA();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(cVar.cxN, eVar);
        if (eVar.arK() == 0) {
            this.cxc.Mw();
            return null;
        }
        this.cxc.a(eVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.cxc);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean O(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cxN == null || cVar.cxN.Ni();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String agC() {
        return "getplugin";
    }
}
