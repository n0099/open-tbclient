package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes bAB;
    public boolean isNewUser = false;
    public String bAC = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> bAD = new ArrayList<>();
    private final ArrayList<FloatStrategy> bAE = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> ZY() {
        return this.bAD;
    }

    public ArrayList<FloatStrategy> ZZ() {
        return this.bAE;
    }

    public void a(DataRes dataRes) {
        this.bAB = dataRes;
        this.bAD.clear();
        this.bAE.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.bAC = dataRes.active_url;
            this.bAE.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.bAB.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.g.a.ahR().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.ZM().q(bVar);
                    } else if (bVar.YN()) {
                        this.bAD.add(bVar);
                    }
                }
            }
        }
    }
}
