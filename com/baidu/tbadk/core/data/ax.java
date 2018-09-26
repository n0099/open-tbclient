package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag ajJ;
    private List<f> ajK;
    private String ajL;
    private List<g> ajM;
    private String ajN;
    private List<af> ajO;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.ajJ = new ag();
            this.ajJ.a(seniorLottery.theme);
            this.ajK = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.ajK.add(fVar);
            }
            this.ajL = seniorLottery.myaward;
            this.ajM = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.ajM.add(gVar);
            }
            this.ajN = seniorLottery.act_desc;
            this.ajO = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.ajO.add(afVar);
            }
        }
    }
}
