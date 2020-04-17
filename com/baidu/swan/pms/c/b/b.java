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
    /* renamed from: ca */
    public com.baidu.swan.pms.c.c.b bA(JSONObject jSONObject) {
        return com.baidu.swan.pms.f.d.ce(jSONObject);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: a */
    public com.baidu.swan.pms.model.a S(com.baidu.swan.pms.c.c.b bVar) {
        this.dax.Xe();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.dbc, eVar);
        a(bVar.dbf, eVar);
        a(bVar.dbg, eVar);
        a(bVar.dbi, eVar);
        p(bVar.dbh);
        if (eVar.aCH() == 0) {
            this.dax.Xa();
            return null;
        }
        this.dax.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.dax);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean R(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.dbc == null && ((bVar.dbf == null || bVar.dbf.isEmpty()) && bVar.dbg == null && bVar.dbi == null && bVar.dbh == null)) {
            return false;
        }
        if (bVar.dbc == null || bVar.dbc.XM()) {
            if (bVar.dbf != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dbf) {
                    if (!gVar.XM()) {
                        return false;
                    }
                }
            }
            if (bVar.dbg == null || bVar.dbg.XM()) {
                if (bVar.dbi == null || bVar.dbi.XM()) {
                    return bVar.dbh == null || bVar.dbh.XM();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arw() {
        return "getpkg";
    }
}
