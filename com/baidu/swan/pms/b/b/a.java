package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.b.d.e;
import com.baidu.swan.pms.model.h;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class a extends com.baidu.swan.pms.b.d<com.baidu.swan.pms.b.c.a> {
    public a(f fVar, e eVar) {
        super(fVar, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: bc */
    public com.baidu.swan.pms.b.c.a bb(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bg(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.a aVar) {
        this.bMk.Gm();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(aVar.bMc, eVar);
        a(aVar.bMN, eVar);
        a(aVar.bMO, eVar);
        a(aVar.bMQ, eVar);
        i(aVar.bMP);
        if (eVar.abN() == 0) {
            this.bMk.Gi();
            return null;
        }
        this.bMk.a(eVar);
        com.baidu.swan.pms.b.a.a.a(aVar, this.bMk);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean U(com.baidu.swan.pms.b.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.bMc == null && ((aVar.bMN == null || aVar.bMN.isEmpty()) && aVar.bMO == null && aVar.bMQ == null && aVar.bMP == null)) {
            return false;
        }
        if (aVar.bMc == null || aVar.bMc.abh()) {
            if (aVar.bMN != null) {
                for (h hVar : aVar.bMN) {
                    if (!hVar.abh()) {
                        return false;
                    }
                }
            }
            if (aVar.bMO == null || aVar.bMO.abh()) {
                if (aVar.bMQ == null || aVar.bMQ.abh()) {
                    return aVar.bMP == null || aVar.bMP.abh();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abj() {
        return "getpkg";
    }
}
