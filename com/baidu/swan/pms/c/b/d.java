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
    /* renamed from: cO */
    public com.baidu.swan.pms.c.c.d cK(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cW(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.d dVar) {
        this.ehR.aqm();
        f fVar = new f();
        a(dVar.eiz, fVar);
        if (fVar.bcy() == 0) {
            this.ehR.anq();
            return null;
        }
        this.ehR.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.ehR);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.eiz == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.eiz) {
            if (!gVar.are()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bbw() {
        return "getpkg";
    }
}
