package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class al {
    private z UC;
    private List<e> UD;
    private String UE;
    private List<f> UF;
    private String UG;
    private List<y> UH;

    public z sN() {
        return this.UC;
    }

    public List<e> sO() {
        return this.UD;
    }

    public String sP() {
        return this.UE;
    }

    public List<f> sQ() {
        return this.UF;
    }

    public String sR() {
        return this.UG;
    }

    public List<y> sS() {
        return this.UH;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.UC = new z();
            this.UC.a(seniorLottery.theme);
            this.UD = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.UD.add(eVar);
            }
            this.UE = seniorLottery.myaward;
            this.UF = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.UF.add(fVar);
            }
            this.UG = seniorLottery.act_desc;
            this.UH = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                y yVar = new y();
                yVar.a(seniorLottery.act_regular.get(i3));
                this.UH.add(yVar);
            }
        }
    }
}
