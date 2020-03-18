package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes cJr;
    public boolean isNewUser = false;
    public String cJs = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> cJt = new ArrayList<>();
    private final ArrayList<FloatStrategy> cJu = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> ayp() {
        return this.cJt;
    }

    public ArrayList<FloatStrategy> ayq() {
        return this.cJu;
    }

    public void a(DataRes dataRes) {
        this.cJr = dataRes;
        this.cJt.clear();
        this.cJu.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.cJs = dataRes.active_url;
            this.cJu.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.cJr.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aFE().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.ayd().q(bVar);
                    } else if (bVar.axf()) {
                        this.cJt.add(bVar);
                    }
                }
            }
        }
    }
}
