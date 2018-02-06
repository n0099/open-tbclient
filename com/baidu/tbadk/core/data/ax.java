package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aOf;
    private List<e> aOg;
    private String aOh;
    private List<f> aOi;
    private String aOj;
    private List<af> aOk;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aOf = new ag();
            this.aOf.a(seniorLottery.theme);
            this.aOg = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.aOg.add(eVar);
            }
            this.aOh = seniorLottery.myaward;
            this.aOi = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.aOi.add(fVar);
            }
            this.aOj = seniorLottery.act_desc;
            this.aOk = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aOk.add(afVar);
            }
        }
    }
}
