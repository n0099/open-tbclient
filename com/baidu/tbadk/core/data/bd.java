package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private am WW;
    private List<e> WX;
    private String WY;
    private List<f> WZ;
    private String Xa;
    private List<al> Xb;

    public am qK() {
        return this.WW;
    }

    public List<e> qL() {
        return this.WX;
    }

    public String qM() {
        return this.WY;
    }

    public List<f> qN() {
        return this.WZ;
    }

    public String qO() {
        return this.Xa;
    }

    public List<al> qP() {
        return this.Xb;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.WW = new am();
            this.WW.a(seniorLottery.theme);
            this.WX = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.WX.add(eVar);
            }
            this.WY = seniorLottery.myaward;
            this.WZ = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.WZ.add(fVar);
            }
            this.Xa = seniorLottery.act_desc;
            this.Xb = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                al alVar = new al();
                alVar.a(seniorLottery.act_regular.get(i3));
                this.Xb.add(alVar);
            }
        }
    }
}
