package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.f.f;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class d extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.d> {
    public d(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cq */
    public com.baidu.swan.pms.c.c.d bL(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.e.cy(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.d dVar) {
        this.dwq.abX();
        f fVar = new f();
        a(dVar.dwX, fVar);
        if (fVar.aMl() == 0) {
            this.dwq.Zs();
            return null;
        }
        this.dwq.a(fVar);
        com.baidu.swan.pms.c.a.a.a(dVar, this.dwq);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.d dVar) {
        if (dVar == null || dVar.dwX == null) {
            return false;
        }
        for (com.baidu.swan.pms.model.g gVar : dVar.dwX) {
            if (!gVar.acP()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ayY() {
        return "getpkg";
    }
}
