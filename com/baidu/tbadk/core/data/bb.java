package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ai bAs;
    private List<h> bAt;
    private String bAu;
    private List<i> bAv;
    private String bAw;
    private List<ah> bAx;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bAs = new ai();
            this.bAs.a(seniorLottery.theme);
            this.bAt = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bAt.add(hVar);
            }
            this.bAu = seniorLottery.myaward;
            this.bAv = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bAv.add(iVar);
            }
            this.bAw = seniorLottery.act_desc;
            this.bAx = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bAx.add(ahVar);
            }
        }
    }
}
