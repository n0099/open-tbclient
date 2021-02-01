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
    /* renamed from: cO */
    public com.baidu.swan.pms.c.c.c cL(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.da(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.c cVar) {
        this.eun.aqH();
        f fVar = new f();
        a(cVar.eva, fVar);
        if (fVar.bdL() == 0) {
            this.eun.anG();
            return null;
        }
        this.eun.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.eun);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.eva == null || cVar.eva.arz();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcK() {
        return "getplugin";
    }
}
