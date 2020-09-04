package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private a aXV;
    private int aYd;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void eq(int i) {
        this.aYd = i;
    }

    public void a(a aVar) {
        this.aXV = aVar;
    }

    public a Ik() {
        return this.aXV;
    }

    public void setParams() {
        addParam("scene_from", p.EZ());
        addParam("guard_club_id", this.aYd);
        addParam("client_type", 2);
    }
}
