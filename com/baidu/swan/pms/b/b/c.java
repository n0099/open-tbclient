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
        com.baidu.swan.pms.b.c.c az = com.baidu.swan.pms.d.d.az(cVar.RJ());
        if (az == null) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2102, "response data empty");
            this.bmi.a(bVar);
            return bVar;
        } else if (!a(az)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RJ().toString());
            this.bmi.a(bVar2);
            return bVar2;
        } else {
            this.bmi.zB();
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(az.bmQ, eVar);
            if (eVar.So() == 0) {
                this.bmi.zy();
            } else {
                this.bmi.a(eVar);
                com.baidu.swan.pms.b.a.a.a(az, this.bmi);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.c cVar) {
        if (cVar == null || cVar.bmQ == null) {
            return false;
        }
        for (i iVar : cVar.bmQ) {
            if (!iVar.RI()) {
                return false;
            }
        }
        return true;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RK() {
        return "getpkg";
    }
}
