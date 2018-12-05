package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag asS;
    private List<f> asT;
    private String asU;
    private List<g> asV;
    private String asW;
    private List<af> asX;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.asS = new ag();
            this.asS.a(seniorLottery.theme);
            this.asT = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.asT.add(fVar);
            }
            this.asU = seniorLottery.myaward;
            this.asV = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.asV.add(gVar);
            }
            this.asW = seniorLottery.act_desc;
            this.asX = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.asX.add(afVar);
            }
        }
    }
}
