package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class br {
    private ap exc;
    private List<g> exd;
    private String exe;
    private List<h> exf;
    private String exg;
    private List<ao> exh;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.exc = new ap();
            this.exc.a(seniorLottery.theme);
            this.exd = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                g gVar = new g();
                gVar.a(seniorLottery.award_info.get(i));
                this.exd.add(gVar);
            }
            this.exe = seniorLottery.myaward;
            this.exf = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                h hVar = new h();
                hVar.a(seniorLottery.luck_users.get(i2));
                this.exf.add(hVar);
            }
            this.exg = seniorLottery.act_desc;
            this.exh = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ao aoVar = new ao();
                aoVar.a(seniorLottery.act_regular.get(i3));
                this.exh.add(aoVar);
            }
        }
    }
}
