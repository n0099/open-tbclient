package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private af Qj;
    private List<d> Qk;
    private String Ql;
    private List<e> Qm;
    private String Qn;
    private List<ae> Qo;

    public af pP() {
        return this.Qj;
    }

    public List<d> pQ() {
        return this.Qk;
    }

    public String pR() {
        return this.Ql;
    }

    public List<e> pS() {
        return this.Qm;
    }

    public String pT() {
        return this.Qn;
    }

    public List<ae> pU() {
        return this.Qo;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Qj = new af();
            this.Qj.a(seniorLottery.theme);
            this.Qk = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                d dVar = new d();
                dVar.a(seniorLottery.award_info.get(i));
                this.Qk.add(dVar);
            }
            this.Ql = seniorLottery.myaward;
            this.Qm = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                e eVar = new e();
                eVar.a(seniorLottery.luck_users.get(i2));
                this.Qm.add(eVar);
            }
            this.Qn = seniorLottery.act_desc;
            this.Qo = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ae aeVar = new ae();
                aeVar.a(seniorLottery.act_regular.get(i3));
                this.Qo.add(aeVar);
            }
        }
    }
}
