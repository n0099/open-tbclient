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
            this.bmj.a(bVar);
            return bVar;
        } else if (!a(ay)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RJ().toString());
            this.bmj.a(bVar2);
            return bVar2;
        } else {
            this.bmj.zB();
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(ay.bmc, eVar);
            a(ay.bmR, eVar);
            a(ay.bmP, eVar);
            a(ay.bmQ, eVar);
            i(ay.bmS);
            if (eVar.So() == 0) {
                this.bmj.zy();
            } else {
                this.bmj.a(eVar);
                com.baidu.swan.pms.b.a.a.a(ay, this.bmj);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.bmc == null && ((bVar.bmR == null || bVar.bmR.isEmpty()) && bVar.bmP == null && bVar.bmQ == null && bVar.bmS == null)) {
            return false;
        }
        if (bVar.bmc == null || bVar.bmc.RI()) {
            if (bVar.bmR != null) {
                for (i iVar : bVar.bmR) {
                    if (!iVar.RI()) {
                        return false;
                    }
                }
            }
            if (bVar.bmP == null || bVar.bmP.RI()) {
                if (bVar.bmQ == null || bVar.bmQ.RI()) {
                    return bVar.bmS == null || bVar.bmS.RI();
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
