package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class br {
    private ap eoF;
    private List<g> eoG;
    private String eoH;
    private List<h> eoI;
    private String eoJ;
    private List<ao> eoK;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eoF = new ap();
            this.eoF.a(seniorLottery.theme);
            this.eoG = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.eoG.add(gVar);
            }
            this.eoH = seniorLottery.myaward;
            this.eoI = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.eoI.add(hVar);
            }
            this.eoJ = seniorLottery.act_desc;
            this.eoK = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ao aoVar = new ao();
                aoVar.a(seniorLottery.act_regular.get(i3));
                this.eoK.add(aoVar);
            }
        }
    }
}
