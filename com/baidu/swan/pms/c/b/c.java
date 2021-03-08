package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cQ */
    public com.baidu.swan.pms.c.c.c cN(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.dc(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ao(com.baidu.swan.pms.c.c.c cVar) {
        this.evO.aqK();
        f fVar = new f();
        a(cVar.ewB, fVar);
        if (fVar.bdN() == 0) {
            this.evO.anJ();
            return null;
        }
        this.evO.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.evO);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ap(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.ewB == null || cVar.ewB.arC();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcM() {
        return "getplugin";
    }
}
