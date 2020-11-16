package com.baidu.swan.pms.c.b;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.node.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    @Nullable
    private g egO;
    @Nullable
    private g egP;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.egO = gVar3;
        this.egP = gVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cJ */
    public com.baidu.swan.pms.c.c.e cE(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cR(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.e eVar) {
        this.egj.apE();
        com.baidu.swan.pms.g.a.k(this.cRr.getCategory(), eVar.maxAge);
        f.b(eVar.data, (this.egj == this.egO || this.egj == this.egP) ? null : this.egj, this.egO, this.egP);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.e eVar) {
        return eVar != null;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String baP() {
        return "updatecore";
    }
}
