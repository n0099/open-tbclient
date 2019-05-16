package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ai bHI;
    private List<h> bHJ;
    private String bHK;
    private List<i> bHL;
    private String bHM;
    private List<ah> bHN;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bHI = new ai();
            this.bHI.a(seniorLottery.theme);
            this.bHJ = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bHJ.add(hVar);
            }
            this.bHK = seniorLottery.myaward;
            this.bHL = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bHL.add(iVar);
            }
            this.bHM = seniorLottery.act_desc;
            this.bHN = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bHN.add(ahVar);
            }
        }
    }
}
