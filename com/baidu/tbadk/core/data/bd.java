package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private am XT;
    private List<f> XU;
    private String XV;
    private List<g> XW;
    private String XX;
    private List<al> XY;

    public am qQ() {
        return this.XT;
    }

    public List<f> qR() {
        return this.XU;
    }

    public String qS() {
        return this.XV;
    }

    public List<g> qT() {
        return this.XW;
    }

    public String qU() {
        return this.XX;
    }

    public List<al> qV() {
        return this.XY;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.XT = new am();
            this.XT.a(seniorLottery.theme);
            this.XU = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.XU.add(fVar);
            }
            this.XV = seniorLottery.myaward;
            this.XW = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.XW.add(gVar);
            }
            this.XX = seniorLottery.act_desc;
            this.XY = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                al alVar = new al();
                alVar.a(seniorLottery.act_regular.get(i3));
                this.XY.add(alVar);
            }
        }
    }
}
