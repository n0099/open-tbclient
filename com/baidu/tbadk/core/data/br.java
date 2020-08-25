package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes2.dex */
public class br {
    private ap eam;
    private List<g> ean;
    private String eao;
    private List<h> eap;
    private String eaq;
    private List<ao> ear;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eam = new ap();
            this.eam.a(seniorLottery.theme);
            this.ean = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.ean.add(gVar);
            }
            this.eao = seniorLottery.myaward;
            this.eap = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.eap.add(hVar);
            }
            this.eaq = seniorLottery.act_desc;
            this.ear = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ao aoVar = new ao();
                aoVar.a(seniorLottery.act_regular.get(i3));
                this.ear.add(aoVar);
            }
        }
    }
}
