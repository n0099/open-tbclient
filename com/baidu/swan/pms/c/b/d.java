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
    /* renamed from: cK */
    public com.baidu.swan.pms.c.c.d cG(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cS(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.d dVar) {
        this.enl.asM();
        f fVar = new f();
        a(dVar.enT, fVar);
        if (fVar.beW() == 0) {
            this.enl.apQ();
            return null;
        }
        this.enl.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.enl);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.enT == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.enT) {
            if (!gVar.atE()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bdU() {
        return "getpkg";
    }
}
