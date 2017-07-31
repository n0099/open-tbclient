package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private am YI;
    private List<f> YJ;
    private String YK;
    private List<g> YL;
    private String YM;
    private List<al> YN;

    public am qU() {
        return this.YI;
    }

    public List<f> qV() {
        return this.YJ;
    }

    public String qW() {
        return this.YK;
    }

    public List<g> qX() {
        return this.YL;
    }

    public String qY() {
        return this.YM;
    }

    public List<al> qZ() {
        return this.YN;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.YI = new am();
            this.YI.a(seniorLottery.theme);
            this.YJ = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.YJ.add(fVar);
            }
            this.YK = seniorLottery.myaward;
            this.YL = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.YL.add(gVar);
            }
            this.YM = seniorLottery.act_desc;
            this.YN = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                al alVar = new al();
                alVar.a(seniorLottery.act_regular.get(i3));
                this.YN.add(alVar);
            }
        }
    }
}
