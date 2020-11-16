package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bs {
    private aq eBl;
    private List<h> eBm;
    private String eBn;
    private List<i> eBo;
    private String eBp;
    private List<ap> eBq;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eBl = new aq();
            this.eBl.a(seniorLottery.theme);
            this.eBm = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.eBm.add(hVar);
            }
            this.eBn = seniorLottery.myaward;
            this.eBo = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.eBo.add(iVar);
            }
            this.eBp = seniorLottery.act_desc;
            this.eBq = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ap apVar = new ap();
                apVar.a(seniorLottery.act_regular.get(i3));
                this.eBq.add(apVar);
            }
        }
    }
}
