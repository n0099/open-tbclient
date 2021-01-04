package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bu {
    private ar eSd;
    private List<h> eSe;
    private String eSf;
    private List<i> eSg;
    private String eSh;
    private List<aq> eSi;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eSd = new ar();
            this.eSd.a(seniorLottery.theme);
            this.eSe = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.eSe.add(hVar);
            }
            this.eSf = seniorLottery.myaward;
            this.eSg = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.eSg.add(iVar);
            }
            this.eSh = seniorLottery.act_desc;
            this.eSi = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aq aqVar = new aq();
                aqVar.a(seniorLottery.act_regular.get(i3));
                this.eSi.add(aqVar);
            }
        }
    }
}
