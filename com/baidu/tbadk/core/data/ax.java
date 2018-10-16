package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aoE;
    private List<f> aoF;
    private String aoG;
    private List<g> aoH;
    private String aoI;
    private List<af> aoJ;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aoE = new ag();
            this.aoE.a(seniorLottery.theme);
            this.aoF = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.aoF.add(fVar);
            }
            this.aoG = seniorLottery.myaward;
            this.aoH = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.aoH.add(gVar);
            }
            this.aoI = seniorLottery.act_desc;
            this.aoJ = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aoJ.add(afVar);
            }
        }
    }
}
