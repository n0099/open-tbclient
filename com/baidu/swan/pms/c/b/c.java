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
    /* renamed from: cH */
    public com.baidu.swan.pms.c.c.c cE(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cT(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.c cVar) {
        this.ebZ.anL();
        f fVar = new f();
        a(cVar.ecN, fVar);
        if (fVar.aZY() == 0) {
            this.ebZ.akQ();
            return null;
        }
        this.ebZ.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.ebZ);
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
        return cVar.ecN == null || cVar.ecN.aoD();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aYW() {
        return "getplugin";
    }
}
