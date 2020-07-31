package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    private g dwU;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, g gVar3) {
        super(gVar, gVar2);
        this.dwU = gVar3;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cr */
    public com.baidu.swan.pms.c.c.e bL(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.e.cz(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.e eVar) {
        this.dwq.abX();
        com.baidu.swan.pms.e.a.k(this.dwr.getCategory(), eVar.maxAge);
        com.baidu.swan.pms.node.e.b(eVar.data, this.dwq, this.dwU);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.e eVar) {
        return eVar != null;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ayY() {
        return "updatecore";
    }
}
