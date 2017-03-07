package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bc {
    private al Xs;
    private List<e> Xt;
    private String Xu;
    private List<f> Xv;
    private String Xw;
    private List<ak> Xx;

    public al rg() {
        return this.Xs;
    }

    public List<e> rh() {
        return this.Xt;
    }

    public String ri() {
        return this.Xu;
    }

    public List<f> rj() {
        return this.Xv;
    }

    public String rk() {
        return this.Xw;
    }

    public List<ak> rl() {
        return this.Xx;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Xs = new al();
            this.Xs.a(seniorLottery.theme);
            this.Xt = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.Xt.add(eVar);
            }
            this.Xu = seniorLottery.myaward;
            this.Xv = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.Xv.add(fVar);
            }
            this.Xw = seniorLottery.act_desc;
            this.Xx = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ak akVar = new ak();
                akVar.a(seniorLottery.act_regular.get(i3));
                this.Xx.add(akVar);
            }
        }
    }
}
