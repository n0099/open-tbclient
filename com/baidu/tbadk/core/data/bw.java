package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bw {
    private at eRf;
    private List<i> eRg;
    private String eRh;
    private List<j> eRi;
    private String eRj;
    private List<as> eRk;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.eRf = new at();
            this.eRf.a(seniorLottery.theme);
            this.eRg = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                i iVar = new i();
                iVar.a(seniorLottery.award_info.get(i));
                this.eRg.add(iVar);
            }
            this.eRh = seniorLottery.myaward;
            this.eRi = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                j jVar = new j();
                jVar.a(seniorLottery.luck_users.get(i2));
                this.eRi.add(jVar);
            }
            this.eRj = seniorLottery.act_desc;
            this.eRk = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                as asVar = new as();
                asVar.a(seniorLottery.act_regular.get(i3));
                this.eRk.add(asVar);
            }
        }
    }
}
