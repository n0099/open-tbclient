package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aMJ;
    private List<e> aMK;
    private String aML;
    private List<f> aMM;
    private String aMN;
    private List<af> aMO;

    public ag yl() {
        return this.aMJ;
    }

    public List<e> ym() {
        return this.aMK;
    }

    public String yn() {
        return this.aML;
    }

    public List<f> yo() {
        return this.aMM;
    }

    public String yp() {
        return this.aMN;
    }

    public List<af> yq() {
        return this.aMO;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aMJ = new ag();
            this.aMJ.a(seniorLottery.theme);
            this.aMK = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.aMK.add(eVar);
            }
            this.aML = seniorLottery.myaward;
            this.aMM = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.aMM.add(fVar);
            }
            this.aMN = seniorLottery.act_desc;
            this.aMO = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aMO.add(afVar);
            }
        }
    }
}
