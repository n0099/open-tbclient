package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ai bAq;
    private List<h> bAr;
    private String bAs;
    private List<i> bAt;
    private String bAu;
    private List<ah> bAv;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bAq = new ai();
            this.bAq.a(seniorLottery.theme);
            this.bAr = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bAr.add(hVar);
            }
            this.bAs = seniorLottery.myaward;
            this.bAt = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bAt.add(iVar);
            }
            this.bAu = seniorLottery.act_desc;
            this.bAv = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bAv.add(ahVar);
            }
        }
    }
}
