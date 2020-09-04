package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes14.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cv */
    public com.baidu.swan.pms.c.c.d cr(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cD(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ag(com.baidu.swan.pms.c.c.d dVar) {
        this.dFy.aiw();
        f fVar = new f();
        a(dVar.dGg, fVar);
        if (fVar.aUK() == 0) {
            this.dFy.afB();
            return null;
        }
        this.dFy.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dFy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ah(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.dGg == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.dGg) {
            if (!gVar.ajo()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aTI() {
        return "getpkg";
    }
}
