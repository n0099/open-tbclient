package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class az {
    private aj SV;
    private List<e> SW;
    private String SX;
    private List<f> SY;
    private String SZ;
    private List<ai> Ta;

    public aj qV() {
        return this.SV;
    }

    public List<e> qW() {
        return this.SW;
    }

    public String qX() {
        return this.SX;
    }

    public List<f> qY() {
        return this.SY;
    }

    public String qZ() {
        return this.SZ;
    }

    public List<ai> ra() {
        return this.Ta;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.SV = new aj();
            this.SV.a(seniorLottery.theme);
            this.SW = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.SW.add(eVar);
            }
            this.SX = seniorLottery.myaward;
            this.SY = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.SY.add(fVar);
            }
            this.SZ = seniorLottery.act_desc;
            this.Ta = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.Ta.add(aiVar);
            }
        }
    }
}
