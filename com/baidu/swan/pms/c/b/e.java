package com.baidu.swan.pms.c.b;

import androidx.annotation.Nullable;
import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.node.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class e extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.e> {
    @Nullable
    private g ewr;
    @Nullable
    private g ews;

    public e(g gVar, com.baidu.swan.pms.c.d.g gVar2, @Nullable g gVar3, @Nullable g gVar4) {
        super(gVar, gVar2);
        this.ewr = gVar3;
        this.ews = gVar4;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cS */
    public com.baidu.swan.pms.c.c.e cN(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.da(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ao(com.baidu.swan.pms.c.c.e eVar) {
        this.evO.aqK();
        com.baidu.swan.pms.g.a.l(this.dcd.getCategory(), eVar.maxAge);
        f.b(eVar.data, (this.evO == this.ewr || this.evO == this.ews) ? null : this.evO, this.ewr, this.ews);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ap(com.baidu.swan.pms.c.c.e eVar) {
        return eVar != null;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcM() {
        return "updatecore";
    }
}
