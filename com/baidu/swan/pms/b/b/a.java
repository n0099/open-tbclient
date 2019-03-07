package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.e;
import com.baidu.swan.pms.b.d;
/* loaded from: classes2.dex */
public class a extends d<com.baidu.swan.pms.b.c.a> {
    public a(e eVar, com.baidu.swan.pms.b.d.c cVar) {
        super(eVar, cVar);
    }

    @Override // com.baidu.swan.pms.b.d
    protected com.baidu.swan.pms.model.b a(com.baidu.swan.pms.b.c cVar) {
        com.baidu.swan.pms.b.c.a aA = com.baidu.swan.pms.d.d.aA(cVar.RL());
        if (aA == null) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2102, "response data empty");
            this.bme.a(bVar);
            return bVar;
        } else if (!a(aA)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RL().toString());
            this.bme.a(bVar2);
            return bVar2;
        } else {
            this.bme.zC();
            com.baidu.swan.pms.c.a.V(aA.aug);
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(aA.bmK, eVar);
            a(aA.bmL, eVar);
            if (eVar.Sq() == 0) {
                this.bme.zz();
            } else {
                this.bme.a(eVar);
                com.baidu.swan.pms.b.a.a.a(aA, this.bme);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.bmK == null || aVar.bmK.RK()) {
            return aVar.bmL == null || aVar.bmL.RK();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RM() {
        return "updatecore";
    }
}
