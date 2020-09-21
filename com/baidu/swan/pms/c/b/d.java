package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cy */
    public com.baidu.swan.pms.c.c.d cu(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cG(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ah(com.baidu.swan.pms.c.c.d dVar) {
        this.dHC.ajg();
        f fVar = new f();
        a(dVar.dIk, fVar);
        if (fVar.aVw() == 0) {
            this.dHC.agl();
            return null;
        }
        this.dHC.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dHC);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ai(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.dIk == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.dIk) {
            if (!gVar.ajY()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aUu() {
        return "getpkg";
    }
}
