package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes eGM;
    public NewUserRedPackageData eGQ;
    public ActiveCenterData eGR;
    public boolean isNewUser = false;
    public String eGN = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> eGO = new ArrayList<>();
    private final ArrayList<FloatStrategy> eGP = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> biy() {
        return this.eGO;
    }

    public ArrayList<FloatStrategy> biz() {
        return this.eGP;
    }

    public void a(DataRes dataRes) {
        this.eGM = dataRes;
        this.eGO.clear();
        this.eGP.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.eGN = dataRes.active_url;
            this.eGP.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.eGM.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.brN().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bhU().q(bVar);
                    } else if (bVar.bgS()) {
                        this.eGO.add(bVar);
                    }
                }
            }
            this.eGQ = new NewUserRedPackageData();
            this.eGQ.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eGR = new ActiveCenterData();
                this.eGR.parseProto(dataRes);
            }
        }
    }
}
