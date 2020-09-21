package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class br {
    private ap ecA;
    private List<g> ecB;
    private String ecC;
    private List<h> ecD;
    private String ecE;
    private List<ao> ecF;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.ecA = new ap();
            this.ecA.a(seniorLottery.theme);
            this.ecB = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.ecB.add(gVar);
            }
            this.ecC = seniorLottery.myaward;
            this.ecD = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.ecD.add(hVar);
            }
            this.ecE = seniorLottery.act_desc;
            this.ecF = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ao aoVar = new ao();
                aoVar.a(seniorLottery.act_regular.get(i3));
                this.ecF.add(aoVar);
            }
        }
    }
}
