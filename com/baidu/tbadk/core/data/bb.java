package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ai bHJ;
    private List<h> bHK;
    private String bHL;
    private List<i> bHM;
    private String bHN;
    private List<ah> bHO;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bHJ = new ai();
            this.bHJ.a(seniorLottery.theme);
            this.bHK = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bHK.add(hVar);
            }
            this.bHL = seniorLottery.myaward;
            this.bHM = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bHM.add(iVar);
            }
            this.bHN = seniorLottery.act_desc;
            this.bHO = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bHO.add(ahVar);
            }
        }
    }
}
