package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes cJg;
    public boolean isNewUser = false;
    public String cJh = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> cJi = new ArrayList<>();
    private final ArrayList<FloatStrategy> cJj = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aym() {
        return this.cJi;
    }

    public ArrayList<FloatStrategy> ayn() {
        return this.cJj;
    }

    public void a(DataRes dataRes) {
        this.cJg = dataRes;
        this.cJi.clear();
        this.cJj.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.cJh = dataRes.active_url;
            this.cJj.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.cJg.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aFA().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aya().q(bVar);
                    } else if (bVar.axc()) {
                        this.cJi.add(bVar);
                    }
                }
            }
        }
    }
}
