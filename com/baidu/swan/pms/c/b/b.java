package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cI */
    public com.baidu.swan.pms.c.c.b cG(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cR(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ak(com.baidu.swan.pms.c.c.b bVar) {
        this.enl.asM();
        f fVar = new f();
        a(bVar.enS, fVar);
        a(bVar.enT, fVar);
        a(bVar.enW, fVar);
        a(bVar.enY, fVar);
        v(bVar.enX);
        if (fVar.beW() == 0) {
            this.enl.apQ();
            return null;
        }
        this.enl.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.enl);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean al(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.enS == null && ((bVar.enT == null || bVar.enT.isEmpty()) && bVar.enW == null && bVar.enY == null && bVar.enX == null)) {
            return false;
        }
        if (bVar.enS == null || bVar.enS.atE()) {
            if (bVar.enT != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.enT) {
                    if (!gVar.atE()) {
                        return false;
                    }
                }
            }
            if (bVar.enW == null || bVar.enW.atE()) {
                if (bVar.enY == null || bVar.enY.atE()) {
                    return bVar.enX == null || bVar.enX.atE();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bdU() {
        return "getpkg";
    }
}
