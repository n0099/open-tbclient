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
        this.dFu.aiw();
        f fVar = new f();
        a(cVar.dGi, fVar);
        if (fVar.aUK() == 0) {
            this.dFu.afB();
            return null;
        }
        this.dFu.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dFu);
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
        return cVar.dGi == null || cVar.dGi.ajo();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aTI() {
        return "getplugin";
    }
}
