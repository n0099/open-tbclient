package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cP */
    public com.baidu.swan.pms.c.c.d cL(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cX(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.d dVar) {
        this.eun.aqH();
        f fVar = new f();
        a(dVar.euU, fVar);
        if (fVar.bdL() == 0) {
            this.eun.anG();
            return null;
        }
        this.eun.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.eun);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.euU == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.euU) {
            if (!gVar.arz()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcK() {
        return "getpkg";
    }
}
