package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes bTh;
    public boolean isNewUser = false;
    public String bTi = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> bTj = new ArrayList<>();
    private final ArrayList<FloatStrategy> bTk = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aeN() {
        return this.bTj;
    }

    public ArrayList<FloatStrategy> aeO() {
        return this.bTk;
    }

    public void a(DataRes dataRes) {
        this.bTh = dataRes;
        this.bTj.clear();
        this.bTk.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.bTi = dataRes.active_url;
            this.bTk.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.bTh.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.g.a.alO().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aeB().q(bVar);
                    } else if (bVar.adC()) {
                        this.bTj.add(bVar);
                    }
                }
            }
        }
    }
}
