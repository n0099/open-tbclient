package com.baidu.tbadk.BdToken.activeConfig;

import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes bzg;
    public boolean isNewUser = false;
    public String bzh = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> bzi = new ArrayList<>();
    private final ArrayList<FloatStrategy> bzj = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> YV() {
        return this.bzi;
    }

    public ArrayList<FloatStrategy> YW() {
        return this.bzj;
    }

    public void a(DataRes dataRes) {
        this.bzg = dataRes;
        this.bzi.clear();
        this.bzj.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.bzh = dataRes.active_url;
            this.bzj.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.bzg.mission_list) {
                if (missionInfo != null) {
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.agJ().a(missionInfo);
                    } else {
                        com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                        if (bVar.XN()) {
                            this.bzi.add(bVar);
                        }
                    }
                }
            }
        }
    }
}
