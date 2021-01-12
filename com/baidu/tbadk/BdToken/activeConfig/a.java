package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes eDe;
    public NewUserRedPackageData eDi;
    public ActiveCenterData eDj;
    public boolean isNewUser = false;
    public String eDf = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> eDg = new ArrayList<>();
    private final ArrayList<FloatStrategy> eDh = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bij() {
        return this.eDg;
    }

    public ArrayList<FloatStrategy> bik() {
        return this.eDh;
    }

    public void a(DataRes dataRes) {
        this.eDe = dataRes;
        this.eDg.clear();
        this.eDh.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.eDf = dataRes.active_url;
            this.eDh.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.eDe.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.brt().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bhF().q(bVar);
                    } else if (bVar.bgD()) {
                        this.eDg.add(bVar);
                    }
                }
            }
            this.eDi = new NewUserRedPackageData();
            this.eDi.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eDj = new ActiveCenterData();
                this.eDj.parseProto(dataRes);
            }
        }
    }
}
