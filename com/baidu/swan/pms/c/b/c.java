package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cc */
    public com.baidu.swan.pms.c.c.c bz(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.co(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.c cVar) {
        this.dlN.ZP();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(cVar.dmA, eVar);
        if (eVar.aHn() == 0) {
            this.dlN.ZL();
            return null;
        }
        this.dlN.a(eVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dlN);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dmA == null || cVar.dmA.aaF();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ave() {
        return "getplugin";
    }
}
