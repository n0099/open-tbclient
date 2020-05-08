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
    public com.baidu.swan.pms.model.a T(com.baidu.swan.pms.c.c.b bVar) {
        this.daD.Xd();
        com.baidu.swan.pms.f.e eVar = new com.baidu.swan.pms.f.e();
        a(bVar.dbh, eVar);
        a(bVar.dbk, eVar);
        a(bVar.dbl, eVar);
        a(bVar.dbn, eVar);
        p(bVar.dbm);
        if (eVar.aCH() == 0) {
            this.daD.WZ();
            return null;
        }
        this.daD.a(eVar);
        com.baidu.swan.pms.c.a.a.a(bVar, this.daD);
        return null;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.swan.pms.c.d
    /* renamed from: b */
    public boolean S(com.baidu.swan.pms.c.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.dbh == null && ((bVar.dbk == null || bVar.dbk.isEmpty()) && bVar.dbl == null && bVar.dbn == null && bVar.dbm == null)) {
            return false;
        }
        if (bVar.dbh == null || bVar.dbh.XL()) {
            if (bVar.dbk != null) {
                for (com.baidu.swan.pms.model.g gVar : bVar.dbk) {
                    if (!gVar.XL()) {
                        return false;
                    }
                }
            }
            if (bVar.dbl == null || bVar.dbl.XL()) {
                if (bVar.dbn == null || bVar.dbn.XL()) {
                    return bVar.dbm == null || bVar.dbm.XL();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.c.d
    protected String arv() {
        return "getpkg";
    }
}
