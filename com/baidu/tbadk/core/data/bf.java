package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bf {
    private ai dEc;
    private List<g> dEd;
    private String dEe;
    private List<h> dEf;
    private String dEg;
    private List<ah> dEh;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.dEc = new ai();
            this.dEc.a(seniorLottery.theme);
            this.dEd = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.dEd.add(gVar);
            }
            this.dEe = seniorLottery.myaward;
            this.dEf = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.dEf.add(hVar);
            }
            this.dEg = seniorLottery.act_desc;
            this.dEh = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.dEh.add(ahVar);
            }
        }
    }
}
