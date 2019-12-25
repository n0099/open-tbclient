package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class be {
    private aj cMt;
    private List<h> cMu;
    private String cMv;
    private List<i> cMw;
    private String cMx;
    private List<ai> cMy;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.cMt = new aj();
            this.cMt.a(seniorLottery.theme);
            this.cMu = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.cMu.add(hVar);
            }
            this.cMv = seniorLottery.myaward;
            this.cMw = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.cMw.add(iVar);
            }
            this.cMx = seniorLottery.act_desc;
            this.cMy = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ai aiVar = new ai();
                aiVar.a(seniorLottery.act_regular.get(i3));
                this.cMy.add(aiVar);
            }
        }
    }
}
