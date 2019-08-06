package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bc {
    private ai bIO;
    private List<h> bIP;
    private String bIQ;
    private List<i> bIR;
    private String bIS;
    private List<ah> bIT;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bIO = new ai();
            this.bIO.a(seniorLottery.theme);
            this.bIP = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bIP.add(hVar);
            }
            this.bIQ = seniorLottery.myaward;
            this.bIR = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bIR.add(iVar);
            }
            this.bIS = seniorLottery.act_desc;
            this.bIT = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bIT.add(ahVar);
            }
        }
    }
}
