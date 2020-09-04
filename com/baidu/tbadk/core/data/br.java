package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class br {
    private ap eaq;
    private List<g> ear;
    private String eas;
    private List<h> eat;
    private String eau;
    private List<ao> eav;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eaq = new ap();
            this.eaq.a(seniorLottery.theme);
            this.ear = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.ear.add(gVar);
            }
            this.eas = seniorLottery.myaward;
            this.eat = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.eat.add(hVar);
            }
            this.eau = seniorLottery.act_desc;
            this.eav = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ao aoVar = new ao();
                aoVar.a(seniorLottery.act_regular.get(i3));
                this.eav.add(aoVar);
            }
        }
    }
}
