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
        this.cBn.Pm();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(cVar.cBY, eVar);
        if (eVar.aut() == 0) {
            this.cBn.Pi();
            return null;
        }
        this.cBn.a(eVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.cBn);
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
        return cVar.cBY == null || cVar.cBY.PU();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajl() {
        return "getplugin";
    }
}
