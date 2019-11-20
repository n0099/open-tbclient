package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bc {
    private ai cac;
    private List<h> cad;
    private String cae;
    private List<i> caf;
    private String cag;
    private List<ah> cah;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.cac = new ai();
            this.cac.a(seniorLottery.theme);
            this.cad = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                h hVar = new h();
                hVar.a(seniorLottery.award_info.get(i));
                this.cad.add(hVar);
            }
            this.cae = seniorLottery.myaward;
            this.caf = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                i iVar = new i();
                iVar.a(seniorLottery.luck_users.get(i2));
                this.caf.add(iVar);
            }
            this.cag = seniorLottery.act_desc;
            this.cah = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ah ahVar = new ah();
                ahVar.a(seniorLottery.act_regular.get(i3));
                this.cah.add(ahVar);
            }
        }
    }
}
