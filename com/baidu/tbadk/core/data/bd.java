package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private am Xm;
    private List<f> Xn;
    private String Xo;
    private List<g> Xp;
    private String Xq;
    private List<al> Xr;

    public am qK() {
        return this.Xm;
    }

    public List<f> qL() {
        return this.Xn;
    }

    public String qM() {
        return this.Xo;
    }

    public List<g> qN() {
        return this.Xp;
    }

    public String qO() {
        return this.Xq;
    }

    public List<al> qP() {
        return this.Xr;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Xm = new am();
            this.Xm.a(seniorLottery.theme);
            this.Xn = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.Xn.add(fVar);
            }
            this.Xo = seniorLottery.myaward;
            this.Xp = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.Xp.add(gVar);
            }
            this.Xq = seniorLottery.act_desc;
            this.Xr = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                al alVar = new al();
                alVar.a(seniorLottery.act_regular.get(i3));
                this.Xr.add(alVar);
            }
        }
    }
}
