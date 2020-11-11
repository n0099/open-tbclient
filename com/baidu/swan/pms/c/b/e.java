package com.baidu.swan.pms.c.b;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.node.f;
import org.json.JSONObject;
/* loaded from: classes15.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    @Nullable
    private g eiv;
    @Nullable
    private g eiw;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.eiv = gVar3;
        this.eiw = gVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cP */
    public com.baidu.swan.pms.c.c.e cK(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cX(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.e eVar) {
        this.ehR.aqm();
        com.baidu.swan.pms.g.a.k(this.cTb.getCategory(), eVar.maxAge);
        f.b(eVar.data, (this.ehR == this.eiv || this.ehR == this.eiw) ? null : this.ehR, this.eiv, this.eiw);
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
    protected String bbw() {
        return "updatecore";
    }
}
