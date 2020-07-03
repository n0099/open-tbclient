package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bp {
    private an dKG;
    private List<g> dKH;
    private String dKI;
    private List<h> dKJ;
    private String dKK;
    private List<am> dKL;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.dKG = new an();
            this.dKG.a(seniorLottery.theme);
            this.dKH = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.dKH.add(gVar);
            }
            this.dKI = seniorLottery.myaward;
            this.dKJ = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.dKJ.add(hVar);
            }
            this.dKK = seniorLottery.act_desc;
            this.dKL = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                am amVar = new am();
                amVar.a(seniorLottery.act_regular.get(i3));
                this.dKL.add(amVar);
            }
        }
    }
}
