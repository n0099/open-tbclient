package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cF */
    public com.baidu.swan.pms.c.c.d cB(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cN(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.d dVar) {
        this.dTD.alR();
        f fVar = new f();
        a(dVar.dUl, fVar);
        if (fVar.aYf() == 0) {
            this.dTD.aiW();
            return null;
        }
        this.dTD.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dTD);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.dUl == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.dUl) {
            if (!gVar.amJ()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aXd() {
        return "getpkg";
    }
}
