package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes cJf;
    public boolean isNewUser = false;
    public String cJg = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> cJh = new ArrayList<>();
    private final ArrayList<FloatStrategy> cJi = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aym() {
        return this.cJh;
    }

    public ArrayList<FloatStrategy> ayn() {
        return this.cJi;
    }

    public void a(DataRes dataRes) {
        this.cJf = dataRes;
        this.cJh.clear();
        this.cJi.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.cJg = dataRes.active_url;
            this.cJi.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.cJf.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aFA().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aya().q(bVar);
                    } else if (bVar.axc()) {
                        this.cJh.add(bVar);
                    }
                }
            }
        }
    }
}
