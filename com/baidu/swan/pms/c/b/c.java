package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cN */
    public com.baidu.swan.pms.c.c.c cK(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cZ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.c cVar) {
        this.ehR.aqm();
        f fVar = new f();
        a(cVar.eiF, fVar);
        if (fVar.bcy() == 0) {
            this.ehR.anq();
            return null;
        }
        this.ehR.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.ehR);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.eiF == null || cVar.eiF.are();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bbw() {
        return "getplugin";
    }
}
