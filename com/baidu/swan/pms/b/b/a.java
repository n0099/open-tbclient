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
    /* renamed from: aE */
    public com.baidu.swan.pms.b.c.a aD(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.aI(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a V(com.baidu.swan.pms.b.c.a aVar) {
        this.btb.Bn();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(aVar.bsT, eVar);
        a(aVar.btE, eVar);
        a(aVar.btF, eVar);
        a(aVar.btH, eVar);
        i(aVar.btG);
        if (eVar.WU() == 0) {
            this.btb.Bj();
            return null;
        }
        this.btb.a(eVar);
        com.baidu.swan.pms.b.a.a.a(aVar, this.btb);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.b.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.bsT == null && ((aVar.btE == null || aVar.btE.isEmpty()) && aVar.btF == null && aVar.btH == null && aVar.btG == null)) {
            return false;
        }
        if (aVar.bsT == null || aVar.bsT.Wo()) {
            if (aVar.btE != null) {
                for (h hVar : aVar.btE) {
                    if (!hVar.Wo()) {
                        return false;
                    }
                }
            }
            if (aVar.btF == null || aVar.btF.Wo()) {
                if (aVar.btH == null || aVar.btH.Wo()) {
                    return aVar.btG == null || aVar.btG.Wo();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Wq() {
        return "getpkg";
    }
}
