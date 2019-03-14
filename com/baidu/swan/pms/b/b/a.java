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
            this.bmf.a(bVar);
            return bVar;
        } else if (!a(aA)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RL().toString());
            this.bmf.a(bVar2);
            return bVar2;
        } else {
            this.bmf.zC();
            com.baidu.swan.pms.c.a.V(aA.auh);
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(aA.bmL, eVar);
            a(aA.bmM, eVar);
            if (eVar.Sq() == 0) {
                this.bmf.zz();
            } else {
                this.bmf.a(eVar);
                com.baidu.swan.pms.b.a.a.a(aA, this.bmf);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.bmL == null || aVar.bmL.RK()) {
            return aVar.bmM == null || aVar.bmM.RK();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RM() {
        return "updatecore";
    }
}
