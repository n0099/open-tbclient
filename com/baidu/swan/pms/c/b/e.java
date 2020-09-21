package com.baidu.swan.pms.c.b;

import android.support.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.node.f;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    @Nullable
    private g dIg;
    @Nullable
    private g dIh;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.dIg = gVar3;
        this.dIh = gVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cz */
    public com.baidu.swan.pms.c.c.e cu(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cH(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ah(com.baidu.swan.pms.c.c.e eVar) {
        this.dHC.ajg();
        com.baidu.swan.pms.g.a.k(this.csB.getCategory(), eVar.maxAge);
        f.b(eVar.data, (this.dHC == this.dIg || this.dHC == this.dIh) ? null : this.dHC, this.dIg, this.dIh);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ai(com.baidu.swan.pms.c.c.e eVar) {
        return eVar != null;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aUu() {
        return "updatecore";
    }
}
