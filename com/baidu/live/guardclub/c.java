package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private a bdN;
    private int bdV;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void ez(int i) {
        this.bdV = i;
    }

    public void a(a aVar) {
        this.bdN = aVar;
    }

    public a JK() {
        return this.bdN;
    }

    public void setParams() {
        addParam("scene_from", p.Gv());
        addParam("guard_club_id", this.bdV);
        addParam("client_type", 2);
    }
}
