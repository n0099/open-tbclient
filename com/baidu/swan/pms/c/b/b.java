package com.baidu.swan.pms.c.b;

import com.baidu.swan.pms.a.g;
import com.baidu.swan.pms.c.d.f;
import org.json.JSONObject;
/* loaded from: classes11.dex */
public class b extends com.baidu.swan.pms.c.d<com.baidu.swan.pms.c.c.b> {
    public b(g gVar, f fVar) {
        super(gVar, fVar);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: cb */
    public com.baidu.swan.pms.c.c.b bz(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.ck(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a X(com.baidu.swan.pms.c.c.b bVar) {
        this.dlN.ZP();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.dmt, eVar);
        a(bVar.dmw, eVar);
        a(bVar.dmx, eVar);
        a(bVar.dmz, eVar);
        r(bVar.dmy);
        if (eVar.aHn() == 0) {
            this.dlN.ZL();
            return null;
        }
        this.dlN.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dlN);
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
        if (bVar.dmt == null && ((bVar.dmw == null || bVar.dmw.isEmpty()) && bVar.dmx == null && bVar.dmz == null && bVar.dmy == null)) {
            return false;
        }
        if (bVar.dmt == null || bVar.dmt.aaF()) {
            if (bVar.dmw != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dmw) {
                    if (!gVar.aaF()) {
                        return false;
                    }
                }
            }
            if (bVar.dmx == null || bVar.dmx.aaF()) {
                if (bVar.dmz == null || bVar.dmz.aaF()) {
                    return bVar.dmy == null || bVar.dmy.aaF();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String ave() {
        return "getpkg";
    }
}
