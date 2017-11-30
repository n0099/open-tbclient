package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag Ys;
    private List<e> Yt;
    private String Yu;
    private List<f> Yv;
    private String Yw;
    private List<af> Yx;

    public ag qN() {
        return this.Ys;
    }

    public List<e> qO() {
        return this.Yt;
    }

    public String qP() {
        return this.Yu;
    }

    public List<f> qQ() {
        return this.Yv;
    }

    public String qR() {
        return this.Yw;
    }

    public List<af> qS() {
        return this.Yx;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Ys = new ag();
            this.Ys.a(seniorLottery.theme);
            this.Yt = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.Yt.add(eVar);
            }
            this.Yu = seniorLottery.myaward;
            this.Yv = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.Yv.add(fVar);
            }
            this.Yw = seniorLottery.act_desc;
            this.Yx = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.Yx.add(afVar);
            }
        }
    }
}
