package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.f.f;
import org.json.JSONObject;
/* loaded from: classes19.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: co */
    public com.baidu.swan.pms.c.c.b bL(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.e.cx(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.b bVar) {
        this.dwq.abX();
        f fVar = new f();
        a(bVar.dwW, fVar);
        a(bVar.dwX, fVar);
        a(bVar.dxa, fVar);
        a(bVar.dxc, fVar);
        v(bVar.dxb);
        if (fVar.aMl() == 0) {
            this.dwq.Zs();
            return null;
        }
        this.dwq.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dwq);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean W(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.dwW == null && ((bVar.dwX == null || bVar.dwX.isEmpty()) && bVar.dxa == null && bVar.dxc == null && bVar.dxb == null)) {
            return false;
        }
        if (bVar.dwW == null || bVar.dwW.acP()) {
            if (bVar.dwX != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dwX) {
                    if (!gVar.acP()) {
                        return false;
                    }
                }
            }
            if (bVar.dxa == null || bVar.dxa.acP()) {
                if (bVar.dxc == null || bVar.dxc.acP()) {
                    return bVar.dxb == null || bVar.dxb.acP();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ayY() {
        return "getpkg";
    }
}
