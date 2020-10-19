package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes eeM;
    public NewUserRedPackageData eeQ;
    public ActiveCenterData eeR;
    public boolean isNewUser = false;
    public String eeN = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> eeO = new ArrayList<>();
    private final ArrayList<FloatStrategy> eeP = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bcW() {
        return this.eeO;
    }

    public ArrayList<FloatStrategy> bcX() {
        return this.eeP;
    }

    public void a(DataRes dataRes) {
        this.eeM = dataRes;
        this.eeO.clear();
        this.eeP.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.eeN = dataRes.active_url;
            this.eeP.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.eeM.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.blK().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bcr().q(bVar);
                    } else if (bVar.bbp()) {
                        this.eeO.add(bVar);
                    }
                }
            }
            this.eeQ = new NewUserRedPackageData();
            this.eeQ.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eeR = new ActiveCenterData();
                this.eeR.parseProto(dataRes);
            }
        }
    }
}
