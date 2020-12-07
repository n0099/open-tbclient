package com.baidu.swan.pms.c.b;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.node.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    @Nullable
    private g enP;
    @Nullable
    private g enQ;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.enP = gVar3;
        this.enQ = gVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cL */
    public com.baidu.swan.pms.c.c.e cG(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cT(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.e eVar) {
        this.enl.asM();
        com.baidu.swan.pms.g.a.k(this.cYk.getCategory(), eVar.maxAge);
        f.b(eVar.data, (this.enl == this.enP || this.enl == this.enQ) ? null : this.enl, this.enP, this.enQ);
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
    protected String bdU() {
        return "updatecore";
    }
}
