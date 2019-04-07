package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private List<ah> bAA;
    private ai bAv;
    private List<h> bAw;
    private String bAx;
    private List<i> bAy;
    private String bAz;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bAv = new ai();
            this.bAv.a(seniorLottery.theme);
            this.bAw = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bAw.add(hVar);
            }
            this.bAx = seniorLottery.myaward;
            this.bAy = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bAy.add(iVar);
            }
            this.bAz = seniorLottery.act_desc;
            this.bAA = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bAA.add(ahVar);
            }
        }
    }
}
