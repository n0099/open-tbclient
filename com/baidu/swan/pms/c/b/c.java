package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cu */
    public com.baidu.swan.pms.c.c.c cr(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cG(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ag(com.baidu.swan.pms.c.c.c cVar) {
        this.dFy.aiw();
        f fVar = new f();
        a(cVar.dGm, fVar);
        if (fVar.aUK() == 0) {
            this.dFy.afB();
            return null;
        }
        this.dFy.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dFy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ah(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dGm == null || cVar.dGm.ajo();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aTI() {
        return "getplugin";
    }
}
