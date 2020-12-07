package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bt {
    private ar eIl;
    private List<h> eIm;
    private String eIn;
    private List<i> eIo;
    private String eIp;
    private List<aq> eIq;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eIl = new ar();
            this.eIl.a(seniorLottery.theme);
            this.eIm = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.eIm.add(hVar);
            }
            this.eIn = seniorLottery.myaward;
            this.eIo = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.eIo.add(iVar);
            }
            this.eIp = seniorLottery.act_desc;
            this.eIq = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aq aqVar = new aq();
                aqVar.a(seniorLottery.act_regular.get(i3));
                this.eIq.add(aqVar);
            }
        }
    }
}
