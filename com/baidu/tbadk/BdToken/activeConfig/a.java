package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes cFa;
    public boolean isNewUser = false;
    public String cFb = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> cFc = new ArrayList<>();
    private final ArrayList<FloatStrategy> cFd = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> avX() {
        return this.cFc;
    }

    public ArrayList<FloatStrategy> avY() {
        return this.cFd;
    }

    public void a(DataRes dataRes) {
        this.cFa = dataRes;
        this.cFc.clear();
        this.cFd.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.cFb = dataRes.active_url;
            this.cFd.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.cFa.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aDo().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.avL().q(bVar);
                    } else if (bVar.auM()) {
                        this.cFc.add(bVar);
                    }
                }
            }
        }
    }
}
