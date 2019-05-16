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
        this.bsl.AF();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(aVar.bse, eVar);
        a(aVar.bsO, eVar);
        a(aVar.bsP, eVar);
        a(aVar.bsR, eVar);
        i(aVar.bsQ);
        if (eVar.Wa() == 0) {
            this.bsl.AB();
            return null;
        }
        this.bsl.a(eVar);
        com.baidu.swan.pms.b.a.a.a(aVar, this.bsl);
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
        if (aVar.bse == null && ((aVar.bsO == null || aVar.bsO.isEmpty()) && aVar.bsP == null && aVar.bsR == null && aVar.bsQ == null)) {
            return false;
        }
        if (aVar.bse == null || aVar.bse.Vv()) {
            if (aVar.bsO != null) {
                for (h hVar : aVar.bsO) {
                    if (!hVar.Vv()) {
                        return false;
                    }
                }
            }
            if (aVar.bsP == null || aVar.bsP.Vv()) {
                if (aVar.bsR == null || aVar.bsR.Vv()) {
                    return aVar.bsQ == null || aVar.bsQ.Vv();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Vx() {
        return "getpkg";
    }
}
