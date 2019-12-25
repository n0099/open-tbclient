package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes cEO;
    public boolean isNewUser = false;
    public String cEP = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> cEQ = new ArrayList<>();
    private final ArrayList<FloatStrategy> cER = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> avE() {
        return this.cEQ;
    }

    public ArrayList<FloatStrategy> avF() {
        return this.cER;
    }

    public void a(DataRes dataRes) {
        this.cEO = dataRes;
        this.cEQ.clear();
        this.cER.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.cEP = dataRes.active_url;
            this.cER.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.cEO.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aCV().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.avs().q(bVar);
                    } else if (bVar.aut()) {
                        this.cEQ.add(bVar);
                    }
                }
            }
        }
    }
}
