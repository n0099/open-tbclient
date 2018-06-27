package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ay {
    private ah ahP;
    private List<f> ahQ;
    private String ahR;
    private List<g> ahS;
    private String ahT;
    private List<ag> ahU;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.ahP = new ah();
            this.ahP.a(seniorLottery.theme);
            this.ahQ = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.ahQ.add(fVar);
            }
            this.ahR = seniorLottery.myaward;
            this.ahS = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.ahS.add(gVar);
            }
            this.ahT = seniorLottery.act_desc;
            this.ahU = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ag agVar = new ag();
                agVar.a(seniorLottery.act_regular.get(i3));
                this.ahU.add(agVar);
            }
        }
    }
}
