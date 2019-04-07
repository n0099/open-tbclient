package com.baidu.swan.pms.b.b;

import com.baidu.swan.pms.a.e;
import com.baidu.swan.pms.b.d;
import com.baidu.swan.pms.model.i;
/* loaded from: classes2.dex */
public class b extends d<com.baidu.swan.pms.b.c.b> {
    public b(e eVar, com.baidu.swan.pms.b.d.c cVar) {
        super(eVar, cVar);
    }

    @Override // com.baidu.swan.pms.b.d
    protected com.baidu.swan.pms.model.b a(com.baidu.swan.pms.b.c cVar) {
        com.baidu.swan.pms.b.c.b ay = com.baidu.swan.pms.d.d.ay(cVar.RJ());
        if (ay == null) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2102, "response data empty");
            this.bmi.a(bVar);
            return bVar;
        } else if (!a(ay)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RJ().toString());
            this.bmi.a(bVar2);
            return bVar2;
        } else {
            this.bmi.zB();
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(ay.bmb, eVar);
            a(ay.bmQ, eVar);
            a(ay.bmO, eVar);
            a(ay.bmP, eVar);
            i(ay.bmR);
            if (eVar.So() == 0) {
                this.bmi.zy();
            } else {
                this.bmi.a(eVar);
                com.baidu.swan.pms.b.a.a.a(ay, this.bmi);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.bmb == null && ((bVar.bmQ == null || bVar.bmQ.isEmpty()) && bVar.bmO == null && bVar.bmP == null && bVar.bmR == null)) {
            return false;
        }
        if (bVar.bmb == null || bVar.bmb.RI()) {
            if (bVar.bmQ != null) {
                for (i iVar : bVar.bmQ) {
                    if (!iVar.RI()) {
                        return false;
                    }
                }
            }
            if (bVar.bmO == null || bVar.bmO.RI()) {
                if (bVar.bmP == null || bVar.bmP.RI()) {
                    return bVar.bmR == null || bVar.bmR.RI();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RK() {
        return "getpkg";
    }
}
