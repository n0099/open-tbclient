package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class bb {
    private ak XU;
    private List<f> XV;
    private String XW;
    private List<g> XX;
    private String XY;
    private List<aj> XZ;

    public ak qK() {
        return this.XU;
    }

    public List<f> qL() {
        return this.XV;
    }

    public String qM() {
        return this.XW;
    }

    public List<g> qN() {
        return this.XX;
    }

    public String qO() {
        return this.XY;
    }

    public List<aj> qP() {
        return this.XZ;
    }

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.XU = new ak();
            this.XU.a(seniorLottery.theme);
            this.XV = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.XV.add(fVar);
            }
            this.XW = seniorLottery.myaward;
            this.XX = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.XX.add(gVar);
            }
            this.XY = seniorLottery.act_desc;
            this.XZ = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                aj ajVar = new aj();
                ajVar.a(seniorLottery.act_regular.get(i3));
                this.XZ.add(ajVar);
            }
        }
    }
}
