package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cI */
    public com.baidu.swan.pms.c.c.d cE(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cQ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.d dVar) {
        this.egj.apE();
        f fVar = new f();
        a(dVar.egS, fVar);
        if (fVar.bbR() == 0) {
            this.egj.amI();
            return null;
        }
        this.egj.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.egj);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.egS == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.egS) {
            if (!gVar.aqw()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String baP() {
        return "getpkg";
    }
}
