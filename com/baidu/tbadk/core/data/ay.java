package com.baidu.tbadk.core.data;

import java.util.ArrayList;
import java.util.List;
import tbclient.SeniorLottery;
/* loaded from: classes.dex */
public class ay {
    private ah Zu;
    private List<f> Zv;
    private String Zw;
    private List<g> Zx;
    private String Zy;
    private List<ag> Zz;

    public void a(SeniorLottery seniorLottery) {
        if (seniorLottery != null) {
            this.Zu = new ah();
            this.Zu.a(seniorLottery.theme);
            this.Zv = new ArrayList();
            int size = seniorLottery.award_info.size();
            for (int i = 0; i < size; i++) {
                f fVar = new f();
                fVar.a(seniorLottery.award_info.get(i));
                this.Zv.add(fVar);
            }
            this.Zw = seniorLottery.myaward;
            this.Zx = new ArrayList();
            int size2 = seniorLottery.luck_users.size();
            for (int i2 = 0; i2 < size2; i2++) {
                g gVar = new g();
                gVar.a(seniorLottery.luck_users.get(i2));
                this.Zx.add(gVar);
            }
            this.Zy = seniorLottery.act_desc;
            this.Zz = new ArrayList();
            int size3 = seniorLottery.act_regular.size();
            for (int i3 = 0; i3 < size3; i3++) {
                ag agVar = new ag();
                agVar.a(seniorLottery.act_regular.get(i3));
                this.Zz.add(agVar);
            }
        }
    }
}
