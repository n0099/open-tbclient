package com.baidu.live.guardclub;

import com.baidu.ala.AlaCmdConfigHttp;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.utils.p;
/* loaded from: classes4.dex */
public class c extends HttpMessage {
    private a aSF;
    private int aSN;

    public c() {
        super(AlaCmdConfigHttp.CMD_ALA_UPDATE_MARK_WEAR_STATUS);
    }

    public void cA(int i) {
        this.aSN = i;
    }

    public void a(a aVar) {
        this.aSF = aVar;
    }

    public a CH() {
        return this.aSF;
    }

    public void setParams() {
        addParam("scene_from", p.zw());
        addParam("guard_club_id", this.aSN);
        addParam("client_type", 2);
    }
}
