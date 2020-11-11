package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes ete;
    public NewUserRedPackageData eti;
    public ActiveCenterData etj;
    public boolean isNewUser = false;
    public String etf = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> etg = new ArrayList<>();
    private final ArrayList<FloatStrategy> eth = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> bhp() {
        return this.etg;
    }

    public ArrayList<FloatStrategy> bhq() {
        return this.eth;
    }

    public void a(DataRes dataRes) {
        this.ete = dataRes;
        this.etg.clear();
        this.eth.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.etf = dataRes.active_url;
            this.eth.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.ete.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.bqd().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.bgK().q(bVar);
                    } else if (bVar.bfI()) {
                        this.etg.add(bVar);
                    }
                }
            }
            this.eti = new NewUserRedPackageData();
            this.eti.parseProto(dataRes);
            if (dataRes.active_center != null) {
                this.etj = new ActiveCenterData();
                this.etj.parseProto(dataRes);
            }
        }
    }
}
