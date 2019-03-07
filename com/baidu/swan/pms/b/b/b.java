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
            this.bme.a(bVar);
            return bVar;
        } else if (!a(ay)) {
            com.baidu.swan.pms.model.b bVar2 = new com.baidu.swan.pms.model.b(2103, cVar.RL().toString());
            this.bme.a(bVar2);
            return bVar2;
        } else {
            this.bme.zC();
            com.baidu.swan.pms.d.e eVar = new com.baidu.swan.pms.d.e();
            a(ay.blX, eVar);
            a(ay.bmM, eVar);
            a(ay.bmK, eVar);
            a(ay.bmL, eVar);
            i(ay.bmN);
            if (eVar.Sq() == 0) {
                this.bme.zz();
            } else {
                this.bme.a(eVar);
                com.baidu.swan.pms.b.a.a.a(ay, this.bme);
            }
            return null;
        }
    }

    protected boolean a(com.baidu.swan.pms.b.c.b bVar) {
        if (bVar == null) {
            return false;
        }
        if (bVar.blX == null && ((bVar.bmM == null || bVar.bmM.isEmpty()) && bVar.bmK == null && bVar.bmL == null && bVar.bmN == null)) {
            return false;
        }
        if (bVar.blX == null || bVar.blX.RK()) {
            if (bVar.bmM != null) {
                for (i iVar : bVar.bmM) {
                    if (!iVar.RK()) {
                        return false;
                    }
                }
            }
            if (bVar.bmK == null || bVar.bmK.RK()) {
                if (bVar.bmL == null || bVar.bmL.RK()) {
                    return bVar.bmN == null || bVar.bmN.RK();
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
