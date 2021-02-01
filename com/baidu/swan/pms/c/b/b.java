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
    /* renamed from: cN */
    public com.baidu.swan.pms.c.c.b cL(JSONObject jSONObject) {
        return com.baidu.swan.pms.utils.e.cW(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a am(com.baidu.swan.pms.c.c.b bVar) {
        this.eun.aqH();
        f fVar = new f();
        a(bVar.euT, fVar);
        a(bVar.euU, fVar);
        a(bVar.euX, fVar);
        a(bVar.euZ, fVar);
        v(bVar.euY);
        if (fVar.bdL() == 0) {
            this.eun.anG();
            return null;
        }
        this.eun.a(fVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.eun);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean an(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.euT == null && ((bVar.euU == null || bVar.euU.isEmpty()) && bVar.euX == null && bVar.euZ == null && bVar.euY == null)) {
            return false;
        }
        if (bVar.euT == null || bVar.euT.arz()) {
            if (bVar.euU != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.euU) {
                    if (!gVar.arz()) {
                        return false;
                    }
                }
            }
            if (bVar.euX == null || bVar.euX.arz()) {
                if (bVar.euZ == null || bVar.euZ.arz()) {
                    return bVar.euY == null || bVar.euY.arz();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String bcK() {
        return "getpkg";
    }
}
