package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cx */
    public com.baidu.swan.pms.c.c.c cu(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cJ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ah(com.baidu.swan.pms.c.c.c cVar) {
        this.dHC.ajg();
        f fVar = new f();
        a(cVar.dIq, fVar);
        if (fVar.aVw() == 0) {
            this.dHC.agl();
            return null;
        }
        this.dHC.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dHC);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ai(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dIq == null || cVar.dIq.ajY();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aUu() {
        return "getplugin";
    }
}
