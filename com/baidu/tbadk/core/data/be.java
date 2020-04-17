package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj dqb;
    private List<h> dqc;
    private String dqd;
    private List<i> dqe;
    private String dqf;
    private List<ai> dqg;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.dqb = new aj();
            this.dqb.a(seniorLottery.theme);
            this.dqc = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.dqc.add(hVar);
            }
            this.dqd = seniorLottery.myaward;
            this.dqe = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.dqe.add(iVar);
            }
            this.dqf = seniorLottery.act_desc;
            this.dqg = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.dqg.add(aiVar);
            }
        }
    }
}
