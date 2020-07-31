package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bq {
    private ao dQS;
    private List<g> dQT;
    private String dQU;
    private List<h> dQV;
    private String dQW;
    private List<an> dQX;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.dQS = new ao();
            this.dQS.a(seniorLottery.theme);
            this.dQT = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.dQT.add(gVar);
            }
            this.dQU = seniorLottery.myaward;
            this.dQV = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.dQV.add(hVar);
            }
            this.dQW = seniorLottery.act_desc;
            this.dQX = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                an anVar = new an();
                anVar.a(seniorLottery.act_regular.get(i3));
                this.dQX.add(anVar);
            }
        }
    }
}
