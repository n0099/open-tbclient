package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj dqf;
    private List<h> dqg;
    private String dqh;
    private List<i> dqi;
    private String dqj;
    private List<ai> dqk;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.dqf = new aj();
            this.dqf.a(seniorLottery.theme);
            this.dqg = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.dqg.add(hVar);
            }
            this.dqh = seniorLottery.myaward;
            this.dqi = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.dqi.add(iVar);
            }
            this.dqj = seniorLottery.act_desc;
            this.dqk = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.dqk.add(aiVar);
            }
        }
    }
}
