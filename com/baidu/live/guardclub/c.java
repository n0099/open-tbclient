package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes7.dex */
public class c extends HttpMessage {
    private a aXT;
    private int aYb;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void eq(int i) {
        this.aYb = i;
    }

    public void a(a aVar) {
        this.aXT = aVar;
    }

    public a Ik() {
        return this.aXT;
    }

    public void setParams() {
        addParam("scene_from", p.EZ());
        addParam("guard_club_id", this.aYb);
        addParam("client_type", 2);
    }
}
