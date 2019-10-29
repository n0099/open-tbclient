package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bc {
    private ai caT;
    private List<h> caU;
    private String caV;
    private List<i> caW;
    private String caX;
    private List<ah> caY;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.caT = new ai();
            this.caT.a(seniorLottery.theme);
            this.caU = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.caU.add(hVar);
            }
            this.caV = seniorLottery.myaward;
            this.caW = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.caW.add(iVar);
            }
            this.caX = seniorLottery.act_desc;
            this.caY = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.caY.add(ahVar);
            }
        }
    }
}
