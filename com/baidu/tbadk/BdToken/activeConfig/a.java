package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    public NewUserRedPackageData dBB;
    public ActiveCenterData dBC;
    private DataRes dBx;
    public boolean isNewUser = false;
    public String dBy = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> dBz = new ArrayList<>();
    private final ArrayList<FloatStrategy> dBA = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aNx() {
        return this.dBz;
    }

    public ArrayList<FloatStrategy> aNy() {
        return this.dBA;
    }

    public void a(DataRes dataRes) {
        if (dataRes != null && dataRes.active_center != null && dataRes.active_center.is_first_up.intValue() != 1) {
            this.dBC = new ActiveCenterData();
            this.dBC.parseProto(dataRes);
            return;
        }
        this.dBx = dataRes;
        this.dBz.clear();
        this.dBA.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dBy = dataRes.active_url;
            this.dBA.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.dBx.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aVM().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aMS().q(bVar);
                    } else if (bVar.aLR()) {
                        this.dBz.add(bVar);
                    }
                }
            }
            this.dBB = new NewUserRedPackageData();
            this.dBB.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.dBC = new ActiveCenterData();
                this.dBC.parseProto(dataRes);
            }
        }
    }
}
