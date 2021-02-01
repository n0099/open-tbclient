package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes eFl;
    public NewUserRedPackageData eFp;
    public ActiveCenterData eFq;
    public boolean isNewUser = false;
    public String eFm = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> eFn = new ArrayList<>();
    private final ArrayList<FloatStrategy> eFo = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> biw() {
        return this.eFn;
    }

    public ArrayList<FloatStrategy> bix() {
        return this.eFo;
    }

    public void a(DataRes dataRes) {
        this.eFl = dataRes;
        this.eFn.clear();
        this.eFo.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.eFm = dataRes.active_url;
            this.eFo.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.eFl.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.brM().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bhS().q(bVar);
                    } else if (bVar.bgQ()) {
                        this.eFn.add(bVar);
                    }
                }
            }
            this.eFp = new NewUserRedPackageData();
            this.eFp.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.eFq = new ActiveCenterData();
                this.eFq.parseProto(dataRes);
            }
        }
    }
}
