package com.baidu.tbadk.BdToken.activeConfig;

import com.baidu.tbadk.BdToken.p;
import java.util.ArrayList;
import tbclient.ActiveConfig.DataRes;
import tbclient.FloatStrategy;
import tbclient.MissionInfo;
/* loaded from: classes.dex */
public class a {
    private DataRes diA;
    public boolean isNewUser = false;
    public String diB = "";
    private final ArrayList<com.baidu.tbadk.BdToken.b> diC = new ArrayList<>();
    private final ArrayList<FloatStrategy> diD = new ArrayList<>();

    public ArrayList<com.baidu.tbadk.BdToken.b> aGy() {
        return this.diC;
    }

    public ArrayList<FloatStrategy> aGz() {
        return this.diD;
    }

    public void a(DataRes dataRes) {
        this.diA = dataRes;
        this.diC.clear();
        this.diD.clear();
        if (dataRes != null) {
            this.isNewUser = dataRes.is_new_user.intValue() == 1;
            this.diB = dataRes.active_url;
            this.diD.addAll(dataRes.float_list);
            for (MissionInfo missionInfo : this.diA.mission_list) {
                if (missionInfo != null) {
                    com.baidu.tbadk.BdToken.b bVar = new com.baidu.tbadk.BdToken.b(missionInfo);
                    if (missionInfo.tasktype.intValue() == 5) {
                        com.baidu.tbadk.core.f.a.aNQ().a(missionInfo);
                    } else if (missionInfo.tasktype.intValue() == 9) {
                        p.aGm().q(bVar);
                    } else if (bVar.aFq()) {
                        this.diC.add(bVar);
                    }
                }
            }
        }
    }
}
