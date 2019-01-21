package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private List<af> atA;
    private ag atv;
    private List<f> atw;
    private String atx;
    private List<g> aty;
    private String atz;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.atv = new ag();
            this.atv.a(seniorLottery.theme);
            this.atw = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.atw.add(fVar);
            }
            this.atx = seniorLottery.myaward;
            this.aty = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.aty.add(gVar);
            }
            this.atz = seniorLottery.act_desc;
            this.atA = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.atA.add(afVar);
            }
        }
    }
}
