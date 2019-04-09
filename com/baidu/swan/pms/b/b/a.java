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
            this.bmj.a(bVar);
            return bVar;
        } else if (!a(aA)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RJ().toString());
            this.bmj.a(bVar2);
            return bVar2;
        } else {
            this.bmj.zB();
            com.baidu.swan.pms.c.a.V(aA.aum);
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(aA.bmP, eVar);
            a(aA.bmQ, eVar);
            if (eVar.So() == 0) {
                this.bmj.zy();
            } else {
                this.bmj.a(eVar);
                com.baidu.swan.pms.b.a.a.a(aA, this.bmj);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.a aVar) {
        if (aVar == null) {
            return false;
        }
        if (aVar.bmP == null || aVar.bmP.RI()) {
            return aVar.bmQ == null || aVar.bmQ.RI();
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RK() {
        return "updatecore";
    }
}
