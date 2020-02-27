package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes cJe;
    public boolean isNewUser = false;
    public String cJf = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> cJg = new ArrayList<>();
    private final ArrayList<FloatStrategy> cJh = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> ayk() {
        return this.cJg;
    }

    public ArrayList<FloatStrategy> ayl() {
        return this.cJh;
    }

    public void a(DataRes dataRes) {
        this.cJe = dataRes;
        this.cJg.clear();
        this.cJh.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.cJf = dataRes.active_url;
            this.cJh.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.cJe.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aFy().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.axY().q(bVar);
                    } else if (bVar.axa()) {
                        this.cJg.add(bVar);
                    }
                }
            }
        }
    }
}
