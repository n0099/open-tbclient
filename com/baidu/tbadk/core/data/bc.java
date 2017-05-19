package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bc {
    private al Xb;
    private List<e> Xc;
    private String Xd;
    private List<f> Xe;
    private String Xf;
    private List<ak> Xg;

    public al qO() {
        return this.Xb;
    }

    public List<e> qP() {
        return this.Xc;
    }

    public String qQ() {
        return this.Xd;
    }

    public List<f> qR() {
        return this.Xe;
    }

    public String qS() {
        return this.Xf;
    }

    public List<ak> qT() {
        return this.Xg;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Xb = new al();
            this.Xb.a(seniorLottery.theme);
            this.Xc = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.Xc.add(eVar);
            }
            this.Xd = seniorLottery.myaward;
            this.Xe = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.Xe.add(fVar);
            }
            this.Xf = seniorLottery.act_desc;
            this.Xg = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ak akVar = new ak();
                akVar.a(seniorLottery.act_regular.get(i3));
                this.Xg.add(akVar);
            }
        }
    }
}
