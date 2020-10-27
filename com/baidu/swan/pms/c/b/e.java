package com.baidu.swan.pms.c.b;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.node.f;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    @Nullable
    private g ecD;
    @Nullable
    private g ecE;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.ecD = gVar3;
        this.ecE = gVar4;
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
        this.ebZ.anL();
        com.baidu.swan.pms.g.a.l(this.cNi.getCategory(), eVar.maxAge);
        f.b(eVar.data, (this.ebZ == this.ecD || this.ebZ == this.ecE) ? null : this.ebZ, this.ecD, this.ecE);
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
    protected String aYW() {
        return "updatecore";
    }
}
