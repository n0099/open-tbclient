package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aps;
    private List<f> apt;
    private String apu;
    private List<g> apv;
    private String apw;
    private List<af> apx;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aps = new ag();
            this.aps.a(seniorLottery.theme);
            this.apt = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.apt.add(fVar);
            }
            this.apu = seniorLottery.myaward;
            this.apv = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.apv.add(gVar);
            }
            this.apw = seniorLottery.act_desc;
            this.apx = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.apx.add(afVar);
            }
        }
    }
}
