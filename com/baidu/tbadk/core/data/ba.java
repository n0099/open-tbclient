package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ba {
    private ak Sf;
    private List<f> Sg;
    private String Sh;
    private List<g> Si;
    private String Sj;
    private List<aj> Sk;

    public ak qN() {
        return this.Sf;
    }

    public List<f> qO() {
        return this.Sg;
    }

    public String qP() {
        return this.Sh;
    }

    public List<g> qQ() {
        return this.Si;
    }

    public String qR() {
        return this.Sj;
    }

    public List<aj> qS() {
        return this.Sk;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Sf = new ak();
            this.Sf.a(seniorLottery.theme);
            this.Sg = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.Sg.add(fVar);
            }
            this.Sh = seniorLottery.myaward;
            this.Si = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.Si.add(gVar);
            }
            this.Sj = seniorLottery.act_desc;
            this.Sk = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aj ajVar = new aj();
                ajVar.a(seniorLottery.act_regular.get(i3));
                this.Sk.add(ajVar);
            }
        }
    }
}
