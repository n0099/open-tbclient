package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bc {
    private ai bJm;
    private List<h> bJn;
    private String bJo;
    private List<i> bJp;
    private String bJq;
    private List<ah> bJr;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.bJm = new ai();
            this.bJm.a(seniorLottery.theme);
            this.bJn = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.bJn.add(hVar);
            }
            this.bJo = seniorLottery.myaward;
            this.bJp = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.bJp.add(iVar);
            }
            this.bJq = seniorLottery.act_desc;
            this.bJr = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.bJr.add(ahVar);
            }
        }
    }
}
