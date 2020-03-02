package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: bR */
    public com.baidu.swan.pms.c.c.d bp(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.bU(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a R(com.baidu.swan.pms.c.c.d dVar) {
        this.cBm.Pm();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(dVar.cBT, eVar);
        if (eVar.aut() == 0) {
            this.cBm.Pi();
            return null;
        }
        this.cBm.a(eVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.cBm);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean Q(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.cBT == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.cBT) {
            if (!gVar.PU()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ajl() {
        return "getpkg";
    }
}
