package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes24.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cw */
    public com.baidu.swan.pms.c.c.b cu(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cF(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ah(com.baidu.swan.pms.c.c.b bVar) {
        this.dHC.ajg();
        f fVar = new f();
        a(bVar.dIj, fVar);
        a(bVar.dIk, fVar);
        a(bVar.dIn, fVar);
        a(bVar.dIp, fVar);
        v(bVar.dIo);
        if (fVar.aVw() == 0) {
            this.dHC.agl();
            return null;
        }
        this.dHC.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dHC);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ai(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.dIj == null && ((bVar.dIk == null || bVar.dIk.isEmpty()) && bVar.dIn == null && bVar.dIp == null && bVar.dIo == null)) {
            return false;
        }
        if (bVar.dIj == null || bVar.dIj.ajY()) {
            if (bVar.dIk != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dIk) {
                    if (!gVar.ajY()) {
                        return false;
                    }
                }
            }
            if (bVar.dIn == null || bVar.dIn.ajY()) {
                if (bVar.dIp == null || bVar.dIp.ajY()) {
                    return bVar.dIo == null || bVar.dIo.ajY();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String aUu() {
        return "getpkg";
    }
}
