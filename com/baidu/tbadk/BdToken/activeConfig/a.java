package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes dSL;
    public NewUserRedPackageData dSP;
    public ActiveCenterData dSQ;
    public boolean isNewUser = false;
    public String dSM = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> dSN = new ArrayList<>();
    private final ArrayList<FloatStrategy> dSO = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bao() {
        return this.dSN;
    }

    public ArrayList<FloatStrategy> bap() {
        return this.dSO;
    }

    public void a(DataRes dataRes) {
        this.dSL = dataRes;
        this.dSN.clear();
        this.dSO.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dSM = dataRes.active_url;
            this.dSO.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.dSL.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bjb().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aZJ().q(bVar);
                    } else if (bVar.aYH()) {
                        this.dSN.add(bVar);
                    }
                }
            }
            this.dSP = new NewUserRedPackageData();
            this.dSP.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.dSQ = new ActiveCenterData();
                this.dSQ.parseProto(dataRes);
            }
        }
    }
}
