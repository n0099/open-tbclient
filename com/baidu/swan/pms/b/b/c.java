package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.e;
import com.baidu.swan.pms.b.d;
import com.baidu.swan.pms.model.i;
/* loaded from: classes2.dex */
public class c extends d<com.baidu.swan.pms.b.c.c> {
    public c(e eVar, com.baidu.swan.pms.b.d.c cVar) {
        super(eVar, cVar);
    }

    @Override // com.baidu.swan.pms.b.d
    protected com.baidu.swan.pms.model.b a(com.baidu.swan.pms.b.c cVar) {
        com.baidu.swan.pms.b.c.c az = com.baidu.swan.pms.d.d.az(cVar.RL());
        if (az == null) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2102, "response data empty");
            this.bme.a(bVar);
            return bVar;
        } else if (!a(az)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RL().toString());
            this.bme.a(bVar2);
            return bVar2;
        } else {
            this.bme.zC();
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(az.bmM, eVar);
            if (eVar.Sq() == 0) {
                this.bme.zz();
            } else {
                this.bme.a(eVar);
                com.baidu.swan.pms.b.a.a.a(az, this.bme);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.c cVar) {
        if (cVar == null || cVar.bmM == null) {
            return false;
        }
        for (i iVar : cVar.bmM) {
            if (!iVar.RK()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RM() {
        return "getpkg";
    }
}
