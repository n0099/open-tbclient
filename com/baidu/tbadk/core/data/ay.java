package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ay {
    private String ahA;
    private List<ag> ahB;
    private ah ahw;
    private List<f> ahx;
    private String ahy;
    private List<g> ahz;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.ahw = new ah();
            this.ahw.a(seniorLottery.theme);
            this.ahx = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.ahx.add(fVar);
            }
            this.ahy = seniorLottery.myaward;
            this.ahz = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.ahz.add(gVar);
            }
            this.ahA = seniorLottery.act_desc;
            this.ahB = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ag agVar = new ag();
                agVar.a(seniorLottery.act_regular.get(i3));
                this.ahB.add(agVar);
            }
        }
    }
}
