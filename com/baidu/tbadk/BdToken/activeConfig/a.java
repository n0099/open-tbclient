package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes dQE;
    public NewUserRedPackageData dQI;
    public ActiveCenterData dQJ;
    public boolean isNewUser = false;
    public String dQF = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> dQG = new ArrayList<>();
    private final ArrayList<FloatStrategy> dQH = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aZB() {
        return this.dQG;
    }

    public ArrayList<FloatStrategy> aZC() {
        return this.dQH;
    }

    public void a(DataRes dataRes) {
        this.dQE = dataRes;
        this.dQG.clear();
        this.dQH.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dQF = dataRes.active_url;
            this.dQH.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.dQE.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bih().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aYW().q(bVar);
                    } else if (bVar.aXV()) {
                        this.dQG.add(bVar);
                    }
                }
            }
            this.dQI = new NewUserRedPackageData();
            this.dQI.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.dQJ = new ActiveCenterData();
                this.dQJ.parseProto(dataRes);
            }
        }
    }
}
