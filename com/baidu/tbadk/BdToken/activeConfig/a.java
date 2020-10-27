package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes enj;
    public NewUserRedPackageData enn;
    public ActiveCenterData eno;
    public boolean isNewUser = false;
    public String enk = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> enl = new ArrayList<>();
    private final ArrayList<FloatStrategy> enm = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> beP() {
        return this.enl;
    }

    public ArrayList<FloatStrategy> beQ() {
        return this.enm;
    }

    public void a(DataRes dataRes) {
        this.enj = dataRes;
        this.enl.clear();
        this.enm.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.enk = dataRes.active_url;
            this.enm.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.enj.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bnD().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bek().q(bVar);
                    } else if (bVar.bdi()) {
                        this.enl.add(bVar);
                    }
                }
            }
            this.enn = new NewUserRedPackageData();
            this.enn.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eno = new ActiveCenterData();
                this.eno.parseProto(dataRes);
            }
        }
    }
}
