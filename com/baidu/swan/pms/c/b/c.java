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
    /* renamed from: bQ */
    public com.baidu.swan.pms.c.c.c bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bX(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a R(com.baidu.swan.pms.c.c.c cVar) {
        this.cBy.Pp();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(cVar.cCj, eVar);
        if (eVar.auw() == 0) {
            this.cBy.Pl();
            return null;
        }
        this.cBy.a(eVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.cBy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean Q(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.cCj == null || cVar.cCj.PX();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajo() {
        return "getplugin";
    }
}
