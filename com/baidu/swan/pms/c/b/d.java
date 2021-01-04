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
    /* renamed from: cS */
    public com.baidu.swan.pms.c.c.d cO(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.da(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.d dVar) {
        this.ewT.aud();
        f fVar = new f();
        a(dVar.exB, fVar);
        if (fVar.bhr() == 0) {
            this.ewT.arc();
            return null;
        }
        this.ewT.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.ewT);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.exB == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.exB) {
            if (!gVar.auV()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bgq() {
        return "getpkg";
    }
}
