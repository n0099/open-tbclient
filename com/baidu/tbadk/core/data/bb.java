package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ak XJ;
    private List<e> XK;
    private String XL;
    private List<f> XM;
    private String XN;
    private List<aj> XO;

    public ak rE() {
        return this.XJ;
    }

    public List<e> rF() {
        return this.XK;
    }

    public String rG() {
        return this.XL;
    }

    public List<f> rH() {
        return this.XM;
    }

    public String rI() {
        return this.XN;
    }

    public List<aj> rJ() {
        return this.XO;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.XJ = new ak();
            this.XJ.a(seniorLottery.theme);
            this.XK = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.XK.add(eVar);
            }
            this.XL = seniorLottery.myaward;
            this.XM = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.XM.add(fVar);
            }
            this.XN = seniorLottery.act_desc;
            this.XO = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aj ajVar = new aj();
                ajVar.a(seniorLottery.act_regular.get(i3));
                this.XO.add(ajVar);
            }
        }
    }
}
