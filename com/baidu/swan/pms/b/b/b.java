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
        com.baidu.swan.pms.b.c.b ay = com.baidu.swan.pms.d.d.ay(cVar.RL());
        if (ay == null) {
            com.baidu.swan.pms.model.b bVar = new com.baidu.swan.pms.model.b(2102, "response data empty");
            this.bmf.a(bVar);
            return bVar;
        } else if (!a(ay)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RL().toString());
            this.bmf.a(bVar2);
            return bVar2;
        } else {
            this.bmf.zC();
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(ay.blY, eVar);
            a(ay.bmN, eVar);
            a(ay.bmL, eVar);
            a(ay.bmM, eVar);
            i(ay.bmO);
            if (eVar.Sq() == 0) {
                this.bmf.zz();
            } else {
                this.bmf.a(eVar);
                com.baidu.swan.pms.b.a.a.a(ay, this.bmf);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.blY == null && ((bVar.bmN == null || bVar.bmN.isEmpty()) && bVar.bmL == null && bVar.bmM == null && bVar.bmO == null)) {
            return false;
        }
        if (bVar.blY == null || bVar.blY.RK()) {
            if (bVar.bmN != null) {
                for (i iVar : bVar.bmN) {
                    if (!iVar.RK()) {
                        return false;
                    }
                }
            }
            if (bVar.bmL == null || bVar.bmL.RK()) {
                if (bVar.bmM == null || bVar.bmM.RK()) {
                    return bVar.bmO == null || bVar.bmO.RK();
                }
                return false;
            }
            return false;
        }
        return false;
    }

    @Override // com.baidu.swan.pms.b.d
    protected String RM() {
        return "getpkg";
    }
}
