package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj cQV;
    private List<h> cQW;
    private String cQX;
    private List<i> cQY;
    private String cQZ;
    private List<ai> cRa;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.cQV = new aj();
            this.cQV.a(seniorLottery.theme);
            this.cQW = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.cQW.add(hVar);
            }
            this.cQX = seniorLottery.myaward;
            this.cQY = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.cQY.add(iVar);
            }
            this.cQZ = seniorLottery.act_desc;
            this.cRa = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.cRa.add(aiVar);
            }
        }
    }
}
