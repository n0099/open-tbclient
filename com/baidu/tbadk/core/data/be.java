package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private an WW;
    private List<f> WX;
    private String WY;
    private List<g> WZ;
    private String Xa;
    private List<am> Xb;

    public an qH() {
        return this.WW;
    }

    public List<f> qI() {
        return this.WX;
    }

    public String qJ() {
        return this.WY;
    }

    public List<g> qK() {
        return this.WZ;
    }

    public String qL() {
        return this.Xa;
    }

    public List<am> qM() {
        return this.Xb;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.WW = new an();
            this.WW.a(seniorLottery.theme);
            this.WX = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.WX.add(fVar);
            }
            this.WY = seniorLottery.myaward;
            this.WZ = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.WZ.add(gVar);
            }
            this.Xa = seniorLottery.act_desc;
            this.Xb = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                am amVar = new am();
                amVar.a(seniorLottery.act_regular.get(i3));
                this.Xb.add(amVar);
            }
        }
    }
}
