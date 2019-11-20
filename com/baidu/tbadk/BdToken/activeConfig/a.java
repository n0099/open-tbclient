package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes bSq;
    public boolean isNewUser = false;
    public String bSr = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> bSs = new ArrayList<>();
    private final ArrayList<FloatStrategy> bSt = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aeL() {
        return this.bSs;
    }

    public ArrayList<FloatStrategy> aeM() {
        return this.bSt;
    }

    public void a(DataRes dataRes) {
        this.bSq = dataRes;
        this.bSs.clear();
        this.bSt.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.bSr = dataRes.active_url;
            this.bSt.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.bSq.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.g.a.alM().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aez().q(bVar);
                    } else if (bVar.adA()) {
                        this.bSs.add(bVar);
                    }
                }
            }
        }
    }
}
