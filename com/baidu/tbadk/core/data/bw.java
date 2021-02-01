package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bw {
    private at ePE;
    private List<i> ePF;
    private String ePG;
    private List<j> ePH;
    private String ePI;
    private List<as> ePJ;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.ePE = new at();
            this.ePE.a(seniorLottery.theme);
            this.ePF = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                i iVar = new i();
                iVar.a(seniorLottery.award_info.get(i));
                this.ePF.add(iVar);
            }
            this.ePG = seniorLottery.myaward;
            this.ePH = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                j jVar = new j();
                jVar.a(seniorLottery.luck_users.get(i2));
                this.ePH.add(jVar);
            }
            this.ePI = seniorLottery.act_desc;
            this.ePJ = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                as asVar = new as();
                asVar.a(seniorLottery.act_regular.get(i3));
                this.ePJ.add(asVar);
            }
        }
    }
}
