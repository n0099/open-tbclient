package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.f;
import com.baidu.swan.pms.b.d.e;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class b extends com.baidu.swan.pms.b.d<com.baidu.swan.pms.b.c.b> {
    public b(f fVar, e eVar) {
        super(fVar, eVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: aF */
    public com.baidu.swan.pms.b.c.b aD(JSONObject jSONObject) {
        return com.baidu.swan.pms.e.d.aL(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a V(com.baidu.swan.pms.b.c.b bVar) {
        this.btb.Bn();
        com.baidu.swan.pms.e.e eVar = new com.baidu.swan.pms.e.e();
        a(bVar.btI, eVar);
        if (eVar.WU() == 0) {
            this.btb.Bj();
            return null;
        }
        this.btb.a(eVar);
        com.baidu.swan.pms.b.a.a.a(bVar, this.btb);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.b.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        return bVar.btI == null || bVar.btI.Wo();
    }

    @Override // com.baidu.swan.pms.b.d
    protected String Wq() {
        return "getplugin";
    }
}
