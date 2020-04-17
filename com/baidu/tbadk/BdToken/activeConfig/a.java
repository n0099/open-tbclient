package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes diw;
    public boolean isNewUser = false;
    public String dix = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> diy = new ArrayList<>();
    private final ArrayList<FloatStrategy> diz = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aGA() {
        return this.diy;
    }

    public ArrayList<FloatStrategy> aGB() {
        return this.diz;
    }

    public void a(DataRes dataRes) {
        this.diw = dataRes;
        this.diy.clear();
        this.diz.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dix = dataRes.active_url;
            this.diz.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.diw.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aNS().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aGo().q(bVar);
                    } else if (bVar.aFq()) {
                        this.diy.add(bVar);
                    }
                }
            }
        }
    }
}
