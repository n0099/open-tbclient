package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aNV;
    private List<e> aNW;
    private String aNX;
    private List<f> aNY;
    private String aNZ;
    private List<af> aOa;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aNV = new ag();
            this.aNV.a(seniorLottery.theme);
            this.aNW = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.aNW.add(eVar);
            }
            this.aNX = seniorLottery.myaward;
            this.aNY = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.aNY.add(fVar);
            }
            this.aNZ = seniorLottery.act_desc;
            this.aOa = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aOa.add(afVar);
            }
        }
    }
}
