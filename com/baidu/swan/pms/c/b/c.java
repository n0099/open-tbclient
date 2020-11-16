package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
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
        this.egj.apE();
        f fVar = new f();
        a(cVar.egY, fVar);
        if (fVar.bbR() == 0) {
            this.egj.amI();
            return null;
        }
        this.egj.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.egj);
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
        return cVar.egY == null || cVar.egY.aqw();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String baP() {
        return "getplugin";
    }
}
