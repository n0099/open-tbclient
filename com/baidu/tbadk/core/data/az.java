package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class az {
    private ag SS;
    private List<d> ST;
    private String SU;
    private List<e> SV;
    private String SW;
    private List<af> SX;

    public ag qT() {
        return this.SS;
    }

    public List<d> qU() {
        return this.ST;
    }

    public String qV() {
        return this.SU;
    }

    public List<e> qW() {
        return this.SV;
    }

    public String qX() {
        return this.SW;
    }

    public List<af> qY() {
        return this.SX;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.SS = new ag();
            this.SS.a(seniorLottery.theme);
            this.ST = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                d dVar = new d();
                dVar.a(seniorLottery.award_info.get(i));
                this.ST.add(dVar);
            }
            this.SU = seniorLottery.myaward;
            this.SV = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                e eVar = new e();
                eVar.a(seniorLottery.luck_users.get(i2));
                this.SV.add(eVar);
            }
            this.SW = seniorLottery.act_desc;
            this.SX = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.SX.add(afVar);
            }
        }
    }
}
