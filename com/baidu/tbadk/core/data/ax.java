package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag Ym;
    private List<e> Yn;
    private String Yo;
    private List<f> Yp;
    private String Yq;
    private List<af> Yr;

    public ag qL() {
        return this.Ym;
    }

    public List<e> qM() {
        return this.Yn;
    }

    public String qN() {
        return this.Yo;
    }

    public List<f> qO() {
        return this.Yp;
    }

    public String qP() {
        return this.Yq;
    }

    public List<af> qQ() {
        return this.Yr;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Ym = new ag();
            this.Ym.a(seniorLottery.theme);
            this.Yn = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.Yn.add(eVar);
            }
            this.Yo = seniorLottery.myaward;
            this.Yp = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.Yp.add(fVar);
            }
            this.Yq = seniorLottery.act_desc;
            this.Yr = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.Yr.add(afVar);
            }
        }
    }
}
