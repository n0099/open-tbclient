package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import com.baidu.tbadk.core.data.NewUserRedPackageData;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes dws;
    public NewUserRedPackageData dww;
    public boolean isNewUser = false;
    public String dwt = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> dwu = new ArrayList<>();
    private final ArrayList<FloatStrategy> dwv = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aLT() {
        return this.dwu;
    }

    public ArrayList<FloatStrategy> aLU() {
        return this.dwv;
    }

    public void a(DataRes dataRes) {
        this.dws = dataRes;
        this.dwu.clear();
        this.dwv.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.dwt = dataRes.active_url;
            this.dwv.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.dws.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aTU().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aLH().q(bVar);
                    } else if (bVar.aKL()) {
                        this.dwu.add(bVar);
                    }
                }
            }
            this.dww = new NewUserRedPackageData();
            this.dww.parseProto(dataRes);
        }
    }
}
