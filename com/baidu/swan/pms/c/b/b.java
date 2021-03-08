package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.utils.f;
import org.json.JSONObject;
/* loaded from: classes3.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, com.baidu.swan.pms.c.d.g gVar2) {
        super(gVar, gVar2);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cP */
    public com.baidu.swan.pms.c.c.b cN(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cY(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a ao(com.baidu.swan.pms.c.c.b bVar) {
        this.evO.aqK();
        f fVar = new f();
        a(bVar.ewu, fVar);
        a(bVar.ewv, fVar);
        a(bVar.ewy, fVar);
        a(bVar.ewA, fVar);
        v(bVar.ewz);
        if (fVar.bdN() == 0) {
            this.evO.anJ();
            return null;
        }
        this.evO.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.evO);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean ap(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.ewu == null && ((bVar.ewv == null || bVar.ewv.isEmpty()) && bVar.ewy == null && bVar.ewA == null && bVar.ewz == null)) {
            return false;
        }
        if (bVar.ewu == null || bVar.ewu.arC()) {
            if (bVar.ewv != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.ewv) {
                    if (!gVar.arC()) {
                        return false;
                    }
                }
            }
            if (bVar.ewy == null || bVar.ewy.arC()) {
                if (bVar.ewA == null || bVar.ewA.arC()) {
                    return bVar.ewz == null || bVar.ewz.arC();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcM() {
        return "getpkg";
    }
}
