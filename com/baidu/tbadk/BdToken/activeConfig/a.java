package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes bAd;
    public boolean isNewUser = false;
    public String bAe = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> bAf = new ArrayList<>();
    private final ArrayList<FloatStrategy> bAg = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> ZU() {
        return this.bAf;
    }

    public ArrayList<FloatStrategy> ZV() {
        return this.bAg;
    }

    public void a(DataRes dataRes) {
        this.bAd = dataRes;
        this.bAf.clear();
        this.bAg.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.bAe = dataRes.active_url;
            this.bAg.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.bAd.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.g.a.ahL().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.ZI().q(bVar);
                    } else if (bVar.YJ()) {
                        this.bAf.add(bVar);
                    }
                }
            }
        }
    }
}
