package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.q;
/* loaded from: classes3.dex */
public class c extends HttpMessage {
    private a aIR;
    private int aIZ;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void cf(int i) {
        this.aIZ = i;
    }

    public void a(a aVar) {
        this.aIR = aVar;
    }

    public a Aq() {
        return this.aIR;
    }

    public void setParams() {
        addParam("scene_from", q.xg());
        addParam("guard_club_id", this.aIZ);
        addParam("client_type", 2);
    }
}
