package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private String bAA;
    private List<ah> bAB;
    private ai bAw;
    private List<h> bAx;
    private String bAy;
    private List<i> bAz;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bAw = new ai();
            this.bAw.a(seniorLottery.theme);
            this.bAx = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bAx.add(hVar);
            }
            this.bAy = seniorLottery.myaward;
            this.bAz = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bAz.add(iVar);
            }
            this.bAA = seniorLottery.act_desc;
            this.bAB = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bAB.add(ahVar);
            }
        }
    }
}
