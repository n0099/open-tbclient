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
    /* renamed from: cR */
    public com.baidu.swan.pms.c.c.d cN(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cZ(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ao(com.baidu.swan.pms.c.c.d dVar) {
        this.evO.aqK();
        f fVar = new f();
        a(dVar.ewv, fVar);
        if (fVar.bdN() == 0) {
            this.evO.anJ();
            return null;
        }
        this.evO.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.evO);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ap(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.ewv == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.ewv) {
            if (!gVar.arC()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcM() {
        return "getpkg";
    }
}
