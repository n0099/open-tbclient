package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aMM;
    private List<e> aMN;
    private String aMO;
    private List<f> aMP;
    private String aMQ;
    private List<af> aMR;

    public ag ym() {
        return this.aMM;
    }

    public List<e> yn() {
        return this.aMN;
    }

    public String yo() {
        return this.aMO;
    }

    public List<f> yp() {
        return this.aMP;
    }

    public String yq() {
        return this.aMQ;
    }

    public List<af> yr() {
        return this.aMR;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aMM = new ag();
            this.aMM.a(seniorLottery.theme);
            this.aMN = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.aMN.add(eVar);
            }
            this.aMO = seniorLottery.myaward;
            this.aMP = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.aMP.add(fVar);
            }
            this.aMQ = seniorLottery.act_desc;
            this.aMR = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aMR.add(afVar);
            }
        }
    }
}
