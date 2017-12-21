package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag Yp;
    private List<e> Yq;
    private String Yr;
    private List<f> Ys;
    private String Yt;
    private List<af> Yu;

    public ag qL() {
        return this.Yp;
    }

    public List<e> qM() {
        return this.Yq;
    }

    public String qN() {
        return this.Yr;
    }

    public List<f> qO() {
        return this.Ys;
    }

    public String qP() {
        return this.Yt;
    }

    public List<af> qQ() {
        return this.Yu;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Yp = new ag();
            this.Yp.a(seniorLottery.theme);
            this.Yq = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.Yq.add(eVar);
            }
            this.Yr = seniorLottery.myaward;
            this.Ys = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.Ys.add(fVar);
            }
            this.Yt = seniorLottery.act_desc;
            this.Yu = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.Yu.add(afVar);
            }
        }
    }
}
