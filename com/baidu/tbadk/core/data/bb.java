package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ak XI;
    private List<e> XJ;
    private String XK;
    private List<f> XL;
    private String XM;
    private List<aj> XN;

    public ak rE() {
        return this.XI;
    }

    public List<e> rF() {
        return this.XJ;
    }

    public String rG() {
        return this.XK;
    }

    public List<f> rH() {
        return this.XL;
    }

    public String rI() {
        return this.XM;
    }

    public List<aj> rJ() {
        return this.XN;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.XI = new ak();
            this.XI.a(seniorLottery.theme);
            this.XJ = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.XJ.add(eVar);
            }
            this.XK = seniorLottery.myaward;
            this.XL = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.XL.add(fVar);
            }
            this.XM = seniorLottery.act_desc;
            this.XN = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aj ajVar = new aj();
                ajVar.a(seniorLottery.act_regular.get(i3));
                this.XN.add(ajVar);
            }
        }
    }
}
