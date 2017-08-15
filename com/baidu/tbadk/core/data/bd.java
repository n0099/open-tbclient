package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private am YK;
    private List<f> YL;
    private String YM;
    private List<g> YN;
    private String YO;
    private List<al> YP;

    public am qU() {
        return this.YK;
    }

    public List<f> qV() {
        return this.YL;
    }

    public String qW() {
        return this.YM;
    }

    public List<g> qX() {
        return this.YN;
    }

    public String qY() {
        return this.YO;
    }

    public List<al> qZ() {
        return this.YP;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.YK = new am();
            this.YK.a(seniorLottery.theme);
            this.YL = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.YL.add(fVar);
            }
            this.YM = seniorLottery.myaward;
            this.YN = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.YN.add(gVar);
            }
            this.YO = seniorLottery.act_desc;
            this.YP = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                al alVar = new al();
                alVar.a(seniorLottery.act_regular.get(i3));
                this.YP.add(alVar);
            }
        }
    }
}
