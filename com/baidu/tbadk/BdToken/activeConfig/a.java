package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes dHt;
    public NewUserRedPackageData dHx;
    public ActiveCenterData dHy;
    public boolean isNewUser = false;
    public String dHu = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> dHv = new ArrayList<>();
    private final ArrayList<FloatStrategy> dHw = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aRl() {
        return this.dHv;
    }

    public ArrayList<FloatStrategy> aRm() {
        return this.dHw;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null && dataRes.active_center != null && dataRes.active_center.is_first_up.intValue() != 1) {
            this.dHy = new ActiveCenterData();
            this.dHy.parseProto(dataRes);
            return;
        }
        this.dHt = dataRes;
        this.dHv.clear();
        this.dHw.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dHu = dataRes.active_url;
            this.dHw.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.dHt.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aZM().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aQG().q(bVar);
                    } else if (bVar.aPF()) {
                        this.dHv.add(bVar);
                    }
                }
            }
            this.dHx = new NewUserRedPackageData();
            this.dHx.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.dHy = new ActiveCenterData();
                this.dHy.parseProto(dataRes);
            }
        }
    }
}
