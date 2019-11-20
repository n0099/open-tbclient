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
    /* renamed from: bd */
    public com.baidu.swan.pms.b.c.a bc(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.bh(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.b.c.a aVar) {
        this.bLt.Gn();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(aVar.bLl, eVar);
        a(aVar.bLW, eVar);
        a(aVar.bLX, eVar);
        a(aVar.bLZ, eVar);
        i(aVar.bLY);
        if (eVar.abL() == 0) {
            this.bLt.Gj();
            return null;
        }
        this.bLt.a(eVar);
        com.baidu.swan.pms.b.a.a.a(aVar, this.bLt);
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
        if (aVar.bLl == null && ((aVar.bLW == null || aVar.bLW.isEmpty()) && aVar.bLX == null && aVar.bLZ == null && aVar.bLY == null)) {
            return false;
        }
        if (aVar.bLl == null || aVar.bLl.abf()) {
            if (aVar.bLW != null) {
                for (h hVar : aVar.bLW) {
                    if (!hVar.abf()) {
                        return false;
                    }
                }
            }
            if (aVar.bLX == null || aVar.bLX.abf()) {
                if (aVar.bLZ == null || aVar.bLZ.abf()) {
                    return aVar.bLY == null || aVar.bLY.abf();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String abh() {
        return "getpkg";
    }
}
