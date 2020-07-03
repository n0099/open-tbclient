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
    /* renamed from: ck */
    public com.baidu.swan.pms.c.c.d bG(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cs(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.d dVar) {
        this.dqy.aaV();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(dVar.drh, eVar);
        if (eVar.aIt() == 0) {
            this.dqy.aaR();
            return null;
        }
        this.dqy.a(eVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dqy);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.drh == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.drh) {
            if (!gVar.abL()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String awk() {
        return "getpkg";
    }
}
