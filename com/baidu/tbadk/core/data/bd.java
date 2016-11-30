package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bd {
    private ak Tu;
    private List<e> Tv;
    private String Tw;
    private List<f> Tx;
    private String Ty;
    private List<aj> Tz;

    public ak rg() {
        return this.Tu;
    }

    public List<e> rh() {
        return this.Tv;
    }

    public String ri() {
        return this.Tw;
    }

    public List<f> rj() {
        return this.Tx;
    }

    public String rk() {
        return this.Ty;
    }

    public List<aj> rl() {
        return this.Tz;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Tu = new ak();
            this.Tu.a(seniorLottery.theme);
            this.Tv = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.Tv.add(eVar);
            }
            this.Tw = seniorLottery.myaward;
            this.Tx = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.Tx.add(fVar);
            }
            this.Ty = seniorLottery.act_desc;
            this.Tz = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aj ajVar = new aj();
                ajVar.a(seniorLottery.act_regular.get(i3));
                this.Tz.add(ajVar);
            }
        }
    }
}
