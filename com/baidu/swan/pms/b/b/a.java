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
        this.btz.Br();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(aVar.btr, eVar);
        a(aVar.buc, eVar);
        a(aVar.bud, eVar);
        a(aVar.bug, eVar);
        i(aVar.bue);
        if (eVar.WY() == 0) {
            this.btz.Bn();
            return null;
        }
        this.btz.a(eVar);
        com.baidu.swan.pms.b.a.a.a(aVar, this.btz);
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
        if (aVar.btr == null && ((aVar.buc == null || aVar.buc.isEmpty()) && aVar.bud == null && aVar.bug == null && aVar.bue == null)) {
            return false;
        }
        if (aVar.btr == null || aVar.btr.Ws()) {
            if (aVar.buc != null) {
                for (h hVar : aVar.buc) {
                    if (!hVar.Ws()) {
                        return false;
                    }
                }
            }
            if (aVar.bud == null || aVar.bud.Ws()) {
                if (aVar.bug == null || aVar.bug.Ws()) {
                    return aVar.bue == null || aVar.bue.Ws();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Wu() {
        return "getpkg";
    }
}
