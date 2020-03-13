package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj cQI;
    private List<h> cQJ;
    private String cQK;
    private List<i> cQL;
    private String cQM;
    private List<ai> cQN;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.cQI = new aj();
            this.cQI.a(seniorLottery.theme);
            this.cQJ = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.cQJ.add(hVar);
            }
            this.cQK = seniorLottery.myaward;
            this.cQL = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.cQL.add(iVar);
            }
            this.cQM = seniorLottery.act_desc;
            this.cQN = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.cQN.add(aiVar);
            }
        }
    }
}
