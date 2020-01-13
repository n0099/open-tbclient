package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj cMD;
    private List<h> cME;
    private String cMF;
    private List<i> cMG;
    private String cMH;
    private List<ai> cMI;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.cMD = new aj();
            this.cMD.a(seniorLottery.theme);
            this.cME = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.cME.add(hVar);
            }
            this.cMF = seniorLottery.myaward;
            this.cMG = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.cMG.add(iVar);
            }
            this.cMH = seniorLottery.act_desc;
            this.cMI = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.cMI.add(aiVar);
            }
        }
    }
}
