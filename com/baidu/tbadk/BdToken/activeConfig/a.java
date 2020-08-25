package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes2.dex */
public class a {
    private DataRes dQA;
    public NewUserRedPackageData dQE;
    public ActiveCenterData dQF;
    public boolean isNewUser = false;
    public String dQB = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> dQC = new ArrayList<>();
    private final ArrayList<FloatStrategy> dQD = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aZB() {
        return this.dQC;
    }

    public ArrayList<FloatStrategy> aZC() {
        return this.dQD;
    }

    public void a(DataRes dataRes) {
        this.dQA = dataRes;
        this.dQC.clear();
        this.dQD.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dQB = dataRes.active_url;
            this.dQD.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.dQA.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bih().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aYW().q(bVar);
                    } else if (bVar.aXV()) {
                        this.dQC.add(bVar);
                    }
                }
            }
            this.dQE = new NewUserRedPackageData();
            this.dQE.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.dQF = new ActiveCenterData();
                this.dQF.parseProto(dataRes);
            }
        }
    }
}
