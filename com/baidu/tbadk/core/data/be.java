package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj cQH;
    private List<h> cQI;
    private String cQJ;
    private List<i> cQK;
    private String cQL;
    private List<ai> cQM;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.cQH = new aj();
            this.cQH.a(seniorLottery.theme);
            this.cQI = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.cQI.add(hVar);
            }
            this.cQJ = seniorLottery.myaward;
            this.cQK = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.cQK.add(iVar);
            }
            this.cQL = seniorLottery.act_desc;
            this.cQM = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.cQM.add(aiVar);
            }
        }
    }
}
