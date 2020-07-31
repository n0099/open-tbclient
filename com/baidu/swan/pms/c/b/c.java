package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.f.f;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class c extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.c> {
    public c(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cp */
    public com.baidu.swan.pms.c.c.c bL(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.e.cB(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.c cVar) {
        this.dwq.abX();
        f fVar = new f();
        a(cVar.dxd, fVar);
        if (fVar.aMl() == 0) {
            this.dwq.Zs();
            return null;
        }
        this.dwq.a(fVar);
        com.baidu.swan.pms.c.a.a.a(cVar, this.dwq);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.c cVar) {
        if (cVar == null) {
            return false;
        }
        return cVar.dxd == null || cVar.dxd.acP();
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ayY() {
        return "getplugin";
    }
}
