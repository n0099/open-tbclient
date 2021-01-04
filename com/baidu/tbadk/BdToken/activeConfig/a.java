package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes eHP;
    public NewUserRedPackageData eHT;
    public ActiveCenterData eHU;
    public boolean isNewUser = false;
    public String eHQ = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> eHR = new ArrayList<>();
    private final ArrayList<FloatStrategy> eHS = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bmc() {
        return this.eHR;
    }

    public ArrayList<FloatStrategy> bmd() {
        return this.eHS;
    }

    public void a(DataRes dataRes) {
        this.eHP = dataRes;
        this.eHR.clear();
        this.eHS.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.eHQ = dataRes.active_url;
            this.eHS.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.eHP.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bvm().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bly().q(bVar);
                    } else if (bVar.bkw()) {
                        this.eHR.add(bVar);
                    }
                }
            }
            this.eHT = new NewUserRedPackageData();
            this.eHT.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eHU = new ActiveCenterData();
                this.eHU.parseProto(dataRes);
            }
        }
    }
}
