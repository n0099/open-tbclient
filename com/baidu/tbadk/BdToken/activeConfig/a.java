package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    public NewUserRedPackageData erC;
    public ActiveCenterData erD;
    private DataRes ery;
    public boolean isNewUser = false;
    public String erz = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> erA = new ArrayList<>();
    private final ArrayList<FloatStrategy> erB = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bgI() {
        return this.erA;
    }

    public ArrayList<FloatStrategy> bgJ() {
        return this.erB;
    }

    public void a(DataRes dataRes) {
        this.ery = dataRes;
        this.erA.clear();
        this.erB.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.erz = dataRes.active_url;
            this.erB.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.ery.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bpq().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bgd().q(bVar);
                    } else if (bVar.bfb()) {
                        this.erA.add(bVar);
                    }
                }
            }
            this.erC = new NewUserRedPackageData();
            this.erC.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.erD = new ActiveCenterData();
                this.erD.parseProto(dataRes);
            }
        }
    }
}
