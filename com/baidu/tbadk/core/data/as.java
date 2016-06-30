package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class as {
    private ac PM;
    private List<d> PN;
    private String PO;
    private List<e> PP;
    private String PQ;
    private List<ab> PR;

    public ac qg() {
        return this.PM;
    }

    public List<d> qh() {
        return this.PN;
    }

    public String qi() {
        return this.PO;
    }

    public List<e> qj() {
        return this.PP;
    }

    public String qk() {
        return this.PQ;
    }

    public List<ab> ql() {
        return this.PR;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.PM = new ac();
            this.PM.a(seniorLottery.theme);
            this.PN = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                d dVar = new d();
                dVar.a(seniorLottery.award_info.get(i));
                this.PN.add(dVar);
            }
            this.PO = seniorLottery.myaward;
            this.PP = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                e eVar = new e();
                eVar.a(seniorLottery.luck_users.get(i2));
                this.PP.add(eVar);
            }
            this.PQ = seniorLottery.act_desc;
            this.PR = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ab abVar = new ab();
                abVar.a(seniorLottery.act_regular.get(i3));
                this.PR.add(abVar);
            }
        }
    }
}
