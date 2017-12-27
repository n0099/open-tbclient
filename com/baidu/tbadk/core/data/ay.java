package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ay {
    private ah aMN;
    private List<e> aMO;
    private String aMP;
    private List<f> aMQ;
    private String aMR;
    private List<ag> aMS;

    public ah yo() {
        return this.aMN;
    }

    public List<e> yp() {
        return this.aMO;
    }

    public String yq() {
        return this.aMP;
    }

    public List<f> yr() {
        return this.aMQ;
    }

    public String ys() {
        return this.aMR;
    }

    public List<ag> yt() {
        return this.aMS;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.aMN = new ah();
            this.aMN.a(seniorLottery.theme);
            this.aMO = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                e eVar = new e();
                eVar.a(seniorLottery.award_info.get(i));
                this.aMO.add(eVar);
            }
            this.aMP = seniorLottery.myaward;
            this.aMQ = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                f fVar = new f();
                fVar.a(seniorLottery.luck_users.get(i2));
                this.aMQ.add(fVar);
            }
            this.aMR = seniorLottery.act_desc;
            this.aMS = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ag agVar = new ag();
                agVar.a(seniorLottery.act_regular.get(i3));
                this.aMS.add(agVar);
            }
        }
    }
}
