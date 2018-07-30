package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ax {
    private ag ahj;
    private List<f> ahk;
    private String ahl;
    private List<g> ahm;
    private String ahn;
    private List<af> aho;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.ahj = new ag();
            this.ahj.a(seniorLottery.theme);
            this.ahk = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.ahk.add(fVar);
            }
            this.ahl = seniorLottery.myaward;
            this.ahm = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.ahm.add(gVar);
            }
            this.ahn = seniorLottery.act_desc;
            this.aho = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                af afVar = new af();
                afVar.a(seniorLottery.act_regular.get(i3));
                this.aho.add(afVar);
            }
        }
    }
}
