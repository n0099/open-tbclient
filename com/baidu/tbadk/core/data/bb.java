package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ak Ya;
    private List<f> Yb;
    private String Yc;
    private List<g> Yd;
    private String Ye;
    private List<aj> Yf;

    public ak qI() {
        return this.Ya;
    }

    public List<f> qJ() {
        return this.Yb;
    }

    public String qK() {
        return this.Yc;
    }

    public List<g> qL() {
        return this.Yd;
    }

    public String qM() {
        return this.Ye;
    }

    public List<aj> qN() {
        return this.Yf;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Ya = new ak();
            this.Ya.a(seniorLottery.theme);
            this.Yb = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.Yb.add(fVar);
            }
            this.Yc = seniorLottery.myaward;
            this.Yd = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.Yd.add(gVar);
            }
            this.Ye = seniorLottery.act_desc;
            this.Yf = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aj ajVar = new aj();
                ajVar.a(seniorLottery.act_regular.get(i3));
                this.Yf.add(ajVar);
            }
        }
    }
}
