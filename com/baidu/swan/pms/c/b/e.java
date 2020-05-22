package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    private g dmr;

    public e(g gVar, f fVar, g gVar2) {
        super(gVar, fVar);
        this.dmr = gVar2;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: ce */
    public com.baidu.swan.pms.c.c.e bz(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.cm(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.e eVar) {
        this.dlN.ZP();
        com.baidu.swan.pms.e.a.j(this.dlO.getCategory(), eVar.maxAge);
        com.baidu.swan.pms.node.e.b(eVar.data, this.dlN, this.dmr);
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
    protected String ave() {
        return "updatecore";
    }
}
