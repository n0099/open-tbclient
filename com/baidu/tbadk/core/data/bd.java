package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private am YL;
    private List<f> YM;
    private String YN;
    private List<g> YO;
    private String YP;
    private List<al> YQ;

    public am qV() {
        return this.YL;
    }

    public List<f> qW() {
        return this.YM;
    }

    public String qX() {
        return this.YN;
    }

    public List<g> qY() {
        return this.YO;
    }

    public String qZ() {
        return this.YP;
    }

    public List<al> ra() {
        return this.YQ;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.YL = new am();
            this.YL.a(seniorLottery.theme);
            this.YM = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.YM.add(fVar);
            }
            this.YN = seniorLottery.myaward;
            this.YO = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.YO.add(gVar);
            }
            this.YP = seniorLottery.act_desc;
            this.YQ = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                al alVar = new al();
                alVar.a(seniorLottery.act_regular.get(i3));
                this.YQ.add(alVar);
            }
        }
    }
}
