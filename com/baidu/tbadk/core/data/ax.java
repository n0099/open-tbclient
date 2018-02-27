package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag aNU;
    private List<e> aNV;
    private String aNW;
    private List<f> aNX;
    private String aNY;
    private List<af> aNZ;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aNU = new ag();
            this.aNU.a(seniorLottery.theme);
            this.aNV = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.aNV.add(eVar);
            }
            this.aNW = seniorLottery.myaward;
            this.aNX = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.aNX.add(fVar);
            }
            this.aNY = seniorLottery.act_desc;
            this.aNZ = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aNZ.add(afVar);
            }
        }
    }
}
