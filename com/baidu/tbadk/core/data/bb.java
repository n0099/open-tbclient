package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ai SZ;
    private List<d> Ta;
    private String Tb;
    private List<e> Tc;
    private String Td;
    private List<ah> Te;

    public ai re() {
        return this.SZ;
    }

    public List<d> rf() {
        return this.Ta;
    }

    public String rg() {
        return this.Tb;
    }

    public List<e> rh() {
        return this.Tc;
    }

    public String ri() {
        return this.Td;
    }

    public List<ah> rj() {
        return this.Te;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.SZ = new ai();
            this.SZ.a(seniorLottery.theme);
            this.Ta = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                d dVar = new d();
                dVar.a(seniorLottery.award_info.get(i));
                this.Ta.add(dVar);
            }
            this.Tb = seniorLottery.myaward;
            this.Tc = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                e eVar = new e();
                eVar.a(seniorLottery.luck_users.get(i2));
                this.Tc.add(eVar);
            }
            this.Td = seniorLottery.act_desc;
            this.Te = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.Te.add(ahVar);
            }
        }
    }
}
