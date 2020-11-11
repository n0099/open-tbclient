package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class br {
    private ap eCU;
    private List<g> eCV;
    private String eCW;
    private List<h> eCX;
    private String eCY;
    private List<ao> eCZ;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eCU = new ap();
            this.eCU.a(seniorLottery.theme);
            this.eCV = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.eCV.add(gVar);
            }
            this.eCW = seniorLottery.myaward;
            this.eCX = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.eCX.add(hVar);
            }
            this.eCY = seniorLottery.act_desc;
            this.eCZ = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ao aoVar = new ao();
                aoVar.a(seniorLottery.act_regular.get(i3));
                this.eCZ.add(aoVar);
            }
        }
    }
}
