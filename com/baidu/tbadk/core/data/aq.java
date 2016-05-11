package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class aq {
    private aa PA;
    private List<e> PC;
    private String PD;
    private List<f> PE;
    private String PF;
    private List<z> PG;

    public aa qm() {
        return this.PA;
    }

    public List<e> qn() {
        return this.PC;
    }

    public String qo() {
        return this.PD;
    }

    public List<f> qp() {
        return this.PE;
    }

    public String qq() {
        return this.PF;
    }

    public List<z> qr() {
        return this.PG;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.PA = new aa();
            this.PA.a(seniorLottery.theme);
            this.PC = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.PC.add(eVar);
            }
            this.PD = seniorLottery.myaward;
            this.PE = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.PE.add(fVar);
            }
            this.PF = seniorLottery.act_desc;
            this.PG = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                z zVar = new z();
                zVar.a(seniorLottery.act_regular.get(i3));
                this.PG.add(zVar);
            }
        }
    }
}
