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
    /* renamed from: cR */
    public com.baidu.swan.pms.c.c.c cO(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.dd(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.c cVar) {
        this.ewT.aud();
        f fVar = new f();
        a(cVar.exH, fVar);
        if (fVar.bhr() == 0) {
            this.ewT.arc();
            return null;
        }
        this.ewT.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.ewT);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.exH == null || cVar.exH.auV();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bgq() {
        return "getplugin";
    }
}
