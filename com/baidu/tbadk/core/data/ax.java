package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag atu;
    private List<f> atv;
    private String atw;
    private List<g> atx;
    private String aty;
    private List<af> atz;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.atu = new ag();
            this.atu.a(seniorLottery.theme);
            this.atv = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.atv.add(fVar);
            }
            this.atw = seniorLottery.myaward;
            this.atx = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.atx.add(gVar);
            }
            this.aty = seniorLottery.act_desc;
            this.atz = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.atz.add(afVar);
            }
        }
    }
}
