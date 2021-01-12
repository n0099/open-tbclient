package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bu {
    private ar eNs;
    private List<h> eNt;
    private String eNu;
    private List<i> eNv;
    private String eNw;
    private List<aq> eNx;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eNs = new ar();
            this.eNs.a(seniorLottery.theme);
            this.eNt = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.eNt.add(hVar);
            }
            this.eNu = seniorLottery.myaward;
            this.eNv = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.eNv.add(iVar);
            }
            this.eNw = seniorLottery.act_desc;
            this.eNx = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aq aqVar = new aq();
                aqVar.a(seniorLottery.act_regular.get(i3));
                this.eNx.add(aqVar);
            }
        }
    }
}
