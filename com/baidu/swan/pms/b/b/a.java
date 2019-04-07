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
        com.baidu.swan.pms.b.c.a aA = com.baidu.swan.pms.d.d.aA(cVar.RJ());
        if (aA == null) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2102, "response data empty");
            this.bmi.a(bVar);
            return bVar;
        } else if (!a(aA)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RJ().toString());
            this.bmi.a(bVar2);
            return bVar2;
        } else {
            this.bmi.zB();
            com.baidu.swan.pms.c.a.V(aA.aul);
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(aA.bmO, eVar);
            a(aA.bmP, eVar);
            if (eVar.So() == 0) {
                this.bmi.zy();
            } else {
                this.bmi.a(eVar);
                com.baidu.swan.pms.b.a.a.a(aA, this.bmi);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.bmO == null || aVar.bmO.RI()) {
            return aVar.bmP == null || aVar.bmP.RI();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RK() {
        return "updatecore";
    }
}
