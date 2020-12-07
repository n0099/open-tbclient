package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes eyB;
    public NewUserRedPackageData eyF;
    public ActiveCenterData eyG;
    public boolean isNewUser = false;
    public String eyC = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> eyD = new ArrayList<>();
    private final ArrayList<FloatStrategy> eyE = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bjN() {
        return this.eyD;
    }

    public ArrayList<FloatStrategy> bjO() {
        return this.eyE;
    }

    public void a(DataRes dataRes) {
        this.eyB = dataRes;
        this.eyD.clear();
        this.eyE.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.eyC = dataRes.active_url;
            this.eyE.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.eyB.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bsK().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bji().q(bVar);
                    } else if (bVar.big()) {
                        this.eyD.add(bVar);
                    }
                }
            }
            this.eyF = new NewUserRedPackageData();
            this.eyF.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eyG = new ActiveCenterData();
                this.eyG.parseProto(dataRes);
            }
        }
    }
}
